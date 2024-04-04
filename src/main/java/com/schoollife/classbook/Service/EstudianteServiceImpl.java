package com.schoollife.classbook.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schoollife.classbook.Entities.Estudiante;
import com.schoollife.classbook.Repository.EstudianteRepository;

@Service
public class EstudianteServiceImpl implements EstudianteService{
	
	@Autowired
	public final EstudianteRepository estudianteRepository;

	public EstudianteServiceImpl(EstudianteRepository estudianteRepository) {
		super();
		this.estudianteRepository = estudianteRepository;
	}

	@Override
	public List<Estudiante> getAllEstudiante() {
		return (List<Estudiante>) estudianteRepository.findAll();
	}

}
