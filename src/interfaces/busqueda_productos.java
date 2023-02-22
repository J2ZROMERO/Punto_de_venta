package interfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import com.itextpdf.text.log.SysoCounter;

import conexionDB.DB_productos;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.JobAttributes;

import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import java.awt.Color;
import java.awt.event.WindowFocusListener;
import javax.swing.SpinnerModel;

public class busqueda_productos extends JFrame {
private 	String spinnerTimeInicial ;
private String spinnerTimefinal;
private JSpinner spinner_tiempo_inicial;
private JSpinner spinner_tiempo_limite;
	private JPanel contentPane;
	private JTextField txt_notas_a_cerca_del_producto;
	private JTextField txt_distintivo_1;
	private JTextField txt_stock;
	private JTextField txt_precio_de_venta;
	private JTextField txt_precio_de_compra;
	public JTextField txt_id;
	private JTextField txt_producto;
	private JTextField txt_tamano;
	private JComboBox cbx_atributos_produccion;
	private static JTextField txt_marca;
	private static JTextField txt_linea;
	private static JTextField txt_categoria;
	private static JTextField txt_provedores;
	private JTextField txt_color;
	private JTextField txt_mililitros;
	private JTextField txt_cm;
	private JTextField txt_kilos;
	private JTextField txt_usuario;
	private JTextField txt_notas_de_venta;
	private static busqueda_productos frame;
	private JTextField txt_caducidad;
	private JTextField txt_pv2;
	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new busqueda_productos();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
*/
	/**
	 * Create the frame.
	 */
	public void Limpiar_Campos() {
		cbx_atributos_produccion.setSelectedItem(1);
		txt_id.setText("");
		txt_producto.setText("");
		txt_distintivo_1.setText("");
		txt_notas_a_cerca_del_producto.setText("");
		txt_stock.setText("");
		txt_kilos.setText("");
		txt_cm.setText("");
		txt_mililitros.setText("");
		txt_color.setText("");
		txt_tamano.setText("");
		txt_precio_de_compra.setText("");
		txt_precio_de_venta.setText("");
		txt_provedores.setText("");
		txt_marca.setText("");
		txt_linea.setText("");
		txt_categoria.setText("");
		txt_usuario.setText("");
		txt_notas_de_venta.setText("");
		txt_pv2.setText("");
		txt_caducidad.setText("");
		txt_id.requestFocus();
		
	}
	
	public busqueda_productos() {
	
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		setResizable(false);
		
		setBounds(100, 100, 1122, 591);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(198, 144, 125));
		panel.setBounds(0, 0, 1106, 552);
		contentPane.add(panel);
		
		JButton btn_regresar = new JButton("");
		btn_regresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_regresar.setBounds(0, 0, 44, 35);
		btn_regresar.setIcon(new ImageIcon(busqueda_productos.class.getResource("/imagenes/flecha.png")));
		
