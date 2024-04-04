package com.schoollife.classbook.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.schoollife.classbook.Service.ColegioService;

@Controller
public class HomeController {
	
	@Autowired
	private final ColegioService colegioService;

	public HomeController(ColegioService colegioService) {
		super();
		this.colegioService = colegioService;
	}

	@GetMapping("/")
	public String index(Model model) {
		var listaColegios = colegioService.getAllColegios();
		
		model.addAttribute("listaColegios",listaColegios);
		return "Index";
	}
}
