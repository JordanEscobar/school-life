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
	@Column(name = "cantidad_max")
	private Integer cantidad_max;
	@Column(name = "cantidad_min")
	private Integer cantidad_min;
	@Column(name = "estado")
	private String estado;
	@Column(name= "id_colegio")
	private Integer id_colegio;
	@Column(name= "id_profesor_jefe")
	private Integer id_profesor_jefe;
	public Curso(Integer id, String nombre, char seccion, Integer cantidad, Integer cantidad_max, Integer cantidad_min,
			String estado, Integer id_colegio, Integer id_profesor_jefe) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.seccion = seccion;
		this.cantidad = cantidad;
		this.cantidad_max = cantidad_max;
		this.cantidad_min = cantidad_min;
		this.estado = estado;
		this.id_colegio = id_colegio;
		this.id_profesor_jefe = id_profesor_jefe;
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
	public Integer getCantidad_max() {
		return cantidad_max;
	}
	public void setCantidad_max(Integer cantidad_max) {
		this.cantidad_max = cantidad_max;
	}
	public Integer getCantidad_min() {
		return cantidad_min;
	}
	public void setCantidad_min(Integer cantidad_min) {
		this.cantidad_min = cantidad_min;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Integer getId_colegio() {
		return id_colegio;
	}
	public void setId_colegio(Integer id_colegio) {
		this.id_colegio = id_colegio;
	}
	public Integer getId_profesor_jefe() {
		return id_profesor_jefe;
	}
	public void setId_profesor_jefe(Integer id_profesor_jefe) {
		this.id_profesor_jefe = id_profesor_jefe;
	}
	@Override
	public String toString() {
		return "Curso [id=" + id + ", nombre=" + nombre + ", seccion=" + seccion + ", cantidad=" + cantidad
				+ ", cantidad_max=" + cantidad_max + ", cantidad_min=" + cantidad_min + ", estado=" + estado
				+ ", id_colegio=" + id_colegio + ", id_profesor_jefe=" + id_profesor_jefe + "]";
	}
	
	
	
	
	
	
	
	

}
