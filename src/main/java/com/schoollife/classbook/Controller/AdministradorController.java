package com.schoollife.classbook.Controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.schoollife.classbook.Entities.Apoderado;
import com.schoollife.classbook.Entities.Curso;
import com.schoollife.classbook.Entities.Estudiante;
import com.schoollife.classbook.Entities.Matricula;
import com.schoollife.classbook.Entities.Registro_conexion;
import com.schoollife.classbook.Service.ApoderadoService;
import com.schoollife.classbook.Service.CursoService;
import com.schoollife.classbook.Service.EstudianteService;
import com.schoollife.classbook.Service.MatriculaService;
import com.schoollife.classbook.Service.ProfesorService;
import com.schoollife.classbook.Service.Registro_conexionService;

import jakarta.servlet.http.HttpSession;

@Controller
public class AdministradorController {
	//Inyeccion de dependencias
	@Autowired
	private final CursoService cursoS;
	@Autowired
	private final ProfesorService profeS;
	@Autowired
	private final EstudianteService estudianteS;
	@Autowired
	private final Registro_conexionService registroS;
	@Autowired
	private final ApoderadoService apoderadoS;
	@Autowired
	private final MatriculaService matriculaS;
	
	
	public AdministradorController(CursoService cursoS, ProfesorService profeS,
			EstudianteService estudianteS, Registro_conexionService registroS,
			ApoderadoService apoderadoS, MatriculaService matriculaS) {
		super();
		this.cursoS = cursoS;
		this.profeS = profeS;
		this.estudianteS = estudianteS;
		this.registroS = registroS;
		this.apoderadoS = apoderadoS;
		this.matriculaS = matriculaS;
	}

	//Controllers de parte del administrador
	//administrador lista los cursos del colegio al que administra
	@GetMapping("/administrador/curso")
	public String administradorCurso(Model model) {
		Integer colegioid = 1;//este dato deberia ser un argumento que venga de la sesion iniciada
		var cursos = cursoS.cursoPorColegio(colegioid);
		model.addAttribute("colegioid",colegioid);
		model.addAttribute("cursos",cursos);
		return "Administrador-curso";
	}
	//administrador estudiantes por curso 
	@GetMapping("/administrador/curso/{id}")
	public String administradorCursoEstudiante(Curso curso,Model model, HttpSession sesion) {
		var estudiantesCurso = cursoS.getEstudianteByIdCurso(curso.getId());
		model.addAttribute("estudiantesCurso",estudiantesCurso);
		return "Administrador-curso-estudiante";
	}
	
	@GetMapping("/administrador/curso/modificar/{id}")
	public String administradorCursoEstudianteModificar(Estudiante estudiante, Model model, HttpSession sesion) {
		estudiante = estudianteS.findEstudiante(estudiante);
		model.addAttribute("estudiante", estudiante);
		return "Administrador-curso-estudiante-modificar";
	}
	
	@PostMapping(path = "/administrador/curso/modificado" /*, consumes = "application/x-ww-form-urlencoded"*/)
	public String administradorCursoEstudianteModificado(Estudiante estudiante,RedirectAttributes flash, Model model, HttpSession sesion) {
		var estudiantes = estudianteS.getAllEstudiante();
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
		estudianteS.updateEstudiante(estudiante, estudiante.getId());
		flash.addFlashAttribute("success","Modificado Correctamente");
		model.addAttribute("estudiante",estudiante);
		return "redirect:/administrador/curso/modificar/" + estudiante.getId();
	}
	
	@PostMapping(path = "/administrador/curso/guardado", consumes = "application/x-www-form-urlencoded")
	public String administradorCursoGuardado(Curso curso,RedirectAttributes flash, Model model,HttpSession sesion) {			
		Integer colegioid = 1;
		Curso c = new Curso();
		c.setColegio_id(colegioid);
		c.setEstado("activo");
		c.setGrado(curso.getGrado());
		c.setId(curso.getId());
		c.setProfesor_id(curso.getProfesor_id());
		c.setSeccion(curso.getSeccion());
		cursoS.CreateCurso(c);              
		System.out.println("CURSO CREADO: " + c);
		flash.addFlashAttribute("success","Curso ingresado correctamente");
		return "redirect:/administrador/curso";
	}
	
	
	
	@GetMapping("/administrador/curso/crear")
	public String administradorCursoCrear(Curso curso,Model model) {
		return "Administrador-curso-crear";
	}
	
	@GetMapping("/administrador/matricula")
	public String administradorCursoMatricula(@Param("pie") String pie,Model model, HttpSession sesion) {
		List<Estudiante> matriculas = estudianteS.estudiantesPie(pie);
		System.out.println("estudiantes pie: " + matriculas);
		model.addAttribute("matriculas",matriculas);
		return "Administrador-matricula";
	}
	
