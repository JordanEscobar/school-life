package com.schoollife.classbook.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
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
	@NotNull
	@Column(name = "estado")
	private String estado;
	@JoinColumn(name = "colegio_id", nullable = false)
	private Integer colegio_id;
	@JoinColumn(name = "profesor_id", nullable = false)
	private Integer profesor_id;
	public Curso(Integer id, @NotNull String grado, @NotNull char seccion, @NotNull String estado, Integer colegio_id,
			Integer profesor_id) {
		super();
		this.id = id;
		this.grado = grado;
		this.seccion = seccion;
		this.estado = estado;
		this.colegio_id = colegio_id;
		this.profesor_id = profesor_id;
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
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Integer getColegio_id() {
		return colegio_id;
	}
	public void setColegio_id(Integer colegio_id) {
		this.colegio_id = colegio_id;
	}
	public Integer getProfesor_id() {
		return profesor_id;
	}
	public void setProfesor_id(Integer profesor_id) {
		this.profesor_id = profesor_id;
	}
	@Override
	public String toString() {
		return "Curso [id=" + id + ", grado=" + grado + ", seccion=" + seccion + ", estado=" + estado + ", colegio_id="
				+ colegio_id + ", profesor_id=" + profesor_id + "]";
	}
	
	
	
	
	
	

}
