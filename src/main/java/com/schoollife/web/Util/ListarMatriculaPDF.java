package com.schoollife.web.Util;

import java.awt.Color;
import java.text.DateFormat;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.schoollife.web.Entities.Apoderado;
import com.schoollife.web.Entities.Estudiante;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component("ResumenMatricula")
public class ListarMatriculaPDF extends AbstractPdfView{
	
	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		@SuppressWarnings("unchecked")
		Estudiante listaE = (Estudiante) model.get("listaE");
		@SuppressWarnings("unchecked")
		List<Apoderado> listaA = (List<Apoderado>) model.get("listaA");
		/*@SuppressWarnings("unchecked")
		List<Programa_Integracion> listaP = (List<Programa_Integracion>) model.get("listaP");*/
		
		
		Font fuenteTitulo = FontFactory.getFont(FontFactory.HELVETICA_BOLD,20,Color.BLACK);
		Font fuenteTicket = FontFactory.getFont(FontFactory.HELVETICA_BOLD,12,Color.BLACK);
		Font fuenteTituloTabla = FontFactory.getFont(FontFactory.HELVETICA_BOLD,12,Color.BLACK);
		Font fuenteCeldas = FontFactory.getFont(FontFactory.COURIER,10,Color.BLACK);
		
		document.setPageSize(PageSize.LETTER.rotate());
		document.setMargins(-20, 20, 40, 20);
		document.open();
		
		PdfPTable titulo = new PdfPTable(1);
		PdfPCell celdatitulo = null;
		celdatitulo = new PdfPCell(new Phrase("School Life",fuenteTicket));
		celdatitulo.setBorder(0);
		
		DateFormat formateadorFechaMedia = DateFormat.getDateInstance(DateFormat.MEDIUM);
		PdfPCell celdaFechaR = new PdfPCell(new Phrase(formateadorFechaMedia.format(listaE.getFecha_matricula()),fuenteTicket));
		celdaFechaR.setBorder(0);
		celdaFechaR.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
		
		titulo.addCell(celdatitulo);
		titulo.addCell(celdaFechaR);
		titulo.setSpacingAfter(30);
		titulo.setHorizontalAlignment(50);
		
		PdfPTable tablaTitulo1 = new PdfPTable(1);
		PdfPCell celda1 = null;
		celda1 = new PdfPCell(new Phrase("Matrícula estudiante",fuenteTitulo));
		celda1.setBorder(0);
		//celda1.setBackgroundColor(new Color(40,190,138));
		celda1.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
		celda1.setVerticalAlignment(PdfPCell.ALIGN_CENTER);
		celda1.setPadding(30);
		
		tablaTitulo1.addCell(celda1);
		tablaTitulo1.setSpacingAfter(50);
		
		PdfPTable tablaTitulo3 = new PdfPTable(5);
		PdfPCell celda20 = new PdfPCell(new Phrase("Nombre estudiante",fuenteTituloTabla));
		PdfPCell celda21 = new PdfPCell(new Phrase("Rut",fuenteTituloTabla));
		PdfPCell celda22 = new PdfPCell(new Phrase("Fecha nacimiento",fuenteTituloTabla));
		PdfPCell celda23 = new PdfPCell(new Phrase("Colégio matriculado",fuenteTituloTabla));
		PdfPCell celda24 = new PdfPCell(new Phrase("Curso",fuenteTituloTabla));
		celda20.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
		celda20.setVerticalAlignment(PdfPCell.ALIGN_CENTER);
		celda21.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
		celda21.setVerticalAlignment(PdfPCell.ALIGN_CENTER);
		celda22.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
		celda22.setVerticalAlignment(PdfPCell.ALIGN_CENTER);
		celda23.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
		celda23.setVerticalAlignment(PdfPCell.ALIGN_CENTER);
		celda24.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
		celda24.setVerticalAlignment(PdfPCell.ALIGN_CENTER);
		celda20.setBackgroundColor(Color.LIGHT_GRAY);
		celda21.setBackgroundColor(Color.LIGHT_GRAY);
		celda22.setBackgroundColor(Color.LIGHT_GRAY);
		celda23.setBackgroundColor(Color.LIGHT_GRAY);
		celda24.setBackgroundColor(Color.LIGHT_GRAY);
		celda20.setPadding(10);
		celda21.setPadding(10);
		celda22.setPadding(10);
		celda23.setPadding(10);
		celda24.setPadding(10);
		
		tablaTitulo3.addCell(celda20);
		tablaTitulo3.addCell(celda21);
		tablaTitulo3.addCell(celda22);
		tablaTitulo3.addCell(celda23);
		tablaTitulo3.addCell(celda24);
		
