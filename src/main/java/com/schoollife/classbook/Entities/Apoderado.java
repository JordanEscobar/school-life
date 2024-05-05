package com.schoollife.classbook.Entities;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "apoderados")
public class Apoderado {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_apoderado;
	@NotNull
	@NotEmpty
	@Column(name = "nombre_apoderado")
	private String nombre_apoderado;
	@NotNull
	@NotEmpty
	@Column(name = "apaterno_apoderado")
	private String apaterno_apoderado;
	@NotNull
	@NotEmpty
	@Column(name = "amaterno_apoderado")
	private String amaterno_apoderado;
	@NotNull
	@NotEmpty
	@Length(min = 6, max = 11)
	@Pattern(regexp = "^[0-9]+-[0-9kK]{1}$", message = "El Rut debe ser sin puntos y con guión")
	@Column(name = "rut_apoderado")
	private String rut_apoderado;
	@NotNull
	@NotEmpty
	@Length(min = 6, max = 250)
	@Column(name = "direccion_apoderado")
	private String direccion_apoderado;
	@NotBlank
	@NotNull
	@NotEmpty
	@Length(min = 5, max = 15)
	@Column(name = "telefono_apoderado")
	private String telefono_apoderado;
	@Column(name = "estado_apoderado")
	private String estado_apoderado;
	@JoinColumn(name = "estudiante_id", nullable = false)
	private Integer estudiante_id;
	public Apoderado(Integer id_apoderado, @NotBlank @NotNull @NotEmpty String nombre_apoderado,
			@NotBlank @NotNull @NotEmpty String apaterno_apoderado,
			@NotBlank @NotNull @NotEmpty String amaterno_apoderado,
			@NotBlank @NotNull @NotEmpty @Length(min = 6, max = 11) @Pattern(regexp = "^[0-9]+-[0-9kK]{1}$", message = "El Rut debe ser sin puntos y con guión") String rut_apoderado,
			@NotBlank @NotNull @NotEmpty @Length(min = 6, max = 250) String direccion_apoderado,
			@NotBlank @NotNull @NotEmpty @Length(min = 5, max = 15) String telefono_apoderado,
			@NotBlank @NotNull @NotEmpty String estado_apoderado, Integer estudiante_id) {
		super();
		this.id_apoderado = id_apoderado;
		this.nombre_apoderado = nombre_apoderado;
		this.apaterno_apoderado = apaterno_apoderado;
		this.amaterno_apoderado = amaterno_apoderado;
		this.rut_apoderado = rut_apoderado;
		this.direccion_apoderado = direccion_apoderado;
		this.telefono_apoderado = telefono_apoderado;
		this.estado_apoderado = estado_apoderado;
		this.estudiante_id = estudiante_id;
	}
	public Apoderado() {
		super();
	}
	public Integer getId_apoderado() {
		return id_apoderado;
	}
	public void setId_apoderado(Integer id_apoderado) {
		this.id_apoderado = id_apoderado;
	}
	public String getNombre_apoderado() {
		return nombre_apoderado;
	}
	public void setNombre_apoderado(String nombre_apoderado) {
		this.nombre_apoderado = nombre_apoderado;
	}
	public String getApaterno_apoderado() {
		return apaterno_apoderado;
	}
	public void setApaterno_apoderado(String apaterno_apoderado) {
		this.apaterno_apoderado = apaterno_apoderado;
	}
	public String getAmaterno_apoderado() {
		return amaterno_apoderado;
	}
	public void setAmaterno_apoderado(String amaterno_apoderado) {
		this.amaterno_apoderado = amaterno_apoderado;
	}
	public String getRut_apoderado() {
		return rut_apoderado;
	}
	public void setRut_apoderado(String rut_apoderado) {
		this.rut_apoderado = rut_apoderado;
	}
	public String getDireccion_apoderado() {
		return direccion_apoderado;
	}
	public void setDireccion_apoderado(String direccion_apoderado) {
		this.direccion_apoderado = direccion_apoderado;
	}
	public String getTelefono_apoderado() {
		return telefono_apoderado;
	}
	public void setTelefono_apoderado(String telefono_apoderado) {
		this.telefono_apoderado = telefono_apoderado;
	}
	public String getEstado_apoderado() {
		return estado_apoderado;
	}
	public void setEstado_apoderado(String estado_apoderado) {
		this.estado_apoderado = estado_apoderado;
	}
	public Integer getEstudiante_id() {
		return estudiante_id;
	}
	public void setEstudiante_id(Integer estudiante_id) {
		this.estudiante_id = estudiante_id;
	}
	@Override
	public String toString() {
		return "Apoderado [id_apoderado=" + id_apoderado + ", nombre_apoderado=" + nombre_apoderado
				+ ", apaterno_apoderado=" + apaterno_apoderado + ", amaterno_apoderado=" + amaterno_apoderado
				+ ", rut_apoderado=" + rut_apoderado + ", direccion_apoderado=" + direccion_apoderado
				+ ", telefono_apoderado=" + telefono_apoderado + ", estado_apoderado=" + estado_apoderado
				+ ", estudiante_id=" + estudiante_id + "]";
	}
	
	
	
	
	

}
