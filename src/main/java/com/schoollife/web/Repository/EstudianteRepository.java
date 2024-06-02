package com.schoollife.web.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.schoollife.web.Entities.Estudiante;

public interface EstudianteRepository extends JpaRepository<Estudiante, String>{
	List<Estudiante> findByEstablecimientoId(Integer establciemiento_id);
	 List<Estudiante> findByRunEstudianteContainingAndEstablecimientoId(String rut, Integer establecimientoId);
	
	@Query(value = "SELECT e.numero_matricula AS n_matricula, e.run_estudiante AS run_estudiante,\r\n"
			+ "e.nombre + ' ' + e.apaterno + ' ' + e.amaterno AS nombre, p.tipo_permanencia AS tipo_permanencia,\r\n"
			+ "c.nivel + ' '+ c.letra AS curso, c.nivel_ensenanza AS nivel_curso , e.estado AS estado, c.establecimiento_id AS establecimientos,"
			+ " e.acepta_clases_religion AS ACEPTARELIGION  \r\n"
			+ " FROM cursos c JOIN estudiantes e ON c.id_curso = e.curso_id JOIN programa_integracion p \r\n"
			+ " ON e.run_estudiante = p.estudiante_id WHERE e.nombre = %?1%", nativeQuery = true)
	public List<Estudiante> findAllByNombre(String nombre);
	
	@Query(value = "SELECT e.numero_matricula AS n_matricula, e.run_estudiante AS run_estudiante,\r\n"
			+ "e.nombre + ' ' + e.apaterno + ' ' + e.amaterno AS nombre, p.tipo_permanencia AS tipo_permanencia,\r\n"
			+ "c.nivel + ' '+ c.letra AS curso, c.nivel_ensenanza AS nivel_curso , e.estado AS estado, c.establecimiento_id AS establecimientos,"
			+ " e.acepta_clases_religion AS ACEPTARELIGION \r\n"
			+ " FROM cursos c JOIN estudiantes e ON c.id_curso = e.curso_id JOIN programa_integracion p \r\n"
			+ "ON e.run_estudiante = p.estudiante_id", nativeQuery = true)
	public List<Object[]> findMatriculas();
	
	
	
	
	
}
