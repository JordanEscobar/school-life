package com.schoollife.classbook.Entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "asistencia")
public class Asistencia {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "fecha")
	private Date fecha;
	@Column(name = "estado")
	private boolean estado;
	@Column(name = "justificacion")
	private String justificacion;
	@Column(name = "total")
	private Integer total;
	@Column(name = "asignatura")
	private Integer asignatura;
	public Asistencia(Integer id, Date fecha, boolean estado, String justificacion, Integer total, Integer asignatura) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.estado = estado;
		this.justificacion = justificacion;
		this.total = total;
		this.asignatura = asignatura;
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
	public String getJustificacion() {
		return justificacion;
	}
	public void setJustificacion(String justificacion) {
		this.justificacion = justificacion;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public Integer getAsignatura() {
		return asignatura;
	}
	public void setAsignatura(Integer asignatura) {
		this.asignatura = asignatura;
	}
	@Override
	public String toString() {
		return "Asistencia [id=" + id + ", fecha=" + fecha + ", estado=" + estado + ", justificacion=" + justificacion
				+ ", total=" + total + ", asignatura=" + asignatura + "]";
	}
	
	
	

}
