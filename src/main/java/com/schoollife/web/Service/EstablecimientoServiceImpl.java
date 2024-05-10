package com.schoollife.web.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schoollife.web.Entities.Establecimiento;
import com.schoollife.web.Repository.EstablecimientoRepository;

import jakarta.transaction.Transactional;

@Service
public class EstablecimientoServiceImpl implements EstablecimientoService{
	@Autowired
	private final EstablecimientoRepository establecimientoR;

	public EstablecimientoServiceImpl(EstablecimientoRepository establecimientoR) {
		super();
		this.establecimientoR = establecimientoR;
	}

	@Override
	@Transactional
	public List<Establecimiento> getAll() {
		return establecimientoR.findAll();
	}

	@Override
	@Transactional
	public void updateEstablecimiento(Establecimiento establecimiento, Integer rbd) {
		Optional<Establecimiento> establecimientoId = establecimientoR.findById(rbd);
		Establecimiento e = establecimientoId.get();
		e.setComuna(establecimiento.getComuna());
		e.setCorreo_electronico(establecimiento.getCorreo_electronico());
		e.setDireccion(establecimiento.getDireccion());
		e.setFecha_aniversario(establecimiento.getFecha_aniversario());
		e.setNombre(establecimiento.getNombre());
		e.setNumero_telefonico(establecimiento.getNumero_telefonico());
		e.setPagina_web(establecimiento.getPagina_web());
		e.setRbd(establecimiento.getRbd());
		e.setRegion(establecimiento.getRegion());
		e.setZona_horaria(establecimiento.getZona_horaria());
		establecimientoR.save(e);
		
	}

	@Override
	@Transactional
	public Establecimiento findEstablecimiento(Establecimiento establecimiento) {
		return establecimientoR.findById(establecimiento.getRbd()).orElse(null);
	}

	@Override
	@Transactional
	public Establecimiento createEstablecimiento(Establecimiento establecimiento) {
		return establecimientoR.save(establecimiento);
	}
	
	

}
