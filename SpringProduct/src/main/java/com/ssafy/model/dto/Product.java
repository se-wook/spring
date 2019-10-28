package com.ssafy.model.dto;

public class Product {
	String no;
	String name;
	int price;
	String info;

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}
	
	public Product() {
		
	}

	public Product(String no, String name, int price, String info) {
		super();
		this.no = no;
		this.name = name;
		this.price = price;
		this.info = info;
	}

	@Override
	public String toString() {
		return "Product [no=" + no + ", name=" + name + ", price=" + price + ", info=" + info + "]";
	}
}
