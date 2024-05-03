package com.schoollife.classbook.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.schoollife.classbook.Entities.Curso;
import com.schoollife.classbook.Entities.Estudiante;
import com.schoollife.classbook.Service.CursoService;
import com.schoollife.classbook.Service.EstudianteService;
import com.schoollife.classbook.Service.ProfesorService;

import jakarta.servlet.http.HttpSession;


@Controller
public class ProfesorController {
	
	@Autowired
	private final ProfesorService profesorService;
	@Autowired
	private final CursoService cursoS;
	
	private final EstudianteService estudianteS;

	public ProfesorController(ProfesorService profesorService, CursoService cursoS,
			EstudianteService estudianteS) {
		super();
		this.profesorService = profesorService;
		this.cursoS = cursoS;
		this.estudianteS = estudianteS;
	}

	@GetMapping("/profesor/listar")
	public String profesorLista(Model model, HttpSession sesion) {
		var listaProfesor = profesorService.getAllProfesor();
		model.addAttribute("listaProfesor",listaProfesor);
		return "Profesor";
	}
	
	//Controladores nuevos que no se deben borrar
	//Controllers de parte del Profesor
	@GetMapping("/profesor/asistencia")
	public String profesorAsistencia() {
		return "Profesor-asistencia";
	}
	
	@GetMapping("/profesor/asistencia/justificar")
	public String profesorAsistenciaJustificar() {
		return "Profesor-asistencia-justificar";
	}
	
	@GetMapping("/profesor/asistencia/modificar")
	public String profesorAsistenciaModificar() {
		return "Profesor-asistencia-modificar";
	}
	
	@GetMapping("/profesor/asistencia/registrar")
	public String profesorAsistenciaRegistrar() {
		return "Profesor-asistencia-registrar";
	}
	
	@GetMapping("/profesor/curso")
	public String profesorCurso() {
		return "Profesor-curso";
	}
	
	@GetMapping("/profesor/curso/encargado/{profesor_jefe}")
	public String profesorCursoEncargado(Curso curso, @PathVariable("profesor_jefe") Integer profesor_jefe, Model model, HttpSession sesion) {
		Curso cursoProfeJefe = cursoS.getCursoByIdProfesorJefe(profesor_jefe);	
		Integer cursoId = cursoProfeJefe.getId();
		List<Estudiante> estudiantes = estudianteS.estudiantePorColegioYCurso(cursoId,1);
		model.addAttribute("estudiantes",estudiantes);
		model.addAttribute("cursoProfeJefe",cursoProfeJefe);
		return "Profesor-curso-encargado";
	}
	


}
