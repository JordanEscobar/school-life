package com.schoollife.classbook.Entities;

import java.util.Date;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import jakarta.persistence.Column;
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
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "estudiantes")
public class Estudiante {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotEmpty
	@NotNull
	@Length(min = 6, max = 11)
	@Pattern(regexp = "^[0-9]+-[0-9kK]{1}$", message = "El Rut debe ser sin puntos y con guión")
	@Column(name = "rut")
	private String rut;
	@NotEmpty
	@NotNull
	@Column(name = "nombre")
	private String nombre;
	@NotEmpty
	@NotNull
	@Column(name = "apaterno")
	private String apaterno;
	@NotEmpty
	@NotNull
	@Column(name = "amaterno")
	private String amaterno;
	@NotNull
	@Past
	@DateTimeFormat(iso=ISO.DATE)
	private Date fecha_nacimiento;
	@NotEmpty
	@NotNull
	@NotBlank
	@Length(min = 3, max = 255)
	@Column(name = "direccion")
	private String direccion;
	@NotEmpty
	@NotNull
	@Length(min = 5, max = 15)
	@Column(name = "telefono")
	private String telefono;
	@NotEmpty
	@NotNull
	@Email
	@Column(name = "correo")
	private String correo;
	@NotEmpty
	@NotNull
	@Column(name = "contrasena")
	private String contrasena;
	@NotEmpty
	@NotNull
	@Column(name = "sep")
	private String sep;
	@NotEmpty
	@NotNull
	@Column(name = "pie")
	private String pie;
	@Column(name = "estado")
	private String estado;
	@JoinColumn(name = "colegio_id", nullable = false)
	private Integer colegio_id;
	@JoinColumn(name = "curso_id", nullable = false)
	private Integer curso_id;
	public Estudiante(Integer id,
			@NotEmpty @NotNull @NotBlank @Length(min = 6, max = 11) @Pattern(regexp = "^[0-9]+-[0-9kK]{1}$", message = "El Rut debe ser sin puntos y con guión") String rut,
			@NotEmpty @NotNull @NotBlank String nombre, @NotEmpty @NotNull @NotBlank String apaterno,
			@NotEmpty @NotNull @NotBlank String amaterno, @NotNull @Past Date fecha_nacimiento,
			@NotEmpty @NotNull @NotBlank @Length(min = 3, max = 255) String direccion,
			@NotEmpty @NotNull @NotBlank @Length(min = 5, max = 15) String telefono,
			@NotEmpty @NotNull @NotBlank @Email String correo, @NotEmpty @NotNull @NotBlank String contrasena,
			@NotEmpty @NotNull @NotBlank String sep, @NotEmpty @NotNull @NotBlank String pie, String estado,
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
