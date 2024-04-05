package com.schoollife.classbook.Service;

import java.util.List;

import com.schoollife.classbook.Entities.Curso;

public interface CursoService {
	
	List<Curso> getAllCurso();
	
	Curso CreateCurso(Curso curso);

	Curso getCursoById(Integer id);

	void deleteCurso(Integer id);
	
	void updateCurso(Curso curso, Integer id);
	
    Curso findCurso(Curso curso);

}
