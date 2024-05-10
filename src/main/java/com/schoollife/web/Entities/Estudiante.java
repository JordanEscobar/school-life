package com.schoollife.web.Entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name ="estudiantes")
public class Estudiante {
	@Id
	private String run_estudiante;
	private String nombre;
	private String apaterno;
	private String amaterno;
	private String numero_matricula;
	private Date fecha_matricula;
	private Date fecha_nacimiento;
	private String pais_nacimiento;
	private String genero;
	private String direccion;
	private String comuna;
	private String correo_electronico;
	private String telefono;
	private String celular;
	private String colegio_procedencia;
	private String nombre_contacto_emergencia;
	private String telefono_emergencia;
	private String vive_con;
	private Integer cantidad_computadores_casa;
	private String religion;
	private boolean acepta_clases_religion;
	private String beca;
	private Integer estatura;
	private double peso;
	private String grupo_sanguineo;
	private String alergias_alimentos;
	private String alergias_medicamentos;
	private String medicamentos_contraindicados;
	private String enfermedades_cronicas;
	private boolean vacuna_covid;
	private Integer cantidad_vacunas_covid;
	private boolean esquema_completo_vacunacion_covid;
	private Date fecha_ultima_vacuna_COVID;
	private boolean apto_educacion_fisica;
	private String sistema_prevision;
	private String seguro_escolar_privado;
	private String nacionalidad;
	private String etnia;
	private String consultorio_clinica;
	@Column(name = "observaciones_medicas")
	private String observaciones;
	private boolean estado;
	private Integer establecimiento_id;
	private Integer curso_id;
	public Estudiante(String run_estudiante, String nombre, String apaterno, String amaterno, String numero_matricula,
			Date fecha_matricula, Date fecha_nacimiento, String pais_nacimiento, String genero, String direccion,
			String comuna, String correo_electronico, String telefono, String celular, String colegio_procedencia,
			String nombre_contacto_emergencia, String telefono_emergencia, String vive_con,
			Integer cantidad_computadores_casa, String religion, boolean acepta_clases_religion, String beca,
			Integer estatura, double peso, String grupo_sanguineo, String alergias_alimentos,
			String alergias_medicamentos, String medicamentos_contraindicados, String enfermedades_cronicas,
			boolean vacuna_covid, Integer cantidad_vacunas_covid, boolean esquema_completo_vacunacion_covid,
			Date fecha_ultima_vacuna_COVID, boolean apto_educacion_fisica, String sistema_prevision,
			String seguro_escolar_privado, String nacionalidad, String etnia, String consultorio_clinica,
			String observaciones, boolean estado, Integer establecimiento_id, Integer curso_id) {
		super();
		this.run_estudiante = run_estudiante;
		this.nombre = nombre;
		this.apaterno = apaterno;
		this.amaterno = amaterno;
		this.numero_matricula = numero_matricula;
		this.fecha_matricula = fecha_matricula;
		this.fecha_nacimiento = fecha_nacimiento;
		this.pais_nacimiento = pais_nacimiento;
		this.genero = genero;
		this.direccion = direccion;
		this.comuna = comuna;
		this.correo_electronico = correo_electronico;
		this.telefono = telefono;
		this.celular = celular;
		this.colegio_procedencia = colegio_procedencia;
		this.nombre_contacto_emergencia = nombre_contacto_emergencia;
		this.telefono_emergencia = telefono_emergencia;
		this.vive_con = vive_con;
		this.cantidad_computadores_casa = cantidad_computadores_casa;
		this.religion = religion;
		this.acepta_clases_religion = acepta_clases_religion;
		this.beca = beca;
		this.estatura = estatura;
		this.peso = peso;
		this.grupo_sanguineo = grupo_sanguineo;
		this.alergias_alimentos = alergias_alimentos;
		this.alergias_medicamentos = alergias_medicamentos;
		this.medicamentos_contraindicados = medicamentos_contraindicados;
		this.enfermedades_cronicas = enfermedades_cronicas;
		this.vacuna_covid = vacuna_covid;
		this.cantidad_vacunas_covid = cantidad_vacunas_covid;
		this.esquema_completo_vacunacion_covid = esquema_completo_vacunacion_covid;
		this.fecha_ultima_vacuna_COVID = fecha_ultima_vacuna_COVID;
		this.apto_educacion_fisica = apto_educacion_fisica;
		this.sistema_prevision = sistema_prevision;
		this.seguro_escolar_privado = seguro_escolar_privado;
		this.nacionalidad = nacionalidad;
		this.etnia = etnia;
		this.consultorio_clinica = consultorio_clinica;
		this.observaciones = observaciones;
		this.estado = estado;
		this.establecimiento_id = establecimiento_id;
		this.curso_id = curso_id;
	}
	public Estudiante() {
		super();
	}
	public String getRun_estudiante() {
		return run_estudiante;
	}
	public void setRun_estudiante(String run_estudiante) {
		this.run_estudiante = run_estudiante;
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
	public String getNumero_matricula() {
		return numero_matricula;
	}
	public void setNumero_matricula(String numero_matricula) {
		this.numero_matricula = numero_matricula;
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
	public String getPais_nacimiento() {
		return pais_nacimiento;
	}
	public void setPais_nacimiento(String pais_nacimiento) {
		this.pais_nacimiento = pais_nacimiento;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getComuna() {
		return comuna;
	}
	public void setComuna(String comuna) {
		this.comuna = comuna;
	}
	public String getCorreo_electronico() {
		return correo_electronico;
	}
	public void setCorreo_electronico(String correo_electronico) {
		this.correo_electronico = correo_electronico;
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
	public String getColegio_procedencia() {
		return colegio_procedencia;
	}
	public void setColegio_procedencia(String colegio_procedencia) {
		this.colegio_procedencia = colegio_procedencia;
	}
	public String getNombre_contacto_emergencia() {
		return nombre_contacto_emergencia;
	}
	public void setNombre_contacto_emergencia(String nombre_contacto_emergencia) {
		this.nombre_contacto_emergencia = nombre_contacto_emergencia;
	}
	public String getTelefono_emergencia() {
		return telefono_emergencia;
	}
	public void setTelefono_emergencia(String telefono_emergencia) {
		this.telefono_emergencia = telefono_emergencia;
	}
	public String getVive_con() {
		return vive_con;
	}
	public void setVive_con(String vive_con) {
		this.vive_con = vive_con;
	}
	public Integer getCantidad_computadores_casa() {
		return cantidad_computadores_casa;
	}
	public void setCantidad_computadores_casa(Integer cantidad_computadores_casa) {
		this.cantidad_computadores_casa = cantidad_computadores_casa;
	}
	public String getReligion() {
		return religion;
	}
	public void setReligion(String religion) {
		this.religion = religion;
	}
	public boolean isAcepta_clases_religion() {
		return acepta_clases_religion;
	}
	public void setAcepta_clases_religion(boolean acepta_clases_religion) {
		this.acepta_clases_religion = acepta_clases_religion;
	}
	public String getBeca() {
		return beca;
	}
	public void setBeca(String beca) {
		this.beca = beca;
	}
	public Integer getEstatura() {
		return estatura;
	}
	public void setEstatura(Integer estatura) {
		this.estatura = estatura;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	public String getGrupo_sanguineo() {
		return grupo_sanguineo;
	}
	public void setGrupo_sanguineo(String grupo_sanguineo) {
		this.grupo_sanguineo = grupo_sanguineo;
	}
	public String getAlergias_alimentos() {
		return alergias_alimentos;
	}
	public void setAlergias_alimentos(String alergias_alimentos) {
		this.alergias_alimentos = alergias_alimentos;
	}
	public String getAlergias_medicamentos() {
		return alergias_medicamentos;
	}
	public void setAlergias_medicamentos(String alergias_medicamentos) {
		this.alergias_medicamentos = alergias_medicamentos;
	}
	public String getMedicamentos_contraindicados() {
		return medicamentos_contraindicados;
	}
	public void setMedicamentos_contraindicados(String medicamentos_contraindicados) {
		this.medicamentos_contraindicados = medicamentos_contraindicados;
	}
	public String getEnfermedades_cronicas() {
		return enfermedades_cronicas;
	}
	public void setEnfermedades_cronicas(String enfermedades_cronicas) {
		this.enfermedades_cronicas = enfermedades_cronicas;
	}
	public boolean isVacuna_covid() {
		return vacuna_covid;
	}
	public void setVacuna_covid(boolean vacuna_covid) {
		this.vacuna_covid = vacuna_covid;
	}
	public Integer getCantidad_vacunas_covid() {
		return cantidad_vacunas_covid;
	}
	public void setCantidad_vacunas_covid(Integer cantidad_vacunas_covid) {
		this.cantidad_vacunas_covid = cantidad_vacunas_covid;
	}
	public boolean isEsquema_completo_vacunacion_covid() {
		return esquema_completo_vacunacion_covid;
	}
	public void setEsquema_completo_vacunacion_covid(boolean esquema_completo_vacunacion_covid) {
		this.esquema_completo_vacunacion_covid = esquema_completo_vacunacion_covid;
	}
	public Date getFecha_ultima_vacuna_COVID() {
		return fecha_ultima_vacuna_COVID;
	}
	public void setFecha_ultima_vacuna_COVID(Date fecha_ultima_vacuna_COVID) {
		this.fecha_ultima_vacuna_COVID = fecha_ultima_vacuna_COVID;
	}
	public boolean isApto_educacion_fisica() {
		return apto_educacion_fisica;
	}
	public void setApto_educacion_fisica(boolean apto_educacion_fisica) {
		this.apto_educacion_fisica = apto_educacion_fisica;
	}
	public String getSistema_prevision() {
		return sistema_prevision;
	}
	public void setSistema_prevision(String sistema_prevision) {
		this.sistema_prevision = sistema_prevision;
	}
	public String getSeguro_escolar_privado() {
		return seguro_escolar_privado;
	}
	public void setSeguro_escolar_privado(String seguro_escolar_privado) {
		this.seguro_escolar_privado = seguro_escolar_privado;
	}
	public String getNacionalidad() {
		return nacionalidad;
	}
	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	public String getEtnia() {
		return etnia;
	}
	public void setEtnia(String etnia) {
		this.etnia = etnia;
	}
	public String getConsultorio_clinica() {
		return consultorio_clinica;
	}
	public void setConsultorio_clinica(String consultorio_clinica) {
		this.consultorio_clinica = consultorio_clinica;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	public Integer getEstablecimiento_id() {
		return establecimiento_id;
	}
	public void setEstablecimiento_id(Integer establecimiento_id) {
		this.establecimiento_id = establecimiento_id;
	}
	public Integer getCurso_id() {
		return curso_id;
	}
	public void setCurso_id(Integer curso_id) {
		this.curso_id = curso_id;
	}
	@Override
	public String toString() {
		return "Estudiante [run_estudiante=" + run_estudiante + ", nombre=" + nombre + ", apaterno=" + apaterno
				+ ", amaterno=" + amaterno + ", numero_matricula=" + numero_matricula + ", fecha_matricula="
				+ fecha_matricula + ", fecha_nacimiento=" + fecha_nacimiento + ", pais_nacimiento=" + pais_nacimiento
				+ ", genero=" + genero + ", direccion=" + direccion + ", comuna=" + comuna + ", correo_electronico="
				+ correo_electronico + ", telefono=" + telefono + ", celular=" + celular + ", colegio_procedencia="
				+ colegio_procedencia + ", nombre_contacto_emergencia=" + nombre_contacto_emergencia
				+ ", telefono_emergencia=" + telefono_emergencia + ", vive_con=" + vive_con
				+ ", cantidad_computadores_casa=" + cantidad_computadores_casa + ", religion=" + religion
				+ ", acepta_clases_religion=" + acepta_clases_religion + ", beca=" + beca + ", estatura=" + estatura
				+ ", peso=" + peso + ", grupo_sanguineo=" + grupo_sanguineo + ", alergias_alimentos="
				+ alergias_alimentos + ", alergias_medicamentos=" + alergias_medicamentos
				+ ", medicamentos_contraindicados=" + medicamentos_contraindicados + ", enfermedades_cronicas="
				+ enfermedades_cronicas + ", vacuna_covid=" + vacuna_covid + ", cantidad_vacunas_covid="
				+ cantidad_vacunas_covid + ", esquema_completo_vacunacion_covid=" + esquema_completo_vacunacion_covid
				+ ", fecha_ultima_vacuna_COVID=" + fecha_ultima_vacuna_COVID + ", apto_educacion_fisica="
				+ apto_educacion_fisica + ", sistema_prevision=" + sistema_prevision + ", seguro_escolar_privado="
				+ seguro_escolar_privado + ", nacionalidad=" + nacionalidad + ", etnia=" + etnia
				+ ", consultorio_clinica=" + consultorio_clinica + ", observaciones=" + observaciones + ", estado="
				+ estado + ", establecimiento_id=" + establecimiento_id + ", curso_id=" + curso_id + "]";
	}
	
	
	
	
	
	

}
