package com.schoollife.classbook.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schoollife.classbook.Entities.Profesor;
import com.schoollife.classbook.Repository.ProfesorRepository;

@Service
public class ProfesorServiceImpl implements ProfesorService{
	
	@Autowired
	public final ProfesorRepository profesorRepository;

	public ProfesorServiceImpl(ProfesorRepository profesorRepository) {
		super();
		this.profesorRepository = profesorRepository;
	}

	@Override
	public List<Profesor> getAllProfesor() {
		return (List<Profesor>) profesorRepository.findAll();
	}
	
	
}
