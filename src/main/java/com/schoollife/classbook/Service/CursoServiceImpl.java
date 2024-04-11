package com.schoollife.classbook.Service;

import java.util.List;
import java.util.Optional;

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
	public Curso findCurso(Curso curso) {
		return cursoRepository.findById(curso.getId()).orElse(null);
	}

	@Override
	@Transactional
	public void updateCurso(Curso curso, Integer id) {
		Optional<Curso> cursoId = cursoRepository.findById(id);
		Curso cursoN = cursoId.get();
		cursoN.setId(curso.getId());
		cursoN.setNombre(curso.getNombre());
		cursoN.setSeccion(curso.getSeccion());
		cursoN.setCantidad(curso.getCantidad());
		cursoN.setEstado(curso.getEstado());
		cursoN.setProfesor_jefe(curso.getProfesor_jefe());
		cursoRepository.save(cursoN);
	}

	@Override
	@Transactional
	public void desactivarCurso(Curso curso, Integer id) {
		if (curso != null) {
			Optional<Curso> cursoId = cursoRepository.findById(id);
			Curso cursoN = cursoId.get();
			cursoN.setId(curso.getId());
			cursoN.setEstado("desactivado");
			cursoRepository.save(cursoN);
		}
	}
	
	@Override
	@Transactional
	public void activarCurso(Curso curso, Integer id) {
		if (curso != null) {
			Optional<Curso> cursoId = cursoRepository.findById(id);
			Curso cursoN = cursoId.get();
			cursoN.setId(curso.getId());
			cursoN.setEstado("activo");
			cursoRepository.save(cursoN);
		}
	}

}
