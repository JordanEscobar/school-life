package com.schoollife.classbook.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.schoollife.classbook.Service.CursoService;

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
		return "Index";
	}

}
