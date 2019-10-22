package com.ssafy.model.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.model.dao.MemberDao;
import com.ssafy.model.dao.MemberDaoImpl;
import com.ssafy.model.dto.BoardException;
import com.ssafy.model.dto.Member;
import com.ssafy.model.dto.MemberException;
import com.ssafy.model.dto.PageBean;
import com.ssafy.util.PageUtility;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberDao dao;
	
	public boolean login(String id, String pw) {
		try {
			System.out.println(id);
			Member member = dao.search(id);
			System.out.println(member);
			if(member == null) {
				throw new MemberException("등록되지 않은 회원 아이디 입니다.");
			}
			if(!member.getPassword().equals(pw)) {
				throw new MemberException("비밀번호 오류.");
			}
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			if(e instanceof MemberException) {
				throw (MemberException)e;
			}else {
				throw new MemberException("회원 번호 조회중 오류 발생");
			}
		}
	}
	public boolean idCheck(String id) {
		try {
			Member member = dao.search(id);
			if(member == null) {
				throw new MemberException("등록되지 않은 회원 아이디 입니다.");
			}
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			if(e instanceof MemberException) {
				throw (MemberException)e;
			}else {
				throw new MemberException("회원 번호 조회중 오류 발생");
			}
		}
	}
	public Member search(String id) {
		try {
			Member member = dao.search(id);
			if(member == null) {
				throw new MemberException("등록되지 않은 회원 아이디 입니다.");
			}
			return member;
		}catch (Exception e) {
			e.printStackTrace();
			if(e instanceof MemberException) {
				throw (MemberException)e;
			}else {
				throw new MemberException("회원 번호 조회중 오류 발생");
			}
		}
	}
	public List<Member> searchAll(PageBean bean) {
		try {
			int total = dao.getCount(bean);
			PageUtility bar = new PageUtility(bean.getInterval(), total, bean.getPageNo(), "/images/");
			bean.setPageLink(bar.getPageBar());
			return dao.searchAll(bean);
		}catch (Exception e) {
			e.printStackTrace();
			if(e instanceof MemberException) {
				throw (MemberException)e;
			}else {
				throw new MemberException("회원 번호 조회중 오류 발생");
			}
		}	
	}
	public void insertMember(Member member) {
		try {
			dao.insertMember(member);
		}catch (Exception e) {
			e.printStackTrace();
			if(e instanceof MemberException) {
				throw (MemberException)e;
			}else {
				throw new MemberException("회원 정보 등록중 오류 발생");
			}
		}
	}
	public void updateMember(Member member) {
		try {
			dao.updateMember(member);
		}catch (Exception e) {
			e.printStackTrace();
			if(e instanceof MemberException) {
				throw (MemberException)e;
			}else {
				throw new MemberException("회원 정보 수정중 오류 발생");
			}
		}
	}
	public void deleteMember(String id) {
		try {
			dao.deleteMember(id);
		}catch (Exception e) {
			e.printStackTrace();
			if(e instanceof MemberException) {
				throw (MemberException)e;
			}else {
				throw new MemberException("회원 정보 삭제중 오류 발생");
			}
		}
	}
}
