package com.schoollife.web.Controller;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	public UsuarioController(
			RolService rolS, EstablecimientoService establecimientoS,
			UsuarioService userService) {
		super();
		this.rolS = rolS;
		this.establecimientoS = establecimientoS;
		this.userService = userService;

	}
	
	@GetMapping("/usuario")
	public String usuario(Model model) {
		
		return "Usuario";	
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
		model.addAttribute("usuario",usuario);
		return "Login";
	}
	
	@PostMapping(path = "/logearse", consumes = "application/x-www-form-urlencoded")
	public String loginUsuario(Usuario usuario) {

			return "Index";		
	}



}
