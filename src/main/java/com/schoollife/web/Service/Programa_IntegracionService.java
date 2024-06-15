package com.schoollife.web.Service;

import java.util.List;

import com.schoollife.web.Entities.Programa_Integracion;

public interface Programa_IntegracionService {
	//listar programa de integracion
	List<Programa_Integracion> getAll();
	//Actualizar programa de integracion
	void updatePrograma(Programa_Integracion programa, Integer id);
	//Buscar  programa de integracion
	Programa_Integracion findPrograma(Programa_Integracion programa);
	//buscar programa de integracion por run de estudiante
	List<Programa_Integracion> findProgramaPorEstudiante(String run_estudiante);
	//Crear programa integracion
	Programa_Integracion CreatePrograma(Programa_Integracion programa);

}
