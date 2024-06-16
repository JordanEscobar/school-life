package com.schoollife.web.Util;

import java.awt.Color;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfName;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.schoollife.web.Entities.Apoderado;
import com.schoollife.web.Entities.Estudiante;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component("ResumenMatricula")
public class ListarMatriculaPDF extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
	        HttpServletRequest request, HttpServletResponse response) throws Exception {

	    Estudiante estudiante = (Estudiante) model.get("listaE");
	    List<Apoderado> listaApoderados = (List<Apoderado>) model.get("listaA");

	    Font fuenteTitulo = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 20, Color.BLACK);
	    Font fuenteSubtitulo = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 14, Color.BLACK);
	    Font fuenteTicket = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12, Color.BLACK);
	    Font fuenteTituloTabla = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12, Color.BLACK);
	    Font fuenteCeldas = FontFactory.getFont(FontFactory.COURIER, 10, Color.BLACK);
	    Font fuentePie = FontFactory.getFont(FontFactory.HELVETICA, 8, Color.BLACK);

	    document.setPageSize(PageSize.LETTER.rotate());
	    document.setMargins(20, 20, 40, 20);
	    document.open();

	    // Header
	    PdfPTable encabezado = new PdfPTable(2);
	    encabezado.setWidthPercentage(100);
	    encabezado.setSpacingAfter(20);

	    PdfPCell celdaLogo = new PdfPCell(new Phrase("Logo de la Empresa"));
	    celdaLogo.setBorder(0);
	    celdaLogo.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
	    celdaLogo.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
	    // celdaLogo.addElement(Image.getInstance("path/to/logo.png")); // Add your logo image here

	    PdfPCell celdaTitulo = new PdfPCell(new Phrase("Resumen de Matrícula", fuenteTitulo));
	    celdaTitulo.setBorder(0);
	    celdaTitulo.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
	    celdaTitulo.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);

	    encabezado.addCell(celdaLogo);
	    encabezado.addCell(celdaTitulo);

	    document.add(encabezado);

	    // Date
	    DateFormat formateadorFechaMedia = DateFormat.getDateInstance(DateFormat.MEDIUM);
	    PdfPCell celdaFechaR = new PdfPCell(new Phrase("Fecha: " + formateadorFechaMedia.format(estudiante.getFecha_matricula()), fuenteTicket));
	    celdaFechaR.setBorder(0);
	    celdaFechaR.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);

	    PdfPTable tablaFecha = new PdfPTable(1);
	    tablaFecha.setWidthPercentage(100);
	    tablaFecha.addCell(celdaFechaR);
	    tablaFecha.setSpacingAfter(20);

	    document.add(tablaFecha);

	    // Información del alumno
	    PdfPTable tablaInformacionAlumno = new PdfPTable(1);
	    PdfPCell celdaTituloAlumno = new PdfPCell(new Phrase("Información del Alumno", fuenteSubtitulo));
	    celdaTituloAlumno.setBorder(0);
	    celdaTituloAlumno.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
	    celdaTituloAlumno.setVerticalAlignment(PdfPCell.ALIGN_CENTER);
	    celdaTituloAlumno.setPadding(10);
	    tablaInformacionAlumno.addCell(celdaTituloAlumno);
	    tablaInformacionAlumno.setSpacingAfter(10);

	    PdfPTable tablaAlumno = new PdfPTable(2); // Modificado para ajustar mejor el espacio
	    tablaAlumno.setWidthPercentage(100);
	    tablaAlumno.setSpacingAfter(20);
	    tablaAlumno.addCell(crearCeldaCabecera("Nombre Completo", fuenteTituloTabla));
	    tablaAlumno.addCell(crearCeldaDato(estudiante.getNombre() + " " + estudiante.getApaterno() + " " + estudiante.getAmaterno(), fuenteCeldas)); // Cambio directo al método getter de nombre completo
	    tablaAlumno.addCell(crearCeldaCabecera("Rut", fuenteTituloTabla));
	    tablaAlumno.addCell(crearCeldaDato(estudiante.getRunEstudiante(), fuenteCeldas));
	    tablaAlumno.addCell(crearCeldaCabecera("Fecha nacimiento", fuenteTituloTabla));
	    tablaAlumno.addCell(crearCeldaDato(formateadorFechaMedia.format(estudiante.getFecha_nacimiento()), fuenteCeldas));
	    tablaAlumno.addCell(crearCeldaCabecera("Género", fuenteTituloTabla));
	    tablaAlumno.addCell(crearCeldaDato(estudiante.getGenero(), fuenteCeldas));
	    tablaAlumno.addCell(crearCeldaCabecera("Dirección", fuenteTituloTabla));
	    tablaAlumno.addCell(crearCeldaDato(estudiante.getDireccion(), fuenteCeldas));
	    tablaAlumno.addCell(crearCeldaCabecera("Nacionalidad", fuenteTituloTabla)); // Nueva columna
	    tablaAlumno.addCell(crearCeldaDato(estudiante.getNacionalidad(), fuenteCeldas)); // Agregar nacionalidad
	    tablaAlumno.addCell(crearCeldaCabecera("Comuna", fuenteTituloTabla)); // Nueva columna
	    tablaAlumno.addCell(crearCeldaDato(estudiante.getComuna(), fuenteCeldas)); // Agregar comuna

	    document.add(tablaInformacionAlumno);
	    document.add(tablaAlumno);

	 // Información de contacto
	    PdfPTable tablaInformacionContacto = new PdfPTable(1);
	    PdfPCell celdaTituloContacto = new PdfPCell(new Phrase("Información de Contacto", fuenteSubtitulo));
	    celdaTituloContacto.setBorder(0);
	    celdaTituloContacto.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
	    celdaTituloContacto.setVerticalAlignment(PdfPCell.ALIGN_CENTER);
	    celdaTituloContacto.setPadding(10);
	    tablaInformacionContacto.addCell(celdaTituloContacto);
	    tablaInformacionContacto.setSpacingAfter(10);

	    PdfPTable tablaContacto = new PdfPTable(1);
	    tablaContacto.setWidthPercentage(100);

	    // Correo Electrónico
	    tablaContacto.addCell(crearCeldaCabecera("Correo Electrónico", fuenteTituloTabla));
	    tablaContacto.addCell(crearCeldaDato(estudiante.getCorreo_electronico(), fuenteCeldas));

	    // Teléfono
	    String telefono = estudiante.getTelefono() != null && !estudiante.getTelefono().isEmpty() ? estudiante.getTelefono() : "No tiene teléfono";
	    tablaContacto.addCell(crearCeldaCabecera("Teléfono", fuenteTituloTabla));
	    tablaContacto.addCell(crearCeldaDato(telefono, fuenteCeldas));

	    // Celular
	    String celular = estudiante.getCelular() != null && !estudiante.getCelular().isEmpty() ? estudiante.getCelular() : "No tiene celular";
	    tablaContacto.addCell(crearCeldaCabecera("Celular", fuenteTituloTabla)); // Nueva columna para celular
	    tablaContacto.addCell(crearCeldaDato(celular != null ? celular : "No tiene celular", fuenteCeldas)); // Agregar celular aquí

	    tablaInformacionContacto.addCell(tablaContacto);

	    document.add(tablaInformacionContacto);
	 // Información escolar
	    PdfPTable tablaInformacionEscolar = new PdfPTable(1);
	    PdfPCell celdaTituloEscolar = new PdfPCell(new Phrase("Información Escolar", fuenteSubtitulo));
	    celdaTituloEscolar.setBorder(0);
	    celdaTituloEscolar.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
	    celdaTituloEscolar.setVerticalAlignment(PdfPCell.ALIGN_CENTER);
	    celdaTituloEscolar.setPadding(10);
	    tablaInformacionEscolar.addCell(celdaTituloEscolar);
	    tablaInformacionEscolar.setSpacingAfter(10);

	    PdfPTable tablaEscolar = new PdfPTable(2); // Usamos 2 columnas para mostrar datos de forma vertical
	    tablaEscolar.setWidthPercentage(100);
	    tablaEscolar.setSpacingAfter(20);

	    // Datos de la tabla
	    tablaEscolar.addCell(crearCeldaCabecera("Colegio matriculado", fuenteTituloTabla));
	    tablaEscolar.addCell(crearCeldaDato(estudiante.getEstablecimientoId().toString(), fuenteCeldas));

	    tablaEscolar.addCell(crearCeldaCabecera("Curso", fuenteTituloTabla));
	    tablaEscolar.addCell(crearCeldaDato(estudiante.getCurso_id().toString(), fuenteCeldas));

	    tablaEscolar.addCell(crearCeldaCabecera("Número Matrícula", fuenteTituloTabla));
	    tablaEscolar.addCell(crearCeldaDato(estudiante.getNumero_matricula().toString(), fuenteCeldas));

	    tablaEscolar.addCell(crearCeldaCabecera("Estado", fuenteTituloTabla));
	    tablaEscolar.addCell(crearCeldaDato(estudiante.isEstado() ? "Matriculado" : "Retirado", fuenteCeldas));

	    tablaEscolar.addCell(crearCeldaCabecera("Acepta clases de religión", fuenteTituloTabla));
	    tablaEscolar.addCell(crearCeldaDato(estudiante.isAcepta_clases_religion() ? "No opta a clases" : "Acepta clases", fuenteCeldas));

	    tablaEscolar.addCell(crearCeldaCabecera("Beca", fuenteTituloTabla));
	    tablaEscolar.addCell(crearCeldaDato(estudiante.getBeca(), fuenteCeldas));

	    tablaEscolar.addCell(crearCeldaCabecera("Cantidad de Computadores en Casa", fuenteTituloTabla));
	    tablaEscolar.addCell(crearCeldaDato(
	        estudiante.getCantidad_computadores_casa() == 0 ? "No tiene computadoras en su hogar" : String.valueOf(estudiante.getCantidad_computadores_casa()), 
	        fuenteCeldas));

	    tablaEscolar.addCell(crearCeldaCabecera("Colegio de Procedencia", fuenteTituloTabla));
	    tablaEscolar.addCell(crearCeldaDato(
	        estudiante.getColegio_procedencia().isEmpty() ? "Colegio actual/recién matriculado" : estudiante.getColegio_procedencia(), 
	        fuenteCeldas));

	    document.add(tablaInformacionEscolar);
	    document.add(tablaEscolar);
	 // Datos de salud
	    PdfPTable tablaDatosSalud = new PdfPTable(1); // Tabla principal para los datos de salud
	    PdfPCell celdaTituloSalud = new PdfPCell(new Phrase("Datos de Salud", fuenteSubtitulo)); // Celda para el título
	    celdaTituloSalud.setBorder(0);
	    celdaTituloSalud.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
	    celdaTituloSalud.setVerticalAlignment(PdfPCell.ALIGN_CENTER);
	    celdaTituloSalud.setPadding(10);

	    // Agregar celda de título a tablaDatosSalud
	    tablaDatosSalud.addCell(celdaTituloSalud);
	    tablaDatosSalud.setSpacingAfter(10); // Espacio después del título

	    // Crear tabla para los datos individuales de salud
	    PdfPTable tablaSalud = new PdfPTable(2); // 2 columnas para los datos de salud
	    tablaSalud.setWidthPercentage(100);
	    tablaSalud.setSpacingAfter(20); // Espacio después de la tabla

	    // Filas de la tabla de salud
	    tablaSalud.addCell(crearCeldaCabecera("Estatura", fuenteTituloTabla));
	    tablaSalud.addCell(crearCeldaDato(String.valueOf(estudiante.getEstatura()), fuenteCeldas));

	    tablaSalud.addCell(crearCeldaCabecera("Peso", fuenteTituloTabla));
	    tablaSalud.addCell(crearCeldaDato(String.valueOf(estudiante.getPeso()), fuenteCeldas));

	    tablaSalud.addCell(crearCeldaCabecera("Grupo Sanguíneo", fuenteTituloTabla));
	    tablaSalud.addCell(crearCeldaDato(estudiante.getGrupo_sanguineo(), fuenteCeldas));

	    tablaSalud.addCell(crearCeldaCabecera("Alergias a Alimentos", fuenteTituloTabla));
	    tablaSalud.addCell(crearCeldaDato(estudiante.getAlergias_alimentos(), fuenteCeldas));

	    tablaSalud.addCell(crearCeldaCabecera("Alergias a Medicamentos", fuenteTituloTabla));
	    tablaSalud.addCell(crearCeldaDato(estudiante.getAlergias_medicamentos(), fuenteCeldas));

	    // Nuevos campos de datos de salud
	    tablaSalud.addCell(crearCeldaCabecera("Medicamentos Contraindicados", fuenteTituloTabla));
	    tablaSalud.addCell(crearCeldaDato(estudiante.getMedicamentos_contraindicados(), fuenteCeldas));

	    tablaSalud.addCell(crearCeldaCabecera("Enfermedades Crónicas", fuenteTituloTabla));
	    tablaSalud.addCell(crearCeldaDato(estudiante.getEnfermedades_cronicas(), fuenteCeldas));

	    tablaSalud.addCell(crearCeldaCabecera("Vacuna COVID", fuenteTituloTabla));
	    tablaSalud.addCell(crearCeldaDato(estudiante.isVacuna_covid() ? "Está vacunado" : "No está vacunado", fuenteCeldas)); // Mostrar según el valor booleano

	    tablaSalud.addCell(crearCeldaCabecera("Cantidad de Vacunas COVID", fuenteTituloTabla));
	    String cantidadVacunasCovid = estudiante.getCantidad_vacunas_covid() == 0 ? "No tiene vacunas" : String.valueOf(estudiante.getCantidad_vacunas_covid());
	    tablaSalud.addCell(crearCeldaDato(cantidadVacunasCovid, fuenteCeldas));

	    // Mostrar la fecha de última vacuna COVID o mensaje si no tiene vacunas
	    tablaSalud.addCell(crearCeldaCabecera("Fecha Última Vacuna COVID", fuenteTituloTabla));
	    if (estudiante.getFecha_ultima_vacuna_COVID() != null) {
	        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	        tablaSalud.addCell(crearCeldaDato(dateFormat.format(estudiante.getFecha_ultima_vacuna_COVID()), fuenteCeldas));
	    } else {
	        tablaSalud.addCell(crearCeldaDato("No tiene vacunas COVID", fuenteCeldas));
	    }

	    // Mostrar el esquema completo de vacunación COVID
	    tablaSalud.addCell(crearCeldaCabecera("Esquema Completo Vacunación COVID", fuenteTituloTabla)); // Nueva columna
	    tablaSalud.addCell(crearCeldaDato(estudiante.isEsquema_completo_vacunacion_covid() ? "Sí" : "No", fuenteCeldas)); // Convertir a Sí/No según el valor

	    // Mostrar apto para educación física
	    tablaSalud.addCell(crearCeldaCabecera("Apto para Educación Física", fuenteTituloTabla));
	    tablaSalud.addCell(crearCeldaDato(estudiante.isApto_educacion_fisica() ? "Apto para actividad física" : "No puede realizar actividad física", fuenteCeldas));

	    // Mostrar sistema de previsión
	    tablaSalud.addCell(crearCeldaCabecera("Sistema de Previsión", fuenteTituloTabla));
	    tablaSalud.addCell(crearCeldaDato(estudiante.getSistema_prevision(), fuenteCeldas));
	    
	 // Mostrar seguro escolar privado
	    tablaSalud.addCell(crearCeldaCabecera("Seguro Escolar Privado", fuenteTituloTabla));
	    tablaSalud.addCell(crearCeldaDato(estudiante.isSeguro_escolar_privado() ? "Tiene seguro" : "No tiene seguro", fuenteCeldas));

	    tablaSalud.addCell(crearCeldaCabecera("Consultorio o Clínica", fuenteTituloTabla));
	    tablaSalud.addCell(crearCeldaDato(estudiante.getConsultorio_clinica(), fuenteCeldas));
	    
	    tablaSalud.addCell(crearCeldaCabecera("¿Condición 'Es P.I.E.'?", fuenteTituloTabla));
	    tablaSalud.addCell(crearCeldaDato(estudiante.isEs_pie() ? "Sí" : "No", fuenteCeldas));
	    
	    String observaciones = estudiante.getObservaciones();

	 // Mostrar observaciones si están presentes y cumplen con la longitud máxima
	 if (observaciones != null && !observaciones.isEmpty()) {
	     // Limitar la longitud si es necesario
	     if (observaciones.length() > 255) {
	         observaciones = observaciones.substring(0, 255); // Ajustar a 255 caracteres
	     }
	     tablaSalud.addCell(crearCeldaCabecera("Observaciones", fuenteTituloTabla));
	     tablaSalud.addCell(crearCeldaDato(observaciones, fuenteCeldas));
	 } else {
	     // Mostrar mensaje de ausencia de observaciones
	     tablaSalud.addCell(crearCeldaCabecera("Observaciones", fuenteTituloTabla));
	     tablaSalud.addCell(crearCeldaDato("No se entregan observaciones de salud para este estudiante", fuenteCeldas));
	 }

	    
	    // Agregar tabla de salud a tablaDatosSalud
	    tablaDatosSalud.addCell(tablaSalud);

	    // Agregar tablaDatosSalud al documento
	    try {
	        document.add(tablaDatosSalud);
	    } catch (DocumentException e) {
	        e.printStackTrace();
	    }

	    // Datos del apoderado
	    PdfPTable tablaDatosApoderado = new PdfPTable(1);
	    PdfPCell celdaTituloApoderado = new PdfPCell(new Phrase("Datos del Apoderado", fuenteSubtitulo));
	    celdaTituloApoderado.setBorder(0);
	    celdaTituloApoderado.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
	    celdaTituloApoderado.setVerticalAlignment(PdfPCell.ALIGN_CENTER);
	    celdaTituloApoderado.setPadding(10);
	    tablaDatosApoderado.addCell(celdaTituloApoderado);
	    tablaDatosApoderado.setSpacingAfter(10);

	    PdfPTable tablaApoderado = new PdfPTable(4);
	    tablaApoderado.setWidthPercentage(100);
	    tablaApoderado.setSpacingAfter(20);
	    tablaApoderado.addCell(crearCeldaCabecera("Nombre", fuenteTituloTabla));
	    tablaApoderado.addCell(crearCeldaCabecera("Parentesco", fuenteTituloTabla));
	    tablaApoderado.addCell(crearCeldaCabecera("Domicilio", fuenteTituloTabla));
	    tablaApoderado.addCell(crearCeldaCabecera("Fecha nacimiento", fuenteTituloTabla));

	    for (Apoderado apoderado : listaApoderados) {
	        tablaApoderado.addCell(crearCeldaDato(apoderado.getNombres() + " " + apoderado.getApaterno_apoderado(), fuenteCeldas));
	        tablaApoderado.addCell(crearCeldaDato(apoderado.getParentesco(), fuenteCeldas));
	        tablaApoderado.addCell(crearCeldaDato(apoderado.getDomicilio_apoderado(), fuenteCeldas));
	        tablaApoderado.addCell(crearCeldaDato(formateadorFechaMedia.format(apoderado.getFecha_nacimiento_apoderado()), fuenteCeldas));
	    }

	    tablaDatosApoderado.addCell(tablaApoderado);

	    document.add(tablaDatosApoderado);

	    // Footer
	    PdfPTable pieDePagina = new PdfPTable(1);
	    pieDePagina.setWidthPercentage(100);
	    PdfPCell celdaPie = new PdfPCell(new Phrase("Documento confidencial. Contacto: info@schoollife.com | Tel: (123) 456-7890", fuentePie));
	    celdaPie.setBorder(0);
	    celdaPie.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
	    pieDePagina.addCell(celdaPie);

	    document.add(pieDePagina);

	    document.close();
	}

	private PdfPCell crearCeldaCabecera(String texto, Font fuente) {
	    PdfPCell celda = new PdfPCell(new Phrase(texto, fuente));
	    celda.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
	    celda.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
	    celda.setBackgroundColor(new Color(240, 240, 240)); // Fondo gris claro
	    celda.setPadding(8);
	    return celda;
	}

	private PdfPCell crearCeldaDato(String texto, Font fuente) {
	    PdfPCell celda = new PdfPCell(new Phrase(texto, fuente));
	    celda.setPadding(8);
	    celda.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
	    return celda;
	}}