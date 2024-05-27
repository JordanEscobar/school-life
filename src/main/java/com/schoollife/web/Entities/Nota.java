package com.schoollife.web.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "notas")
public class Nota {
	@Id
	private Integer id_nota;
	private String semestre;
	private double nota;
	private String escala_numerica;
	private String escala_conceptual;
	private double promedio;
	private String id_estudiante;
	private Integer id_asignatura;
	public Nota(Integer id_nota, String semestre, double nota, String escala_numerica, String escala_conceptual,
			double promedio, String id_estudiante, Integer id_asignatura) {
		super();
		this.id_nota = id_nota;
		this.semestre = semestre;
		this.nota = nota;
		this.escala_numerica = escala_numerica;
		this.escala_conceptual = escala_conceptual;
		this.promedio = promedio;
		this.id_estudiante = id_estudiante;
		this.id_asignatura = id_asignatura;
	}
	public Nota() {
		super();
	}
	public Integer getId_nota() {
		return id_nota;
	}
	public void setId_nota(Integer id_nota) {
		this.id_nota = id_nota;
	}
	public String getSemestre() {
		return semestre;
	}
	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}
	public double getNota() {
		return nota;
	}
	public void setNota(double nota) {
		this.nota = nota;
	}
	public String getEscala_numerica() {
		return escala_numerica;
	}
	public void setEscala_numerica(String escala_numerica) {
		this.escala_numerica = escala_numerica;
	}
	public String getEscala_conceptual() {
		return escala_conceptual;
	}
	public void setEscala_conceptual(String escala_conceptual) {
		this.escala_conceptual = escala_conceptual;
	}
	public double getPromedio() {
		return promedio;
	}
	public void setPromedio(double promedio) {
		this.promedio = promedio;
	}
	public String getId_estudiante() {
		return id_estudiante;
	}
	public void setId_estudiante(String id_estudiante) {
		this.id_estudiante = id_estudiante;
	}
	public Integer getId_asignatura() {
		return id_asignatura;
	}
	public void setId_asignatura(Integer id_asignatura) {
		this.id_asignatura = id_asignatura;
	}
	@Override
	public String toString() {
		return "Nota [id_nota=" + id_nota + ", semestre=" + semestre + ", nota=" + nota + ", escala_numerica="
				+ escala_numerica + ", escala_conceptual=" + escala_conceptual + ", promedio=" + promedio
				+ ", id_estudiante=" + id_estudiante + ", id_asignatura=" + id_asignatura + "]";
	}
	
	

}
