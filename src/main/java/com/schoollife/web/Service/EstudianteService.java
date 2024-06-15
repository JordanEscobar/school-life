package com.schoollife.web.Service;

import java.util.List;
import com.schoollife.web.Entities.Estudiante;

public interface EstudianteService {
	//Listar a los estudiantes por establecimiento
	List<Estudiante> getAll(Integer establecimiento_id);
	//listar a todos los estudiantes de la aplicación
	List<Estudiante> getAlls();
	//actualizar un estudiante
	void updateEstudiante(Estudiante estudiante, String run_estudiante);
	//cambiar estado de matricula a retirado
	void estadoMatriculaRetirado(Estudiante estudiante, String run_estudiante);
	//cambiar estado de matricula a matriculado
	void estadoMatriculaRecuperado(Estudiante estudiante, String run_estudiante);
	//actualizar estudiante a estudiante PIE
	void updateEstudiantePie(String estudianteId);
	//buscar estudiante
	Estudiante findEstudiante(Estudiante estudiante);
	//crear estudiante
	Estudiante createEstudiante(Estudiante estudiante);
	//filtrar estudiantes por nombre y apellidos por establecimiento
	List<Estudiante> findPorEstudiantePorCodigo(String nombre, Integer colegioId);
	//buscar estudiante de un establecimiento por rut
	List<Estudiante> findEstudiantePorRut(String rut, Integer colegioId);
	//filtrar estudiantes por curso
	List<Estudiante> findEstudiantePorCurso(Integer curso_id);
	//buscar matriculas
	List<Object[]> findMatriculas();
	//retornar el numero total de matriculados de un establecimiento
	Integer totalMatriculados(Integer establecimientoId);
	//retornar el numero total de hombres de un establecimiento
	Integer totalHombres(Integer establecimientoId);
	//retornar el numero total de mujeres de un establecimiento
	Integer totalMujeres(Integer establecimientoId);
	//retornar el numero total de otro genero de un establecimiento
	Integer totalOtro(Integer establecimientoId);
	//buscar estudiante por estado matriculado  o retirado de un establecimiento
	List<Estudiante> findEstudiantePorEstado(String estado, Integer colegioId);
	//buscar estudiante por pie
	List<Estudiante> findEstudiantePorPie(String pie);
	//cancelar matricula de un estudiante
	void cancelarMatricula(String estudianteid);
	//retorna un boolean para saber si el estudiante existe o no
	boolean estudianteExiste(String estudiante_id);
	//buscar un estudiante matriculado en un establecimiento a traves del run
	Estudiante findMatriculaExistente(String runEstudiante,Integer establecimientoId);
	
	

}
