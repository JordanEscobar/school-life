package com.schoollife.classbook.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schoollife.classbook.Entities.Colegio;
import com.schoollife.classbook.Repository.ColegioRepository;

import jakarta.transaction.Transactional;

@Service
public class ColegioServiceImpl implements ColegioService{
	
	@Autowired
	private final ColegioRepository colegioRepository;
	
	public ColegioServiceImpl(ColegioRepository colegioRepository) {
		super();
		this.colegioRepository = colegioRepository;
	}

	@Override
	@Transactional
	public List<Colegio> getAll() {
		return colegioRepository.findAll();
	}

}
