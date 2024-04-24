package com.schoollife.classbook.Entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "matriculas")
public class Matricula {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Date fecha_matricula;
	private String descripcion;
	@Column(name = "estado")
	private String estado;
	@JoinColumn(name = "id_estudiante", nullable = false)
	private Integer id_estudiante;
	@JoinColumn(name = "id_colegio", nullable = false)
	private Integer id_colegio;
	public Matricula(Integer id, Date fecha_matricula, String descripcion, String estado, Integer id_estudiante,
			Integer id_colegio) {
		super();
		this.id = id;
		this.fecha_matricula = fecha_matricula;
		this.descripcion = descripcion;
		this.estado = estado;
		this.id_estudiante = id_estudiante;
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
	public Date getFecha_matricula() {
		return fecha_matricula;
	}
	public void setFecha_matricula(Date fecha_matricula) {
		this.fecha_matricula = fecha_matricula;
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
	public Integer getId_colegio() {
		return id_colegio;
	}
	public void setId_colegio(Integer id_colegio) {
		this.id_colegio = id_colegio;
	}
	@Override
	public String toString() {
		return "Matricula [id=" + id + ", fecha_matricula=" + fecha_matricula + ", descripcion=" + descripcion
				+ ", estado=" + estado + ", id_estudiante=" + id_estudiante + ", id_colegio=" + id_colegio + "]";
	}
	
	
	
	
	
	
	
	

	
	
	

}
