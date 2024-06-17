package com.schoollife.web.Service;

import java.util.List;

import com.schoollife.web.Entities.Apoderado;

public interface ApoderadoService {
	//listar a todos los apoderados de la aplicación
	List<Apoderado> getAll();
	//actualizar un apoderado
	void updateApoderado(Apoderado apoderado);
	//Buscar apoderado
	Apoderado findApoderado(Apoderado apoderado);
	//Buscar a los apoderados por el run del estudiante
	List<Apoderado> findApoderadoPorEstudiante(String run_estudiante);
	//crear un apoderado
	Apoderado createApoderado(Apoderado apoderado);
	//eliminar apoderado
	void deleteApoderado(String apoderadoid);
	
	


}
