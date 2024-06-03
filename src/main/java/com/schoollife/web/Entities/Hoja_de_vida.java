package com.schoollife.web.Entities;

import java.util.Date;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "hoja_de_vida")
public class Hoja_de_vida {
	@Id
	private Integer id_hoja_de_vida;
	@DateTimeFormat(iso=ISO.DATE)
	private Date fecha;
	@NotBlank
	@Column(name = "tipo_evento")
	private String tipoEvento;
	private String asignatura;
	@NotBlank
	@Length(min = 1,max = 250)
	private String detalle;
	private String archivo;
	@Column(name = "usuario_id")
	private String usuarioId;
	@Column(name = "estudiante_id")
	private String estudianteId;
	public Hoja_de_vida(Integer id_hoja_de_vida, Date fecha, String tipoEvento, String asignatura, String detalle,
			String archivo, String usuarioId, String estudianteId) {
		super();
		this.id_hoja_de_vida = id_hoja_de_vida;
		this.fecha = fecha;
		this.tipoEvento = tipoEvento;
		this.asignatura = asignatura;
		this.detalle = detalle;
		this.archivo = archivo;
		this.usuarioId = usuarioId;
		this.estudianteId = estudianteId;
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
	public String getTipoEvento() {
		return tipoEvento;
	}
	public void setTipoEvento(String tipoEvento) {
		this.tipoEvento = tipoEvento;
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
	public String getUsuarioId() {
		return usuarioId;
	}
	public void setUsuarioId(String usuarioId) {
		this.usuarioId = usuarioId;
	}
	public String getEstudianteId() {
		return estudianteId;
	}
	public void setEstudianteId(String estudianteId) {
		this.estudianteId = estudianteId;
	}
	@Override
	public String toString() {
		return "Hoja_de_vida [id_hoja_de_vida=" + id_hoja_de_vida + ", fecha=" + fecha + ", tipoEvento=" + tipoEvento
				+ ", asignatura=" + asignatura + ", detalle=" + detalle + ", archivo=" + archivo + ", usuarioId="
				+ usuarioId + ", estudianteId=" + estudianteId + "]";
	}
	
	
	

}
