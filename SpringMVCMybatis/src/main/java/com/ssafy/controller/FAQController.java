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
	
	@GetMapping("searchFaq.do")
	public String search(String no, Model model) {
		model.addAttribute("faq",faqService.search(no));
		return "faq/searchFAQ";
	}
	
	@GetMapping("updateFaqForm.do")
	public String updateFaqForm(String no, Model model) {
		model.addAttribute("faq",faqService.search(no));
		return "faq/updateFAQ";
	}
	
	@GetMapping("deleteFaq.do")
	public String deleteFaq(String no, Model model) {
		faqService.delete(no);
		return "redirect:faqList.do";
	}
	
	@PostMapping("updateFaq.do")
	public String updateFaq(FAQ faq, Model model) {
		faqService.update(faq);
		return "redirect:faqList.do";
	}
}
