package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.registerDao;

/**
 * Servlet implementation class loginController
 */
public class loginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw=response.getWriter();
		String userName=request.getParameter("uname");
		String passWord=request.getParameter("pass");
		int cid = Integer.parseInt(request.getParameter("cid"));
		HttpSession session1=request.getSession();
		session1.setAttribute("custid", cid);
		registerDao rd=new registerDao();
		ResultSet rs=rd.validate_user(userName, passWord,cid);
		try {
			if(rs.next())
			{
				pw.print("<html><body bgcolor='grey'> <center>");
				pw.print("<h1>Log In Successfully...!!</h1>");
				pw.print("<a href='customerHome.html'><button padding=15px 32px><h3>Shop Now</h3></button></a>");
				pw.print("</center></body></html>");
			}
			else
			{
				pw.print("<html><body bgcolor='grey'><center>");
				pw.print("<h1>Invalid Username or Password...Try Again..!!</h1>");
				pw.print("<a href='login.html'><button padding=15px 32px><h3>Log In Again</h3></button></a>");
				pw.print("</center></body></html>");
			}
			/*if(rs.next())
			{
				response.sendRedirect("customerHome.html");
			}
			else
			{
				response.sendRedirect("login.html");
			}*/
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
