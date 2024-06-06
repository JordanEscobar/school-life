package com.schoollife.web.Controller;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.schoollife.web.Entities.Usuario;
import com.schoollife.web.Service.EstablecimientoService;
import com.schoollife.web.Service.RolService;
import com.schoollife.web.Service.RutValidationService;
import com.schoollife.web.Service.UsuarioService;

@Controller
public class UsuarioController {

	@Autowired
	private RolService rolS;
	@Autowired
	private EstablecimientoService establecimientoS;
	@Autowired
	private final RutValidationService rutValidationService;
	@Autowired
	private final UsuarioService userService;
	
	private BCryptPasswordEncoder encoder=new BCryptPasswordEncoder(12);
	public UsuarioController(
			RolService rolS, EstablecimientoService establecimientoS,
			UsuarioService userService, RutValidationService rutValidationService) {
		super();
		this.rolS = rolS;
		this.establecimientoS = establecimientoS;
		this.userService = userService;
		this.rutValidationService = rutValidationService;

	}
	
	@GetMapping("/usuario")
	public String usuario(Model model, HttpSession sesion) {
		if(sesion.getAttribute("usuario")!=null)
		{
			List<Usuario> uSesion =  (List<Usuario>) sesion.getAttribute("usuario");
			model.addAttribute("uSesion",uSesion.get(0));
			model.addAttribute("establecimientoSesion", establecimientoS.findById(uSesion.get(0).getEstablecimientoId()));
			model.addAttribute("usuario",sesion.getAttribute("usuario"));
			var roles = rolS.getAll();
			model.addAttribute("roles",roles);
			var usuarios = userService.getByEstablecimiento(uSesion.get(0).getEstablecimientoId());
			model.addAttribute("usuarios",usuarios);
			return "Usuario";
		}
		return "Login";	
	}
	
	@GetMapping("/registro")
	public String registroUsuario(Usuario usuario,Model model) {
		model.addAttribute("usuario",new Usuario());
		
		boolean rutinvalido3 = false;
		model.addAttribute("rutinvalido3", rutinvalido3);
		boolean rutex3 =false;
		model.addAttribute("rutexiste3",rutex3);
		boolean correoexiste3 =false;
		model.addAttribute("correoexiste3",correoexiste3);
		var roles = rolS.getAll();
		model.addAttribute("establecimientos",establecimientoS.getAll());
		model.addAttribute("roles",roles);
		return "Registro";	
	}

	@PostMapping(path = "/registrar", consumes = "application/x-www-form-urlencoded")
	public String registrarUsuario(@Valid Usuario usuario ,Errors errores, Model model,RedirectAttributes flash){

		var roles = rolS.getAll();
		model.addAttribute("roles",roles);
		model.addAttribute("establecimientos",establecimientoS.getAll());
		boolean rutinvalido3 = false;
		model.addAttribute("rutinvalido3", rutinvalido3);
		boolean rutex3 =false;
		model.addAttribute("rutexiste3",rutex3);
		boolean correoexiste3 =false;
		model.addAttribute("correoexiste3",correoexiste3);
		
		Usuario us = new Usuario();
		
		for (Usuario user : userService.getAll()) {
			if(usuario.getCorreo().equals(user.getCorreo())) {
				correoexiste3 =true;
				model.addAttribute("correoexiste3",correoexiste3);
				return "Registro";
			}else {
				correoexiste3 =false;
				model.addAttribute("correoexiste3",correoexiste3);
				us.setCorreo(usuario.getCorreo());
			}
		}
		
		us.setPass(usuario.getPass());
		us.setRoles(usuario.getRoles());
		us.setAmaterno(usuario.getAmaterno());
		us.setApaterno(usuario.getApaterno());
		us.setCargo(usuario.getCargo());
		us.setEstablecimientoId(usuario.getEstablecimientoId());
		us.setEstudios(usuario.getEstudios());
		us.setFecha_nacimiento(usuario.getFecha_nacimiento());
		us.setGenero(usuario.getGenero());
		us.setNombre(usuario.getNombre());
		
		if(rutValidationService.isValidRut(usuario.getRut_usuario())) {
			for (Usuario u : userService.getAll()) {
				if(usuario.getRut_usuario().equals(u.getRut_usuario())) {
					rutex3 =true;
					model.addAttribute("rutexiste3",rutex3);
					return "Registro";
				}else {
					rutex3 =false;
					model.addAttribute("rutexiste3",rutex3);
					us.setRut_usuario(usuario.getRut_usuario());
				}
			}		
		}else {
			rutinvalido3 = true;
			model.addAttribute("rutinvalido3", rutinvalido3);
			return "Registro";				
		}
	
		us.setRolId(usuario.getRolId());
		us.setRoles(usuario.getRoles());
		us.setTelefono(usuario.getTelefono());
		
		if (errores.hasErrors()) {
			return "Registro";
		}
		
		userService.registerUser(usuario);
		flash.addFlashAttribute("success","Usuario creado correctamente");
		return "redirect:/login";
	}
	