		btn_regresar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//Menu_principal mp = new Menu_principal();
				//mp.setVisible(true);
				//mp.setFocusable(true);
				//mp.setLocationRelativeTo(null);
				//dispose();
				Ventas.id_productos = txt_id.getText();
				dispose();
				
				
			
				
			}
		});
		panel.setLayout(null);
		panel.add(btn_regresar);
		
		
		
		JButton btn_buscar = new JButton("BUSCAR");
		btn_buscar.setBounds(341, 465, 156, 23);
		btn_buscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_buscar.setFont(new Font("Dialog", Font.BOLD, 13));
		
		btn_buscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!txt_id.getText().equals("") ) {
					
					
					try {
				
				Object datos []=DB_productos.buscar(Long.parseLong(txt_id.getText()));			
		
				txt_id.setText(datos[0].toString());
				txt_producto.setText(datos[1].toString());
				txt_distintivo_1.setText(datos[2].toString());
								txt_notas_a_cerca_del_producto.setText(datos[3].toString());
						txt_stock.setText(datos[4].toString());
						txt_kilos.setText(datos[5].toString());
						txt_cm.setText(datos[6].toString());
						txt_mililitros.setText(datos[7].toString());
						txt_color.setText(datos[8].toString());
						txt_tamano.setText(datos[9].toString());
						  txt_precio_de_compra.setText(datos[10].toString());
						 txt_precio_de_venta.setText(datos[11].toString());
				
						 txt_provedores.setText(datos[12].toString());
						 txt_marca.setText(datos[13].toString());
						 txt_linea.setText(datos[14].toString());
					 txt_categoria.setText(datos[15].toString());
						  txt_usuario.setText(datos[16].toString());
						  txt_notas_de_venta.setText(datos[17].toString());
						  txt_pv2.setText(datos[18].toString());
						  txt_caducidad.setText(datos[19].toString());
						  
						  
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
					
				}else {   
				 
					Object datos [] = new Object [19];
					
					datos[0] = txt_producto.getText().toString();
					datos[1] = txt_distintivo_1.getText().toString();
					datos[2] = txt_notas_a_cerca_del_producto.getText().toString();
					datos[3] = txt_stock.getText().toString();
					datos[4] = txt_kilos.getText().toString();
					datos[5] = txt_cm.getText().toString();
					datos[6] = txt_mililitros.getText().toString();
					datos[7] = txt_color.getText().toString();
					datos[8] = txt_tamano.getText().toString();
					datos[9] = txt_precio_de_compra.getText().toString();
					datos[10] = txt_precio_de_venta.getText().toString();
					datos[11] = txt_provedores.getText().toString();
					datos[12] = txt_marca.getText().toString();
					datos[13] = txt_linea.getText().toString();
					datos[14] = txt_categoria.getText().toString();
					datos[15] = txt_usuario.getText().toString();
					datos[16] = txt_notas_de_venta.getText().toString();
					datos[17] =   txt_pv2.getText().toString();
					datos[18] =   txt_caducidad.getText().toString();
					  
					Ventas_Buscar b= new Ventas_Buscar();
					b.setVisible(true);
					b.setFocusable(true);
					b.setLocationRelativeTo(null);
					b.ver_datos_productos_like(datos);
					b.ver_datos_evento();

				b.addWindowListener(new WindowAdapter() {
					@Override
					public void windowClosed(WindowEvent e) {
						System.out.println(b.getId());
						Limpiar_Campos();
						txt_id.setText(b.getId());
					}
				});

				}
			
				
			
				
			}
		});
		
		panel.add(btn_buscar);
		

		
		JButton btn_limpiar_campos = new JButton("LIMPIAR CAMPOS");
		btn_limpiar_campos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_limpiar_campos.setBounds(810, 465, 156, 23);
		btn_limpiar_campos.setFont(new Font("Dialog", Font.BOLD, 13));
		
		btn_limpiar_campos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			Limpiar_Campos();
			cbx_atributos_produccion.setSelectedIndex(0);
			}
		});
		panel.add(btn_limpiar_campos);
		
		JLabel lbl_distintivo1 = new JLabel("DISTINTIVO 1");
		lbl_distintivo1.setBounds(35, 191, 227, 23);
		lbl_distintivo1.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_distintivo1.setFont(new Font("Dialog", Font.BOLD, 13));
		panel.add(lbl_distintivo1);
		
		JLabel notas_a_cerca_del_producto = new JLabel("<html><center>distintivo2</center></html>");
		notas_a_cerca_del_producto.setBounds(34, 269, 217, 20);
		notas_a_cerca_del_producto.setHorizontalAlignment(SwingConstants.CENTER);
		notas_a_cerca_del_producto.setFont(new Font("Dialog", Font.BOLD, 13));
		panel.add(notas_a_cerca_del_producto);
		
		txt_notas_a_cerca_del_producto = new JTextField();
		txt_notas_a_cerca_del_producto.setBounds(34, 303, 218, 23);
		txt_notas_a_cerca_del_producto.setFont(new Font("Dialog", Font.BOLD, 12));
		txt_notas_a_cerca_del_producto.setColumns(10);
		panel.add(txt_notas_a_cerca_del_producto);
		
		txt_distintivo_1 = new JTextField();
		txt_distintivo_1.setBounds(35, 225, 227, 23);
		txt_distintivo_1.setFont(new Font("Dialog", Font.BOLD, 12));
		txt_distintivo_1.setColumns(10);
		panel.add(txt_distintivo_1);
		
		JLabel lbl_atributos_basicos = new JLabel("<html><center>ATRIBUTOS PRODUCCION </center></html>");
		lbl_atributos_basicos.setBounds(855, 52, 189, 23);
		lbl_atributos_basicos.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_atributos_basicos.setFont(new Font("Dialog", Font.BOLD, 13));
		panel.add(lbl_atributos_basicos);
		
		cbx_atributos_produccion = new JComboBox();
		cbx_atributos_produccion.setBounds(610, 74, 167, 23);
		cbx_atributos_produccion.setFont(new Font("Dialog", Font.BOLD, 12));
		cbx_atributos_produccion.setModel(new DefaultComboBoxModel(new String[] {"SELECCIONAR",  "KILOGRAMO", "MEDIDA","MILILITROS", "COLOR", "TAMAÑO"}));
		cbx_atributos_produccion.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(e.toString());
				
				if(cbx_atributos_produccion.getSelectedItem().toString().equalsIgnoreCase("kilogramo")){
					txt_kilos.setEnabled(true); 
					txt_cm.setEnabled(false);
					txt_mililitros.setEnabled(false);
					txt_color.setEnabled(false);
					txt_tamano.setEnabled(false);
			 
			
		}
				if(cbx_atributos_produccion.getSelectedItem().toString().equalsIgnoreCase("medida")){
					txt_kilos.setEnabled(false);
					txt_cm.setEnabled(true);
					txt_mililitros.setEnabled(false);
					txt_color.setEnabled(false);
					txt_tamano.setEnabled(false);
			  
					
				}	else	if(cbx_atributos_produccion.getSelectedItem().toString().equalsIgnoreCase("mililitros")){
					txt_kilos.setEnabled(false);
					txt_cm.setEnabled(false);
					txt_mililitros.setEnabled(true);
					txt_color.setEnabled(false);
					txt_tamano.setEnabled(false);
					
				}		else if(cbx_atributos_produccion.getSelectedItem().toString().equalsIgnoreCase("color")){
					txt_kilos.setEnabled(false);
					txt_cm.setEnabled(false);
					txt_mililitros.setEnabled(false);
					txt_color.setEnabled(true);
					txt_tamano.setEnabled(false);
					
				}		else if(cbx_atributos_produccion.getSelectedItem().toString().equalsIgnoreCase("tamaño")){
					txt_kilos.setEnabled(false);
					txt_cm.setEnabled(false);
					txt_mililitros.setEnabled(false);
					txt_color.setEnabled(false);
					txt_tamano.setEnabled(true);
					
				}else if (cbx_atributos_produccion.getSelectedItem().toString().equalsIgnoreCase("SELECCIONAR")){
					txt_kilos.setEnabled(false);
					txt_cm.setEnabled(false);
					txt_mililitros.setEnabled(false);
					txt_color.setEnabled(false);
					txt_tamano.setEnabled(false);
				}
				
			}
			
		});
		panel.add(cbx_atributos_produccion);
		
		JButton btn_limpiar_atributos_de_contenido = new JButton("");
		btn_limpiar_atributos_de_contenido.setBounds(933, 257, 33, 32);
		btn_limpiar_atributos_de_contenido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_limpiar_atributos_de_contenido.setIcon(new ImageIcon(busqueda_productos.class.getResource("/imagenes/limpiar.png")));
		
		btn_limpiar_atributos_de_contenido.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cbx_atributos_produccion.setSelectedIndex(0);
				limpia_campos_atributos_produccion();
			}
		});
		panel.add(btn_limpiar_atributos_de_contenido);
		
		txt_stock = new JTextField();
		txt_stock.setBounds(341, 64, 167, 23);
		txt_stock.setFont(new Font("Dialog", Font.BOLD, 12));
		txt_stock.setColumns(10);
		panel.add(txt_stock);
		
		JLabel lbl_stock = new JLabel("CANTIDAD");
		lbl_stock.setBounds(339, 40, 113, 20);
		lbl_stock.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_stock.setFont(new Font("Dialog", Font.BOLD, 13));
		panel.add(lbl_stock);
		
		JLabel lbl_precio_de_venta = new JLabel("PRECIO DE VENTA");
		lbl_precio_de_venta.setBounds(333, 184, 140, 20);
		lbl_precio_de_venta.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_precio_de_venta.setFont(new Font("Dialog", Font.BOLD, 13));
		panel.add(lbl_precio_de_venta);
		
		txt_precio_de_venta = new JTextField();
		txt_precio_de_venta.setBounds(333, 209, 227, 23);
		txt_precio_de_venta.setFont(new Font("Dialog", Font.BOLD, 12));
		txt_precio_de_venta.setColumns(10);
		panel.add(txt_precio_de_venta);
		
		JLabel lbl_precio_de_compra = new JLabel("PRECIO DE COMPRA");
		lbl_precio_de_compra.setBounds(343, 98, 140, 32);
		lbl_precio_de_compra.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_precio_de_compra.setFont(new Font("Dialog", Font.BOLD, 13));
		panel.add(lbl_precio_de_compra);
		
		txt_precio_de_compra = new JTextField();
		txt_precio_de_compra.setBounds(343, 129, 217, 23);
		txt_precio_de_compra.setFont(new Font("Dialog", Font.BOLD, 12));
		txt_precio_de_compra.setColumns(10);
		panel.add(txt_precio_de_compra);
		
		JLabel lbl_id = new JLabel("ID");
		lbl_id.setBounds(34, 30, 44, 23);
		lbl_id.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_id.setFont(new Font("Dialog", Font.BOLD, 13));
		panel.add(lbl_id);
		
		txt_id = new JTextField();
		txt_id.setBounds(34, 64, 151, 23);
		txt_id.setFont(new Font("Dialog", Font.BOLD, 12));
		txt_id.setColumns(10);
		panel.add(txt_id);
		
		JLabel lbl_producto = new JLabel("PRODUCTO");
		lbl_producto.setBounds(34, 115, 167, 21);
		lbl_producto.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_producto.setFont(new Font("Dialog", Font.BOLD, 13));
		panel.add(lbl_producto);
		
		txt_producto = new JTextField();
		txt_producto.setBounds(36, 148, 167, 23);
		txt_producto.setFont(new Font("Dialog", Font.BOLD, 12));
		txt_producto.setColumns(10);
		panel.add(txt_producto);
		
		JLabel lbl_detalles = new JLabel("<html><center>DETALLES FISICOS</center></html>");
		lbl_detalles.setBounds(610, 52, 167, 23);
		lbl_detalles.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_detalles.setFont(new Font("Dialog", Font.BOLD, 13));
		panel.add(lbl_detalles);
		
		JButton btn_limpiar_atributos_de_contenido_1 = new JButton("");
		btn_limpiar_atributos_de_contenido_1.setBounds(701, 257, 33, 32);
		btn_limpiar_atributos_de_contenido_1.setIcon(new ImageIcon(busqueda_productos.class.getResource("/imagenes/limpiar.png")));
		btn_limpiar_atributos_de_contenido_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			limpia_campos_detalles_fisicos();
			}
		});
		panel.add(btn_limpiar_atributos_de_contenido_1);
		
		JButton btn_ver_atributos = new JButton("VER ATRIBUTOS");
		btn_ver_atributos.setBounds(855, 74, 189, 23);
		btn_ver_atributos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Productos_Tabla_Buscar interfaz_busqueda = new Productos_Tabla_Buscar();
				interfaz_busqueda.setVisible(true);
				interfaz_busqueda.setLocationRelativeTo(null);
				interfaz_busqueda.addWindowFocusListener(new WindowFocusListener() {
					public void windowGainedFocus(WindowEvent e) {
						System.out.println("in the focus the focuss");
					}
					public void windowLostFocus(WindowEvent e) {
					System.out.println("loosing the focuss");
					 txt_marca.setText(interfaz_busqueda.datosMarcas[0]);
					  txt_linea.setText( interfaz_busqueda.datosMarcas[1]);
					 txt_categoria.setText(( interfaz_busqueda.datosMarcas[2])); ;
					 txt_provedores.setText(interfaz_busqueda.datosMarcas[3]);
					
					}
				});
			}
			
		});
		
	
		btn_ver_atributos.setFont(new Font("Dialog", Font.BOLD, 13));
		panel.add(btn_ver_atributos);
		
		txt_marca = new JTextField();
		txt_marca.setBounds(855, 106, 189, 20);
		panel.add(txt_marca);
		txt_marca.setColumns(10);
		
		txt_linea = new JTextField();
		txt_linea.setBounds(855, 137, 189, 20);
		txt_linea.setColumns(10);
		panel.add(txt_linea);
		
		txt_categoria = new JTextField();
		txt_categoria.setBounds(855, 164, 189, 20);
		txt_categoria.setColumns(10);
		panel.add(txt_categoria);
		
		txt_provedores = new JTextField();
		txt_provedores.setBounds(855, 195, 189, 20);
		txt_provedores.setColumns(10);
		panel.add(txt_provedores);
		
		txt_color = new JTextField();
		txt_color.setBounds(660, 195, 117, 20);
		txt_color.setColumns(10);
		panel.add(txt_color);
		
		txt_mililitros = new JTextField();
		txt_mililitros.setBounds(660, 164, 117, 20);
		txt_mililitros.setColumns(10);
		panel.add(txt_mililitros);
		
		txt_cm = new JTextField();
		txt_cm.setBounds(660, 137, 117, 20);
		txt_cm.setColumns(10);
		panel.add(txt_cm);
		
		txt_kilos = new JTextField();
		txt_kilos.setBounds(660, 106, 117, 20);
		txt_kilos.setColumns(10);
		panel.add(txt_kilos);
		
		txt_tamano = new JTextField();
		txt_tamano.setBounds(660, 226, 117, 20);
				txt_tamano.setColumns(10);
		panel.add(txt_tamano);
		
		JLabel lblNewLabel = new JLabel("KG");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 12));
		lblNewLabel.setBounds(583, 109, 73, 14);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel);
		
		JLabel lblCm = new JLabel("CM");
		lblCm.setFont(new Font("Dialog", Font.BOLD, 12));
		lblCm.setBounds(583, 140, 73, 14);
		lblCm.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblCm);
		
		JLabel lblMl = new JLabel("ML");
		lblMl.setFont(new Font("Dialog", Font.BOLD, 12));
		lblMl.setBounds(583, 167, 73, 14);
		lblMl.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblMl);
		
		JLabel lblColor = new JLabel("COLOR");
		lblColor.setFont(new Font("Dialog", Font.BOLD, 12));
		lblColor.setBounds(583, 198, 73, 14);
		lblColor.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblColor);
		
		JLabel lblTamao = new JLabel("TAMAÑO");
		lblTamao.setFont(new Font("Dialog", Font.BOLD, 12));
		lblTamao.setBounds(583, 229, 73, 14);
		lblTamao.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblTamao);
		
		txt_usuario = new JTextField();
		txt_usuario.setBounds(855, 226, 189, 20);
		txt_usuario.setColumns(10);
		panel.add(txt_usuario);
		








		spinner_tiempo_inicial = new JSpinner(new SpinnerDateModel());
		spinner_tiempo_inicial.setBounds(281, 542, 151, 20);
		spinner_tiempo_inicial.setEditor(new JSpinner.DateEditor(spinner_tiempo_inicial, "yyyy-MM-dd HH:mm:ss"));
		
	
		
		
 
		
		
		
		 spinner_tiempo_limite = new JSpinner(new SpinnerDateModel());
		 spinner_tiempo_limite.setBounds(563, 541, 151, 20);
		
		spinner_tiempo_limite.setEditor(new JSpinner.DateEditor(spinner_tiempo_limite, "yyyy-MM-dd HH:mm:ss"));
		
	
		
		
		
		
		JLabel lbl_notas_venta = new JLabel("<html><center>Notas de venta </center></html>");
		lbl_notas_venta.setBounds(35, 356, 189, 23);
		lbl_notas_venta.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_notas_venta.setFont(new Font("Dialog", Font.BOLD, 13));
		panel.add(lbl_notas_venta);
		
		txt_notas_de_venta = new JTextField();
		txt_notas_de_venta.setBounds(35, 380, 217, 23);
		txt_notas_de_venta.setFont(new Font("Dialog", Font.BOLD, 12));
		txt_notas_de_venta.setColumns(10);
		panel.add(txt_notas_de_venta);
		
		JButton btn_encontrado = new JButton("ENCONTRADO");
		btn_encontrado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_encontrado.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//Menu_principal mp = new Menu_principal();
				//mp.setVisible(true);
				//mp.setFocusable(true);
				//mp.setLocationRelativeTo(null);
				//dispose();
				Ventas.id_productos = txt_id.getText();
				dispose();
				
				
			
				
			}
		});
		
		btn_encontrado.setFont(new Font("Dialog", Font.BOLD, 13));
		btn_encontrado.setBounds(567, 465, 156, 23);
		panel.add(btn_encontrado);
		
		JLabel lbl_caducidad = new JLabel("CADUCIDAD");
		lbl_caducidad.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_caducidad.setFont(new Font("Dialog", Font.BOLD, 13));
		lbl_caducidad.setBounds(342, 346, 217, 23);
		panel.add(lbl_caducidad);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(101, 494, -346, -203);
		panel.add(lblNewLabel_1);
		
		txt_caducidad = new JTextField();
		txt_caducidad.setEditable(false);
		txt_caducidad.setFont(new Font("Dialog", Font.BOLD, 12));
		txt_caducidad.setColumns(10);
		txt_caducidad.setBounds(341, 380, 217, 23);
		panel.add(txt_caducidad);
		
		txt_pv2 = new JTextField();
		txt_pv2.setFont(new Font("Dialog", Font.BOLD, 12));
		txt_pv2.setColumns(10);
		txt_pv2.setBounds(333, 303, 227, 23);
		panel.add(txt_pv2);
		
		JLabel lbl_precio_de_venta_1 = new JLabel("PRECIO DE VENTA 2");
		lbl_precio_de_venta_1.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_precio_de_venta_1.setFont(new Font("Dialog", Font.BOLD, 13));
		lbl_precio_de_venta_1.setBounds(333, 278, 140, 20);
		panel.add(lbl_precio_de_venta_1);
	
	}
	
	
	public static void impresion_atributos(String marca,String linea,String categoria,String provedores) {
		
		txt_marca.setText(marca);
		txt_linea.setText(linea);
		txt_categoria.setText(categoria);
		txt_provedores.setText(provedores);
	}
	
	public static JTextField[] bloquear_campos() {
		JTextField campos[] =new JTextField[4];
		campos[0] = txt_marca;
		campos[1] = txt_linea;
		campos[2] = txt_categoria;
		campos[3] = txt_provedores;
		return  campos;
	}
	public  String generar_contraseña() {

		String pas = "";
		boolean id_similar = false;
		
		do {
			
			
			for(int i =0 ; i < 13 ; i++) {
				int numero =  (int) Math.abs(Math.random()*10);


				pas += String.valueOf(numero);	



				}
				
				long cast_id =  Long.parseLong(pas);
				try {
					
					
					if(DB_productos.compara_id(cast_id) == true) {
						id_similar = true;
					}else {
						id_similar = false;
					}
						

					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
							
			
		}while(id_similar != false);
		
		
		

	
	return String.valueOf(pas);
	}
	private void limpia_campos_detalles_fisicos() {
		txt_kilos.setText("");
		txt_cm.setText("");
		txt_mililitros.setText("");
		txt_color.setText("");
		txt_tamano.setText("");
	}
private void limpia_campos_atributos_produccion() {
	txt_marca.setText("");
	txt_linea.setText("");
	txt_categoria.setText("");
	txt_provedores.setText("");
	txt_usuario.setText("");
	}
}
