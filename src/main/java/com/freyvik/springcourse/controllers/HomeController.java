package com.freyvik.springcourse.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.freyvik.springcourse.models.Usuario;

@Controller
@RequestMapping("/app")
public class HomeController {

	@GetMapping("/index")
	public String index(ModelMap model) {
		model.addAttribute("titulo", "Nuevo titulo");
		model.addAttribute("h1Title", "Hello Spring");
		
		return "index";
	}
	
	@GetMapping({"/index2", "/", ""})
	public ModelAndView index(ModelAndView modelView) {
		modelView.addObject("titulo", "Nuevo titulo");
		modelView.addObject("h1Title", "Hello Spring con modelView");
		
		modelView.setViewName("index");
		return modelView;
	}
	
	@GetMapping("/perfil")
	public String perfil(Model model) {
		Usuario user = new Usuario();
		
		user.setNombre("Gonzalo");
		user.setApellido("Fuente");
		user.setEmail("gonzalo@gmail.com");
		
		model.addAttribute("usuario", user);
		return "perfil";
	}
	
	@GetMapping("/listar")
	public String listar(Model model) {
		
		return "listar";
	}
	
	/**
	 * Generate list of defined users to testing
	 * 
	 * @return Usuarios's list
	 * 
	 * <table border="1">
	 * 		<tr>
	 * 			<th>nombre</th>
	 * 			<th>apellido</th>
	 * 		</tr>
	 * 		<tr>
	 * 			<td>Gonzalo</th>
	 * 			<td>Fuente</th>
	 * 		</tr>
	 * </table>
	 * 
	 */
	@ModelAttribute("usuarios")
	public List<Usuario> poblar() {
		List<Usuario> users = new ArrayList<Usuario>();
		
		users.add(new Usuario("Gonzalo", "Fuente", "gonzalo@gmail.com"));
		users.add(new Usuario("Ismael", "Magnaleno", "ismael@gmail.com"));
		users.add(new Usuario("Chare", "Munoz", "chare@gmail.com"));
		
		return users;
	}
}
