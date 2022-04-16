package com.freyvik.springcourse.di.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.freyvik.springcourse.di.service.MainService;

@Controller
public class IndexController {
	
	@Autowired
	private MainService service;

	@GetMapping({"", "/", "/index"})
	public String index(Model model) {
		model.addAttribute("objeto", service.operacion());
		
		return "index";
	}
}
