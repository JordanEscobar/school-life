package com.schoollife.web.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.schoollife.web.Service.Historial_estudianteService;

@Controller
public class Historial_estudianteController {

	@Autowired
	private final Historial_estudianteService historialS;

	public Historial_estudianteController(Historial_estudianteService historialS) {
		super();
		this.historialS = historialS;
	}
	
	
	
}
