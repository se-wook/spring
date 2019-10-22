package com.ssafy.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class TimeAop {
	/**
	 * 
	 * [Around 작성 시 주의점]
	 * 
	 * @param jp 	Aspect와 연결될 핵심 모듈의 메소드 이름, 인자를 추출할 메소드와
	 * 				핵심 모듈을 수행할 메소드가 있다.
	 * 
	 * @return		핵심 모듈을 수행한 결과를 리턴해야 
	 * 				핵심 모듈을 호출한 곳으로 결과가 전달된다.
	 */
	@Around("execution( * com.ssafy.model.service.*ServiceImp*.search*(..))") // point cut으로 등록된거임.
	public Object calcTime(ProceedingJoinPoint jp) {
		
		long startTime = System.currentTimeMillis();
		
		try {
			/*핵심 모듈 호출 
			 * proceed() : 
			 * 	- 핵심 모듈을 호출한 곳에서 전달한 인자를 이용해서 핵심 모듈을 호출
			 * proceed(Object[] args) : 
			 * 	- 지정한 인자를 이용해서 핵심 모듈을 호출 
			 * */
			return jp.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		} finally {
			long endTime = System.currentTimeMillis();
			System.out.println("=====================수행 시간 구하기=====================");
			System.out.println("수행한 함수 : " + jp.getSignature()); // 클래스 이름, 메소드 이름
			System.out.printf("수행시간 : %dms\n",endTime-startTime);
			System.out.println("=====================================================");
		}
		
		return null;
	}
}
