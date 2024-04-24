package com.schoollife.classbook.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.schoollife.classbook.Entities.Asistencia;

public interface AsistenciaRepository extends JpaRepository<Asistencia, Integer>{
	
	@Query(value = "SELECT a.id,a.id_estudiante,a.estado,a.id_asignatura,a.fecha as FECHA,e.estado AS estado_estudiante, e.id AS idestudiante"
			+ ", e.rut, e.nombre, e.amaterno, e.apaterno, e.genero, e.direccion, e.telefono, e.correo, e.curso_id "
			+ "FROM estudiantes e INNER JOIN asistencia a ON(e.id = a.id_estudiante) "
			+ "WHERE e.nombre='lauras'", nativeQuery = true)
	List<Asistencia> listarAsistencia();
	
	@Query(value = "SELECT DISTINCT CONCAT(es.nombre, ' ', es.apaterno) AS Alumnos, es.rut AS RUT, CONCAT(cur.grado, ' ', cur.seccion) AS CURSO " +
            "FROM profesores p " +
            "JOIN asignaturas asig ON p.id = asig.id_profesor " +
            "JOIN asistencia asis ON asig.id = asis.id_asignatura " +
            "JOIN estudiantes es ON asis.id_estudiante = es.id " +
            "JOIN cursos cur ON es.curso_id = cur.id " +
            "WHERE asig.id_profesor = :profesorId AND asig.id = :asignaturaId AND es.curso_id = :cursoId", nativeQuery = true)
    List<Object[]> obtenerDatosAlumnos(@Param("profesorId") Integer profesorId, @Param("asignaturaId") Integer asignaturaId, @Param("cursoId") Integer cursoId);

}
