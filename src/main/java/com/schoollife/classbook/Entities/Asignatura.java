package com.schoollife.classbook.Entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "asignatura")
public class Asignatura {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "profesor")
	private Integer profesor;
	public Asignatura(Integer id, String nombre, Integer profesor) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.profesor = profesor;
	}
	public Asignatura() {
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
	public Integer getProfesor() {
		return profesor;
	}
	public void setProfesor(Integer profesor) {
		this.profesor = profesor;
	}
	@Override
	public String toString() {
		return "Asignatura [id=" + id + ", nombre=" + nombre + ", profesor=" + profesor + "]";
	}
	
	
	
	
	

}
