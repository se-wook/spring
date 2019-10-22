package com.ssafy.spring;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ssafy.model.dto.Board;

public class DITest3 {

	public static void main(String[] args) {
		/** 지정한 xml을 분석해서 xml 등록한 bean을 생성한다. **/
		BeanFactory con = new ClassPathXmlApplicationContext("com/ssafy/config/beans3.xml");
		
		
		
		System.out.println("Spring Container 구성 완료");
		Board board1 = con.getBean("board",Board.class);
		System.out.println(board1);
		
		Board board2 = con.getBean("board2",Board.class);
		System.out.println(board2);
	}

}
