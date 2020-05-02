package com.abhi.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/firsturl")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = null;
		pw = response.getWriter();
		response.setContentType("text/html");
		String pname = request.getParameter("pname");
		String fname = request.getParameter("fname");
		String ms = request.getParameter("ms");
		if (ms.contains("married")) {
			pw.println("<!DOCTYPE html>");
			pw.println("<html>");
			pw.println("<head>");
			pw.println("<meta charset=\"ISO-8859-1\">");
			pw.println("<head>");
			pw.println("<title>index</title>");
			pw.println("<link rel=\"stylesheet\" href=\"css/bootstrap.css\">");
			pw.println("<script src=js/jquery.js></script>");
			pw.println("<script src=js/jquery.js></script>");
			pw.println("</head>");
			pw.println("<body>");
			pw.println("<form action='secoundurl' method='post'>");
			pw.println("<div class='container'>");
			pw.println("<h1 class='jumbotron text-center'>Next steps to continue (section married)</h1>");
			pw.println("<label>Spouse name</label>");
			pw.println("<input type='text' name='st1' class='form-control'>");
			pw.println("</div>");
			pw.println("<div class='container'");
			pw.println("<label>No.of Kids</label>");
			pw.println("<input type='text' name='st2' class='form-control'>");
			pw.println("</div>");
			pw.println("<input type='hidden' name='hpname' value=" + pname + ">");
			pw.println("<input type='hidden' name='hfname' value=" + fname + ">");
			pw.println("<input type='hidden' name='hms' value=" + ms + ">");
			pw.println("<div class='mt-4 container'>");
			pw.println("<button type='submit' class='btn btn-primary'>submit</button>");
			pw.println("</div>");
			pw.println("</body>");
			pw.println("</html>");
		} else {
			pw.println("<!DOCTYPE html>");
			pw.println("<html>");
			pw.println("<head>");
			pw.println("<meta charset=\"ISO-8859-1\">");
			pw.println("<head>");
			pw.println("<title>index</title>");
			pw.println("<link rel=\"stylesheet\" href=\"css/bootstrap.css\">");
			pw.println("<script src=js/jquery.js></script>");
			pw.println("<script src=js/jquery.js></script>");
			pw.println("</head>");
			pw.println("<body>");
			pw.println("<form action='secoundurl'method='post'>");
			pw.println("<div class='container'>");
			pw.println("<h1 class='jumbotron text-center'>Next steps to continue (section single)</h1>");
			pw.println("<div class='container'");
			pw.println("<label>Why to marry</label>");
			pw.println("<input type='text' name='st1' class='form-control'>");
			pw.println("</div>");
			pw.println("<div class='container'");
			pw.println("<label>Whento  marry</label>");
			pw.println("<input type='text' name='st2' class='form-control'>");
			pw.println("</div>");

			pw.println("<input type='hidden' name='hpname' value=" + pname + ">");
			pw.println("<input type='hidden' name='hfname' value=" + fname + ">");
			pw.println("<input type='hidden' name='hms' value=" + ms + ">");
			pw.println("<div class='mt-4 container'>");
			pw.println("<button type='submit' class='btn btn-primary'>submit</button>");
			pw.println("</div>");
			pw.println("</body>");
			pw.println("</html>");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
