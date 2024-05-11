package com.schoollife.web.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.schoollife.web.Service.ApoderadoService;
import com.schoollife.web.Service.CursoService;
import com.schoollife.web.Service.EstablecimientoService;
import com.schoollife.web.Service.EstudianteService;
import com.schoollife.web.Service.Programa_IntegracionService;

@Controller
public class HomeController {
	@Autowired
	private final ApoderadoService apoderadoS;
	@Autowired
	private final EstudianteService estudianteS;
	@Autowired
	private final EstablecimientoService establecimientoS;
	@Autowired
	private final CursoService cursoS;
	@Autowired
	private final Programa_IntegracionService programaS;
	
	
	public HomeController(ApoderadoService apoderadoS,
			EstudianteService estudianteS, EstablecimientoService establecimientoS, CursoService cursoS,
			Programa_IntegracionService programaS) {
		super();
		this.apoderadoS = apoderadoS;
		this.estudianteS = estudianteS;
		this.establecimientoS = establecimientoS;
		this.cursoS = cursoS;
		this.programaS = programaS;
	}


	@GetMapping("/")
	public String index() {
		return "Index";
	}
	

	
	@GetMapping("/login")
	public String login() {
		return "Login";
	}
	//Matricula
	@GetMapping("/matricula")
	public String matricula(Model model) {
		var estudiantes = estudianteS.getAll();
		var cursos = cursoS.getAll();		
		var programas = programaS.getAll();
		model.addAttribute("cursos",cursos);
		model.addAttribute("programas",programas);
		model.addAttribute("estudiantes", estudiantes);
		return "Matricula";
	}
	//filtrar por nombre y apellidos
	@PostMapping(path = "/filtrarnombre", consumes = "application/x-www-form-urlencoded")
	public String filtroNombre(Model model,@RequestParam("filtronombre") String filtronombre) {
		var estudiantes = estudianteS.findPorEstudiantePorCodigo(filtronombre);
		var cursos = cursoS.getAll();
		var programas = programaS.getAll();
		model.addAttribute("programas",programas);
		model.addAttribute("estudiantes", estudiantes);
		model.addAttribute("cursos",cursos);
		return "Matricula";
	}
	@PostMapping(path = "/filtrarcurso", consumes = "application/x-www-form-urlencoded") 
	public String filtroCurso(Model model, @RequestParam("filtrocurso") Integer filtrocurso) {
		var estudiantes = estudianteS.findPorEstudiantePorCurso(filtrocurso);
		var cursos = cursoS.getAll();
		var programas = programaS.getAll();
		model.addAttribute("programas",programas);
		model.addAttribute("estudiantes", estudiantes);
		model.addAttribute("cursos",cursos);
		model.addAttribute("filtrocurso",filtrocurso);
		return "redirect:/matricula";
	}
	
	//Ingreso de una matricula
	@GetMapping("/matricula/ingresar")
	public String matriculaIngresar() {
		return "Matricula-ingresar";
	}

}
