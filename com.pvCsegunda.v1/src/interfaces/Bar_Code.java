package interfaces;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import org.icepdf.ri.common.ComponentKeyBinding;
import org.icepdf.ri.common.SwingController;
import org.icepdf.ri.common.SwingViewBuilder;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.Barcode;
import com.itextpdf.text.pdf.Barcode128;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import conexionDB.DB_productos;
import conexionDB.DB_ventas;
import jbarcodebean.JBarcodeBean;
import net.sourceforge.jbarcodebean.model.Interleaved25;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Bar_Code extends JFrame {
	private List<String> letras = new ArrayList<>();
	private JPanel contentPane;
	public JTextField txt_id;
	private JTable tbl_bar_code;
	public JTextField txt_cantidad;
	public JLabel lbl_bar_code;
	public JLabel lbl_cantidad;
	public JLabel lbl_precio;
	public static Bar_Code frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Bar_Code();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws DocumentException 
	 */
	
	//barcode bean
	JBarcodeBean barcode = new JBarcodeBean();
	public static BufferedImage imagen = null;
	
	public void Generar_Img_Barras() {
		barcode.setCodeType(new Interleaved25());
		barcode.setCheckDigit(true);
		barcode.setCode(txt_id.getText()+"34563");
		
		imagen = barcode.draw(new BufferedImage(450, 300, BufferedImage.TYPE_INT_BGR));
		
		ImageIcon barras = new ImageIcon(imagen);
		this.lbl_bar_code.setName("31452345");
		this.lbl_bar_code.setIcon(barras);
		
	}
	
	
	public void Generar_Codigo() throws DocumentException {
		try {
			//se crea el documento pdf
		    Document doc=new Document();
		    //ruta de guardado del documento
		    //PdfWriter pdf=PdfWriter.getInstance(doc,new FileOutputStream("D:/PDF/codigo.pdf"));
		    PdfWriter pdf=PdfWriter.getInstance(doc,new FileOutputStream("E:/RESPALDO/Punto_de_venta/com.pvCsegunda.v1/src/Codigo_De_Barras/codigo.pdf"));
		    
		    //se abre el documento
		    doc.open();
		    
		    if (doc.isOpen() == true) {
		    	
		    JOptionPane.showMessageDialog(null, "CODIGO DE BARRAS GENERADO");
		    
		    for (int i = 0 ; i < Integer.parseInt(txt_cantidad.getText()) ; i++) {
		    //se crea el codigo de barras de tipo 39
		    Barcode128 code = new Barcode128();
		    //se le añade un codigo para mostrar
		    code.setCode(txt_id.getText());
		    //se le da color al codigo de barras
		    Image img = code.createImageWithBarcode(pdf.getDirectContent(), BaseColor.BLACK, BaseColor.BLACK);
		    //se le puede dar un tamaño al condigo de barras
		    img.scalePercent(120);
		    img.setAbsolutePosition(10, 600);
		    //insercion de la imagen con la posicion
		    img.setAlignment(Chunk.ALIGN_CENTER);
		    
		    
		    //se agrega el codigo de barras al documento
		    doc.add(img);
		    
		    
		    //se usa para generar un espacio o salto de linea 
		    doc.add(new Paragraph(" "));
		    
		    //para generar un espacio mas grande utilizamos (doc.add(Chunk.NEWLINE);)
		    }
		    }else {
		    	JOptionPane.showMessageDialog(null, "ERROR AL GENERA CODIGO DE BARRAS");
		    }
		    	
		    //se cierra el documento
		    doc.close();
		    
		}catch(FileNotFoundException ex) {
		   System.out.println(ex);
		}
	}
	
	public Bar_Code() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 990, 725);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(253, 223, 127));
		panel.setBounds(0, 0, 974, 686);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btn_regresar = new JButton("");
		btn_regresar.setIcon(new ImageIcon(Bar_Code.class.getResource("/imagenes/flecha.png")));
		btn_regresar.setBounds(0, 0, 44, 35);
		
		btn_regresar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Menu_principal mp = new Menu_principal();
				mp.setVisible(true);
				mp.setFocusable(true);
				mp.setLocationRelativeTo(null);
				dispose();
			}
		});
		panel.add(btn_regresar);
		
		JLabel lbl_id = new JLabel("ID");
		lbl_id.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_id.setFont(new Font("Dialog", Font.BOLD, 13));
		lbl_id.setBounds(83, 42, 69, 20);
		panel.add(lbl_id);
		
		txt_id = new JTextField();
		txt_id.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
			if(e.getButton()  == 3 || e.getButton() == 2) {
				txt_id.setText("");
			}
			}
		});
		txt_id.setFont(new Font("Dialog", Font.BOLD, 12));
		txt_id.setBounds(162, 42, 180, 20);
		
		
		panel.add(txt_id);
		
