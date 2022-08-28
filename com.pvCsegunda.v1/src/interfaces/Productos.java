package interfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

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

public class Productos extends JFrame {
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
	private JTextField txt_id;
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
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Productos frame = new Productos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public void Limpiar_Campos() {
		txt_producto.setText("");
		txt_distintivo_1.setText("");
		//txt_atributos_produccion.setText("");
		txt_stock.setText("");
		txt_precio_de_venta.setText("");
		txt_precio_de_compra.setText("");
		txt_notas_a_cerca_del_producto.setText("");
	}
	
	public Productos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1089, 681);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(198, 144, 125));
		panel.setBounds(0, 11, 1073, 631);
		contentPane.add(panel);
		
		JButton btn_regresar = new JButton("");
		btn_regresar.setBounds(0, 0, 44, 35);
		btn_regresar.setIcon(new ImageIcon(Productos.class.getResource("/imagenes/flecha.png")));
		
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
		panel.setLayout(null);
		panel.add(btn_regresar);
		
		JLabel lbl_fecha_inicial = new JLabel("FECHA INICIAL");
		lbl_fecha_inicial.setBounds(297, 501, 135, 32);
		lbl_fecha_inicial.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_fecha_inicial.setFont(new Font("Dialog", Font.BOLD, 13));
		panel.add(lbl_fecha_inicial);
		
		JLabel lbl_fecha_final = new JLabel("FECHA FINAL");
		lbl_fecha_final.setBounds(579, 501, 135, 32);
		lbl_fecha_final.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_fecha_final.setFont(new Font("Dialog", Font.BOLD, 13));
		panel.add(lbl_fecha_final);
		
		JLabel lbl_calendario = new JLabel("");
		lbl_calendario.setBounds(442, 501, 76, 60);
		lbl_calendario.setIcon(new ImageIcon(Productos.class.getResource("/imagenes/calendario.png")));
		lbl_calendario.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lbl_calendario);
		
		JLabel lbl_calendario_1 = new JLabel("");
		lbl_calendario_1.setBounds(724, 501, 76, 60);
		lbl_calendario_1.setIcon(new ImageIcon(Productos.class.getResource("/imagenes/calendario.png")));
		lbl_calendario_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lbl_calendario_1);
		
		JButton btn_ver_movimientos = new JButton("VER MOVIMIENTOS");
		btn_ver_movimientos.setBounds(461, 590, 161, 23);
		btn_ver_movimientos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				 spinnerTimeInicial = formater.format(spinner_tiempo_inicial.getValue());
				
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				 spinnerTimefinal = formater.format(spinner_tiempo_limite.getValue());
				
				Productos_Tabla_Ver_Movimientos movimientos = new Productos_Tabla_Ver_Movimientos();
				System.out.println(spinnerTimeInicial + spinnerTimefinal);
			movimientos.ver_datos(spinnerTimeInicial, spinnerTimefinal);
				movimientos.setVisible(true);
			
			}
		});
		btn_ver_movimientos.setFont(new Font("Dialog", Font.BOLD, 13));
		
		/*btn_ver_movimientos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!txt_fecha_inicial.getText().equals("") && !txt_fecha_inicial.getText().equals("")) {
					Productos_Tabla_Ver_Movimientos p = new Productos_Tabla_Ver_Movimientos();
					p.setVisible(true);
					p.setLocationRelativeTo(null);
					p.setFocusable(true);
					
				}else {
					JOptionPane.showMessageDialog(null,"SELECCIONA UN RANGO DE FECHAS");
				}
			}
		});*/
		panel.add(btn_ver_movimientos);
		
		JButton btn_añadir = new JButton("AÑADIR");
		btn_añadir.setBounds(34, 121, 156, 23);
		btn_añadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			
			
			}
		});
		btn_añadir.setFont(new Font("Dialog", Font.BOLD, 13));
		
		btn_añadir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			Object datosDB[] = new Object[18];
							datosDB[0] = txt_id.getText();
							datosDB[1] = txt_producto.getText();
							datosDB[2] = txt_distintivo_1.getText();
							datosDB[3] = txt_notas_a_cerca_del_producto.getText();
							datosDB[4] = txt_stock.getText();
							datosDB[5] = txt_kilos.getText();
							datosDB[6] = txt_cm.getText();
							datosDB[7] = txt_mililitros.getText();
							datosDB[8] = txt_color.getText();
							datosDB[9] = txt_tamano.getText();
							datosDB[10] =  txt_precio_de_compra.getText();
							datosDB[11] = txt_precio_de_venta.getText();
							datosDB[12] = txt_provedores.getText();
							datosDB[13] = txt_marca.getText();
							datosDB[14] = txt_linea.getText();
							datosDB[15] = txt_categoria.getText();
							datosDB[16] =  txt_usuario.getText();
							datosDB[17] =  txt_notas_de_venta.getText();
							
							try 
							{
								
								DB_productos.anadir(datosDB);
								System.out.println("datos enviados");
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
			
			
							
			}	
		});
		panel.add(btn_añadir);
		
		
		
		JButton btn_buscar = new JButton("BUSCAR");
		btn_buscar.setBounds(34, 169, 156, 23);
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
						  
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
					
				}else {   
				 
					Object datos [] = new Object [17];
					
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
					
					Ventas_Buscar b= new Ventas_Buscar();
					b.setVisible(true);
					b.setFocusable(true);
					b.setLocationRelativeTo(null);
					
				b.ver_datos_productos_like(datos);
				b.ver_datos_evento(txt_id);
		b.addFocusListener((FocusListener) new FocusListener() {

				@Override
				public void focusGained(FocusEvent e) {
					// TODO Auto-generated method stub
					System.out.println("i have the focus");
				}

				@Override
				public void focusLost(FocusEvent e) {
					 Object datos[];
					try {
						if(!txt_id.getText().equals("") ) {
						datos = DB_productos.buscar(Long.parseLong(txt_id.getText()));
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
								  }
						
					} catch (NumberFormatException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}			
					
					
					
				}

		      });
				}
			
				
			
				
			}
		});
		
		panel.add(btn_buscar);
		
		JButton btn_actualizar = new JButton("ACTUALIZAR");
		btn_actualizar.setBounds(34, 217, 156, 23);
		btn_actualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!txt_id.getText().equals("") ) {
	
				
					
					try {
						Object datosDB[] = new Object[18];
						datosDB[0] = txt_id.getText();
						datosDB[1] = txt_producto.getText();
						datosDB[2] = txt_distintivo_1.getText();
						datosDB[3] = txt_notas_a_cerca_del_producto.getText();
						datosDB[4] = txt_stock.getText();
						datosDB[5] = txt_kilos.getText();
						datosDB[6] = txt_cm.getText();
						datosDB[7] = txt_mililitros.getText();
						datosDB[8] = txt_color.getText();
						datosDB[9] = txt_tamano.getText();
						datosDB[10] =  txt_precio_de_compra.getText();
						datosDB[11] = txt_precio_de_venta.getText();
						datosDB[12] = txt_provedores.getText();
						datosDB[13] = txt_marca.getText();
						datosDB[14] = txt_linea.getText();
						datosDB[15] = txt_categoria.getText();
						datosDB[16] =  txt_usuario.getText();
						datosDB[17] =  txt_notas_de_venta.getText();
						DB_productos.actualizar(datosDB);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					System.out.println("datos enviados");
					
				}
			}	
		});
		btn_actualizar.setFont(new Font("Dialog", Font.BOLD, 13));
		panel.add(btn_actualizar);
		
		JButton btn_eliminar = new JButton("ELIMINAR");
		btn_eliminar.setBounds(34, 266, 156, 23);
		btn_eliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					DB_productos.eliminar(txt_usuario.getText(), Long.parseLong(txt_id.getText()));
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btn_eliminar.setFont(new Font("Dialog", Font.BOLD, 13));
		panel.add(btn_eliminar);
		
		JButton btn_limpiar_campos = new JButton("LIMPIAR CAMPOS");
		btn_limpiar_campos.setBounds(34, 313, 156, 23);
		btn_limpiar_campos.setFont(new Font("Dialog", Font.BOLD, 13));
		
		btn_limpiar_campos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
			}
		});
		panel.add(btn_limpiar_campos);
		
		JLabel lbl_distintivo1 = new JLabel("DISTINTIVO 1");
		lbl_distintivo1.setBounds(490, 30, 227, 23);
		lbl_distintivo1.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_distintivo1.setFont(new Font("Dialog", Font.BOLD, 13));
		panel.add(lbl_distintivo1);
		
		JLabel notas_a_cerca_del_producto = new JLabel("<html><center>distintivo2</center></html>");
		notas_a_cerca_del_producto.setBounds(777, 30, 217, 20);
		notas_a_cerca_del_producto.setHorizontalAlignment(SwingConstants.CENTER);
		notas_a_cerca_del_producto.setFont(new Font("Dialog", Font.BOLD, 13));
		panel.add(notas_a_cerca_del_producto);
		
		txt_notas_a_cerca_del_producto = new JTextField();
		txt_notas_a_cerca_del_producto.setBounds(777, 64, 218, 23);
		txt_notas_a_cerca_del_producto.setFont(new Font("Dialog", Font.BOLD, 12));
		txt_notas_a_cerca_del_producto.setColumns(10);
		panel.add(txt_notas_a_cerca_del_producto);
		
		txt_distintivo_1 = new JTextField();
		txt_distintivo_1.setBounds(490, 64, 227, 23);
		txt_distintivo_1.setFont(new Font("Dialog", Font.BOLD, 12));
		txt_distintivo_1.setColumns(10);
		panel.add(txt_distintivo_1);
		
		JLabel lbl_atributos_basicos = new JLabel("<html><center>ATRIBUTOS PRODUCCION </center></html>");
		lbl_atributos_basicos.setBounds(490, 201, 189, 23);
		lbl_atributos_basicos.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_atributos_basicos.setFont(new Font("Dialog", Font.BOLD, 13));
		panel.add(lbl_atributos_basicos);
		
		cbx_atributos_produccion = new JComboBox();
		cbx_atributos_produccion.setBounds(245, 223, 167, 23);
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
					
				}
				
			}
			
		});
		panel.add(cbx_atributos_produccion);
		
		JButton btn_limpiar_atributos_de_contenido = new JButton("");
		btn_limpiar_atributos_de_contenido.setBounds(568, 406, 33, 32);
		btn_limpiar_atributos_de_contenido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_limpiar_atributos_de_contenido.setIcon(new ImageIcon(Productos.class.getResource("/imagenes/limpiar.png")));
		
		btn_limpiar_atributos_de_contenido.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cbx_atributos_produccion.setSelectedIndex(0);
				limpia_campos_atributos_produccion();
			}
		});
		panel.add(btn_limpiar_atributos_de_contenido);
		
		txt_stock = new JTextField();
		txt_stock.setBounds(245, 146, 167, 23);
		txt_stock.setFont(new Font("Dialog", Font.BOLD, 12));
		txt_stock.setColumns(10);
		panel.add(txt_stock);
		
		JLabel lbl_stock = new JLabel("STOCK");
		lbl_stock.setBounds(243, 122, 113, 20);
		lbl_stock.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_stock.setFont(new Font("Dialog", Font.BOLD, 13));
		panel.add(lbl_stock);
		
		JLabel lbl_precio_de_venta = new JLabel("PRECIO DE VENTA");
		lbl_precio_de_venta.setBounds(490, 121, 140, 20);
		lbl_precio_de_venta.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_precio_de_venta.setFont(new Font("Dialog", Font.BOLD, 13));
		panel.add(lbl_precio_de_venta);
		
		txt_precio_de_venta = new JTextField();
		txt_precio_de_venta.setBounds(490, 146, 227, 23);
		txt_precio_de_venta.setFont(new Font("Dialog", Font.BOLD, 12));
		txt_precio_de_venta.setColumns(10);
		panel.add(txt_precio_de_venta);
		
		JLabel lbl_precio_de_compra = new JLabel("PRECIO DE COMPRA");
		lbl_precio_de_compra.setBounds(777, 115, 140, 32);
		lbl_precio_de_compra.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_precio_de_compra.setFont(new Font("Dialog", Font.BOLD, 13));
		panel.add(lbl_precio_de_compra);
		
		txt_precio_de_compra = new JTextField();
		txt_precio_de_compra.setBounds(777, 146, 217, 23);
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
		
		
		JButton btn_generar_qr = new JButton("");
		btn_generar_qr.setBounds(195, 52, 40, 35);
		btn_generar_qr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txt_id.setText(generar_contraseña());
			}
		});
		btn_generar_qr.setIcon(new ImageIcon(Productos.class.getResource("/imagenes/actualizar.png")));
		btn_generar_qr.setFont(new Font("Dialog", Font.BOLD, 13));
		
	
		panel.add(btn_generar_qr);
		
		JLabel lbl_producto = new JLabel("PRODUCTO");
		lbl_producto.setBounds(243, 31, 167, 21);
		lbl_producto.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_producto.setFont(new Font("Dialog", Font.BOLD, 13));
		panel.add(lbl_producto);
		
		txt_producto = new JTextField();
		txt_producto.setBounds(245, 64, 167, 23);
		txt_producto.setFont(new Font("Dialog", Font.BOLD, 12));
		txt_producto.setColumns(10);
		panel.add(txt_producto);
		
		JLabel lbl_detalles = new JLabel("<html><center>DETALLES FISICOS</center></html>");
		lbl_detalles.setBounds(245, 201, 167, 23);
		lbl_detalles.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_detalles.setFont(new Font("Dialog", Font.BOLD, 13));
		panel.add(lbl_detalles);
		
		JButton btn_limpiar_atributos_de_contenido_1 = new JButton("");
		btn_limpiar_atributos_de_contenido_1.setBounds(336, 406, 33, 32);
		btn_limpiar_atributos_de_contenido_1.setIcon(new ImageIcon(Productos.class.getResource("/imagenes/limpiar.png")));
		btn_limpiar_atributos_de_contenido_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			limpia_campos_detalles_fisicos();
			}
		});
		panel.add(btn_limpiar_atributos_de_contenido_1);
		
		JButton btn_ver_atributos = new JButton("VER ATRIBUTOS");
		btn_ver_atributos.setBounds(490, 223, 189, 23);
		btn_ver_atributos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Productos_Tabla_Buscar interfaz_busqueda = new Productos_Tabla_Buscar();
				interfaz_busqueda.setVisible(true);
			}
		});
		btn_ver_atributos.setFont(new Font("Dialog", Font.BOLD, 13));
		panel.add(btn_ver_atributos);
		
		txt_marca = new JTextField();
		txt_marca.setBounds(490, 255, 189, 20);
		panel.add(txt_marca);
		txt_marca.setColumns(10);
		
		txt_linea = new JTextField();
		txt_linea.setBounds(490, 286, 189, 20);
		txt_linea.setColumns(10);
		panel.add(txt_linea);
		
		txt_categoria = new JTextField();
		txt_categoria.setBounds(490, 313, 189, 20);
		txt_categoria.setColumns(10);
		panel.add(txt_categoria);
		
		txt_provedores = new JTextField();
		txt_provedores.setBounds(490, 344, 189, 20);
		txt_provedores.setColumns(10);
		panel.add(txt_provedores);
		
		txt_color = new JTextField();
		txt_color.setBounds(295, 344, 117, 20);
		txt_color.setColumns(10);
		panel.add(txt_color);
		
		txt_mililitros = new JTextField();
		txt_mililitros.setBounds(295, 313, 117, 20);
		txt_mililitros.setColumns(10);
		panel.add(txt_mililitros);
		
		txt_cm = new JTextField();
		txt_cm.setBounds(295, 286, 117, 20);
		txt_cm.setColumns(10);
		panel.add(txt_cm);
		
		txt_kilos = new JTextField();
		txt_kilos.setBounds(295, 255, 117, 20);
		txt_kilos.setColumns(10);
		panel.add(txt_kilos);
		
		txt_tamano = new JTextField();
		txt_tamano.setBounds(295, 375, 117, 20);
				txt_tamano.setColumns(10);
		panel.add(txt_tamano);
		
		JLabel lblNewLabel = new JLabel("KG");
		lblNewLabel.setBounds(231, 258, 60, 14);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel);
		
		JLabel lblCm = new JLabel("CM");
		lblCm.setBounds(231, 289, 60, 14);
		lblCm.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblCm);
		
		JLabel lblMl = new JLabel("ML");
		lblMl.setBounds(231, 316, 60, 14);
		lblMl.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblMl);
		
		JLabel lblColor = new JLabel("COLOR");
		lblColor.setBounds(231, 347, 60, 14);
		lblColor.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblColor);
		
		JLabel lblTamao = new JLabel("TAMAÑO");
		lblTamao.setBounds(231, 378, 60, 14);
		lblTamao.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblTamao);
		
		txt_usuario = new JTextField();
		txt_usuario.setBounds(490, 375, 189, 20);
		txt_usuario.setColumns(10);
		panel.add(txt_usuario);
		








		spinner_tiempo_inicial = new JSpinner(new SpinnerDateModel());
		spinner_tiempo_inicial.setBounds(281, 542, 151, 20);
		spinner_tiempo_inicial.setEditor(new JSpinner.DateEditor(spinner_tiempo_inicial, "yyyy-MM-dd HH:mm:ss"));
		
	
		
		panel.add(spinner_tiempo_inicial);
 
		
		
		
		 spinner_tiempo_limite = new JSpinner(new SpinnerDateModel());
		 spinner_tiempo_limite.setBounds(563, 541, 151, 20);
		
		spinner_tiempo_limite.setEditor(new JSpinner.DateEditor(spinner_tiempo_limite, "yyyy-MM-dd HH:mm:ss"));
		
	
		
		
		panel.add(spinner_tiempo_limite);
		
		JLabel lbl_notas_venta = new JLabel("<html><center>Notas de venta </center></html>");
		lbl_notas_venta.setBounds(777, 201, 189, 23);
		lbl_notas_venta.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_notas_venta.setFont(new Font("Dialog", Font.BOLD, 13));
		panel.add(lbl_notas_venta);
		
		txt_notas_de_venta = new JTextField();
		txt_notas_de_venta.setBounds(777, 225, 217, 23);
		txt_notas_de_venta.setFont(new Font("Dialog", Font.BOLD, 12));
		txt_notas_de_venta.setColumns(10);
		panel.add(txt_notas_de_venta);
	
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
	for(int i =0 ; i < 13 ; i++) {
	int numero =  (int) Math.abs(Math.random()*10);


	pas += String.valueOf(numero);	



	}
	return pas;
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
