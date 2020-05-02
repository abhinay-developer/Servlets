package com.abhi.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/firsturl")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = null;
		String pname = null, fname = null, gender = null;
		pw = response.getWriter();
		response.setContentType("text/html");

		pname = request.getParameter("pname");
		fname = request.getParameter("fname");
		gender = request.getParameter("gender");
		HttpSession session = request.getSession(true);
		session.setAttribute("pname", pname);
		session.setAttribute("fname", fname);
		session.setAttribute("gender", gender);
		pw.println("<!DOCTYPE html>");
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<link rel='stylesheet' href='css/bootstrap.min.css'>");
		pw.println("<script type='text/javascript' src='js/validation.js'></script>");
		pw.println("</head>");
		pw.println("<body>");
		pw.println("<form action='secoundurl' method='POST'>");
		pw.println("<div class='container'>");
		pw.println("<h1 class='jumbotron'>Fill Details</h1>");
		pw.println("<div class='container'>");
		pw.println("<label>Income</label>");
		pw.println("<input type='text' name='income' placeholder='enter income' class='form-control' ");
		pw.println("</div>");
		pw.println("<div class='container'>");
		pw.println("<label>Tax</label>");
		pw.println("<input type='text' name='tax' placeholder='enter tax' class='form-control' ");
		pw.println("</div>");
		pw.println("<div class='mt-2 container'>");
		pw.println("<input type='submit' value='submit' class='btn btn-primary' ");
		pw.println("</div>");
		pw.println("</div>");	
		pw.println("</form>");
		pw.println("</body>");
		pw.println("</html>");
		pw.println("The Session is"+session.getId());

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
