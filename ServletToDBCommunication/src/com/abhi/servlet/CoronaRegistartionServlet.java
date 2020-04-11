package com.abhi.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.activation.DataSource;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CoronaRegistartionServlet")
public class CoronaRegistartionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String CORONA_REGISTARTION= "INSERT INTO CORONA_REGISTRATION(PATNAME,PATADDR,PATAGE,GENDER,STAGE)VALUES(?,?,?,?,?)";
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection con = null;
		PreparedStatement ps=null;
		ResultSet rs = null;
		PrintWriter pw = null;
		int result=0;
		pw = response.getWriter();
		response.setContentType("text/html");
		// patName,patAddr,patAge,gender,stage
		String patName = request.getParameter("patName");
		String patAddr = request.getParameter("patAddr");
		String patAge = request.getParameter("patAge");
		String gender = request.getParameter("gender");
		String stage = request.getParameter("stage");
		try {
			con = makeConnection();
			ps = con.prepareStatement(CORONA_REGISTARTION);
			ps.setString(1, patName);
			ps.setString(2, patAddr);
			ps.setString(3, patAge);
			ps.setString(4, gender);
			ps.setString(5, stage);
			 result=ps.executeUpdate();
			if(result>0)
			{
				pw.println("Sucessfully registered");
			}
			else
			{
				pw.print("Internal db Problem");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
	private Connection makeConnection() throws Exception {
        InitialContext ic=null;
        DataSource ds=null;
        Connection con=null;
        ic=new InitialContext();
        ds=(DataSource)ic.lookup("DsJndi");
        try
        {
        	con=((Statement) ds).getConnection();
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        }
		return con;
        
	}

}
