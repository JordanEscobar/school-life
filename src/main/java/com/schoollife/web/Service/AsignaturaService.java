package com.schoollife.web.Service;

import java.util.List;

import com.schoollife.web.Entities.Asignatura;

public interface AsignaturaService {
	
	List<Asignatura> getAsignaturasPorCurso(Integer curso_id);

}
