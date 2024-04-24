package com.schoollife.classbook.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schoollife.classbook.Entities.Asistencia;
import com.schoollife.classbook.Repository.AsistenciaRepository;

import jakarta.transaction.Transactional;

@Service
public class AsistenciaServiceImpl implements AsistenciaService{
	@Autowired
	public final AsistenciaRepository asistenciaRepository;

	public AsistenciaServiceImpl(AsistenciaRepository asistenciaRepository) {
		super();
		this.asistenciaRepository = asistenciaRepository;
	}

	@Override
	@Transactional
	public List<Asistencia> getAllAsistencias() {
		return (List<Asistencia>) asistenciaRepository.findAll();
	}

	@Override
	@Transactional
	public Asistencia CreateAsistencia(Asistencia asistencia) {
		return asistenciaRepository.save(asistencia);
	}

	@Override
	@Transactional
	public Asistencia getAsistenciaById(Integer id) {
		return asistenciaRepository.findById(id).get();
	}

	@Override
	@Transactional
	public void updateAsistencia(Asistencia asistencia, Integer id) {
		Optional<Asistencia> asistenciaId = asistenciaRepository.findById(id);
		Asistencia asistenciaN = asistenciaId.get();
		asistenciaN.setId(asistencia.getId());
		asistenciaN.setEstado(asistencia.getEstado());
		asistenciaN.setDescripcion(asistencia.getDescripcion());
		asistenciaRepository.save(asistenciaN);
	}

	@Override
	@Transactional
	public Asistencia findAsistencia(Asistencia asistencia) {
		return asistenciaRepository.findById(asistencia.getId()).orElse(null);
	}

	@Override
	@Transactional
	public List<Asistencia> listaAsistencias() {
		return asistenciaRepository.listarAsistencia();
	}

	@Override
	@Transactional
	public List<Object[]> obtenerDatos(Integer profesorId, Integer asignaturaId, Integer cursoId) {
		var listaDatos = asistenciaRepository.obtenerDatosAlumnos(profesorId, asignaturaId, cursoId);
		return listaDatos;
	}

	@Override
	@Transactional
	public List<Asistencia> obtenerAsistenciaEstudiante(Integer estudianteId) {
		List<Asistencia> listaAsistencia = asistenciaRepository.findAll();
		listaAsistencia = listaAsistencia.stream().filter(a -> a.getId_estudiante() == estudianteId).collect(Collectors.toList());
		return listaAsistencia;
	}
	
	

}
