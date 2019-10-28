package com.ssafy.controller;

import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.model.dto.Product;
import com.ssafy.model.service.ProductService;

@Controller
public class ProductController {
	@Autowired
	private ProductService service;
	@ExceptionHandler
	public ModelAndView  handler(Exception e) {
		ModelAndView mav = new ModelAndView("ErrorHandler");
		mav.addObject("msg",e.getMessage());
		return mav;
	}
	
	@GetMapping("productInput.do")
	public String insertFAQForm() {
		return "product/insertProduct";
	}
	@PostMapping("productInsert.do")
	public String faqInsert(Product faq) {
		service.insert(faq);
		return "redirect:productList.do";
	}
	@GetMapping("productList.do")
	public String faqList(Model  model) {
		model.addAttribute("list", service.searchAll());
		return "product/listProduct";
	}
}















