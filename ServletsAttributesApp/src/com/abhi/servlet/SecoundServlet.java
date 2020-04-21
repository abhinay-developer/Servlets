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

@WebServlet("/secoundurl")
public class SecoundServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = null;
		PrintWriter pw = null;
		HttpSession session=null;
        ServletContext sc=null;
		pw = response.getWriter();
		response.setContentType("text/html");
		session=request.getSession();
		sc=request.getServletContext();
	   // String age=(String)request.getAttribute("attr1");
	    
        pw.println("<br><b>(SecoundServlet)ses.setAttributevalue::"+session.getAttribute("attr1"));
		pw.println("<br><b>(SecoundServlet)req.getAttribute value::" + request.getAttribute("attr2") + "</b>");
		pw.println("<br><b>(SecoundServlet)sc.getAttribute value::" + sc.getAttribute("attr3") + "</b>");

		rd = request.getRequestDispatcher("/thirdurl");
		rd.forward(request, response);
		pw.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
