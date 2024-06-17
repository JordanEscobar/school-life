package com.schoollife.web.Entities;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

@Entity
@Table(name="usuarios")
public class Usuario {
	
	@Id
	@NotBlank
	@Column(name = "rut_usuario")
	private String rutUsuario;
	@NotBlank
	private String pass;
	@NotBlank
	private String nombre;
	@NotBlank
	private String apaterno;
	@NotBlank
	private String amaterno;
	@NotBlank
	@Email
	private String correo;
	@NotBlank
	private String telefono;
	@NotNull
	@Past
	@DateTimeFormat(iso=ISO.DATE)
	private Date fecha_nacimiento;
	@NotNull
	private String genero;
	@NotNull
	private String estudios;
	@NotNull
	private String cargo;
	@NotNull
	@Column(name = "establecimiento_id")
	private Integer establecimientoId;
	@JoinColumn(name = "rol_id")
	private Integer rolId;
	public Usuario(@NotBlank String rutUsuario, @NotBlank String pass, @NotBlank String nombre,
			@NotBlank String apaterno, String amaterno, @NotBlank String correo, @NotBlank String telefono,
			@NotNull @Past Date fecha_nacimiento, @NotNull String genero, @NotNull String estudios,
			@NotNull String cargo, @NotNull Integer establecimientoId, Integer rolId) {
		super();
		this.rutUsuario = rutUsuario;
		this.pass = pass;
		this.nombre = nombre;
		this.apaterno = apaterno;
		this.amaterno = amaterno;
		this.correo = correo;
		this.telefono = telefono;
		this.fecha_nacimiento = fecha_nacimiento;
		this.genero = genero;
		this.estudios = estudios;
		this.cargo = cargo;
		this.establecimientoId = establecimientoId;
		this.rolId = rolId;
	}
	public Usuario() {
		super();
	}
	public String getRutUsuario() {
		return rutUsuario;
	}
	public void setRutUsuario(String rutUsuario) {
		this.rutUsuario = rutUsuario;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
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
	public Date getFecha_nacimiento() {
		return fecha_nacimiento;
	}
	public void setFecha_nacimiento(Date fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getEstudios() {
		return estudios;
	}
	public void setEstudios(String estudios) {
		this.estudios = estudios;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public Integer getEstablecimientoId() {
		return establecimientoId;
	}
	public void setEstablecimientoId(Integer establecimientoId) {
		this.establecimientoId = establecimientoId;
	}
	public Integer getRolId() {
		return rolId;
	}
	public void setRolId(Integer rolId) {
		this.rolId = rolId;
	}
	@Override
	public String toString() {
		return "Usuario [rutUsuario=" + rutUsuario + ", pass=" + pass + ", nombre=" + nombre + ", apaterno=" + apaterno
				+ ", amaterno=" + amaterno + ", correo=" + correo + ", telefono=" + telefono + ", fecha_nacimiento="
				+ fecha_nacimiento + ", genero=" + genero + ", estudios=" + estudios + ", cargo=" + cargo
				+ ", establecimientoId=" + establecimientoId + ", rolId=" + rolId + "]";
	}
	
	
	
	
}
