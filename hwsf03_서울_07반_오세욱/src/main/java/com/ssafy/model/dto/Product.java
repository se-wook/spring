package com.ssafy.model.dto;

import java.io.Serializable;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;
public class Product implements Serializable {
	private String num;
	private String title;
	private String category;
	private String pdate;
	private String vendor;
	private int price;
	private String description;
	public Product() {}
	public Product(String num, String title, String category, String pdate, String vendor, int price,
			String description) {
		super();
		this.num = num;
		this.title = title;
		this.category = category;
		this.pdate = pdate;
		this.vendor = vendor;
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
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getPdate() {
		return pdate;
	}
	public void setPdate(String pdate) {
		this.pdate = pdate;
	}
	public String getVendor() {
		return vendor;
	}
	public void setVendor(String vendor) {
		this.vendor = vendor;
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
		return "Product [num=" + num + ", title=" + title + ", category=" + category + ", pdate=" + pdate + ", vendor="
				+ vendor + ", price=" + price + ", description=" + description + "]";
	}
	
	
}
