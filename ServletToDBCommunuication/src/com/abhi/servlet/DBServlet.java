package com.abhi.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/dburl")
public class DBServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String GET_DETAILS = "SELECT ID,NAME,ADDR FROM STUDENTS WHERE NAME=?";
	Connection con = null;
	PreparedStatement ps = null;

	public void init() {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "root");
			ps = con.prepareStatement(GET_DETAILS);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String name = null;
		name = request.getParameter("name");
		ResultSet rs = null;
		PrintWriter pw = null;
		pw = response.getWriter();
		response.setContentType("text/html");
		try {
			ps.setString(1, name);
			rs = ps.executeQuery();
			if (rs.next()) {
				pw.println("<html>");
				pw.println("<body>");
				pw.println("<div align='center'>");
				pw.println("<h1>Students Info</h1>");
				pw.println("<h3>Id::" + rs.getInt(1) + "</h3>");
				pw.println("<h3>Name::" + rs.getString(2) + "</h3>");
				pw.println("<h3>Address::" + rs.getString(3) + "</h3>");
				pw.println("</div>");
				pw.println("</body>");
				pw.println("</html>");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
