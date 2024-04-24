package com.schoollife.classbook.Entities;

import java.util.Date;

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
	@Column(name = "rut")
	private String rut;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "apaterno")
	private String apaterno;
	@Column(name = "amaterno")
	private String amaterno;
	@Column(name = "fecha_nacimiento")
	private Date fecha_nacimiento;
	@Column(name = "telefono")
	private String telefono;
	@Column(name = "direccion")
	private String direccion;
	@Column(name = "correo")
	private String correo;
	@Column(name = "especialidad")
	private String especialidad;
	@Column(name = "estado")
	private String estado;
	private Integer edad;
	private Integer id_colegio;
	private Integer id_login;
	public Profesor(Integer id, String rut, String nombre, String apaterno, String amaterno, Date fecha_nacimiento,
			String telefono, String direccion, String correo, String especialidad, String estado, Integer edad,
			Integer id_colegio, Integer id_login) {
		super();
		this.id = id;
		this.rut = rut;
		this.nombre = nombre;
		this.apaterno = apaterno;
		this.amaterno = amaterno;
		this.fecha_nacimiento = fecha_nacimiento;
		this.telefono = telefono;
		this.direccion = direccion;
		this.correo = correo;
		this.especialidad = especialidad;
		this.estado = estado;
		this.edad = edad;
		this.id_colegio = id_colegio;
		this.id_login = id_login;
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
	public Date getFecha_nacimiento() {
		return fecha_nacimiento;
	}
	public void setFecha_nacimiento(Date fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
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
	public Integer getEdad() {
		return edad;
	}
	public void setEdad(Integer edad) {
		this.edad = edad;
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
		return "Profesor [id=" + id + ", rut=" + rut + ", nombre=" + nombre + ", apaterno=" + apaterno + ", amaterno="
				+ amaterno + ", fecha_nacimiento=" + fecha_nacimiento + ", telefono=" + telefono + ", direccion="
				+ direccion + ", correo=" + correo + ", especialidad=" + especialidad + ", estado=" + estado + ", edad="
				+ edad + ", id_colegio=" + id_colegio + ", id_login=" + id_login + "]";
	}
	
	
	
	
	
	
	
	
	

}
