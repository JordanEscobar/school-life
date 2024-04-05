package com.schoollife.classbook.Service;

import java.util.List;

import com.schoollife.classbook.Entities.Matricula;

public interface MatriculaService {
	
	List<Matricula> getAllMatricula();
	
	Matricula CreateMatricula(Matricula matricula);

	Matricula getMatriculaById(Integer id);

	void deleteMatricula(Integer id);
	
	void updateMatricula(Matricula matricula, Integer id);
	
    Matricula findMatricula(Matricula matricula);

}
