package com.schoollife.classbook.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.schoollife.classbook.Entities.Estudiante;
import com.schoollife.classbook.Entities.Seleccion;
import com.schoollife.classbook.Service.ColegioService;
import com.schoollife.classbook.Service.EstudianteService;

@Controller
public class HomeController {
	
	@Autowired
	private final ColegioService colegioService;
	@Autowired
	private final EstudianteService estudianteService;
	
	public HomeController(ColegioService colegioService,EstudianteService estudianteService) {
		super();
		this.colegioService = colegioService;
		this.estudianteService = estudianteService;
	}

	@GetMapping("/")
	public String index(Model model) {
		
		String profe = "profesor";
		String admin = "administrador";
		model.addAttribute("profe", profe);
		model.addAttribute("admin", admin);
		return "Index";
	}
	
	@GetMapping("/inicio")
	public String funcionalidades(Model model) {
		var colegios = colegioService.getAll();
		model.addAttribute("colegios", colegios);
		return "Funcionalidades";
	}
	
	@GetMapping("/home")
	public String funcionalidadesIndex(Model model) {
		var colegios = colegioService.getAll();
		model.addAttribute("colegios", colegios);
		return "Home";
	}	
	
	@GetMapping("/matricula")
	public String Matricula(@Param("pie") String pie,Model model) {
		List<Estudiante> matriculas = estudianteService.estudiantesPie(pie);
		System.out.println("estudiantes pie: " + matriculas);
		model.addAttribute("matriculas",matriculas);

		return "Matricula";
	}
	
	@GetMapping("/matriculaPie")
	public String MatriculaPie(Model model) {
		List<Estudiante> matriculas = estudianteService.estudiantePie();
		model.addAttribute("matriculas",matriculas);
		return "Matricula";
	}
	
	@GetMapping("/matriculaSep")
	public String MatriculaSep(Model model) {
		List<Estudiante> matriculas = estudianteService.estudianteSep();
		model.addAttribute("matriculas",matriculas);
		return "Matricula";
	}
	
	@GetMapping("/matricula/estudiante")
	public String MatriculaRegistro(Model model) {
		return "Matricula-registro";
	}

}
