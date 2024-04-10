package com.schoollife.classbook.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.schoollife.classbook.Entities.Asignatura;
import com.schoollife.classbook.Service.AsignaturaService;

import jakarta.servlet.http.HttpSession;

@Controller
public class AsignaturaController {
	
	@Autowired
	private final AsignaturaService asignaturaService;

	public AsignaturaController(AsignaturaService asignaturaService) {
		super();
		this.asignaturaService = asignaturaService;
	}

	@GetMapping("/asignatura/listar/")
	public String asignaturaLista(Model model) {
		var listaAsignatura = asignaturaService.getAllAsignaturas();
		model.addAttribute("listaAsignatura",listaAsignatura);
		return "Index";
	}
	


}
