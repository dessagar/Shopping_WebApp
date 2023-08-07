package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.productDao;
import com.dao.registerDao;
import com.model.product;

/**
 * Servlet implementation class cartController
 */
public class cartController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public cartController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		PrintWriter pw=response.getWriter();
		HttpSession session=request.getSession(true);
		//List<product> prodlist=(List)session.getAttribute("prod");
		HttpSession session1=request.getSession(true);
		int custId=(int)session1.getAttribute("custid");
		pw.print("<html><head><link rel='stylesheet' type='text/css' href='mystyle.css'>");
		pw.print("</head><body  style= 'background-image:linear-gradient(to right top,#b4cd5a,#c1c647,#cebd34,#dcb422,#eba912); background-repeat: no-repeat; background-attachment: fixed; background-size: cover;'>");
		pw.print("<center><table id='cust'>");
		pw.print("<tr><th>Product ID</th><th>Product Name</th><th>Product price</th><th>Product Qunatity</th></tr>");
		productDao pd = new productDao();
		ResultSet rs = pd.searchProduct(custId);
		try {
			while(rs.next())
			{
				pw.print("<tr><td>"+rs.getInt(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getInt(3)+"</td><td>"+rs.getInt(4)+"</td></tr>");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pw.print("</table></center>");
		pw.print("</body></html>");
		pw.print("<html><body bgcolor='grey'><center>");
		pw.print("<h1>Do you want to Generate Bill</h1>");
		pw.print("<a href='billController'><button padding=15px 32px><h3>Bill</h3></button></a>");
		pw.print("</center></body></html>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
