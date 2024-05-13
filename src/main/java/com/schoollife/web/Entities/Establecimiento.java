package com.schoollife.web.Entities;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name ="establecimientos")
public class Establecimiento {
	
	@Id
	private Integer rbd;
	private String nombre;
	private String direccion;
	private String region;
	private String comuna;
	@DateTimeFormat(iso=ISO.DATE)
	private Date fecha_aniversario;
	private String correo_electronico;
	private String pagina_web;
	private String numero_telefonico;
	private String zona_horaria;
	public Establecimiento(Integer rbd, String nombre, String direccion, String region, String comuna,
			Date fecha_aniversario, String correo_electronico, String pagina_web, String numero_telefonico,
			String zona_horaria) {
		super();
		this.rbd = rbd;
		this.nombre = nombre;
		this.direccion = direccion;
		this.region = region;
		this.comuna = comuna;
		this.fecha_aniversario = fecha_aniversario;
		this.correo_electronico = correo_electronico;
		this.pagina_web = pagina_web;
		this.numero_telefonico = numero_telefonico;
		this.zona_horaria = zona_horaria;
	}
	public Establecimiento() {
		super();
	}
	public Integer getRbd() {
		return rbd;
	}
	public void setRbd(Integer rbd) {
		this.rbd = rbd;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getComuna() {
		return comuna;
	}
	public void setComuna(String comuna) {
		this.comuna = comuna;
	}
	public Date getFecha_aniversario() {
		return fecha_aniversario;
	}
	public void setFecha_aniversario(Date fecha_aniversario) {
		this.fecha_aniversario = fecha_aniversario;
	}
	public String getCorreo_electronico() {
		return correo_electronico;
	}
	public void setCorreo_electronico(String correo_electronico) {
		this.correo_electronico = correo_electronico;
	}
	public String getPagina_web() {
		return pagina_web;
	}
	public void setPagina_web(String pagina_web) {
		this.pagina_web = pagina_web;
	}
	public String getNumero_telefonico() {
		return numero_telefonico;
	}
	public void setNumero_telefonico(String numero_telefonico) {
		this.numero_telefonico = numero_telefonico;
	}
	public String getZona_horaria() {
		return zona_horaria;
	}
	public void setZona_horaria(String zona_horaria) {
		this.zona_horaria = zona_horaria;
	}
	@Override
	public String toString() {
		return "Establecimiento [rbd=" + rbd + ", nombre=" + nombre + ", direccion=" + direccion + ", region=" + region
				+ ", comuna=" + comuna + ", fecha_aniversario=" + fecha_aniversario + ", correo_electronico="
				+ correo_electronico + ", pagina_web=" + pagina_web + ", numero_telefonico=" + numero_telefonico
				+ ", zona_horaria=" + zona_horaria + "]";
	}
	
	

}
