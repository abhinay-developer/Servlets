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

@WebServlet("/sgsturl")
public class ITStateGSTServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String pname = null, company = null, ptype = null;
		float cost = 0.0f, sgst = 0.0f;
		ServletContext sc1 = null, sc2 = null;
		RequestDispatcher rd = null;
		PrintWriter pw = null;
		// get PrintWriter
		pw = res.getWriter();
		// set Content Type
		res.setContentType("text/html");
		// read data
		pname = req.getParameter("pname");
		company = req.getParameter("company");
		ptype = req.getParameter("ptype");
		cost = Float.parseFloat(req.getParameter("cost"));

		if (ptype.equalsIgnoreCase("product"))
			sgst = cost * 0.12f;
		else if (ptype.equalsIgnoreCase("service"))
			sgst = cost * 0.1f;
		else if (ptype.equalsIgnoreCase("startup"))
			sgst = cost * 0.03f;
		// Display Details
		pw.println("<h1 stype='color:red;text-align:center'>GST INFO</h1>");
		pw.println("<br><b>Project Name::" + pname + "</b>");
		pw.println("<br><b>Project Company::" + company + "</b>");
		pw.println("<br><b>Project type::" + ptype + "</b>");
		pw.println("<br><b>Project Cost::" + cost + "</b>");
		pw.println("<br><b>State GST::" + sgst + "</b>");
		// Communication with Destination Servlet CentralGSTApp Using Cross context
		// Communication
		// get ServletContext object of current web App
		sc1 = getServletContext();
		// get ForeignContext object of CentralGSTApp
		sc2 = sc1.getContext("/CentralGSTApp");
		// get RequestDispatcher object pointing ITCentralGSTServlet of CentralGSTApp
		rd = sc2.getRequestDispatcher("/cgsturl");
		rd.include(req, res);
		// add hyperlink
		pw.println("<br><br><br><a href='input.html'>Home</a>");
		// close Print writer
		pw.close();
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
