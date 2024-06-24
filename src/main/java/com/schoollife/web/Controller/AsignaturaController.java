package com.schoollife.web.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.schoollife.web.Entities.Curso;
import com.schoollife.web.Entities.Usuario;
import com.schoollife.web.Service.AsignaturaService;
import com.schoollife.web.Service.CursoService;
import com.schoollife.web.Service.EstablecimientoService;

import jakarta.servlet.http.HttpSession;

@Controller
public class AsignaturaController {
	
	@Autowired
	private final AsignaturaService asignaturaS;
	@Autowired
	private final EstablecimientoService establecimientoS;
	@Autowired
	private final CursoService cursoS;

	public AsignaturaController(AsignaturaService asignaturaS, EstablecimientoService establecimientoS,
			CursoService cursoS) {
		super();
		this.asignaturaS = asignaturaS;
		this.establecimientoS = establecimientoS;
		this.cursoS = cursoS;
	}
	
	@GetMapping("/asignatura/{idCurso}")
	public String asignatura(Curso curso, Model model, HttpSession sesion) {
		if(sesion.getAttribute("user") != null) {		
			List<Usuario> uSesion =  (List<Usuario>) sesion.getAttribute("user");
			model.addAttribute("uSesion",uSesion.get(0));
			model.addAttribute("establecimientoSesion", establecimientoS.findById(uSesion.get(0).getEstablecimientoId()));		
			var asignaturas = asignaturaS.getAsignaturasPorCurso(curso.getIdCurso());
			model.addAttribute("asignaturas",asignaturas);
			return "Asignatura";
		}
		return "Login";
	}

	
}
