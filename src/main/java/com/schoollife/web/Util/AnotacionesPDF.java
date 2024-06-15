package com.schoollife.web.Util;

import java.awt.Color;
import java.text.DateFormat;
import java.time.ZoneId;
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
import com.schoollife.web.Entities.Hoja_de_vida;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component("Hoja-de-vida-ver")
public class AnotacionesPDF extends AbstractPdfView {

    @Override
    protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
                                    HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        @SuppressWarnings("unchecked")
        List<Hoja_de_vida> listaHojas = (List<Hoja_de_vida>) model.get("hoja_de_vida");

        Font fuenteTitulo = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 20, Color.BLACK);
        Font fuenteTicket = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12, Color.BLACK);
        Font fuenteTituloTabla = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12, Color.BLACK);
        Font fuenteCeldas = FontFactory.getFont(FontFactory.COURIER, 10, Color.BLACK);

        document.setPageSize(PageSize.LETTER.rotate());
        document.setMargins(-20, 20, 40, 20);
        document.open();

        PdfPTable titulo = new PdfPTable(1);
        PdfPCell celdatitulo = new PdfPCell(new Phrase("School Life", fuenteTicket));
        celdatitulo.setBorder(0);
        celdatitulo.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);

        DateFormat formateadorFechaMedia = DateFormat.getDateInstance(DateFormat.MEDIUM);

        titulo.addCell(celdatitulo);
        titulo.setSpacingAfter(30);

        PdfPTable tablaTitulo1 = new PdfPTable(1);
        PdfPCell celda1 = new PdfPCell(new Phrase("Anotaciones estudiante", fuenteTitulo));
        celda1.setBorder(0);
        celda1.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celda1.setPadding(30);

        tablaTitulo1.addCell(celda1);
        tablaTitulo1.setSpacingAfter(50);

        PdfPTable tablaTitulo3 = new PdfPTable(6);
        float[] columnWidths = {2f, 2f, 2f, 4f, 2f, 2f};
        tablaTitulo3.setWidths(columnWidths);

        PdfPCell celda20 = new PdfPCell(new Phrase("Tipo de evento", fuenteTituloTabla));
        PdfPCell celda21 = new PdfPCell(new Phrase("Fecha", fuenteTituloTabla));
        PdfPCell celda22 = new PdfPCell(new Phrase("Asignatura", fuenteTituloTabla));
        PdfPCell celda23 = new PdfPCell(new Phrase("Detalle", fuenteTituloTabla));
        PdfPCell celda24 = new PdfPCell(new Phrase("Rut estudiante", fuenteTituloTabla));
        PdfPCell celda25 = new PdfPCell(new Phrase("Rut emisor", fuenteTituloTabla));

        PdfPCell[] headerCells = {celda20, celda21, celda22, celda23, celda24, celda25};
        for (PdfPCell cell : headerCells) {
            cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
            cell.setVerticalAlignment(PdfPCell.ALIGN_CENTER);
            cell.setBackgroundColor(Color.LIGHT_GRAY);
            cell.setPadding(10);
            tablaTitulo3.addCell(cell);
        }

        PdfPTable tablaEvento = new PdfPTable(6);
        tablaEvento.setWidths(columnWidths);

        listaHojas.forEach(hojas -> {
            tablaEvento.addCell(createCell(hojas.getTipoEvento(), fuenteCeldas));
            tablaEvento.addCell(createCell(formateadorFechaMedia.format(hojas.getFecha()), fuenteCeldas));
            tablaEvento.addCell(createCell(hojas.getAsignatura(), fuenteCeldas));
            tablaEvento.addCell(createCell(hojas.getDetalle(), fuenteCeldas));
            tablaEvento.addCell(createCell(hojas.getEstudianteId(), fuenteCeldas));
            tablaEvento.addCell(createCell(hojas.getUsuarioId(), fuenteCeldas));
        });

        document.add(titulo);
        document.add(tablaTitulo1);
        document.add(tablaTitulo3);
        document.add(tablaEvento);
    }

    private PdfPCell createCell(String content, Font font) {
        PdfPCell cell = new PdfPCell(new Phrase(content, font));
        cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        cell.setVerticalAlignment(PdfPCell.ALIGN_CENTER);
        cell.setPadding(8);
        return cell;
    }
}
