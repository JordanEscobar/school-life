package com.schoollife.classbook.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.schoollife.classbook.Entities.Curso;
import com.schoollife.classbook.Entities.Estudiante;
import com.schoollife.classbook.Repository.CursoRepository;
import com.schoollife.classbook.Repository.EstudianteRepository;

import jakarta.transaction.Transactional;

@Service
public class CursoServiceImpl implements CursoService{
	
	@Autowired
	private final CursoRepository cursoRepository;
	@Autowired
	private final EstudianteRepository estudianteRepository;

	public CursoServiceImpl(CursoRepository cursoRepository, EstudianteRepository estudianteRepository) {
		super();
		this.cursoRepository = cursoRepository;
		this.estudianteRepository = estudianteRepository;
	}

	@Override
	@Transactional
	public List<Curso> getAll() {
		return cursoRepository.findAll();
	}

	@Override
	@Transactional
	public void updateCurso(Curso curso, Integer id) {
		Optional<Curso> cursoId = cursoRepository.findById(id);
		Curso cursoN = cursoId.get();
		cursoN.setId(curso.getId());
		cursoN.setGrado(curso.getGrado());
		cursoN.setSeccion(curso.getSeccion());
		cursoRepository.save(cursoN);
	}

	@Override
	@Transactional
	public Curso findCurso(Curso curso) {
		return cursoRepository.findById(curso.getId()).orElse(null);
	}

	@Override
	public List<Estudiante> getEstudianteByIdCurso(Integer id) {
		List<Estudiante> listaEstudiante = (List<Estudiante>) estudianteRepository.findAll();
		listaEstudiante = listaEstudiante.stream().filter(e -> e.getId_curso() == id).collect(Collectors.toList());
		return listaEstudiante;
	}

	@Override
	public Curso getCursoByIdProfesorJefe(Integer id) {
		List<Curso> listaCurso = (List<Curso>) cursoRepository.findAll();
		listaCurso = listaCurso.stream().filter(c -> c.getId_profesor_jefe() == id).collect(Collectors.toList());
		Curso c = new Curso();
		for (Curso curso : listaCurso) {
			if(curso.getId_profesor_jefe() == id) {
				c.setId(curso.getId());
				c.setCantidad(curso.getCantidad());
				c.setEstado(curso.getEstado());
				c.setGrado(curso.getGrado());
				c.setCantidad_max(curso.getCantidad_max());
				c.setCantidad_min(curso.getCantidad_min());
				c.setId_colegio(curso.getId_colegio());
				c.setId_profesor_jefe(curso.getId_profesor_jefe());
				c.setSeccion(curso.getSeccion());
			}
		}
		return c;
	}

}
