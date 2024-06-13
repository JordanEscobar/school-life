package com.schoollife.web.Controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.schoollife.web.Entities.Curso;
import com.schoollife.web.Entities.Estudiante;
import com.schoollife.web.Entities.Hoja_de_vida;
import com.schoollife.web.Entities.Usuario;
import com.schoollife.web.Service.AsignaturaService;
import com.schoollife.web.Service.CursoService;
import com.schoollife.web.Service.EstablecimientoService;
import com.schoollife.web.Service.EstudianteService;
import com.schoollife.web.Service.Hoja_de_vidaService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
public class EstudianteController {
	
	@Autowired
	private final EstudianteService estudianteS;
	@Autowired
	private final EstablecimientoService establecimientoS;
	@Autowired
	private final CursoService cursoS;
	@Autowired
	private final AsignaturaService asignaturaS;
	@Autowired
	private final Hoja_de_vidaService hojaService;
	
	private static String UPLOADED_FOLDER = "C://Temp/uploads/";
	
	public EstudianteController(EstudianteService estudianteS, EstablecimientoService establecimientoS, CursoService cursoS,
			AsignaturaService asignaturaS, Hoja_de_vidaService hojaService) {
		super();
		this.estudianteS = estudianteS;
		this.establecimientoS = establecimientoS;
		this.cursoS = cursoS;
		this.asignaturaS = asignaturaS;
		this.hojaService = hojaService;
	}

	@GetMapping("/hojadevida")
	public String hojaVida(Model model,HttpSession sesion) {
		if(sesion.getAttribute("user") != null) {
			model.addAttribute("user",sesion.getAttribute("user"));
			List<Usuario> uSesion =  (List<Usuario>) sesion.getAttribute("user");
			model.addAttribute("uSesion",uSesion.get(0));
			model.addAttribute("cursos",cursoS.getAll(uSesion.get(0).getEstablecimientoId()));
			model.addAttribute("establecimientoSesion", establecimientoS.findById(uSesion.get(0).getEstablecimientoId()));	
			var estudiantes = estudianteS.getAll(uSesion.get(0).getEstablecimientoId());
			model.addAttribute("estudiantes",estudiantes);
			return "Hoja-de-vida";
		}
		return "Login";
	}
	
	@PostMapping(path = "/filtrarcursos", consumes = "application/x-www-form-urlencoded")
	public String filtroCursos(Model model, @RequestParam("filtrocursos") Integer filtrocursos,HttpSession sesion) {
		if(sesion.getAttribute("user") != null) {
			var estudiantes = estudianteS.findEstudiantePorCurso(filtrocursos);
			List<Usuario> uSesion =  (List<Usuario>) sesion.getAttribute("user");
			model.addAttribute("filtrocursos", filtrocursos);	
			model.addAttribute("user",sesion.getAttribute("user"));
			model.addAttribute("uSesion",uSesion.get(0));
			model.addAttribute("cursos",cursoS.getAll(uSesion.get(0).getEstablecimientoId()));
			model.addAttribute("establecimientoSesion", establecimientoS.findById(uSesion.get(0).getEstablecimientoId()));	
			model.addAttribute("estudiantes",estudiantes);
			return "Hoja-de-vida";
		}
		return "Login";
	}
	
	@GetMapping("/Hoja-de-vida/ingresar/{estudianteId}")
	public String hojaDeVidaIngresar(Hoja_de_vida hoja_de_vida, Model model,HttpSession sesion ) {
		if(sesion.getAttribute("user") != null) {
			List<Usuario> uSesion =  (List<Usuario>) sesion.getAttribute("user");
			model.addAttribute("user",sesion.getAttribute("user"));
			model.addAttribute("establecimientoSesion", establecimientoS.findById(uSesion.get(0).getEstablecimientoId()));		
			var estudianteSeleccionado = estudianteS.findEstudiantePorRut(hoja_de_vida.getEstudianteId(), uSesion.get(0).getEstablecimientoId());
			var asignaturas = asignaturaS.getAsignaturasPorCurso(estudianteSeleccionado.get(0).getCurso_id());
			model.addAttribute("asignaturas",asignaturas);
			model.addAttribute("hoja_de_vida",hoja_de_vida);
			return "Hoja-de-vida-ingresar";
		}
		return "Login";
		
	}
	
