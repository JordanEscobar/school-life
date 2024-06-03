package com.schoollife.web.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "asignaturas")
public class Asignatura {
	@Id
	private Integer id_asignatura;
	private String nombre;
	@Column(name = "tiene_profesor_titular")
	private boolean tieneProfesorTitular;
	@Column(name = "profesor_id")
	private String profesorId;
	@Column(name = "curso_id")
	private Integer cursoId;
	public Asignatura(Integer id_asignatura, String nombre, boolean tieneProfesorTitular, String profesorId,
			Integer cursoId) {
		super();
		this.id_asignatura = id_asignatura;
		this.nombre = nombre;
		this.tieneProfesorTitular = tieneProfesorTitular;
		this.profesorId = profesorId;
		this.cursoId = cursoId;
	}
	public Asignatura() {
		super();
	}
	public Integer getId_asignatura() {
		return id_asignatura;
	}
	public void setId_asignatura(Integer id_asignatura) {
		this.id_asignatura = id_asignatura;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public boolean isTieneProfesorTitular() {
		return tieneProfesorTitular;
	}
	public void setTieneProfesorTitular(boolean tieneProfesorTitular) {
		this.tieneProfesorTitular = tieneProfesorTitular;
	}
	public String getProfesorId() {
		return profesorId;
	}
	public void setProfesorId(String profesorId) {
		this.profesorId = profesorId;
	}
	public Integer getCursoId() {
		return cursoId;
	}
	public void setCursoId(Integer cursoId) {
		this.cursoId = cursoId;
	}
	@Override
	public String toString() {
		return "Asignatura [id_asignatura=" + id_asignatura + ", nombre=" + nombre + ", tieneProfesorTitular="
				+ tieneProfesorTitular + ", profesorId=" + profesorId + ", cursoId=" + cursoId + "]";
	}
	
	
	
	
	
	

}
