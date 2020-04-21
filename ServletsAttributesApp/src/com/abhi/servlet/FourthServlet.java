package com.abhi.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/fourthurl")
public class FourthServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = null;
		HttpSession session = null;

		ServletContext sc = null;
		pw = response.getWriter();
		session = request.getSession();
		sc = request.getServletContext();
		response.setContentType("text/html");
		pw.println("<br><b>(Fourthservlet)request.getattribute value::" + request.getAttribute("attr1") + "</b>");
		pw.println("<br><b>(Forthservlet)session.getattribute value::" + session.getAttribute("attr2") + "</b>");
		pw.println("<br><b>(Forthservlet)sc.getattribute value::" + sc.getAttribute("attr3") + "</b>");
		pw.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