	@PostMapping("/Hoja-de-vida/ingresado")
	public String hojaDeVidaIngresado(@Valid Hoja_de_vida hoja_de_vida,Errors errores,RedirectAttributes flash,@RequestParam(name = "file",required = false) MultipartFile file, Model model, HttpSession sesion) {
		if(sesion.getAttribute("user") != null) {
			List<Usuario> uSesion =  (List<Usuario>) sesion.getAttribute("user");
			model.addAttribute("user",sesion.getAttribute("user"));
			model.addAttribute("establecimientoSesion", establecimientoS.findById(uSesion.get(0).getEstablecimientoId()));					
			var estudianteSeleccionado = estudianteS.findEstudiantePorRut(hoja_de_vida.getEstudianteId(), uSesion.get(0).getEstablecimientoId());
			var asignaturas = asignaturaS.getAsignaturasPorCurso(estudianteSeleccionado.get(0).getCurso_id());
			model.addAttribute("asignaturas",asignaturas);
			model.addAttribute("hoja_de_vida",hoja_de_vida);
						
			Hoja_de_vida hNueva = new Hoja_de_vida();
			hNueva.setAsignatura(hoja_de_vida.getAsignatura());
			hNueva.setDetalle(hoja_de_vida.getDetalle());
			hNueva.setEstudianteId(hoja_de_vida.getEstudianteId());
			hNueva.setFecha(new Date());
			hNueva.setTipoEvento(hoja_de_vida.getTipoEvento());
			hNueva.setUsuarioId(uSesion.get(0).getRutUsuario());
			hNueva.setId_hoja_de_vida(hoja_de_vida.getId_hoja_de_vida());
			
	        try {
	            // Guardar el archivo en el servidor
	            byte[] bytes = file.getBytes();
	            Date fechaHoy = new Date();	            
	            // Obtener el nombre original del archivo
	            String nombreOriginal = file.getOriginalFilename();	            
	            // Obtener la extensión del archivo (si es necesario)
	            String extension = "";
	            int lastIndex = nombreOriginal.lastIndexOf('.');
	            if (lastIndex > 0) {
	                extension = nombreOriginal.substring(lastIndex);
	            }	            
	            // Concatenar la fecha al nombre del archivo
	            String nombreConFecha = fechaHoy.getTime() +"_" + nombreOriginal  +  extension;            
	            // Crear la ruta del archivo con el nuevo nombre
	            Path path = Paths.get(UPLOADED_FOLDER + nombreConFecha);	            
	            // Escribir el archivo en el servidor
	            Files.write(path, bytes);            
	            // Guardar el nombre del archivo con fecha en el objeto hoja_de_vida
	            hoja_de_vida.setArchivo(nombreConFecha);	            
	            // Agregar el nombre del archivo con fecha al modelo
	            model.addAttribute("fileName", nombreConFecha);
	        } catch (IOException e) {
	            e.printStackTrace();	           
	        }			
			
			if (errores.hasErrors()) {
				return "Hoja-de-vida-ingresar";
			}
			hNueva.setArchivo(hoja_de_vida.getArchivo());
			hojaService.createHojaDeVida(hNueva);
			flash.addFlashAttribute("success","Hoja ingresada correctamente");
			return "redirect:/hojadevida";
		}
		return "Login";
	}
	@GetMapping("/Hoja-de-vida/ver/{estudianteId}")
	public String hojaDeVidaEstudiante(Hoja_de_vida hoja_de_vida,Model model,HttpSession sesion) {
		if(sesion.getAttribute("user") != null) {
			List<Usuario> uSesion =  (List<Usuario>) sesion.getAttribute("user");
			model.addAttribute("user",sesion.getAttribute("user"));
			model.addAttribute("establecimientoSesion", establecimientoS.findById(uSesion.get(0).getEstablecimientoId()));							
			
			var hojas = hojaService.getByEstudianteId(hoja_de_vida.getEstudianteId());
			model.addAttribute("hoja_de_vida",hojas);
			return "Hoja-de-vida-ver";
		}
		return "Login";
	}
	
