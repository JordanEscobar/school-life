package com.schoollife.web.Service;

import java.util.List;

import com.schoollife.web.Entities.Establecimiento;

public interface EstablecimientoService {
	//Listar a todos los establecimientos
	List<Establecimiento> getAll();
	//actualizar un establecimiento
	void updateEstablecimiento(Establecimiento establecimiento, Integer rbd);
	//buscar establecimiento
	Establecimiento findEstablecimiento(Establecimiento establecimiento);
	//buscar establecimiento por ID
	Establecimiento findById(Integer rbd);
	//crear un nuevo establecimiento
	Establecimiento createEstablecimiento(Establecimiento establecimiento);
	//Listado de las comunas de Chile
	List<String> comunas();
	//Listado de las regiones de Chile
	List<String> regiones();
}
