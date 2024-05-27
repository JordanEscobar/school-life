package com.schoollife.web.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "roles")
public class Rol {
	@Id
	private Integer id_rol;
	private String nombre;
	private String descripcion;
	public Rol(Integer id_rol, String nombre, String descripcion) {
		super();
		this.id_rol = id_rol;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}
	public Rol() {
		super();
	}
	public Integer getId_rol() {
		return id_rol;
	}
	public void setId_rol(Integer id_rol) {
		this.id_rol = id_rol;
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
		return "Rol [id_rol=" + id_rol + ", nombre=" + nombre + ", descripcion=" + descripcion + "]";
	}
	
	

}
