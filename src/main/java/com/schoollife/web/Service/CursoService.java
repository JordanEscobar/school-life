package com.schoollife.web.Service;

import java.util.List;

import com.schoollife.web.Entities.Curso;

public interface CursoService {
	
		//listar todos los cursos
		List<Curso> getAll();
		//Actualizar curso
		void updateCurso(Curso curso, Integer id);
		//Buscar un curso por curso
		Curso findCurso(Curso curso);
		//Crear
		Curso CreateCurso(Curso curso);
		

}
