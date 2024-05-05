package com.schoollife.classbook.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpSession;

@Controller
public class BaseController {
	
	//Inicio es el index
	@GetMapping("/iniciobase")
	public String inicioBase() {
		return "Index";
	}
	//Login 
	@GetMapping("/")
	public String login(Model model) {
		return "Login";
	}
	//Controlador para cerrar sesion y volver al login
	@GetMapping("/cerrarSesion")
	public String cerrarSesion(Model model,HttpSession sesion) throws ServletException {
		sesion.invalidate();
		return "redirect:/";
	}
	
	@PostMapping("/administrador/login")
	public String administradorLogin(Model model, HttpSession sesion) {
		String usuario = "admin";
		model.addAttribute("usuario",usuario);
		return "Index";
	}
	
	@PostMapping("/profesor/login")
	public String profesorLogin(Model model, HttpSession sesion) {
		String usuario = "profesor";
		model.addAttribute("usuario",usuario);
		return "Index";
	}
	
	@GetMapping("/administrador/login")
	public String administradorVolver(Model model, HttpSession sesion) {
		String usuario = "admin";
		model.addAttribute("usuario",usuario);
		return "Index";
	}
	
	@GetMapping("/profesor/login")
	public String profesorVolver(Model model, HttpSession sesion) {
		String usuario = "profesor";
		model.addAttribute("usuario",usuario);
		return "Index";
	}


	
	
	
	

}
