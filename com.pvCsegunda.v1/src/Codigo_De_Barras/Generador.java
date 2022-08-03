package Codigo_De_Barras;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.swing.JOptionPane;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.Barcode39;
import com.itextpdf.text.pdf.PdfWriter;

public class Generador {

	public static void main(String []args) throws DocumentException {
	try {
		
			//se crea el documento pdf
		    Document doc=new Document();
		    //ruta de guardado del documento
		    PdfWriter pdf=PdfWriter.getInstance(doc,new FileOutputStream("D:/PDF/codigo.pdf"));
		          
		    //se abre el documento
		    doc.open();
		    
		    if (doc.isOpen() == true) {
		    	
		    JOptionPane.showMessageDialog(null, "CODIGO DE BARRAS GENERADO");
		    
		    for (int i = 0 ; i < 25 ; i++) {
		    //se crea el codigo de barras de tipo 39
		    Barcode39 code = new Barcode39();
		    //se le añade un codigo para mostrar
		    code.setCode("1234567890");
		    //se le da color al codigo de barras
		    Image img = code.createImageWithBarcode(pdf.getDirectContent(), BaseColor.BLACK, BaseColor.BLACK);
		    //se le puede dar un tamaño al condigo de barras
		    img.scalePercent(125);
		    //se agrega el codigo de barras al documento
		    doc.add(img);
		    
		    doc.add(new Paragraph(" "));
		    }
		    }else {
		    	JOptionPane.showMessageDialog(null, "ERROR AL GENERA CODIGO DE BARRAS");
		    }
		    	
		    //se cierra el documento
		    doc.close();
		    
		}catch(FileNotFoundException ex) {
		   System.out.println(ex);
		}     
}}
