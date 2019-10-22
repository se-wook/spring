package com.ssafy.spring;

import java.util.Map;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ssafy.model.dto.PageBean;
import com.ssafy.model.service.BoardService;
import com.ssafy.model.service.MemberService;

public class DITest {

	public static void main(String[] args) {
		BeanFactory con = new ClassPathXmlApplicationContext("com/ssafy/config/beans3.xml");
		
		BoardService boardService = con.getBean(BoardService.class);
		System.out.println(boardService.search("1"));
		
		
		PageBean bean = new PageBean("all", null,1);
		Map<String, Object> map = boardService.searchAll(bean);

		MemberService memService = con.getBean(MemberService.class);
		System.out.println(memService.search("ssafy"));
		
	}

}
