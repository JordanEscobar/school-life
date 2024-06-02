package com.schoollife.web.Controller;

import jakarta.servlet.http.HttpSession;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.schoollife.web.Entities.Usuario;
import com.schoollife.web.Service.EstablecimientoService;
import com.schoollife.web.Service.RolService;
import com.schoollife.web.Service.UsuarioService;

@Controller
public class UsuarioController {

	@Autowired
	private RolService rolS;
	@Autowired
	private EstablecimientoService establecimientoS;
	@Autowired
	private final UsuarioService userService;
	private BCryptPasswordEncoder encoder=new BCryptPasswordEncoder(12);
	public UsuarioController(
			RolService rolS, EstablecimientoService establecimientoS,
			UsuarioService userService) {
		super();
		this.rolS = rolS;
		this.establecimientoS = establecimientoS;
		this.userService = userService;

	}
	
	@GetMapping("/usuario")
	public String usuario(Model model, HttpSession sesion) {
		if(sesion.getAttribute("usuario")!=null)
		{
			List<Usuario> uSesion =  (List<Usuario>) sesion.getAttribute("usuario");
			model.addAttribute("uSesion",uSesion.get(0));
			model.addAttribute("establecimientoSesion", establecimientoS.findById(uSesion.get(0).getEstablecimiento_id()));
			model.addAttribute("usuario",sesion.getAttribute("usuario"));
			return "Usuario";
		}
		return "Login";	
	}
	
	@GetMapping("/registro")
	public String registroUsuario(Usuario usuario,Model model) {
		model.addAttribute("usuario",new Usuario());
		var roles = rolS.getAll();
		model.addAttribute("establecimientos",establecimientoS.getAll());
		model.addAttribute("roles",roles);
		return "Registro";	
	}

	@PostMapping(path = "/registrar", consumes = "application/x-www-form-urlencoded")
	public String registrarUsuario(Usuario usuario , Model model){

		var roles = rolS.getAll();
		model.addAttribute("roles",roles);
		
		Usuario us = new Usuario();
		us.setCorreo(usuario.getCorreo());
		us.setPass(usuario.getPass());
		us.setRoles(usuario.getRoles());
		us.setAmaterno(usuario.getAmaterno());
		us.setApaterno(usuario.getApaterno());
		us.setCargo(usuario.getCargo());
		us.setEstablecimiento_id(usuario.getEstablecimiento_id());
		us.setEstudios(usuario.getEstudios());
		us.setFecha_nacimiento(usuario.getFecha_nacimiento());
		us.setGenero(usuario.getGenero());
		us.setNombre(usuario.getNombre());
		us.setRut_usuario(usuario.getRut_usuario());
		us.setRol_id(usuario.getRol_id());
		us.setRoles(usuario.getRoles());
		us.setTelefono(usuario.getTelefono());
		userService.registerUser(usuario);
		System.out.println("Usuario creado: " + us);
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
				model.addAttribute("establecimientoSesion", establecimientoS.findById(uSesion.get(0).getEstablecimiento_id()));
				System.out.println("la sesion iniciada es: "+ sesion.getAttribute("usuario"));
				return "Index";
			}
			flash.addFlashAttribute("warning","Debe ingresar credenciales válidas");
			return "redirect:/login";
		}
		flash.addFlashAttribute("warning","Debe ingresar credenciales válidas");
		return "redirect:/login";		
	}



}
