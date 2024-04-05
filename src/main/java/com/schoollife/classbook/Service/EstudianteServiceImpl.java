package com.schoollife.classbook.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schoollife.classbook.Entities.Estudiante;
import com.schoollife.classbook.Repository.EstudianteRepository;

import jakarta.transaction.Transactional;

@Service
public class EstudianteServiceImpl implements EstudianteService{
	
	@Autowired
	public final EstudianteRepository estudianteRepository;

	public EstudianteServiceImpl(EstudianteRepository estudianteRepository) {
		super();
		this.estudianteRepository = estudianteRepository;
	}

	@Override
	@Transactional
	public List<Estudiante> getAllEstudiante() {
		return (List<Estudiante>) estudianteRepository.findAll();
	}

	@Override
	@Transactional
	public Estudiante CreateEstudiante(Estudiante estudiante) {
		return estudianteRepository.save(estudiante);
	}

	@Override
	@Transactional
	public Estudiante getEstudianteById(Integer id) {
		return estudianteRepository.findById(id).get();
	}

	@Override
	@Transactional
	public void deleteEstudiante(Integer id) {
		estudianteRepository.deleteById(id);
	}

	@Override
	@Transactional
	public void updateEstudiante(Estudiante estudiante, Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional
	public Estudiante findEstudiante(Estudiante estudiante) {
		return estudianteRepository.findById(estudiante.getId()).orElse(null);
	}

}
