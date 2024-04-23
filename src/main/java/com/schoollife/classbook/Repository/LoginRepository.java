package com.schoollife.classbook.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.schoollife.classbook.Entities.Login;

public interface LoginRepository extends JpaRepository<Login, Integer>{

}
