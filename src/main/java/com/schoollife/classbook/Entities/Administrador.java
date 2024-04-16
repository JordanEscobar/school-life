package com.schoollife.classbook.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "administradores")
public class Administrador {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nombre;
	private String apaterno;
	private String amaterno;
	private String correo;
	private Integer telefono;
	private Integer cuenta;
	private Integer colegio;
	private String estado;
	public Administrador(Integer id, String nombre, String apaterno, String amaterno, String correo, Integer telefono,
			Integer cuenta, Integer colegio, String estado) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apaterno = apaterno;
		this.amaterno = amaterno;
		this.correo = correo;
		this.telefono = telefono;
		this.cuenta = cuenta;
		this.colegio = colegio;
		this.estado = estado;
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
	public Integer getTelefono() {
		return telefono;
	}
	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}
	public Integer getCuenta() {
		return cuenta;
	}
	public void setCuenta(Integer cuenta) {
		this.cuenta = cuenta;
	}
	public Integer getColegio() {
		return colegio;
	}
	public void setColegio(Integer colegio) {
		this.colegio = colegio;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	@Override
	public String toString() {
		return "Administrador [id=" + id + ", nombre=" + nombre + ", apaterno=" + apaterno + ", amaterno=" + amaterno
				+ ", correo=" + correo + ", telefono=" + telefono + ", cuenta=" + cuenta + ", colegio=" + colegio
				+ ", estado=" + estado + "]";
	}
	
	

}
