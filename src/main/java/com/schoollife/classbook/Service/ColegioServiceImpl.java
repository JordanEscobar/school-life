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
	public List<Colegio> getAllColegios() {
		return (List<Colegio>) colegioRepository.findAll();
	}

	@Override
	@Transactional
	public Colegio CreateColegio(Colegio colegio) {
		return colegioRepository.save(colegio);
	}

	@Override
	@Transactional
	public Colegio getColegioById(Integer id) {
		return colegioRepository.findById(id).get();
	}

	@Override
	@Transactional
	public void deleteColegio(Integer id) {
		colegioRepository.deleteById(id);
		
	}

	@Override
	@Transactional
	public void updateColegio(Colegio colegio, Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional
	public Colegio findColegio(Colegio colegio) {
		return colegioRepository.findById(colegio.getId()).orElse(null);
	}
	
}
