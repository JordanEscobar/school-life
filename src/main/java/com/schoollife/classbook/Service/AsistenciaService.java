package com.schoollife.classbook.Service;

import java.util.List;

import com.schoollife.classbook.Entities.Asistencia;

public interface AsistenciaService {
	//Listar las asistencias
	List<Asistencia> getAllAsistencias();
	//Crear asistencia
	Asistencia CreateAsistencia(Asistencia asistencia);
	//Buscar asistencia por ID
	Asistencia getAsistenciaById(Integer id);
	//Actualizar asistencia
	void updateAsistencia(Asistencia asistencia, Integer id);
	//Buscar asistencia por Asistencia
    Asistencia findAsistencia(Asistencia asistencia);
    //Es una Query que se encuentra en Repository
    List<Object[]> obtenerDatos(Integer profesorId, Integer asignaturaId, Integer cursoId);
  //Es una Query que se encuentra en Repository
    List<Object[]> asistenciaCurso(Integer profesorId,Integer asignaturaid, Integer cursoid, Integer mes);
  //Metodo para buscar la asistencia por estudiantes
    List<Asistencia> asistenciaPorEstudiante(Integer estudianteId);
    
    
    
    

}
