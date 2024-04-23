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
	@Column(name = "id_estudiante")
	private Integer id_estudiante;
	@Column(name = "id_apoderado")
	private Integer id_apoderado;
	@Column(name = "id_colegio")
	private Integer id_colegio;
	public Matricula(Integer id, String descripcion, String estado, Integer id_estudiante, Integer id_apoderado,
			Integer id_colegio) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.estado = estado;
		this.id_estudiante = id_estudiante;
		this.id_apoderado = id_apoderado;
		this.id_colegio = id_colegio;
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
	public Integer getId_estudiante() {
		return id_estudiante;
	}
	public void setId_estudiante(Integer id_estudiante) {
		this.id_estudiante = id_estudiante;
	}
	public Integer getId_apoderado() {
		return id_apoderado;
	}
	public void setId_apoderado(Integer id_apoderado) {
		this.id_apoderado = id_apoderado;
	}
	public Integer getId_colegio() {
		return id_colegio;
	}
	public void setId_colegio(Integer id_colegio) {
		this.id_colegio = id_colegio;
	}
	@Override
	public String toString() {
		return "Matricula [id=" + id + ", descripcion=" + descripcion + ", estado=" + estado + ", id_estudiante="
				+ id_estudiante + ", id_apoderado=" + id_apoderado + ", id_colegio=" + id_colegio + "]";
	}
	
	
	
	
	

	
	
	

}
