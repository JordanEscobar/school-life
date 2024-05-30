package com.schoollife.web.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.schoollife.web.Entities.Usuario;
import com.schoollife.web.Repository.UsuarioRepository;

import jakarta.transaction.Transactional;

@Service
public class UsuarioServiceImpl implements UsuarioService{
	
	@Autowired
	private final UsuarioRepository usuarioR;
	@Autowired
	private final PasswordEncoder passwordEncoder;
		
    public UsuarioServiceImpl( UsuarioRepository usuarioR, PasswordEncoder passwordEncoder) {
		super();
		this.usuarioR = usuarioR;
		this.passwordEncoder = passwordEncoder;
	}

    @Override
    @Transactional
	public void registerUser(Usuario usuario) {
    	String encoderPassword = this.passwordEncoder.encode(usuario.getPass());
        Usuario user = new Usuario();     
        user.setPass(encoderPassword);
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

	@Override
	public List<Usuario> buscarUsuarioCorreo(String correo) {
		return usuarioR.findByCorreoContaining(correo);
	}

	
	
	
	

}
