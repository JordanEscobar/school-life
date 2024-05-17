package com.schoollife.web.Service;

import java.util.List;

import com.schoollife.web.Entities.Programa_Integracion;

public interface Programa_IntegracionService {
	//listar
	List<Programa_Integracion> getAll();
	//Actualizar
	void updatePrograma(Programa_Integracion programa, Integer id);
	//Buscar 
	Programa_Integracion findPrograma(Programa_Integracion programa);
	List<Programa_Integracion> findProgramaPorEstudiante(String run_estudiante);
	//Crear
	Programa_Integracion CreatePrograma(Programa_Integracion programa);

}
