package com.schoollife.web.Entities;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "asistencias")
public class Asistencia {
	@Id
	private Integer id_asistencia;
	private Date fecha;
	private boolean asistio;
	private Integer curso_id;
	public Asistencia(Integer id_asistencia, Date fecha, boolean asistio, Integer curso_id) {
		super();
		this.id_asistencia = id_asistencia;
		this.fecha = fecha;
		this.asistio = asistio;
		this.curso_id = curso_id;
	}
	public Asistencia() {
		super();
	}
	public Integer getId_asistencia() {
		return id_asistencia;
	}
	public void setId_asistencia(Integer id_asistencia) {
		this.id_asistencia = id_asistencia;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public boolean isAsistio() {
		return asistio;
	}
	public void setAsistio(boolean asistio) {
		this.asistio = asistio;
	}
	public Integer getCurso_id() {
		return curso_id;
	}
	public void setCurso_id(Integer curso_id) {
		this.curso_id = curso_id;
	}
	@Override
	public String toString() {
		return "Asistencia [id_asistencia=" + id_asistencia + ", fecha=" + fecha + ", asistio=" + asistio
				+ ", curso_id=" + curso_id + "]";
	}
	
	

}
