package com.schoollife.classbook.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schoollife.classbook.Entities.Administrador;
import com.schoollife.classbook.Repository.AdministradorRepository;

import jakarta.transaction.Transactional;

@Service
public class AdministradorServiceImpl implements AdministradorService{

	@Autowired
	private final AdministradorRepository administradorRepository;
	
	public AdministradorServiceImpl(AdministradorRepository administradorRepository) {
		super();
		this.administradorRepository = administradorRepository;
	}
	//listar
	@Override
	@Transactional
	public List<Administrador> findAll() {
		return administradorRepository.findAll();
	}
	//login admin
	@Override
	@Transactional
	public Administrador administradorLogin(String mail) {
		List<Administrador> administradores = administradorRepository.findAll();
		Administrador admin = new Administrador();
		for (int i = 0; i < administradores.size(); i++) {
			if (mail.equalsIgnoreCase(administradores.get(i).getCorreo())) {
				admin.setAmaterno(administradores.get(i).getAmaterno());
				admin.setApaterno(administradores.get(i).getApaterno());
				admin.setCargo(administradores.get(i).getCargo());
				admin.setColegio_id(administradores.get(i).getColegio_id());
				admin.setContrasena(administradores.get(i).getContrasena());
				admin.setCorreo(administradores.get(i).getCorreo());
				admin.setDireccion(administradores.get(i).getDireccion());
				admin.setEstado(administradores.get(i).getEstado());
				admin.setFecha_nacimiento(administradores.get(i).getFecha_nacimiento());
				admin.setId(administradores.get(i).getId());
				admin.setNombre(administradores.get(i).getNombre());
				admin.setRut(administradores.get(i).getRut());
				admin.setTelefono(administradores.get(i).getTelefono());
			}
		}
		return admin;
	}

}
