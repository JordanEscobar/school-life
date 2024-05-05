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
@Table(name = "matriculas")
public class Matricula {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@DateTimeFormat(iso=ISO.DATE)
	private Date fecha;
	@NotBlank
	@NotNull
	@NotEmpty
	@Column(name = "estado")
	private String estado;
	@JoinColumn(name = "estudiante_id", nullable = false)
	private Integer estudiante_id;
	@JoinColumn(name = "colegio_id", nullable = false)
	private Integer colegio_id;
	public Matricula(Integer id, Date fecha, String estado, Integer estudiante_id, Integer colegio_id) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.estado = estado;
		this.estudiante_id = estudiante_id;
		this.colegio_id = colegio_id;
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
	public Integer getEstudiante_id() {
		return estudiante_id;
	}
	public void setEstudiante_id(Integer estudiante_id) {
		this.estudiante_id = estudiante_id;
	}
	public Integer getColegio_id() {
		return colegio_id;
	}
	public void setColegio_id(Integer colegio_id) {
		this.colegio_id = colegio_id;
	}
	@Override
	public String toString() {
		return "Matricula [id=" + id + ", fecha=" + fecha + ", estado=" + estado + ", estudiante_id=" + estudiante_id
				+ ", colegio_id=" + colegio_id + "]";
	}
	
	
	
	
	
	

	
	
	

}
