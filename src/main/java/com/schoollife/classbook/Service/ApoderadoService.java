package com.schoollife.classbook.Service;

import java.util.List;

import com.schoollife.classbook.Entities.Apoderado;

public interface ApoderadoService {

	//Buscar Apoderado por Estudiante
	List<Apoderado> apoderadoPorEstudiante(Integer estudianteid);
	//Crear
	Apoderado createApoderado(Apoderado apoderado);
}
