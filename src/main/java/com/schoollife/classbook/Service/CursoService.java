package com.schoollife.classbook.Service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.schoollife.classbook.Entities.Curso;
import com.schoollife.classbook.Entities.Estudiante;

public interface CursoService {
	//listar todos los cursos
	List<Curso> getAll();
	//Actualizar curso
	void updateCurso(Curso curso, Integer id);
	//Buscar un curso por curso
	Curso findCurso(Curso curso);
	//Estudiantes de un curso
	List<Estudiante> getEstudianteByIdCurso(Integer id);
	//Curso por profesor jefe
	Curso getCursoByIdProfesorJefe(Integer id);
	//Servicio cursos por colegio
	List<Object[]> cursoPorColegio(Integer colegioId);
	//Crear
	Curso CreateCurso(Curso curso);
	//
	List<Object[]> cursosPorProfesor(Integer profesorId);

	
	

}
