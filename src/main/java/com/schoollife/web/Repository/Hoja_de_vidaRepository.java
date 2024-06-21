package com.schoollife.web.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.schoollife.web.Entities.Hoja_de_vida;

public interface Hoja_de_vidaRepository extends JpaRepository<Hoja_de_vida, Integer>{
	//Buscar anotaciones por rut del estudiante
	List<Hoja_de_vida> findByEstudianteId(String runEstudiante);
	//Buscar anotaciones por tipo de evento
	List<Hoja_de_vida> findByTipoEventoAndEstudianteId(String tipoEvento, String estudianteId);
}
