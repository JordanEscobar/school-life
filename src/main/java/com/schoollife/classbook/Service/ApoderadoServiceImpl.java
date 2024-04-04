package com.schoollife.classbook.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schoollife.classbook.Entities.Apoderado;
import com.schoollife.classbook.Repository.ApoderadoRepository;

@Service
public class ApoderadoServiceImpl implements ApoderadoService{
	
	@Autowired
	private final ApoderadoRepository apoderadoRepository;
	
	public ApoderadoServiceImpl(ApoderadoRepository apoderadoRepository) {
		super();
		this.apoderadoRepository = apoderadoRepository;
	}

	@Override
	public List<Apoderado> getAllApoderados() {
		return (List<Apoderado>) apoderadoRepository.findAll();
	}
	


}
