package com.schoollife.classbook.Service;

import java.util.List;

import com.schoollife.classbook.Entities.Apoderado;

public interface ApoderadoService {
	
	List<Apoderado> getAllApoderados();
	
	Apoderado CreateApoderado(Apoderado apoderado);

	Apoderado getApoderadoById(Integer id);

	void deleteApoderado(Integer id);
	
	void updateApoderado(Apoderado apoderado, Integer id);
	
    Apoderado findApoderado(Apoderado apoderado);

}
