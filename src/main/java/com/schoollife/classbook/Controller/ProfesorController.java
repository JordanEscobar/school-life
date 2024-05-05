package com.schoollife.classbook.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.schoollife.classbook.Entities.Asignatura;
import com.schoollife.classbook.Entities.Asistencia;
import com.schoollife.classbook.Entities.Curso;
import com.schoollife.classbook.Entities.Estudiante;
import com.schoollife.classbook.Service.AsignaturaService;
import com.schoollife.classbook.Service.AsistenciaService;
import com.schoollife.classbook.Service.CursoService;
import com.schoollife.classbook.Service.EstudianteService;
import com.schoollife.classbook.Service.ProfesorService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class ProfesorController {
	
	@Autowired
	private final ProfesorService profesorService;
	@Autowired
	private final CursoService cursoS;
	@Autowired
	private final EstudianteService estudianteS;
	@Autowired
	private final AsignaturaService asignaturaS;
	@Autowired
	private final AsistenciaService asistenciaS;

	public ProfesorController(ProfesorService profesorService, CursoService cursoS,
			EstudianteService estudianteS, AsignaturaService asignaturaS, AsistenciaService asistenciaS) {
		super();
		this.profesorService = profesorService;
		this.cursoS = cursoS;
		this.estudianteS = estudianteS;
		this.asignaturaS = asignaturaS;
		this.asistenciaS = asistenciaS;
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
	public String profesorAsistencia(Model model) {
		List<Asignatura> asignaturaSelect = asignaturaS.asignaturaPorProfesor(1);
		List<Asistencia> asistencias = asistenciaS.getAllAsistencias();
		var estudiantes = estudianteS.getAllEstudiante();
		model.addAttribute("asignaturaSelect",asignaturaSelect);
		model.addAttribute("asistencias",asistencias);
		model.addAttribute("estudiantes",estudiantes);
		return "Profesor-asistencia";
	}
	//filtrar a traves de un select las asistencias por las asignaturas impartidas por el profesor que se logea
	@PostMapping("/filtrar")
	public String profesorAsistenciaPorAsignatura(@RequestParam("filtroAsignatura") int filtroAsignatura,Model model) {
		List<Asignatura> asignaturaSelect = asignaturaS.asignaturaPorProfesor(1);
		model.addAttribute("asignaturaSelect",asignaturaSelect);
		List<Asistencia> asistencias = asistenciaS.asistenciaPorAsignatura(filtroAsignatura);
		var estudiantes = estudianteS.getAllEstudiante();
		model.addAttribute("estudiantes",estudiantes);
		model.addAttribute("asistencias", asistencias);
		return "Profesor-asistencia";
	}
	
	@GetMapping("/profesor/asistencia/justificar/{id}")
	public String profesorAsistenciaJustificar(Estudiante estudiante, Model model, HttpSession sesion) {
		var asistencias = asistenciaS.asistenciaPorEstudiante(estudiante.getId());
		var asignaturas = asignaturaS.getAllAsignaturas();
		model.addAttribute("asignaturas",asignaturas);
		model.addAttribute("asistencias",asistencias);
		return "Profesor-asistencia-justificar";
	}
	
	@GetMapping("/profesor/asistencia/modificar/{id}")
	public String profesorAsistenciaModificar(Asistencia asistencia, Model model, HttpSession sesion) {
		var asistencias = asistenciaS.findAsistencia(asistencia);
		
		model.addAttribute("asistencias", asistencias);
		return "Profesor-asistencia-modificar";
	}
	
	@PostMapping(path = "/profesor/asistencia/modificado" /*, consumes = "application/x-ww-form-urlencoded"*/)
	public String profesorAsistenciaModificado(@Valid Asistencia asistencia, RedirectAttributes flash, Model model, HttpSession sesion) {
		var asistencias = asistenciaS.getAllAsistencias();
		Asistencia a = new Asistencia();
		for (int i = 0; i < asistencias.size(); i++) {
			if (asistencias.get(i).getId() == asistencia.getId()) {
				a.setId(asistencias.get(i).getId());
				a.setEstado(asistencias.get(i).getEstado());
				a.setDescripcion(asistencias.get(i).getDescripcion());
			}
		}
		asistenciaS.updateAsistencia(asistencia, asistencia.getId());
		flash.addFlashAttribute("success","Modificado Correctamente");
		model.addAttribute("asistencia",asistencia);
		return "redirect:/profesor/asistencia/justificar/" + asistencia.getEstudiante_id();
	}
	
	//ver curso Jefatura
	@GetMapping("/profesor/curso/encargado/{profesor_jefe}")
	public String profesorCursoEncargado(Curso curso, @PathVariable("profesor_jefe") Integer profesor_jefe, Model model, HttpSession sesion) {
		Curso cursoProfeJefe = cursoS.getCursoByIdProfesorJefe(profesor_jefe);	
		Integer cursoId = cursoProfeJefe.getId();
		List<Estudiante> estudiantes = estudianteS.estudiantePorColegioYCurso(cursoId,1);
		model.addAttribute("estudiantes",estudiantes);
		model.addAttribute("cursoProfeJefe",cursoProfeJefe);
		return "Profesor-curso-encargado";
	}
	//profesor ve las asignaturas que imparte y a que cursos
	@GetMapping("/profesor/curso/asignatura/{profesor_id}")
	public String profesorAsignaturas(@PathVariable("profesor_id") Integer profesor_id,Model model) {
		var asignaturas = asignaturaS.asignaturaPorProfesor(profesor_id);
		var cursos = cursoS.cursosPorProfesor(profesor_id);
		model.addAttribute("asignaturas",asignaturas);
		model.addAttribute("cursos", cursos);
		return"Profesor-curso";
	}
	@GetMapping("/profesor/curso/asignatura/estudiantes/{curso_id}")
	public String profesorAsignaturasPorCurso(@PathVariable("curso_id") Integer curso_id, Model model) {
		model.addAttribute("curso_id",curso_id);
		var estudiantes = cursoS.getEstudianteByIdCurso(curso_id);
		model.addAttribute("estudiantes",estudiantes);
		return "Profesor-curso-estudiante";
	}
	
	
	
	@GetMapping("/profesor/asistencia/registrar/{profesor_id}")
	public String profesorAsistenciaRegistrar(@PathVariable("profesor_id") Integer profesor_id, Model model, HttpSession sesion) {
		var cursos = cursoS.cursosPorProfesorNoQuery(profesor_id);
		var asignaturas = asignaturaS.getAllAsignaturas();
		model.addAttribute("asignaturas",asignaturas);
		model.addAttribute("cursos",cursos);
		return "Profesor-asistencia-registrar";
	}
	@PostMapping("/filtrar/asignatura")
	public String profesorAsistenciaRegistrarFiltro(@RequestParam("filtroAsignatura") int filtroAsignatura,Model model) {
		//var cursos = cursoS.cursosPorProfesorNoQuery(profesor_id);
		var asignaturas = asignaturaS.asignaturaPorProfesor(filtroAsignatura);
		model.addAttribute("asignaturas",asignaturas);
		//model.addAttribute("cursos",cursos);
		return "redirect:/profesor/asistencia/registrar/1";
	}
	


}
