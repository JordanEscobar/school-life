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
	
	
	//listar todos los cursos
	@Override
	@Transactional
	public List<Curso> getAll() {
		return cursoRepository.findAll();
	}
	//actualizar
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
	//buscar curso por curso
	@Override
	@Transactional
	public Curso findCurso(Curso curso) {
		return cursoRepository.findById(curso.getId()).orElse(null);
	}

	//curso por profesor jefe
	@Override
	@Transactional
	public Curso getCursoByIdProfesorJefe(Integer id) {
		List<Curso> listaCurso = (List<Curso>) cursoRepository.findAll();
		listaCurso = listaCurso.stream().filter(c -> c.getProfesor_id() == id).collect(Collectors.toList());
		Curso c = new Curso();
		for (Curso curso : listaCurso) {
			if(curso.getProfesor_id() == id) {
				c.setId(curso.getId());
				c.setEstado(curso.getEstado());
				c.setGrado(curso.getGrado());
				c.setColegio_id(curso.getColegio_id());
				c.setProfesor_id(curso.getProfesor_id());
				c.setSeccion(curso.getSeccion());
			}
		}
		return c;
	}

	//estudiantes de un curso
	@Override
	@Transactional
	public List<Estudiante> getEstudianteByIdCurso(Integer id) {
		List<Estudiante> listaEstudiante = (List<Estudiante>) estudianteRepository.findAll();
		listaEstudiante = listaEstudiante.stream().filter(e -> e.getCurso_id() == id).collect(Collectors.toList());
		return listaEstudiante;
	}
	
	
	//Cursos por colegio !!!no borrar!!!!
	@Override
	@Transactional
	public List<Object[]> cursoPorColegio(Integer colegioId) {
		List<Object[]> cursos = cursoRepository.cursoPorColegio(colegioId);
		return cursos;
	}

	//Crear cursos administrador !!!!!!No borrar!!!!!
	@Override
	@Transactional
	public Curso CreateCurso(Curso curso) {
		return cursoRepository.save(curso);
	}

	//curso por profesor
	@Override
	@Transactional
	public List<Object[]> cursosPorProfesor(Integer profesorId) {
		List<Object[]> cursos = cursoRepository.cursosPorProfesor(profesorId);
		return cursos;
	}


	@Override
	@Transactional
	public List<Curso> cursosPorProfesorNoQuery(Integer profesor_id) {
		List<Curso> cursos = cursoRepository.findAll();
		cursos = cursos.stream().filter(c -> c.getProfesor_id() == profesor_id).collect(Collectors.toList());
		return cursos;
	}
	
	

}
