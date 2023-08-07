package com.model;

public class customer {
	private int custId;
	private String custName;
	private String mobNo;
	private String city;
	private String state;
	public customer(int custId, String custName, String mobNo, String city, String state) {
		super();
		this.custId = custId;
		this.custName = custName;
		this.mobNo = mobNo;
		this.city = city;
		this.state = state;
	}
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getMobNo() {
		return mobNo;
	}
	public void setMobNo(String mobNo) {
		this.mobNo = mobNo;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	

}
