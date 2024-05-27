package com.schoollife.web.Entities;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="periodo_bloqueo")
public class Periodo_bloqueo {

	@Id
	private Integer id_periodo;
	private Date fecha_inicio;
	private Date fecha_fin;
	public Periodo_bloqueo(Integer id_periodo, Date fecha_inicio, Date fecha_fin) {
		super();
		this.id_periodo = id_periodo;
		this.fecha_inicio = fecha_inicio;
		this.fecha_fin = fecha_fin;
	}
	public Periodo_bloqueo() {
		super();
	}
	public Integer getId_periodo() {
		return id_periodo;
	}
	public void setId_periodo(Integer id_periodo) {
		this.id_periodo = id_periodo;
	}
	public Date getFecha_inicio() {
		return fecha_inicio;
	}
	public void setFecha_inicio(Date fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}
	public Date getFecha_fin() {
		return fecha_fin;
	}
	public void setFecha_fin(Date fecha_fin) {
		this.fecha_fin = fecha_fin;
	}
	@Override
	public String toString() {
		return "Periodo_bloqueo [id_periodo=" + id_periodo + ", fecha_inicio=" + fecha_inicio + ", fecha_fin="
				+ fecha_fin + "]";
	}
	
	
	
}
