package com.ssafy.model.dto;

public class Product {
	private int gno;
	private String gname;
	private int price;
	private String gdesc;
	
	public Product() {}
	
	public Product(String gname, int price, String gdesc) {
		super();
		this.gname = gname;
		this.price = price;
		this.gdesc = gdesc;
	}

	public Product(int gno, String gname, int price, String gdesc) {
		super();
		this.gno = gno;
		this.gname = gname;
		this.price = price;
		this.gdesc = gdesc;
	}

	public int getGno() {
		return gno;
	}

	public void setGno(int gno) {
		this.gno = gno;
	}

	public String getGname() {
		return gname;
	}

	public void setGname(String gname) {
		this.gname = gname;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getGdesc() {
		return gdesc;
	}

	public void setGdesc(String gdesc) {
		this.gdesc = gdesc;
	}

	@Override
	public String toString() {
		return "Product [gno=" + gno + ", gname=" + gname + ", price=" + price + ", gdesc=" + gdesc + "]";
	}
	
	
	
}
