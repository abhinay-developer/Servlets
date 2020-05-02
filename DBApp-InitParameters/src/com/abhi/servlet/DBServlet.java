package com.abhi.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DBServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String SELECT_QUERY = "SELECT ENO,ENAME,EDESG,ESAL FROM EMP WHERE ENO=?";
	Connection con = null;
	PreparedStatement ps = null;

	public void init() {
		try {
			ServletConfig sc=getServletConfig();
			String s1=sc.getInitParameter("driver");
			String s2=sc.getInitParameter("dburl");
			String s3=sc.getInitParameter("dbuser");
			String s4=sc.getInitParameter("dbpwd");
			Class.forName(s1);
			con = DriverManager.getConnection(s2,s3,s4);
			ps = con.prepareStatement(SELECT_QUERY);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ResultSet rs = null;
		PrintWriter pw = null;
		pw = response.getWriter();
		response.setContentType("text/html");
		String eno = request.getParameter("eno");
		try {
			ps.setString(1, eno);
			rs = ps.executeQuery();
			if (rs.next()) {
				pw.println("<h1 style='color:red'>Employee Details </h1>");
				pw.println("<br><b>The Employee No::</b> " + rs.getString(1));
				pw.println("<br><b>The Employee Name:: </b>" + rs.getString(2));
				pw.println("<br><b>The Employee Desigination:: </b>" + rs.getString(3));
				pw.println("<br><b>The Employee Salary::</b> " + rs.getFloat(4));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
