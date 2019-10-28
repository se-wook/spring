package com.ssafy.model.service;

import java.util.List;

import com.ssafy.model.dto.Product;

public interface ProductService {

	public List<Product> searchAll();

	public void insert(Product product);

}
