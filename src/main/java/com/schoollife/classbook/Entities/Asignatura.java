package com.schoollife.classbook.Entities;

import java.util.Date;

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
	@Column(name = "hora_inicio")
	private Date  hora_inicio;//Se debe cambiar a un tipo compatible con datetime
	@Column(name = "hora_termino")
	private Date hora_termino;
	@Column(name = "tipo")
	private String tipo;
	@Column(name = "profesor")
	private Integer profesor;
	@Column(name = "curso")
	private Integer curso;
	public Asignatura(Integer id, Date hora_inicio, Date hora_termino, String tipo, Integer profesor, Integer curso) {
		super();
		this.id = id;
		this.hora_inicio = hora_inicio;
		this.hora_termino = hora_termino;
		this.tipo = tipo;
		this.profesor = profesor;
		this.curso = curso;
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
	public Date getHora_inicio() {
		return hora_inicio;
	}
	public void setHora_inicio(Date hora_inicio) {
		this.hora_inicio = hora_inicio;
	}
	public Date getHora_termino() {
		return hora_termino;
	}
	public void setHora_termino(Date hora_termino) {
		this.hora_termino = hora_termino;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Integer getProfesor() {
		return profesor;
	}
	public void setProfesor(Integer profesor) {
		this.profesor = profesor;
	}
	public Integer getCurso() {
		return curso;
	}
	public void setCurso(Integer curso) {
		this.curso = curso;
	}
	@Override
	public String toString() {
		return "Asignatura [id=" + id + ", hora_inicio=" + hora_inicio + ", hora_termino=" + hora_termino + ", tipo="
				+ tipo + ", profesor=" + profesor + ", curso=" + curso + "]";
	}
	
	

}
