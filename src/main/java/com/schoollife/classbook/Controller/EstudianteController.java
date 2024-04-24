package com.schoollife.classbook.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.schoollife.classbook.Service.EstudianteService;


@Controller
public class EstudianteController {
	
	@Autowired
	private final EstudianteService estudianteService;

	public EstudianteController(EstudianteService estudianteService) {
		super();
		this.estudianteService = estudianteService;
	}


	

	

	

}
