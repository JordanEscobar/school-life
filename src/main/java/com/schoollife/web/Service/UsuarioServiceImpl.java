package com.schoollife.web.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.schoollife.web.Entities.Usuario;
import com.schoollife.web.Repository.UsuarioRepository;

import jakarta.transaction.Transactional;

@Service
public class UsuarioServiceImpl implements UsuarioService{
	
	//@Autowired
   // private PasswordEncoder passwordEncoder;
	@Autowired
	private final UsuarioRepository usuarioR;
		
    public UsuarioServiceImpl( UsuarioRepository usuarioR) {
		super();
		this.usuarioR = usuarioR;
	}

    @Override
    @Transactional
	public void registerUser(Usuario usuario) {
       // String encodedPassword = passwordEncoder.encode(usuario.getPass());
        Usuario user = new Usuario();     
        //user.setPass(encodedPassword);
        user.setCorreo(usuario.getCorreo());
        user.setAmaterno(usuario.getAmaterno());
        user.setApaterno(usuario.getApaterno());
        user.setCargo(usuario.getCargo());
        user.setEstablecimiento_id(usuario.getEstablecimiento_id());
        user.setEstudios(usuario.getEstudios());
        user.setFecha_nacimiento(usuario.getFecha_nacimiento());
        user.setGenero(usuario.getGenero());
        user.setNombre(usuario.getNombre());
        user.setRol_id(usuario.getRol_id());
        user.setRut_usuario(usuario.getRut_usuario());
        user.setTelefono(usuario.getTelefono());
        usuarioR.save(user);
    }
	
	
	
	

}
