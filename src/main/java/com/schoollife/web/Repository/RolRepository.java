package com.schoollife.web.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.schoollife.web.Entities.Rol;

public interface RolRepository extends JpaRepository<Rol, Integer>{
	Optional<Rol> findByNombre(String nombre);
}
