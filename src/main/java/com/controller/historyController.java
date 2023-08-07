package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.productDao;

/**
 * Servlet implementation class historyController
 */
public class historyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public historyController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		PrintWriter pw=response.getWriter();
		//int custid=Integer.parseInt(request.getParameter("custid"));
		productDao pd=new productDao();
		HttpSession session1=request.getSession(true);
		int custId=(int)session1.getAttribute("custid");
		ResultSet rs=pd.searchProduct(custId);
		pw.print("<html><head><link rel='stylesheet' type='text/css' href='mystyle.css'>");
        pw.print("</head><body style= 'background-image:linear-gradient(to right top,#b4cd5a,#c1c647,#cebd34,#dcb422,#eba912); background-repeat: no-repeat; background-attachment: fixed; background-size: cover;'>");
		pw.print("<center><table id='cust'>");
		pw.print("<tr><th>Product ID</th><th>Product Name</th><th>Product price</th><th>Product Qunatity</th><th>Total</th></tr>");
		try {
			while(rs.next())
			{
				pw.print("<tr><td>"+rs.getInt(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getInt(3)+"</td><td>"+rs.getInt(4)+"</td><td>"+(rs.getInt(3)*rs.getInt(4))+"</td></tr>");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pw.print("</table></center>");
		pw.print("</body></html>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
