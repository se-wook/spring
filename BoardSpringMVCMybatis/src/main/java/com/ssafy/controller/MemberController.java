package com.ssafy.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.model.service.MemberService;

@Controller
public class MemberController {
	@Autowired
	private MemberService memberService;
	
	@ExceptionHandler
	public ModelAndView handler(Exception e) {
		ModelAndView mav = new ModelAndView("ErrorHandler");
		mav.addObject("msg",e.getMessage());
		return mav;
	}
	
	@GetMapping("loginform.do")
	public String loginForm() {
		return "member/login";
	}
	
	@PostMapping("login.do")
	public String login(String id, String pw, HttpSession session, Model model) {
		try {
			System.out.println(id + " " + pw);
			memberService.login(id, pw);
			// 인증 정보 저장
			session.setAttribute("id",id);
			
			return "redirect:index.jsp";
		}catch (Exception e) {
			model.addAttribute("msg",e.getMessage());
			return "member/login";
		}
	}
	
	@GetMapping("logout.do")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:loginform.do";
	}
}
