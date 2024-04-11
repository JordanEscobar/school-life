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
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "seccion")
	private char seccion;
	@Column(name = "cantidad")
	private Integer cantidad;
	@Column(name = "estado")
	private String estado;
	@Column(name= "profesor_jefe")
	private Integer profesor_jefe;
	public Curso(Integer id, String nombre, char seccion, Integer cantidad, String estado, Integer profesor_jefe) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.seccion = seccion;
		this.cantidad = cantidad;
		this.estado = estado;
		this.profesor_jefe = profesor_jefe;
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
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public char getSeccion() {
		return seccion;
	}
	public void setSeccion(char seccion) {
		this.seccion = seccion;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Integer getProfesor_jefe() {
		return profesor_jefe;
	}
	public void setProfesor_jefe(Integer profesor_jefe) {
		this.profesor_jefe = profesor_jefe;
	}
	@Override
	public String toString() {
		return "Curso [id=" + id + ", nombre=" + nombre + ", seccion=" + seccion + ", cantidad=" + cantidad
				+ ", estado=" + estado + ", profesor_jefe=" + profesor_jefe + "]";
	}
	
	
	
	

}
