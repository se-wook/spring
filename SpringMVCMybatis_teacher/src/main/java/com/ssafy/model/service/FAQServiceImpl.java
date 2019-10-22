package com.ssafy.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.model.dao.FAQDao;
import com.ssafy.model.dto.FAQ;
import com.ssafy.model.dto.FAQException;

@Service
public class FAQServiceImpl implements FAQService {
	
	@Autowired
	private FAQDao  dao;
	public FAQ search(String no) {
		try {
			return dao.search(no);
		} catch (Exception e) {
			e.printStackTrace();
			throw new FAQException("FAQ 조회 중 오류 발생");
		}
	}
	public List<FAQ> searchAll() {
		try {
			return dao.searchAll();
		} catch (Exception e) {
			e.printStackTrace();
			throw new FAQException("FAQ 목록 조회 중 오류 발생");
		}
	}
	public void insert(FAQ faq) {
		try {
			dao.insert(faq);
		} catch (Exception e) {
			e.printStackTrace();
			throw new FAQException("질문을 등록 중 오류 발생");
		}
	}
	public void update(FAQ faq) {
		try {
			dao.update(faq);
		} catch (Exception e) {
			e.printStackTrace();
			throw new FAQException("질문을 수정 중 오류 발생");
		}
	}
	public void reply(FAQ faq) {
		try {
			dao.reply(faq);
		} catch (Exception e) {
			e.printStackTrace();
			throw new FAQException("답변을 작성 중 오류 발생");
		}
	}
	public void delete(String no) {
		try {
			dao.delete(no);
		} catch (Exception e) {
			e.printStackTrace();
			throw new FAQException("FAQ 삭제 중 오류 발생");
		}
	}

}
