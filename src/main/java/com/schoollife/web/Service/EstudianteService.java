package com.schoollife.web.Service;

import java.util.Date;
import java.util.List;

import com.schoollife.web.Entities.Estudiante;

public interface EstudianteService {
	List<Estudiante> getAll();
	
	void updateEstudiante(Estudiante estudiante);
	
	Estudiante findEstudiante(Estudiante estudiante);
	
	Estudiante createEstudiante(Estudiante estudiante);
	
	//filtrar estudiantes por nombre y apellidos y funciona
	List<Estudiante> findPorEstudiantePorCodigo(String nombre);
	//filtrar estudiantes por curso
	List<Estudiante> findEstudiantePorCurso(Integer curso_id);
	
	List<Object[]> findMatriculas();
	
	Integer totalMatriculados();
	Integer totalHombres();
	Integer totalMujeres();
	Integer totalOtro();

}
