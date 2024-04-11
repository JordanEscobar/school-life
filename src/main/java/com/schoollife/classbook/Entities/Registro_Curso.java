package com.schoollife.classbook.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "registro_cursos")
public class Registro_Curso {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "estudiante")
	private Integer estudiante;
	@Column(name = "curso")
	private Integer curso;
	@Column(name = "descripcion")
	private String descripcion;
	public Registro_Curso(Integer id, Integer estudiante, Integer curso, String descripcion) {
		super();
		this.id = id;
		this.estudiante = estudiante;
		this.curso = curso;
		this.descripcion = descripcion;
	}
	public Registro_Curso() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getEstudiante() {
		return estudiante;
	}
	public void setEstudiante(Integer estudiante) {
		this.estudiante = estudiante;
	}
	public Integer getCurso() {
		return curso;
	}
	public void setCurso(Integer curso) {
		this.curso = curso;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	@Override
	public String toString() {
		return "Registro_Curso [id=" + id + ", estudiante=" + estudiante + ", curso=" + curso + ", descripcion="
				+ descripcion + "]";
	}
	
	
	
	

}
