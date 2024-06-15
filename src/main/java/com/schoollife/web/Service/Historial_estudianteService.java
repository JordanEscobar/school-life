package com.schoollife.web.Service;

import java.util.List;

import com.schoollife.web.Entities.Historial_estudiante;

public interface Historial_estudianteService {
	//listar historial de estudiantes de un establecimiento
	List<Historial_estudiante> getAll(String establecimiento);
	//listar historial de estudiante por rut del estudiante
	List<Historial_estudiante> getByEstudiante(String estudianteId);
	//crear historial de estudiante
	Historial_estudiante createHistorial_estudiante(Historial_estudiante historial_estudiante);
}
