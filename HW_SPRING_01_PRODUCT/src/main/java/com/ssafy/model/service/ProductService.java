package com.ssafy.model.service;

import java.util.List;

import com.ssafy.model.dto.Product;

public interface ProductService {
	public Product select(String id);
	public List<Product> selectAll();
	public void insert(Product product);
	public void update(Product product);
	public void delete(String id);
}
