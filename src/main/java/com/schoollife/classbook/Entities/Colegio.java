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
	@Column(name = "correo")
	private String correo;
	@Column(name = "telefono")
	private Integer telefono;
	@Column(name = "rbd")
	private Integer rbd;
	@Column(name = "direccion")
	private String direccion;
	@Column(name = "descripcion")
	private String descripcion;
	public Colegio(Integer id, String nombre, String correo, Integer telefono, Integer rbd, String direccion,
			String descripcion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.correo = correo;
		this.telefono = telefono;
		this.rbd = rbd;
		this.direccion = direccion;
		this.descripcion = descripcion;
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
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	@Override
	public String toString() {
		return "Colegio [id=" + id + ", nombre=" + nombre + ", correo=" + correo + ", telefono=" + telefono + ", rbd="
				+ rbd + ", direccion=" + direccion + ", descripcion=" + descripcion + "]";
	}
	
	
	
	
	

}
