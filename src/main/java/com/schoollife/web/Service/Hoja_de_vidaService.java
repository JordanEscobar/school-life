package com.schoollife.web.Service;

import java.util.List;
import com.schoollife.web.Entities.Hoja_de_vida;

public interface Hoja_de_vidaService {
	//Buscar Hojas de vida por run del estudiante
	List<Hoja_de_vida> getByEstudianteId(String runEstudiante);
	//Buscar hojas de vida por ID 
	Hoja_de_vida findById(Integer id);
	//Crear una hoja de vida
	Hoja_de_vida createHojaDeVida(Hoja_de_vida hoja);
	//Eliminar una hoja de vida por el ID
	void deleteHojaDeVida(Integer id);
	//Actualizar una hoja de vida
	void updateCurso(Hoja_de_vida hoja, Integer id);
	//Retornar una lista con los años de las hojas de vida segun el run de un estudiante
	List<Integer> getDistinctYears(String estudianteId);
	//Buscar anotaciones por tipo de evento
	List<Hoja_de_vida> findByTipoEventoAndEstudianteId(String tipoEvento, String estudianteId);
}
