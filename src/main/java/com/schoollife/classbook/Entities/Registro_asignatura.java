package com.schoollife.classbook.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "registro_asignatura")
public class Registro_asignatura {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "estudiante")
	private Integer estudiante;
	@Column(name = "asignatura")
	private Integer asignatura;
	@Column(name = "descripcion")
	private String descripcion;
	public Registro_asignatura(Integer id, Integer estudiante, Integer asignatura, String descripcion) {
		super();
		this.id = id;
		this.estudiante = estudiante;
		this.asignatura = asignatura;
		this.descripcion = descripcion;
	}
	public Registro_asignatura() {
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
	public Integer getAsignatura() {
		return asignatura;
	}
	public void setAsignatura(Integer asignatura) {
		this.asignatura = asignatura;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	@Override
	public String toString() {
		return "Registro_asignatura [id=" + id + ", estudiante=" + estudiante + ", asignatura=" + asignatura
				+ ", descripcion=" + descripcion + "]";
	}
	
	

}
