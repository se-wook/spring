package com.ssafy.pms.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.pms.model.dto.Phone;
import com.ssafy.pms.model.dto.UserInfo;

@Repository
public class PhoneDaoImpl implements PhoneDao {
	@Autowired
	private SqlSession session;
	
	String ns="sql.pms.";
	public void insert(Phone phone) {
		session.insert(ns+"insert", phone);
	}
	public void delete(List<String> num) {
//		for (String n : num) {
//			session.delete(ns+"delete", n);
//		}
		session.delete(ns+"delete2", num);
	}
	public Phone search(String num) {
		return session.selectOne(ns+"search", num);
	}
	public List<Phone> searchAll() {
		return session.selectList(ns+"searchAll");
	}
	public UserInfo findUser(String id) {
		return session.selectOne(ns+"findUser", id);
	}
}