	@GetMapping("/login")
	public String login( Usuario usuario,Model model) {
		
		boolean passisBlank = false;
		boolean correoisBlank = false;		
		model.addAttribute("passisBlank",passisBlank);
		model.addAttribute("correoisBlank",correoisBlank);
		model.addAttribute("usuario",usuario);
		return "Login";
	}
	
	@PostMapping(path = "/logearse", consumes = "application/x-www-form-urlencoded")
	public String loginUsuario(Usuario usuario,RedirectAttributes flash, Model model,HttpSession sesion) {
		
		if(usuario.getCorreo().isBlank() || usuario.getCorreo().isEmpty()) {
			flash.addFlashAttribute("warning","Debe ingresar credenciales válidas");
			return "redirect:/login";
		}
		if(usuario.getPass().isBlank() || usuario.getPass().isEmpty()) {
			flash.addFlashAttribute("warning","Debe ingresar credenciales válidas");
			return "redirect:/login";
		}
		
		if(userService.buscarUsuarioCorreo(usuario.getCorreo()).isEmpty()) {
			flash.addFlashAttribute("warning","Debe ingresar credenciales válidas");
			return "redirect:/login";
		}
		
		if(userService.buscarUsuarioCorreo(usuario.getCorreo()) != null) {
			var user = userService.buscarUsuarioCorreo(usuario.getCorreo());
			if(encoder.matches(usuario.getPass(), user.get(0).getPass())) {
				
				sesion.setAttribute("usuario", user);
				model.addAttribute("usuario",sesion.getAttribute("usuario"));
				List<Usuario> uSesion =  (List<Usuario>) sesion.getAttribute("usuario");
				model.addAttribute("uSesion",uSesion.get(0));
				model.addAttribute("establecimientoSesion", establecimientoS.findById(uSesion.get(0).getEstablecimientoId()));
				return "Index";
			}
			flash.addFlashAttribute("warning","Debe ingresar credenciales válidas");
			return "redirect:/login";
		}
		flash.addFlashAttribute("warning","Debe ingresar credenciales válidas");
		return "redirect:/login";		
	}
	@GetMapping("/usuario/eliminar/{rut_usuario}")
	public String deleteUsuario(Usuario usuario,Model model,HttpSession sesion, RedirectAttributes flash) {
		if(sesion.getAttribute("usuario")!=null)
		{
			List<Usuario> uSesion =  (List<Usuario>) sesion.getAttribute("usuario");
			model.addAttribute("uSesion",uSesion.get(0));
			model.addAttribute("establecimientoSesion", establecimientoS.findById(uSesion.get(0).getEstablecimientoId()));
			model.addAttribute("usuario",sesion.getAttribute("usuario"));
			
			userService.deleteUser(usuario.getRut_usuario());
			flash.addFlashAttribute("warning","Usuario eliminado correctamente");
			return "redirect:/usuario";
		}
		return "Login";
	}



}
