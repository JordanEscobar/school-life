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
import jakarta.validation.constraints.Max;
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
	//@Length(min = 6, max = 11)
	//@Pattern(regexp = "^[0-9]+-[0-9kK]{1}$", message = "El Rut debe ser sin puntos y con guión")
	private String run_apoderado; //obligatorio
	private String estudiante_id; //obligatorio
	private Integer numero_documento; //obligatorio
	@NotBlank
	private String nombres; //obligatorio
	@NotBlank
	@Column(name = "apaterno")
	private String apaterno_apoderado; //obligatorio
	@NotBlank
	@Column(name = "amaterno")
	private String amaterno_apoderado;//obligatorio
	private String pasaporte;//opcional
	@NotBlank
	private String parentesco; //obligatorio
	@NotBlank
	private String tipo_apoderado; //obligatorio pero el principal
	@NotBlank
	private String estado_civil; //obligatorio
	@NotNull
	@Past
	@DateTimeFormat(iso=ISO.DATE)
	@Column(name = "fecha_nacimiento")
	private Date fecha_nacimiento_apoderado; //obligatorio
	@NotBlank
	@Column(name = "domicilio")
	private String domicilio_apoderado; //obligatorio
	@Column(name = "comuna")
	private String comuna_apoderado; //obligatorio
	@NotBlank
	private String nivel_educacion; //obligatorio
	@NotBlank
	private String ocupacion;	//obligatorio
	//@Length(min = 6, max = 9)
	@Column(name = "telefono")
	private String telefono_apoderado; //opcional
	@Length(min = 6, max = 9)
	@Column(name = "celular")
	private String celular_apoderado; //obligatorio
	@NotBlank
	@Email
	@Column(name = "correo_electronico")
	private String correo_electronico_apoderado; //obligatorio
	@NotNull
	private boolean es_tutor;
	@NotNull
	private boolean acepta_manual_convivencia_escolar; //obligatorio
	@NotNull
	private boolean autorizacion_fotografia_grabacion; //obligatorio
	@NotNull
	private boolean autorizado_retirar_establecimiento; //obligatorio
	public Apoderado(@NotBlank String run_apoderado, String estudiante_id, @Min(6) Integer numero_documento,
			@NotBlank String nombres, @NotBlank String apaterno_apoderado, @NotBlank String amaterno_apoderado,
			String pasaporte, @NotBlank String parentesco, @NotBlank String tipo_apoderado,
			@NotBlank String estado_civil, @NotNull @Past Date fecha_nacimiento_apoderado,
			@NotBlank String domicilio_apoderado, String comuna_apoderado, @NotBlank String nivel_educacion,
			@NotBlank String ocupacion, String telefono_apoderado, @Length(min = 6, max = 9) String celular_apoderado,
			@NotBlank @Email String correo_electronico_apoderado, @NotNull boolean es_tutor,
			@NotNull boolean acepta_manual_convivencia_escolar, @NotNull boolean autorizacion_fotografia_grabacion,
			@NotNull boolean autorizado_retirar_establecimiento) {
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
		this.fecha_nacimiento_apoderado = fecha_nacimiento_apoderado;
		this.domicilio_apoderado = domicilio_apoderado;
		this.comuna_apoderado = comuna_apoderado;
		this.nivel_educacion = nivel_educacion;
		this.ocupacion = ocupacion;
		this.telefono_apoderado = telefono_apoderado;
		this.celular_apoderado = celular_apoderado;
		this.correo_electronico_apoderado = correo_electronico_apoderado;
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
	public Date getFecha_nacimiento_apoderado() {
		return fecha_nacimiento_apoderado;
	}
	public void setFecha_nacimiento_apoderado(Date fecha_nacimiento_apoderado) {
		this.fecha_nacimiento_apoderado = fecha_nacimiento_apoderado;
	}
	public String getDomicilio_apoderado() {
		return domicilio_apoderado;
	}
	public void setDomicilio_apoderado(String domicilio_apoderado) {
		this.domicilio_apoderado = domicilio_apoderado;
	}
	public String getComuna_apoderado() {
		return comuna_apoderado;
	}
	public void setComuna_apoderado(String comuna_apoderado) {
		this.comuna_apoderado = comuna_apoderado;
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
	public String getTelefono_apoderado() {
		return telefono_apoderado;
	}
	public void setTelefono_apoderado(String telefono_apoderado) {
		this.telefono_apoderado = telefono_apoderado;
	}
	public String getCelular_apoderado() {
		return celular_apoderado;
	}
	public void setCelular_apoderado(String celular_apoderado) {
		this.celular_apoderado = celular_apoderado;
	}
	public String getCorreo_electronico_apoderado() {
		return correo_electronico_apoderado;
	}
	public void setCorreo_electronico_apoderado(String correo_electronico_apoderado) {
		this.correo_electronico_apoderado = correo_electronico_apoderado;
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
				+ ", fecha_nacimiento_apoderado=" + fecha_nacimiento_apoderado + ", domicilio_apoderado="
				+ domicilio_apoderado + ", comuna_apoderado=" + comuna_apoderado + ", nivel_educacion="
				+ nivel_educacion + ", ocupacion=" + ocupacion + ", telefono_apoderado=" + telefono_apoderado
				+ ", celular_apoderado=" + celular_apoderado + ", correo_electronico_apoderado="
				+ correo_electronico_apoderado + ", es_tutor=" + es_tutor + ", acepta_manual_convivencia_escolar="
				+ acepta_manual_convivencia_escolar + ", autorizacion_fotografia_grabacion="
				+ autorizacion_fotografia_grabacion + ", autorizado_retirar_establecimiento="
				+ autorizado_retirar_establecimiento + "]";
	}
	
	
	
	

}
