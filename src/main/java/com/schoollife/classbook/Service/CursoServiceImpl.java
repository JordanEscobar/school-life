package com.schoollife.classbook.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schoollife.classbook.Entities.Curso;
import com.schoollife.classbook.Repository.CursoRepository;

import jakarta.transaction.Transactional;

@Service
public class CursoServiceImpl implements CursoService{
	@Autowired
	public final CursoRepository cursoRepository;

	public CursoServiceImpl(CursoRepository cursoRepository) {
		super();
		this.cursoRepository = cursoRepository;
	}

	@Override
	@Transactional
	public List<Curso> getAllCurso() {
		return (List<Curso>) cursoRepository.findAll();
	}

	@Override
	@Transactional
	public Curso CreateCurso(Curso curso) {
		return cursoRepository.save(curso);
	}

	@Override
	@Transactional
	public Curso getCursoById(Integer id) {
		return cursoRepository.findById(id).get();
	}

	@Override
	@Transactional
	public void deleteCurso(Integer id) {
		cursoRepository.deleteById(id);
		
	}

	@Override
	@Transactional
	public void updateCurso(Curso curso, Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional
	public Curso findCurso(Curso curso) {
		return cursoRepository.findById(curso.getId()).orElse(null);
	}

}
