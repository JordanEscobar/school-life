package com.schoollife.web.Service;

import java.util.List;
import com.schoollife.web.Entities.Estudiante;

public interface EstudianteService {
	List<Estudiante> getAll(Integer establecimiento_id);
	List<Estudiante> getAlls();
	
	void updateEstudiante(Estudiante estudiante, String run_estudiante);
	void estadoMatriculaRetirado(Estudiante estudiante, String run_estudiante);
	void estadoMatriculaRecuperado(Estudiante estudiante, String run_estudiante);
	void updateEstudiantePie(String estudianteId);
	Estudiante findEstudiante(Estudiante estudiante);
	Estudiante createEstudiante(Estudiante estudiante);
	//filtrar estudiantes por nombre y apellidos y funciona
	List<Estudiante> findPorEstudiantePorCodigo(String nombre, Integer colegioId);
	List<Estudiante> findEstudiantePorRut(String rut, Integer colegioId);
	//filtrar estudiantes por curso
	List<Estudiante> findEstudiantePorCurso(Integer curso_id);
	List<Object[]> findMatriculas();
	Integer totalMatriculados(Integer establecimientoId);
	Integer totalHombres(Integer establecimientoId);
	Integer totalMujeres(Integer establecimientoId);
	Integer totalOtro(Integer establecimientoId);
	List<Estudiante> findEstudiantePorEstado(String estado, Integer colegioId);
	List<Estudiante> findEstudiantePorPie(String pie);
	void cancelarMatricula(String estudianteid);
	
	

}
