package com.schoollife.classbook.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schoollife.classbook.Entities.Asistencia;
import com.schoollife.classbook.Repository.AsistenciaRepository;

@Service
public class AsistenciaServiceImpl implements AsistenciaService{
	@Autowired
	public final AsistenciaRepository asistenciaRepository;

	public AsistenciaServiceImpl(AsistenciaRepository asistenciaRepository) {
		super();
		this.asistenciaRepository = asistenciaRepository;
	}

	@Override
	public List<Asistencia> getAllAsistencias() {
		return (List<Asistencia>) asistenciaRepository.findAll();
	}

}
