package com.schoollife.classbook.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "colegios")
public class Colegio {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "rbd")
	private Integer rbd;
	@Column(name = "direccion")
	private String direccion;
	@Column(name = "telefono")
	private String telefono;
	@Column(name = "descripcion")
	private String descripcion;
	@Column(name = "correo")
	private String correo;
	public Colegio(Integer id, String nombre, Integer rbd, String direccion, String telefono, String descripcion,
			String correo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.rbd = rbd;
		this.direccion = direccion;
		this.telefono = telefono;
		this.descripcion = descripcion;
		this.correo = correo;
	}
	public Colegio() {
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
	public Integer getRbd() {
		return rbd;
	}
	public void setRbd(Integer rbd) {
		this.rbd = rbd;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	@Override
	public String toString() {
		return "Colegio [id=" + id + ", nombre=" + nombre + ", rbd=" + rbd + ", direccion=" + direccion + ", telefono="
				+ telefono + ", descripcion=" + descripcion + ", correo=" + correo + "]";
	}
	
	
	
	
	
	
	

}
