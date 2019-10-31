package com.ssafy.pms.model.dto;

public class ProductException extends RuntimeException {
	public ProductException() {}
	public ProductException(String msg) {
		super(msg);
	}
}
