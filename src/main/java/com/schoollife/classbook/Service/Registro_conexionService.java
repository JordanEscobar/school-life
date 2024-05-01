package com.schoollife.classbook.Service;

import java.util.List;

import com.schoollife.classbook.Entities.Registro_conexion;

public interface Registro_conexionService {
	
	List<Registro_conexion> registrosPorColegio(Integer colegioid);
	
	Registro_conexion crearRegistro(Registro_conexion registro);

}
