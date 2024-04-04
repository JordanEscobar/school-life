package com.schoollife.classbook.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cursos")
public class Curso {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "curso")
	private String curso;
	@Column(name = "cantidad")
	private Integer cantidad;
	@Column(name= "profesor")
	private Integer profesor;
	@Column(name = "estudiante")
	private Integer estudiante;
	public Curso(Integer id, String curso, Integer cantidad, Integer profesor, Integer estudiante) {
		super();
		this.id = id;
		this.curso = curso;
		this.cantidad = cantidad;
		this.profesor = profesor;
		this.estudiante = estudiante;
	}
	public Curso() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public Integer getProfesor() {
		return profesor;
	}
	public void setProfesor(Integer profesor) {
		this.profesor = profesor;
	}
	public Integer getEstudiante() {
		return estudiante;
	}
	public void setEstudiante(Integer estudiante) {
		this.estudiante = estudiante;
	}
	@Override
	public String toString() {
		return "Curso [id=" + id + ", curso=" + curso + ", cantidad=" + cantidad + ", profesor=" + profesor
				+ ", estudiante=" + estudiante + "]";
	}
	
	

}
