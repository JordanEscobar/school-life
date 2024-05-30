package com.schoollife.web.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EstudianteController {
	
	@GetMapping("/hojadevida")
	public String hojaVida(Model model) {
		
		return "Hoja-de-vida";
	}

}
