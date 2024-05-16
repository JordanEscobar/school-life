package com.schoollife.web.Entities;

import java.util.Date;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name ="apoderados")
public class Apoderado {
	
	@Id
	@NotBlank
	@Length(min = 6, max = 11)
	@Pattern(regexp = "^[0-9]+-[0-9kK]{1}$", message = "El Rut debe ser sin puntos y con guión")
	private String run_apoderado;
	private String estudiante_id;
	@Min(value = 6)
	private Integer numero_documento;
	@NotBlank
	private String nombres;
	@NotBlank
	@Column(name = "apaterno")
	private String apaterno_apoderado;
	@NotBlank
	@Column(name = "amaterno")
	private String amaterno_apoderado;
	@NotBlank
	private String pasaporte;
	private String parentesco;
	private String tipo_apoderado;
	private String estado_civil;
	@NotNull
	@Past
	@DateTimeFormat(iso=ISO.DATE)
	private Date fecha_nacimiento;
	@NotBlank
	private String domicilio;
	private String comuna;
	private String nivel_educacion;
	@NotBlank
	private String ocupacion;	
	@Length(min = 6, max = 9)
	private String telefono;
	@Length(min = 8, max = 9)
	private String celular;
	@NotBlank
	@Email
	private String correo_electronico;
	@NotNull
	private boolean es_tutor;
	@NotNull
	private boolean acepta_manual_convivencia_escolar;
	@NotNull
	private boolean autorizacion_fotografia_grabacion;
	@NotNull
	private boolean autorizado_retirar_establecimiento;
	public Apoderado(String run_apoderado, String estudiante_id, Integer numero_documento, String nombres,
			String apaterno_apoderado, String amaterno_apoderado, String pasaporte, String parentesco,
			String tipo_apoderado, String estado_civil, Date fecha_nacimiento, String domicilio, String comuna,
			String nivel_educacion, String ocupacion, String telefono, String celular, String correo_electronico,
			boolean es_tutor, boolean acepta_manual_convivencia_escolar, boolean autorizacion_fotografia_grabacion,
			boolean autorizado_retirar_establecimiento) {
		super();
		this.run_apoderado = run_apoderado;
		this.estudiante_id = estudiante_id;
		this.numero_documento = numero_documento;
		this.nombres = nombres;
		this.apaterno_apoderado = apaterno_apoderado;
		this.amaterno_apoderado = amaterno_apoderado;
		this.pasaporte = pasaporte;
		this.parentesco = parentesco;
		this.tipo_apoderado = tipo_apoderado;
		this.estado_civil = estado_civil;
		this.fecha_nacimiento = fecha_nacimiento;
		this.domicilio = domicilio;
		this.comuna = comuna;
		this.nivel_educacion = nivel_educacion;
		this.ocupacion = ocupacion;
		this.telefono = telefono;
		this.celular = celular;
		this.correo_electronico = correo_electronico;
		this.es_tutor = es_tutor;
		this.acepta_manual_convivencia_escolar = acepta_manual_convivencia_escolar;
		this.autorizacion_fotografia_grabacion = autorizacion_fotografia_grabacion;
		this.autorizado_retirar_establecimiento = autorizado_retirar_establecimiento;
	}
	public Apoderado() {
		super();
	}
	public String getRun_apoderado() {
		return run_apoderado;
	}
	public void setRun_apoderado(String run_apoderado) {
		this.run_apoderado = run_apoderado;
	}
	public String getEstudiante_id() {
		return estudiante_id;
	}
	public void setEstudiante_id(String estudiante_id) {
		this.estudiante_id = estudiante_id;
	}
	public Integer getNumero_documento() {
		return numero_documento;
	}
	public void setNumero_documento(Integer numero_documento) {
		this.numero_documento = numero_documento;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApaterno_apoderado() {
		return apaterno_apoderado;
	}
	public void setApaterno_apoderado(String apaterno_apoderado) {
		this.apaterno_apoderado = apaterno_apoderado;
	}
	public String getAmaterno_apoderado() {
		return amaterno_apoderado;
	}
	public void setAmaterno_apoderado(String amaterno_apoderado) {
		this.amaterno_apoderado = amaterno_apoderado;
	}
	public String getPasaporte() {
		return pasaporte;
	}
	public void setPasaporte(String pasaporte) {
		this.pasaporte = pasaporte;
	}
	public String getParentesco() {
		return parentesco;
	}
	public void setParentesco(String parentesco) {
		this.parentesco = parentesco;
	}
	public String getTipo_apoderado() {
		return tipo_apoderado;
	}
	public void setTipo_apoderado(String tipo_apoderado) {
		this.tipo_apoderado = tipo_apoderado;
	}
	public String getEstado_civil() {
		return estado_civil;
	}
	public void setEstado_civil(String estado_civil) {
		this.estado_civil = estado_civil;
	}
	public Date getFecha_nacimiento() {
		return fecha_nacimiento;
	}
	public void setFecha_nacimiento(Date fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}
	public String getDomicilio() {
		return domicilio;
	}
	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}
	public String getComuna() {
		return comuna;
	}
	public void setComuna(String comuna) {
		this.comuna = comuna;
	}
	public String getNivel_educacion() {
		return nivel_educacion;
	}
	public void setNivel_educacion(String nivel_educacion) {
		this.nivel_educacion = nivel_educacion;
	}
	public String getOcupacion() {
		return ocupacion;
	}
	public void setOcupacion(String ocupacion) {
		this.ocupacion = ocupacion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getCorreo_electronico() {
		return correo_electronico;
	}
	public void setCorreo_electronico(String correo_electronico) {
		this.correo_electronico = correo_electronico;
	}
	public boolean isEs_tutor() {
		return es_tutor;
	}
	public void setEs_tutor(boolean es_tutor) {
		this.es_tutor = es_tutor;
	}
	public boolean isAcepta_manual_convivencia_escolar() {
		return acepta_manual_convivencia_escolar;
	}
	public void setAcepta_manual_convivencia_escolar(boolean acepta_manual_convivencia_escolar) {
		this.acepta_manual_convivencia_escolar = acepta_manual_convivencia_escolar;
	}
	public boolean isAutorizacion_fotografia_grabacion() {
		return autorizacion_fotografia_grabacion;
	}
	public void setAutorizacion_fotografia_grabacion(boolean autorizacion_fotografia_grabacion) {
		this.autorizacion_fotografia_grabacion = autorizacion_fotografia_grabacion;
	}
	public boolean isAutorizado_retirar_establecimiento() {
		return autorizado_retirar_establecimiento;
	}
	public void setAutorizado_retirar_establecimiento(boolean autorizado_retirar_establecimiento) {
		this.autorizado_retirar_establecimiento = autorizado_retirar_establecimiento;
	}
	@Override
	public String toString() {
		return "Apoderado [run_apoderado=" + run_apoderado + ", estudiante_id=" + estudiante_id + ", numero_documento="
				+ numero_documento + ", nombres=" + nombres + ", apaterno_apoderado=" + apaterno_apoderado
				+ ", amaterno_apoderado=" + amaterno_apoderado + ", pasaporte=" + pasaporte + ", parentesco="
				+ parentesco + ", tipo_apoderado=" + tipo_apoderado + ", estado_civil=" + estado_civil
				+ ", fecha_nacimiento=" + fecha_nacimiento + ", domicilio=" + domicilio + ", comuna=" + comuna
				+ ", nivel_educacion=" + nivel_educacion + ", ocupacion=" + ocupacion + ", telefono=" + telefono
				+ ", celular=" + celular + ", correo_electronico=" + correo_electronico + ", es_tutor=" + es_tutor
				+ ", acepta_manual_convivencia_escolar=" + acepta_manual_convivencia_escolar
				+ ", autorizacion_fotografia_grabacion=" + autorizacion_fotografia_grabacion
				+ ", autorizado_retirar_establecimiento=" + autorizado_retirar_establecimiento + "]";
	}
	
	
	

}
