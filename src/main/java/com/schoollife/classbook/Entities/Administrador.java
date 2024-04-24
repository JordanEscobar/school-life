package com.schoollife.classbook.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "administradores")
public class Administrador {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String rut;
	private String nombre;
	private String apaterno;
	private String amaterno;
	private String correo;
	private String telefono;
	private String estado;
	@JoinColumn(name = "id_colegio", nullable = false)
	private Integer id_colegio;
	@JoinColumn(name = "id_login", nullable = false)
	private Integer id_login;
	public Administrador(Integer id, String rut, String nombre, String apaterno, String amaterno, String correo,
			String telefono, String estado, Integer id_colegio, Integer id_login) {
		super();
		this.id = id;
		this.rut = rut;
		this.nombre = nombre;
		this.apaterno = apaterno;
		this.amaterno = amaterno;
		this.correo = correo;
		this.telefono = telefono;
		this.estado = estado;
		this.id_colegio = id_colegio;
		this.id_login = id_login;
	}
	public Administrador() {
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
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Integer getId_colegio() {
		return id_colegio;
	}
	public void setId_colegio(Integer id_colegio) {
		this.id_colegio = id_colegio;
	}
	public Integer getId_login() {
		return id_login;
	}
	public void setId_login(Integer id_login) {
		this.id_login = id_login;
	}
	@Override
	public String toString() {
		return "Administrador [id=" + id + ", rut=" + rut + ", nombre=" + nombre + ", apaterno=" + apaterno
				+ ", amaterno=" + amaterno + ", correo=" + correo + ", telefono=" + telefono + ", estado=" + estado
				+ ", id_colegio=" + id_colegio + ", id_login=" + id_login + "]";
	}
	
	

	

}
