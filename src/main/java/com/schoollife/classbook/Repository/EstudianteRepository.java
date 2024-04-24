package com.schoollife.classbook.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.schoollife.classbook.Entities.Estudiante;

public interface EstudianteRepository extends JpaRepository<Estudiante, Integer>{

}