	@GetMapping("/HojaDeVida/eliminar/{id_hoja_de_vida}")
	public String deleteHojaDeVida(Hoja_de_vida hoja_de_vida,RedirectAttributes flash,Model model,HttpSession sesion) {
		if(sesion.getAttribute("user") != null) {
			List<Usuario> uSesion =  (List<Usuario>) sesion.getAttribute("user");
			model.addAttribute("user",sesion.getAttribute("user"));
			model.addAttribute("establecimientoSesion", establecimientoS.findById(uSesion.get(0).getEstablecimientoId()));												
			model.addAttribute("uSesion",uSesion.get(0));
			model.addAttribute("cursos",cursoS.getAll(uSesion.get(0).getEstablecimientoId()));
			model.addAttribute("establecimientoSesion", establecimientoS.findById(uSesion.get(0).getEstablecimientoId()));	
			var estudiantes = estudianteS.getAll(uSesion.get(0).getEstablecimientoId());
			model.addAttribute("estudiantes",estudiantes);
						
			hojaService.deleteHojaDeVida(hoja_de_vida.getId_hoja_de_vida());			
			flash.addFlashAttribute("success","Hoja eliminada correctamente");
			return "redirect:/hojadevida";
		}
		return "Login";	
	}
	
	@GetMapping("/HojaDeVida/modificar/{id_hoja_de_vida}")
	public String updateHojaDeVida(Hoja_de_vida hoja_de_vida,Model model,HttpSession sesion) {
		if(sesion.getAttribute("user") != null) {
			List<Usuario> uSesion =  (List<Usuario>) sesion.getAttribute("user");
			model.addAttribute("user",sesion.getAttribute("user"));
			model.addAttribute("establecimientoSesion", establecimientoS.findById(uSesion.get(0).getEstablecimientoId()));		
			Hoja_de_vida hojaSeleccionada = hojaService.findById(hoja_de_vida.getId_hoja_de_vida());			
			var estudianteSeleccionado = estudianteS.findEstudiantePorRut(hojaSeleccionada.getEstudianteId(), uSesion.get(0).getEstablecimientoId());
			var asignaturas = asignaturaS.getAsignaturasPorCurso(estudianteSeleccionado.get(0).getCurso_id());
			model.addAttribute("asignaturas",asignaturas);
			model.addAttribute("hoja_de_vida",hojaSeleccionada);
			return "Hoja-de-vida-modificar";
		}
		return "Login";	
	}
	
