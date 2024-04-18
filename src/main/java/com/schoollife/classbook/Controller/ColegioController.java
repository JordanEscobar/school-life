package com.schoollife.classbook.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.schoollife.classbook.Entities.Administrador;
import com.schoollife.classbook.Service.ColegioService;



@Controller
public class ColegioController {
	
	@Autowired
	private final ColegioService colegioService;

	public ColegioController(ColegioService colegioService) {
		super();
		this.colegioService = colegioService;
	}

	@GetMapping("/colegio/listar/{id}")
	public String colegioLista(Administrador administrador,Model model) {
		var listaColegio = colegioService.getColegioByUsuarioId(administrador.getId());
		model.addAttribute("listaColegio",listaColegio);
		return "Index";
	}
	
	
	
	


}
