package com.ssafy.model.dao;

import java.util.List;

import com.ssafy.model.dto.Product;

public interface ProductDao {
	public List<Product> searchAll();
	public void insert(Product faq);
}








