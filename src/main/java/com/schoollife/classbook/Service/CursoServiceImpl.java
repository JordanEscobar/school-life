package com.schoollife.classbook.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schoollife.classbook.Entities.Curso;
import com.schoollife.classbook.Repository.CursoRepository;

@Service
public class CursoServiceImpl implements CursoService{
	@Autowired
	public final CursoRepository cursoRepository;

	public CursoServiceImpl(CursoRepository cursoRepository) {
		super();
		this.cursoRepository = cursoRepository;
	}

	@Override
	public List<Curso> getAllCurso() {
		return (List<Curso>) cursoRepository.findAll();
	}

}
