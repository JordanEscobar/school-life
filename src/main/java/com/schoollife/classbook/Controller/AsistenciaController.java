package com.schoollife.classbook.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.schoollife.classbook.Entities.Asistencia;
import com.schoollife.classbook.Service.AsistenciaService;
import com.schoollife.classbook.Service.CursoService;

import jakarta.servlet.http.HttpSession;

@Controller
public class AsistenciaController {
	
	@Autowired
	private final AsistenciaService asistenciaService;
	@Autowired
	private final CursoService cursoService;

	public AsistenciaController(AsistenciaService asistenciaService, CursoService cursoService) {
		super();
		this.asistenciaService = asistenciaService;
		this.cursoService = cursoService;
	}

	@GetMapping("/asistencia/listar/")
	public String asistenciaLista(Model model) {
		var listaAsistencia = asistenciaService.getAllAsistencias();
		var listaCurso = cursoService.getAllCurso();
		model.addAttribute("listaCurso",listaCurso);
		model.addAttribute("listaAsistencia",listaAsistencia);
		return "Index";
	}
	


}
