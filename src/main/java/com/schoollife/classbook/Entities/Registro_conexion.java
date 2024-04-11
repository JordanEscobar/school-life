package com.schoollife.classbook.Entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "registro_conexiones")
public class Registro_conexion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "descripcion")
	private String descripcion;
	@Column(name = "fecha")
	private Date fecha;
	public Registro_conexion(Integer id, String descripcion, Date fecha) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.fecha = fecha;
	}
	public Registro_conexion() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	@Override
	public String toString() {
		return "Registro_conexion [id=" + id + ", descripcion=" + descripcion + ", fecha=" + fecha + "]";
	}
	
	
	

}
