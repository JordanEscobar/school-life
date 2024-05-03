package com.schoollife.classbook.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schoollife.classbook.Entities.Matricula;
import com.schoollife.classbook.Repository.MatriculaRepository;

import jakarta.transaction.Transactional;

@Service
public class MatriculaServiceImpl implements MatriculaService{
	
	@Autowired
	private final MatriculaRepository matriculaRepository;
	
	public MatriculaServiceImpl(MatriculaRepository matriculaRepository) {
		super();
		this.matriculaRepository = matriculaRepository;
	}

	//listar matriculas por colegio
	@Override
	@Transactional
	public List<Matricula> matriculasPorColegio(Integer colegioid) {
		List<Matricula> listaMatricula = matriculaRepository.findAll();
		listaMatricula = listaMatricula.stream().filter(m -> m.getColegio_id() == colegioid).collect(Collectors.toList());
		return listaMatricula;
	}

	@Override
	@Transactional
	public Matricula CreateMatricula(Matricula matricula) {
		return matriculaRepository.save(matricula);
	}
	
	

}
