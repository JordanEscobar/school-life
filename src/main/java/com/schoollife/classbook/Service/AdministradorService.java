package com.schoollife.classbook.Service;

import java.util.List;

import com.schoollife.classbook.Entities.Administrador;

public interface AdministradorService {
	
	List<Administrador> findAll();
	Administrador administradorLogin(String mail);

}
