package com.ssafy.model.dao;

import java.util.List;

import com.ssafy.model.dto.FAQ;

public interface FAQDao {
	public FAQ search(String no);  
	public List<FAQ> searchall();
	public void insert(FAQ faq);
	public void update(FAQ faq);
	public void reply(FAQ faq);
	public void delete(String no);
}
