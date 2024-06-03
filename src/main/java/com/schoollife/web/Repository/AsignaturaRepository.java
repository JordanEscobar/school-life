package com.schoollife.web.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.schoollife.web.Entities.Asignatura;

public interface AsignaturaRepository extends JpaRepository<Asignatura, Integer>{
	List<Asignatura> findByCursoId(Integer curso_id);

}
