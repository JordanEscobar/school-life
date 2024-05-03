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

}
