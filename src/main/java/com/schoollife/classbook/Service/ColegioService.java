package com.schoollife.classbook.Service;

import java.util.List;

import com.schoollife.classbook.Entities.Colegio;

public interface ColegioService {
	
	List<Colegio> getAllColegios(); 
	
	Colegio CreateColegio(Colegio colegio);

	Colegio getColegioById(Integer id);
	
	Colegio getColegioByUsuarioId(Integer idAdministrador);

	void deleteColegio(Integer id);
	
	void updateColegio(Colegio colegio, Integer id);
	
    Colegio findColegio(Colegio colegio);

}
