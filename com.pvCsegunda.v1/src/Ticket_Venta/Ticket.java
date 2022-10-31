package Ticket_Venta;

import java.awt.print.PrinterJob;
import java.io.FileOutputStream;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfWriter;


//libreias itext


public class Ticket{


	public static void main(String[] args) {
		System.out.println("pdf creado");
		pdf();
		
	}
	
	
	public static void pdf() {
		String url="C:/Punto_de_venta/com.pvCsegunda.v1/src/Ticket_Venta/ticket.pdf";
		Rectangle r = new Rectangle(80,100);
		Document documento = new Document(r,9f,9f,7f,7f);
		
		try {
			
			FileOutputStream archivo = new FileOutputStream(url);
			
			PdfWriter.getInstance(documento, archivo);
			
			
			documento.open();
			
			//FUENTES PARA TITULOS Y FUENTE PARA LOS DATOS
			//TIPO DE LETRA, TAMAÑO DE LA FUENTE,DISEÑO DE LETRA,COLOR DE LA FUENTE
			Font Fuente_titulo = FontFactory.getFont(FontFactory.TIMES,3,Font.NORMAL,BaseColor.BLACK);
			Font Fuente_texto = FontFactory.getFont(FontFactory.TIMES,2,Font.NORMAL,BaseColor.BLACK);
			
			//variable para salto de linea
			Paragraph salto_linea = new Paragraph();
			salto_linea.add(new Paragraph(Chunk.NEWLINE));
			
			
			//INICO DEL ENCABEZADO PRINCIPAL DEL TICKET
			PdfPTable encabezado_principal = new PdfPTable(1);
			encabezado_principal.setWidthPercentage(100);
			float[] medida_de_celda = {100f};
			encabezado_principal.setWidths(medida_de_celda);
			
			PdfPCell nombre_empresa = new PdfPCell(new Phrase("NOMBRE DE LA EMPRESA",Fuente_titulo)); 
			nombre_empresa.setVerticalAlignment(Element.ALIGN_CENTER);
			nombre_empresa.setHorizontalAlignment(Element.ALIGN_CENTER);
			nombre_empresa.setBorder(0);
			
			PdfPCell direccion = new PdfPCell(new Phrase("DIRECCION DE LA EMPRESA",Fuente_texto)); 
			direccion.setVerticalAlignment(Element.ALIGN_CENTER);
			direccion.setHorizontalAlignment(Element.ALIGN_CENTER);
			direccion.setBorder(0);
			

			PdfPCell fecha = new PdfPCell(new Phrase("FECHA ACTUAL",Fuente_texto)); 
			fecha.setVerticalAlignment(Element.ALIGN_CENTER);
			fecha.setHorizontalAlignment(Element.ALIGN_CENTER);
			fecha.setBorder(0);
			
			encabezado_principal.addCell(nombre_empresa);
			encabezado_principal.addCell(direccion);
			encabezado_principal.addCell(fecha);
			
			documento.add(encabezado_principal);
			
			//CIERRE DEL ENCABEZADO PRINCIPAL DEL TICKET
			
			
			//INICIA EL APARTADO DE LISTADO DE PRODUCTOS
			PdfPTable informacion = new PdfPTable(3);
			informacion.setWidthPercentage(100);
			float[] medida_de_celda_informacion = {10f,10f,10f};
			informacion.setWidths(medida_de_celda_informacion);
			
			PdfPCell producto = new PdfPCell(new Phrase("NOMBRE DEL PRODUCTO",Fuente_titulo)); 
			producto.setVerticalAlignment(Element.ALIGN_CENTER);
			producto.setHorizontalAlignment(Element.ALIGN_CENTER);
			producto.setBorder(0);
			
			PdfPCell descripcion = new PdfPCell(new Phrase("DESCRIPCION DEL PRODUCTO",Fuente_titulo)); 
			descripcion.setVerticalAlignment(Element.ALIGN_CENTER);
			descripcion.setHorizontalAlignment(Element.ALIGN_CENTER);
			descripcion.setBorder(0);
			
			PdfPCell precio = new PdfPCell(new Phrase("PRECIO DEL PRODUCTO",Fuente_titulo)); 
			precio.setVerticalAlignment(Element.ALIGN_CENTER);
			precio.setHorizontalAlignment(Element.ALIGN_CENTER);
			precio.setBorder(0);
			
			
			informacion.addCell(producto);
			informacion.addCell(precio);
			informacion.addCell(descripcion);
			
			documento.add(informacion);
			//TERMINA EL APARTADO DE LISTADO DE PRODUCTOS
			
			documento.add(salto_linea);
			
			//EMPIEZA EL APARTADO DE TOTAL
			
			PdfPTable precio_total = new PdfPTable(1);
			precio_total.setWidthPercentage(100);
			float[] medida_de_celda_total= {100f};
			encabezado_principal.setWidths(medida_de_celda_total);
			
			PdfPCell precio_t = new PdfPCell(new Phrase("PRECIO TOTAL",Fuente_titulo)); 
			precio_t.setVerticalAlignment(Element.ALIGN_RIGHT);
			precio_t.setHorizontalAlignment(Element.ALIGN_RIGHT);
			precio_t.setBorder(0);
			
			precio_total.addCell(precio_t);
			
			documento.add(precio_total);
			
			//TERMINA EL APARTADO DE TOTAL
			
			//INICIA PIE DE PAGINA
			PdfPTable pie_de_pagina = new PdfPTable(1);
			pie_de_pagina.setWidthPercentage(100);
			float[] medida_de_celda_pie= {100f};

			encabezado_principal.setWidths(medida_de_celda_pie);
			
			PdfPCell pie_descripcion = new PdfPCell(new Phrase("**************",Fuente_titulo)); 
			pie_descripcion.setVerticalAlignment(Element.ALIGN_RIGHT);
			pie_descripcion.setHorizontalAlignment(Element.ALIGN_RIGHT);
			pie_descripcion.setBorder(0);
			
			pie_de_pagina.addCell(pie_descripcion);
			
			documento.add(pie_de_pagina);
			
			
			documento.close();
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
	}	
	
	

}
