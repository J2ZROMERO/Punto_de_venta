package interfaces;

import java.awt.BorderLayout;
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

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.Barcode39;
import com.itextpdf.text.pdf.PdfWriter;

import Codigo_De_Barras.Generar_Img_Codigo;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JToggleButton;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class Bar_Code extends JFrame {

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
	
	public void Generar_Codigo() throws DocumentException {
		try {
			//se crea el documento pdf
		    Document doc=new Document();
		    //ruta de guardado del documento
		    PdfWriter pdf=PdfWriter.getInstance(doc,new FileOutputStream("D:/PDF/codigo.pdf"));
		   
		    
		    //se abre el documento
		    doc.open();
		    
		    if (doc.isOpen() == true) {
		    	
		    JOptionPane.showMessageDialog(null, "CODIGO DE BARRAS GENERADO");
		    
		    for (int i = 0 ; i < Integer.parseInt(txt_cantidad.getText()) ; i++) {
		    //se crea el codigo de barras de tipo 39
		    Barcode39 code = new Barcode39();
		    //se le añade un codigo para mostrar
		    code.setCode(txt_id.getText());
		    //se le da color al codigo de barras
		    Image img = code.createImageWithBarcode(pdf.getDirectContent(), BaseColor.BLACK, BaseColor.BLACK);
		    //se le puede dar un tamaño al condigo de barras
		    img.scalePercent(125);
		    
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 636, 598);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 620, 559);
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
		lbl_id.setBounds(10, 70, 69, 20);
		panel.add(lbl_id);
		
		txt_id = new JTextField();
		txt_id.setFont(new Font("Dialog", Font.BOLD, 12));
		txt_id.setBounds(89, 70, 108, 20);
		panel.add(txt_id);
		
		txt_id.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				int key = e.getKeyChar();

			    boolean numeros = key >= 48 && key <= 57;
			    
			    if (!numeros)
			    {
			        e.consume();
			    }
			    /*if (txt_id.getText().trim().length() == 10) {
			        e.consume();
			    }*/
			}
		});
		txt_id.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(237, 39, 373, 96);
		panel.add(scrollPane);
		
		tbl_bar_code = new JTable();
		tbl_bar_code.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"<html><center>PRODUCTO</center></html>", "<html><center>DISTINTIVO 1</center></html>", "<html><center>DISTINTIVO 2</center></html>"
			}
		));
		scrollPane.setViewportView(tbl_bar_code);
		
		JLabel lbl_id_1 = new JLabel("<html><center>CANTIDAD DE ETIQUETAS</center></html>");
		lbl_id_1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_id_1.setFont(new Font("Dialog", Font.BOLD, 13));
		lbl_id_1.setBounds(10, 146, 147, 35);
		panel.add(lbl_id_1);
		
		txt_cantidad = new JTextField();
		txt_cantidad.setEditable(false);
		txt_cantidad.setText("0");
		txt_cantidad.setHorizontalAlignment(SwingConstants.CENTER);
		txt_cantidad.setFont(new Font("Dialog", Font.BOLD, 14));
		txt_cantidad.setColumns(10);
		txt_cantidad.setBounds(10, 190, 44, 35);
		
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
		btn_mas.setFont(new Font("Dialog", Font.BOLD, 15));
		btn_mas.setBounds(64, 190, 44, 35);
		
		btn_mas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//aumento de los numeros de la caja de texto txt_cantidad
				String Valor = txt_cantidad.getText() ;
				int valor = Integer.parseInt(Valor) ;
				valor++;
				txt_cantidad.setText(""+valor);
				frame.requestFocus();
			}
		});
		panel.add(btn_mas);
		
		JButton btn_menos = new JButton("-");
		btn_menos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String Valor = txt_cantidad.getText() ;
				int valor = Integer.parseInt(Valor) ;
				
				if(valor > 0) {
				valor--;
				txt_cantidad.setText(""+valor);
				frame.requestFocus();
				}else {
					txt_cantidad.setText("0");
					frame.requestFocus();
				}
			}
		});
		btn_menos.setFont(new Font("Dialog", Font.BOLD, 22));
		btn_menos.setBounds(118, 190, 44, 35);
		
		panel.add(btn_menos);
		
		JLabel lbl_añadir_precio_a_etiquetas = new JLabel("<html><center>AÑADIR PRECIO A ETIQUETAS</center></html>");
		lbl_añadir_precio_a_etiquetas.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_añadir_precio_a_etiquetas.setFont(new Font("Dialog", Font.BOLD, 13));
		lbl_añadir_precio_a_etiquetas.setBounds(208, 146, 153, 35);
		panel.add(lbl_añadir_precio_a_etiquetas);
		
		JButton btn_encendido = new JButton("ON");
		btn_encendido.setFont(new Font("Dialog", Font.BOLD, 13));
		btn_encendido.setBounds(218, 197, 61, 23);
		panel.add(btn_encendido);
		
		JButton btn_apagado = new JButton("OFF");
		btn_apagado.setFont(new Font("Dialog", Font.BOLD, 13));
		btn_apagado.setBounds(289, 197, 61, 23);
		panel.add(btn_apagado);
		
		JButton btn_ejecutar = new JButton("EJECUTAR");
		btn_ejecutar.setFont(new Font("Dialog", Font.BOLD, 13));
		btn_ejecutar.setBounds(34, 268, 122, 23);
		
		btn_ejecutar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null,"AÑADIENDO ELEMENTOS A LA HOJA");
				lbl_cantidad.setText(txt_cantidad.getText());
				try {
					Generar_Codigo();
					txt_id.setText("");
					txt_cantidad.setText("0");
					txt_id.requestFocus();
				} catch (DocumentException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		panel.add(btn_ejecutar);
		
		JButton btn_limpiar_hoja = new JButton("LIMPIAR HOJA");
		btn_limpiar_hoja.setFont(new Font("Dialog", Font.BOLD, 13));
		btn_limpiar_hoja.setBounds(192, 268, 141, 23);
		
		btn_limpiar_hoja.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int resp = JOptionPane.showConfirmDialog(null, "¿ESTAS SEGURO DE LIMPIAR LA HOJA?", "¡ALERTA!", JOptionPane.YES_NO_OPTION);
				
				if(resp == 0) {
				JOptionPane.showMessageDialog(null,"LIMPIANDO HOJA");
				lbl_bar_code.setIcon(null);
				lbl_cantidad.setText("");
				lbl_precio.setText("");
				txt_id.setText("");
				txt_id.requestFocus();
				}
			}
		});
		panel.add(btn_limpiar_hoja);
		
		JButton btn_buscar = new JButton("BUSCAR");
		btn_buscar.setFont(new Font("Dialog", Font.BOLD, 13));
		btn_buscar.setBounds(402, 146, 180, 23);
		
		btn_buscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if (!txt_id.getText().equals("")) {
					JOptionPane.showMessageDialog(null,"LLENANDO CAMPOS");
					txt_id.setText("");
					txt_cantidad.setText("");
					txt_id.requestFocus();
				}
				else {
					Bar_Code_Buscar bcb = new Bar_Code_Buscar();
					bcb.setVisible(true);
					bcb.setFocusable(true);
					bcb.setLocationRelativeTo(null);
				}
			}
		});
		panel.add(btn_buscar);
		
		JButton btn_guardar_imagen = new JButton("GUARDAR IMAGEN");
		btn_guardar_imagen.setFont(new Font("Dialog", Font.BOLD, 13));
		btn_guardar_imagen.setBounds(402, 190, 180, 23);
		panel.add(btn_guardar_imagen);
		
		JButton btn_imprimir = new JButton("IMPRIMIR");
		btn_imprimir.setFont(new Font("Dialog", Font.BOLD, 13));
		btn_imprimir.setBounds(402, 234, 180, 23);
		panel.add(btn_imprimir);
		
		JButton btn_guardar_pdf = new JButton("GUARDAR PDF");
		btn_guardar_pdf.setFont(new Font("Dialog", Font.BOLD, 13));
		btn_guardar_pdf.setBounds(402, 279, 180, 23);
		panel.add(btn_guardar_pdf);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 318, 600, 230);
		panel.add(scrollPane_1);
		
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
		lbl_bar_code.setBounds(180, 44, 234, 108);
		pnl_vista.add(lbl_bar_code);
		
		lbl_cantidad = new JLabel("");
		lbl_cantidad.setFont(new Font("Dialog", Font.BOLD, 13));
		lbl_cantidad.setBorder(new LineBorder(new Color(0, 0, 0)));
		lbl_cantidad.setHorizontalTextPosition(SwingConstants.CENTER);
		lbl_cantidad.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_cantidad.setBounds(180, 163, 111, 28);
		pnl_vista.add(lbl_cantidad);
		
		lbl_precio = new JLabel("");
		lbl_precio.setFont(new Font("Dialog", Font.BOLD, 13));
		lbl_precio.setHorizontalTextPosition(SwingConstants.CENTER);
		lbl_precio.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_precio.setBorder(new LineBorder(new Color(0, 0, 0)));
		lbl_precio.setBounds(301, 163, 113, 28);
		pnl_vista.add(lbl_precio);
	}
}
