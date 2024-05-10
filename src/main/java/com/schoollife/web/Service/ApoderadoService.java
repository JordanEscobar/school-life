package com.schoollife.web.Service;

import java.util.List;

import com.schoollife.web.Entities.Apoderado;

public interface ApoderadoService {
	
	List<Apoderado> getAll();
	
	void updateApoderado(Apoderado apoderado);
	
	Apoderado findApoderado(Apoderado apoderado);
	
	Apoderado createApoderado(Apoderado apoderado);


}
