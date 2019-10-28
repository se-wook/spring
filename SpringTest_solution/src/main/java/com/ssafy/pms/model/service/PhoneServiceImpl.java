package com.ssafy.pms.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.pms.model.dao.PhoneDao;
import com.ssafy.pms.model.dto.Phone;
import com.ssafy.pms.model.dto.PhoneException;
import com.ssafy.pms.model.dto.UserInfo;

@Service
public class PhoneServiceImpl implements PhoneService {
	@Autowired
	private PhoneDao dao;
	
	@Override
	public void insert(Phone phone) {
		try {
			dao.insert(phone);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PhoneException("저장 중 오류가 발생했습니다.");
		}
	}

	@Override
	public void delete(List<String> num) {
		try {
			dao.delete(num);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PhoneException("삭제 중 오류가 발생했습니다.");
		}
	}

	@Override
	public Phone search(String num) {
		try {
			return dao.search(num);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PhoneException("검색 중 오류가 발생했습니다.");
		}
	}

	@Override
	public List<Phone> searchAll() {
		try {
			return dao.searchAll();
		} catch (Exception e) {
			e.printStackTrace();
			throw new PhoneException("검색 중 오류가 발생했습니다.");
		}
	}

	@Override
	public boolean login(String id, String pw) {
		try {
			UserInfo user = dao.findUser(id);
			if(user == null) {
				throw new PhoneException("등록된 아이디가 아닙니다.");
			}
			if(pw == null || !pw.equals(user.getPw())) {
				throw new PhoneException("비밀번호 오류.");
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			if(e instanceof PhoneException) {
				throw e;
			}else {
				throw new PhoneException("검색 중 오류가 발생했습니다.");
			}
		}
	}

}
