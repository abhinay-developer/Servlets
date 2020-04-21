package com.abhi.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
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
    RequestDispatcher rd=null;
    HttpSession session=null;
    
    ServletContext sc=null;
    session=request.getSession();
    sc=request.getServletContext();
		request.setAttribute("attr1","val1");
		session.setAttribute("attr2", "val2");
		sc.setAttribute("attr3","val3");
		rd=request.getRequestDispatcher("/secoundurl");
		rd.forward(request, response);
	
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
