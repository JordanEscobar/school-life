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

	@Override
	@Transactional
	public List<Estudiante> getAllEstudiante() {
		return estudianteRepository.findAll();
	}

	@Override
	@Transactional
	public Estudiante CreateEstudiante(Estudiante estudiante) {
		return estudianteRepository.save(estudiante);
	}

	@Override
	@Transactional
	public Estudiante getEstudianteById(Integer id) {
		return estudianteRepository.findById(id).get();
	}

	@Override
	@Transactional
	public Estudiante findEstudiante(Estudiante estudiante) {
		return estudianteRepository.findById(estudiante.getId()).orElse(null);
	}

	@Override
	@Transactional
	public void updateEstudiante(Estudiante estudiante, Integer id) {
		Optional<Estudiante> estudianteId = estudianteRepository.findById(id);
		Estudiante estudianteN = estudianteId.get();
		estudianteN.setId(estudiante.getId());
		estudianteN.setAmaterno(estudiante.getAmaterno());
		estudianteN.setApaterno(estudiante.getApaterno());
		estudianteN.setCorreo(estudiante.getCorreo());
		estudianteN.setId_curso(estudiante.getId_curso());
		estudianteN.setId_colegio(estudiante.getId_colegio());
		estudianteN.setId_login(estudiante.getId_login());
		estudianteN.setEdad(estudiante.getEdad());
		estudianteN.setDireccion(estudiante.getDireccion());
		estudianteN.setEstado(estudiante.getEstado());
		estudianteN.setFecha_nacimiento(estudiante.getFecha_nacimiento());
		estudianteN.setNombre(estudiante.getNombre());
		estudianteN.setRut(estudiante.getRut());
		estudianteN.setTelefono(estudiante.getTelefono());
		estudianteRepository.save(estudianteN);
		
	}

	@Override
	@Transactional
	public List<Estudiante> getEstudianteByIdCurso(Integer id) {
		List<Estudiante> listaEstudiante = (List<Estudiante>) estudianteRepository.findAll();
		listaEstudiante = listaEstudiante.stream().filter(p -> p.getId_curso() == id).collect(Collectors.toList());
		return listaEstudiante;
	}

}