	@PostMapping("/Hoja-de-vida/modificado")
	public String hojaDeVidaModificado(@Valid Hoja_de_vida hoja_de_vida,Errors errores,RedirectAttributes flash,@RequestParam(name = "file",required = false) MultipartFile file, Model model, HttpSession sesion) {
		if(sesion.getAttribute("user") != null) {
			List<Usuario> uSesion =  (List<Usuario>) sesion.getAttribute("user");
			model.addAttribute("user",sesion.getAttribute("user"));
			model.addAttribute("establecimientoSesion", establecimientoS.findById(uSesion.get(0).getEstablecimientoId()));					
			Hoja_de_vida hojaSeleccionada = hojaService.findById(hoja_de_vida.getId_hoja_de_vida());
			var estudianteSeleccionado = estudianteS.findEstudiantePorRut(hojaSeleccionada.getEstudianteId(), uSesion.get(0).getEstablecimientoId());
			var asignaturas = asignaturaS.getAsignaturasPorCurso(estudianteSeleccionado.get(0).getCurso_id());
			model.addAttribute("asignaturas",asignaturas);
			model.addAttribute("hoja_de_vida",hoja_de_vida);
						
			Hoja_de_vida hNueva = new Hoja_de_vida();
			hNueva.setAsignatura(hoja_de_vida.getAsignatura());
			hNueva.setDetalle(hoja_de_vida.getDetalle());			
			hNueva.setEstudianteId(hoja_de_vida.getEstudianteId());			
			hNueva.setFecha(hoja_de_vida.getFecha());
			hNueva.setTipoEvento(hoja_de_vida.getTipoEvento());			
			hNueva.setUsuarioId(hoja_de_vida.getUsuarioId());			
			hNueva.setId_hoja_de_vida(hoja_de_vida.getId_hoja_de_vida());
			
	        try {
	            // Guardar el archivo en el servidor
	            byte[] bytes = file.getBytes();
	            Date fechaHoy = new Date();	            
	            // Obtener el nombre original del archivo
	            String nombreOriginal = file.getOriginalFilename();	            
	            // Obtener la extensión del archivo (si es necesario)
	            String extension = "";
	            int lastIndex = nombreOriginal.lastIndexOf('.');
	            if (lastIndex > 0) {
	                extension = nombreOriginal.substring(lastIndex);
	            }	            
	            // Concatenar la fecha al nombre del archivo
	            String nombreConFecha = fechaHoy.getTime() +"_" + nombreOriginal  +  extension;            
	            // Crear la ruta del archivo con el nuevo nombre
	            Path path = Paths.get(UPLOADED_FOLDER + nombreConFecha);	            
	            // Escribir el archivo en el servidor
	            Files.write(path, bytes);            
	            // Guardar el nombre del archivo con fecha en el objeto hoja_de_vida
	            hoja_de_vida.setArchivo(nombreConFecha);	            
	            // Agregar el nombre del archivo con fecha al modelo
	            model.addAttribute("fileName", nombreConFecha);
	        } catch (IOException e) {
	            e.printStackTrace();	           
	        }			
			
			if (errores.hasErrors()) {
				return "Hoja-de-vida-ingresar";
			}
			hNueva.setArchivo(hoja_de_vida.getArchivo());
			hojaService.updateCurso(hoja_de_vida, hoja_de_vida.getId_hoja_de_vida());
			flash.addFlashAttribute("success","Hoja modificada correctamente");
			return "redirect:/hojadevida";
		}
		return "Login";
	}
	
	// filtrar por Rut
	@PostMapping(path = "/filtrarruthoja", consumes = "application/x-www-form-urlencoded")
	public String filtroRutHoja(Model model, @RequestParam("filtroruthoja") String filtroruthoja,HttpSession sesion) {
		if(sesion.getAttribute("user")!=null)
		{
			List<Usuario> uSesion =  (List<Usuario>) sesion.getAttribute("user");
			model.addAttribute("uSesion",uSesion.get(0));
			model.addAttribute("establecimientoSesion", establecimientoS.findById(uSesion.get(0).getEstablecimientoId()));
			model.addAttribute("user",sesion.getAttribute("user"));
			
			var estudiantes = estudianteS.findEstudiantePorRut(filtroruthoja, uSesion.get(0).getEstablecimientoId());
			var cursos = cursoS.getAll(uSesion.get(0).getEstablecimientoId());

			model.addAttribute("estudiantes", estudiantes);
			model.addAttribute("cursos", cursos);
			model.addAttribute("filtroruthoja", filtroruthoja);
			return "Hoja-de-vida";
		}
		return "Login";
	}
	
	@GetMapping("/matricula/estudiante/antiguo/ingresar")
	public String matriculaEstudianteAntiguo(Estudiante estudiante,Model model,HttpSession sesion) {
		if(sesion.getAttribute("user")!=null)
		{
			List<Usuario> uSesion =  (List<Usuario>) sesion.getAttribute("user");
			model.addAttribute("uSesion",uSesion.get(0));
			model.addAttribute("establecimientoSesion", establecimientoS.findById(uSesion.get(0).getEstablecimientoId()));
			model.addAttribute("user",sesion.getAttribute("user"));
			
			model.addAttribute("estudiante",estudiante);
			return "Matricula-estudiante-antiguo";
		}
		return "Login";
	}
	
	
}
