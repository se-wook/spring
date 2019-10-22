package com.ssafy.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.dto.Board;


/**
 * @Controller -> 어노테이션은 걔랑 연결된 java 클래스가 수행되는 거임. -> 
 * 	 - bean으로 등록하는 Annotation
 *   - Controller 역할을 하는 클래스로  bean이 등록됨.  
 */
@Controller // bean + controller 로 등록해버린거임.
public class MainController {
	
	/**
 * 		@RequestMapping
	 * 		1. 요청 처리 등록
	 * 			HandlerMapper에 요청 URL을  Key로 해서 처리할 함수를 value로 등록.
	 * 		
	 * 		    형식]
	 * 			@RequestMapping(value=url, method=전송방식)
	 * 				method = RequestMethod.GET ==> 생략시 모든 전송 방식을 지원.
	 * 
     * 				- spring ver 4.xx 부터 변경점.	=> pom.xml 에서 spring version 변경이 가능하다.
     * 					@GetMapping(value=url)  => GET 방식 요청을 처리.
     *					@PostMapping(value=url) => POST 방식 요청을 처리. 
     *			1.1 GET 방식 처리 예제
     *
     *		2. 인자   - 요청 데이터 처리
     *			2.1 String 타입
     *				- 인자명으로 요청 데이터를 추출
     *				  String 인자명 = request.getParameter("인자명");
     *				- 요청 데이터 이름으로 데이터가 전송되지 않았거나
     *				    요청 패킷에 데이터명이 없어도 error가 발생하지 않는다.
     *
	 * 			2.2 Primitive 타입
     *				- 인자명으로 요청 데이터를 추출
     *				  ex) int 인자명 = Integer.parseInt(request.getParameter("인자명"));
     *				- 요청 데이터 이름으로 데이터가 전송되지 않았거나 (500 ERROR)
     *				    요청 패킷에 데이터명이 없으면 error가 발생한다. (404 ERROR)
     *
     * 			2.3 @RequestParam String or Primitive 타입
     * 				- 형식]
     * 					@RequestParam(value='요청데이터명' [, required][, defaultValue])
     * 						value
     * 							- 요청데이터명
     * 							- 생략하면 인자명으로 요청 데이터를 추출.
     *						required
     *							- true 면 요청 데이터가 없는 경우 error를 발생시킬 수 있다. ==> String에서 에러 발생시킬 수 있다.
     *						defaultValue
     *							- 요청 데이터가 없는 경우 기본 값으로 사용된다.
     *
     *			2.4 DTO(Data Transfer Object)
     *				- DTO 에 해당하는 객체를 생성 후 요청 패킷에서 속성에 해당하는 모든 요청 데이터를 추출해서
     *				  객체에 setter 메소드를 호출해서 설정한다.
     *				- request에 ****첫글자가 소문자인 클래스명****으로 저장
     * 				- 기본 생성자 있어야됨.
     *
     *				ex) Board board
     *					 
     *					Board board = new Board();
     *					board.setNo(Integer.parseInt(request.getParameter("no")));
     *					board.setTitle(request.getParameter("title"));
     *					board.setId(request.getParameter("id"));
     *					board.setRegdate(request.getParameter("regdate"));
     *					board.setContents(request.getParameter("content"));
     *					request.setAttribute("board",board);
     *					
     *			2.5 @ModelAttribute("이름") DTO
     *				- DTO에 해당하는 객체를 생성 후 요청 패킷에서 속성에 해당하는 모든 요청 데이터를 추출해서
     *				    객체에 setter 메소드를 호출해서 설정한다.
     *				- request에 ****지정한 이름****으로 저장 ==> 클래스 이름이 길면 이거사용하면된다!
     *					
     * 			2.6 @RequestParam Map
     * 				- request에 있는 모든 요청 데이터를 추출해서 Map에 
     * 				    요청 이름이 key가 돼서 요청 데이터를 저장한다.  	
     * 
     * 			2.7 Model
     * 				- Model은 interface이기 때문에 직접 생성할 수 없고, 인자로만 받는다.
     * 				- 모델 수행한 결과를 저장하면 request에 저장한다.	==> Model.addAttribute("이름", );
     * 			
     * 			2.8 Servlet API
     * 				- HttpServletRequest, HttpServletResponse, HttpSession, Reader, Writer
     * 				  ,ServletInputStream, ServletOutputStream...
     * 
     * 				단) ServletContext는 servlet 모듈 2.5버전(pom.xml에서 확인 <servlet.version>~)에서 인자로 받을 수 없다.
     * 					3.x 부터는 가능하다.
     * 			
     * 			2.9 MultipartFile
     * 				- 업로드된 파일 정보를 위한 타입
     * 				- pom.xml에 라이브러리 추가
     * 					commons-io-xxx.jar
     * 					commons-fileupload-xxx.jar --> xxx 는 해당 버전
     * 				- web을 위한 bean configuration에서 MultipartResolver를 추가한다.
     * 				  MultipartResolver는 요청 데이터에서 파일 정보만 추출해서 MultipartFile이 객체로 전달
     * 
     * 		3. 리턴
     * 			- view에 관한 정보	
     * 			3.1 String
     * 				- 이동할 view에 대한 url을 문자로
     * 				  forward : "forward:[url~]"
     *							"[url]"만 줘도 default는 forward임.
     *				  redirect : "redirect:[url~]" 														
     *			3.2 Void
     *				- 요청 url 에서 .(점) 이후를 제거한 이름을 View 이름으로 인식한다.
     *				- ViewResolver를 설정해서 view 이름을 완성해야 한다.
     *
     *			3.3 ModelAndView
     *				- view 정보와 모델을 수행한 결과를 위한 타입
     *				
     * 			3.4 DTO 또는 Map 이나 집합 객체(배열,  List)를 
     * 				- URL을 통해 View로 이동하지 않고 직접 View를 생성해서 출력
     * 				- @ResponseBody를 추가 해 줘야됨 ==> url로 이동하지 않고 직접 view를 출력하겠다는 뜻
     * 				- RESTful 서비스를 위한 객체 정보 JSON or XML 로 출력
     * 				- <mvc:annotation-driven/> 이 반드시 선언되어야 한다. -> annotation을 쓰기위한 코드.
     * 	
     * 		4. 예외처리
     * 			4.1 Controller에서 발생하는 오류를 공통으로 처리하기
     * 				@ExceptionHandler 
     * 				[처리 함수 작성]
     * 
     * 
     * 
     * 
     */			
	
//	@RequestMapping("hello.do") // 기본 value = "hello.do"  [(+a) : 다른속성들]
	//1.1 예제
//	@GetMapping("hello.do")
//	public String hello() {
//		return "hello.jsp"; // forward
//	}
	
