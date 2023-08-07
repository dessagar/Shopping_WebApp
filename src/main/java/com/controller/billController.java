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
import com.model.bill;
import com.model.product;

/**
 * Servlet implementation class billController
 */
public class billController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public billController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		PrintWriter pw=response.getWriter();
		pw.print("hello...bill servelet here");
		double total=0;
		double cgst=0,sgst=0,finalTotal=0;
		HttpSession session=request.getSession(true);
		//List<product> prodlist= (List)session.getAttribute("prod");
		int custid = (int)session.getAttribute("custid");
		productDao pd = new productDao();
		ResultSet rs = pd.searchProduct(custid);
		try {
			while(rs.next())
			{
				 total=total+rs.getInt(3)*rs.getInt(4);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cgst=total*0.06f;
		sgst=total*0.06f;
		finalTotal=total+cgst+sgst;
		bill b=new bill(110, total, cgst, sgst, finalTotal);
		//b.setProdlist(prodlist);
		session.setAttribute("bill", b);
		response.sendRedirect("displayController");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
