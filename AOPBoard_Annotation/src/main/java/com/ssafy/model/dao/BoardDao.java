package com.ssafy.model.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

import com.ssafy.model.dto.Board;
import com.ssafy.model.dto.PageBean;

public interface BoardDao {
	public int getBoardNo(Connection con) throws SQLException;

	public void insertBoard(Connection con, Board board) throws SQLException;

	public Board search(Connection con, String no) throws SQLException;

	public Map<String, Object> searchAll(Connection con, PageBean bean) throws SQLException;

	public int count(Connection con, PageBean bean) throws SQLException;

	public void updateBoard(Connection con, Board board) throws SQLException;

	public void deleteBoard(Connection con, String no) throws SQLException;
}
