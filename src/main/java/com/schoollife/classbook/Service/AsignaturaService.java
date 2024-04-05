package com.schoollife.classbook.Service;

import java.util.List;

import com.schoollife.classbook.Entities.Asignatura;

public interface AsignaturaService {
	
	List<Asignatura> getAllAsignaturas();
	
	Asignatura CreateAsignatura(Asignatura asignatura);

	Asignatura getAsignaturaById(Integer id);

	void deleteAsignatura(Integer id);
	
	void updateAsignatura(Asignatura asignatura, Integer id);
	
    Asignatura findAsignatura(Asignatura asignatura);
	
	

}
