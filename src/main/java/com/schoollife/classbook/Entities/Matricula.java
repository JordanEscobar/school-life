package com.schoollife.classbook.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "matriculas")
public class Matricula {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "descripcion")
	private String descripcion;
	@Column(name = "estado")
	private String estado;
	@Column(name = "estudiante")
	private Integer estudiante;
	@Column(name = "apoderado")
	private Integer apoderado;
	@Column(name = "colegio")
	private Integer colegio;
	public Matricula(Integer id, String descripcion, String estado, Integer estudiante, Integer apoderado,
			Integer colegio) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.estado = estado;
		this.estudiante = estudiante;
		this.apoderado = apoderado;
		this.colegio = colegio;
	}
	public Matricula() {
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
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Integer getEstudiante() {
		return estudiante;
	}
	public void setEstudiante(Integer estudiante) {
		this.estudiante = estudiante;
	}
	public Integer getApoderado() {
		return apoderado;
	}
	public void setApoderado(Integer apoderado) {
		this.apoderado = apoderado;
	}
	public Integer getColegio() {
		return colegio;
	}
	public void setColegio(Integer colegio) {
		this.colegio = colegio;
	}
	@Override
	public String toString() {
		return "Matricula [id=" + id + ", descripcion=" + descripcion + ", estado=" + estado + ", estudiante="
				+ estudiante + ", apoderado=" + apoderado + ", colegio=" + colegio + "]";
	}
	
	

	
	
	

}
