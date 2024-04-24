package com.schoollife.classbook.Controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.schoollife.classbook.Entities.Asistencia;
import com.schoollife.classbook.Entities.Curso;
import com.schoollife.classbook.Entities.Estudiante;
import com.schoollife.classbook.Service.AsistenciaService;

import jakarta.validation.Valid;

@Controller
public class AsistenciaController {
	
	@Autowired
	private final AsistenciaService asistenciaService;

	public AsistenciaController(AsistenciaService asistenciaService) {
		super();
		this.asistenciaService = asistenciaService;
	}
	
	/*@GetMapping("/asistencia/{id}")
	public String indexAsistencia(Curso cursos, Model model) {
		var asistencia = asistenciaService.obtenerDatos(1,1,cursos.getId());
		List<String> alumnoAsistencia = new ArrayList<String>();
		for (Object[] fila : asistencia) {
            String nombreAlumno = (String) fila[0]; // El primer elemento del array es el nombre del alumno
            String rut = (String) fila[1]; // El segundo elemento del array es el rut del alumno
            String curso = (String) fila[2]; // El tercer elemento del array es el curso del alumno
            String alumnos = "Alumno: " + nombreAlumno + ", Rut: " + rut + ", Curso: " + curso;
            alumnoAsistencia.add(alumnos);
        }
		model.addAttribute("alumnoAsistencia",alumnoAsistencia);
		model.addAttribute("asistencia", asistencia);
		return "Index-asistencia";
	}*/
	
	@GetMapping("/asistenciaCurso/{id}")
	public String asistenciaCurso(Curso curso,Model model) {
		
		return"Asistencia-curso";
	}
	
	@GetMapping("/asistencia/estudiante/{id}")
	public String estudianteAsistencia(Estudiante estudiante, Model model) {
		var asistencias = asistenciaService.obtenerAsistenciaEstudiante(estudiante.getId());
		model.addAttribute("asistencias",asistencias);
		return "Asistencia-estudiante";
	}
	
	@GetMapping("/asistenciaModificar/{id}")
	public String editEstudiante(Asistencia asistencia, Model model) {
		var asistencias = asistenciaService.findAsistencia(asistencia);
		model.addAttribute("asistencias", asistencias);
		return "Editar-asistencia";
	}
	
	@PostMapping(path = "/asistenciaModificado" /*, consumes = "application/x-ww-form-urlencoded"*/)
	public String modificarAsistencia(@Valid Asistencia asistencia,Errors errores, RedirectAttributes flash, Model model) {
		if (errores.hasErrors()) {
			flash.addFlashAttribute("warning","Valores Inválidos");
			return "redirect:/curso";
		}
		
		var asistencias = asistenciaService.getAllAsistencias();
		Asistencia a = new Asistencia();
		for (int i = 0; i < asistencias.size(); i++) {
			if (asistencias.get(i).getId() == asistencia.getId()) {
				a.setId(asistencias.get(i).getId());
				a.setEstado(asistencias.get(i).getEstado());
				a.setDescripcion(asistencias.get(i).getDescripcion());
			}
		}
		asistenciaService.updateAsistencia(asistencia, asistencia.getId());
		flash.addFlashAttribute("success","Modificado Correctamente");
		model.addAttribute("asistencia",asistencia);
		return "redirect:/curso";
	}
	
	
}


