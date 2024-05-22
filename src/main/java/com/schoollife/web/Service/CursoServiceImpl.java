package com.schoollife.web.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schoollife.web.Entities.Curso;
import com.schoollife.web.Repository.CursoRepository;

import jakarta.transaction.Transactional;

@Service
public class CursoServiceImpl implements CursoService{
	@Autowired
	private final CursoRepository cursoR;

	public CursoServiceImpl(CursoRepository cursoR) {
		super();
		this.cursoR = cursoR;
	}

	@Override
	@Transactional
	public List<Curso> getAll(Integer rbd) {
		List<Curso> cursos = cursoR.findAll();
		if(rbd != null ) {
			cursos = cursos.stream().filter(c -> c.getEstablecimiento_id().equals(rbd)).collect(Collectors.toList());	
		}else {
			return cursos;
		}
		return cursos;
	}

	@Override
	@Transactional
	public void updateCurso(Curso curso, Integer id) {
		Optional<Curso> cursoId = cursoR.findById(id);
		Curso cursoN = cursoId.get();
		cursoN.setId_curso(curso.getId_curso());
		cursoN.setApodo(curso.getApodo());
		cursoN.setCapacidad(curso.getCapacidad());
		cursoN.setEstablecimiento_id(curso.getEstablecimiento_id());
		cursoN.setJornada(curso.getJornada());
		cursoN.setLetra(curso.getLetra());
		cursoN.setLocal(curso.getLocal());
		cursoN.setNivel(curso.getNivel());
		cursoN.setNivel_ensenanza(curso.getNivel_ensenanza());
		cursoN.setNumero_sala(curso.getNumero_sala());
		cursoR.save(cursoN);
		
	}

	@Override
	@Transactional
	public Curso findCurso(Curso curso) {
		return cursoR.findById(curso.getId_curso()).orElse(null);
	}

	@Override
	@Transactional
	public Curso CreateCurso(Curso curso) {
		return cursoR.save(curso);
	}
	
	

}
