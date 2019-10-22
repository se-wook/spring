package com.ssafy.spring;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ssafy.model.dto.Board;

public class DITest1 {

	public static void main(String[] args) {
		/** 지정한 xml을 분석해서 xml 등록한 bean을 생성한다. **/
		BeanFactory con = new ClassPathXmlApplicationContext("com/ssafy/config/beans1.xml");
		
		
		
		System.out.println("Spring Container 구성 완료");
		
		/*
		 * getBean(String name) : id 또는 name에 해당하는 객체를 컨테이너에서 찾아서 리턴
		 */
//		Board board1 = (Board) con.getBean("board"); 
//		Board board2 = (Board) con.getBean("board");
		
		/*
		 * getBean(Class type) : 
		 * 		- SpringContainer 에서 설정한 타입과 동일한 객체를 추출
		 * 		- 동일한 타입의 객체가 2개 이상 설정된 경우 error발생 -> beans1.xml에서 같은 class가 있으면 error
		 * 		- 형 변환 없이 추출이 가능하다는 장점
		 */
//		Board board1 = con.getBean(Board.class);
		
		
		/*
		 * getBean(String name, Class type) : 
		 * 		- id 또는 name에 해당하는 객체를 컨테이너에서 찾아서 "지정한 타입으로" 리턴
		 * 		- 형변환 없이 추출이 가능
		 */
		Board board1 = con.getBean("board",Board.class);
		System.out.println(board1.hashCode());
//		System.out.println(board2.hashCode());
	}

}
