package com.abhi.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/voterurl")
public class VoterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("VoterServlet.doGet()");

		PrintWriter pw = null;
		pw = response.getWriter();
		response.setContentType("text/html");
		String name = null, tage = null;
		int age = 0;
		name = request.getParameter("name");
		System.out.println(request.getParameter("name"));
		tage = request.getParameter("age");
		age = Integer.parseInt(tage);
		// logic
		if (age >= 18) {
			pw.println("<h1 style=color:red>"+name+"You are Eligible for voting</h1>");
		} else {
			pw.println("<h1 style=color:red>"+name+"You are Not Eligible for voting</h1>");
		}
  pw.println("<h1 style='color:red';text:align:center><a href='index.html'>Home<a></h1>");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("VoterServlet.doPost()");
		doGet(request, response);
	}

}
