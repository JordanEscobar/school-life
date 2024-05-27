package com.schoollife.web.Entities;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "hoja_de_vida")
public class Hoja_de_vida {
	@Id
	private Integer id_hoja_de_vida;
	private Date fecha;
	private String tipo_evento;
	private String asignatura;
	private String detalle;
	private String archivo;
	private String usuario_id;
	private String estudiante_id;
	public Hoja_de_vida(Integer id_hoja_de_vida, Date fecha, String tipo_evento, String asignatura, String detalle,
			String archivo, String usuario_id, String estudiante_id) {
		super();
		this.id_hoja_de_vida = id_hoja_de_vida;
		this.fecha = fecha;
		this.tipo_evento = tipo_evento;
		this.asignatura = asignatura;
		this.detalle = detalle;
		this.archivo = archivo;
		this.usuario_id = usuario_id;
		this.estudiante_id = estudiante_id;
	}
	public Hoja_de_vida() {
		super();
	}
	public Integer getId_hoja_de_vida() {
		return id_hoja_de_vida;
	}
	public void setId_hoja_de_vida(Integer id_hoja_de_vida) {
		this.id_hoja_de_vida = id_hoja_de_vida;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getTipo_evento() {
		return tipo_evento;
	}
	public void setTipo_evento(String tipo_evento) {
		this.tipo_evento = tipo_evento;
	}
	public String getAsignatura() {
		return asignatura;
	}
	public void setAsignatura(String asignatura) {
		this.asignatura = asignatura;
	}
	public String getDetalle() {
		return detalle;
	}
	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}
	public String getArchivo() {
		return archivo;
	}
	public void setArchivo(String archivo) {
		this.archivo = archivo;
	}
	public String getUsuario_id() {
		return usuario_id;
	}
	public void setUsuario_id(String usuario_id) {
		this.usuario_id = usuario_id;
	}
	public String getEstudiante_id() {
		return estudiante_id;
	}
	public void setEstudiante_id(String estudiante_id) {
		this.estudiante_id = estudiante_id;
	}
	@Override
	public String toString() {
		return "Hoja_de_vida [id_hoja_de_vida=" + id_hoja_de_vida + ", fecha=" + fecha + ", tipo_evento=" + tipo_evento
				+ ", asignatura=" + asignatura + ", detalle=" + detalle + ", archivo=" + archivo + ", usuario_id="
				+ usuario_id + ", estudiante_id=" + estudiante_id + "]";
	}
	
	
	
	

}
