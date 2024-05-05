package com.schoollife.classbook.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.schoollife.classbook.Entities.Curso;
import com.schoollife.classbook.Entities.Estudiante;
import com.schoollife.classbook.Service.CursoService;
import com.schoollife.classbook.Service.EstudianteService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class CursoController {
	@Autowired
	private final CursoService cursoService;
	@Autowired
	private final EstudianteService estudianteService;
	
	public CursoController(CursoService cursoService, EstudianteService estudianteService) {
		super();
		this.cursoService = cursoService;
		this.estudianteService = estudianteService;
	}
	
	@GetMapping("/cursosModificar/{id}")
	public String editCurso(Curso curso, Model model, HttpSession sesion) {
		curso = cursoService.findCurso(curso);
		model.addAttribute("curso", curso);
		return "Editar-curso";
	}
	
	
}
