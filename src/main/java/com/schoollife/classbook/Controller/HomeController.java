package com.schoollife.classbook.Controller;

import java.util.List;


import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.schoollife.classbook.Entities.Administrador;
import com.schoollife.classbook.Entities.Estudiante;
import com.schoollife.classbook.Entities.Profesor;
import com.schoollife.classbook.Service.AdministradorService;
import com.schoollife.classbook.Service.ColegioService;
import com.schoollife.classbook.Service.EstudianteService;
import com.schoollife.classbook.Service.ProfesorService;

@Controller
public class HomeController {
	
	@Autowired
	private final ColegioService colegioService;
	@Autowired
	private final EstudianteService estudianteService;
	@Autowired
	private final ProfesorService profesorService;
	@Autowired
	private final AdministradorService adminService;
	
	public HomeController(ColegioService colegioService,EstudianteService estudianteService,
			ProfesorService profesorService, AdministradorService adminService) {
		super();
		this.colegioService = colegioService;
		this.estudianteService = estudianteService;
		this.profesorService = profesorService;
		this.adminService = adminService;
	}


	

	
	@GetMapping("/home")
	public String funcionalidadesIndex(Model model, HttpSession sesion) {
		var colegios = colegioService.getAll();
		model.addAttribute("colegios", colegios);
		if(sesion!=null)
		{
			model.addAttribute("usuario",sesion.getAttribute("usuario"));
		}
		return "Home";
	}	
	
	@GetMapping("/matricula")
	public String Matricula(@Param("pie") String pie,Model model, HttpSession sesion) {
		List<Estudiante> matriculas = estudianteService.estudiantesPie(pie);
		System.out.println("estudiantes pie: " + matriculas);
		model.addAttribute("matriculas",matriculas);

		return "Matricula";
	}
	
	@GetMapping("/matriculaPie")
	public String MatriculaPie(Model model, HttpSession sesion) {
		List<Estudiante> matriculas = estudianteService.estudiantePie();
		model.addAttribute("matriculas",matriculas);
		return "Matricula";
	}
	
	@GetMapping("/matriculaSep")
	public String MatriculaSep(Model model, HttpSession sesion) {
		List<Estudiante> matriculas = estudianteService.estudianteSep();
		model.addAttribute("matriculas",matriculas);
		return "Matricula";
	}
	
	@GetMapping("/matricula/estudiante")
	public String MatriculaRegistro(Model model, HttpSession sesion) {
		return "Matricula-registro";
	}
	
	@GetMapping("/matricula/ingresada")
	public String MatriculaIngresada(Model model, HttpSession sesion) {
		return "Matricula";
	}
	//login
	//@PostMapping(path = "/ingresar", consumes = "application/x-www-form-urlencoded" )
	@GetMapping("/ingresar")
	public String ingresar(Model model,RedirectAttributes flash,HttpSession sesion) {
		String mail = "martin@info.cl";		
		if(mail == null || mail.isEmpty()) {
			flash.addFlashAttribute("warning","Debe ingresar credenciales válidas");
			return "redirect:/";
		}
	
		Profesor profesor = profesorService.profesorLogin(mail);
		
		if(profesor != null) {
			sesion.setAttribute("usuario", profesor);
			model.addAttribute("usuario",sesion.getAttribute("usuario"));
			return "Home";
		}
		Estudiante estudiante = estudianteService.estudianteLogin(mail);
		if(estudiante != null) {
			sesion.setAttribute("usuario", estudiante);
			model.addAttribute("usuario",sesion.getAttribute("usuario"));
			return "Home";
		}
		Administrador admin = adminService.administradorLogin(mail);
		if(admin != null) {
			sesion.setAttribute("usuario", admin);
			model.addAttribute("usuario",sesion.getAttribute("usuario"));
			return "Home";
		}
		
		flash.addFlashAttribute("warning","Debe ingresar credenciales válidas");
		return "redirect:/";
	}

}
