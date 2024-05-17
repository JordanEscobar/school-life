package com.schoollife.web.Util;

import java.awt.Color;
import java.io.IOException;
import java.text.DateFormat;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.schoollife.web.Entities.Apoderado;
import com.schoollife.web.Entities.Estudiante;
import com.schoollife.web.Entities.Programa_Integracion;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component("ResumenMatricula")
public class ListarMatriculaPDF extends AbstractPdfView{
	
	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		@SuppressWarnings("unchecked")
		List<Estudiante> listaE = (List<Estudiante>)model.get("listaE");
		/*@SuppressWarnings("unchecked")
		List<Apoderado> listaA = (List<Apoderado>) model.get("listaA");
		@SuppressWarnings("unchecked")
		List<Programa_Integracion> listaP = (List<Programa_Integracion>) model.get("listaP");*/
		
		
		Font fuenteTitulo = FontFactory.getFont(FontFactory.HELVETICA_BOLD,20,Color.BLUE);
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
		PdfPCell celdaFechaR = new PdfPCell(new Phrase(formateadorFechaMedia.format(listaE.get(0).getFecha_matricula()),fuenteTicket));
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
		celda1.setBackgroundColor(new Color(40,190,138));
		celda1.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
		celda1.setVerticalAlignment(PdfPCell.ALIGN_CENTER);
		celda1.setPadding(30);
		
		tablaTitulo1.addCell(celda1);
		tablaTitulo1.setSpacingAfter(50);
		
		
		
	    try{
	        //Obtenemos la instancia de la imagen/logo.
	        Image imagen = Image.getInstance("https://yt3.googleusercontent.com/K_Y005ALAvwfqQUZwn3jiSBTqjTirRuA_hBvFgMFeuPWmiS8ApMGYBvvYK9NcpBKBtZo3bwvPos=s900-c-k-c0x00ffffff-no-rj");
	        //Alineamos la imagen al centro del documento.
	        imagen.setAlignment(Image.ALIGN_RIGHT);
	        //Agregamos la imagen al documento.
	        document.add(imagen);
	    }catch(IOException | DocumentException ex){
	        ex.getMessage();
	    }
			
	}
}
