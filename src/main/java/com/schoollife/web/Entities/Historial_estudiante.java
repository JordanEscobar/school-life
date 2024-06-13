package com.schoollife.web.Entities;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "historial_estudiante")
public class Historial_estudiante {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_historial")
	private Integer idHistorial;
	private String nombre;
	private String apaterno;
	private String amaterno;
	private Integer numero_matricula;
	private String curso;
	private String establecimiento;
	private String es_pie;
	@DateTimeFormat(iso=ISO.DATE)
	private Date fecha_matricula;
	@DateTimeFormat(iso=ISO.DATE)
	private Date fecha_nacimiento;
	private String hoja_de_vida;
	@Column(name = "id_estudiante")
	private String idEstudiante;
	public Historial_estudiante(Integer idHistorial, String nombre, String apaterno, String amaterno,
			Integer numero_matricula, String curso, String establecimiento, String es_pie, Date fecha_matricula,
			Date fecha_nacimiento, String hoja_de_vida, String idEstudiante) {
		super();
		this.idHistorial = idHistorial;
		this.nombre = nombre;
		this.apaterno = apaterno;
		this.amaterno = amaterno;
		this.numero_matricula = numero_matricula;
		this.curso = curso;
		this.establecimiento = establecimiento;
		this.es_pie = es_pie;
		this.fecha_matricula = fecha_matricula;
		this.fecha_nacimiento = fecha_nacimiento;
		this.hoja_de_vida = hoja_de_vida;
		this.idEstudiante = idEstudiante;
	}
	public Historial_estudiante() {
		super();
	}
	public Integer getIdHistorial() {
		return idHistorial;
	}
	public void setIdHistorial(Integer idHistorial) {
		this.idHistorial = idHistorial;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApaterno() {
		return apaterno;
	}
	public void setApaterno(String apaterno) {
		this.apaterno = apaterno;
	}
	public String getAmaterno() {
		return amaterno;
	}
	public void setAmaterno(String amaterno) {
		this.amaterno = amaterno;
	}
	public Integer getNumero_matricula() {
		return numero_matricula;
	}
	public void setNumero_matricula(Integer numero_matricula) {
		this.numero_matricula = numero_matricula;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public String getEstablecimiento() {
		return establecimiento;
	}
	public void setEstablecimiento(String establecimiento) {
		this.establecimiento = establecimiento;
	}
	public String getEs_pie() {
		return es_pie;
	}
	public void setEs_pie(String es_pie) {
		this.es_pie = es_pie;
	}
	public Date getFecha_matricula() {
		return fecha_matricula;
	}
	public void setFecha_matricula(Date fecha_matricula) {
		this.fecha_matricula = fecha_matricula;
	}
	public Date getFecha_nacimiento() {
		return fecha_nacimiento;
	}
	public void setFecha_nacimiento(Date fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}
	public String getHoja_de_vida() {
		return hoja_de_vida;
	}
	public void setHoja_de_vida(String hoja_de_vida) {
		this.hoja_de_vida = hoja_de_vida;
	}
	public String getIdEstudiante() {
		return idEstudiante;
	}
	public void setIdEstudiante(String idEstudiante) {
		this.idEstudiante = idEstudiante;
	}
	@Override
	public String toString() {
		return "Historial_estudiante [idHistorial=" + idHistorial + ", nombre=" + nombre + ", apaterno=" + apaterno
				+ ", amaterno=" + amaterno + ", numero_matricula=" + numero_matricula + ", curso=" + curso
				+ ", establecimiento=" + establecimiento + ", es_pie=" + es_pie + ", fecha_matricula=" + fecha_matricula
				+ ", fecha_nacimiento=" + fecha_nacimiento + ", hoja_de_vida=" + hoja_de_vida + ", idEstudiante="
				+ idEstudiante + "]";
	}
	
	
	

}
