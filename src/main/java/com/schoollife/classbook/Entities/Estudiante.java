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
	@Column(name = "apaterno")
	private String apaterno;
	@Column(name = "amaterno")
	private String amaterno;
	@Column(name = "direccion")
	private Integer direccion;
	@Column(name = "telefono")
	private Integer telefono;
	@Column(name = "correo")
	private String correo;
	@Column(name = "estado")
	private String estado;
	@Column(name = "colegio")
	private Integer colegio;
	@Column(name = "cuenta_sys")
	private Integer cuenta_sys;
	public Estudiante(Integer id, String rut, String nombre, String apaterno, String amaterno, Integer direccion,
			Integer telefono, String correo, String estado, Integer colegio, Integer cuenta_sys) {
		super();
		this.id = id;
		this.rut = rut;
		this.nombre = nombre;
		this.apaterno = apaterno;
		this.amaterno = amaterno;
		this.direccion = direccion;
		this.telefono = telefono;
		this.correo = correo;
		this.estado = estado;
		this.colegio = colegio;
		this.cuenta_sys = cuenta_sys;
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
	public Integer getTelefono() {
		return telefono;
	}
	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Integer getColegio() {
		return colegio;
	}
	public void setColegio(Integer colegio) {
		this.colegio = colegio;
	}
	public Integer getCuenta_sys() {
		return cuenta_sys;
	}
	public void setCuenta_sys(Integer cuenta_sys) {
		this.cuenta_sys = cuenta_sys;
	}
	@Override
	public String toString() {
		return "Estudiante [id=" + id + ", rut=" + rut + ", nombre=" + nombre + ", apaterno=" + apaterno + ", amaterno="
				+ amaterno + ", direccion=" + direccion + ", telefono=" + telefono + ", correo=" + correo + ", estado="
				+ estado + ", colegio=" + colegio + ", cuenta_sys=" + cuenta_sys + "]";
	}
	
	
	
	
	
	

}
