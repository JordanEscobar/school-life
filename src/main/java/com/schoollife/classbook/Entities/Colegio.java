package com.schoollife.classbook.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "colegios")
public class Colegio {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotBlank
	@NotNull
	@NotEmpty
	@Column(name = "nombre")
	private String nombre;
	@NotBlank
	@NotNull
	@NotEmpty
	@Column(name = "rbd")
	private Integer rbd;
	@NotBlank
	@NotNull
	@NotEmpty
	@Column(name = "direccion")
	private String direccion;
	@NotBlank
	@NotNull
	@NotEmpty
	@Column(name = "telefono")
	private String telefono;
	@NotBlank
	@NotNull
	@NotEmpty
	@Column(name = "correo")
	private String correo;
	@Column(name = "total_estudiantes")
	private Integer total_estudiantes;
	@NotBlank
	@NotNull
	@NotEmpty
	private String comuna;
	@NotBlank
	@NotNull
	@NotEmpty
	private String provincia;
	@NotBlank
	@NotNull
	@NotEmpty
	private String region;
	@NotBlank
	@NotNull
	@NotEmpty
	private String director;
	private float ive;
	public Colegio(Integer id, String nombre, Integer rbd, String direccion, String telefono, String correo,
			Integer total_estudiantes, String comuna, String provincia, String region, String director, float ive) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.rbd = rbd;
		this.direccion = direccion;
		this.telefono = telefono;
		this.correo = correo;
		this.total_estudiantes = total_estudiantes;
		this.comuna = comuna;
		this.provincia = provincia;
		this.region = region;
		this.director = director;
		this.ive = ive;
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
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public Integer getTotal_estudiantes() {
		return total_estudiantes;
	}
	public void setTotal_estudiantes(Integer total_estudiantes) {
		this.total_estudiantes = total_estudiantes;
	}
	public String getComuna() {
		return comuna;
	}
	public void setComuna(String comuna) {
		this.comuna = comuna;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public float getIve() {
		return ive;
	}
	public void setIve(float ive) {
		this.ive = ive;
	}
	@Override
	public String toString() {
		return "Colegio [id=" + id + ", nombre=" + nombre + ", rbd=" + rbd + ", direccion=" + direccion + ", telefono="
				+ telefono + ", correo=" + correo + ", total_estudiantes=" + total_estudiantes + ", comuna=" + comuna
				+ ", provincia=" + provincia + ", region=" + region + ", director=" + director + ", ive=" + ive + "]";
	}
	
	
	
	
	
	
	
	
	
	
	

}
