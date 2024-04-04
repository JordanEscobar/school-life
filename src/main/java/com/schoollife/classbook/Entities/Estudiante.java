package com.schoollife.classbook.Entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "estudiantes")
public class Estudiante {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "rut")
	private String rut;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "apellido")
	private String apellido;
	@Column(name = "fecha_nacimiento")
	private Date fecha_nacimiento;
	@Column(name= "apoderado")
	private Integer apoderado;
	public Estudiante(Integer id, String rut, String nombre, String apellido, Date fecha_nacimiento,
			Integer apoderado) {
		super();
		this.id = id;
		this.rut = rut;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fecha_nacimiento = fecha_nacimiento;
		this.apoderado = apoderado;
	}
	public Estudiante() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getRut() {
		return rut;
	}
	public void setRut(String rut) {
		this.rut = rut;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public Date getFecha_nacimiento() {
		return fecha_nacimiento;
	}
	public void setFecha_nacimiento(Date fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}
	public Integer getApoderado() {
		return apoderado;
	}
	public void setApoderado(Integer apoderado) {
		this.apoderado = apoderado;
	}
	@Override
	public String toString() {
		return "Estudiante [id=" + id + ", rut=" + rut + ", nombre=" + nombre + ", apellido=" + apellido
				+ ", fecha_nacimiento=" + fecha_nacimiento + ", apoderado=" + apoderado + "]";
	}
	
	

}
