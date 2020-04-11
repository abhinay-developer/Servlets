package com.abhi.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DBServlet extends HttpServlet {
	Connection con;
	PreparedStatement ps;

	public void init() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "root");
			ps = con.prepareStatement("SELECT EMPNO,ENAME,EDESG,ESAL FROM EMP WHERE EMPNO=?");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			PrintWriter pw = null;
			response.setContentType("text/html");
			pw = response.getWriter();
			int no = Integer.parseInt(request.getParameter("eno"));
			ps.setInt(1, no);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				pw.println("<br>EmployeeNo::" + rs.getInt(1));
				pw.println("<br>EmployeeName::" + rs.getString(2));
				pw.println("<br>Employee Ddesg::" + rs.getString(3));
				pw.println("<br>EmployeeSalary::" + rs.getString(4));
			} else {
				pw.println("<br> No Employee Id");
			}
		} // try
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	public void destroy() {
		try {
			if (ps != null)
				ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (con != null)
				con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
