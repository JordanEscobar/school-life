package com.schoollife.web.Service;

import java.util.List;

import com.schoollife.web.Entities.Establecimiento;

public interface EstablecimientoService {
	
	List<Establecimiento> getAll();
	void updateEstablecimiento(Establecimiento establecimiento, Integer rbd);
	Establecimiento findEstablecimiento(Establecimiento establecimiento);
	Establecimiento findById(Integer rbd);
	Establecimiento createEstablecimiento(Establecimiento establecimiento);
	
	List<String> comunas();
	List<String> regiones();
}
