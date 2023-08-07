package com.model;

public class product {
	private int prodid;
	private String prodName;
	private int prodPrice;
	private int prodQty;
	public product(int prodid, String prodName, int prodPrice, int prodQty) {
		super();
		this.prodid = prodid;
		this.prodName = prodName;
		this.prodPrice = prodPrice;
		this.prodQty = prodQty;
	}
	public int getProdid() {
		return prodid;
	}
	public void setProdid(int prodid) {
		this.prodid = prodid;
	}
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	public int getProdPrice() {
		return prodPrice;
	}
	public void setProdPrice(int prodPrice) {
		this.prodPrice = prodPrice;
	}
	public int getProdQty() {
		return prodQty;
	}
	public void setProdQty(int prodQty) {
		this.prodQty = prodQty;
	}
	

}