package com.abhi.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/loginurl")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String LOGIN_QUERY = "SELECT COUNT(*) FROM ADMIN WHERE USERNAME=? AND PASSWORD=? ";

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("LoginServlet.doGet()");
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		Connection con = null;
		ResultSet rs = null;
		int count = 0;
		PreparedStatement ps = null;

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "root");
			// query = "SELECT COUNT(*) FROM USERREGISTRATION WHERE USERNAME=? AND
			// PASSWORD=?"
			if (con != null)
				ps = con.prepareStatement(LOGIN_QUERY);
			if (ps != null) {
				ps.setString(1, username);
				ps.setString(2, password);

			}
			if (ps != null)
				rs = ps.executeQuery();
			if (rs != null) {
				if (rs.next()) {
					count = rs.getInt(1);
				} // if
			} // if
			if (count == 0) {
				out.println("<h1 style='color:red';text-align:'center'>Login failed<h1>");
			} else {
				out.println("<h1 style='color:green';text-align:'center'>Login success</h1>");

			}

		} // try
		catch (SQLException se) {
			se.printStackTrace();
		} catch (ClassNotFoundException cnf) {
			cnf.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
			try {
				if (ps != null)
					ps.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
			try {
				if (rs != null)
					rs.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}

		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
