package com.schoollife.web.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.schoollife.web.Entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, String>{
	//busca a un usuario por su correo ESTE ES 
	Optional<Usuario> findByCorreo(String correo);
	
	List<Usuario> findByCorreoContaining(String correo);
}
