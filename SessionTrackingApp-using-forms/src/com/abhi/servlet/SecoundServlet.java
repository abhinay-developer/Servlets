package com.abhi.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/secoundurl")
public class SecoundServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String INSERT_QUERY = "INSERT INTO PERSON_INFO(PNAME,FNAME,MS,INFO1,INFO2)VALUES(?,?,?,?,?)";

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = null;
		Connection con = null;
		PreparedStatement ps = null;
		pw = response.getWriter();
		response.setContentType("text/html");
		String pname = request.getParameter("hpname");
		String fname = request.getParameter("hfname");
		String ms = request.getParameter("hms");
		System.out.println(request.getParameter("hms"));
		String st1 = request.getParameter("st1");
		String st2 = request.getParameter("st2");

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "root");
			ps = con.prepareStatement(INSERT_QUERY);
			ps.setString(1, pname);
			ps.setString(2, fname);
			ps.setString(3, ms);
			ps.setString(4, st1);
			ps.setString(5, st2);
			int count = ps.executeUpdate();
			if (count == 0)
				pw.println("<h3>Person registration failed</h3");
			else
				pw.println("<h3>Person registration succeed</h3");
		} catch (Exception e) {
			e.printStackTrace();
		}
		pw.println("<html>");
		pw.println("<body>");
		pw.println("<b><br>Person Name::</b>" + pname);
		pw.println("<b><br>Father Name:</b>" + fname);
		pw.println("<b><br>st1::</b>" + st1);
		pw.println("<b><br>st2::</b>" + st2);
		pw.println("</body>");
		pw.println("</html>");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
