package com.schoollife.classbook.Service;

import java.util.List;

import com.schoollife.classbook.Entities.Asignatura;

public interface Registro_asignaturaService {
	
	List<Asignatura> getAsignaturaByIdProfesor(Integer id);

}
