package Ticket_Venta;

import java.awt.image.BufferedImage;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.print.PrintService;

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
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfWriter;
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



    public void print(String printerName){

        PrintService printService = PrinterOutputStream.getPrintServiceByName(printerName);
        EscPos escpos;
        try {
            RasterBitImageWrapper imageWrapper = new RasterBitImageWrapper();

            escpos = new EscPos(new PrinterOutputStream(printService));
            

            imageWrapper.setJustification(EscPosConst.Justification.Center);

            
            Style title = new Style()
                    .setFontSize(Style.FontSize._3, Style.FontSize._3)
                    .setJustification(EscPosConst.Justification.Center);

            Style subtitle = new Style(escpos.getStyle())
                    .setBold(true)
                    .setUnderline(Style.Underline.OneDotThick);
            Style bold = new Style(escpos.getStyle())
                    .setBold(true);

           BufferedImage  imageBufferedImage = (BufferedImage)ImageIO.read(new File("c:/arrow.png"));

            

 
            
           escpos = new EscPos(new PrinterOutputStream(printService));
            
   
            Bitonal algorithm = new BitonalThreshold(); 
           EscPosImage escposImage = new EscPosImage(new CoffeeImageImpl(imageBufferedImage), algorithm);
         
        
            // using ordered dither for dithering algorithm with (clearing) values
           // algorithm = new BitonalOrderedDither(2,2,120,170);
       //     escposImage = new EscPosImage(new CoffeeImageImpl(imageBufferedImage), algorithm);
          escpos.write(imageWrapper, escposImage);
       
            escpos.writeLF(title,"My Market")
                    .feed(1)
                    .write						("Client: ")
                    .writeLF					(subtitle, "John Doe")
                    .feed(1)
                    .writeLF						 ("Cup of coffee              $1.00")
                    .writeLF						 ("Botle of water             $0.50")
                    .writeLF					(bold,"--------------------------------")
                    .feed(1)
                    .writeLF					(bold,"TOTAL                      $1.50")
                    .writeLF					(bold,"--------------------------------")
                    .feed(2)
                    .cut(EscPos.CutMode.FULL);
            
            
            escpos.close();
            
        } catch (IOException ex) {
            Logger.getLogger(Ticket.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public static void main(String[] args) {
            if(args.length!=1){
            System.out.println("Usage: java -jar xyz.jar (\"printer name\")");
                System.out.println("Printer list to use:");
                String[] printServicesNames = PrinterOutputStream.getListPrintServicesNames();
                for(String printServiceName: printServicesNames){
                    System.out.println(printServiceName);
                }
                
              //  System.exit(0);
            }
            Ticket obj = new Ticket();
            obj.print("POS-58-Series");

    }
    
	

}
