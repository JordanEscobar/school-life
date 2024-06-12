package com.schoollife.web.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.schoollife.web.Entities.Curso;

public interface CursoRepository extends JpaRepository<Curso, Integer>{
	
}
