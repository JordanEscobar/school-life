package com.schoollife.classbook.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "profesores")
public class Profesor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "rut")
	private String rut;
	@Column(name = "especialidad")
	private String especialidad;
	@Column(name = "colegio")
	private Integer colegio;
	public Profesor(Integer id, String nombre, String rut, String especialidad, Integer colegio) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.rut = rut;
		this.especialidad = especialidad;
		this.colegio = colegio;
	}
	public Profesor() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getRut() {
		return rut;
	}
	public void setRut(String rut) {
		this.rut = rut;
	}
	public String getEspecialidad() {
		return especialidad;
	}
	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}
	public Integer getColegio() {
		return colegio;
	}
	public void setColegio(Integer colegio) {
		this.colegio = colegio;
	}
	@Override
	public String toString() {
		return "Profesor [id=" + id + ", nombre=" + nombre + ", rut=" + rut + ", especialidad=" + especialidad
				+ ", colegio=" + colegio + "]";
	}
	
	

}
