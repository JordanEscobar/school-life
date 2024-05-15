package com.schoollife.web.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schoollife.web.Entities.Apoderado;
import com.schoollife.web.Repository.ApoderadoRepository;

import jakarta.transaction.Transactional;

@Service
public class ApoderadoServiceImpl implements ApoderadoService{
	@Autowired
	private final ApoderadoRepository apoderadoR;

	public ApoderadoServiceImpl(ApoderadoRepository apoderadoR) {
		super();
		this.apoderadoR = apoderadoR;
	}

	@Override
	@Transactional
	public List<Apoderado> getAll() {
		return apoderadoR.findAll();
	}

	@Override
	@Transactional
	public void updateApoderado(Apoderado apoderado) {
		Optional<Apoderado> apoderadoId = apoderadoR.findById(apoderado.getRun_apoderado());
		Apoderado aA = apoderadoId.get();
		aA.setAmaterno_apoderado(apoderado.getAmaterno_apoderado());
		aA.setAcepta_manual_convivencia_escolar(apoderado.isAcepta_manual_convivencia_escolar());
		aA.setApaterno_apoderado(apoderado.getApaterno_apoderado());
		aA.setAutorizacion_fotografia_grabacion(apoderado.isAutorizacion_fotografia_grabacion());
		aA.setAutorizado_retirar_establecimiento(apoderado.isAutorizado_retirar_establecimiento());
		aA.setCelular(apoderado.getCelular());
		aA.setComuna(apoderado.getComuna());
		aA.setCorreo_electronico(apoderado.getCorreo_electronico());
		aA.setDomicilio(apoderado.getDomicilio());
		aA.setEstudiante_id(apoderado.getEstudiante_id());
		aA.setNombres(apoderado.getNombres());
		aA.setParentesco(apoderado.getParentesco());
		aA.setPasaporte(apoderado.getPasaporte());
		aA.setRun_apoderado(apoderado.getRun_apoderado());
		aA.setTelefono(apoderado.getTelefono());
		aA.setFecha_nacimiento(apoderado.getFecha_nacimiento());
		aA.setNivel_educacion(apoderado.getNivel_educacion());
		aA.setNumero_documento(apoderado.getNumero_documento());
		aA.setOcupacion(apoderado.getOcupacion());
		aA.setTipo_apoderado(apoderado.getTipo_apoderado());
		aA.setEs_tutor(apoderado.isEs_tutor());
	}

	@Override
	@Transactional
	public Apoderado findApoderado(Apoderado apoderado) {
		return apoderadoR.findById(apoderado.getRun_apoderado()).get();
	}

	@Override
	@Transactional
	public Apoderado createApoderado(Apoderado apoderado) {
		return apoderadoR.save(apoderado);
	}
}
