package com.schoollife.classbook.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "datos_asignatura")
public class Dato_asignatura {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "estudiante")
	private Integer estudiante;
	@Column(name = "asignatura")
	private Integer asignatura;
	public Dato_asignatura(Integer id, Integer estudiante, Integer asignatura) {
		super();
		this.id = id;
		this.estudiante = estudiante;
		this.asignatura = asignatura;
	}
	public Dato_asignatura() {
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
	@Override
	public String toString() {
		return "Dato_asignatura [id=" + id + ", estudiante=" + estudiante + ", asignatura=" + asignatura + "]";
	}
	
	

}
