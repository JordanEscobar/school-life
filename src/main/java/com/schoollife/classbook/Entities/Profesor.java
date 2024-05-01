package com.schoollife.classbook.Entities;

import java.util.Date;

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
	@DateTimeFormat(iso=ISO.DATE)
	private Date fecha_nacimiento;
	@Column(name = "telefono")
	private String telefono;
	@Column(name = "direccion")
	private String direccion;
	@Column(name = "correo")
	private String correo;
	@Column(name = "contrasena")
	private String contrasena;
	@Column(name = "estado")
	private String estado;
	@JoinColumn(name = "colegio_id", nullable = false)
	private Integer colegio_id;
	public Profesor(Integer id, String rut, String nombre, String apaterno, String amaterno, Date fecha_nacimiento,
			String telefono, String direccion, String correo, String contrasena, String estado, Integer colegio_id) {
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
		this.contrasena = contrasena;
		this.estado = estado;
		this.colegio_id = colegio_id;
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
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
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
	@Override
	public String toString() {
		return "Profesor [id=" + id + ", rut=" + rut + ", nombre=" + nombre + ", apaterno=" + apaterno + ", amaterno="
				+ amaterno + ", fecha_nacimiento=" + fecha_nacimiento + ", telefono=" + telefono + ", direccion="
				+ direccion + ", correo=" + correo + ", contrasena=" + contrasena + ", estado=" + estado
				+ ", colegio_id=" + colegio_id + "]";
	}
	
	

	
	
	
	
	
	
	

}
