package com.freyvik.springcourse.di.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.freyvik.springcourse.di.service.IService;

@Controller
public class IndexController {
	
	@Autowired
	@Qualifier("mainService")
	private IService service;

	@GetMapping({"", "/", "/index"})
	public String index(Model model) {
		model.addAttribute("objeto", service.operacion());
		
		return "index";
	}
}
