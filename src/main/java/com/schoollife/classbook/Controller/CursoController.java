package com.schoollife.classbook.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.schoollife.classbook.Entities.Curso;
import com.schoollife.classbook.Entities.Estudiante;
import com.schoollife.classbook.Service.CursoService;
import com.schoollife.classbook.Service.EstudianteService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class CursoController {
	@Autowired
	private final CursoService cursoService;
	@Autowired
	private final EstudianteService estudianteService;
	
	public CursoController(CursoService cursoService, EstudianteService estudianteService) {
		super();
		this.cursoService = cursoService;
		this.estudianteService = estudianteService;
	}
	
	@GetMapping("/cursosModificar/{id}")
	public String editCurso(Curso curso, Model model, HttpSession sesion) {
		curso = cursoService.findCurso(curso);
		model.addAttribute("curso", curso);
		return "Editar-curso";
	}
	//editar curso
	@PostMapping(path = "/cursoModificado" /*, consumes = "application/x-ww-form-urlencoded"*/)
	public String modificarCurso(@Valid Curso curso,Errors errores, RedirectAttributes flash, Model model, HttpSession sesion) {
		var cursos = cursoService.getAll();
		Curso c = new Curso();
		for (int i = 0; i < cursos.size(); i++) {
			if (cursos.get(i).getId() == curso.getId()) {
				c.setId(cursos.get(i).getId());
				c.setGrado(cursos.get(i).getGrado());
				c.setSeccion(cursos.get(i).getSeccion());
			}
		}
		
		if (errores.hasErrors()) {
			return "Editar-curso";
		}
		
		cursoService.updateCurso(curso, curso.getId());
		model.addAttribute("curso",curso);
		flash.addFlashAttribute("success","Modificado Correctamente");
		return "redirect:/Editar";
	}
	
	@GetMapping("/curso/estudiante/{id}")
	public String estudianteCurso(Curso curso,Model model, HttpSession sesion) {
		var estudiantesCurso = cursoService.getEstudianteByIdCurso(curso.getId());
		model.addAttribute("estudiantesCurso",estudiantesCurso);
		return "Curso-estudiante";
	}
	
	@GetMapping("/estudianteModificar/{id}")
	public String editEstudiante(Estudiante estudiante, Model model, HttpSession sesion) {
		estudiante = estudianteService.findEstudiante(estudiante);
		model.addAttribute("estudiante", estudiante);
		return "Editar-estudiante";
	}
	
	@PostMapping(path = "/estudianteModificado" /*, consumes = "application/x-ww-form-urlencoded"*/)
	public String modificarCurso(@Valid Estudiante estudiante,RedirectAttributes flash, Model model, HttpSession sesion) {
		var estudiantes = estudianteService.getAllEstudiante();
		Estudiante e = new Estudiante();
		for (int i = 0; i < estudiantes.size(); i++) {
			if (estudiantes.get(i).getId() == estudiante.getId()) {
				e.setId(estudiantes.get(i).getId());
				e.setAmaterno(estudiantes.get(i).getAmaterno());
				e.setApaterno(estudiantes.get(i).getApaterno());
				e.setCorreo(estudiantes.get(i).getCorreo());
				e.setColegio_id(estudiantes.get(i).getColegio_id());
				e.setCurso_id(estudiantes.get(i).getCurso_id());
				e.setFecha_nacimiento(estudiantes.get(i).getFecha_nacimiento());
				e.setDireccion(estudiantes.get(i).getDireccion());
				e.setEstado(estudiantes.get(i).getEstado());
				e.setContrasena(estudiantes.get(i).getContrasena());//debe ser hasheada
				e.setNombre(estudiantes.get(i).getNombre());
				e.setRut(estudiantes.get(i).getRut());
				e.setTelefono(estudiantes.get(i).getTelefono());
			}
		}
		estudianteService.updateEstudiante(estudiante, estudiante.getId());
		flash.addFlashAttribute("success","Modificado Correctamente");
		model.addAttribute("estudiante",estudiante);
		return "redirect:/curso";
	}
	
	@GetMapping("/curso/profesorJefe/{profesor_jefe}")
	public String listCursoByProfesorJefe(Curso curso, @PathVariable Integer profesor_jefe, Model model, HttpSession sesion) {
		Curso cursoProfeJefe = cursoService.getCursoByIdProfesorJefe(profesor_jefe);	
		Integer cursoId = cursoProfeJefe.getId();
		List<Estudiante> estudiantes = estudianteService.estudiantePorColegioYCurso(cursoId,1);
		model.addAttribute("estudiantes",estudiantes);
		model.addAttribute("cursoProfeJefe",cursoProfeJefe);
		return "CursoProfesorJefe";
	}
	
}
