package com.schoollife.web.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.schoollife.web.Entities.Curso;
import com.schoollife.web.Entities.Usuario;
import com.schoollife.web.Service.CursoService;
import com.schoollife.web.Service.EstablecimientoService;
import com.schoollife.web.Service.EstudianteService;

import jakarta.servlet.http.HttpSession;

@Controller
public class EstudianteController {
	
	@Autowired
	private final EstudianteService estudianteS;
	@Autowired
	private final EstablecimientoService establecimientoS;
	@Autowired
	private final CursoService cursoS;
	
	public EstudianteController(EstudianteService estudianteS, EstablecimientoService establecimientoS, CursoService cursoS) {
		super();
		this.estudianteS = estudianteS;
		this.establecimientoS = establecimientoS;
		this.cursoS = cursoS;
	}

	@GetMapping("/hojadevida")
	public String hojaVida(Model model,HttpSession sesion) {
		if(sesion.getAttribute("usuario") != null) {
			model.addAttribute("usuario",sesion.getAttribute("usuario"));
			List<Usuario> uSesion =  (List<Usuario>) sesion.getAttribute("usuario");
			model.addAttribute("uSesion",uSesion.get(0));
			model.addAttribute("cursos",cursoS.getAll(uSesion.get(0).getEstablecimiento_id()));
			model.addAttribute("establecimientoSesion", establecimientoS.findById(uSesion.get(0).getEstablecimiento_id()));	
			var estudiantes = estudianteS.getAll(uSesion.get(0).getEstablecimiento_id());
			model.addAttribute("estudiantes",estudiantes);
			return "Hoja-de-vida";
		}
		return "Login";
	}
	
	@PostMapping(path = "/filtrarcursos", consumes = "application/x-www-form-urlencoded")
	public String filtroCursos(Model model, @RequestParam("filtrocursos") Integer filtrocursos,HttpSession sesion) {
		if(sesion.getAttribute("usuario") != null) {
			var estudiantes = estudianteS.findEstudiantePorCurso(filtrocursos);
			List<Usuario> uSesion =  (List<Usuario>) sesion.getAttribute("usuario");
			model.addAttribute("filtrocursos", filtrocursos);	
			model.addAttribute("usuario",sesion.getAttribute("usuario"));
			model.addAttribute("uSesion",uSesion.get(0));
			model.addAttribute("cursos",cursoS.getAll(uSesion.get(0).getEstablecimiento_id()));
			model.addAttribute("establecimientoSesion", establecimientoS.findById(uSesion.get(0).getEstablecimiento_id()));	
			model.addAttribute("estudiantes",estudiantes);
			return "Hoja-de-vida";
		}
		return "Login";
	}

}
