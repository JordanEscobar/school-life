package com.schoollife.classbook.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tipo_profesor")
public class Tipo_profesor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "descripcion")
	private String descripcion;
	public Tipo_profesor(Integer id, String nombre, String descripcion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}
	public Tipo_profesor() {
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
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	@Override
	public String toString() {
		return "Tipo_profesor [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + "]";
	}
	
	

}
