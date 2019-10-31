package com.ssafy.pms.model.dao;

import java.util.List;

import com.ssafy.pms.model.dto.Product;

public interface ProductDao {
	public void 	insert(Product product);
	public void 	update(Product product);
	public void 	delete(String num);
	public Product	search(String num);
	public List<Product>	searchAll();
}