		PdfPTable tablaTitulo2 = new PdfPTable(1);
		PdfPCell celda2 = null;		
		celda2 = new PdfPCell(new Phrase("Apoderado Títular",fuenteTituloTabla));
		celda2.setBorder(0);
		tablaTitulo2.addCell(celda2);
		tablaTitulo2.setSpacingAfter(20);
		tablaTitulo2.setSpacingBefore(30);
		
		PdfPTable tablaEvento = new PdfPTable(5);
		PdfPTable tablaReserva = new PdfPTable(4);
		
		PdfPTable tablaTitulo4 = new PdfPTable(4);
		PdfPCell celda10 = new PdfPCell(new Phrase("Nombre",fuenteTituloTabla));
		PdfPCell celda11 = new PdfPCell(new Phrase("Parentesco",fuenteTituloTabla));
		PdfPCell celda12 = new PdfPCell(new Phrase("Domicilio",fuenteTituloTabla));
		PdfPCell celda13 = new PdfPCell(new Phrase("Fecha nacimiento",fuenteTituloTabla));
		celda10.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
		celda10.setVerticalAlignment(PdfPCell.ALIGN_CENTER);
		celda11.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
		celda11.setVerticalAlignment(PdfPCell.ALIGN_CENTER);
		celda12.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
		celda12.setVerticalAlignment(PdfPCell.ALIGN_CENTER);
		celda13.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
		celda13.setVerticalAlignment(PdfPCell.ALIGN_CENTER);
		celda10.setBackgroundColor(Color.LIGHT_GRAY);
		celda11.setBackgroundColor(Color.LIGHT_GRAY);
		celda12.setBackgroundColor(Color.LIGHT_GRAY);
		celda13.setBackgroundColor(Color.LIGHT_GRAY);
		celda10.setPadding(10);
		celda11.setPadding(10);
		celda12.setPadding(10);
		celda13.setPadding(10);
		
		tablaTitulo4.addCell(celda10);
		tablaTitulo4.addCell(celda11);
		tablaTitulo4.addCell(celda12);
		tablaTitulo4.addCell(celda13);
		
		
		listaA.forEach(reserva->{
			PdfPCell celda25 = new PdfPCell(new Phrase(reserva.getNombres().toString() + " "+ reserva.getApaterno_apoderado(),fuenteCeldas));
			celda24.setPadding(30);
			tablaReserva.addCell(celda25);
			PdfPCell celda26 = new PdfPCell(new Phrase(reserva.getParentesco().toString(),fuenteCeldas));
			celda24.setPadding(30);
			tablaReserva.addCell(celda26);
			PdfPCell celda27 = new PdfPCell(new Phrase(reserva.getDomicilio_apoderado().toString(),fuenteCeldas));
			celda24.setPadding(30);
			tablaReserva.addCell(celda27);
			PdfPCell celda28 = new PdfPCell(new Phrase(formateadorFechaMedia.format(reserva.getFecha_nacimiento_apoderado()),fuenteCeldas));
			celda24.setPadding(30);
			tablaReserva.addCell(celda28);
		});
		
		tablaReserva.setSpacingAfter(30);
		
			PdfPCell celda29 = new PdfPCell(new Phrase(listaE.getNombre(),fuenteCeldas));
			celda24.setPadding(8);
			tablaEvento.addCell(celda29);
			PdfPCell celda30 = new PdfPCell(new Phrase(listaE.getRunEstudiante().toString(),fuenteCeldas));
			celda24.setPadding(8);
			tablaEvento.addCell(celda30);
			PdfPCell celda31 = new PdfPCell(new Phrase(formateadorFechaMedia.format(listaE.getFecha_nacimiento()),fuenteCeldas));
			celda24.setPadding(8);
			tablaEvento.addCell(celda31);
			PdfPCell celda32 = new PdfPCell(new Phrase(listaE.getEstablecimiento_id().toString(),fuenteCeldas));
			celda24.setPadding(8);
			tablaEvento.addCell(celda32);
			PdfPCell celda33 = new PdfPCell(new Phrase(listaE.getCurso_id().toString(),fuenteCeldas));
			celda24.setPadding(8);
			tablaEvento.addCell(celda33);
		
		document.add(titulo);
		document.add(tablaTitulo1);
		document.add(tablaTitulo3);
		document.add(tablaEvento);
		document.add(tablaTitulo2);
		document.add(tablaTitulo4);
		document.add(tablaReserva);

			
	}
}
