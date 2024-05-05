package com.schoollife.classbook.Entities;

import java.util.Date;

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
@Table(name = "registro_conexiones")
public class Registro_conexion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotBlank
	@NotNull
	@NotEmpty
	@Column(name = "descripcion")
	private String descripcion;
	@Column(name = "fecha")
	private Date fecha;//debe capturar la hora y minutos igual
	@JoinColumn(name = "colegio_id", nullable = false)
	private Integer colegio_id;
	public Registro_conexion(Integer id, String descripcion, Date fecha, Integer colegio_id) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.fecha = fecha;
		this.colegio_id = colegio_id;
	}
	public Registro_conexion() {
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
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Integer getColegio_id() {
		return colegio_id;
	}
	public void setColegio_id(Integer colegio_id) {
		this.colegio_id = colegio_id;
	}
	@Override
	public String toString() {
		return "Registro_conexion [id=" + id + ", descripcion=" + descripcion + ", fecha=" + fecha + ", colegio_id="
				+ colegio_id + "]";
	}
	
	
	
	
	

}
