package com.ssafy.pms.model.service;

import java.util.List;

import com.ssafy.pms.model.dto.Phone;
import com.ssafy.pms.model.dto.UserInfo;

public interface PhoneService {
	public void 	insert(Phone phone);
	public void 	delete(List<String> num);
	public Phone	search(String num);
	public List<Phone>	searchAll();
	public boolean login(String id, String pw);
}










