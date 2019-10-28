package com.ssafy.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.model.dto.Product;

@Repository
public class ProductDAOImp implements ProductDAO {
	private String ns = "sql.product.";
	@Autowired
	private SqlSession session;
	public void insert(Product product)  {
		session.insert(ns + "insert", product);
	}
	public List<Product> searchAll() {
		return session.selectList(ns + "searchAll");
	}
}
