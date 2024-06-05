package com.schoollife.web.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.schoollife.web.Entities.Usuario;
import com.schoollife.web.Repository.UsuarioRepository;
import jakarta.transaction.Transactional;

@Service
public class UsuarioServiceImpl implements UsuarioService{
	
	@Autowired
	private final UsuarioRepository usuarioR;
	private BCryptPasswordEncoder encoder=new BCryptPasswordEncoder(12);
		
    public UsuarioServiceImpl( UsuarioRepository usuarioR) {
		super();
		this.usuarioR = usuarioR;
	}

    @Override
    @Transactional
	public void registerUser(Usuario usuario) {
        Usuario user = new Usuario();     
        user.setPass(encoder.encode(usuario.getPass()));
        user.setCorreo(usuario.getCorreo());
        user.setAmaterno(usuario.getAmaterno());
        user.setApaterno(usuario.getApaterno());
        user.setCargo(usuario.getCargo());
        user.setEstablecimientoId(usuario.getEstablecimientoId());
        user.setEstudios(usuario.getEstudios());
        user.setFecha_nacimiento(usuario.getFecha_nacimiento());
        user.setGenero(usuario.getGenero());
        user.setNombre(usuario.getNombre());
        user.setRolId(usuario.getRolId());
        user.setRut_usuario(usuario.getRut_usuario());
        user.setTelefono(usuario.getTelefono());
        usuarioR.save(user);
    }

	@Override
	@Transactional
	public List<Usuario> buscarUsuarioCorreo(String correo) {
		return usuarioR.findByCorreo(correo);
	}

	@Override
	@Transactional
	public Usuario buscarUserPorCorreoYPass(String correo, String pass) {
		return usuarioR.findByCorreoAndPass(correo, pass);
	}

	@Override
	@Transactional
	public List<Usuario> getAll() {
		return usuarioR.findAll();
	}

	
	
	
	

}
