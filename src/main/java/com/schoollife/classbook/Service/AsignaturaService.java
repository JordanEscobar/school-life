package com.schoollife.classbook.Service;

import java.util.List;

import com.schoollife.classbook.Entities.Asignatura;

public interface AsignaturaService {
	//Listar 
	List<Asignatura> getAllAsignaturas();
	// Crear
	Asignatura CreateAsignatura(Asignatura asignatura);
	//buscar por ID
	Asignatura getAsignaturaById(Integer id);

	//actualizar asignatura
	void updateAsignatura(Asignatura asignatura, Integer id);
	//Buscar asignatura por asignatura
    Asignatura findAsignatura(Asignatura asignatura);
    //Buscar asignaturas por profesor
    List<Asignatura> asignaturaPorProfesor(Integer profesorid);
	//Buscar por estado 
    List<Asignatura> asignaturaPorEstado(String estado);
  //Buscar por dia 
    List<Asignatura> asignaturaPorDia(String dia);
	

}
