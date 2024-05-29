package com.schoollife.web.Security;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.schoollife.web.Entities.Rol;
import com.schoollife.web.Entities.Usuario;
import com.schoollife.web.Repository.UsuarioRepository;

@Service
public class CustomUsuarioDetailsService implements UserDetailsService{
	@Autowired
	private UsuarioRepository usuarioR;
	
	public CustomUsuarioDetailsService(UsuarioRepository usuarioR) {
		super();
		this.usuarioR = usuarioR;
	}
	
	public Collection<GrantedAuthority> mapToAuthorities(List<Rol> roles){		
		return roles.stream().map(role-> new SimpleGrantedAuthority(role.getNombre())).collect(Collectors.toList());
	}

	@Override
	public UserDetails loadUserByUsername(String correo) throws UsernameNotFoundException {
		Usuario u = usuarioR.findByCorreo(correo).orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));
		return new User(u.getCorreo(),u.getPass(), mapToAuthorities(u.getRoles()));
	}

}
