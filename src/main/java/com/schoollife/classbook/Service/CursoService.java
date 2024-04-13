package com.schoollife.classbook.Service;

import java.util.List;

import com.schoollife.classbook.Entities.Curso;

public interface CursoService {
	
	List<Curso> getAllCurso();
	
	Curso CreateCurso(Curso curso);

	Curso getCursoById(Integer id);
	
	Curso getCursoByIdProfesorJefe(Integer id);

	void desactivarCurso(Curso curso, Integer id);
	
	void activarCurso(Curso curso, Integer id);
	
	void updateCurso(Curso curso, Integer id);
	
    Curso findCurso(Curso curso);

}
