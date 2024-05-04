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
	//lista todas las asistencias
	@Override
	@Transactional
	public List<Asistencia> getAllAsistencias() {
		return (List<Asistencia>) asistenciaRepository.findAll();
	}
	//Crea una asistencia
	@Override
	@Transactional
	public Asistencia CreateAsistencia(Asistencia asistencia) {
		return asistenciaRepository.save(asistencia);
	}
	//Busca asistencia por ID
	@Override
	@Transactional
	public Asistencia getAsistenciaById(Integer id) {
		return asistenciaRepository.findById(id).get();
	}
	//Actualiza una asistencia
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
	//Busca las asistencias por asistencia
	@Override
	@Transactional
	public Asistencia findAsistencia(Asistencia asistencia) {
		return asistenciaRepository.findById(asistencia.getId()).orElse(null);
	}

	//Es una Query que se encuentra en Repository
	@Override
	@Transactional
	public List<Object[]> obtenerDatos(Integer profesorId, Integer asignaturaId, Integer cursoId) {
		var listaDatos = asistenciaRepository.obtenerDatosAlumnos(profesorId, asignaturaId, cursoId);
		return listaDatos;
	}
	//buscar las asistencias por estudiante
	@Override
	@Transactional
	public List<Asistencia> asistenciaPorEstudiante(Integer estudianteId) {
		List<Asistencia> listaAsistencia = asistenciaRepository.findAll();
		listaAsistencia = listaAsistencia.stream().filter(a -> a.getEstudiante_id() == estudianteId).collect(Collectors.toList());
		if(listaAsistencia.size()<=0) {
			System.out.println("No tiene datos: "+listaAsistencia);
		}
		return listaAsistencia;
	}
	//Es una Query que se encuentra en Repository
	@Override
	@Transactional
	public List<Object[]> asistenciaCurso(Integer profesorId, Integer asignaturaid, Integer cursoid, Integer mes) {
		List<Object[]> asistenciaCurso = asistenciaRepository.asistenciaCurso(profesorId, asignaturaid, cursoid, mes);
		return asistenciaCurso;
	}
	//buscar asistencias por asignatura
	@Override
	@Transactional
	public List<Asistencia> asistenciaPorAsignatura(Integer asignaturaid) {
		List<Asistencia> asistencias = asistenciaRepository.findAll();
		asistencias = asistencias.stream().filter(a -> a.getAsignatura_id() == asignaturaid).collect(Collectors.toList());
		return asistencias;
	}

	
	

}
