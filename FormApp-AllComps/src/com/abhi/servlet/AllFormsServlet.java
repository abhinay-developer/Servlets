package com.abhi.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/formurl")
public class AllFormsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = null;
		String gender = null;
		String address = null;
		String ms = null;
		String qualification = null;
		// String course = null;
		// String hb = null;
		int age = 0;
		PrintWriter pw = null;
		pw = response.getWriter();
		response.setContentType("text/html");
		username = request.getParameter("username");
		age = Integer.parseInt(request.getParameter("age"));
		ms = request.getParameter("ms");
		gender = request.getParameter("gender");
		address = request.getParameter("address");
		qualification = request.getParameter("qualification");
		String course[] = request.getParameterValues("course");
		String hb[] = request.getParameterValues("hb");
		pw.println("<br><h1>Student Info</h1>");
		if (gender.equalsIgnoreCase("Male")) {
			if (age <= 5)

				pw.println(username + "You are baby boy");
			else if (age <= 12)
				pw.println(username + "You are Small boy");
			else if (age <= 35)
				pw.println(username + "You are Young man");
			else if (age <= 50)
				pw.println(username + "You are middle aged man");
			else
				pw.println(username + "You are Budda ");
		} else if (gender.equalsIgnoreCase("Female")) {
			if (age <= 5)

				pw.println(username + "You are baby girl");
			else if (age <= 12)
				pw.println(username + "You are Small girl");
			else if (age <= 35)
				pw.println(username + "You are Young woman");
			else if (age <= 50)
				pw.println(username + "You are middle aged  woman");
			else
				pw.println(username + "You are old man ");
		}

		pw.println("<br>Name:" + username);
		pw.println("<br>Age:" + age);
		pw.println("<br>Material Status:" + ms);
		pw.println("<br>Address:" + address);
		pw.println("<br>Qualification:" + qualification);
		pw.println("<br>Course:" + Arrays.toString(course));
		pw.println("<br>Hobbies:" + Arrays.toString(hb));
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