//		txt_id.addKeyListener(new KeyAdapter() {
//			@Override
//			public void keyTyped(KeyEvent e) {
//				int key = e.getKeyChar();
//
//			    boolean numeros = key >= 48 && key <= 57;
//			    
//			    if (!numeros)
//			    {
//			        e.consume();
//			    }
//			    /*if (txt_id.getText().trim().length() == 10) {
//			        e.consume();
//			    }*/
//			}
//		});
		txt_id.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(370, 39, 594, 79);
		panel.add(scrollPane);
		
		tbl_bar_code = new JTable();
		
		scrollPane.setViewportView(tbl_bar_code);
		
		JLabel lbl_id_1 = new JLabel("<html><center>CANTIDAD DE ETIQUETAS</center></html>");
		lbl_id_1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_id_1.setFont(new Font("Dialog", Font.BOLD, 13));
		lbl_id_1.setBounds(10, 115, 147, 35);
		panel.add(lbl_id_1);
		
		txt_cantidad = new JTextField();
		txt_cantidad.setEditable(false);
		txt_cantidad.setText("0");
		txt_cantidad.setHorizontalAlignment(SwingConstants.RIGHT);
		txt_cantidad.setFont(new Font("Dialog", Font.BOLD, 14));
		txt_cantidad.setColumns(10);
		txt_cantidad.setBounds(162, 115, 72, 35);
		
		txt_cantidad.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				int key = e.getKeyChar();
				boolean numeros = key >= 48 && key <= 57;
				if (!numeros)
			    {
			        e.consume();
			    }
				if(txt_cantidad.getText().trim().length() == 4) {
					e.consume();
				}
			}
		});
		panel.add(txt_cantidad);
		
		JButton btn_mas = new JButton("+");
		btn_mas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_mas.setFont(new Font("Dialog", Font.BOLD, 15));
		btn_mas.setBounds(244, 115, 44, 35);
		
		btn_mas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				//aumento de los numeros de la caja de texto txt_cantidad
				String Valor = txt_cantidad.getText() ;
				int valor = Integer.parseInt(Valor) ;
				valor++;
				txt_cantidad.setText(""+valor);
				//frame.requestFocus();
			}
		});
		panel.add(btn_mas);
		
		JButton btn_menos = new JButton("-");
		btn_menos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_menos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String Valor = txt_cantidad.getText() ;
				int valor = Integer.parseInt(Valor) ;
				
				if(valor > 0) {
				valor--;
				txt_cantidad.setText(""+valor);
				//frame.requestFocus();
				}else {
					txt_cantidad.setText("0");
					frame.requestFocus();
				}
			}
		});
		btn_menos.setFont(new Font("Dialog", Font.BOLD, 22));
		btn_menos.setBounds(298, 115, 44, 35);
		
		panel.add(btn_menos);
		
		JButton btn_ejecutar = new JButton("EJECUTAR");
		
		btn_ejecutar.setFont(new Font("Dialog", Font.BOLD, 13));
		btn_ejecutar.setBounds(162, 161, 180, 35);
