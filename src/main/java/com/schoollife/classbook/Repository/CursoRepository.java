package com.schoollife.classbook.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.schoollife.classbook.Entities.Curso;

public interface CursoRepository extends JpaRepository<Curso, Integer>{

}
