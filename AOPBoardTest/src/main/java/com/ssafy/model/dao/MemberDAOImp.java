package com.ssafy.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.mysql.cj.jdbc.result.ResultSetMetaData;
import com.ssafy.model.dto.Member;
import com.ssafy.util.DBUtil;

public class MemberDAOImp implements MemberDAO {
	@Override
	public Member search(Connection con, String id) throws SQLException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			System.out.println(id);
			String sql = " select * from member where id = ? ";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, id);
			rs = stmt.executeQuery();			
			if (rs.next()) {
				return new Member(rs.getString("id"), rs.getString("password"), rs.getString("name"), rs.getString("email"), rs.getString("phone"), rs.getString("address"));
			}
		} finally {
			DBUtil.close(rs);
			DBUtil.close(stmt);
		}
		return null;
	}

	@Override
	public List<Member> searchAll(Connection con) throws SQLException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			String sql = " select * from member  ";
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			List<Member> members = new LinkedList<>();
			while (rs.next()) {
				members.add(new Member(rs.getString("id"), rs.getString("name"), rs.getString("email"), rs.getString("phone")));
			}
			return members;
		} finally {
			DBUtil.close(rs);
			DBUtil.close(stmt);
		}
	}

	@Override
	public void update(Connection con, Member member) throws SQLException {
		PreparedStatement stmt = null;
		try {
			String sql = " update member set password=?, name=?, email=?, phone=? "
							+ "                  , address=?  where id=? ";

			stmt = con.prepareStatement(sql);
			int idx = 1;
			stmt.setString(idx++, member.getPassword());
			stmt.setString(idx++, member.getName());
			stmt.setString(idx++, member.getEmail());
			stmt.setString(idx++, member.getPhone());
			stmt.setString(idx++, member.getAddress());
			stmt.setString(idx++, member.getId());
			stmt.executeUpdate();
		} finally {
			DBUtil.close(stmt);
		}
	}

	@Override
	public void remove(Connection con, String id) throws SQLException {
		PreparedStatement stmt = null;
		try {
			String sql = " delete from member where id=? ";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, id);
			stmt.executeUpdate();
		} finally {
			DBUtil.close(stmt);
		}
	}

	@Override
	public void add(Connection con, Member member) throws SQLException {
		PreparedStatement stmt = null;
		try {
			String sql = " insert into member(id,password,name,email,phone,address) "
							+ " values(?,?,?,?,?,?) ";
			stmt = con.prepareStatement(sql);
			int idx = 1;
			stmt.setString(idx++, member.getId());
			stmt.setString(idx++, member.getPassword());
			stmt.setString(idx++, member.getName());
			stmt.setString(idx++, member.getEmail());
			stmt.setString(idx++, member.getPhone());
			stmt.setString(idx++, member.getAddress());
			stmt.executeUpdate();
		} finally {
			DBUtil.close(stmt);
		}
	}
}
