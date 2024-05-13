package com.schoollife.web.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.schoollife.web.Entities.Apoderado;
import com.schoollife.web.Entities.Estudiante;
import com.schoollife.web.Service.ApoderadoService;
import com.schoollife.web.Service.CursoService;
import com.schoollife.web.Service.EstablecimientoService;
import com.schoollife.web.Service.EstudianteService;
import com.schoollife.web.Service.Programa_IntegracionService;
import jakarta.*;

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

	public HomeController(ApoderadoService apoderadoS, EstudianteService estudianteS,
			EstablecimientoService establecimientoS, CursoService cursoS, Programa_IntegracionService programaS) {
		super();
		this.apoderadoS = apoderadoS;
		this.estudianteS = estudianteS;
		this.establecimientoS = establecimientoS;
		this.cursoS = cursoS;
		this.programaS = programaS;
	}

	@GetMapping("/")
	public String index(Model model) {
		return "Index";
	}

	@GetMapping("/login")
	public String login(Model model) {
		return "Login";
	}

	// Matricula
	@GetMapping("/matricula")
	public String matricula(Model model) {
		var estudiantes = estudianteS.getAll();
		var cursos = cursoS.getAll();
		Integer mujeres = estudianteS.totalMujeres();
		Integer hombres = estudianteS.totalHombres();
		Integer otros = estudianteS.totalOtro();
		model.addAttribute("otros", otros);
		model.addAttribute("mujeres", mujeres);
		model.addAttribute("hombres", hombres);
		Integer estudiantesMatriculados = estudianteS.totalMatriculados();
		model.addAttribute("matriculados", estudiantesMatriculados);
		var programas = programaS.getAll();
		model.addAttribute("cursos", cursos);
		model.addAttribute("programas", programas);
		model.addAttribute("estudiantes", estudiantes);
		return "Matricula";
	}

	// filtrar por nombre y apellidos
	@PostMapping(path = "/filtrarnombre", consumes = "application/x-www-form-urlencoded")
	public String filtroNombre(Model model, @RequestParam("filtronombre") String filtronombre) {
		var estudiantes = estudianteS.findPorEstudiantePorCodigo(filtronombre);
		var cursos = cursoS.getAll();
		var programas = programaS.getAll();
		Integer estudiantesMatriculados = estudianteS.totalMatriculados();
		Integer mujeres = estudianteS.totalMujeres();
		Integer hombres = estudianteS.totalHombres();
		Integer otros = estudianteS.totalOtro();
		model.addAttribute("otros", otros);
		model.addAttribute("mujeres", mujeres);
		model.addAttribute("hombres", hombres);
		model.addAttribute("matriculados", estudiantesMatriculados);
		model.addAttribute("programas", programas);
		model.addAttribute("estudiantes", estudiantes);
		model.addAttribute("cursos", cursos);
		model.addAttribute("filtronombre", filtronombre);
		return "Matricula";
	}

	@PostMapping(path = "/filtrarcurso", consumes = "application/x-www-form-urlencoded")
	public String filtroCurso(Model model, @RequestParam("filtrocurso") Integer filtrocurso) {
		var estudiantes = estudianteS.findEstudiantePorCurso(filtrocurso);
		var cursos = cursoS.getAll();
		var programas = programaS.getAll();
		Integer estudiantesMatriculados = estudianteS.totalMatriculados();
		Integer mujeres = estudianteS.totalMujeres();
		Integer hombres = estudianteS.totalHombres();
		Integer otros = estudianteS.totalOtro();
		model.addAttribute("otros", otros);
		model.addAttribute("mujeres", mujeres);
		model.addAttribute("hombres", hombres);
		model.addAttribute("matriculados", estudiantesMatriculados);
		model.addAttribute("programas", programas);
		model.addAttribute("estudiantes", estudiantes);
		model.addAttribute("cursos", cursos);
		model.addAttribute("filtrocurso", filtrocurso);
		return "Matricula";
	}

	@PostMapping(path = "/filtrarestado", consumes = "application/x-www-form-urlencoded")
	public String filtroEstado(Model model, @RequestParam("filtroestado") String filtroestado) {
		var estudiantes = estudianteS.findEstudiantePorEstado(filtroestado);
		var cursos = cursoS.getAll();
		var programas = programaS.getAll();
		Integer estudiantesMatriculados = estudianteS.totalMatriculados();
		Integer mujeres = estudianteS.totalMujeres();
		Integer hombres = estudianteS.totalHombres();
		Integer otros = estudianteS.totalOtro();
		model.addAttribute("otros", otros);
		model.addAttribute("mujeres", mujeres);
		model.addAttribute("hombres", hombres);
		model.addAttribute("matriculados", estudiantesMatriculados);
		model.addAttribute("programas", programas);
		model.addAttribute("estudiantes", estudiantes);
		model.addAttribute("cursos", cursos);
		model.addAttribute("filtrocurso", filtroestado);
		return "Matricula";
	}

	// Ingreso de una matricula
	@GetMapping("/matricula/ingresar")
	public String matriculaIngresar(Estudiante estudiante, Model model) {
		model.addAttribute("estudiante", estudiante);
		return "Matricula-ingresar";
	}
	
	@PostMapping(path = "/matricula/ingresar/creada", consumes = "application/x-www-form-urlencoded")
	public String matriculaIngresarCreada(@Validated Estudiante estudiante,Errors errores, Model model, Apoderado apoderado) {
		
		model.addAttribute("apoderado", apoderado);
		
		Estudiante e = new Estudiante();
		e.setNumero_matricula("1");
		e.setColegio_procedencia("Colegio Concepción");
		e.setEstado(true);
		e.setEstablecimiento_id(123456);
		e.setAcepta_clases_religion(estudiante.isAcepta_clases_religion());
		e.setAlergias_alimentos(estudiante.getAlergias_alimentos());
		e.setAlergias_medicamentos(estudiante.getAlergias_medicamentos());
		e.setAmaterno(estudiante.getAmaterno());
		e.setApaterno(estudiante.getApaterno());
		e.setApto_educacion_fisica(estudiante.isApto_educacion_fisica());
		e.setBeca(estudiante.getBeca());
		e.setCantidad_computadores_casa(estudiante.getCantidad_computadores_casa());
		e.setCantidad_vacunas_covid(estudiante.getCantidad_vacunas_covid());
		e.setCelular(estudiante.getCelular());		
		e.setComuna(estudiante.getComuna());
		e.setConsultorio_clinica(estudiante.getConsultorio_clinica());
		e.setCorreo_electronico(estudiante.getCorreo_electronico());
		e.setCurso_id(1);
		e.setDireccion(estudiante.getDireccion());
		e.setEnfermedades_cronicas(estudiante.getEnfermedades_cronicas());
		e.setEsquema_completo_vacunacion_covid(estudiante.isEsquema_completo_vacunacion_covid());		
		e.setEstatura(estudiante.getEstatura());
		e.setEtnia(estudiante.getEtnia());
		e.setFecha_matricula(estudiante.getFecha_matricula());
		e.setFecha_nacimiento(estudiante.getFecha_nacimiento());
		e.setFecha_ultima_vacuna_COVID(estudiante.getFecha_ultima_vacuna_COVID());
		e.setGenero(estudiante.getGenero());
		e.setGrupo_sanguineo(estudiante.getGrupo_sanguineo());
		e.setMedicamentos_contraindicados(estudiante.getMedicamentos_contraindicados());
		e.setNacionalidad(estudiante.getNacionalidad());
		e.setNombre(estudiante.getNombre());
		e.setNombre_contacto_emergencia(estudiante.getNombre_contacto_emergencia());		
		e.setObservaciones(estudiante.getObservaciones());
		e.setPais_nacimiento(estudiante.getPais_nacimiento());
		e.setPeso(estudiante.getPeso());
		e.setReligion(estudiante.getReligion());
		e.setRun_estudiante(estudiante.getRun_estudiante());
		e.setSeguro_escolar_privado(estudiante.getSeguro_escolar_privado());
		e.setSistema_prevision(estudiante.getSistema_prevision());
		e.setTelefono(estudiante.getTelefono());
		e.setTelefono_emergencia(estudiante.getTelefono_emergencia());
		e.setVacuna_covid(estudiante.isVacuna_covid());
		e.setVive_con(estudiante.getVive_con());
		
		if (errores.hasErrors()) {
			return "Matricula-ingresar";
		}
		
		//se crea el estudiante
		estudianteS.createEstudiante(e);
		model.addAttribute("estudiante", e);
		model.addAttribute("estudianteid",e.getRun_estudiante());
		
		return "Matricula-ingresar-apoderado";
	}
	
	@GetMapping("/matricula/ingresar/pie")
	public String matriculaIngresarPie(Model model) {
		return "Matricula-ingresar-pie";
	}
	
	@GetMapping("/matricula/ingresar/apoderado")
	public String matriculaIngresarApoderado(Model model) {
		return "Matricula-ingresar-apoderado";
	}

}
