package com.schoollife.web.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name ="cursos")
public class Curso {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_curso")
	private Integer idCurso;
	private String nivel_ensenanza;
	private String nivel;
	private String letra;
	private String jornada;
	@NotNull
	@Min(value = 10)
	private Integer capacidad;
	@NotBlank
	private String local;
	private String numero_sala;
	private String apodo;
	private Integer establecimiento_id;
	public Curso(Integer idCurso, String nivel_ensenanza, String nivel, String letra, String jornada,
			@NotNull @Min(10) Integer capacidad, @NotBlank String local, String numero_sala, String apodo,
			Integer establecimiento_id) {
		super();
		this.idCurso = idCurso;
		this.nivel_ensenanza = nivel_ensenanza;
		this.nivel = nivel;
		this.letra = letra;
		this.jornada = jornada;
		this.capacidad = capacidad;
		this.local = local;
		this.numero_sala = numero_sala;
		this.apodo = apodo;
		this.establecimiento_id = establecimiento_id;
	}
	public Curso() {
		super();
	}
	public Integer getIdCurso() {
		return idCurso;
	}
	public void setIdCurso(Integer idCurso) {
		this.idCurso = idCurso;
	}
	public String getNivel_ensenanza() {
		return nivel_ensenanza;
	}
	public void setNivel_ensenanza(String nivel_ensenanza) {
		this.nivel_ensenanza = nivel_ensenanza;
	}
	public String getNivel() {
		return nivel;
	}
	public void setNivel(String nivel) {
		this.nivel = nivel;
	}
	public String getLetra() {
		return letra;
	}
	public void setLetra(String letra) {
		this.letra = letra;
	}
	public String getJornada() {
		return jornada;
	}
	public void setJornada(String jornada) {
		this.jornada = jornada;
	}
	public Integer getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(Integer capacidad) {
		this.capacidad = capacidad;
	}
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	public String getNumero_sala() {
		return numero_sala;
	}
	public void setNumero_sala(String numero_sala) {
		this.numero_sala = numero_sala;
	}
	public String getApodo() {
		return apodo;
	}
	public void setApodo(String apodo) {
		this.apodo = apodo;
	}
	public Integer getEstablecimiento_id() {
		return establecimiento_id;
	}
	public void setEstablecimiento_id(Integer establecimiento_id) {
		this.establecimiento_id = establecimiento_id;
	}
	@Override
	public String toString() {
		return "Curso [idCurso=" + idCurso + ", nivel_ensenanza=" + nivel_ensenanza + ", nivel=" + nivel + ", letra="
				+ letra + ", jornada=" + jornada + ", capacidad=" + capacidad + ", local=" + local + ", numero_sala="
				+ numero_sala + ", apodo=" + apodo + ", establecimiento_id=" + establecimiento_id + "]";
	}
	
	
	
	

}
