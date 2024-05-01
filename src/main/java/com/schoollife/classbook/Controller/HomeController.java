package com.schoollife.classbook.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
	
	@GetMapping("/home")
	public String funcionalidadesIndex(Model model) {
		var colegios = colegioService.getAll();
		model.addAttribute("colegios", colegios);
		return "Home";
	}	
	
	@GetMapping("/matricula")
	public String Matricula(Model model) {
		return "Matricula";
	}
	
	@GetMapping("/matricula/estudiante")
	public String MatriculaRegistro(Model model) {
		return "Matricula-registro";
	}

}
