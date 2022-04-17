package com.freyvik.springcourse.form.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.freyvik.springcourse.form.domain.Usuario;

@Controller
public class FormController {

	@GetMapping("/form")
	public String form(Model model) {
		model.addAttribute("title", "Form");
		model.addAttribute("usuario", new Usuario());
		
		return "form";
	}
	
	@PostMapping("/form")
	public String procesar(@Valid Usuario user, BindingResult result, Model model 
//			@RequestParam String username,
//			@RequestParam String password,
//			@RequestParam String email
			) {		
		// Getting values from @RequestParam
//		Usuario user = new Usuario(username, password, email);
		
		model.addAttribute("title", "Form resuelt");
		
		if (result.hasErrors()) {
			Map<String, String> errors = new HashMap<>();
			result.getFieldErrors().forEach(err -> {
				errors.put(err.getField(), "El campo '".concat(err.getField()).concat("' ").concat(err.getDefaultMessage()));
			});
			
			model.addAttribute("error", errors);			
			return "form";
		}		
		
		model.addAttribute("user", user);		
		return "resultado";
	}
}
