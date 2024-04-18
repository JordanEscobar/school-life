package com.schoollife.classbook.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schoollife.classbook.Entities.Administrador;
import com.schoollife.classbook.Entities.Colegio;
import com.schoollife.classbook.Entities.Curso;
import com.schoollife.classbook.Repository.AdministradorRepository;
import com.schoollife.classbook.Repository.ColegioRepository;

import jakarta.transaction.Transactional;

@Service
public class ColegioServiceImpl implements ColegioService{

	@Autowired
	private final ColegioRepository colegioRepository;
	@Autowired
	private final AdministradorRepository administradorRepository;
	
	public ColegioServiceImpl(ColegioRepository colegioRepository, AdministradorRepository administradorRepository) {
		super();
		this.colegioRepository = colegioRepository;
		this.administradorRepository = administradorRepository;
	}

	@Override
	@Transactional
	public List<Colegio> getAllColegios() {
		return (List<Colegio>) colegioRepository.findAll();
	}

	@Override
	@Transactional
	public Colegio CreateColegio(Colegio colegio) {
		return colegioRepository.save(colegio);
	}

	@Override
	@Transactional
	public Colegio getColegioById(Integer id) {
		return colegioRepository.findById(id).get();
	}

	@Override
	@Transactional
	public void deleteColegio(Integer id) {
		colegioRepository.deleteById(id);
		
	}

	@Override
	@Transactional
	public void updateColegio(Colegio colegio, Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional
	public Colegio findColegio(Colegio colegio) {
		return colegioRepository.findById(colegio.getId()).orElse(null);
	}

	@Override
	@Transactional
	public Colegio getColegioByUsuarioId(Integer idAdministrador) {
		
		Optional<Administrador> ad = administradorRepository.findById(idAdministrador);
		
		List<Colegio> listaColegio = (List<Colegio>) colegioRepository.findAll();
		listaColegio = listaColegio.stream().filter(c -> c.getId() == ad.get().getColegio()).collect(Collectors.toList());
		Colegio c = new Colegio();
		for (Colegio colegio : listaColegio) {
			if(colegio.getId() == ad.get().getColegio()) {
				c.setCorreo(colegio.getCorreo());
				c.setDescripcion(colegio.getDescripcion());
				c.setDireccion(colegio.getDireccion());
				c.setId(colegio.getId());
				c.setNombre(colegio.getNombre());
				c.setRbd(colegio.getRbd());
				c.setTelefono(colegio.getTelefono());
			}	
		}		
		//lista de los administradores del colegio
		/*List<Administrador> listaAdmin = (List<Administrador>) administradorRepository.findAll();
		listaAdmin = listaAdmin.stream().filter(a -> a.getColegio() == c.getId()).collect(Collectors.toList());
		Administrador a = new Administrador();
		for (Administrador admin : listaAdmin) {
			if(admin.getColegio() == c.getId()) {
				a.setAmaterno(admin.getAmaterno());
				a.setApaterno(admin.getApaterno());
				a.setColegio(admin.getColegio());
				a.setCorreo(admin.getCorreo());
				a.setCuenta(admin.getCuenta());
				a.setEstado(admin.getEstado());
				a.setId(admin.getId());
				a.setNombre(admin.getNombre());
				a.setTelefono(admin.getTelefono());
			}
		}*/	
		return c;
	}
	
}
