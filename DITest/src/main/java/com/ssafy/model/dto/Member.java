package com.ssafy.model.dto;

import java.io.Serializable;

public class Member implements Serializable {
	private String id;
	private String password;
	private String name;
	private String email;
	private String address;
	/**탈퇴 여부 Y: 탈퇴 N:회원*/
	private String withdraw;
	public Member() {}
	public Member(String id, String password, String name, String email, String address) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.email = email;
		this.address = address;
	}
	public Member(String id, String password, String name, String email, String address, String withdraw) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.email = email;
		this.address = address;
		this.withdraw = withdraw;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getWithdraw() {
		return withdraw;
	}
	public void setWithdraw(String withdraw) {
		this.withdraw = withdraw;
	}
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Member [id=").append(id).append(", password=").append(password).append(", name=").append(name)
				.append(", email=").append(email).append(", address=").append(address).append(", withdraw=")
				.append(withdraw).append("]");
		return builder.toString();
	}
	
}