//		
//		btn_ejecutar.addMouseListener(new MouseAdapter() {
//			public void mouseClicked(MouseEvent e) {
//				JOptionPane.showMessageDialog(null,"AÑADIENDO ELEMENTOS A LA HOJA");
//				
//				lbl_cantidad.setText(txt_cantidad.getText());
//				
//				try {
//					Generar_Img_Barras();
//					Generar_Codigo();
//					txt_id.setText("");
//					txt_cantidad.setText("0");
//					txt_id.requestFocus();
//				} catch (DocumentException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//			}
//		});
		panel.add(btn_ejecutar);
		
		JButton btn_limpiar_hoja = new JButton("LIMPIAR HOJA");
		btn_limpiar_hoja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			}
		});
		btn_limpiar_hoja.setFont(new Font("Dialog", Font.BOLD, 13));
		btn_limpiar_hoja.setBounds(596, 173, 142, 23);
	
		panel.add(btn_limpiar_hoja);
		
		JButton btn_buscar = new JButton("BUSCAR");
		btn_buscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btn_buscar.setFont(new Font("Dialog", Font.BOLD, 13));
		btn_buscar.setBounds(162, 73, 180, 31);
		
		btn_buscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//			
				
				try {
				
					if(!txt_id.getText().equalsIgnoreCase("")) {
						int filas =  DB_productos.model_view_prod_barcode(Long.parseLong(txt_id.getText())).getRowCount();
						
						if(filas > 0) {
							tbl_bar_code.setModel(DB_productos.model_view_prod_barcode(Long.parseLong( txt_id.getText())));	
						}
						
					}
				
				
				
				
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
//				if (!txt_id.getText().equals("")) {
//					JOptionPane.showMessageDialog(null,"LLENANDO CAMPOS");
//					txt_id.setText("");
//					txt_cantidad.setText("");
//					txt_id.requestFocus();
//				}
//				else {
//					Bar_Code_Buscar bcb = new Bar_Code_Buscar();
//					bcb.setVisible(true);
//					bcb.setFocusable(true);
//					bcb.setLocationRelativeTo(null);
//				}
			}
		});
		panel.add(btn_buscar);
		
		JButton btn_imprimir = new JButton("IMPRIMIR");
		btn_imprimir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String url = "C:/Punto_de_venta/com.pvCsegunda.v1/src/Codigo_De_Barras/codigo.pdf";

				File archivo = new File(url);
				
				if(archivo.exists()) {
			
					if(Desktop.isDesktopSupported()) {
						try {
							Desktop.getDesktop().open(archivo);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}else{
						System.out.println("no soportado");
					}
					
				}else{
				System.out.println("no existe archivo");
			}
			}
		});
		btn_imprimir.setFont(new Font("Dialog", Font.BOLD, 13));
		btn_imprimir.setBounds(596, 139, 142, 23);
		panel.add(btn_imprimir);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 222, 954, 451);
		panel.add(scrollPane_1);
		
		btn_ejecutar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
				try {
		

					if(txt_id.getText().equalsIgnoreCase("") && txt_cantidad.getText().equalsIgnoreCase("") || !txt_id.getText().equalsIgnoreCase("") && txt_cantidad.getText().equalsIgnoreCase("0")) {
						JOptionPane.showMessageDialog(null,"SELECCIONA UNA CANTIDAD DE ETIQUETAS MAYOR A 0");
		frame.requestFocus();

					}else {

						createPdf(txt_id.getText(), Integer.parseInt(txt_cantidad.getText()));
						openpdf(scrollPane_1 );	

					//	frame.requestFocus();


					}
					
					}	
			
		 catch (NumberFormatException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (DocumentException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
			}
			
		});
		
		btn_limpiar_hoja.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int resp = JOptionPane.showConfirmDialog(null, "¿ESTAS SEGURO DE LIMPIAR LA HOJA?", "¡ALERTA!", JOptionPane.YES_NO_OPTION);
				
				if(resp == 0) {
				
					try {
						createPdf("",0);
						letras.clear();
					
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (DocumentException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					openpdf(scrollPane_1);
					
					 DefaultTableModel cleanTable;
					try {
						cleanTable = DB_productos.model_view_prod_barcode(Long.parseLong( txt_id.getText()));

						cleanTable.setRowCount(0);
						tbl_bar_code.setModel(cleanTable);
						txt_id.setText("");
						txt_id.requestFocus();
					}
					catch (NumberFormatException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				
				//lbl_bar_code.setIcon(null);
				//lbl_cantidad.setText("");
				//lbl_precio.setText("");

				txt_cantidad.setText("0");
				txt_id.setText("");
				txt_id.requestFocus();

				}
			}
			@Override
			public void mousePressed(MouseEvent e) {
		
			}
		});
		/*
		 
		 panel con recuadro centrico resaltando precio titulo
		JPanel pnl_vista = new JPanel();
		scrollPane_1.setViewportView(pnl_vista);
		pnl_vista.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnl_vista.setLayout(null);
		
		JLabel lbl_titulo_etiqueta = new JLabel("<html><center>ETIQUETAS</center></html>");
		lbl_titulo_etiqueta.setFont(new Font("Dialog", Font.BOLD, 13));
		lbl_titulo_etiqueta.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_titulo_etiqueta.setBounds(7, 11, 583, 22);
		pnl_vista.add(lbl_titulo_etiqueta);
		
		lbl_bar_code = new JLabel("");
		lbl_bar_code.setIcon(null);
		lbl_bar_code.setBorder(new LineBorder(new Color(0, 0, 0)));
		lbl_bar_code.setHorizontalTextPosition(SwingConstants.CENTER);
		lbl_bar_code.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_bar_code.setBounds(180, 44, 234, 121);
		pnl_vista.add(lbl_bar_code);
		
		lbl_cantidad = new JLabel("");
		lbl_cantidad.setFont(new Font("Dialog", Font.BOLD, 13));
		lbl_cantidad.setBorder(new LineBorder(new Color(0, 0, 0)));
		lbl_cantidad.setHorizontalTextPosition(SwingConstants.CENTER);
		lbl_cantidad.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_cantidad.setBounds(180, 176, 111, 28);
		pnl_vista.add(lbl_cantidad);
		
		lbl_precio = new JLabel("$ 352");
		lbl_precio.setFont(new Font("Dialog", Font.BOLD, 13));
		lbl_precio.setHorizontalTextPosition(SwingConstants.CENTER);
		lbl_precio.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_precio.setBorder(new LineBorder(new Color(0, 0, 0)));
		lbl_precio.setBounds(301, 176, 113, 28);
		pnl_vista.add(lbl_precio);*/
		envento_barcode eventos = new envento_barcode();
		eventos.evento_barcodes(tbl_bar_code, txt_id);
		txt_id.addKeyListener(eventos);
		
	}
	
	public void createPdf(String id,int cantidad) throws IOException, DocumentException {

		Document document = new Document();
		String url = "C:/Punto_de_venta/com.pvCsegunda.v1/src/Codigo_De_Barras/codigo.pdf";
		

	PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(url));
    System.out.println(id+cantidad);
		if(cantidad == 0) {

	document.open();
	document.add(new  Chunk(""));
	document.close();		
		}else {

	document.open();
	PdfPTable table = new PdfPTable(4);

	table.setWidthPercentage(100);
	table.setHorizontalAlignment(0);



	for(int i = 0; i < cantidad ; i++) {
		letras.add(i, id);
		
	}

	while((cantidad % 4) != 0) {
	cantidad++;
	letras.add("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

	};
		






	for (int i = 0; i <= letras.size()-1; i++) {
		
	    table.addCell(createBarcode(writer, letras.get(i)));
	}

	document.add(table);
	document.close();		
		}

	}

		public static PdfPCell createBarcode(PdfWriter writer, String code) throws DocumentException, IOException {
		Barcode128 barcode = new Barcode128();
		barcode.setCodeType(Barcode.CODE128);


		barcode.setCode(code);



		PdfPCell cell = new PdfPCell(barcode.createImageWithBarcode(writer.getDirectContent(), BaseColor.BLACK, BaseColor.GRAY), true);
		cell.setPadding(10);
		return cell;

		}
		
		
