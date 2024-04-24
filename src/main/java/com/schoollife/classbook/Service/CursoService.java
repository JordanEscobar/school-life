package com.schoollife.classbook.Service;

import java.util.List;
import com.schoollife.classbook.Entities.Curso;
import com.schoollife.classbook.Entities.Estudiante;

public interface CursoService {
	
	List<Curso> getAll();
	void updateCurso(Curso curso, Integer id);
	Curso findCurso(Curso curso);
	List<Estudiante> getEstudianteByIdCurso(Integer id);
	
	Curso getCursoByIdProfesorJefe(Integer id);

}
