package com.schoollife.classbook.Service;

import java.util.List;

import com.schoollife.classbook.Entities.Estudiante;

public interface EstudianteService {
	//Listar
	List<Estudiante> getAllEstudiante();
	//Crear
	Estudiante CreateEstudiante(Estudiante estudiante);
	//Buscar por ID
	Estudiante getEstudianteById(Integer id);
	//Buscar estudiante por colegio y curso
	List<Estudiante> estudiantePorColegioYCurso(Integer cursoid, Integer colegioid);
	//Actualizar
	void updateEstudiante(Estudiante estudiante, Integer id);
	//Buscar estudiante por estudiante
    Estudiante findEstudiante(Estudiante estudiante);
    
    //Buscar estudiantes SEP
  	List<Estudiante> estudiantesSep(String sep);
  	
  //Buscar estudiantes PIE
  	List<Estudiante> estudiantesPie(String pie);
  	
    //Buscar estudiantes PIE Botton
  	List<Estudiante> estudiantePie();
  //Buscar estudiantes SEP Botton
  	List<Estudiante> estudianteSep();
  	//estudiante login
  	Estudiante estudianteLogin(String mail);
  	//Estudiantes por asistencias a través del ID estudiantes de asistencia
  	List<Estudiante> estudiantesPorAsistencias(Integer asistenciaid);

}
