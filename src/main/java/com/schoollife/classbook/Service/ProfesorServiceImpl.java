package com.schoollife.classbook.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schoollife.classbook.Entities.Profesor;
import com.schoollife.classbook.Repository.ProfesorRepository;

import jakarta.transaction.Transactional;

@Service
public class ProfesorServiceImpl implements ProfesorService{
	
	@Autowired
	public final ProfesorRepository profesorRepository;

	public ProfesorServiceImpl(ProfesorRepository profesorRepository) {
		super();
		this.profesorRepository = profesorRepository;
	}

	@Override
	@Transactional
	public List<Profesor> getAllProfesor() {
		return profesorRepository.findAll();
	}

	@Override
	@Transactional
	public Profesor CreateProfesor(Profesor profesor) {
		return profesorRepository.save(profesor);
	}

	@Override
	@Transactional
	public Profesor getProfesorById(Integer id) {
		return profesorRepository.findById(id).get();
	}


	@Override
	@Transactional
	public void updateProfesor(Profesor profesor, Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional
	public Profesor findProfesor(Profesor profesor) {
		return profesorRepository.findById(profesor.getId()).orElse(null);
	}
	//login Profesor
	@Override
	@Transactional
	public Profesor profesorLogin(String mail) {
		List<Profesor> profesores = profesorRepository.findAll();
		Profesor profesorLogeado = new Profesor();
		for (int i = 0; i < profesores.size(); i++) {
			if(mail.equalsIgnoreCase(profesores.get(i).getCorreo())) {
				profesorLogeado.setAmaterno(profesores.get(i).getAmaterno());
				profesorLogeado.setApaterno(profesores.get(i).getApaterno());
				profesorLogeado.setColegio_id(profesores.get(i).getColegio_id());
				profesorLogeado.setContrasena(profesores.get(i).getContrasena());
				profesorLogeado.setCorreo(profesores.get(i).getCorreo());
				profesorLogeado.setDireccion(profesores.get(i).getDireccion());
				profesorLogeado.setEstado(profesores.get(i).getEstado());
				profesorLogeado.setFecha_nacimiento(profesores.get(i).getFecha_nacimiento());
				profesorLogeado.setId(profesores.get(i).getId());
				profesorLogeado.setNombre(profesores.get(i).getNombre());
				profesorLogeado.setRut(profesores.get(i).getRut());
				profesorLogeado.setTelefono(profesores.get(i).getTelefono());		
			}
		}
		return profesorLogeado;
	}

	//Servicio lista de profesores por colegio !!!!se utiliza
	@Override
	@Transactional
	public List<Profesor> profesorPorColegio(Integer colegioid) {
		List<Profesor> profes = profesorRepository.findAll();
		profes = profes.stream().filter(p->p.getColegio_id() == colegioid).collect(Collectors.toList());
		return profes;
	}
	
	
}
