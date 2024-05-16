package com.schoollife.web.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.schoollife.web.Entities.Apoderado;
import com.schoollife.web.Entities.Curso;
import com.schoollife.web.Entities.Establecimiento;
import com.schoollife.web.Entities.Estudiante;
import com.schoollife.web.Entities.Programa_Integracion;
import com.schoollife.web.Service.ApoderadoService;
import com.schoollife.web.Service.CursoService;
import com.schoollife.web.Service.EstablecimientoService;
import com.schoollife.web.Service.EstudianteService;
import com.schoollife.web.Service.Programa_IntegracionService;
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
		var programas = programaS.getAll();
		/*Collections.reverse(estudiantes);
		Collections.reverse(cursos);
		Collections.reverse(programas);*/
		model.addAttribute("otros", otros);
		model.addAttribute("mujeres", mujeres);
		model.addAttribute("hombres", hombres);
		Integer estudiantesMatriculados = estudianteS.totalMatriculados();
		model.addAttribute("matriculados", estudiantesMatriculados);
		
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
		
		String[] comunas = { "Arica", "Camarones", "Putre", "General Lagos", "Iquique", "Alto Hospicio", "Pozo Almonte", "Camiña", "Colchane", "Huara", "Pica",
				"Antofagasta", "Mejillones", "Sierra Gorda", "Taltal", "Calama", "Ollagüe", "San Pedro de Atacama", "Tocopilla", "María Elena",
			 "Copiapó", "Caldera", "Tierra Amarilla", "Chañaral", "Diego de Almagro", "Vallenar", "Alto del Carmen", "Freirina", "Huasco",
			"La Serena", "Coquimbo", "Andacollo", "La Higuera", "Paiguano", "Vicuña", "Illapel", "Canela", "Los Vilos", "Salamanca", "Ovalle", "Combarbalá", "Monte Patria",
			"Punitaqui", "Río Hurtado" ,"Valparaíso", "Casablanca", "Concón", "Juan Fernández", "Puchuncaví", "Quintero", "Viña del Mar", "Isla de Pascua", "Los Andes", "Calle Larga",
			"Rinconada", "San Esteban", "La Ligua", "Cabildo", "Papudo", "Petorca", "Zapallar", "Quillota", "Calera", "Hijuelas", "La Cruz", "Nogales", "San Antonio", "Algarrobo", "Cartagena",
			"El Quisco", "El Tabo", "Santo Domingo", "San Felipe", "Catemu", "Llaillay", "Panquehue", "Putaendo", "Santa María", "Quilpué", "Limache", "Olmué", "Villa Alemana","Rancagua", "Codegua",
			"Coinco", "Coltauco", "Doñihue", "Graneros", "Las Cabras", "Machalí", "Malloa", "Mostazal", "Olivar", "Peumo", "Pichidegua", "Quinta de Tilcoco", "Rengo", "Requínoa", "San Vicente", "Pichilemu",
			"La Estrella", "Litueche", "Marchihue", "Navidad", "Paredones", "San Fernando", "Chépica", "Chimbarongo", "Lolol", "Nancagua", "Palmilla", "Peralillo", "Placilla", "Pumanque", "Santa Cruz","Talca",
			"Constitución", "Curepto", "Empedrado", "Maule", "Pelarco", "Pencahue", "Río Claro", "San Clemente", "San Rafael", "Cauquenes", "Chanco", "Pelluhue", "Curicó", "Hualañé", "Licantén", "Molina", "Rauco",
			"Romeral", "Sagrada Familia", "Teno", "Vichuquén", "Linares", "Colbún", "Longaví", "Parral", "Retiro", "San Javier", "Villa Alegre", "Yerbas Buenas","Cobquecura", "Coelemu", "Ninhue", "Portezuelo", "Quirihue",
			"Ránquil", "Treguaco", "Bulnes", "Chillán Viejo", "Chillán", "El Carmen", "Pemuco", "Pinto", "Quillón", "San Ignacio", "Yungay", "Coihueco", "Ñiquén", "San Carlos", "San Fabián", "San Nicolás","Concepción", "Coronel", 
			"Chiguayante", "Florida", "Hualqui", "Lota", "Penco", "San Pedro de la Paz", "Santa Juana", "Talcahuano", "Tomé", "Hualpén", "Lebu", "Arauco", "Cañete", "Contulmo", "Curanilahue", "Los Álamos", "Tirúa", "Los Ángeles",
			"Antuco", "Cabrero", "Laja", "Mulchén", "Nacimiento", "Negrete", "Quilaco", "Quilleco", "San Rosendo", "Santa Bárbara", "Tucapel", "Yumbel", "Alto Biobío", "Temuco", "Carahue", "Cunco", "Curarrehue", "Freire", "Galvarino",
			"Gorbea", "Lautaro", "Loncoche", "Melipeuco", "Nueva Imperial", "Padre las Casas", "Perquenco", "Pitrufquén", "Pucón", "Saavedra", "Teodoro Schmidt", "Toltén", "Vilcún", "Villarrica", "Cholchol", "Angol", "Collipulli",
			"Curacautín", "Ercilla", "Lonquimay", "Los Sauces", "Lumaco", "Purén", "Renaico", "Traiguén", "Victoria","Valdivia", "Corral", "Lanco", "Los Lagos", "Máfil", "Mariquina", "Paillaco", "Panguipulli", "La Unión", "Futrono", 
			"Lago Ranco", "Río Bueno", "Puerto Montt", "Calbuco", "Cochamó", "Fresia", "Frutillar", "Los Muermos", "Llanquihue", "Maullín", "Puerto Varas", "Castro", "Ancud", "Chonchi", "Curaco de Vélez", "Dalcahue", "Puqueldón",
			"Queilén", "Quellón", "Quemchi", "Quinchao", "Osorno", "Puerto Octay", "Purranque", "Puyehue", "Río Negro", "San Juan de la Costa", "San Pablo", "Chaitén", "Futaleufú", "Hualaihué", "Palena", "Coihaique", "Lago Verde",
			"Aisén", "Cisnes", "Guaitecas", "Cochrane", "O’Higgins", "Tortel", "Chile Chico", "Río Ibáñez", "Punta Arenas", "Laguna Blanca", "Río Verde", "San Gregorio", "Cabo de Hornos (Ex Navarino)", "Antártica", "Porvenir", "Primavera",
			"Timaukel", "Natales", "Torres del Paine", "Cerrillos", "Cerro Navia", "Conchalí", "El Bosque", "Estación Central", "Huechuraba", "Independencia", "La Cisterna", "La Florida", "La Granja", "La Pintana", "La Reina", "Las Condes",
			"Lo Barnechea", "Lo Espejo", "Lo Prado", "Macul", "Maipú", "Ñuñoa", "Pedro Aguirre Cerda", "Peñalolén", "Providencia", "Pudahuel", "Quilicura", "Quinta Normal", "Recoleta", "Renca", "Santiago", "San Joaquín", "San Miguel", "San Ramón",
			"Vitacura", "Puente Alto", "Pirque", "San José de Maipo", "Colina", "Lampa", "Tiltil", "San Bernardo", "Buin", "Calera de Tango", "Paine", "Melipilla", "Alhué", "Curacaví", "María Pinto", "San Pedro", "Talagante", "El Monte",
			"Isla de Maipo", "Padre Hurtado", "Peñaflor" };
		
		List<String> comunalist = new ArrayList<String>();
		for (String string : comunas) {
			comunalist.add(string);
		}
		
		model.addAttribute("comunas",comunalist);
		model.addAttribute("estudiante", estudiante);
		return "Matricula-ingresar";
	}
	
	@PostMapping(path = "/matricula/ingresar/creada", consumes = "application/x-www-form-urlencoded")
	public String matriculaIngresarCreada(@Valid Estudiante estudiante,Errors errores, Model model, Apoderado apoderado) {
		
		String[] comunas = { "Arica", "Camarones", "Putre", "General Lagos", "Iquique", "Alto Hospicio", "Pozo Almonte", "Camiña", "Colchane", "Huara", "Pica",
				"Antofagasta", "Mejillones", "Sierra Gorda", "Taltal", "Calama", "Ollagüe", "San Pedro de Atacama", "Tocopilla", "María Elena",
			 "Copiapó", "Caldera", "Tierra Amarilla", "Chañaral", "Diego de Almagro", "Vallenar", "Alto del Carmen", "Freirina", "Huasco",
			"La Serena", "Coquimbo", "Andacollo", "La Higuera", "Paiguano", "Vicuña", "Illapel", "Canela", "Los Vilos", "Salamanca", "Ovalle", "Combarbalá", "Monte Patria",
			"Punitaqui", "Río Hurtado" ,"Valparaíso", "Casablanca", "Concón", "Juan Fernández", "Puchuncaví", "Quintero", "Viña del Mar", "Isla de Pascua", "Los Andes", "Calle Larga",
			"Rinconada", "San Esteban", "La Ligua", "Cabildo", "Papudo", "Petorca", "Zapallar", "Quillota", "Calera", "Hijuelas", "La Cruz", "Nogales", "San Antonio", "Algarrobo", "Cartagena",
			"El Quisco", "El Tabo", "Santo Domingo", "San Felipe", "Catemu", "Llaillay", "Panquehue", "Putaendo", "Santa María", "Quilpué", "Limache", "Olmué", "Villa Alemana","Rancagua", "Codegua",
			"Coinco", "Coltauco", "Doñihue", "Graneros", "Las Cabras", "Machalí", "Malloa", "Mostazal", "Olivar", "Peumo", "Pichidegua", "Quinta de Tilcoco", "Rengo", "Requínoa", "San Vicente", "Pichilemu",
			"La Estrella", "Litueche", "Marchihue", "Navidad", "Paredones", "San Fernando", "Chépica", "Chimbarongo", "Lolol", "Nancagua", "Palmilla", "Peralillo", "Placilla", "Pumanque", "Santa Cruz","Talca",
			"Constitución", "Curepto", "Empedrado", "Maule", "Pelarco", "Pencahue", "Río Claro", "San Clemente", "San Rafael", "Cauquenes", "Chanco", "Pelluhue", "Curicó", "Hualañé", "Licantén", "Molina", "Rauco",
			"Romeral", "Sagrada Familia", "Teno", "Vichuquén", "Linares", "Colbún", "Longaví", "Parral", "Retiro", "San Javier", "Villa Alegre", "Yerbas Buenas","Cobquecura", "Coelemu", "Ninhue", "Portezuelo", "Quirihue",
			"Ránquil", "Treguaco", "Bulnes", "Chillán Viejo", "Chillán", "El Carmen", "Pemuco", "Pinto", "Quillón", "San Ignacio", "Yungay", "Coihueco", "Ñiquén", "San Carlos", "San Fabián", "San Nicolás","Concepción", "Coronel", 
			"Chiguayante", "Florida", "Hualqui", "Lota", "Penco", "San Pedro de la Paz", "Santa Juana", "Talcahuano", "Tomé", "Hualpén", "Lebu", "Arauco", "Cañete", "Contulmo", "Curanilahue", "Los Álamos", "Tirúa", "Los Ángeles",
			"Antuco", "Cabrero", "Laja", "Mulchén", "Nacimiento", "Negrete", "Quilaco", "Quilleco", "San Rosendo", "Santa Bárbara", "Tucapel", "Yumbel", "Alto Biobío", "Temuco", "Carahue", "Cunco", "Curarrehue", "Freire", "Galvarino",
			"Gorbea", "Lautaro", "Loncoche", "Melipeuco", "Nueva Imperial", "Padre las Casas", "Perquenco", "Pitrufquén", "Pucón", "Saavedra", "Teodoro Schmidt", "Toltén", "Vilcún", "Villarrica", "Cholchol", "Angol", "Collipulli",
			"Curacautín", "Ercilla", "Lonquimay", "Los Sauces", "Lumaco", "Purén", "Renaico", "Traiguén", "Victoria","Valdivia", "Corral", "Lanco", "Los Lagos", "Máfil", "Mariquina", "Paillaco", "Panguipulli", "La Unión", "Futrono", 
			"Lago Ranco", "Río Bueno", "Puerto Montt", "Calbuco", "Cochamó", "Fresia", "Frutillar", "Los Muermos", "Llanquihue", "Maullín", "Puerto Varas", "Castro", "Ancud", "Chonchi", "Curaco de Vélez", "Dalcahue", "Puqueldón",
			"Queilén", "Quellón", "Quemchi", "Quinchao", "Osorno", "Puerto Octay", "Purranque", "Puyehue", "Río Negro", "San Juan de la Costa", "San Pablo", "Chaitén", "Futaleufú", "Hualaihué", "Palena", "Coihaique", "Lago Verde",
			"Aisén", "Cisnes", "Guaitecas", "Cochrane", "O’Higgins", "Tortel", "Chile Chico", "Río Ibáñez", "Punta Arenas", "Laguna Blanca", "Río Verde", "San Gregorio", "Cabo de Hornos (Ex Navarino)", "Antártica", "Porvenir", "Primavera",
			"Timaukel", "Natales", "Torres del Paine", "Cerrillos", "Cerro Navia", "Conchalí", "El Bosque", "Estación Central", "Huechuraba", "Independencia", "La Cisterna", "La Florida", "La Granja", "La Pintana", "La Reina", "Las Condes",
			"Lo Barnechea", "Lo Espejo", "Lo Prado", "Macul", "Maipú", "Ñuñoa", "Pedro Aguirre Cerda", "Peñalolén", "Providencia", "Pudahuel", "Quilicura", "Quinta Normal", "Recoleta", "Renca", "Santiago", "San Joaquín", "San Miguel", "San Ramón",
			"Vitacura", "Puente Alto", "Pirque", "San José de Maipo", "Colina", "Lampa", "Tiltil", "San Bernardo", "Buin", "Calera de Tango", "Paine", "Melipilla", "Alhué", "Curacaví", "María Pinto", "San Pedro", "Talagante", "El Monte",
			"Isla de Maipo", "Padre Hurtado", "Peñaflor" };
		
		List<String> comunalist = new ArrayList<String>();
		for (String string : comunas) {
			comunalist.add(string);
		}
		
		model.addAttribute("comunas",comunalist);
		
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
		e.setEs_pie(estudiante.isEs_pie());
		
		
		if (errores.hasErrors()) {
			return "Matricula-ingresar";
		}
		
		//se crea el estudiante
		estudianteS.createEstudiante(e);
		model.addAttribute("estudiante", e);
		model.addAttribute("estudianteid",e.getRun_estudiante());
		
		return "Matricula-ingresar-apoderado";
	}
	
	@PostMapping(path = "/matricula/ingresar/apoderados", consumes = "application/x-www-form-urlencoded")
	public String matriculaIngresarApoderado(@Valid Apoderado apoderado,Errors errores, Model model, Programa_Integracion programa_integracion) {
		
		Apoderado a = new Apoderado();
		a.setAcepta_manual_convivencia_escolar(apoderado.isAcepta_manual_convivencia_escolar());
		a.setAmaterno_apoderado(apoderado.getAmaterno_apoderado());
		a.setApaterno_apoderado(apoderado.getApaterno_apoderado());
		a.setAutorizacion_fotografia_grabacion(apoderado.isAutorizacion_fotografia_grabacion());
		a.setAutorizado_retirar_establecimiento(apoderado.isAutorizado_retirar_establecimiento());
		a.setCelular(apoderado.getCelular());
		a.setComuna(apoderado.getComuna());
		a.setCorreo_electronico(apoderado.getCorreo_electronico());
		a.setDomicilio(apoderado.getDomicilio());
		a.setEs_tutor(apoderado.isEs_tutor());
		a.setEstudiante_id(apoderado.getEstudiante_id());
		a.setRun_apoderado("123212321");
		a.setFecha_nacimiento(apoderado.getFecha_nacimiento());
		a.setNivel_educacion(apoderado.getNivel_educacion());
		a.setNombres(apoderado.getNombres());
		a.setNumero_documento(apoderado.getNumero_documento());
		a.setOcupacion(apoderado.getOcupacion());
		a.setParentesco(apoderado.getParentesco());
		a.setPasaporte(apoderado.getPasaporte());
		a.setTelefono(apoderado.getTelefono());
		a.setTipo_apoderado(apoderado.getTipo_apoderado());
		a.setEstado_civil(apoderado.getEstado_civil());	
		
		if (errores.hasErrors()) {
			return "Matricula-ingresar-apoderado";
		}		
		
		//se crea el apoderado
		apoderadoS.createApoderado(a);
		model.addAttribute("estudianteid",a.getEstudiante_id());
		model.addAttribute("programa_integracion", programa_integracion);
		
		
		return "Matricula-ingresar-pie";
	}
	
	@PostMapping(path = "/matricula/ingresar/programa_integracion", consumes = "application/x-www-form-urlencoded")
	public String matriculaIngresarPie(@Valid Programa_Integracion programa_integracion, Errors errores,RedirectAttributes flash, Model model) {
		
		Programa_Integracion p = new Programa_Integracion();
		p.setEstudiante_id("");
		p.setIndicaciones_generales(programa_integracion.getIndicaciones_generales());
		p.setPermanencia_pie(programa_integracion.isPermanencia_pie());
		p.setTipo_permanencia(programa_integracion.getTipo_permanencia());
		
		if (errores.hasErrors()) {
			return "Matricula-ingresar-pie";
		}	
		//se crea el Programa para el estudiante
		programaS.CreatePrograma(p);
		model.addAttribute("programa_integracion",p);
		model.addAttribute("programa_integracionId",p.getId_Programa());
		flash.addFlashAttribute("success","Estudiante matriculado correctamente");
		return "redirect:/matricula";
	}
	
	@GetMapping("/programa/pie")
	public String ingresarProgramaPie(Programa_Integracion programa_integracion,Model model) {
		var estudiantes = estudianteS.getAll();
		model.addAttribute("estudiantes", estudiantes);
		model.addAttribute("programa_integracion",programa_integracion);
		return "Ingresar-programa-pie";
	}
	
	@PostMapping(path = "/programa/pie/ingreso")
	public String programaPieIngresado(@Valid Programa_Integracion programa_integracion,Errors errores,RedirectAttributes flash,Model model) {
		var estudiantes = estudianteS.getAll();
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
	
	@GetMapping("/matricula/modificar/{run_estudiante}")
	public String matriculaModificar(Estudiante estudiante,Model model) {
		estudiante = estudianteS.findEstudiante(estudiante);
		var cursos = cursoS.getAll();
		model.addAttribute("cursos", cursos);
		model.addAttribute("estudiante",estudiante);
		return "Matricula-modificar";
	}
	
	@PostMapping(path = "/matricula/modificada", consumes = "application/x-www-form-urlencoded")
	public String matriculaModificada(@Valid Estudiante estudiante,Errors errores,RedirectAttributes flash,Model model) {
		var estudiantes = estudianteS.getAll();
		Estudiante e = new Estudiante();
		for (Estudiante es : estudiantes) {
			if(es.getRun_estudiante().equalsIgnoreCase(estudiante.getRun_estudiante())) {
				e.setNumero_matricula(es.getNumero_matricula());
				e.setColegio_procedencia("Colegio Concepción");
				e.setEstado(true);
				e.setEstablecimiento_id(es.getEstablecimiento_id());
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
				e.setRun_estudiante(es.getRun_estudiante());
				e.setSeguro_escolar_privado(es.getSeguro_escolar_privado());
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
		
		estudianteS.updateEstudiante(estudiante, estudiante.getRun_estudiante());
		flash.addFlashAttribute("success","Matrícula modificada correctamente");
		model.addAttribute("estudiante",estudiante);		
		return "redirect:/matricula";
	}
	
	@GetMapping("/curso/ingresar")
	public String cursoAgregar(Curso curso,Model model)
	{
				
		var establecimientos = establecimientoS.getAll();
		model.addAttribute("establecimientos", establecimientos);
		model.addAttribute("curso",curso);
		
		return "Curso-ingresar"; 
	}
	
	@PostMapping(path = "/curso/ingresado", consumes = "application/x-www-form-urlencoded")
	public String cursoIngresado(@Valid Curso curso,Errors errores,RedirectAttributes flash,Model model)
	{
		
		var establecimientos = establecimientoS.getAll();
		model.addAttribute("establecimientos", establecimientos);
		
		Curso c = new Curso();
		c.setApodo(curso.getApodo());
		c.setCapacidad(curso.getCapacidad());
		c.setEstablecimiento_id(curso.getEstablecimiento_id());
		c.setId_curso(curso.getId_curso());
		c.setJornada(curso.getJornada());
		c.setLetra(curso.getLetra());
		c.setLocal(curso.getLocal());
		c.setNivel(curso.getNivel());
		c.setNivel_ensenanza(curso.getNivel_ensenanza());
		c.setNumero_sala(curso.getNumero_sala());
		
		if (errores.hasErrors()) {
			return "Curso-ingresar";
		}	
		
		cursoS.CreateCurso(c);
		flash.addFlashAttribute("success","Curso ingresado correctamente");
		model.addAttribute("curso",c);
		return "redirect:/"; 
	}
	
	@GetMapping("/establecimiento/ingresar")
	public String establecimientoIngresar(Establecimiento establecimiento,Model model) {
		
		String[] comunas = { "Arica", "Camarones", "Putre", "General Lagos", "Iquique", "Alto Hospicio", "Pozo Almonte", "Camiña", "Colchane", "Huara", "Pica",
				"Antofagasta", "Mejillones", "Sierra Gorda", "Taltal", "Calama", "Ollagüe", "San Pedro de Atacama", "Tocopilla", "María Elena",
			 "Copiapó", "Caldera", "Tierra Amarilla", "Chañaral", "Diego de Almagro", "Vallenar", "Alto del Carmen", "Freirina", "Huasco",
			"La Serena", "Coquimbo", "Andacollo", "La Higuera", "Paiguano", "Vicuña", "Illapel", "Canela", "Los Vilos", "Salamanca", "Ovalle", "Combarbalá", "Monte Patria",
			"Punitaqui", "Río Hurtado" ,"Valparaíso", "Casablanca", "Concón", "Juan Fernández", "Puchuncaví", "Quintero", "Viña del Mar", "Isla de Pascua", "Los Andes", "Calle Larga",
			"Rinconada", "San Esteban", "La Ligua", "Cabildo", "Papudo", "Petorca", "Zapallar", "Quillota", "Calera", "Hijuelas", "La Cruz", "Nogales", "San Antonio", "Algarrobo", "Cartagena",
			"El Quisco", "El Tabo", "Santo Domingo", "San Felipe", "Catemu", "Llaillay", "Panquehue", "Putaendo", "Santa María", "Quilpué", "Limache", "Olmué", "Villa Alemana","Rancagua", "Codegua",
			"Coinco", "Coltauco", "Doñihue", "Graneros", "Las Cabras", "Machalí", "Malloa", "Mostazal", "Olivar", "Peumo", "Pichidegua", "Quinta de Tilcoco", "Rengo", "Requínoa", "San Vicente", "Pichilemu",
			"La Estrella", "Litueche", "Marchihue", "Navidad", "Paredones", "San Fernando", "Chépica", "Chimbarongo", "Lolol", "Nancagua", "Palmilla", "Peralillo", "Placilla", "Pumanque", "Santa Cruz","Talca",
			"Constitución", "Curepto", "Empedrado", "Maule", "Pelarco", "Pencahue", "Río Claro", "San Clemente", "San Rafael", "Cauquenes", "Chanco", "Pelluhue", "Curicó", "Hualañé", "Licantén", "Molina", "Rauco",
			"Romeral", "Sagrada Familia", "Teno", "Vichuquén", "Linares", "Colbún", "Longaví", "Parral", "Retiro", "San Javier", "Villa Alegre", "Yerbas Buenas","Cobquecura", "Coelemu", "Ninhue", "Portezuelo", "Quirihue",
			"Ránquil", "Treguaco", "Bulnes", "Chillán Viejo", "Chillán", "El Carmen", "Pemuco", "Pinto", "Quillón", "San Ignacio", "Yungay", "Coihueco", "Ñiquén", "San Carlos", "San Fabián", "San Nicolás","Concepción", "Coronel", 
			"Chiguayante", "Florida", "Hualqui", "Lota", "Penco", "San Pedro de la Paz", "Santa Juana", "Talcahuano", "Tomé", "Hualpén", "Lebu", "Arauco", "Cañete", "Contulmo", "Curanilahue", "Los Álamos", "Tirúa", "Los Ángeles",
			"Antuco", "Cabrero", "Laja", "Mulchén", "Nacimiento", "Negrete", "Quilaco", "Quilleco", "San Rosendo", "Santa Bárbara", "Tucapel", "Yumbel", "Alto Biobío", "Temuco", "Carahue", "Cunco", "Curarrehue", "Freire", "Galvarino",
			"Gorbea", "Lautaro", "Loncoche", "Melipeuco", "Nueva Imperial", "Padre las Casas", "Perquenco", "Pitrufquén", "Pucón", "Saavedra", "Teodoro Schmidt", "Toltén", "Vilcún", "Villarrica", "Cholchol", "Angol", "Collipulli",
			"Curacautín", "Ercilla", "Lonquimay", "Los Sauces", "Lumaco", "Purén", "Renaico", "Traiguén", "Victoria","Valdivia", "Corral", "Lanco", "Los Lagos", "Máfil", "Mariquina", "Paillaco", "Panguipulli", "La Unión", "Futrono", 
			"Lago Ranco", "Río Bueno", "Puerto Montt", "Calbuco", "Cochamó", "Fresia", "Frutillar", "Los Muermos", "Llanquihue", "Maullín", "Puerto Varas", "Castro", "Ancud", "Chonchi", "Curaco de Vélez", "Dalcahue", "Puqueldón",
			"Queilén", "Quellón", "Quemchi", "Quinchao", "Osorno", "Puerto Octay", "Purranque", "Puyehue", "Río Negro", "San Juan de la Costa", "San Pablo", "Chaitén", "Futaleufú", "Hualaihué", "Palena", "Coihaique", "Lago Verde",
			"Aisén", "Cisnes", "Guaitecas", "Cochrane", "O’Higgins", "Tortel", "Chile Chico", "Río Ibáñez", "Punta Arenas", "Laguna Blanca", "Río Verde", "San Gregorio", "Cabo de Hornos (Ex Navarino)", "Antártica", "Porvenir", "Primavera",
			"Timaukel", "Natales", "Torres del Paine", "Cerrillos", "Cerro Navia", "Conchalí", "El Bosque", "Estación Central", "Huechuraba", "Independencia", "La Cisterna", "La Florida", "La Granja", "La Pintana", "La Reina", "Las Condes",
			"Lo Barnechea", "Lo Espejo", "Lo Prado", "Macul", "Maipú", "Ñuñoa", "Pedro Aguirre Cerda", "Peñalolén", "Providencia", "Pudahuel", "Quilicura", "Quinta Normal", "Recoleta", "Renca", "Santiago", "San Joaquín", "San Miguel", "San Ramón",
			"Vitacura", "Puente Alto", "Pirque", "San José de Maipo", "Colina", "Lampa", "Tiltil", "San Bernardo", "Buin", "Calera de Tango", "Paine", "Melipilla", "Alhué", "Curacaví", "María Pinto", "San Pedro", "Talagante", "El Monte",
			"Isla de Maipo", "Padre Hurtado", "Peñaflor" };
		
		List<String> comunalist = new ArrayList<String>();
		for (String string : comunas) {
			comunalist.add(string);
		}
		
		model.addAttribute("comunas",comunalist);
		
		String[] regiones = {"Arica y Parinacota","Tarapacá","Antofagasta", "Atacama", "Coquimbo","Valparaíso",
				"Región del Libertador Gral. Bernardo O’Higgins",
				"Región del Maule","Región de Ñuble","Región del Biobío","Región de la Araucanía","Región de Los Ríos","Región de Los Lagos",
				"Región Aisén del Gral. Carlos Ibáñez del Campo",
				"Región de Magallanes y de la Antártica Chilena","Región Metropolitana de Santiago" };
		List<String> regionlist = new ArrayList<String>();
		for (String r : regiones) {
			regionlist.add(r);
		}
		model.addAttribute("regiones",regionlist);
		model.addAttribute("establecimiento",establecimiento);
		return "Establecimiento-ingresar";
	}
	
	@PostMapping(path = "/establecimiento/ingresado", consumes = "application/x-www-form-urlencoded")
	public String establecimientoIngresado(@Valid Establecimiento establecimiento,Errors errores, RedirectAttributes flash,Model model) {
		
		String[] comunas = { "Arica", "Camarones", "Putre", "General Lagos", "Iquique", "Alto Hospicio", "Pozo Almonte", "Camiña", "Colchane", "Huara", "Pica",
				"Antofagasta", "Mejillones", "Sierra Gorda", "Taltal", "Calama", "Ollagüe", "San Pedro de Atacama", "Tocopilla", "María Elena",
			 "Copiapó", "Caldera", "Tierra Amarilla", "Chañaral", "Diego de Almagro", "Vallenar", "Alto del Carmen", "Freirina", "Huasco",
			"La Serena", "Coquimbo", "Andacollo", "La Higuera", "Paiguano", "Vicuña", "Illapel", "Canela", "Los Vilos", "Salamanca", "Ovalle", "Combarbalá", "Monte Patria",
			"Punitaqui", "Río Hurtado" ,"Valparaíso", "Casablanca", "Concón", "Juan Fernández", "Puchuncaví", "Quintero", "Viña del Mar", "Isla de Pascua", "Los Andes", "Calle Larga",
			"Rinconada", "San Esteban", "La Ligua", "Cabildo", "Papudo", "Petorca", "Zapallar", "Quillota", "Calera", "Hijuelas", "La Cruz", "Nogales", "San Antonio", "Algarrobo", "Cartagena",
			"El Quisco", "El Tabo", "Santo Domingo", "San Felipe", "Catemu", "Llaillay", "Panquehue", "Putaendo", "Santa María", "Quilpué", "Limache", "Olmué", "Villa Alemana","Rancagua", "Codegua",
			"Coinco", "Coltauco", "Doñihue", "Graneros", "Las Cabras", "Machalí", "Malloa", "Mostazal", "Olivar", "Peumo", "Pichidegua", "Quinta de Tilcoco", "Rengo", "Requínoa", "San Vicente", "Pichilemu",
			"La Estrella", "Litueche", "Marchihue", "Navidad", "Paredones", "San Fernando", "Chépica", "Chimbarongo", "Lolol", "Nancagua", "Palmilla", "Peralillo", "Placilla", "Pumanque", "Santa Cruz","Talca",
			"Constitución", "Curepto", "Empedrado", "Maule", "Pelarco", "Pencahue", "Río Claro", "San Clemente", "San Rafael", "Cauquenes", "Chanco", "Pelluhue", "Curicó", "Hualañé", "Licantén", "Molina", "Rauco",
			"Romeral", "Sagrada Familia", "Teno", "Vichuquén", "Linares", "Colbún", "Longaví", "Parral", "Retiro", "San Javier", "Villa Alegre", "Yerbas Buenas","Cobquecura", "Coelemu", "Ninhue", "Portezuelo", "Quirihue",
			"Ránquil", "Treguaco", "Bulnes", "Chillán Viejo", "Chillán", "El Carmen", "Pemuco", "Pinto", "Quillón", "San Ignacio", "Yungay", "Coihueco", "Ñiquén", "San Carlos", "San Fabián", "San Nicolás","Concepción", "Coronel", 
			"Chiguayante", "Florida", "Hualqui", "Lota", "Penco", "San Pedro de la Paz", "Santa Juana", "Talcahuano", "Tomé", "Hualpén", "Lebu", "Arauco", "Cañete", "Contulmo", "Curanilahue", "Los Álamos", "Tirúa", "Los Ángeles",
			"Antuco", "Cabrero", "Laja", "Mulchén", "Nacimiento", "Negrete", "Quilaco", "Quilleco", "San Rosendo", "Santa Bárbara", "Tucapel", "Yumbel", "Alto Biobío", "Temuco", "Carahue", "Cunco", "Curarrehue", "Freire", "Galvarino",
			"Gorbea", "Lautaro", "Loncoche", "Melipeuco", "Nueva Imperial", "Padre las Casas", "Perquenco", "Pitrufquén", "Pucón", "Saavedra", "Teodoro Schmidt", "Toltén", "Vilcún", "Villarrica", "Cholchol", "Angol", "Collipulli",
			"Curacautín", "Ercilla", "Lonquimay", "Los Sauces", "Lumaco", "Purén", "Renaico", "Traiguén", "Victoria","Valdivia", "Corral", "Lanco", "Los Lagos", "Máfil", "Mariquina", "Paillaco", "Panguipulli", "La Unión", "Futrono", 
			"Lago Ranco", "Río Bueno", "Puerto Montt", "Calbuco", "Cochamó", "Fresia", "Frutillar", "Los Muermos", "Llanquihue", "Maullín", "Puerto Varas", "Castro", "Ancud", "Chonchi", "Curaco de Vélez", "Dalcahue", "Puqueldón",
			"Queilén", "Quellón", "Quemchi", "Quinchao", "Osorno", "Puerto Octay", "Purranque", "Puyehue", "Río Negro", "San Juan de la Costa", "San Pablo", "Chaitén", "Futaleufú", "Hualaihué", "Palena", "Coihaique", "Lago Verde",
			"Aisén", "Cisnes", "Guaitecas", "Cochrane", "O’Higgins", "Tortel", "Chile Chico", "Río Ibáñez", "Punta Arenas", "Laguna Blanca", "Río Verde", "San Gregorio", "Cabo de Hornos (Ex Navarino)", "Antártica", "Porvenir", "Primavera",
			"Timaukel", "Natales", "Torres del Paine", "Cerrillos", "Cerro Navia", "Conchalí", "El Bosque", "Estación Central", "Huechuraba", "Independencia", "La Cisterna", "La Florida", "La Granja", "La Pintana", "La Reina", "Las Condes",
			"Lo Barnechea", "Lo Espejo", "Lo Prado", "Macul", "Maipú", "Ñuñoa", "Pedro Aguirre Cerda", "Peñalolén", "Providencia", "Pudahuel", "Quilicura", "Quinta Normal", "Recoleta", "Renca", "Santiago", "San Joaquín", "San Miguel", "San Ramón",
			"Vitacura", "Puente Alto", "Pirque", "San José de Maipo", "Colina", "Lampa", "Tiltil", "San Bernardo", "Buin", "Calera de Tango", "Paine", "Melipilla", "Alhué", "Curacaví", "María Pinto", "San Pedro", "Talagante", "El Monte",
			"Isla de Maipo", "Padre Hurtado", "Peñaflor" };
		List<String> comunalist = new ArrayList<String>();
		for (String string : comunas) {
			comunalist.add(string);
		}
		model.addAttribute("comunas",comunalist);
		String[] regiones = {"Arica y Parinacota","Tarapacá","Antofagasta", "Atacama", "Coquimbo","Valparaíso",
				"Región del Libertador Gral. Bernardo O’Higgins",
				"Región del Maule","Región de Ñuble","Región del Biobío","Región de la Araucanía","Región de Los Ríos","Región de Los Lagos",
				"Región Aisén del Gral. Carlos Ibáñez del Campo",
				"Región de Magallanes y de la Antártica Chilena","Región Metropolitana de Santiago" };
		List<String> regionlist = new ArrayList<String>();
		for (String r : regiones) {
			regionlist.add(r);
		}
		model.addAttribute("regiones",regionlist);
		
		
		Establecimiento e = new Establecimiento();
		e.setComuna(establecimiento.getComuna());
		e.setCorreo_electronico(establecimiento.getCorreo_electronico());
		e.setDireccion(establecimiento.getDireccion());
		e.setFecha_aniversario(establecimiento.getFecha_aniversario());
		e.setNombre(establecimiento.getNombre());
		e.setNumero_telefonico(establecimiento.getNumero_telefonico());
		e.setPagina_web(establecimiento.getPagina_web());
		e.setRbd(establecimiento.getRbd());
		e.setRegion(establecimiento.getRegion());
		e.setZona_horaria(establecimiento.getZona_horaria());
		
		if (errores.hasErrors()) {
			return "Establecimiento-ingresar";
		}
		
		establecimientoS.createEstablecimiento(e);
		flash.addFlashAttribute("success","Establecimiento ingresado correctamente");
		model.addAttribute("establecimiento",e);
		return "redirect:/";
	}
	
}
