package com.schoollife.classbook.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "profesores")
public class Profesor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "apaterno")
	private String apaterno;
	@Column(name = "amaterno")
	private String amaterno;
	@Column(name = "rut")
	private String rut;
	@Column(name = "correo")
	private String correo;
	@Column(name = "telefono")
	private Integer telefono;
	@Column(name = "especialidad")
	private String especialidad;
	@Column(name = "estado")
	private String estado;
	@Column(name = "tipo")
	private Integer tipo;
	@Column(name = "colegio")
	private Integer colegio;
	public Profesor(Integer id, String nombre, String apaterno, String amaterno, String rut, String correo,
			Integer telefono, String especialidad, String estado, Integer tipo, Integer colegio) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apaterno = apaterno;
		this.amaterno = amaterno;
		this.rut = rut;
		this.correo = correo;
		this.telefono = telefono;
		this.especialidad = especialidad;
		this.estado = estado;
		this.tipo = tipo;
		this.colegio = colegio;
	}
	public Profesor() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public String getRut() {
		return rut;
	}
	public void setRut(String rut) {
		this.rut = rut;
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
	public String getEspecialidad() {
		return especialidad;
	}
	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Integer getTipo() {
		return tipo;
	}
	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}
	public Integer getColegio() {
		return colegio;
	}
	public void setColegio(Integer colegio) {
		this.colegio = colegio;
	}
	@Override
	public String toString() {
		return "Profesor [id=" + id + ", nombre=" + nombre + ", apaterno=" + apaterno + ", amaterno=" + amaterno
				+ ", rut=" + rut + ", correo=" + correo + ", telefono=" + telefono + ", especialidad=" + especialidad
				+ ", estado=" + estado + ", tipo=" + tipo + ", colegio=" + colegio + "]";
	}
	
	
	
	
	

}
