package com.schoollife.classbook.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.schoollife.classbook.Entities.Curso;

public interface CursoRepository extends JpaRepository<Curso, Integer>{
	//cursos por colegio incluyendo el profesor jefe
	@Query(value = "SELECT cur.id AS CURSOID, CONCAT(cur.grado, ' ', cur.seccion) AS CURSO, CONCAT(p.nombre, ' ', p.apaterno) AS PROFESORES,"
			+ "cur.estado AS ESTADOS, co.id AS COLEGIOID  " +
            " FROM colegios co " +
            "JOIN profesores p ON co.id = p.colegio_id " +
            "JOIN cursos cur ON p.id = cur.profesor_id " +
            "WHERE co.id = :colegioId", nativeQuery = true)
    List<Object[]> cursoPorColegio(@Param("colegioId") Integer colegioId);
    
    
    @Query(value = "SELECT DISTINCT  cu.grado + ' ' + cu.seccion AS CURSO, asig.nombre AS ASIGNATURA, cu.id AS IDCURSO FROM profesores p JOIN  asignaturas asig ON p.id = asig.profesor_id JOIN asistencias asis ON asig.id = asis.asignatura_id\r\n"
    		+ "JOIN estudiantes e ON asis.estudiante_id = e.id JOIN cursos cu ON e.curso_id = cu.id\r\n"
    		+ "WHERE asig.profesor_id = :profesorId", nativeQuery = true)
    List<Object[]> cursosPorProfesor(@Param("profesorId") Integer profesorId);

}
