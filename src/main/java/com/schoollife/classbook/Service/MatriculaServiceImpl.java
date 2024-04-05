package com.schoollife.classbook.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schoollife.classbook.Entities.Matricula;
import com.schoollife.classbook.Repository.MatriculaRepository;

import jakarta.transaction.Transactional;

@Service
public class MatriculaServiceImpl implements MatriculaService{
	@Autowired
	public final MatriculaRepository matriculaRepository;

	public MatriculaServiceImpl(MatriculaRepository matriculaRepository) {
		super();
		this.matriculaRepository = matriculaRepository;
	}

	@Override
	@Transactional
	public List<Matricula> getAllMatricula() {
		return (List<Matricula>) matriculaRepository.findAll();
	}

	@Override
	@Transactional
	public Matricula CreateMatricula(Matricula matricula) {
		matriculaRepository.save(matricula);
		return null;
	}

	@Override
	@Transactional
	public Matricula getMatriculaById(Integer id) {
		matriculaRepository.findById(id);
		return null;
	}

	@Override
	@Transactional
	public void deleteMatricula(Integer id) {
		matriculaRepository.deleteById(id);
		
	}

	@Override
	@Transactional
	public void updateMatricula(Matricula matricula, Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional
	public Matricula findMatricula(Matricula matricula) {
		return matriculaRepository.findById(matricula.getId()).orElse(null);
	}
	
	
	
}
