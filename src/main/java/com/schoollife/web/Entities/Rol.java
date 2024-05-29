package com.schoollife.web.Entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "roles")
public class Rol {
	@Id
	private Integer id_rol;
	private String nombre;
	private String descripcion;
	
    @ManyToMany(mappedBy = "roles")
    private List<Usuario> usuarios;

	public Rol(Integer id_rol, String nombre, String descripcion, List<Usuario> usuarios) {
		super();
		this.id_rol = id_rol;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.usuarios = usuarios;
	}

	public Rol() {
		super();
	}

	public Integer getId_rol() {
		return id_rol;
	}

	public void setId_rol(Integer id_rol) {
		this.id_rol = id_rol;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	@Override
	public String toString() {
		return "Rol [id_rol=" + id_rol + ", nombre=" + nombre + ", descripcion=" + descripcion + "]";
	}
    
    
	

}
