package com.schoollife.classbook.Controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.schoollife.classbook.Entities.Curso;
import com.schoollife.classbook.Entities.Estudiante;
import com.schoollife.classbook.Service.EstudianteService;

import jakarta.servlet.http.HttpSession;


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
		
		List<Object> asistencias = new  ArrayList<Object>();
		asistencias.add(1);
		asistencias.add(2);
		asistencias.add(3);
		
		model.addAttribute("asistencias",asistencias);
		model.addAttribute("listaEstudiante",listaEstudiante);
		return "ListaEstudiante";
	}
	
	@GetMapping("/estudiante/curso/{id}")
	public String estudianteCurso(Curso curso,Model model) {
		var estudiantesCurso = estudianteService.getEstudianteByIdCurso(curso.getId());
		
		model.addAttribute("estudiantesCurso",estudiantesCurso);
		return "EstudianteCurso";
	}
	
	@PostMapping("/guardarAsistencia")
	public String guardarAsistencia(Model model, @RequestParam("asistencias") String asistencias) {
		model.addAttribute("asistencias",asistencias);
		return "asistenciaModulo";
	}
	

	

}
