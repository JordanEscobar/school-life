package com.schoollife.web.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.schoollife.web.Entities.Curso;
import com.schoollife.web.Service.CursoService;
import com.schoollife.web.Service.EstablecimientoService;

import jakarta.validation.Valid;

@Controller
public class CursoController {
	
	@Autowired
	private final CursoService cursoS;
	@Autowired
	private final EstablecimientoService establecimientoS;
	
	public CursoController(CursoService cursoS, EstablecimientoService establecimientoS) {
		super();
		this.cursoS = cursoS;
		this.establecimientoS = establecimientoS;
	}

	
	@GetMapping("/curso")
	public String indexCurso(Model model) {
		var cursos = cursoS.getAll(4717);
		//var establecimientos = establecimientoS.getAll();
		
		return "Curso";
	}
	
	@GetMapping("/curso/ingresar")
	public String cursoAgregar(Curso curso,Model model)
	{
				
		var establecimientos = establecimientoS.getAll();
		model.addAttribute("establecimientos", establecimientos);
		model.addAttribute("curso",curso);
		return "Curso-ingresar"; 
	}
	
	@PostMapping(path = "/curso/ingresado", consumes = "application/x-www-form-urlencoded")
	public String cursoIngresado(@Valid Curso curso,Errors errores,RedirectAttributes flash,Model model)
	{
		var establecimientos = establecimientoS.getAll();
		model.addAttribute("establecimientos", establecimientos);
		Curso c = new Curso();
		c.setApodo(curso.getApodo());
		c.setCapacidad(curso.getCapacidad());
		c.setEstablecimiento_id(curso.getEstablecimiento_id());
		c.setId_curso(curso.getId_curso());
		c.setJornada(curso.getJornada());
		c.setLetra(curso.getLetra());
		c.setLocal(curso.getLocal());
		c.setNivel(curso.getNivel());
		c.setNivel_ensenanza(curso.getNivel_ensenanza());
		c.setNumero_sala(curso.getNumero_sala());
		
		if (errores.hasErrors()) {
			return "Curso-ingresar";
		}	
		cursoS.CreateCurso(c);
		flash.addFlashAttribute("success","Curso ingresado correctamente");
		model.addAttribute("curso",c);
		return "redirect:/"; 
	}

}
