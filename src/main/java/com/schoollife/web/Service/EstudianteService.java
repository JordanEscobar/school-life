package com.schoollife.web.Service;

import java.util.Date;
import java.util.List;

import com.schoollife.web.Entities.Estudiante;

public interface EstudianteService {
	List<Estudiante> getAll();
	
	void updateEstudiante(Estudiante estudiante);
	
	Estudiante findEstudiante(Estudiante estudiante);
	
	Estudiante createEstudiante(Estudiante estudiante);
	
	//buscar por nombre o apellidos
	List<Estudiante> findPorEstudiante(String nombre);
	
	List<Estudiante> findPorEstudiantePorCodigo(String nombre);
	
	List<Object[]> findMatriculas();

}
