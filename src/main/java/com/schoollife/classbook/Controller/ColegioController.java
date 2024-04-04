package com.schoollife.classbook.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.schoollife.classbook.Service.ColegioService;



@Controller
public class ColegioController {
	
	@Autowired
	private final ColegioService colegioService;

	public ColegioController(ColegioService colegioService) {
		super();
		this.colegioService = colegioService;
	}

	@GetMapping("/colegio/listar/")
	public String colegioLista(Model model) {
		var listaColegio = colegioService.getAllColegios();
		model.addAttribute("listaColegio",listaColegio);
		return "Index";
	}


}
