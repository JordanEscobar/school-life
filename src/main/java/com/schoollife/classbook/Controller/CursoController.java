package com.schoollife.classbook.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.schoollife.classbook.Entities.Curso;
import com.schoollife.classbook.Service.CursoService;
import com.schoollife.classbook.Service.EstudianteService;
import com.schoollife.classbook.Service.ProfesorService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class CursoController {
	@Autowired
	private final CursoService cursoS;
	@Autowired
	private final EstudianteService estudianteService;
	@Autowired
	private final ProfesorService profeS;
	
	
	public CursoController(CursoService cursoS, EstudianteService estudianteService, ProfesorService profeS) {
		super();
		this.cursoS = cursoS;
		this.estudianteService = estudianteService;
		this.profeS = profeS;
	}
	
	@GetMapping("/cursosModificar/{id}")
	public String editCurso(Curso curso, Model model, HttpSession sesion) {
		var profesores = profeS.profesorPorColegio(1);
		model.addAttribute("profesores", profesores);
		curso = cursoS.findCurso(curso);
		model.addAttribute("curso", curso);
		return "Editar-curso";
	}
	
	@PostMapping(path = "/administrador/curso/actualizado", consumes = "application/x-www-form-urlencoded")
	public String administradorCursoActualizado(@Valid Curso curso,Errors errores,RedirectAttributes flash, Model model,HttpSession sesion) {			
		Integer colegioid = 1;
		Curso c = new Curso();
		c.setColegio_id(colegioid);
		c.setEstado("activo");
		c.setGrado(curso.getGrado());
		c.setId(curso.getId());
		c.setProfesor_id(curso.getProfesor_id());
		c.setSeccion(curso.getSeccion());
		
		if (errores.hasErrors()) {
			var profesores = profeS.profesorPorColegio(1);
			model.addAttribute("profesores", profesores);
			return "Editar-curso";
		}
		cursoS.CreateCurso(c);              
		flash.addFlashAttribute("success","Curso modificado correctamente");
		return "redirect:/administrador/curso";
	}
	
	
}
