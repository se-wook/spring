package com.ssafy.model.dao;

import java.util.List;

import com.ssafy.model.dto.Product;

public interface ProductDAO {

	void insert(Product product);

	List<Product> searchAll();

}