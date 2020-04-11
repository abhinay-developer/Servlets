package com.abhi.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
try
{
	PrintWriter pw=response.getWriter();
	response.setContentType("text/html");
	String username=request.getParameter("userName");
	pw.println("Welcome::"+username);
	Cookie ck=new Cookie("uname",username);//creating cookie object  
    response.addCookie(ck);//adding cookie in the response  
  
    //creating submit button  
    pw.println("<form action='SecoundServlet' method='post'>");  
    pw.println("<input type='submit' value='Go'>");  
    pw.println("</form>");  
          
    pw.close();
}
    catch(Exception e)
    {
    	e.printStackTrace();
    }
	}
}


