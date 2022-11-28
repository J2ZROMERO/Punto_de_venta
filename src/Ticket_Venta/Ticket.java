package Ticket_Venta;

import java.awt.image.BufferedImage;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.print.PrintService;
import javax.swing.table.DefaultTableModel;

import com.github.anastaciocintra.escpos.EscPos;
import com.github.anastaciocintra.escpos.EscPosConst;
import com.github.anastaciocintra.escpos.Style;
import com.github.anastaciocintra.escpos.image.Bitonal;
import com.github.anastaciocintra.escpos.image.BitonalOrderedDither;
import com.github.anastaciocintra.escpos.image.BitonalThreshold;
import com.github.anastaciocintra.escpos.image.CoffeeImageImpl;
import com.github.anastaciocintra.escpos.image.EscPosImage;
import com.github.anastaciocintra.escpos.image.RasterBitImageWrapper;
import com.github.anastaciocintra.output.PrinterOutputStream;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.List;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfWriter;

import interfaces.Usuarios;

import com.github.anastaciocintra.escpos.EscPos;
import com.github.anastaciocintra.escpos.EscPosConst;
import com.github.anastaciocintra.escpos.Style;
import com.github.anastaciocintra.escpos.image.Bitonal;
import com.github.anastaciocintra.escpos.image.BitonalOrderedDither;
import com.github.anastaciocintra.escpos.image.BitonalThreshold;
import com.github.anastaciocintra.escpos.image.CoffeeImageImpl;
import com.github.anastaciocintra.escpos.image.EscPosImage;
import com.github.anastaciocintra.escpos.image.RasterBitImageWrapper;
import com.github.anastaciocintra.output.PrinterOutputStream;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.print.PrintService;

//libreias itext

public class Ticket{
	
	public void datosImpresora (DefaultTableModel datos,String user,String total) {
		

		Object datos_venta[] = new Object[5];
		
		for(int i= 0;i < datos.getRowCount();i++) {
		
			datos_venta[0] = datos.getValueAt(i,0);
			datos_venta[1] = datos.getValueAt(i,5);
			datos_venta[2] =datos.getValueAt(i,4);
			datos_venta[3] =datos.getValueAt(i,6);
			datos_venta[4] =datos.getValueAt(i,1);
			
 	
		}
		
	
		
		
	}


