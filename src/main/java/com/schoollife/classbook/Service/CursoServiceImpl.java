package com.schoollife.classbook.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schoollife.classbook.Entities.Curso;
import com.schoollife.classbook.Entities.Profesor;
import com.schoollife.classbook.Repository.CursoRepository;
import com.schoollife.classbook.Repository.ProfesorRepository;

import jakarta.transaction.Transactional;

@Service
public class CursoServiceImpl implements CursoService{
	@Autowired
	public final CursoRepository cursoRepository;
	@Autowired
	public final ProfesorRepository profesorRepository;

	public CursoServiceImpl(CursoRepository cursoRepository, ProfesorRepository profesorRepository) {
		super();
		this.cursoRepository = cursoRepository;
		this.profesorRepository = profesorRepository;
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
		cursoN.setId_profesor_jefe(curso.getId_profesor_jefe());
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

	@Override
	@Transactional
	public Curso getCursoByIdProfesorJefe(Integer id) {
		List<Curso> listaCurso = (List<Curso>) cursoRepository.findAll();
		listaCurso = listaCurso.stream().filter(p -> p.getId_profesor_jefe() == id).collect(Collectors.toList());
		Curso c = new Curso();
		for (Curso curso : listaCurso) {
			if(curso.getId_profesor_jefe() == id) {
				c.setId(curso.getId());
				c.setCantidad(curso.getCantidad());
				c.setEstado(curso.getEstado());
				c.setNombre(curso.getNombre());
				c.setId_profesor_jefe(curso.getId_profesor_jefe());
				c.setSeccion(curso.getSeccion());
			}
		}
		return null;
	}

}
