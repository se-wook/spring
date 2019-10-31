package com.ssafy.pms.model.dto;

import java.io.Serializable;

public class Product implements Serializable {
	private String num;
	private String title;
	private int price;
	private String description;
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(String num, String title, int price, String description) {
		super();
		this.num = num;
		this.title = title;
		this.price = price;
		this.description = description;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Product [num=" + num + ", title=" + title + ", price=" + price + ", description=" + description + "]";
	}
	
	

}