package com.abhi.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/thirdurl")
public class ThirdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter pw=null;
		HttpSession session=null;
		RequestDispatcher rd = null;
		ServletContext sc=null;
		response.setContentType("text/html");
		pw=response.getWriter();
		session=request.getSession();
		sc=request.getServletContext();
		System.out.println(request.getAttribute("attr1"));
		pw.println("<b>(ThirdServlet)"+request.getAttribute("attr1")+"</b>");
		pw.println("<b>(ThirdServlet)"+session.getAttribute("attr2")+"</b>");
		pw.println("<b>(ThirdServlet)"+sc.getAttribute("attr3")+"</b>");
		rd = request.getRequestDispatcher("/fourthurl");
		rd.forward(request, response);
		pw.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
