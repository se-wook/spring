package com.ssafy.model.dao;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.model.dto.Board;
import com.ssafy.model.dto.BoardFile;
import com.ssafy.model.dto.PageBean;

@Repository
public class BoardDaoImpl implements BoardDao {
	private String  ns="com.ssafy.board.dao.BoardDao.";
	
	@Autowired
	private SqlSession session; // sqlSessionFactory 상속?
	
	public int getBoardNo() {
		return session.selectOne(ns+"getBoardNo");
	}
	public void insertBoard(Board board) {
		session.insert(ns+"insert",board);
		//spring이 커밋 or 롤백 해준다.
	}
	public void insertBoardFile(List<BoardFile> files, int bno) {
		for(BoardFile boardFile: files) {
			boardFile.setBno(bno);
			session.insert(ns+"insertfile",boardFile);
		}
	}
	public Board search(String no) {
		return session.selectOne(ns+"search",no);
	}
	public List<Board> searchAll(PageBean bean) {
		return session.selectList(ns+"searchAll",bean);
	}
	public int count(PageBean bean) {
		return session.selectOne(ns+"count",bean);
	}
	public void updateBoard(Board board) {
		session.update(ns+"update",board);
	}
	public void deleteBoard(String no) {
		session.delete(ns+"delete",no);
	}
	public void deleteBoardFile(int bno) {
		session.delete(ns+"deletefile",bno);
	}
}
