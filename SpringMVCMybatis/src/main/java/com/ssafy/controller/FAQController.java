package com.ssafy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.model.dto.FAQ;
import com.ssafy.model.service.FAQService;

@Controller
public class FAQController {
	
	@Autowired
	private FAQService faqService;
	@ExceptionHandler
	public ModelAndView handler(Exception e) {
		ModelAndView mav = new ModelAndView("ErrorHandler");
		mav.addObject("msg",e.getMessage());
		return mav;
	}
	
	@GetMapping("faqInput.do")
	public String insertFAQForm() {
		return "faq/FAQInsert";
	}
	
	@PostMapping("faqInsert.do")
	public String faqInsert(FAQ faq) {
		faqService.insert(faq);
		return "redirect:faqList.do"; 
	}
	
	@GetMapping("faqList.do")
	public String faqList(Model model) {
		model.addAttribute("list",faqService.searchAll());
		return "faq/listFAQ";
		
	}
	
	
}
