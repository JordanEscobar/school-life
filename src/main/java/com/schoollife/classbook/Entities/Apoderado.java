package com.schoollife.classbook.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "apoderados")
public class Apoderado {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "rut")
	private String rut;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "apaterno")
	private String apaterno;
	@Column(name = "amaterno")
	private String amaterno;
	@Column(name = "direccion")
	private Integer direccion;
	@Column(name = "correo")
	private String correo;
	@Column(name = "telefono")
	private Integer telefono;
	@Column(name = "estado")
	private String estado;
	@Column(name = "estudiante")
	private Integer estudiante;
	public Apoderado(Integer id, String rut, String nombre, String apaterno, String amaterno, Integer direccion,
			String correo, Integer telefono, String estado, Integer estudiante) {
		super();
		this.id = id;
		this.rut = rut;
		this.nombre = nombre;
		this.apaterno = apaterno;
		this.amaterno = amaterno;
		this.direccion = direccion;
		this.correo = correo;
		this.telefono = telefono;
		this.estado = estado;
		this.estudiante = estudiante;
	}
	public Apoderado() {
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
	public String getApaterno() {
		return apaterno;
	}
	public void setApaterno(String apaterno) {
		this.apaterno = apaterno;
	}
	public String getAmaterno() {
		return amaterno;
	}
	public void setAmaterno(String amaterno) {
		this.amaterno = amaterno;
	}
	public Integer getDireccion() {
		return direccion;
	}
	public void setDireccion(Integer direccion) {
		this.direccion = direccion;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public Integer getTelefono() {
		return telefono;
	}
	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Integer getEstudiante() {
		return estudiante;
	}
	public void setEstudiante(Integer estudiante) {
		this.estudiante = estudiante;
	}
	@Override
	public String toString() {
		return "Apoderado [id=" + id + ", rut=" + rut + ", nombre=" + nombre + ", apaterno=" + apaterno + ", amaterno="
				+ amaterno + ", direccion=" + direccion + ", correo=" + correo + ", telefono=" + telefono + ", estado="
				+ estado + ", estudiante=" + estudiante + "]";
	}
	
	
	
	

}
