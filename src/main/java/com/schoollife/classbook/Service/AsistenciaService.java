package com.schoollife.classbook.Service;

import java.util.List;

import com.schoollife.classbook.Entities.Asistencia;

public interface AsistenciaService {
	
	List<Asistencia> getAllAsistencias();
	
	Asistencia CreateAsistencia(Asistencia asistencia);

	Asistencia getAsistenciaById(Integer id);

	void deleteAsistencia(Integer id);
	
	void updateAsistencia(Asistencia asistencia, Integer id);
	
    Asistencia findAsistencia(Asistencia asistencia);

}
