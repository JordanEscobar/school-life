package com.schoollife.classbook.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schoollife.classbook.Entities.Matricula;
import com.schoollife.classbook.Repository.MatriculaRepository;

@Service
public class MatriculaServiceImpl implements MatriculaService{
	@Autowired
	public final MatriculaRepository matriculaRepoaitory;

	public MatriculaServiceImpl(MatriculaRepository matriculaRepoaitory) {
		super();
		this.matriculaRepoaitory = matriculaRepoaitory;
	}

	@Override
	public List<Matricula> getAllMatricula() {
		return (List<Matricula>) matriculaRepoaitory.findAll();
	}
	
	
	
}
