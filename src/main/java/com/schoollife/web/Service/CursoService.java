package com.schoollife.web.Service;

import java.util.List;

import com.schoollife.web.Entities.Curso;

public interface CursoService {
	
		//listar todos los cursos por establecimientos
		List<Curso> getAll(Integer rbd);
		//Actualizar curso
		void updateCurso(Curso curso, Integer id);
		//Buscar un curso por curso
		Curso findCurso(Curso curso);
		//Crear un curso
		Curso CreateCurso(Curso curso);
		//listar letras del abecedario
		List<String> abecedario();
		//buscar por ID
		Curso findById(Integer idCurso);
		

}
