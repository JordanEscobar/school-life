package com.schoollife.web.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.schoollife.web.Entities.Historial_estudiante;

public interface Historial_estudianteRepository extends JpaRepository<Historial_estudiante, Integer>{
	List<Historial_estudiante> findByEstablecimiento(String establecimiento);
	List<Historial_estudiante> findByIdEstudiante(String idEstudiante);
}
