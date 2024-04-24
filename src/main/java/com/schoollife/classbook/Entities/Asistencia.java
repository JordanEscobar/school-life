package com.schoollife.classbook.Entities;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "asistencia")
public class Asistencia {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@DateTimeFormat(iso=ISO.DATE)
	private Date fecha;
	@NotNull
	@NotEmpty
	@Column(name = "estado")
	private String estado;
	@NotNull
	@NotEmpty
	@NotBlank
	@Column(name = "descripcion")
	private String descripcion;
	@JoinColumn(name = "id_estudiante", nullable = false)
	private Integer id_estudiante;
	@JoinColumn(name = "id_asignatura", nullable = false)
	private Integer id_asignatura;
	public Asistencia(Integer id, Date fecha, String estado, String descripcion, Integer id_estudiante,
			Integer id_asignatura) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.estado = estado;
		this.descripcion = descripcion;
		this.id_estudiante = id_estudiante;
		this.id_asignatura = id_asignatura;
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
	public Integer getId_estudiante() {
		return id_estudiante;
	}
	public void setId_estudiante(Integer id_estudiante) {
		this.id_estudiante = id_estudiante;
	}
	public Integer getId_asignatura() {
		return id_asignatura;
	}
	public void setId_asignatura(Integer id_asignatura) {
		this.id_asignatura = id_asignatura;
	}
	@Override
	public String toString() {
		return "Asistencia [id=" + id + ", fecha=" + fecha + ", estado=" + estado + ", descripcion=" + descripcion
				+ ", id_estudiante=" + id_estudiante + ", id_asignatura=" + id_asignatura + "]";
	}
	
	
	

	

	
	
	

}
