package com.ssafy.pms.model.dto;

import java.io.Serializable;
public class UserInfo implements Serializable {
	private String id;
	private String pw;
	public UserInfo() {}
	public UserInfo(String id, String pw){
		super();
		this.id = id;
		this.pw = pw;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	
}
