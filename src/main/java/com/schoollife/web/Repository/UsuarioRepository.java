package com.schoollife.web.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.schoollife.web.Entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, String>{

}
