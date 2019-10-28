package com.ssafy.pms.model.dao;

import java.util.List;

import com.ssafy.pms.model.dto.Phone;
import com.ssafy.pms.model.dto.UserInfo;

public interface PhoneDao {
	public void insert(Phone phone);
	public void delete(List<String> num);
	public Phone search(String num);
	public List<Phone> searchAll();
	public UserInfo findUser(String id);
}
