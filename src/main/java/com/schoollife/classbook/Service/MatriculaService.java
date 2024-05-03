package com.schoollife.classbook.Service;

import java.util.List;

import com.schoollife.classbook.Entities.Matricula;

public interface MatriculaService {
	//listar matriculas por colegio
	List<Matricula> matriculasPorColegio(Integer colegioid);
	
	Matricula CreateMatricula(Matricula matricula);

}
