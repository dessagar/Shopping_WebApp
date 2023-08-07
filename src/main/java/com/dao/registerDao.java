package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.model.register;

public class registerDao {
	int i=0;
	public int createUser(register r)
	{
		Connection con=dbConnection.getConnection();
		try {
			PreparedStatement pstate=con.prepareStatement("insert into register5 values(?,?,?,?,?,?,?,?)");
			pstate.setInt(1, r.getCustId());
			pstate.setString(2, r.getUserName());
			pstate.setString(3, r.getPassWord());
			pstate.setString(4, r.getCustName());
			pstate.setString(5, r.getEmail());
			pstate.setString(6, r.getMobNo());
			pstate.setString(7, r.getCity());
			pstate.setString(8, r.getState());
			i=pstate.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	public ResultSet validate_user(String userName,String passWord, int cid)
	{
		Connection con=dbConnection.getConnection();
		ResultSet rs=null;
		try {
			PreparedStatement pstate=con.prepareStatement("select *from register5 where uname=? and pass=? and custid=?");
			pstate.setString(1, userName);
			pstate.setString(2, passWord);
			pstate.setInt(3, cid);
			rs = pstate.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	public ResultSet searchCust(int custId)
	{
		Connection con=dbConnection.getConnection();
		ResultSet rs=null;
		try {
			PreparedStatement pstate=con.prepareStatement("select *from register5 where custid=?");
			pstate.setInt(1, custId);
			rs = pstate.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	public ResultSet validateID()
	{
		ResultSet rs=null;
		java.sql.Statement st=null;
		Connection con=dbConnection.getConnection();
		String str="select *from register5";
		try {
			st= con.createStatement();
			rs=st.executeQuery(str);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
}
