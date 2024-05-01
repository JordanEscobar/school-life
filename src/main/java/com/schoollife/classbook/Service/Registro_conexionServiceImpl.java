package com.schoollife.classbook.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schoollife.classbook.Entities.Registro_conexion;
import com.schoollife.classbook.Repository.Registro_conexionRepository;

import jakarta.transaction.Transactional;

@Service
public class Registro_conexionServiceImpl implements Registro_conexionService{
	@Autowired
	private final Registro_conexionRepository registro_conexionRepository;

	public Registro_conexionServiceImpl(Registro_conexionRepository registro_conexionRepository) {
		super();
		this.registro_conexionRepository = registro_conexionRepository;
	}

	@Override
	@Transactional
	public List<Registro_conexion> registrosPorColegio(Integer colegioid) {
		List<Registro_conexion> registros = registro_conexionRepository.findAll();
		registros = registros.stream().filter(r -> r.getColegio_id() == colegioid).collect(Collectors.toList());
		return registros;
	}

	@Override
	@Transactional 
	public Registro_conexion crearRegistro(Registro_conexion registro) {
		return registro_conexionRepository.save(registro);
	}

}
