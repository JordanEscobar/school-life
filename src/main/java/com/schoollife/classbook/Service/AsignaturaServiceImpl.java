package com.schoollife.classbook.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schoollife.classbook.Entities.Asignatura;
import com.schoollife.classbook.Repository.AsignaturaRepository;

import jakarta.transaction.Transactional;

@Service
public class AsignaturaServiceImpl implements AsignaturaService{
	@Autowired
	public final AsignaturaRepository asignaturaRepository;
	
	public AsignaturaServiceImpl(AsignaturaRepository asignaturaRepository) {
		super();
		this.asignaturaRepository = asignaturaRepository;
	}
	//listar
	@Override
	@Transactional
	public List<Asignatura> getAllAsignaturas() {
		return asignaturaRepository.findAll();
	}
	//crear
	@Override
	@Transactional
	public Asignatura CreateAsignatura(Asignatura asignatura) {
		return asignaturaRepository.save(asignatura);
	}
	//buscar por ID
	@Override
	@Transactional
	public Asignatura getAsignaturaById(Integer id) {
		return asignaturaRepository.findById(id).get();
	}

	//actualizar
	@Override
	@Transactional
	public void updateAsignatura(Asignatura asignatura, Integer id) {
		// TODO Auto-generated method stub
		
	}
	//buscar por asignatura
	@Override
	@Transactional
	public Asignatura findAsignatura(Asignatura asignatura) {
		return asignaturaRepository.findById(asignatura.getId()).orElse(null);
	}
	//Buscar asignaturas por profesor
	@Override
	@Transactional
	public List<Asignatura> asignaturaPorProfesor(Integer profesorid) {
		List<Asignatura> listaAsignatura = asignaturaRepository.findAll();
		listaAsignatura = listaAsignatura.stream().filter(p -> p.getProfesor_id() == profesorid).collect(Collectors.toList());
		return listaAsignatura;
	}
	//Buscar por estado 
	@Override
	@Transactional
	public List<Asignatura> asignaturaPorEstado(String estado) {
		List<Asignatura> listaAsignatura = asignaturaRepository.findAll();
		listaAsignatura = listaAsignatura.stream().filter(p -> p.getEstado().equalsIgnoreCase(estado)).collect(Collectors.toList());
		return listaAsignatura;
	}
	//Buscar por dia
	@Override
	@Transactional
	public List<Asignatura> asignaturaPorDia(String dia) {
		List<Asignatura> listaAsignatura = asignaturaRepository.findAll();
		listaAsignatura = listaAsignatura.stream().filter(p -> p.getDia().equalsIgnoreCase(dia)).collect(Collectors.toList());
		return listaAsignatura;
	}

}
