package com.schoollife.classbook.Entities;

import java.sql.Time;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "asignaturas")
public class Asignatura {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "hora_inicio")
	private Time hora_inicio;
	@Column(name = "hora_termino")
	private Time hora_termino;
	@Column(name = "profesor_encargado")
	private Integer profesor_encargado;
	public Asignatura(Integer id, String nombre, Time hora_inicio, Time hora_termino, Integer profesor_encargado) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.hora_inicio = hora_inicio;
		this.hora_termino = hora_termino;
		this.profesor_encargado = profesor_encargado;
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
	public Time getHora_inicio() {
		return hora_inicio;
	}
	public void setHora_inicio(Time hora_inicio) {
		this.hora_inicio = hora_inicio;
	}
	public Time getHora_termino() {
		return hora_termino;
	}
	public void setHora_termino(Time hora_termino) {
		this.hora_termino = hora_termino;
	}
	public Integer getProfesor_encargado() {
		return profesor_encargado;
	}
	public void setProfesor_encargado(Integer profesor_encargado) {
		this.profesor_encargado = profesor_encargado;
	}
	@Override
	public String toString() {
		return "Asignatura [id=" + id + ", nombre=" + nombre + ", hora_inicio=" + hora_inicio + ", hora_termino="
				+ hora_termino + ", profesor_encargado=" + profesor_encargado + "]";
	}
	
	
	
	
	
	
	

}
