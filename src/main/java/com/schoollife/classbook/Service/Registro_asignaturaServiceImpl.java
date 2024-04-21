package com.schoollife.classbook.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schoollife.classbook.Entities.Asignatura;
import com.schoollife.classbook.Entities.Registro_asignatura;
import com.schoollife.classbook.Repository.Registro_asignaturaRepository;

import jakarta.transaction.Transactional;

@Service
public class Registro_asignaturaServiceImpl implements Registro_asignaturaService{
	
	@Autowired
	private final Registro_asignaturaRepository registro_asignaturaRepository;

	public Registro_asignaturaServiceImpl(Registro_asignaturaRepository registro_asignaturaRepository) {
		super();
		this.registro_asignaturaRepository = registro_asignaturaRepository;
	}

	@Override
	@Transactional
	public List<Asignatura> getAsignaturaByIdProfesor(Integer id) {
		List<Registro_asignatura> registro_asignaturas = (List<Registro_asignatura>) registro_asignaturaRepository.findAll();
		
		
		
		return null;
	}
	
	

}
