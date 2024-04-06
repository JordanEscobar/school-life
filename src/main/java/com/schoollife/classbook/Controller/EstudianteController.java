package com.schoollife.classbook.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.schoollife.classbook.Service.EstudianteService;


@Controller
public class EstudianteController {
	
	@Autowired
	private final EstudianteService estudianteService;

	public EstudianteController(EstudianteService estudianteService) {
		super();
		this.estudianteService = estudianteService;
	}

	@GetMapping("/estudiante/listar/")
	public String estudianteLista(Model model) {
		var listaEstudiante = estudianteService.getAllEstudiante();
		model.addAttribute("listaEstudiante",listaEstudiante);
		return "ListaEstudiante";
	}

}
