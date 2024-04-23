package com.schoollife.classbook.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "registro_cursos")
public class Registro_curso {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "id_estudiante")
	private Integer id_estudiante;
	@Column(name = "id_curso")
	private Integer id_curso;
	@Column(name = "id_profesor_jefe")
	private Integer id_profesor_jefe;
	@Column(name = "descripcion")
	private String descripcion;
	public Registro_curso(Integer id, Integer id_estudiante, Integer id_curso, Integer id_profesor_jefe,
			String descripcion) {
		super();
		this.id = id;
		this.id_estudiante = id_estudiante;
		this.id_curso = id_curso;
		this.id_profesor_jefe = id_profesor_jefe;
		this.descripcion = descripcion;
	}
	public Registro_curso() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getId_estudiante() {
		return id_estudiante;
	}
	public void setId_estudiante(Integer id_estudiante) {
		this.id_estudiante = id_estudiante;
	}
	public Integer getId_curso() {
		return id_curso;
	}
	public void setId_curso(Integer id_curso) {
		this.id_curso = id_curso;
	}
	public Integer getId_profesor_jefe() {
		return id_profesor_jefe;
	}
	public void setId_profesor_jefe(Integer id_profesor_jefe) {
		this.id_profesor_jefe = id_profesor_jefe;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	@Override
	public String toString() {
		return "Registro_curso [id=" + id + ", id_estudiante=" + id_estudiante + ", id_curso=" + id_curso
				+ ", id_profesor_jefe=" + id_profesor_jefe + ", descripcion=" + descripcion + "]";
	}
	
	
	

}
