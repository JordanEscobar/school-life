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
@Table(name = "asistencias")
public class Asistencia {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@DateTimeFormat(iso=ISO.DATE)
	private Date fecha;
	@NotNull
	@NotEmpty
	@NotBlank
	@Column(name = "estado")
	private Boolean estado;
	@Column(name = "descripcion")
	private String descripcion;
	@JoinColumn(name = "estudiante_id", nullable = false)
	private Integer estudiante_id;
	@JoinColumn(name = "asignatura_id", nullable = false)
	private Integer asignatura_id;
	public Asistencia(Integer id, Date fecha, @NotNull @NotEmpty @NotBlank Boolean estado, String descripcion,
			Integer estudiante_id, Integer asignatura_id) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.estado = estado;
		this.descripcion = descripcion;
		this.estudiante_id = estudiante_id;
		this.asignatura_id = asignatura_id;
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
	public Boolean getEstado() {
		return estado;
	}
	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Integer getEstudiante_id() {
		return estudiante_id;
	}
	public void setEstudiante_id(Integer estudiante_id) {
		this.estudiante_id = estudiante_id;
	}
	public Integer getAsignatura_id() {
		return asignatura_id;
	}
	public void setAsignatura_id(Integer asignatura_id) {
		this.asignatura_id = asignatura_id;
	}
	@Override
	public String toString() {
		return "Asistencia [id=" + id + ", fecha=" + fecha + ", estado=" + estado + ", descripcion=" + descripcion
				+ ", estudiante_id=" + estudiante_id + ", asignatura_id=" + asignatura_id + "]";
	}
	
	
	

	
	
	

}
