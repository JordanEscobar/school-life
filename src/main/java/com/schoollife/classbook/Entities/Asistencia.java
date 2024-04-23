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
	@Column(name = "registro_asignaturas")
	private Integer id_registro_asignaturas;
	@Column(name = "fecha")
	private Date fecha;
	@Column(name = "estado")
	private String estado;
	@Column(name = "descripcion")
	private String descripcion;
	public Asistencia(Integer id, Integer id_registro_asignaturas, Date fecha, String estado, String descripcion) {
		super();
		this.id = id;
		this.id_registro_asignaturas = id_registro_asignaturas;
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
	public Integer getId_registro_asignaturas() {
		return id_registro_asignaturas;
	}
	public void setId_registro_asignaturas(Integer id_registro_asignaturas) {
		this.id_registro_asignaturas = id_registro_asignaturas;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
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
		return "Asistencia [id=" + id + ", id_registro_asignaturas=" + id_registro_asignaturas + ", fecha=" + fecha
				+ ", estado=" + estado + ", descripcion=" + descripcion + "]";
	}
	
	
	
	

	
	
	

}
