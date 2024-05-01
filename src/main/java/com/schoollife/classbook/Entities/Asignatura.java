package com.schoollife.classbook.Entities;

import java.sql.Time;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "asignaturas")
public class Asignatura {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nombre;
	private String estado;
	@JoinColumn(name = "profesor_id", nullable = false)
	private Integer profesor_id;
	private String dia;
	private Time hora_inicio;
	private Time hora_final;
	public Asignatura(Integer id, String nombre, String estado, Integer profesor_id, String dia, Time hora_inicio,
			Time hora_final) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.estado = estado;
		this.profesor_id = profesor_id;
		this.dia = dia;
		this.hora_inicio = hora_inicio;
		this.hora_final = hora_final;
	}
	public Asignatura() {
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
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Integer getProfesor_id() {
		return profesor_id;
	}
	public void setProfesor_id(Integer profesor_id) {
		this.profesor_id = profesor_id;
	}
	public String getDia() {
		return dia;
	}
	public void setDia(String dia) {
		this.dia = dia;
	}
	public Time getHora_inicio() {
		return hora_inicio;
	}
	public void setHora_inicio(Time hora_inicio) {
		this.hora_inicio = hora_inicio;
	}
	public Time getHora_final() {
		return hora_final;
	}
	public void setHora_final(Time hora_final) {
		this.hora_final = hora_final;
	}
	@Override
	public String toString() {
		return "Asignatura [id=" + id + ", nombre=" + nombre + ", estado=" + estado + ", profesor_id=" + profesor_id
				+ ", dia=" + dia + ", hora_inicio=" + hora_inicio + ", hora_final=" + hora_final + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
