package com.ssafy.model.dto;

public class FAQException extends RuntimeException {

	public FAQException() {}
	public FAQException(String msg) {
		super(msg);
	}

	
}

// 1기 때는 유저 로그인하나 FAQ 하나 두개 했었다.