	@GetMapping("/administrador/matricula/pie")
	public String administradorMatriculaPie(Model model, HttpSession sesion) {
		List<Estudiante> matriculas = estudianteS.estudiantePie();
		model.addAttribute("matriculas",matriculas);
		return "Administrador-matricula";
	}
	
	@GetMapping("/administrador/matricula/sep")
	public String administradorMatriculaSep(Model model, HttpSession sesion) {
		List<Estudiante> matriculas = estudianteS.estudianteSep();
		model.addAttribute("matriculas",matriculas);
		return "Administrador-matricula";
	}
	
	@GetMapping("/administrador/matricula/crear")
	public String administradorCursoMatriculaCrear(Estudiante estudiante,Apoderado apoderado, Model model, HttpSession sesion) {
	
		model.addAttribute("estudiante", estudiante);
		return "Administrador-matricula-crear";
	}
	
	@PostMapping(path = "/administrador/matricula/creada", consumes = "application/x-www-form-urlencoded")
	public String administradorMatriculaCreada(Estudiante estudiante,Apoderado apoderado,Model model,HttpSession sesion) {			
		Integer colegioid = 1;
		Estudiante e = new Estudiante();
		e.setColegio_id(colegioid);
		e.setEstado("activo");
		e.setApaterno(estudiante.getApaterno());
		e.setAmaterno(estudiante.getAmaterno());
		e.setId(estudiante.getId());
		e.setContrasena(estudiante.getContrasena());
		e.setCorreo(estudiante.getCorreo());
		e.setCurso_id(estudiante.getCurso_id());
		e.setDireccion(estudiante.getDireccion());
		e.setFecha_nacimiento(estudiante.getFecha_nacimiento());
		e.setNombre(estudiante.getNombre());
		e.setPie(estudiante.getPie());
		e.setRut(estudiante.getRut());
		e.setSep(estudiante.getSep());
		e.setTelefono(estudiante.getTelefono());
		//se crea el estudiante
		estudianteS.CreateEstudiante(e);         
		model.addAttribute("estudianteid",e.getId());
		model.addAttribute("estudiante", e);
		//Se crea un registro cada vez que se ingresa una matricula
		Registro_conexion registro = new Registro_conexion();
		registro.setFecha(new Date());
		registro.setColegio_id(colegioid);
		registro.setDescripcion("Ingreso nueva matrícula. Paso 1. Ingreso del estudiante al sistema.");
		registroS.crearRegistro(registro);

		return "Administrador-matricula-crear2";
	}
	
	@PostMapping(path = "/administrador/matricula/creada/ingresado", consumes = "application/x-www-form-urlencoded")
	public String administradorMatriculaCreadaFinal(Estudiante estudiante,Apoderado apoderado, Model model,@Param("estudianteid") Integer estudianteid,@Param("pie") String pie,HttpSession sesion) {			
		Integer colegioid = 1;
		Apoderado a = new Apoderado();
		a.setEstado("activo");
		a.setApaterno(apoderado.getApaterno());
		a.setAmaterno(apoderado.getAmaterno());
		a.setId(apoderado.getId());
		a.setDireccion(apoderado.getDireccion());
		a.setNombre(apoderado.getNombre());
		a.setRut(apoderado.getRut());
		a.setTelefono(apoderado.getTelefono());
		a.setEstudiante_id(estudianteid);
		//se crea el apodearo
		apoderadoS.createApoderado(a);   
		
		//se ingresa matricula
		Matricula m = new Matricula();
		m.setColegio_id(colegioid);
		m.setEstado("matriculado");
		m.setEstudiante_id(estudiante.getId());
		m.setFecha(new Date());
		//se crea la matricula
		matriculaS.CreateMatricula(m);
 		
		
		
		model.addAttribute("apoderado", a);
		//Se crea un registro cada vez que se ingresa una matricula
		Registro_conexion registro = new Registro_conexion();
		registro.setFecha(new Date());
		registro.setColegio_id(colegioid);
		registro.setDescripcion("Ingreso nueva matrícula. Paso 2. Ingreso del apoderado al sistema. Creación de la matricula.");
		registroS.crearRegistro(registro);
		//redireccion a matriculas
		/*List<Estudiante> matriculas = estudianteS.estudiantesPie(pie);
		System.out.println("estudiantes pie: " + matriculas);
		model.addAttribute("matriculas",matriculas);*/

		return "redirect:/administrador/matricula";
	}

}
