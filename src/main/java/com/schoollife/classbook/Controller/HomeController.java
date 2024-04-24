package com.schoollife.classbook.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.schoollife.classbook.Service.ColegioService;

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
		
		String profe = "profesor";
		String admin = "administrador";
		model.addAttribute("profe", profe);
		model.addAttribute("admin", admin);
		return "Index";
	}
	
	@GetMapping("/inicio")
	public String funcionalidades(Model model) {
		var colegios = colegioService.getAll();
		model.addAttribute("colegios", colegios);
		return "Funcionalidades";
	}
	
	@GetMapping("/inicio/perfil")
	public String funcionalidadesIndex(Model model) {
		var colegios = colegioService.getAll();
		model.addAttribute("colegios", colegios);
		return "Funcionalidades-index";
	}
	
	@GetMapping("/profesor")
	public String indexProfesor(Model model) {
		var colegios = colegioService.getAll();
		model.addAttribute("colegios", colegios);
		return "Index-profesor";
	}
	
	@GetMapping("/administrador")
	public String indexAdministrador(Model model) {
		var colegios = colegioService.getAll();
		model.addAttribute("colegios", colegios);
		return "Index-administrador";
	}

}
