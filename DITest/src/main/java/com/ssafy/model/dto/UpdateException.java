package com.ssafy.model.dto;

public class UpdateException extends RuntimeException{
	public UpdateException() {}
	public UpdateException(String msg) {
		super(msg);
	}
}
