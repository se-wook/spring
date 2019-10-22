package com.ssafy.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.ssafy.model.dao.BoardDao;
import com.ssafy.model.dao.BoardDaoImpl;
import com.ssafy.model.dto.Board;
import com.ssafy.model.dto.BoardException;
import com.ssafy.model.dto.PageBean;
import com.ssafy.util.DBUtil;
import com.ssafy.util.PageUtility;

//@Component
//@Scope("") 생략하면 default는 singleton 이다.
@Service("boardService")
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	BoardDao dao;

	public BoardServiceImpl() {
		System.out.println("boardserviceimpl()......");
	}

	public BoardServiceImpl(BoardDao dao) {
		super();
		System.out.println("boardserviceImpl(boarddao)");
		this.dao = dao;
	}

	public BoardDao getDao() {
		return dao;
	}

	public void setDao(BoardDao dao) {
		System.out.println("setter boarddao!!");
		this.dao = dao;
	}

	@Override
	public void insertBoard(Board board) {
		Connection con = null;
		try {
			con = DBUtil.getConnection();
			con.setAutoCommit(false);    //트랜잭션 처리를 위해 자동 커밋이 안된게 설정한다. 
			int no = dao.getBoardNo(con);
			board.setNo(no);
			dao.insertBoard(con, board);
			// TODO : 파일 등록 코드
			con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			DBUtil.rollback(con);
		} finally {
			DBUtil.close(con);
		}
	}

	@Override
	public void updateBoard(Board board) {
		Connection con = null;
		try {
			con = DBUtil.getConnection();
			con.setAutoCommit(false);
			dao.updateBoard(con, board);
			con.commit();
		} catch (SQLException e) {
			DBUtil.rollback(con);
		} finally {
			DBUtil.close(con);
		}
	}

	@Override
	public void deleteBoard(String no) {
		Connection con = null;
		try {
			con = DBUtil.getConnection();
			con.setAutoCommit(false);
			dao.deleteBoard(con, no);
			con.commit();
		} catch (SQLException e) {
			DBUtil.rollback(con);
		} finally {
			DBUtil.close(con);
		}
	}

	@Override
	public Board search(String no) {
		Connection con = null;
		try {
			con = DBUtil.getConnection();
			return dao.search(con, no);
		} catch (SQLException e) {
			throw new BoardException("게시물 검색 중 오류 발생");
		} finally {
			DBUtil.close(con);
		}
	}

	@Override
	public Map<String, Object> searchAll(PageBean bean) {
		Connection con = null;
		try {
			con = DBUtil.getConnection();
			
			Map<String, Object> map =dao.searchAll(con, bean);
			int total = (Integer) map.get("totalNumber");
			try {
				PageUtility bar = new PageUtility(bean.getInterval(), total, bean.getPageNo(), "images/");
				bean.setPageLink(bar.getPageBar());
			}catch(Exception e) {
				
			}
			
			return dao.searchAll(con, bean);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new BoardException("게시물 검색 중 오류 발생");
		} finally {
			DBUtil.close(con);
		}
	}
}
