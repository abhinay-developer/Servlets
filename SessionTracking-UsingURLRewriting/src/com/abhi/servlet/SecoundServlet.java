package com.abhi.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

@WebServlet("/secoundurl")
public class SecoundServlet extends HttpServlet {
	@Resource(name = "DsJndi")
	private DataSource ds;
	private static final long serialVersionUID = 1L;
	private static final String INSERT_QUERY = "INSERT INTO COOKIE_PERSON_INFO1(PNAME,FNAME,GENDER,INCOME,TAX)VALUES(?,?,?,?,?)";

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection con = null;
		PreparedStatement ps = null;
		PrintWriter pw = null;
		String pname = null, fname = null, gender = null;
		float income = 0.0f;
		float tax = 0.0f;
		int count = 0;
		pw = response.getWriter();
		response.setContentType("text/html");
		income = Float.parseFloat(request.getParameter("income"));
		tax = Float.parseFloat(request.getParameter("tax"));
	    //get req1 data
		HttpSession session=request.getSession(false);
	    pname=(String)session.getAttribute("pname");
	    fname=(String)session.getAttribute("fname");
	    gender=(String)session.getAttribute("gender");
		try {
			con = ds.getConnection();
			ps = con.prepareStatement(INSERT_QUERY);
			ps.setString(1, pname);
			ps.setString(2, fname);
			ps.setString(3, gender);
			ps.setFloat(4, income);
			ps.setFloat(5, tax);
			count = ps.executeUpdate();
			if (count == 0)
				pw.println("<b>Person Registration Failed</b>");
			else
				pw.println("<b>Registration Successful</b>");

			pw.println("<br><b>Person Name</b>" + pname);
			pw.println("<br><b>Father Name</b>" + fname);
			pw.println("<br><b>Gender</b>" + gender);
			pw.println("<br><b>Income</b>" + income);
			pw.println("<br><b>Tax</b>" + tax);
			pw.println("<br>The Session is"+session.getId());
		}

		catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
