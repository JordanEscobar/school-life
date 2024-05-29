package com.schoollife.web.Entities;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="usuarios")
public class Usuario {
	
	@Id
	private String rut_usuario;
	private String pass;
	private String nombre;
	private String apaterno;
	private String amaterno;
	private String correo;
	private String telefono;
	@DateTimeFormat(iso=ISO.DATE)
	private Date fecha_nacimiento;
	private String genero;
	private String estudios;
	private String cargo;
	private Integer rol_id;
	private Integer establecimiento_id;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
	    name = "usuario_roles",
	    joinColumns = @JoinColumn(name = "usuario_id"),
	    inverseJoinColumns = @JoinColumn(name = "role_id")
	)
	private List<Rol> roles;
	public Usuario(String rut_usuario, String pass, String nombre, String apaterno, String amaterno, String correo,
			String telefono, Date fecha_nacimiento, String genero, String estudios, String cargo, Integer rol_id,
			Integer establecimiento_id) {
		super();
		this.rut_usuario = rut_usuario;
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
		this.rol_id = rol_id;
		this.establecimiento_id = establecimiento_id;
	}
	public Usuario() {
		super();
	}
	public String getRut_usuario() {
		return rut_usuario;
	}
	public void setRut_usuario(String rut_usuario) {
		this.rut_usuario = rut_usuario;
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
	public Integer getRol_id() {
		return rol_id;
	}
	public void setRol_id(Integer rol_id) {
		this.rol_id = rol_id;
	}
	public Integer getEstablecimiento_id() {
		return establecimiento_id;
	}
	public void setEstablecimiento_id(Integer establecimiento_id) {
		this.establecimiento_id = establecimiento_id;
	}
	public List<Rol> getRoles() {
		return roles;
	}
	public void setRoles(List<Rol> roles) {
		this.roles = roles;
	}
	@Override
	public String toString() {
		return "Usuario [rut_usuario=" + rut_usuario + ", pass=" + pass + ", nombre=" + nombre + ", apaterno="
				+ apaterno + ", amaterno=" + amaterno + ", correo=" + correo + ", telefono=" + telefono
				+ ", fecha_nacimiento=" + fecha_nacimiento + ", genero=" + genero + ", estudios=" + estudios
				+ ", cargo=" + cargo + ", rol_id=" + rol_id + ", establecimiento_id=" + establecimiento_id + ", roles="
				+ roles + "]";
	}
	
	
	
}
