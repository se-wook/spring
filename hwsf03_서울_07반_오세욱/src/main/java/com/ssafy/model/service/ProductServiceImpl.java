package com.ssafy.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.model.dao.ProductDao;
import com.ssafy.model.dto.Product;
import com.ssafy.model.dto.ProductException;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductDao  dao;
	public List<Product> searchAll() {
		try {
			return dao.searchAll();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ProductException("상품 목록 조회 중 오류 발생");
		}
	}
	public void insert(Product product) {
		try {
			dao.insert(product);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ProductException("상품 등록 중 오류 발생");
		}
	}

}
