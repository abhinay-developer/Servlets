package com.abhi.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/firsturl")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = null;
		String pname = null, fname = null, gender = null;
		Cookie ck1 = null, ck2 = null, ck3 = null;
		pw = response.getWriter();
		response.setContentType("text/html");
		pname = request.getParameter("pname");
		fname = request.getParameter("fname");
		gender = request.getParameter("gender");
		ck1 = new Cookie("pname", pname);//(name,value)
		ck2 = new Cookie("fname", fname);
		ck3 = new Cookie("gender", gender);
		response.addCookie(ck1);
		response.addCookie(ck2);
		response.addCookie(ck3);

		pw.println("<!DOCTYPE html>");
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<link rel='stylesheet' href='css/bootstrap.min.css'>");
		pw.println("<script type='text/javascript' src='js/validation.js'></script>");
		pw.println("</head>");
		pw.println("<body>");
		pw.println("<form action='secoundurl'>");
		pw.println("<body>");
		pw.println("<div class='container'>");
		pw.println("<div class='container'>");
		pw.println("<h1 class='jumbotron'>Details<h1></div>");
		pw.println("<div class='container'>");
		pw.println("<label>Income</label><input type='text' name='income' class='form-control'></div>");
		pw.println("<div class='container'>");
		pw.println("<label>Tax</label><input type='text' name='tax' class='form-control'></div>");
		pw.println("<div class='mt-4 container'>");
		pw.println("<input type='submit' value='Submit' class='btn btn-primary'></div>");
		pw.println("</form>");
		pw.println("</body>");
		pw.println("</html>");

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
