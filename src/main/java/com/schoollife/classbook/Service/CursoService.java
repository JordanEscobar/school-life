package com.schoollife.classbook.Service;

import java.util.List;
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
	//Cursos de un colegio y estado
	List<Curso> cursoPorColegio(Integer colegioid);
	
	

}
