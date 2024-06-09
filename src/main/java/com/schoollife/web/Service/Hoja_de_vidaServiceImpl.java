package com.schoollife.web.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schoollife.web.Entities.Hoja_de_vida;
import com.schoollife.web.Repository.Hoja_de_vidaRepository;

import jakarta.transaction.Transactional;

@Service
public class Hoja_de_vidaServiceImpl implements Hoja_de_vidaService{
	@Autowired
	private final Hoja_de_vidaRepository hoja_de_vidaR;
	
	public Hoja_de_vidaServiceImpl(Hoja_de_vidaRepository hoja_de_vidaR) {
		super();
		this.hoja_de_vidaR = hoja_de_vidaR;
	}

	@Override
	@Transactional
	public List<Hoja_de_vida> getByEstudianteId(String runEstudiante) {
		return hoja_de_vidaR.findByEstudianteId(runEstudiante);
	}

	@Override
	@Transactional
	public Hoja_de_vida createHojaDeVida(Hoja_de_vida hoja) {
		return hoja_de_vidaR.save(hoja);
	}

	@Override
	public void deleteHojaDeVida(Integer id) {
		hoja_de_vidaR.deleteById(id);
	}

	@Override
	@Transactional
	public void updateCurso(Hoja_de_vida hoja, Integer id) {
		Optional<Hoja_de_vida>  hoja_de_vidaId = hoja_de_vidaR.findById(id);
		Hoja_de_vida hN = hoja_de_vidaId.get();
		hN.setArchivo(hoja.getArchivo());
		hN.setAsignatura(hoja.getAsignatura());
		hN.setDetalle(hoja.getDetalle());
		hN.setEstudianteId(hoja.getEstudianteId());
		hN.setFecha(hoja.getFecha());
		hN.setId_hoja_de_vida(hoja.getId_hoja_de_vida());
		hN.setTipoEvento(hoja.getTipoEvento());
		hN.setUsuarioId(hoja.getUsuarioId());
		hoja_de_vidaR.save(hN);
	}

	@Override
	@Transactional
	public Hoja_de_vida findById(Integer id) {	
		return hoja_de_vidaR.findById(id).get();
	}

}
