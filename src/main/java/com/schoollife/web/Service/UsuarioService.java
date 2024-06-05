package com.schoollife.web.Service;

import java.util.List;

import com.schoollife.web.Entities.Usuario;

public interface UsuarioService {
	
	void registerUser(Usuario usuario);
	List<Usuario> getAll();
	List<Usuario> buscarUsuarioCorreo(String correo);
	Usuario buscarUserPorCorreoYPass(String correo, String pass);

	
}
