package com.freyvik.springcourse.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/params")
public class ParamsController {
	
	@Value("${ver.title}")
	private String verTitle;
	
	@Value("${index.title}")
	private String indexTitle;
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("title", indexTitle);
		
		return "params/index";
	}

	@GetMapping("/string")
	public String param(@RequestParam(defaultValue = "") String texto, Model model) {
		model.addAttribute("title", verTitle);
		model.addAttribute("resultado", "El texto enviado es: " + texto);
		
		return "params/ver";
	}
}