public	  void openpdf(JScrollPane panel){
	  
	String url = "C:/Punto_de_venta/com.pvCsegunda.v1/src/Codigo_De_Barras/codigo.pdf";

    try {
           SwingController control=new SwingController();
            SwingViewBuilder factry=new SwingViewBuilder(control);
            JPanel veiwerCompntpnl=factry.buildViewerPanel();
            ComponentKeyBinding.install(control, veiwerCompntpnl);
            
           control.getDocumentViewController();
            control.getDocumentViewController().setAnnotationCallback(new org.icepdf.ri.common.MyAnnotationCallback( control.getDocumentViewController()));
           
            control.openDocument(url);
        panel.setViewportView(veiwerCompntpnl); 
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,"Cannot Load Pdf");
        }
}
}

class envento_barcode implements KeyListener{

	private JTable tabla;
	private JTextField campo;
	
	public envento_barcode() {
		
	}
	

	 void evento_barcodes(JTable tabla, JTextField campo) {
		// TODO Auto-generated method stub
this.tabla = tabla;
		this.campo = campo;
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
		
		
		
		int key = e.getKeyChar();
		boolean numeros = key >= 48 && key <=57;
		if(!numeros) {
			
		e.consume();	
		}
			}
	
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
	


						
				}
	
	@Override
	public void keyPressed(KeyEvent e) {
		
		
if(e.getKeyCode() == KeyEvent.VK_ENTER) {
	
	
	if(campo.getText().equalsIgnoreCase("")) {
		System.out.println("vaacio");
	}else {
		
		
try {
tabla.setModel(	DB_productos.model_view_prod_barcode(Long.parseLong(campo.getText() )));

} catch (NumberFormatException e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
} catch (SQLException e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
}
		
					
					 
	
}
		
}}
	
}

