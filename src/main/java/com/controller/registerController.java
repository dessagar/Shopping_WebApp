package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.registerDao;
import com.model.register;

/**
 * Servlet implementation class regiseterController
 */
public class registerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public  boolean isValid(String mobNo)
	{

		// The given argument to compile() method
		// is regular expression. With the help of
		// regular expression we can validate mobile
		// number.
		// 1) Begins with 0 or 91
		// 2) Then contains 7 or 8 or 9.
		// 3) Then contains 9 digits
		Pattern p = Pattern.compile("(0/91)?[7-9][0-9]{9}");

		// Pattern class contains matcher() method
		// to find matching between given number
		// and regular expression
		Matcher m = p.matcher(mobNo);
		return (m.find() && m.group().equals(mobNo));
	}
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public registerController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		registerDao rd=new registerDao();
		PrintWriter pw=response.getWriter();
		int flag=0;
		String email=request.getParameter("email");
		String userName=request.getParameter("uname");
		String passWord=request.getParameter("pass");
		int custId=Integer.parseInt(request.getParameter("custid"));
		try {
			if(custId<=0)
			{
				throw new Exception();
			}
		} catch (Exception ex) {
			pw.print("<script>alert('Enter Valid customer ID');location='register.html'; </script>");
		}
		
		
		ResultSet rs=rd.validateID();
		try {
			while(rs.next())
			{
				if(rs.getInt(1)==custId)
				{
					pw.print("<script>alert('Enter Unique customer ID');location='register.html'; </script>");
					flag=1;
					//	response.sendRedirect("register.html");
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(flag==0)
		{
			String custName=request.getParameter("custname");
			String mobNo=request.getParameter("mobno");
			String city=request.getParameter("city");
			String state=request.getParameter("state");
			if(isValid(mobNo))
			{
				register r = new register(custId, userName, passWord, custName, email, mobNo, city, state);
				HttpSession session1=request.getSession();
				session1.setAttribute("custid", custId);
				int i=rd.createUser(r);
				if(i>0)
				{
					pw.print("<html><body bgcolor ='grey'><center>");
					pw.print("<h1>Registration Successfull...!!</h1>");
					pw.print("<a href='login.html'><button>Log In</button></a>");
					pw.print("</center></body></html>");

				}
			}
			else
			{
				pw.print("<script> if(confirm('Enter valid Mobile Number')){window.location.href='register.html'} </script>");
				//response.sendRedirect("register.html");
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
