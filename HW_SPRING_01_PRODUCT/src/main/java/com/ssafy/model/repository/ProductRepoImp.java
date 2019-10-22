package com.ssafy.model.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.ssafy.model.dto.Product;
import com.ssafy.util.DBUtil;

public class ProductRepoImp implements ProductRepo {
	
	@Override
	public Product select(String id) throws SQLException {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet  rs  = null;
		try {
			con = DBUtil.getConnection();
			String sql = " select * from goods2 where gno = ? ";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, id);
			rs = stmt.executeQuery();
			if(rs.next()) {
				return new Product(rs.getInt("gno")
								, rs.getString("gname")
								, rs.getInt("price")
						        , rs.getString("gdesc"));
			}
		} finally {
		  DBUtil.close(rs);
		  DBUtil.close(stmt);
		  DBUtil.close(con);
		}
		return null;
	}

	@Override
	public List<Product> selectAll() throws SQLException {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet  rs  = null;
		try {
			con = DBUtil.getConnection();
			String sql = " select * from goods2  ";
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			List<Product> product = new ArrayList<Product>();
			while(rs.next()) {
				product.add(new Product(rs.getInt("gno")
										, rs.getString("gname")
										, rs.getInt("price")
								        , rs.getString("gdesc")));
			}
			return product;
		} finally {
		  DBUtil.close(rs);
		  DBUtil.close(stmt);
		  DBUtil.close(con);
		}
	}

	@Override
	public void insert(Product product) throws SQLException {
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = DBUtil.getConnection();
			String sql = " insert into goods2(gname, price, gdesc) "
					   + " values(?,?,?) ";
			System.out.println(sql);
			stmt = con.prepareStatement(sql);
			int idx = 1;
			stmt.setString(idx++, product.getGname());		
			stmt.setInt(idx++, product.getPrice());		
			stmt.setString(idx++, product.getGdesc());		
			stmt.executeUpdate();
		} finally {
			DBUtil.close(stmt);
			DBUtil.close(con);
		}
	}

	@Override
	public void update(Product product) throws SQLException {
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = DBUtil.getConnection();
			String sql = " update goods2 set price=?, gdesc=? "
						+"                  where gname=? " ;
			System.out.println(sql);
			stmt = con.prepareStatement(sql);
			int idx = 1;
			stmt.setInt(idx++, product.getPrice());		
			stmt.setString(idx++, product.getGdesc());		
			stmt.setString(idx++, product.getGname());		
			stmt.executeUpdate();
		} finally {
			DBUtil.close(stmt);
			DBUtil.close(con);
		}
	}

	@Override
	public void delete(String id) throws SQLException {
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = DBUtil.getConnection();
			String sql = " delete from goods2 where gno=? " ;
			stmt = con.prepareStatement(sql);
			stmt.setString(1, id);		
			stmt.executeUpdate();
		} finally {
			DBUtil.close(stmt);
			DBUtil.close(con);
		}
	}


}
