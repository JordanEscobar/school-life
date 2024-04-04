package com.schoollife.classbook.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.schoollife.classbook.Service.MatriculaService;


@Controller
public class MatriculaController {
	
	@Autowired
	private final MatriculaService matriculaService;

	public MatriculaController(MatriculaService matriculaService) {
		super();
		this.matriculaService = matriculaService;
	}

	@GetMapping("/matricula/listar/")
	public String matriculaLista(Model model) {
		var listaMatricula = matriculaService.getAllMatricula();
		model.addAttribute("listaMatricula",listaMatricula);
		return "Index";
	}

}
