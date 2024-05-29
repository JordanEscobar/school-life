package com.schoollife.web.Controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.schoollife.web.Dto.DtoLogin;
import com.schoollife.web.Entities.Rol;
import com.schoollife.web.Entities.Usuario;
import com.schoollife.web.Repository.RolRepository;
import com.schoollife.web.Repository.UsuarioRepository;
import com.schoollife.web.Security.JwtGenerador;
import com.schoollife.web.Service.EstablecimientoService;
import com.schoollife.web.Service.RolService;

@Controller
public class UsuarioController {
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private UsuarioRepository usuarioR;
	@Autowired
	private RolRepository rolR;
	@Autowired
	private JwtGenerador jwtGenerador;
	@Autowired
	private RolService rolS;
	@Autowired
	private EstablecimientoService establecimientoS;
	
	public UsuarioController(AuthenticationManager authenticationManager, PasswordEncoder passwordEncoder,
			UsuarioRepository usuarioR, RolRepository rolR, JwtGenerador jwtGenerador, RolService rolS, EstablecimientoService establecimientoS) {
		super();
		this.authenticationManager = authenticationManager;
		this.passwordEncoder = passwordEncoder;
		this.usuarioR = usuarioR;
		this.rolR = rolR;
		this.jwtGenerador = jwtGenerador;
		this.rolS = rolS;
		this.establecimientoS = establecimientoS;
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
	public String registrarUsuario(@ModelAttribute Usuario usuario , Model model){
		if(usuarioR.existsByCorreo(usuario.getCorreo())) {
			new ResponseEntity<>("El usuario ya existe",HttpStatus.BAD_REQUEST);
			return "redirect:/registro";
		}
		var roles = rolS.getAll();
		model.addAttribute("roles",roles);
		
		Usuario us = new Usuario();
		us.setCorreo(usuario.getCorreo());
		us.setPass(passwordEncoder.encode(usuario.getPass()));
		Rol rol = rolR.findByNombre("USER").get();
		us.setRoles(Collections.singletonList(rol));
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
		usuarioR.save(us);
		System.out.println("Usuario creado: " + us);
		return "redirect:/login";
	}
	
	@GetMapping("/login")
	public String login(Usuario usuario,Model model) {
		model.addAttribute("usuario",new Usuario());
		return "Login";
	}
	
	@PostMapping(path = "/logearse", consumes = "application/x-www-form-urlencoded")
	public String loginUsuario(@ModelAttribute Usuario usuario, Model model) {
		try {
            Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(usuario.getCorreo(), usuario.getPass()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            String token = jwtGenerador.generarToken(authentication);
            List<Usuario> usuarioConectado = usuarioR.findByCorreoContaining(usuario.getCorreo());
            System.out.println("El usuario es:" + usuarioConectado);
            model.addAttribute("usuario",usuarioConectado);
            System.out.println("El token de la autenticación es: " + token);
            System.out.println("la autenticacion es: " + authentication);
            return "Index";
        } catch (BadCredentialsException e) {
            System.out.println("Error de autenticación: " + e.getMessage());
            model.addAttribute("error", "Usuario o contraseña incorrectos");
            return "Login";
        }
	}



}
