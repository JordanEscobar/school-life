package com.schoollife.web.Controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.schoollife.web.Entities.Curso;
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
		if(sesion.getAttribute("usuario") != null) {
			model.addAttribute("usuario",sesion.getAttribute("usuario"));
			List<Usuario> uSesion =  (List<Usuario>) sesion.getAttribute("usuario");
			model.addAttribute("uSesion",uSesion.get(0));
			model.addAttribute("cursos",cursoS.getAll(uSesion.get(0).getEstablecimiento_id()));
			model.addAttribute("establecimientoSesion", establecimientoS.findById(uSesion.get(0).getEstablecimiento_id()));	
			var estudiantes = estudianteS.getAll(uSesion.get(0).getEstablecimiento_id());
			model.addAttribute("estudiantes",estudiantes);
			return "Hoja-de-vida";
		}
		return "Login";
	}
	
	@PostMapping(path = "/filtrarcursos", consumes = "application/x-www-form-urlencoded")
	public String filtroCursos(Model model, @RequestParam("filtrocursos") Integer filtrocursos,HttpSession sesion) {
		if(sesion.getAttribute("usuario") != null) {
			var estudiantes = estudianteS.findEstudiantePorCurso(filtrocursos);
			List<Usuario> uSesion =  (List<Usuario>) sesion.getAttribute("usuario");
			model.addAttribute("filtrocursos", filtrocursos);	
			model.addAttribute("usuario",sesion.getAttribute("usuario"));
			model.addAttribute("uSesion",uSesion.get(0));
			model.addAttribute("cursos",cursoS.getAll(uSesion.get(0).getEstablecimiento_id()));
			model.addAttribute("establecimientoSesion", establecimientoS.findById(uSesion.get(0).getEstablecimiento_id()));	
			model.addAttribute("estudiantes",estudiantes);
			return "Hoja-de-vida";
		}
		return "Login";
	}
	
	@GetMapping("/Hoja-de-vida/ingresar/{estudianteId}")
	public String hojaDeVidaIngresar(Hoja_de_vida hoja_de_vida, Model model,HttpSession sesion ) {
		if(sesion.getAttribute("usuario") != null) {
			List<Usuario> uSesion =  (List<Usuario>) sesion.getAttribute("usuario");
			model.addAttribute("usuario",sesion.getAttribute("usuario"));
			model.addAttribute("establecimientoSesion", establecimientoS.findById(uSesion.get(0).getEstablecimiento_id()));		
			var estudianteSeleccionado = estudianteS.findEstudiantePorRut(hoja_de_vida.getEstudianteId(), uSesion.get(0).getEstablecimiento_id());
			var asignaturas = asignaturaS.getAsignaturasPorCurso(estudianteSeleccionado.get(0).getCurso_id());
			model.addAttribute("asignaturas",asignaturas);
			model.addAttribute("hoja_de_vida",hoja_de_vida);
			return "Hoja-de-vida-ingresar";
		}
		return "Login";
		
	}
	
	@PostMapping(path = "/Hoja-de-vida/ingresado", consumes = "application/x-www-form-urlencoded")
	public String hojaDeVidaIngresado(@Valid Hoja_de_vida hoja_de_vida,Errors errores,RedirectAttributes flash, Model model, HttpSession sesion) {
		if(sesion.getAttribute("usuario") != null) {
			List<Usuario> uSesion =  (List<Usuario>) sesion.getAttribute("usuario");
			model.addAttribute("usuario",sesion.getAttribute("usuario"));
			model.addAttribute("establecimientoSesion", establecimientoS.findById(uSesion.get(0).getEstablecimiento_id()));					
			var estudianteSeleccionado = estudianteS.findEstudiantePorRut(hoja_de_vida.getEstudianteId(), uSesion.get(0).getEstablecimiento_id());
			var asignaturas = asignaturaS.getAsignaturasPorCurso(estudianteSeleccionado.get(0).getCurso_id());
			model.addAttribute("asignaturas",asignaturas);
			model.addAttribute("hoja_de_vida",hoja_de_vida);
						
			Hoja_de_vida hNueva = new Hoja_de_vida();
			hNueva.setArchivo(hoja_de_vida.getArchivo());
			hNueva.setAsignatura(hoja_de_vida.getAsignatura());
			hNueva.setDetalle(hoja_de_vida.getDetalle());
			hNueva.setEstudianteId(hoja_de_vida.getEstudianteId());
			hNueva.setFecha(new Date());
			hNueva.setTipoEvento(hoja_de_vida.getTipoEvento());
			hNueva.setUsuarioId(uSesion.get(0).getRut_usuario());
			Integer idHojaAutoincrement = hojaService.getByEstudianteId(hoja_de_vida.getEstudianteId()).size() + 1;
			hNueva.setId_hoja_de_vida(idHojaAutoincrement);
			
			if (errores.hasErrors()) {
				return "Hoja-de-vida-ingresar";
			}
			
			hojaService.createHojaDeVida(hNueva);
			flash.addFlashAttribute("success","Hoja ingresada correctamente");
			return "redirect:/hojadevida";
		}
		return "Login";
	}
	@GetMapping("/Hoja-de-vida/ver/{estudianteId}")
	public String hojaDeVidaEstudiante(Hoja_de_vida hoja_de_vida,Model model,HttpSession sesion) {
		if(sesion.getAttribute("usuario") != null) {
			List<Usuario> uSesion =  (List<Usuario>) sesion.getAttribute("usuario");
			model.addAttribute("usuario",sesion.getAttribute("usuario"));
			model.addAttribute("establecimientoSesion", establecimientoS.findById(uSesion.get(0).getEstablecimiento_id()));							
			var hojas = hojaService.getByEstudianteId(hoja_de_vida.getEstudianteId());
			model.addAttribute("hoja_de_vida",hojas);
			return "Hoja-de-vida-ver";
		}
		return "Login";
	}
	
	@GetMapping("/HojaDeVida/eliminar/{id_hoja_de_vida}")
	public String deleteHojaDeVida(Hoja_de_vida hoja_de_vida,RedirectAttributes flash,Model model,HttpSession sesion) {
		if(sesion.getAttribute("usuario") != null) {
			List<Usuario> uSesion =  (List<Usuario>) sesion.getAttribute("usuario");
			model.addAttribute("usuario",sesion.getAttribute("usuario"));
			model.addAttribute("establecimientoSesion", establecimientoS.findById(uSesion.get(0).getEstablecimiento_id()));												
			model.addAttribute("uSesion",uSesion.get(0));
			model.addAttribute("cursos",cursoS.getAll(uSesion.get(0).getEstablecimiento_id()));
			model.addAttribute("establecimientoSesion", establecimientoS.findById(uSesion.get(0).getEstablecimiento_id()));	
			var estudiantes = estudianteS.getAll(uSesion.get(0).getEstablecimiento_id());
			model.addAttribute("estudiantes",estudiantes);
						
			hojaService.deleteHojaDeVida(hoja_de_vida.getId_hoja_de_vida());			
			flash.addFlashAttribute("success","Hoja eliminada correctamente");
			return "redirect:/hojadevida";
		}
		return "Login";
		
		
	}

}