	//2.1 예제
//	@GetMapping("hello.do")
//	public String Hello(String msg) {
//		System.out.println("전송 데이터 : " + msg);
//		return "hello.jsp";
//	}
	
	//2.2 예제
//	@GetMapping("hello.do")
//	public String Hello(int msg) {
//		System.out.println("전송 데이터 : " + msg);
//		return "hello.jsp";
//	}
	
	//2.3 예제
//	@GetMapping("hello.do")
//	public String Hello(@RequestParam(required=true) String msg) {
//		System.out.println("전송 데이터 : " + msg);
//		return "hello.jsp";
//	}
	
	//2.3 -2
//	@GetMapping("hello.do")
//	public String Hello(@RequestParam(defaultValue="500") int msg) {
//		System.out.println("전송 데이터 : " + msg);
//		return "hello.jsp";
//	}
	
	//2.4 DTO 인자로 받기
//	@PostMapping("insertBoard.log")
//	public String insertBoard(Board board) {
//		System.out.println("board .... " + board);
//		return "searchBoard.jsp";
//	}
	
	//2.5 @ModelAttribute("이름")
//	@PostMapping("insertBoard.log")
//	public String insertBoard(@ModelAttribute("b") Board board) {
//		System.out.println("board ..... " + board);
//		return "searchBoard2.jsp";
//	}
	
	//2.6 @RequestParam Map
//	@PostMapping("insertBoard.log")
//	public String insertBoard(@RequestParam Map<String, String> map, HttpServletRequest request) {
//		System.out.println("board!! ..... " + map);
//		// request에 저장하는 작업이 필요하다.
//		request.setAttribute("board", map);
//		return "searchBoard.jsp";
//	}
	
	//2.7 Model을 인자로 사용
//	@PostMapping("insertBoard.log")
//	public String insertBoard(@RequestParam Map<String, String> map, Model model) {
//		System.out.println("board!! ..... " + map);
//		model.addAttribute("board",map); // request에 저장한 효과
//		return "searchBoard.jsp";
//	}
	
	//3.2 Void 리턴타입
	// 주의점. mvc-config.xml 에서  InternalResourceViewResolver 설정 (-> 경로 설정했었다.) 해야 한다.
//	@GetMapping("showMessage.do")
//	public void showMessage(String msg, Model model) {
//		model.addAttribute("message",msg); // 기본 forward로 이동한다.
//	}
	
	//4.1 
	@ExceptionHandler
	public ModelAndView handler(Exception e) { // 인자가 다른게 들어오면 안됨.
//		ModelAndView(String viewName)
		
		ModelAndView mav = new ModelAndView("ErrorHandler.jsp");
		mav.addObject("msg",e.getMessage()); // request에 저장.
		return mav;
		
	}
	
	@GetMapping("error.do")
	public String error(int price) {
		System.out.printf("결과 : %d", 500/price);
		return "result.jsp";
	}
}
