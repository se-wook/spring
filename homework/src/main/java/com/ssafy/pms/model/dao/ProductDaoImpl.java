package com.ssafy.pms.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.pms.model.dto.Product;

@Repository
public class ProductDaoImpl implements ProductDao {
	@Autowired
	private SqlSession session;
	
	String ns="sql.pms.";
	public void insert(Product phone) {
		session.insert(ns+"insert", phone);
	}
	public void delete(String num) {
		session.delete(ns+"delete", num);
	}
	public Product search(String num) {
		return session.selectOne(ns+"search", num);
	}
	public List<Product> searchAll() {
		return session.selectList(ns+"searchAll");
	}
	@Override
	public void update(Product product) {
		session.update(ns+"update",product);
	}

}