    public void print(String printerName,DefaultTableModel datos,String user,String total,String cliente){

        PrintService printService = PrinterOutputStream.getPrintServiceByName(printerName);
        EscPos escpos;
        try {
            RasterBitImageWrapper imageWrapper = new RasterBitImageWrapper();

            escpos = new EscPos(new PrinterOutputStream(printService));
            

            imageWrapper.setJustification(EscPosConst.Justification.Center);

            
            Style title = new Style()
            		
                    .setFontSize(Style.FontSize._3, Style.FontSize._3)
                    .setJustification(EscPosConst.Justification.Center);
            Style center = new Style()
                    .setFontSize(Style.FontSize._1, Style.FontSize._1)
                    .setJustification(EscPosConst.Justification.Center);

            Style right = new Style().setJustification(EscPosConst.Justification.Right);
	Style left = new Style().setJustification(EscPosConst.Justification.Left_Default);
            
            Style subtitle = new Style(escpos.getStyle())
                    .setBold(true)
                    .setUnderline(Style.Underline.OneDotThick);
            Style bold = new Style(escpos.getStyle())
                    .setBold(true);
            
            

//BufferedImage  imageBufferedImage = (BufferedImage)ImageIO.read(new File("C:/Punto_de_venta/src/imagenes/impresora.png"));
            
           SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
           Date date = new Date();  
             
 
            
           escpos = new EscPos(new PrinterOutputStream(printService));
            
   
        Bitonal algorithm = new BitonalThreshold(); 
//EscPosImage escposImage = new EscPosImage(new CoffeeImageImpl(imageBufferedImage), algorithm);
         
        
//         using ordered dither for dithering algorithm with (clearing) values
  //         algorithm = new BitonalOrderedDither(2,2,120,170);
   //escposImage = new EscPosImage(new CoffeeImageImpl(imageBufferedImage), algorithm);
    //escpos.write(imageWrapper, escposImage);
         escpos.writeLF						("").feed(1);
         escpos.write(27).write(112).write(0).write(55).write(121);   
            escpos.writeLF						(title,"My Market")
                    .feed(1)
                    .writeLF					(center,"Calle de las flores #12 seccion primera")
                    .writeLF					(center,"Ticket #1325156") 
                    .writeLF(center,formatter.format(date))
                    .write						("Te atendio:")  .writeLF(user == null ? "":user)
                    .write						("Cliente: ")     .writeLF(cliente)
                    .feed(1);
                    
         
            
    		for(int i= 0;i < datos.getRowCount();i++) {

    			if(String.valueOf(datos.getValueAt(i,0)).length() > 10) {
    				escpos.writeLF		("Id      Pzas    Precio     Total");
      				escpos.writeLF(right,
      				Ticket.printline(Long.parseLong((String)datos.getValueAt(i,0)),
     	    		   Long.parseLong(datos.getValueAt(i,5).toString()),
     	    		   Double.parseDouble(datos.getValueAt(i,4).toString()),
     	    		   Double.parseDouble(datos.getValueAt(i,6).toString())    	    		   )
     	    		   )
               .write(String.valueOf(datos.getValueAt(i,0))+ "   ")
               .writeLF(String.valueOf(datos.getValueAt(i,1)));
      		}else {
      			escpos.writeLF		("Id      Pzas    Precio     Total");		
      			escpos.writeLF(right,
      					Ticket.printline(Long.parseLong((String)datos.getValueAt(i,0)),
      					Long.parseLong(datos.getValueAt(i,5).toString()),
      					Double.parseDouble(datos.getValueAt(i,4).toString()),
      					Double.parseDouble(datos.getValueAt(i,6).toString())    	    		   )
      					)
      			.writeLF(String.valueOf(datos.getValueAt(i,1)));  			
      		}
    }
 	
    		int conteoSubYtotal = ("SubTotal   $   ").length() + total.length();
    		int conteoIva =("      Iva   $   ").length();
    		String espacioIva = "";
    		String iva = "      Iva   $";
    		while(conteoIva != conteoSubYtotal) {
    			espacioIva+=" ";
    			conteoSubYtotal--;
    		}
    		iva+=espacioIva+"0.00";
    		
                escpos.feed(1);
                 escpos.writeLF					(right,"SubTotal   $   " + total )
                   .writeLF					(right,iva)
                    .writeLF					(right,"    Total   $   "+ total)
                    .feed(1)
                   .writeLF					(center,"Gracias por tu compra!");
                 escpos.feed(3)
                    //.pulsePin(null, conteoSubYtotal, conteoIva)
                    
                    .cut(EscPos.CutMode.FULL);
            
            
            escpos.close();
            
        } catch (IOException ex) {
            Logger.getLogger(Ticket.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
/*
    public static void main(String[] args) {
         	
    	
    	if(args.length!=1){
//            System.out.println("Usage: java -jar xyz.jar (\"printer name\")");
              //  System.out.println("Printer list to use:");
                String[] printServicesNames = PrinterOutputStream.getListPrintServicesNames();
                for(String printServiceName: printServicesNames){
                  //  System.out.println(printServiceName);
                }
                
               // System.exit(0);
            }
            Ticket obj = new Ticket();
//            obj.print("POS-58-Series");
            System.out.println(obj.printline(12349123123L, 545, 54521.00, 12333.32));

    }*/
    
    private static String printline(long id, long unidades, double precio, double total) {
    	
    	String ids = String.valueOf(id);
        String unidadesvar = String.valueOf(unidades);
        String preciovar = String.valueOf(precio);
        String totalvar = String.valueOf(total);
        String totalDePago = "";
        String totalPrecio = "";
        String space = " ";
      
        
    	if(ids.length() > 10 || preciovar.length() > 8 ||totalvar.length() > 8 ) {
    		
    		System.out.println("in range out ");
    		while (unidadesvar.length() != 3) {
    			unidadesvar += space;
    		} ;
 
    		int countSpacesInprecio = preciovar.length();
    		while (countSpacesInprecio != 8) {
    			
    			totalPrecio += space;
    			countSpacesInprecio++;
    		} ;
    		totalPrecio+=preciovar;
    		int countSpacesIntotal = totalvar.length();
 
    		while (countSpacesIntotal != 8) {
    			totalDePago +=space;
    			countSpacesIntotal++;
    		};
    		totalDePago += totalvar;
    		String productoDetalles = unidadesvar + " "+ totalPrecio + " "+ totalDePago;
    		System.out.println("below");
    		return productoDetalles;
    		
    	}else {
    		System.out.println("in range in ");
    		while (ids.length() != 10){
    			
    			ids += space;
    			System.out.println("1 while ");
    		} ;
    		
    		while (unidadesvar.length() != 3) {
    			System.out.println("2 while ");
    			unidadesvar += space;
    		} ;
 
    		int countSpacesInprecio = preciovar.length();
    		while (countSpacesInprecio != 8) {
    			System.out.println("3 while ");
    			totalPrecio += space;
    			countSpacesInprecio++;
    		} ;
    		totalPrecio+=preciovar;
    		int countSpacesIntotal = totalvar.length();
 
    		while (countSpacesIntotal != 8) {
    			System.out.println("4 while ");
    			totalDePago +=space;
    			countSpacesIntotal++;
    		};
    		totalDePago += totalvar;
    		String productoDetalles = ids+" " + unidadesvar + " "+ totalPrecio + " "+ totalDePago;
    		System.out.println("below");
    		return productoDetalles;
    	}
    	
        // System.out.println("Los caracteres estan sobrepasado los limites de la
        // impresion maixmo largo de 32");
        // para subtotal el maximo es de 7 cifras inclutyendo el punto}
        // para ñas piezas maximo una cantidadn de 3000
        // 
      };


}


