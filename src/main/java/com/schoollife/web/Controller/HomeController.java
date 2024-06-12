package com.schoollife.web.Controller;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import jakarta.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.schoollife.web.Entities.Apoderado;
import com.schoollife.web.Entities.Curso;
import com.schoollife.web.Entities.Estudiante;
import com.schoollife.web.Entities.Programa_Integracion;
import com.schoollife.web.Entities.Usuario;
import com.schoollife.web.Service.ApoderadoService;
import com.schoollife.web.Service.CursoService;
import com.schoollife.web.Service.EstablecimientoService;
import com.schoollife.web.Service.EstudianteService;
import com.schoollife.web.Service.Programa_IntegracionService;
import com.schoollife.web.Service.RutValidationService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

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
	@Autowired
	private final RutValidationService rutValidationService;

	public HomeController(ApoderadoService apoderadoS, EstudianteService estudianteS,
			EstablecimientoService establecimientoS, CursoService cursoS, Programa_IntegracionService programaS,
			RutValidationService rutValidationService) {
		super();
		this.apoderadoS = apoderadoS;
		this.estudianteS = estudianteS;
		this.establecimientoS = establecimientoS;
		this.cursoS = cursoS;
		this.programaS = programaS;
		this.rutValidationService = rutValidationService;
	}

	@GetMapping("/")
	public String index(Model model,HttpSession sesion) {
		if(sesion.getAttribute("user")!=null)
		{
			model.addAttribute("user",sesion.getAttribute("user"));
			List<Usuario> uSesion =  (List<Usuario>) sesion.getAttribute("user");
			model.addAttribute("uSesion",uSesion.get(0));
			model.addAttribute("establecimientoSesion", establecimientoS.findById(uSesion.get(0).getEstablecimientoId()));	
			return "Index";
		}
		return "Login";
	}
	
	@GetMapping("/cerrarSesion")
	public String cerrarSesion(Model model,HttpSession sesion) throws ServletException {
		sesion.invalidate();
		return "redirect:/";
	}

	// Matricula
	@GetMapping("/matricula")
	public String matricula(Model model,HttpSession sesion) {
		if(sesion.getAttribute("user")!=null)
		{
			List<Usuario> uSesion =  (List<Usuario>) sesion.getAttribute("user");
			model.addAttribute("uSesion",uSesion.get(0));
			model.addAttribute("establecimientoSesion", establecimientoS.findById(uSesion.get(0).getEstablecimientoId()));
			model.addAttribute("user",sesion.getAttribute("user"));
			var estudiantes = estudianteS.getAll(uSesion.get(0).getEstablecimientoId());
			var cursos = cursoS.getAll(uSesion.get(0).getEstablecimientoId());
			Integer mujeres = estudianteS.totalMujeres(uSesion.get(0).getEstablecimientoId());
			Integer hombres = estudianteS.totalHombres(uSesion.get(0).getEstablecimientoId());
			Integer otros = estudianteS.totalOtro(uSesion.get(0).getEstablecimientoId());
			var programas = programaS.getAll();
			model.addAttribute("otros", otros);
			model.addAttribute("mujeres", mujeres);
			model.addAttribute("hombres", hombres);
			Integer estudiantesMatriculados = estudianteS.totalMatriculados(uSesion.get(0).getEstablecimientoId());
			model.addAttribute("matriculados", estudiantesMatriculados);
			model.addAttribute("cursos", cursos);
			model.addAttribute("programas", programas);
			model.addAttribute("estudiantes", estudiantes);
			return "Matricula";
		}
		return "Login";
		
		
		
	}
	
	

	// filtrar por nombre y apellidos
	@PostMapping(path = "/filtrarnombre", consumes = "application/x-www-form-urlencoded")
	public String filtroNombre(Model model, @RequestParam("filtronombre") String filtronombre,HttpSession sesion) {
		if(sesion.getAttribute("user")!=null)
		{
			List<Usuario> uSesion =  (List<Usuario>) sesion.getAttribute("user");
			model.addAttribute("uSesion",uSesion.get(0));
			model.addAttribute("establecimientoSesion", establecimientoS.findById(uSesion.get(0).getEstablecimientoId()));
			model.addAttribute("user",sesion.getAttribute("user"));
			
			var estudiantes = estudianteS.findPorEstudiantePorCodigo(filtronombre, uSesion.get(0).getEstablecimientoId());
			var cursos = cursoS.getAll(uSesion.get(0).getEstablecimientoId());
			var programas = programaS.getAll();
			Integer estudiantesMatriculados = estudianteS.totalMatriculados(uSesion.get(0).getEstablecimientoId());
			Integer mujeres = estudianteS.totalMujeres(uSesion.get(0).getEstablecimientoId());
			Integer hombres = estudianteS.totalHombres(uSesion.get(0).getEstablecimientoId());
			Integer otros = estudianteS.totalOtro(uSesion.get(0).getEstablecimientoId());
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
		return "Login";
				
	}
	
	// filtrar por Rut
	@PostMapping(path = "/filtrarrut", consumes = "application/x-www-form-urlencoded")
	public String filtroRut(Model model, @RequestParam("filtrorut") String filtrorut,HttpSession sesion) {
		if(sesion.getAttribute("user")!=null)
		{
			List<Usuario> uSesion =  (List<Usuario>) sesion.getAttribute("user");
			model.addAttribute("uSesion",uSesion.get(0));
			model.addAttribute("establecimientoSesion", establecimientoS.findById(uSesion.get(0).getEstablecimientoId()));
			model.addAttribute("user",sesion.getAttribute("user"));
			
			var estudiantes = estudianteS.findEstudiantePorRut(filtrorut, uSesion.get(0).getEstablecimientoId());
			var cursos = cursoS.getAll(uSesion.get(0).getEstablecimientoId());
			var programas = programaS.getAll();
			Integer estudiantesMatriculados = estudianteS.totalMatriculados(uSesion.get(0).getEstablecimientoId());
			Integer mujeres = estudianteS.totalMujeres(uSesion.get(0).getEstablecimientoId());
			Integer hombres = estudianteS.totalHombres(uSesion.get(0).getEstablecimientoId());
			Integer otros = estudianteS.totalOtro(uSesion.get(0).getEstablecimientoId());
			model.addAttribute("otros", otros);
			model.addAttribute("mujeres", mujeres);
			model.addAttribute("hombres", hombres);
			model.addAttribute("matriculados", estudiantesMatriculados);
			model.addAttribute("programas", programas);
			model.addAttribute("estudiantes", estudiantes);
			model.addAttribute("cursos", cursos);
			model.addAttribute("filtrorut", filtrorut);
			return "Matricula";
		}
		return "Login";
	}
	
	//filtrar por curso
	@PostMapping(path = "/filtrarcurso", consumes = "application/x-www-form-urlencoded")
	public String filtroCurso(Model model, @RequestParam("filtrocurso") Integer filtrocurso,HttpSession sesion) {
		if(sesion.getAttribute("user")!=null)
		{
			List<Usuario> uSesion =  (List<Usuario>) sesion.getAttribute("user");
			model.addAttribute("uSesion",uSesion.get(0));
			model.addAttribute("establecimientoSesion", establecimientoS.findById(uSesion.get(0).getEstablecimientoId()));
			model.addAttribute("user",sesion.getAttribute("user"));
			
			var estudiantes = estudianteS.findEstudiantePorCurso(filtrocurso);
			List<Curso> cursos = cursoS.getAll(uSesion.get(0).getEstablecimientoId());
			var programas = programaS.getAll();
			Integer estudiantesMatriculados = estudianteS.totalMatriculados(uSesion.get(0).getEstablecimientoId());
			Integer mujeres = estudianteS.totalMujeres(uSesion.get(0).getEstablecimientoId());
			Integer hombres = estudianteS.totalHombres(uSesion.get(0).getEstablecimientoId());
			Integer otros = estudianteS.totalOtro(uSesion.get(0).getEstablecimientoId());
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
		return "Login";
		
		
	}
	//filtrar por estado matriculado o retirado
	@PostMapping(path = "/filtrarestado", consumes = "application/x-www-form-urlencoded")
	public String filtroEstado(Model model, @RequestParam("filtroestado") String filtroestado,HttpSession sesion) {
		if(sesion.getAttribute("user")!=null)
		{
			List<Usuario> uSesion =  (List<Usuario>) sesion.getAttribute("user");
			model.addAttribute("uSesion",uSesion.get(0));
			model.addAttribute("establecimientoSesion", establecimientoS.findById(uSesion.get(0).getEstablecimientoId()));
			model.addAttribute("user",sesion.getAttribute("user"));
			
			var estudiantes = estudianteS.findEstudiantePorEstado(filtroestado,uSesion.get(0).getEstablecimientoId());
			var cursos = cursoS.getAll(uSesion.get(0).getEstablecimientoId());
			var programas = programaS.getAll();
			Integer estudiantesMatriculados = estudianteS.totalMatriculados(uSesion.get(0).getEstablecimientoId());
			Integer mujeres = estudianteS.totalMujeres(uSesion.get(0).getEstablecimientoId());
			Integer hombres = estudianteS.totalHombres(uSesion.get(0).getEstablecimientoId());
			Integer otros = estudianteS.totalOtro(uSesion.get(0).getEstablecimientoId());
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
		return "Login";
		
		
	}

	// Ingreso de una matricula
	@GetMapping("/matricula/ingresar")
	public String matriculaIngresar(Estudiante estudiante, Model model,HttpSession sesion) {
		if(sesion.getAttribute("user")!=null)
		{
			List<Usuario> uSesion =  (List<Usuario>) sesion.getAttribute("user");
			model.addAttribute("uSesion",uSesion.get(0));
			model.addAttribute("establecimientoSesion", establecimientoS.findById(uSesion.get(0).getEstablecimientoId()));
			model.addAttribute("user",sesion.getAttribute("user"));
			
			model.addAttribute("comunas",establecimientoS.comunas());
			model.addAttribute("estudiante", estudiante);
			boolean rutex = false;
			model.addAttribute("rutexiste", rutex);
			boolean rutinvalido = false;
			model.addAttribute("rutinvalido", rutinvalido);
			return "Matricula-ingresar";
		}
		return "Login";
		
		
	}
	/*Ingresa datos del estudiante*/
	@PostMapping(path = "/matricula/ingresar/creada", consumes = "application/x-www-form-urlencoded")
	public String matriculaIngresarCreada(@Valid Estudiante estudiante,Errors errores, Model model, Apoderado apoderado,HttpSession sesion) {
		if(sesion.getAttribute("user")!=null)
		{
			List<Usuario> uSesion =  (List<Usuario>) sesion.getAttribute("user");
			model.addAttribute("uSesion",uSesion.get(0));
			model.addAttribute("establecimientoSesion", establecimientoS.findById(uSesion.get(0).getEstablecimientoId()));
			model.addAttribute("user",sesion.getAttribute("user"));
			
			
			model.addAttribute("comunas",establecimientoS.comunas());		
			model.addAttribute("apoderado", apoderado);
			
			boolean rutex2 = false;
			model.addAttribute("rutexiste2", rutex2);
			boolean rutinvalido2 = false;
			model.addAttribute("rutinvalido2", rutinvalido2);
					
			Estudiante e = new Estudiante();
			Integer correlativo = estudianteS.getAll(uSesion.get(0).getEstablecimientoId()).size() + 1;
			String correlativoString = (String) correlativo.toString();
			e.setNumero_matricula(correlativoString);
			e.setColegio_procedencia(estudiante.getColegio_procedencia());
			e.setEstado(true);
			e.setEstablecimientoId(uSesion.get(0).getEstablecimientoId());
			//el curso se debe seleccionar o modificar FALTA ESO
			e.setCurso_id(1);
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
			e.setDireccion(estudiante.getDireccion());
			e.setEnfermedades_cronicas(estudiante.getEnfermedades_cronicas());
			e.setEsquema_completo_vacunacion_covid(estudiante.isEsquema_completo_vacunacion_covid());		
			e.setEstatura(estudiante.getEstatura());
			e.setEtnia(estudiante.getEtnia());
			
			//fecha actual en local date
			LocalDate localDate = LocalDate.now();
			//transformar el local date a date
			Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
			e.setFecha_matricula(date);
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
			
			if(rutValidationService.isValidRut(estudiante.getRunEstudiante())) {
				for (Estudiante es : estudianteS.getAll(uSesion.get(0).getEstablecimientoId())) {
					if(estudiante.getRunEstudiante().equalsIgnoreCase(es.getRunEstudiante())) {
						boolean rutex =true;
						model.addAttribute("rutexiste",rutex);
						return "Matricula-ingresar";
					}
					else {
						boolean rutex =false;
						model.addAttribute("rutexiste",rutex);
						e.setRunEstudiante(estudiante.getRunEstudiante());
					}
				}
			}else {
				rutinvalido2 = false;
				model.addAttribute("rutinvalido2", rutinvalido2);
				return "Matricula-ingresar";
			}
					
			e.setSeguro_escolar_privado(estudiante.isSeguro_escolar_privado());
			e.setSistema_prevision(estudiante.getSistema_prevision());
			e.setTelefono(estudiante.getTelefono());
			e.setTelefono_emergencia(estudiante.getTelefono_emergencia());
			e.setVacuna_covid(estudiante.isVacuna_covid());
			e.setVive_con(estudiante.getVive_con());
			e.setEs_pie(estudiante.isEs_pie());
			
			
			if (errores.hasErrors()) {
				return "Matricula-ingresar";
			}
			
			//se crea el estudiante
			estudianteS.createEstudiante(e);
			model.addAttribute("estudiante", e);
			model.addAttribute("estudianteid",e.getRunEstudiante());
			sesion.setAttribute("estudiante", e);
			Estudiante eSesion = (Estudiante) sesion.getAttribute("estudiante");
			model.addAttribute("estudiante", sesion.getAttribute("estudiante"));
			model.addAttribute("eSesion",eSesion);
			System.out.println("el estudiante creado es: " + eSesion);
			return "Matricula-ingresar-apoderado";	
		}
		return "Login";		
	}
	//ingreso por GET que me permite ingresar a la vista de ingreso de apoderado para la matricula
	@GetMapping("/matricula/ingresar/apoderados/get")
	public String matriculaIngresarApoderadoGet(Apoderado apoderado,Model model,HttpSession sesion) {
		
		if(sesion.getAttribute("user")!=null)
		{
			List<Usuario> uSesion = (List<Usuario>) sesion.getAttribute("user");
		    model.addAttribute("uSesion", uSesion.get(0));
		    model.addAttribute("establecimientoSesion", establecimientoS.findById(uSesion.get(0).getEstablecimientoId()));
		    model.addAttribute("user", sesion.getAttribute("user"));
		    boolean rutex2 = false;
		    model.addAttribute("rutexiste2", rutex2);
		    boolean rutinvalido2 = false;
		    model.addAttribute("rutinvalido2", rutinvalido2);
		    
		    model.addAttribute("comunas", establecimientoS.comunas());
		    Estudiante eSesion = (Estudiante) sesion.getAttribute("estudiante");
		    model.addAttribute("eSesion",eSesion);
		    System.out.println("el estudiante que se creo es: " + eSesion);
			return "Matricula-ingresar-apoderado";		
		}
		return "Login";
		
		
	}
	
	//recibe datos del estudiante, Ingresa datos del apoderado 
	@PostMapping(path = "/matricula/ingresar/apoderados", consumes = "application/x-www-form-urlencoded")
	public String matriculaIngresarApoderado(@Valid Apoderado apoderado, Errors errores, Model model, Programa_Integracion programa_integracion, HttpSession sesion) {
		if(sesion.getAttribute("user")!=null)
		{
			List<Usuario> uSesion = (List<Usuario>) sesion.getAttribute("user");
		    model.addAttribute("uSesion", uSesion.get(0));
		    model.addAttribute("establecimientoSesion", establecimientoS.findById(uSesion.get(0).getEstablecimientoId()));
		    model.addAttribute("user", sesion.getAttribute("user"));
		    boolean rutex2 = false;
		    model.addAttribute("rutexiste2", rutex2);
		    boolean rutinvalido2 = false;
		    model.addAttribute("rutinvalido2", rutinvalido2);

		    model.addAttribute("comunas", establecimientoS.comunas());

		    // Verificar que el estudiante_id existe en la base de datos
		    if (!estudianteS.estudianteExiste(apoderado.getEstudiante_id())) {
		        errores.rejectValue("estudiante_id", "error.apoderado", "El estudiante especificado no existe.");
		        return "Matricula-ingresar-apoderado";
		    }

		    // Crear el objeto Apoderado y asignar los valores
		    Apoderado a = new Apoderado();
		    
		    Estudiante eSesion = (Estudiante) sesion.getAttribute("estudiante");
		    model.addAttribute("eSesion",eSesion);
		    a.setEstudiante_id(apoderado.getEstudiante_id());
		    
		    a.setAcepta_manual_convivencia_escolar(apoderado.isAcepta_manual_convivencia_escolar());
		    a.setAmaterno_apoderado(apoderado.getAmaterno_apoderado());
		    a.setApaterno_apoderado(apoderado.getApaterno_apoderado());
		    a.setAutorizacion_fotografia_grabacion(apoderado.isAutorizacion_fotografia_grabacion());
		    a.setAutorizado_retirar_establecimiento(apoderado.isAutorizado_retirar_establecimiento());
		    a.setCelular_apoderado(apoderado.getCelular_apoderado());
		    a.setComuna_apoderado(apoderado.getComuna_apoderado());
		    a.setCorreo_electronico_apoderado(apoderado.getCorreo_electronico_apoderado());
		    a.setDomicilio_apoderado(apoderado.getDomicilio_apoderado());
		    a.setEs_tutor(apoderado.isEs_tutor());
		    
		    if (rutValidationService.isValidRut(apoderado.getRun_apoderado())) {
		        a.setRun_apoderado(apoderado.getRun_apoderado());
		    } else {
		        rutinvalido2 = true;
		        model.addAttribute("rutinvalido2", rutinvalido2);
		        return "Matricula-ingresar-apoderado";
		    }

		    a.setFecha_nacimiento_apoderado(apoderado.getFecha_nacimiento_apoderado());
		    a.setNivel_educacion(apoderado.getNivel_educacion());
		    a.setNombres(apoderado.getNombres());
		    a.setNumero_documento(apoderado.getNumero_documento());
		    a.setOcupacion(apoderado.getOcupacion());
		    a.setParentesco(apoderado.getParentesco());
		    a.setPasaporte(apoderado.getPasaporte());
		    a.setTelefono_apoderado(apoderado.getTelefono_apoderado());
		    a.setTipo_apoderado(apoderado.getTipo_apoderado());
		    a.setEstado_civil(apoderado.getEstado_civil());

		    if (errores.hasErrors()) {
		    	model.addAttribute("eSesion",eSesion);
		    	model.addAttribute("user", sesion.getAttribute("user"));
		        System.out.println("El usuario conectado es: "+ sesion.getAttribute("user"));
		        System.out.println("el estudiante que se registro es:"+ eSesion);
		    	return "Matricula-ingresar-apoderado";
		    }

		    // Se crea el apoderado
		    apoderadoS.createApoderado(a);
		    model.addAttribute("programa_integracion", programa_integracion);
		    return "Matricula-ingresar-pie";
			
		}
		
		return "Login";
		
		
		
	}
	
	public String matricularIngresarPieGet(Programa_Integracion programa_integracion, Model model,HttpSession sesion) {
		if(sesion.getAttribute("user")!=null)
		{
			List<Usuario> uSesion =  (List<Usuario>) sesion.getAttribute("user");
			model.addAttribute("uSesion",uSesion.get(0));
			model.addAttribute("establecimientoSesion", establecimientoS.findById(uSesion.get(0).getEstablecimientoId()));
			model.addAttribute("user",sesion.getAttribute("user"));	
			
			Estudiante eSesion = (Estudiante) sesion.getAttribute("estudiante");
			model.addAttribute("eSesion",eSesion);
	    	return "Matricula-ingresar-pie";
		}
		
		return "Login";
	}
	
	//Ingreso por post a ingresar al programa de integracion luego de ingresar el apoderado
	@PostMapping(path = "/matricula/ingresar/programa_integracion", consumes = "application/x-www-form-urlencoded")
	public String matriculaIngresarPie(@Valid Programa_Integracion programa_integracion, Errors errores,RedirectAttributes flash, Model model,HttpSession sesion) {
		if(sesion.getAttribute("user")!=null)
		{
			List<Usuario> uSesion =  (List<Usuario>) sesion.getAttribute("user");
			model.addAttribute("uSesion",uSesion.get(0));
			model.addAttribute("establecimientoSesion", establecimientoS.findById(uSesion.get(0).getEstablecimientoId()));
			model.addAttribute("user",sesion.getAttribute("user"));	
			
			Estudiante eSesion = (Estudiante) sesion.getAttribute("estudiante");
			model.addAttribute("eSesion",eSesion);
			
			Programa_Integracion p = new Programa_Integracion();
			//el rut esta hardcode, hay que modificarlo
			p.setEstudiante_id(eSesion.getRunEstudiante());
			p.setIndicaciones_generales(programa_integracion.getIndicaciones_generales());
			p.setPermanencia_pie(programa_integracion.isPermanencia_pie());
			p.setTipo_permanencia(programa_integracion.getTipo_permanencia());
			
			if (errores.hasErrors()) {
				model.addAttribute("eSesion",eSesion);
		    	model.addAttribute("user", sesion.getAttribute("user"));
				return "Matricula-ingresar-pie";
			}	
			//se crea el Programa para el estudiante
			programaS.CreatePrograma(p);
			model.addAttribute("programa_integracion",p);
			model.addAttribute("programa_integracionId",p.getId_Programa());
			flash.addFlashAttribute("success","Estudiante matriculado correctamente");
			return "redirect:/matricula";
		}
		return "Login";
		
	}
	
	@GetMapping("/programa/pie")
	public String ingresarProgramaPie(Programa_Integracion programa_integracion,Model model,HttpSession sesion) {
		if(sesion.getAttribute("user")!=null)
		{
			List<Usuario> uSesion =  (List<Usuario>) sesion.getAttribute("user");
			model.addAttribute("uSesion",uSesion.get(0));
			model.addAttribute("establecimientoSesion", establecimientoS.findById(uSesion.get(0).getEstablecimientoId()));
			model.addAttribute("user",sesion.getAttribute("user"));
			
			var estudiantes = estudianteS.getAll(uSesion.get(0).getEstablecimientoId());
			model.addAttribute("estudiantes", estudiantes);
			model.addAttribute("programa_integracion",programa_integracion);
			return "Ingresar-programa-pie";
			
		}
		return "Login";
		
		
		
	}
	
	@PostMapping(path = "/programa/pie/ingreso")
	public String programaPieIngresado(@Valid Programa_Integracion programa_integracion,Errors errores,RedirectAttributes flash,Model model,HttpSession sesion) {
		if(sesion.getAttribute("user")!=null)
		{
			List<Usuario> uSesion =  (List<Usuario>) sesion.getAttribute("user");
			model.addAttribute("uSesion",uSesion.get(0));
			model.addAttribute("establecimientoSesion", establecimientoS.findById(uSesion.get(0).getEstablecimientoId()));
			model.addAttribute("user",sesion.getAttribute("user"));
			
			
			var estudiantes = estudianteS.getAll(uSesion.get(0).getEstablecimientoId());
			model.addAttribute("estudiantes", estudiantes);
			model.addAttribute("programa_integracion",programa_integracion);
			Programa_Integracion p = new Programa_Integracion();
			p.setEstudiante_id(programa_integracion.getEstudiante_id());
			p.setIndicaciones_generales(programa_integracion.getIndicaciones_generales());
			p.setPermanencia_pie(programa_integracion.isPermanencia_pie());
			p.setTipo_permanencia(programa_integracion.getTipo_permanencia());
			
			if (errores.hasErrors()) {
				return "Ingresar-programa-pie";
			}	
			//se crea el Programa para el estudiante
			estudianteS.updateEstudiantePie(programa_integracion.getEstudiante_id());
			programaS.CreatePrograma(p);	
			flash.addFlashAttribute("success","Estudiante ingresado correctamente");
			return "redirect:/matricula";
		}
		return "Login";
		
		
	}
	
	@GetMapping("/matricula/modificar/{runEstudiante}")
	public String matriculaModificar(Estudiante estudiante,Model model,HttpSession sesion) {
		if(sesion.getAttribute("user")!=null)
		{
			List<Usuario> uSesion =  (List<Usuario>) sesion.getAttribute("user");
			model.addAttribute("uSesion",uSesion.get(0));
			model.addAttribute("establecimientoSesion", establecimientoS.findById(uSesion.get(0).getEstablecimientoId()));
			model.addAttribute("user",sesion.getAttribute("user"));
				
			estudiante = estudianteS.findEstudiante(estudiante);
			var cursos = cursoS.getAll(uSesion.get(0).getEstablecimientoId());
			model.addAttribute("cursos", cursos);
			model.addAttribute("comunas",establecimientoS.comunas());
			model.addAttribute("estudiante",estudiante);
			return "Matricula-modificar";	
		}
		return "Login";
	}
	
	@PostMapping(path = "/matricula/modificada", consumes = "application/x-www-form-urlencoded")
	public String matriculaModificada(@Valid Estudiante estudiante,Errors errores,RedirectAttributes flash,Model model,HttpSession sesion) {
		if(sesion.getAttribute("user")!=null)
		{
			List<Usuario> uSesion =  (List<Usuario>) sesion.getAttribute("user");
			model.addAttribute("uSesion",uSesion.get(0));
			model.addAttribute("establecimientoSesion", establecimientoS.findById(uSesion.get(0).getEstablecimientoId()));
			model.addAttribute("user",sesion.getAttribute("user"));			
			
			var estudiantes = estudianteS.getAll(uSesion.get(0).getEstablecimientoId());
			Estudiante e = new Estudiante();
			for (Estudiante es : estudiantes) {
				if(es.getRunEstudiante().equalsIgnoreCase(estudiante.getRunEstudiante())) {
					e.setNumero_matricula(es.getNumero_matricula());
					e.setColegio_procedencia("Colegio Concepción");
					e.setEstado(true);
					e.setEstablecimientoId(es.getEstablecimientoId());
					e.setAcepta_clases_religion(es.isAcepta_clases_religion());
					e.setAlergias_alimentos(es.getAlergias_alimentos());
					e.setAlergias_medicamentos(es.getAlergias_medicamentos());
					e.setAmaterno(es.getAmaterno());
					e.setApaterno(es.getApaterno());
					e.setApto_educacion_fisica(es.isApto_educacion_fisica());
					e.setBeca(es.getBeca());
					e.setCantidad_computadores_casa(es.getCantidad_computadores_casa());
					e.setCantidad_vacunas_covid(es.getCantidad_vacunas_covid());
					e.setCelular(es.getCelular());		
					e.setComuna(es.getComuna());
					e.setConsultorio_clinica(es.getConsultorio_clinica());
					e.setCorreo_electronico(es.getCorreo_electronico());
					e.setCurso_id(1);
					e.setDireccion(es.getDireccion());
					e.setEnfermedades_cronicas(es.getEnfermedades_cronicas());
					e.setEsquema_completo_vacunacion_covid(es.isEsquema_completo_vacunacion_covid());		
					e.setEstatura(es.getEstatura());
					e.setEtnia(es.getEtnia());
					e.setFecha_matricula(es.getFecha_matricula());
					e.setFecha_nacimiento(es.getFecha_nacimiento());
					e.setFecha_ultima_vacuna_COVID(es.getFecha_ultima_vacuna_COVID());
					e.setGenero(es.getGenero());
					e.setGrupo_sanguineo(es.getGrupo_sanguineo());
					e.setMedicamentos_contraindicados(es.getMedicamentos_contraindicados());
					e.setNacionalidad(es.getNacionalidad());
					e.setNombre(es.getNombre());
					e.setNombre_contacto_emergencia(es.getNombre_contacto_emergencia());		
					e.setObservaciones(es.getObservaciones());
					e.setPais_nacimiento(es.getPais_nacimiento());
					e.setPeso(es.getPeso());
					e.setReligion(es.getReligion());
					e.setRunEstudiante(es.getRunEstudiante());
					e.setSeguro_escolar_privado(es.isSeguro_escolar_privado());
					e.setSistema_prevision(es.getSistema_prevision());
					e.setTelefono(es.getTelefono());
					e.setTelefono_emergencia(es.getTelefono_emergencia());
					e.setVacuna_covid(es.isVacuna_covid());
					e.setVive_con(es.getVive_con());
					e.setEs_pie(es.isEs_pie());
				}
			}
			
			if (errores.hasErrors()) {
				return "Matricula-modificar";
			}				
			estudianteS.updateEstudiante(estudiante, estudiante.getRunEstudiante());
			flash.addFlashAttribute("success","Matrícula modificada correctamente");
			model.addAttribute("estudiante",estudiante);		
			return "redirect:/matricula";			
		}
		return "Login";	
	}
	
	@GetMapping("/resumenMatricula/{runEstudiante}")
	public String resumenMatricula(Estudiante estudiante, Model model,HttpSession sesion) {
		if(sesion.getAttribute("user")!=null)
		{
			List<Usuario> uSesion =  (List<Usuario>) sesion.getAttribute("user");
			model.addAttribute("uSesion",uSesion.get(0));
			model.addAttribute("establecimientoSesion", establecimientoS.findById(uSesion.get(0).getEstablecimientoId()));
			model.addAttribute("user",sesion.getAttribute("user"));
			
			model.addAttribute("estudiante", estudiante);
			var estudiantes = estudianteS.findEstudiante(estudiante);
			var apoderados = apoderadoS.findApoderadoPorEstudiante(estudiante.getRunEstudiante());
			var programa = programaS.findProgramaPorEstudiante(estudiante.getRunEstudiante());
				model.addAttribute("listaA",apoderados);
				model.addAttribute("listaP",programa);
				model.addAttribute("listaE", estudiantes);

			return "ResumenMatricula";
		}
		return "Login";
		

	}
	
	@GetMapping(path = "/matricula/retirada/{runEstudiante}")
	public String matriculaRetirada(Estudiante estudiante,RedirectAttributes flash,Model model,HttpSession sesion) {
		if(sesion.getAttribute("user")!=null)
		{
			List<Usuario> uSesion =  (List<Usuario>) sesion.getAttribute("user");
			model.addAttribute("uSesion",uSesion.get(0));
			model.addAttribute("establecimientoSesion", establecimientoS.findById(uSesion.get(0).getEstablecimientoId()));
			model.addAttribute("user",sesion.getAttribute("user"));
			
			var e = establecimientoS.getAll();
			model.addAttribute("establecimientos",e);
			var estudiantes = estudianteS.getAll(uSesion.get(0).getEstablecimientoId());
			Estudiante estu = new Estudiante();
			for (Estudiante es : estudiantes) {
				if(es.getRunEstudiante() == estudiante.getRunEstudiante()) {
					estu.setRunEstudiante(es.getRunEstudiante());
					estu.setEstado(false);
				}
			}		
			estudianteS.estadoMatriculaRetirado(estudiante, estudiante.getRunEstudiante());
			flash.addFlashAttribute("success","Matrícula retirada correctamente");
			model.addAttribute("estudiante",estudiante);	
			return "redirect:/matricula";
		}
		return "Login";
		
		
	}
	@GetMapping(path = "/matricula/recuperada/{runEstudiante}")
	public String matriculaRecuperada(Estudiante estudiante,RedirectAttributes flash,Model model,HttpSession sesion) {
		if(sesion.getAttribute("user")!=null)
		{
			List<Usuario> uSesion =  (List<Usuario>) sesion.getAttribute("user");
			model.addAttribute("uSesion",uSesion.get(0));
			model.addAttribute("establecimientoSesion", establecimientoS.findById(uSesion.get(0).getEstablecimientoId()));
			model.addAttribute("user",sesion.getAttribute("user"));
						
			var e = establecimientoS.getAll();
			model.addAttribute("establecimientos",e);
			var estudiantes = estudianteS.getAll(uSesion.get(0).getEstablecimientoId());
			Estudiante estu = new Estudiante();
			for (Estudiante es : estudiantes) {
				if(es.getRunEstudiante() == estudiante.getRunEstudiante()) {
					estu.setRunEstudiante(es.getRunEstudiante());
					estu.setEstado(true);
				}
			}		
			estudianteS.estadoMatriculaRecuperado(estudiante, estudiante.getRunEstudiante());
			flash.addFlashAttribute("success","Matrícula recuperada correctamente");
			model.addAttribute("estudiante",estudiante);	
			return "redirect:/matricula";
		}
		return "Login";
	}
	
	
	
	
	
}
