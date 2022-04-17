package com.freyvik.springcourse.form.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.freyvik.springcourse.form.domain.Usuario;

@Controller
@SessionAttributes("usuario")
public class FormController {

	@GetMapping("/form")
	public String form(Model model) {
		Usuario usuario = new Usuario();
		usuario.setNombre("Marta");
		usuario.setApellido("Urzanqui");
		
		// Without @SessionAttributes this field will be clean on the form http request
		usuario.setIdentificador("1234567A");
				
		model.addAttribute("title", "Form");
		model.addAttribute("usuario", usuario);
		
		return "form";
	}
	
	@PostMapping("/form")
	public String procesar(@Valid Usuario usuario, BindingResult result, Model model, SessionStatus status
//			@RequestParam String username,
//			@RequestParam String password,
//			@RequestParam String email
			) {		
		// Getting values from @RequestParam
//		Usuario user = new Usuario(username, password, email);
		
		model.addAttribute("title", "Form resuelt");
		
		if (result.hasErrors()) {
			
			return "form";
		}
		
		/* --- Manual errors usage
		if (result.hasErrors()) {
			Map<String, String> errors = new HashMap<>();
			result.getFieldErrors().forEach(err -> {
				errors.put(err.getField(), "El campo '".concat(err.getField()).concat("' ").concat(err.getDefaultMessage()));
			});
			
			model.addAttribute("error", errors);			
			return "form";
		}*/
				
		model.addAttribute("usuario", usuario);	
		status.setComplete();	// Clean the @SeessionsAttributes
		return "resultado";
	}
}
