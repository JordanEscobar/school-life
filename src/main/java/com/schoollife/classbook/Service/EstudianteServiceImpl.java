package com.schoollife.classbook.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.schoollife.classbook.Entities.Estudiante;
import com.schoollife.classbook.Repository.EstudianteRepository;

import jakarta.transaction.Transactional;

@Service
public class EstudianteServiceImpl implements EstudianteService{
	
	@Autowired
	public final EstudianteRepository estudianteRepository;

	public EstudianteServiceImpl(EstudianteRepository estudianteRepository) {
		super();
		this.estudianteRepository = estudianteRepository;
	}
	//listar
	@Override
	@Transactional
	public List<Estudiante> getAllEstudiante() {
		return estudianteRepository.findAll();
	}
	//Crear
	@Override
	@Transactional
	public Estudiante CreateEstudiante(Estudiante estudiante) {
		return estudianteRepository.save(estudiante);
	}
	//Buscar por ID
	@Override
	@Transactional
	public Estudiante getEstudianteById(Integer id) {
		return estudianteRepository.findById(id).get();
	}
	//Buscar estudiante por estudiante
	@Override
	@Transactional
	public Estudiante findEstudiante(Estudiante estudiante) {
		return estudianteRepository.findById(estudiante.getId()).orElse(null);
	}
	//Actualizar
	@Override
	@Transactional
	public void updateEstudiante(Estudiante estudiante, Integer id) {	
		Optional<Estudiante> estudianteId = estudianteRepository.findById(id);
		Estudiante estudianteN = estudianteId.get();
		estudianteN.setId(estudiante.getId());
		estudianteN.setAmaterno(estudiante.getAmaterno());
		estudianteN.setApaterno(estudiante.getApaterno());
		estudianteN.setCorreo(estudiante.getCorreo());
		estudianteN.setCurso_id(estudiante.getCurso_id());
		estudianteN.setColegio_id(estudiante.getColegio_id());
		estudianteN.setContrasena(estudiante.getContrasena());
		estudianteN.setPie(estudiante.getPie());
		estudianteN.setSep(estudiante.getSep());
		estudianteN.setDireccion(estudiante.getDireccion());
		estudianteN.setEstado(estudiante.getEstado());
		estudianteN.setFecha_nacimiento(estudiante.getFecha_nacimiento());
		estudianteN.setNombre(estudiante.getNombre());
		estudianteN.setRut(estudiante.getRut());
		estudianteN.setTelefono(estudiante.getTelefono());
		estudianteRepository.save(estudianteN);		
	}
	//buscar estudiantes por Colegio y curso
	@Override
	@Transactional
	public List<Estudiante> estudiantePorColegioYCurso(Integer cursoid, Integer colegioid){
			List<Estudiante> listaEstudiante = estudianteRepository.findAll();
			listaEstudiante = listaEstudiante.stream().filter(p -> p.getCurso_id() == cursoid && p.getColegio_id() == colegioid).collect(Collectors.toList());
			System.out.println(listaEstudiante);
			return listaEstudiante;	
	}
	//Buscar estudiantes SEP
	@Override
	@Transactional
	public List<Estudiante> estudiantesSep(String sep) {
		List<Estudiante> listaEstudiante = estudianteRepository.findAll();
		if(sep == "si") {
			listaEstudiante = listaEstudiante.stream().filter(p -> p.getSep().equalsIgnoreCase(sep)).collect(Collectors.toList());
			return listaEstudiante;	
		}
		return estudianteRepository.findAll();
		
	}
	//Buscar estudiantes PIE
	@Override
	@Transactional
	public List<Estudiante> estudiantesPie(String pie) {
		if(pie == null) {	
			return estudianteRepository.findAll();
		}	
		if(pie != null) {
			if(pie.length() > 0) {
				if(pie.equalsIgnoreCase("si") || pie.equalsIgnoreCase("no")) {
					List<Estudiante> listaEstudiante = estudianteRepository.findAll();
					listaEstudiante = listaEstudiante.stream().filter(p -> p.getPie().equalsIgnoreCase(pie)).collect(Collectors.toList());
					return listaEstudiante;	
				}
			}
		}
		
		return estudianteRepository.findAll();
	}
	//filtrar a los alumnos matriculados PIE a través de un botón
	@Override
	@Transactional
	public List<Estudiante> estudiantePie() {
		List<Estudiante> listaEstudiante = estudianteRepository.findAll();
		listaEstudiante = listaEstudiante.stream().filter(p -> p.getPie().equalsIgnoreCase("si")).collect(Collectors.toList());
		return listaEstudiante;	
	}
	@Override
	@Transactional
	public List<Estudiante> estudianteSep() {
		List<Estudiante> listaEstudiante = estudianteRepository.findAll();
		listaEstudiante = listaEstudiante.stream().filter(p -> p.getSep().equalsIgnoreCase("si")).collect(Collectors.toList());
		return listaEstudiante;	
	}
	//Login estudiante
	@Override
	@Transactional
	public Estudiante estudianteLogin(String mail) {
		List<Estudiante> estudiantes = estudianteRepository.findAll();
		Estudiante e = new Estudiante();
		for (int i = 0; i < estudiantes.size(); i++) {
			if (e.getCorreo().equalsIgnoreCase(estudiantes.get(i).getCorreo())) {
				e.setAmaterno(estudiantes.get(i).getAmaterno());
				e.setApaterno(estudiantes.get(i).getApaterno());
				e.setColegio_id(estudiantes.get(i).getColegio_id());
				e.setContrasena(estudiantes.get(i).getContrasena());
				e.setCorreo(estudiantes.get(i).getCorreo());
				e.setCurso_id(estudiantes.get(i).getCurso_id());
				e.setDireccion(estudiantes.get(i).getDireccion());
				e.setEstado(estudiantes.get(i).getEstado());
				e.setFecha_nacimiento(estudiantes.get(i).getFecha_nacimiento());
				e.setId(estudiantes.get(i).getId());
				e.setNombre(estudiantes.get(i).getNombre());
				e.setPie(estudiantes.get(i).getPie());
				e.setRut(estudiantes.get(i).getRut());
				e.setSep(estudiantes.get(i).getSep());
				e.setTelefono(estudiantes.get(i).getTelefono());
			}
		}
		return e;
	}


}
