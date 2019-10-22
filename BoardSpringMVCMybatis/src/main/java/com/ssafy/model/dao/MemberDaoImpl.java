package com.ssafy.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.model.dto.Member;
import com.ssafy.model.dto.PageBean;
import com.ssafy.util.DBUtil;

@Repository
public class MemberDaoImpl implements MemberDao {
	private String ns = "com.ssafy.model.dao.MemberDao.";
	@Autowired
	private SqlSession session;
	
	public void insertMember(Member member){
		session.insert(ns+"insert",member);
	}
	public void updateMember(Member member){
		session.update(ns+"update",member);
	}
	public void deleteMember(String id){
		session.update(ns+"delete",id);
	}
	public Member search(String id){
		return session.selectOne(ns+"search",id);
	}
	public List<Member> searchAll(PageBean bean){
		return session.selectList(ns+"searchAll",bean);
	}
	/** 
	 * 검색 조건에 따른 게시글의 개수   ==> 페이징 처리 
	 * */
	public int getCount(PageBean bean) {
		return session.selectOne(ns+"count",bean);
	}
}













