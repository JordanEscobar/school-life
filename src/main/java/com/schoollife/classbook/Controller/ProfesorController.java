package com.schoollife.classbook.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.schoollife.classbook.Service.ProfesorService;


@Controller
public class ProfesorController {
	
	@Autowired
	private final ProfesorService profesorService;

	public ProfesorController(ProfesorService profesorService) {
		super();
		this.profesorService = profesorService;
	}

	@GetMapping("/profesor/listar/")
	public String profesorLista(Model model) {
		var listaProfesor = profesorService.getAllProfesor();
		model.addAttribute("listaProfesor",listaProfesor);
		return "Index";
	}

}
