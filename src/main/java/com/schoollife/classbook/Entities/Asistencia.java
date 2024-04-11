package com.schoollife.classbook.Entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "asistencias")
public class Asistencia {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "registro_asignatura")
	private Integer registro_asignatura;
	@Column(name = "fecha")
	private Date fecha;
	@Column(name = "estado")
	private boolean estado;
	@Column(name = "descripcion")
	private String descripcion;
	public Asistencia(Integer id, Integer registro_asignatura, Date fecha, boolean estado, String descripcion) {
		super();
		this.id = id;
		this.registro_asignatura = registro_asignatura;
		this.fecha = fecha;
		this.estado = estado;
		this.descripcion = descripcion;
	}
	public Asistencia() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getRegistro_asignatura() {
		return registro_asignatura;
	}
	public void setRegistro_asignatura(Integer registro_asignatura) {
		this.registro_asignatura = registro_asignatura;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	@Override
	public String toString() {
		return "Asistencia [id=" + id + ", registro_asignatura=" + registro_asignatura + ", fecha=" + fecha
				+ ", estado=" + estado + ", descripcion=" + descripcion + "]";
	}
	
	

	
	
	

}
