package com.ssafy.pms.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.pms.model.dao.ProductDao;
import com.ssafy.pms.model.dto.Product;
import com.ssafy.pms.model.dto.ProductException;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductDao dao;
		
	public void insert(Product phone) {
		try {
			dao.insert(phone);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ProductException("저장 중 오류가 발생했습니다. ");
		}
	}
	public void delete(String num) {
		try {
			dao.delete(num);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ProductException("삭제 중 오류가 발생했습니다. ");
		}
	}
	public Product search(String num) {
		try {
			return dao.search(num);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ProductException("검색 중 오류가 발생했습니다. ");
		}
	}
	public List<Product> searchAll() {
		try {
			return dao.searchAll();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ProductException("검색 중 오류가 발생했습니다. ");
		}
	}
	@Override
	public void update(Product product) {
		try {
			dao.update(product);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ProductException("업데이트 중 오류가 발생했습니다. ");
		}
	}

}





