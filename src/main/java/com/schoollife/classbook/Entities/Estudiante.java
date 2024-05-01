package com.schoollife.classbook.Entities;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
	@DateTimeFormat(iso=ISO.DATE)
	private String fecha_nacimiento;
	@Column(name = "direccion")
	private String direccion;
	@Column(name = "telefono")
	private String telefono;
	@Column(name = "correo")
	private String correo;
	@Column(name = "contrasena")
	private String contrasena;
	@Column(name = "sep")
	private String sep;
	@Column(name = "pie")
	private String pie;
	@Column(name = "estado")
	private String estado;
	@JoinColumn(name = "colegio_id", nullable = false)
	private Integer colegio_id;
	@JoinColumn(name = "curso_id", nullable = false)
	private Integer curso_id;
	public Estudiante(Integer id, String rut, String nombre, String apaterno, String amaterno, String fecha_nacimiento,
			String direccion, String telefono, String correo, String contrasena, String sep, String pie, String estado,
			Integer colegio_id, Integer curso_id) {
		super();
		this.id = id;
		this.rut = rut;
		this.nombre = nombre;
		this.apaterno = apaterno;
		this.amaterno = amaterno;
		this.fecha_nacimiento = fecha_nacimiento;
		this.direccion = direccion;
		this.telefono = telefono;
		this.correo = correo;
		this.contrasena = contrasena;
		this.sep = sep;
		this.pie = pie;
		this.estado = estado;
		this.colegio_id = colegio_id;
		this.curso_id = curso_id;
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
	public String getFecha_nacimiento() {
		return fecha_nacimiento;
	}
	public void setFecha_nacimiento(String fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
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
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	public String getSep() {
		return sep;
	}
	public void setSep(String sep) {
		this.sep = sep;
	}
	public String getPie() {
		return pie;
	}
	public void setPie(String pie) {
		this.pie = pie;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Integer getColegio_id() {
		return colegio_id;
	}
	public void setColegio_id(Integer colegio_id) {
		this.colegio_id = colegio_id;
	}
	public Integer getCurso_id() {
		return curso_id;
	}
	public void setCurso_id(Integer curso_id) {
		this.curso_id = curso_id;
	}
	@Override
	public String toString() {
		return "Estudiante [id=" + id + ", rut=" + rut + ", nombre=" + nombre + ", apaterno=" + apaterno + ", amaterno="
				+ amaterno + ", fecha_nacimiento=" + fecha_nacimiento + ", direccion=" + direccion + ", telefono="
				+ telefono + ", correo=" + correo + ", contrasena=" + contrasena + ", sep=" + sep + ", pie=" + pie
				+ ", estado=" + estado + ", colegio_id=" + colegio_id + ", curso_id=" + curso_id + "]";
	}
	
	
	
	
	
	
	
	
	
	

}
