package com.ssafy.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.ssafy.model.dao.MemberDAO;
import com.ssafy.model.dao.MemberDAOImp;
import com.ssafy.model.dto.Member;
import com.ssafy.model.dto.MemberException;
import com.ssafy.util.DBUtil;


//@Component
@Service("memberService")
public class MemberServiceImp implements MemberService {
	
	@Autowired
	@Qualifier("MemberDao") // MemberDAO 타입으로 2개 이상 등록된 경우에 byName으로 mapping 할 경우
	private MemberDAO dao;
	
	public MemberServiceImp() {}
	public MemberServiceImp(MemberDAO dao) {
		super();
		this.dao = dao;
	}
	public MemberDAO getDao() {
		return dao;
	}
	public void setDao(MemberDAO dao) {
		this.dao = dao;
	}


	@Override
	public Member search(String id) {
		Connection con = null;
		try {
			con = DBUtil.getConnection();
			Member member = dao.search(con, id);

			if (member == null) {
				throw new MemberException("등록되지 않은 아이디입니다.");
			} else {
				return member;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new MemberException();
		} finally {
			DBUtil.close(con);
		}
	}

	@Override
	public List<Member> searchAll() {
		Connection con = null;
		try {
			con = DBUtil.getConnection();
			return dao.searchAll(con);
		} catch (SQLException e) {
			throw new MemberException();
		} finally {
			DBUtil.close(con);
		}
	}

	@Override
	public boolean login(String id, String pw) {
		Connection con = null;
		try {
			con = DBUtil.getConnection();
			Member member = dao.search(con, id);
			if (member == null) {
				throw new MemberException("등록되지 않은 회원 아이디입니다.");
			} else {
				if (pw.equals(member.getPassword())) {
					return true;
				} else {
					throw new MemberException("비밀 번호 오류");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new MemberException();
		} finally {
			DBUtil.close(con);
		}
	}

	@Override
	public boolean checkID(String id) {
		Connection con = null;
		try {
			con = DBUtil.getConnection();
			Member member = dao.search(con, id);
			if (member == null) {
				return false;
			} else {
				return true;
			}
		} catch (SQLException e) {
			throw new MemberException();
		} finally {
			DBUtil.close(con);
		}
	}

	@Override
	public void update(Member member) {
		Connection con = null;
		try {
			con = DBUtil.getConnection();
			Member find = dao.search(con, member.getId());
			if (find == null) {
				throw new MemberException("수정할 회원 정보가 없습니다.");
			} else {
				dao.update(con, member);
			}
		} catch (SQLException e) {
			throw new MemberException();
		} finally {
			DBUtil.close(con);
		}
	}

	@Override
	public void remove(String id) {
		Connection con = null;
		try {
			con = DBUtil.getConnection();
			Member find = dao.search(con, id);
			if (find == null) {
				throw new MemberException("탈퇴할 회원 정보가 없습니다.");
			} else {
				dao.remove(con, id);
			}
		} catch (SQLException e) {
			throw new MemberException();
		} finally {
			DBUtil.close(con);
		}
	}

	@Override
	public void add(Member member) {
		Connection con = null;
		try {
			con = DBUtil.getConnection();
			Member find = dao.search(con, member.getId());
			if (find != null) {
				throw new MemberException("이미 등록된 아이디입니다.");
			} else {
				dao.add(con, member);
			}
		} catch (SQLException e) {
			throw new MemberException();
		} finally {
			DBUtil.close(con);
		}
	}
}
