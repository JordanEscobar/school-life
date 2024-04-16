package com.schoollife.classbook.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.schoollife.classbook.Entities.Administrador;
import com.schoollife.classbook.Entities.Apoderado;
import com.schoollife.classbook.Entities.Profesor;
import com.schoollife.classbook.Service.ColegioService;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {
	
	@Autowired
	private final ColegioService colegioService;

	public HomeController(ColegioService colegioService) {
		super();
		this.colegioService = colegioService;
	}

	@GetMapping("/")
	public String index(Model model) {
		var listaColegios = colegioService.getAllColegios();		
		model.addAttribute("listaColegios",listaColegios);
		return "Index";
	}
	
	@GetMapping("/login")
	public String login(Model model) {
		String usuario = "";
		model.addAttribute("usuario",usuario);
		return "Login";
	}
	@GetMapping("/iniciarSesion")
	public String loginIniciarSesion(@Param(value = "usuario") String usuario, Model model) {
		String tipo_user = "";
		if(usuario == "admin") {
			tipo_user = "admin";
		}
		if(usuario == "profesor") {
			tipo_user = "profesor";
		}
		model.addAttribute("tipo_user",tipo_user);
		return "Index";
	}
	
	@GetMapping("/cerrarSesion")
	public String cerrarSesion(Model model,HttpSession sesion) throws ServletException {
		sesion.invalidate();
		return "redirect:/";
	}
}
