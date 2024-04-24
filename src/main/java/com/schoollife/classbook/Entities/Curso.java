package com.schoollife.classbook.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "cursos")
public class Curso {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotNull
	@Column(name = "grado")
	private String grado;
	@NotNull
	@Column(name = "seccion")
	private char seccion;
	@Min(value = 1)
	@Column(name = "cantidad")
	private Integer cantidad;
	@Min(value = 1)
	@Column(name = "cantidad_max")
	private Integer cantidad_max;
	@Min(value = 1)
	@Column(name = "cantidad_min")
	private Integer cantidad_min;
	@NotNull
	@Column(name = "estado")
	private String estado;
	@JoinColumn(name = "id_colegio", nullable = false)
	private Integer id_colegio;
	@JoinColumn(name = "id_profesor_jefe", nullable = false)
	private Integer id_profesor_jefe;
	public Curso(Integer id, String grado, char seccion, Integer cantidad, Integer cantidad_max, Integer cantidad_min,
			String estado, Integer id_colegio, Integer id_profesor_jefe) {
		super();
		this.id = id;
		this.grado = grado;
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
	public String getGrado() {
		return grado;
	}
	public void setGrado(String grado) {
		this.grado = grado;
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
		return "Curso [id=" + id + ", grado=" + grado + ", seccion=" + seccion + ", cantidad=" + cantidad
				+ ", cantidad_max=" + cantidad_max + ", cantidad_min=" + cantidad_min + ", estado=" + estado
				+ ", id_colegio=" + id_colegio + ", id_profesor_jefe=" + id_profesor_jefe + "]";
	}
	
	
	

}
