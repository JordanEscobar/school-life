package com.schoollife.classbook.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schoollife.classbook.Entities.Asignatura;
import com.schoollife.classbook.Repository.AsignaturaRepository;

import jakarta.transaction.Transactional;

@Service
public class AsignaturaServiceImpl implements AsignaturaService{
	@Autowired
	public final AsignaturaRepository asignaturaRepository;
	
	public AsignaturaServiceImpl(AsignaturaRepository asignaturaRepository) {
		super();
		this.asignaturaRepository = asignaturaRepository;
	}

	@Override
	@Transactional
	public List<Asignatura> getAllAsignaturas() {
		return (List<Asignatura>) asignaturaRepository.findAll();
	}

	@Override
	@Transactional
	public Asignatura CreateAsignatura(Asignatura asignatura) {
		return asignaturaRepository.save(asignatura);
	}

	@Override
	@Transactional
	public Asignatura getAsignaturaById(Integer id) {
		return asignaturaRepository.findById(id).get();
	}

	@Override
	@Transactional
	public void deleteAsignatura(Integer id) {
		asignaturaRepository.deleteById(id);
	}

	@Override
	@Transactional
	public void updateAsignatura(Asignatura asignatura, Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional
	public Asignatura findAsignatura(Asignatura asignatura) {
		return asignaturaRepository.findById(asignatura.getId()).orElse(null);
	}

}
