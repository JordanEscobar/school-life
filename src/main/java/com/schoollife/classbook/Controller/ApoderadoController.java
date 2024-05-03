package com.schoollife.classbook.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.schoollife.classbook.Entities.Estudiante;
import com.schoollife.classbook.Service.ApoderadoService;

import jakarta.servlet.http.HttpSession;

@Controller
public class ApoderadoController {
	@Autowired
	private final ApoderadoService apoderadoService;

	public ApoderadoController(ApoderadoService apoderadoService) {
		super();
		this.apoderadoService = apoderadoService;
	}
	
	@GetMapping("/apoderado/{id}")
	public String apoderadoAlumno(Estudiante estudiante, Model model, HttpSession sesion) {
		var apoderado = apoderadoService.apoderadoPorEstudiante(estudiante.getId());
		model.addAttribute("apoderado", apoderado);
		return "Home";
	}

}
