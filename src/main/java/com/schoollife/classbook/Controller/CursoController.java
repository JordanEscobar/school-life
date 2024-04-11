package com.schoollife.classbook.Controller;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	public String cursoLista(Model model, HttpSession sesion) {
		var listaCurso = cursoService.getAllCurso();
		model.addAttribute("listaCurso",listaCurso);
		return "Cursos";
	}
	
	@GetMapping("/desactivar/{id}")
	public String desactivarCurso(Curso curso,RedirectAttributes flash,Model model, HttpSession sesion) {

		var cursos = cursoService.getAllCurso();
		Curso c = new Curso();
		for (int i = 0; i < cursos.size(); i++) {
			if (cursos.get(i).getId()==curso.getId()) {				
				c.setId(cursos.get(i).getId());
				c.setEstado(cursos.get(i).getEstado());		
			}		
		}		
		cursoService.desactivarCurso(curso, curso.getId());
		flash.addFlashAttribute("success","Curso desactivado correctamente");
		return "redirect:/curso/listar/";	
	}
	
	@GetMapping("/activar/{id}")
	public String activarCurso(Curso curso,RedirectAttributes flash,Model model, HttpSession sesion) {

		var cursos = cursoService.getAllCurso();
		Curso c = new Curso();
		for (int i = 0; i < cursos.size(); i++) {
			if (cursos.get(i).getId()==curso.getId()) {				
				c.setId(cursos.get(i).getId());
				c.setEstado(cursos.get(i).getEstado());		
			}		
		}		
		cursoService.activarCurso(curso, curso.getId());
		flash.addFlashAttribute("success","Curso Activo correctamente");
		return "redirect:/curso/listar/";	
	}
	
	@GetMapping("/cursosModificar/{id}")
	public String cursoModificar(Curso curso, Model model) {
		curso = cursoService.findCurso(curso);
		model.addAttribute("curso", curso);
		return "CursosModificar";
	}
	@PostMapping(path = "/modificarCurso" /*, consumes = "application/x-ww-form-urlencoded"*/)
	public String modificarCurso(Curso curso,RedirectAttributes flash, Model model) {
		var cursos = cursoService.getAllCurso();
		Curso c = new Curso();
		for (int i = 0; i < cursos.size(); i++) {
			if (cursos.get(i).getId() == curso.getId()) {
				c.setId(cursos.get(i).getId());
				c.setCantidad(cursos.get(i).getCantidad());
				c.setEstado(cursos.get(i).getEstado());
				c.setNombre(cursos.get(i).getNombre());
				c.setProfesor_jefe(cursos.get(i).getProfesor_jefe());
				c.setSeccion(cursos.get(i).getSeccion());
			}
		}
		
		cursoService.updateCurso(curso, curso.getId());
		flash.addFlashAttribute("success","Modificado Correctamente");
		model.addAttribute("curso",curso);
		return "redirect:/curso/listar/";
	}
	
	@GetMapping("/cursoAtras")
	public String cursoAtras(Curso curso, Model model) {
		return "redirect:/curso/listar/";
	}
	


}
