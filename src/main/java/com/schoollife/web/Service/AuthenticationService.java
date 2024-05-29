/*package com.schoollife.web.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.schoollife.web.Entities.Usuario;
import com.schoollife.web.Repository.UsuarioRepository;

@Service
public class AuthenticationService {
	
	@Autowired
    private PasswordEncoder passwordEncoder;
	@Autowired
	private final UsuarioRepository usuarioR;
		
    public AuthenticationService(PasswordEncoder passwordEncoder, UsuarioRepository usuarioR) {
		super();
		this.passwordEncoder = passwordEncoder;
		this.usuarioR = usuarioR;
	}
    
    public boolean authenticate(String correo, String rawPassword) {
        Usuario user = usuarioR.findByCorreo(correo);
        if (user != null) {
            return passwordEncoder.matches(rawPassword, user.getPass());
        }
        return false;
    }
    
    

}*/
