package com.schoollife.classbook.Entities;

import java.util.Date;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "administradores")
public class Administrador {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotBlank
	@NotNull
	@NotEmpty
	private String nombre;
	@NotBlank
	@NotNull
	@NotEmpty
	private String apaterno;
	private String amaterno;
	@NotBlank
	@NotNull
	@NotEmpty
	@Length(min = 6, max = 11)
	@Pattern(regexp = "^[0-9]+-[0-9kK]{1}$", message = "El Rut debe ser sin puntos y con guión")
	private String rut;
	@DateTimeFormat(iso=ISO.DATE)
	private Date fecha_nacimiento;
	@NotBlank
	@NotNull
	@NotEmpty
	@Length(min = 3, max = 255)
	private String direccion;
	@NotBlank
	@NotNull
	@NotEmpty
	@Length(min = 3, max = 255)
	@Email
	private String correo;
	@NotBlank
	@NotNull
	@NotEmpty
	@Length(min = 5, max = 15)
	private String telefono;
	@NotBlank
	@NotNull
	@NotEmpty
	private String cargo;
	@NotBlank
	@NotNull
	@NotEmpty
	private String contrasena;
	@NotBlank
	@NotNull
	@NotEmpty
	private String estado;
	@JoinColumn(name = "colegio_id", nullable = false)
	private Integer colegio_id;
	public Administrador(Integer id, String nombre, String apaterno, String amaterno, String rut, Date fecha_nacimiento,
			String direccion, String correo, String telefono, String cargo, String contrasena, String estado,
			Integer colegio_id) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apaterno = apaterno;
		this.amaterno = amaterno;
		this.rut = rut;
		this.fecha_nacimiento = fecha_nacimiento;
		this.direccion = direccion;
		this.correo = correo;
		this.telefono = telefono;
		this.cargo = cargo;
		this.contrasena = contrasena;
		this.estado = estado;
		this.colegio_id = colegio_id;
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
	public String getRut() {
		return rut;
	}
	public void setRut(String rut) {
		this.rut = rut;
	}
	public Date getFecha_nacimiento() {
		return fecha_nacimiento;
	}
	public void setFecha_nacimiento(Date fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
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
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
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
		return "Administrador [id=" + id + ", nombre=" + nombre + ", apaterno=" + apaterno + ", amaterno=" + amaterno
				+ ", rut=" + rut + ", fecha_nacimiento=" + fecha_nacimiento + ", direccion=" + direccion + ", correo="
				+ correo + ", telefono=" + telefono + ", cargo=" + cargo + ", contrasena=" + contrasena + ", estado="
				+ estado + ", colegio_id=" + colegio_id + "]";
	}
	
	
	
	

	
	

}
