package com.schoollife.web.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.schoollife.web.Entities.Establecimiento;
import com.schoollife.web.Entities.Usuario;
import com.schoollife.web.Service.EstablecimientoService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class EstablecimientoController {
	@Autowired
	private final EstablecimientoService establecimientoS;

	public EstablecimientoController(EstablecimientoService establecimientoS) {
		super();
		this.establecimientoS = establecimientoS;
	}
	@GetMapping("/establecimiento")
	public String indexEstablecimiento(Model model,HttpSession sesion) {
		if(sesion.getAttribute("usuario")!=null)
		{
			model.addAttribute("usuario",sesion.getAttribute("usuario"));
			List<Usuario> uSesion =  (List<Usuario>) sesion.getAttribute("usuario");
			model.addAttribute("uSesion",uSesion.get(0));
			model.addAttribute("establecimientoSesion", establecimientoS.findById(uSesion.get(0).getEstablecimiento_id()));

			var e = establecimientoS.getAll();
			model.addAttribute("establecimientos",e);
			model.addAttribute("usuario",sesion.getAttribute("usuario"));
			return "Establecimiento";
		}
		return "Login";

	}
	
	@GetMapping("/establecimiento/ingresar")
	public String establecimientoIngresar(Establecimiento establecimiento,Model model, HttpSession sesion) {
		if(sesion.getAttribute("usuario")!=null)
		{
			model.addAttribute("usuario",sesion.getAttribute("usuario"));
			List<Usuario> uSesion =  (List<Usuario>) sesion.getAttribute("usuario");
			model.addAttribute("uSesion",uSesion.get(0));
			model.addAttribute("establecimientoSesion", establecimientoS.findById(uSesion.get(0).getEstablecimiento_id()));
			model.addAttribute("regiones",establecimientoS.regiones());
			model.addAttribute("comunas",establecimientoS.comunas());
			model.addAttribute("establecimiento",establecimiento);
			model.addAttribute("usuario",sesion.getAttribute("usuario"));
			return "Establecimiento-ingresar";
		}
		return "Login";
		

	}
	
	@PostMapping(path = "/establecimiento/ingresado", consumes = "application/x-www-form-urlencoded")
	public String establecimientoIngresado(@Valid Establecimiento establecimiento,Errors errores, RedirectAttributes flash,Model model,HttpSession sesion) {
		
		if(sesion.getAttribute("usuario")!=null)
		{
			model.addAttribute("usuario",sesion.getAttribute("usuario"));
			List<Usuario> uSesion =  (List<Usuario>) sesion.getAttribute("usuario");
			model.addAttribute("uSesion",uSesion.get(0));
			model.addAttribute("establecimientoSesion", establecimientoS.findById(uSesion.get(0).getEstablecimiento_id()));
			
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
		return "Login";
				
	}
	
	@GetMapping("/establecimiento/modificar/{rbd}")
	public String establecimientoModificar(Establecimiento establecimiento,Model model,HttpSession sesion ) {
		if(sesion.getAttribute("usuario")!=null)
		{
			model.addAttribute("usuario",sesion.getAttribute("usuario"));
			List<Usuario> uSesion =  (List<Usuario>) sesion.getAttribute("usuario");
			model.addAttribute("uSesion",uSesion.get(0));
			model.addAttribute("establecimientoSesion", establecimientoS.findById(uSesion.get(0).getEstablecimiento_id()));

			establecimiento = establecimientoS.findEstablecimiento(establecimiento);
			model.addAttribute("establecimiento",establecimiento);
			model.addAttribute("regiones",establecimientoS.regiones());
			model.addAttribute("comunas",establecimientoS.comunas());
			model.addAttribute("usuario",sesion.getAttribute("usuario"));
			return "Establecimiento-modificar";
		}
		return "Login";

	}
	
	@PostMapping(path = "/establecimiento/modificado", consumes = "application/x-www-form-urlencoded")
	public String establecimientoModificada(@Valid Establecimiento establecimiento,Errors errores,RedirectAttributes flash,Model model,HttpSession sesion) {	
		if(sesion.getAttribute("usuario")!=null)
		{
			model.addAttribute("usuario",sesion.getAttribute("usuario"));
			List<Usuario> uSesion =  (List<Usuario>) sesion.getAttribute("usuario");
			model.addAttribute("uSesion",uSesion.get(0));
			model.addAttribute("establecimientoSesion", establecimientoS.findById(uSesion.get(0).getEstablecimiento_id()));

			var establecimientos = establecimientoS.getAll();
			Establecimiento e = new Establecimiento();
			for (Establecimiento es : establecimientos) {
				if(es.getRbd() == establecimiento.getRbd()) {
					e.setFecha_aniversario(es.getFecha_aniversario());
					e.setComuna(es.getComuna());
					e.setCorreo_electronico(es.getCorreo_electronico());
					e.setDireccion(es.getDireccion());
					e.setNombre(es.getNombre());
					e.setNumero_telefonico(es.getNumero_telefonico());
					e.setPagina_web(es.getPagina_web());
					e.setRegion(es.getRegion());
					e.setZona_horaria(es.getZona_horaria());
					e.setRbd(es.getRbd());
				}
			}
			
			if (errores.hasErrors()) {
				return "Establecimiento-modificar";
			}	
			
			establecimientoS.updateEstablecimiento(establecimiento, establecimiento.getRbd());
			flash.addFlashAttribute("success","Establecimiento modificado correctamente");
			model.addAttribute("establecimiento",establecimiento);		
			return "redirect:/establecimiento";
		}
		return "Login";
	}
	
	

}
