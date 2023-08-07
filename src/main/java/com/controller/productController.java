package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.productDao;
import com.model.product;

/**
 * Servlet implementation class productController
 */
public class productController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//List<product> prodlist=null;
    /*public void init()
    {
    	prodlist=new LinkedList<product>();
    }*/
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public productController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw=response.getWriter();
		//List<product> prodlist=null;
		//prodlist = new LinkedList<product>();
		int prodId=Integer.parseInt(request.getParameter("prodId"));
		try {
			if(prodId<=0)
			{
				throw new Exception();
			}
		} catch (Exception ex) {
			pw.print("<script>alert('Enter Valid Product Id');location='productUi.html';</script>");
			return;
		}
		String prodName=request.getParameter("prodName");
		int prodPrice=Integer.parseInt(request.getParameter("prodPrice"));
		try {
			if(prodPrice<=0)
			{
				throw new Exception();
			}
		} catch (Exception ex) {
			pw.print("<script>alert('Enter Valid Product Price');location='productUi.html'; </script>");
			return;
		}
		int prodQty= Integer.parseInt(request.getParameter("prodQty"));
		try {
			if(prodQty<=0)
			{
				throw new Exception();
			}
		} catch (Exception ex) {
			pw.print("<script>alert('Enter Valid Product Quantity');location='productUi.html'; </script>");
			return;
		}
		product p=new product(prodId, prodName, prodPrice, prodQty);
		//prodlist.add(p);
		productDao pd=new productDao();
		HttpSession session1=request.getSession(true);
		int custId=(int)session1.getAttribute("custid");
		int i=pd.saveProduct(custId,p);
		if(i>0)
		{
			System.out.println("\nProduct Saved in DB successfully");
		}
		//HttpSession session=request.getSession();
		//session.setAttribute("prod", prodlist);
		pw.print("<html><body bgcolor='grey'><center>");
		pw.print("<h1>do you want to add more products...Press Yes</h1>");
		pw.print("<a href='productUi.html'><button padding=15px 32px><h3>Yes</h3></button></a>&nbsp&nbsp&nbsp&nbsp&nbsp<a href='cartController'><button padding=15px 32px><h3>No</h3></button></a>");
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
