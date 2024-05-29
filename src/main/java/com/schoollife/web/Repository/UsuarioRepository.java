package com.schoollife.web.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.schoollife.web.Entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, String>{
	//busca a un usuario por su correo
	Optional<Usuario> findByCorreo(String correo);
	//verifica si existe el correo en la BD
	boolean existsByCorreo(String correo);
}
