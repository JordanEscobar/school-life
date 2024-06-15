package com.schoollife.web.Service;

import java.util.List;

import com.schoollife.web.Entities.Curso;
import com.schoollife.web.Entities.Usuario;

public interface UsuarioService {
	//registrar usuario nuevo
	void registerUser(Usuario usuario);
	//listar todos los usuarios de la aplicación
	List<Usuario> getAll();
	//listar a los usuarios de un establecimiento 
	List<Usuario> getByEstablecimiento(Integer rbd);
	//listar usuario por el correo electrónico
	List<Usuario> buscarUsuarioCorreo(String correo);
	//buscar usuario por correo y contraseña 
	Usuario buscarUserPorCorreoYPass(String correo, String pass);
	//eliminar usuario
	void deleteUser(String runUsuario);
	//buscar usuario por el run de usuario
	Usuario findUsuarioByRutUsuario(String rutUsuario);
	//actualizar usuario
	void updateUsuario(Usuario usuario, String rutUsuario);

	
}
