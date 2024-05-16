package com.schoollife.web.Entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name ="programa_integracion")
public class Programa_Integracion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_Programa;
	private String estudiante_id;
	@NotNull
	private boolean permanencia_pie;
	private String tipo_permanencia;
	private String indicaciones_generales;
	public Programa_Integracion(Integer id_Programa, String estudiante_id, boolean permanencia_pie,
			String tipo_permanencia, String indicaciones_generales) {
		super();
		this.id_Programa = id_Programa;
		this.estudiante_id = estudiante_id;
		this.permanencia_pie = permanencia_pie;
		this.tipo_permanencia = tipo_permanencia;
		this.indicaciones_generales = indicaciones_generales;
	}
	public Programa_Integracion() {
		super();
	}
	public Integer getId_Programa() {
		return id_Programa;
	}
	public void setId_Programa(Integer id_Programa) {
		this.id_Programa = id_Programa;
	}
	public String getEstudiante_id() {
		return estudiante_id;
	}
	public void setEstudiante_id(String estudiante_id) {
		this.estudiante_id = estudiante_id;
	}
	public boolean isPermanencia_pie() {
		return permanencia_pie;
	}
	public void setPermanencia_pie(boolean permanencia_pie) {
		this.permanencia_pie = permanencia_pie;
	}
	public String getTipo_permanencia() {
		return tipo_permanencia;
	}
	public void setTipo_permanencia(String tipo_permanencia) {
		this.tipo_permanencia = tipo_permanencia;
	}
	public String getIndicaciones_generales() {
		return indicaciones_generales;
	}
	public void setIndicaciones_generales(String indicaciones_generales) {
		this.indicaciones_generales = indicaciones_generales;
	}
	@Override
	public String toString() {
		return "Programa_Integracion [id_Programa=" + id_Programa + ", estudiante_id=" + estudiante_id
				+ ", permanencia_pie=" + permanencia_pie + ", tipo_permanencia=" + tipo_permanencia
				+ ", indicaciones_generales=" + indicaciones_generales + "]";
	}
	
	
	
	

}
