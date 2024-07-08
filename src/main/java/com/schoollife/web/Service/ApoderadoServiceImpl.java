package com.schoollife.web.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
		aA.setCelular_apoderado(apoderado.getCelular_apoderado());
		aA.setComuna_apoderado(apoderado.getComuna_apoderado());
		aA.setCorreo_electronico_apoderado(apoderado.getCorreo_electronico_apoderado());
		aA.setDomicilio_apoderado(apoderado.getDomicilio_apoderado());
		aA.setEstudianteId(apoderado.getEstudianteId());
		aA.setNombres(apoderado.getNombres());
		aA.setParentesco(apoderado.getParentesco());
		aA.setPasaporte(apoderado.getPasaporte());
		aA.setRun_apoderado(apoderado.getRun_apoderado());
		aA.setTelefono_apoderado(apoderado.getTelefono_apoderado());
		aA.setFecha_nacimiento_apoderado(apoderado.getFecha_nacimiento_apoderado());
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

	@Override
	@Transactional
	public List<Apoderado> findApoderadoPorEstudiante(String run_estudiante) {
		List<Apoderado> apoderados = apoderadoR.findAll();		
		apoderados = apoderados.stream().filter(a -> a.getEstudianteId().equalsIgnoreCase(run_estudiante)).collect(Collectors.toList());
		return apoderados;
	}

	@Override
	@Transactional
	public void deleteApoderado(String apoderadoid) {
		apoderadoR.deleteById(apoderadoid);
	}

	@Override
	@Transactional
	public Apoderado findApoderadoPorEstudianteId(String estudianteId) {		
		return apoderadoR.findApoderadoByEstudianteId(estudianteId);
	}
}
