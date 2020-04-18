package com.abhi.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/countryurl")
public class CountryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		{
			String country = null;
			PrintWriter pw = null;
			pw = response.getWriter();
			String statesIndia[] = { "AP", "TS", "MH", "MP", "UP" };
			String statesUs[] = { "CA", "LA", "NY", "CR", "AZ" };
			String stateAusis[] = { "TMS", "BB", "CBR" };
			// read the form dta
			country = request.getParameter("country");
			if (country.equals("INDIA")) {
				pw.println("states=" + Arrays.toString(statesIndia));
			} else if (country.equals("US")) {
				pw.println("states=" + Arrays.toString(statesUs));
			} else {
				pw.println("states=" + Arrays.toString(stateAusis));
			}
			pw.close();
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
