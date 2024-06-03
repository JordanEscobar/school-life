package com.schoollife.web.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.schoollife.web.Entities.Asignatura;
import com.schoollife.web.Repository.AsignaturaRepository;

import jakarta.transaction.Transactional;

@Service
public class AsignaturaServiceImpl implements AsignaturaService{
	
	private final AsignaturaRepository asignaturaR;

	public AsignaturaServiceImpl(AsignaturaRepository asignaturaR) {
		super();
		this.asignaturaR = asignaturaR;
	}

	@Override
	@Transactional
	public List<Asignatura> getAsignaturasPorCurso(Integer curso_id) {
		return  asignaturaR.findByCursoId(curso_id);
	}
	
	

}
