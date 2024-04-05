package com.schoollife.classbook.Service;

import java.util.List;

import com.schoollife.classbook.Entities.Profesor;

public interface ProfesorService {
	
	List<Profesor> getAllProfesor();
	
	Profesor CreateProfesor(Profesor profesor);

	Profesor getProfesorById(Integer id);

	void deleteProfesor(Integer id);
	
	void updateProfesor(Profesor profesor, Integer id);
	
    Profesor findProfesor(Profesor profesor);

}
