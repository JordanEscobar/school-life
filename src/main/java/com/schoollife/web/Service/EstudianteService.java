package com.schoollife.web.Service;

import java.util.List;
import com.schoollife.web.Entities.Estudiante;

public interface EstudianteService {
	List<Estudiante> getAll(Integer establecimiento_id);
	
	void updateEstudiante(Estudiante estudiante, String run_estudiante);
	void estadoMatriculaRetirado(Estudiante estudiante, String run_estudiante);
	void updateEstudiantePie(String estudianteId);
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
	List<Estudiante> findEstudiantePorEstado(String estado);
	List<Estudiante> findEstudiantePorPie(String pie);
	
	

}
