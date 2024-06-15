package com.schoollife.web.Service;

import java.util.List;

import com.schoollife.web.Entities.Asignatura;

public interface AsignaturaService {
	//Listar asignaturas por el ID de un curso en especifico
	List<Asignatura> getAsignaturasPorCurso(Integer curso_id);

}
