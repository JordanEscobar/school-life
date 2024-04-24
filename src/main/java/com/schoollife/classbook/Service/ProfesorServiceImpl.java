package com.schoollife.classbook.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schoollife.classbook.Entities.Profesor;
import com.schoollife.classbook.Repository.ProfesorRepository;

import jakarta.transaction.Transactional;

@Service
public class ProfesorServiceImpl implements ProfesorService{
	
	@Autowired
	public final ProfesorRepository profesorRepository;

	public ProfesorServiceImpl(ProfesorRepository profesorRepository) {
		super();
		this.profesorRepository = profesorRepository;
	}

	@Override
	@Transactional
	public List<Profesor> getAllProfesor() {
		return profesorRepository.findAll();
	}

	@Override
	@Transactional
	public Profesor CreateProfesor(Profesor profesor) {
		return profesorRepository.save(profesor);
	}

	@Override
	@Transactional
	public Profesor getProfesorById(Integer id) {
		return profesorRepository.findById(id).get();
	}

	@Override
	@Transactional
	public void deleteProfesor(Integer id) {
		profesorRepository.deleteById(id);
		
	}

	@Override
	@Transactional
	public void updateProfesor(Profesor profesor, Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional
	public Profesor findProfesor(Profesor profesor) {
		return profesorRepository.findById(profesor.getId()).orElse(null);
	}
	
	
}
