package com.ssafy.model.service;

import java.sql.SQLException;
import java.util.List;


import com.ssafy.model.dto.Product;
import com.ssafy.model.dto.ProductException;
import com.ssafy.model.repository.ProductRepo;

public class ProductServiceImp implements ProductService {
	private ProductRepo dao;

	
	
	public ProductServiceImp() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProductServiceImp(ProductRepo dao) {
		super();
		this.dao = dao;
	}
	public ProductRepo getDao() {
		return dao;
	}
	public void setDao(ProductRepo dao) {
		this.dao = dao;
	}


	@Override
	public Product select(String id) {
		try {
			Product product = dao.select(id);
			if(product == null) {
				throw new ProductException("등록되지 않은 제품입니다.");
			}else {
			   return product;
			}
		} catch (Exception e) {
			throw new ProductException();
		}
	}

	@Override
	public List<Product> selectAll() {
		try {
			return dao.selectAll();
		}catch (SQLException e) {
			throw new ProductException();
		}
	}
	
	@Override
	public void insert(Product product) {
		try {
			dao.insert(product);
		} catch (SQLException e) {
			throw new ProductException();
		}
	}

	@Override
	public void update(Product product) {
		try {
			dao.update(product);
		} catch (SQLException e) {
			throw new ProductException();
		}
	}

	@Override
	public void delete(String id) {
		try {
			dao.delete(id);
		} catch (SQLException e) {
			throw new ProductException();
		}
	}

}
