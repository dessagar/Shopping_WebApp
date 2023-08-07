package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.model.bill;
import com.model.product;

public class productDao {
	Connection  con=null;
	PreparedStatement pstate=null;
	int i=0;
	public int saveProduct(int custId, product p)
	{
		con=dbConnection.getConnection();
		
			try {
				pstate=con.prepareStatement("insert into productInfo values(?,?,?,?,?)");
				pstate.setInt(1, p.getProdid());
				pstate.setString(2, p.getProdName());
				pstate.setInt(3, p.getProdPrice());
				pstate.setInt(4,p.getProdQty());
				pstate.setInt(5, custId);
				i=pstate.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return i;
	}
	public int saveBill(bill b,int custId)
	{
		con=dbConnection.getConnection();
		try {
			pstate=con.prepareStatement("insert into billInfo values(?,?,?,?,?,?)");
			pstate.setInt(1, b.getBillNo());
			pstate.setDouble(2, b.getTotal());
			pstate.setDouble(3, b.getCgst());
			pstate.setDouble(4, b.getSgst());
			pstate.setDouble(5, b.getFinalTotal());
			pstate.setInt(6, custId);
			i=pstate.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	public ResultSet searchProduct(int custId)
	{
		Connection con=dbConnection.getConnection();
		ResultSet rs=null;
		try {
			pstate=con.prepareStatement("select *from productInfo where custid=?");
			pstate.setInt(1, custId);
			rs = pstate.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	public ResultSet searchBill(int custId)
	{
		Connection con=dbConnection.getConnection();
		ResultSet rs=null;
		try {
			pstate=con.prepareStatement("select *from billInfo where custid=?");
			pstate.setInt(1, custId);
			rs = pstate.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

}
