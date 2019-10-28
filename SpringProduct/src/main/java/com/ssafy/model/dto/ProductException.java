package com.ssafy.model.dto;

public class ProductException extends RuntimeException {
	public ProductException() {
		super("상품 정보 처리 중 오류 발생");
	}

	public ProductException(String msg) {
		super(msg);
	}
}
