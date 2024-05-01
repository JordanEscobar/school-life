package com.schoollife.classbook.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schoollife.classbook.Entities.Apoderado;
import com.schoollife.classbook.Entities.Estudiante;
import com.schoollife.classbook.Repository.ApoderadoRepository;
import com.schoollife.classbook.Repository.EstudianteRepository;

import jakarta.transaction.Transactional;

@Service
public class ApoderadoServiceImpl implements ApoderadoService{
	
	@Autowired
	private final ApoderadoRepository apoderadoRepository;
	@Autowired
	private final EstudianteRepository estudianteRepository;
	
	public ApoderadoServiceImpl(ApoderadoRepository apoderadoRepository, EstudianteRepository estudianteRepository) {
		super();
		this.apoderadoRepository = apoderadoRepository;
		this.estudianteRepository = estudianteRepository;
	}
	//Buscar Apoderado por Estudiante
	@Override
	@Transactional
	public List<Apoderado> apoderadoPorEstudiante(Integer estudianteid) {
		List<Apoderado> listaApoderado = (List<Apoderado>) apoderadoRepository.findAll();
		listaApoderado = listaApoderado.stream().filter(p -> p.getEstudiante_id() == estudianteid).collect(Collectors.toList());
		return listaApoderado;
	}
	//Crear
	@Override
	@Transactional
	public Apoderado createApoderado(Apoderado apoderado) {
		return apoderadoRepository.save(apoderado);
	}
	
	

}
