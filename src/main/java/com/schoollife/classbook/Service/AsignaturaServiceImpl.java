package com.schoollife.classbook.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schoollife.classbook.Entities.Asignatura;
import com.schoollife.classbook.Repository.AsignaturaRepository;

@Service
public class AsignaturaServiceImpl implements AsignaturaService{
	@Autowired
	public final AsignaturaRepository asignaturaRepository;
	
	public AsignaturaServiceImpl(AsignaturaRepository asignaturaRepository) {
		super();
		this.asignaturaRepository = asignaturaRepository;
	}

	@Override
	public List<Asignatura> getAllAsignaturas() {
		return (List<Asignatura>) asignaturaRepository.findAll();
	}

}
