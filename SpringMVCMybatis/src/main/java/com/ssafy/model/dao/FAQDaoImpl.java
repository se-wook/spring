package com.ssafy.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.model.dto.FAQ;

@Repository
public class FAQDaoImpl implements FAQDao {
	private String ns = "sql.faq.";
	
	@Autowired
	private SqlSession session;
	
	public FAQ search(String no) {
		return session.selectOne(ns+"search",no);
	}

	public List<FAQ> searchall() {
		return session.selectList(ns+"searchAll");
	}

	public void insert(FAQ faq) {
		session.insert(ns+"insert",faq);
	}

	public void update(FAQ faq) {
		session.update(ns+"update",faq);
	}

	public void reply(FAQ faq) {
		session.update(ns+"reply", faq);
	}

	public void delete(String no) {
		session.delete(ns+"delete",no);
	}

}
