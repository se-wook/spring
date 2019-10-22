package com.ssafy.aop;

import org.aspectj.lang.JoinPoint;

public class HelloAop {
	public void hello(JoinPoint jp) {
		System.out.println("AOP TEST ==============^오^============ helloworld");
	}
}
