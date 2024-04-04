package com.schoollife.classbook.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.schoollife.classbook.Service.ApoderadoService;


@Controller
public class ApoderadoController {
	
	@Autowired
	private final ApoderadoService apoderadoService;

	public ApoderadoController(ApoderadoService apoderadoService) {
		super();
		this.apoderadoService = apoderadoService;
	}

	@GetMapping("/apoderado/listar/")
	public String apoderadoLista(Model model) {
		var listaApoderados = apoderadoService.getAllApoderados();
		model.addAttribute("listaApoderados",listaApoderados);
		return "Index";
	}

}
