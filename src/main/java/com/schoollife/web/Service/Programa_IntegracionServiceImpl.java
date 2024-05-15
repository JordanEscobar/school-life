package com.schoollife.web.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schoollife.web.Entities.Programa_Integracion;
import com.schoollife.web.Repository.Programa_IntegracionRepository;

import jakarta.transaction.Transactional;

@Service
public class Programa_IntegracionServiceImpl implements Programa_IntegracionService{
	@Autowired
	private final Programa_IntegracionRepository programaR;

	public Programa_IntegracionServiceImpl(Programa_IntegracionRepository programaR) {
		super();
		this.programaR = programaR;
	}

	@Override
	@Transactional
	public List<Programa_Integracion> getAll() {
		return programaR.findAll();
	}

	@Override
	@Transactional
	public void updatePrograma(Programa_Integracion programa, Integer id) {
		Optional<Programa_Integracion> programaId = programaR.findById(id);
		Programa_Integracion p = programaId.get();
		p.setEstudiante_id(programa.getEstudiante_id());
		p.setId_Programa(programa.getId_Programa());
		p.setIndicaciones_generales(programa.getIndicaciones_generales());
		p.setPermanencia_pie(programa.isPermanencia_pie());
		p.setTipo_permanencia(programa.getTipo_permanencia());
		programaR.save(p);
		
	}

	@Override
	@Transactional
	public Programa_Integracion findPrograma(Programa_Integracion programa) {
		return programaR.findById(programa.getId_Programa()).orElse(null);
	}

	@Override
	@Transactional
	public Programa_Integracion CreatePrograma(Programa_Integracion programa) {
		return programaR.save(programa);
	}
	
	

}
