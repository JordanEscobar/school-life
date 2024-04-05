package com.schoollife.classbook.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schoollife.classbook.Entities.Apoderado;
import com.schoollife.classbook.Repository.ApoderadoRepository;

import jakarta.transaction.Transactional;

@Service
public class ApoderadoServiceImpl implements ApoderadoService{
	
	@Autowired
	private final ApoderadoRepository apoderadoRepository;
	
	public ApoderadoServiceImpl(ApoderadoRepository apoderadoRepository) {
		super();
		this.apoderadoRepository = apoderadoRepository;
	}

	@Override
	@Transactional
	public List<Apoderado> getAllApoderados() {
		return (List<Apoderado>) apoderadoRepository.findAll();
	}

	@Override
	@Transactional
	public Apoderado CreateApoderado(Apoderado apoderado) {
		return apoderadoRepository.save(apoderado);
	}

	@Override
	@Transactional
	public Apoderado getApoderadoById(Integer id) {
		return apoderadoRepository.findById(id).get();
	}

	@Override
	@Transactional
	public void deleteApoderado(Integer id) {
		apoderadoRepository.deleteById(id);
		
	}

	@Override
	@Transactional
	public void updateApoderado(Apoderado apoderado, Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional
	public Apoderado findApoderado(Apoderado apoderado) {
		return apoderadoRepository.findById(apoderado.getId()).orElse(null);
	}
	


}
