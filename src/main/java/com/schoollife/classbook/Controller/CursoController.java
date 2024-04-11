package com.schoollife.classbook.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.schoollife.classbook.Entities.Curso;
import com.schoollife.classbook.Service.CursoService;

import jakarta.servlet.http.HttpSession;

@Controller
public class CursoController {
	
	@Autowired
	private final CursoService cursoService;

	public CursoController(CursoService cursoService) {
		super();
		this.cursoService = cursoService;
	}

	@GetMapping("/curso/listar/")
	public String cursoLista(Model model) {
		var listaCurso = cursoService.getAllCurso();
		model.addAttribute("listaCurso",listaCurso);
		return "Cursos";
	}
	
	@GetMapping("/eliminar/{id}/")
	public String eliminarCurso(Curso curso,HttpSession sesion) {
		if(sesion!=null) {
			if(curso!=null ) {
				cursoService.deleteCurso(curso.getId());	
			}
		}
		return "redirect:/";
	}
	


}
