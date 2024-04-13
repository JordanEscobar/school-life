package com.schoollife.classbook.Service;

import java.util.List;

import com.schoollife.classbook.Entities.Estudiante;

public interface EstudianteService {
	
	List<Estudiante> getAllEstudiante();
	
	Estudiante CreateEstudiante(Estudiante estudiante);

	Estudiante getEstudianteById(Integer id);
	
	List<Estudiante> getEstudianteByIdCurso(Integer id);

	void deleteEstudiante(Integer id);
	
	void updateEstudiante(Estudiante estudiante, Integer id);
	
    Estudiante findEstudiante(Estudiante estudiante);

}
