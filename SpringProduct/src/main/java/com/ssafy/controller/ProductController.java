package com.ssafy.controller;

import java.util.Iterator;
import java.util.List;

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
	public ModelAndView handler(Exception e) {
		ModelAndView mav = new ModelAndView("ErrorHandler");
		mav.addObject("msg", e.getMessage());
		return mav;
	}
	
	@PostMapping("productInsert.do")
	public String productInsert(Product product) {
		service.insert(product);
		return "redirect:productList.do";
	}
	
	@GetMapping("productReg.do")
	public String productReg() {
		return "product/productReg";
	}
	
	@GetMapping("productList.do")
	public String ProductList(Model model) {
		model.addAttribute("list", service.searchAll());
		return "product/productList";
	}
	
}
