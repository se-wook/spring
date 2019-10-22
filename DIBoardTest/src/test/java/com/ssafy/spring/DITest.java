package com.ssafy.spring;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ssafy.model.service.BoardService;

public class DITest {

	public static void main(String[] args) {
		BeanFactory con = new ClassPathXmlApplicationContext("com/ssafy/config/beans3.xml");
		
		BoardService boardService = con.getBean(BoardService.class);
		System.out.println(boardService.search("1"));
	}

}
