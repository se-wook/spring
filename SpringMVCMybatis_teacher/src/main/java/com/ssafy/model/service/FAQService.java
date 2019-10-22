package com.ssafy.model.service;

import java.util.List;

import com.ssafy.model.dto.FAQ;

public interface FAQService {
	public FAQ search(String no);
	public List<FAQ> searchAll();
	public void insert(FAQ faq);
	public void update(FAQ faq);
	public void reply(FAQ faq);
	public void delete(String no);
}
