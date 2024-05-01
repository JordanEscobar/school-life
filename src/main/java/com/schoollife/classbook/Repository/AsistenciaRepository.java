package com.schoollife.classbook.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.schoollife.classbook.Entities.Asistencia;

public interface AsistenciaRepository extends JpaRepository<Asistencia, Integer>{
	
	@Query(value = "SELECT DISTINCT CONCAT(es.nombre, ' ', es.apaterno) AS Alumnos, es.rut AS RUT, CONCAT(cur.grado, ' ', cur.seccion) AS CURSO " +
            "FROM profesores p " +
            "JOIN asignaturas asig ON p.id = asig.profesor_id " +
            "JOIN asistencia asis ON asig.id = asis.asignatura_id " +
            "JOIN estudiantes es ON asis.estudiante_id = es.id " +
            "JOIN cursos cur ON es.curso_id = cur.id " +
            "WHERE asig.profesor_id = :profesorId AND asig.id = :asignaturaId AND es.curso_id = :cursoId", nativeQuery = true)
    List<Object[]> obtenerDatosAlumnos(@Param("profesorId") Integer profesorId, @Param("asignaturaId") Integer asignaturaId, @Param("cursoId") Integer cursoId);
    
    //asistencia que ve un profesor filtrando el curso, la asignatura y el mes de las asistencias.
    @Query(value = "SELECT e.id AS ID, e.nombre +  ' ' + e.apaterno + ' ' + e.amaterno AS estudiante, a.estado AS estado,\r\n"
    		+ "asi.nombre  AS nombre_asignatura FROM estudiantes e \r\n"
    		+ "JOIN asistencias a ON e.id = a.estudiante_id \r\n"
    		+ "JOIN asignaturas asi ON a.asignatura_id = asi.id \r\n"
    		+ "JOIN profesores p ON asi.profesor_id = p.id \r\n"
    		+ "JOIN cursos cu ON p.id = cu.profesor_id\r\n"
    		+ "WHERE p.id = :profesorId AND asi.id = :asignaturaid AND cu.id = :cursoid AND MONTH(a.fecha) = :mes", nativeQuery = true)
    List<Object[]> asistenciaCurso(@Param("profesorId") Integer profesorId,@Param("asignaturaid") Integer asignaturaid, @Param("cursoid") Integer cursoid, @Param("mes") Integer mes);

}
