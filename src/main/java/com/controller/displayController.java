	package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.productDao;
import com.dao.registerDao;
import com.model.bill;
import com.model.product;
import com.model.register;

/**
 * Servlet implementation class displayController
 */
public class displayController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public displayController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		PrintWriter pw=response.getWriter();
		HttpSession session1=request.getSession(true);
		int custId=(int)session1.getAttribute("custid");
		HttpSession session=request.getSession(true);
		bill b=(bill)session.getAttribute("bill");
		List<product> prodlist=b.getProdlist();
		productDao pd=new productDao();
		int i=pd.saveBill(b,custId);
		if(i>0)
		{
			System.out.println("\nBill added to DB successfully");
		}
		registerDao rd=new registerDao();
		ResultSet rs=rd.searchCust(custId);
        pw.print("<html><head><link rel='stylesheet' type='text/css' href='mystyle.css'>");
        pw.print("</head><body style='background-image:linear-gradient(to right top,#b4cd5a,#c1c647,#cebd34,#dcb422,#eba912); background-repeat: no-repeat; background-attachment: fixed; background-size: cover;'>");
		try {
			pw.print("<center><h1>Customer Details</h1></center>");
			if(rs.next())
			{
				pw.print("<center><table id='cust'>");
				pw.print("<tr><th>Customer Id</th><th>Customer Name</th><th>Phone NO.</th><th>City</th></th><th>State</th></tr>");
				pw.print("<tr><td>"+rs.getInt(1)+"</td><td>"+rs.getString(4)+"</td><td>"+rs.getString(6)+"</td><td>"+rs.getString(7)+"</td><td>"+rs.getString(8)+"</td></tr>");
				pw.print("</table></center>");
			}
			pw.print("<center><h1>Product Details</h1></center>");
			rs=pd.searchProduct(custId);
			pw.print("<center><table id='cust'>");
			pw.print("<tr><th>Product ID</th><th>Product Name</th><th>Product price</th><th>Product Qunatity</th></tr>");
			while(rs.next())
			{
				pw.print("<tr><td>"+rs.getInt(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getInt(3)+"</td><td>"+rs.getInt(4)+"</td></tr>");
			}
			pw.print("</table></center>");
			pw.print("<center><h1>Bill Details</h1></center>");
			rs=pd.searchBill(custId);
			pw.print("<center><table id='cust'>");
			pw.print("<tr><th>Bill no</th><th>Total</th><th>CGST</th><th>SGST</th><th>Final Total</th></tr>");
			if(rs.next())
			{
				pw.print("<tr><td>"+rs.getInt(1)+"</td><td>"+rs.getDouble(2)+"</td><td>"+rs.getDouble(3)+"</td><td>"+rs.getDouble(4)+"</td><td>"+rs.getDouble(5)+"</td></tr>");
			}
			pw.print("</table></center>");
			pw.print("</body></html>");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		prodlist = null;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
