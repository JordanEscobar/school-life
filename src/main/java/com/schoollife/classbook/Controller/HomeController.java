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
import com.schoollife.classbook.Service.LoginService;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {
	
	@Autowired
	private final ColegioService colegioService;
	
	@Autowired
	private final LoginService loginService;

	public HomeController(ColegioService colegioService, LoginService loginService) {
		super();
		this.colegioService = colegioService;
		this.loginService = loginService;
	}

	@GetMapping("/")
	public String index(Model model) {
		var listaColegios = colegioService.getAllColegios();		
		model.addAttribute("listaColegios",listaColegios);
		return "Index";
	}
	
	@GetMapping("/iniciarSesion")
	public String iniciarSesion(@Param("usuario") String usuario,@Param("contrasena") String contrasena, Model model) {
		String usuario_logeado = loginService.loginPrueba(usuario, contrasena);
		model.addAttribute("usuario_logeado",usuario_logeado);	
		return "Index";
	}
	
	@GetMapping("/login")
	public String login(Model model) {
		return "Login";
	}
	
	@GetMapping("/asistenciaIndex")
	public String asistenciaIndex(Model model) {
		return "AsistenciaIndex";
	}

	
	@GetMapping("/cerrarSesion")
	public String cerrarSesion(Model model,HttpSession sesion) throws ServletException {
		sesion.invalidate();
		return "redirect:/";
	}
}
