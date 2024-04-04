package com.schoollife.classbook.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.schoollife.classbook.Service.AsistenciaService;

@Controller
public class AsistenciaController {
	
	@Autowired
	private final AsistenciaService asistenciaService;

	public AsistenciaController(AsistenciaService asistenciaService) {
		super();
		this.asistenciaService = asistenciaService;
	}

	@GetMapping("/asistencia/listar/")
	public String asistenciaLista(Model model) {
		var listaAsistencia = asistenciaService.getAllAsistencias();
		model.addAttribute("listaAsistencia",listaAsistencia);
		return "Index";
	}

}
