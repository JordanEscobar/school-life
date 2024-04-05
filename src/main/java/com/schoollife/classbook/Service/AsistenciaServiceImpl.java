package com.schoollife.classbook.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schoollife.classbook.Entities.Asistencia;
import com.schoollife.classbook.Repository.AsistenciaRepository;

import jakarta.transaction.Transactional;

@Service
public class AsistenciaServiceImpl implements AsistenciaService{
	@Autowired
	public final AsistenciaRepository asistenciaRepository;

	public AsistenciaServiceImpl(AsistenciaRepository asistenciaRepository) {
		super();
		this.asistenciaRepository = asistenciaRepository;
	}

	@Override
	@Transactional
	public List<Asistencia> getAllAsistencias() {
		return (List<Asistencia>) asistenciaRepository.findAll();
	}

	@Override
	@Transactional
	public Asistencia CreateAsistencia(Asistencia asistencia) {
		return asistenciaRepository.save(asistencia);
	}

	@Override
	@Transactional
	public Asistencia getAsistenciaById(Integer id) {
		return asistenciaRepository.findById(id).get();
	}

	@Override
	@Transactional
	public void deleteAsistencia(Integer id) {
		asistenciaRepository.deleteById(id);
		
	}

	@Override
	@Transactional
	public void updateAsistencia(Asistencia asistencia, Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional
	public Asistencia findAsistencia(Asistencia asistencia) {
		return asistenciaRepository.findById(asistencia.getId()).orElse(null);
	}

}
