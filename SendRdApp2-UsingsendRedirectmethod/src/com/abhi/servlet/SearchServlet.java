package com.abhi.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/searchurl")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = null;
		pw = response.getWriter();
		String ss = null;
		String engine = null;
		String url = null;
		ss = request.getParameter("ss");
		engine = request.getParameter("engine");
		response.setContentType("text/html");
		// prepare url based on the selected search engine

		if (engine.equalsIgnoreCase("google"))
			url = "https://www.google.com/search?q=" + ss;
		else if (engine.equalsIgnoreCase("bing"))
			url = "https://www.bing.com/search?q=" + ss;
		else if (engine.equalsIgnoreCase("yahoo"))
			url = "https://in.search.yahoo.com/search?p=" + ss;

		// perform sendRedirection
		System.out.println("before res.sendRedirect(-) method");
		pw.println("<b> before  ....</b>");
		response.sendRedirect(url);
		// RequestDispatcher rd=req.getRequestDispatcher("/xyz.html");
		// rd.include(req,res);
		System.out.println("after res.sendRedirect(-) method");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
