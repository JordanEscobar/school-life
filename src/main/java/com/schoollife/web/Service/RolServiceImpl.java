package com.schoollife.web.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schoollife.web.Entities.Rol;
import com.schoollife.web.Repository.RolRepository;

import jakarta.transaction.Transactional;

@Service
public class RolServiceImpl implements RolService{

	@Autowired
	private final RolRepository rolR;
	
	public RolServiceImpl(RolRepository rolR) {
		super();
		this.rolR = rolR;
	}

	@Override
	@Transactional
	public List<Rol> getAll() {
		return rolR.findAll();
	}

}
