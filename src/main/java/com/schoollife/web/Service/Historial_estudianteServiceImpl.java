package com.schoollife.web.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schoollife.web.Entities.Historial_estudiante;
import com.schoollife.web.Repository.Historial_estudianteRepository;

import jakarta.transaction.Transactional;

@Service
public class Historial_estudianteServiceImpl implements Historial_estudianteService{

	@Autowired
	private final Historial_estudianteRepository historialEstudianteR;

	public Historial_estudianteServiceImpl(Historial_estudianteRepository historialEstudianteR) {
		super();
		this.historialEstudianteR = historialEstudianteR;
	}

	@Override
	@Transactional
	public List<Historial_estudiante> getAll(String establecimiento) {
		return historialEstudianteR.findByEstablecimiento(establecimiento);
	}

	@Override
	@Transactional
	public List<Historial_estudiante> getByEstudiante(String estudianteId) {
		return historialEstudianteR.findByIdEstudiante(estudianteId);
	}

	@Override
	@Transactional
	public Historial_estudiante createHistorial_estudiante(Historial_estudiante historial_estudiante) {
		return historialEstudianteR.save(historial_estudiante);
	}
	
	
	
	
	
	
	
	
}
