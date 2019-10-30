package com.ssafy.pms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.pms.model.dto.Phone;
import com.ssafy.pms.model.service.PhoneService;

@Controller
public class PhoneController {
	@Autowired
	private PhoneService service;
	
	@ExceptionHandler
	public ModelAndView handler(Exception e) {
		ModelAndView mav = new ModelAndView("Error");
		mav.addObject("msg", e.getMessage());
		return mav;
	}
	
	@PostMapping("deletePhone.do")
	public String deletePhone(@RequestParam List<String> num) {
		service.delete(num);
		return "redirect:searchPhone.do";
	}

	@GetMapping("search.do")
	public String search(Model model, String num) {
		model.addAttribute("phone", service.search(num));
		return "pms/PhoneView";
	}
	@GetMapping("searchPhone.do")
	public String searchPhone(Model model) {
		model.addAttribute("list", service.searchAll());
		return "pms/PhoneList";
	}
	@GetMapping("regPhone.do")
	public String regPhone() {
		return "pms/PhoneReg";
	}
	
	@PostMapping("savePhone.do")
	public String savePhone(Phone phone) {
		service.insert(phone);
		return "redirect:Result.jsp";
	}
	
	
	

}







































