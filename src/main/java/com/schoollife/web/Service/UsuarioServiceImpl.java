package com.schoollife.web.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.schoollife.web.Entities.Curso;
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
        user.setRutUsuario(usuario.getRutUsuario());
        user.setTelefono(usuario.getTelefono());
        user.setRolId(usuario.getRolId());
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

	@Override
	@Transactional
	public List<Usuario> getByEstablecimiento(Integer rbd) {
		return usuarioR.findByEstablecimientoId(rbd);
	}

	@Override
	@Transactional
	public void deleteUser(String runUsuario) {
		usuarioR.deleteById(runUsuario);
	}

	@Override
	@Transactional
	public Usuario findUsuarioByRutUsuario(String rutUsuario) {
		return usuarioR.findByRutUsuario(rutUsuario);
	}

	@Override
	@Transactional
	public void updateUsuario(Usuario usuario, String rutUsuario) {
		Optional<Usuario> usuarioId = usuarioR.findById(rutUsuario);
		Usuario userN = usuarioId.get();
		userN.setAmaterno(usuario.getAmaterno());
		userN.setApaterno(usuario.getApaterno());
		userN.setCargo(usuario.getCargo());
		userN.setCorreo(usuario.getCorreo());
		userN.setEstablecimientoId(usuario.getEstablecimientoId());
		userN.setEstudios(usuario.getEstudios());
		userN.setFecha_nacimiento(usuario.getFecha_nacimiento());
		userN.setGenero(usuario.getGenero());
		userN.setNombre(usuario.getNombre());
		userN.setPass(encoder.encode(usuario.getPass()));
		userN.setRolId(usuario.getRolId());
		userN.setRutUsuario(usuario.getRutUsuario());
		userN.setTelefono(usuario.getTelefono());
		usuarioR.save(userN);
		
	}

	
	
	
	

}
