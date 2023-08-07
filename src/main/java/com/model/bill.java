package com.model;

import java.util.List;

public class bill {
	private int billNo;
	private double total;
	private double cgst;
	private double sgst;
	private double finalTotal;
	private List<product> prodlist;
	public bill(int billNo, double total, double cgst, double sgst, double finalTotal) {
		super();
		this.billNo = billNo;
		this.total = total;
		this.cgst = cgst;
		this.sgst = sgst;
		this.finalTotal = finalTotal;
	}
	public int getBillNo() {
		return billNo;
	}
	public void setBillNo(int billNo) {
		this.billNo = billNo;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public double getCgst() {
		return cgst;
	}
	public void setCgst(double cgst) {
		this.cgst = cgst;
	}
	public double getSgst() {
		return sgst;
	}
	public void setSgst(double sgst) {
		this.sgst = sgst;
	}
	public double getFinalTotal() {
		return finalTotal;
	}
	public void setFinalTotal(double finalTotal) {
		this.finalTotal = finalTotal;
	}
	public List<product> getProdlist() {
		return prodlist;
	}
	public void setProdlist(List<product> prodlist) {
		this.prodlist = prodlist;
	}
	

}
