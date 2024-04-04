package com.schoollife.classbook.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "apoderados")
public class Apoderado {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "apellido")
	private String apellido;
	@Column(name = "colegio")
	private Integer colegio;
	public Apoderado(Integer id, String nombre, String apellido, Integer colegio) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.colegio = colegio;
	}
	public Apoderado() {
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
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public Integer getColegio() {
		return colegio;
	}
	public void setColegio(Integer colegio) {
		this.colegio = colegio;
	}
	@Override
	public String toString() {
		return "Apoderado [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", colegio=" + colegio + "]";
	}
	
	
	
	
	

}
