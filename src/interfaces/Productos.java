package interfaces;
import java.util.Date;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import conexionDB.DB_productos;
import metodos_externos_necesarios.Metodos_numericos;

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
import java.awt.event.WindowFocusListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.SpinnerModel;
import javax.swing.JCheckBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class Productos extends JFrame {
	private JSpinner spinner_caducidad = new JSpinner(new SpinnerDateModel());
	private JCheckBox ckb_pza;
	private JCheckBox ckb_kg;
	private JCheckBox ckb_cm;
	private 	String spinnerTimeInicial ;
	private String spinnerTimefinal;
	private String spinnerCaducidad;
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
	private JTextField txt_notas_de_venta;
	public static String id_productos;	
	public static Productos frame;

	//variables de alertas
	private JLabel lbl_alerta_1;
	private JLabel lbl_alerta_2;
	private JLabel lbl_alerta_3;
	private JLabel lbl_alerta_4;
	private JLabel lbl_alerta_5;
	private JLabel lbl_alerta_6;
	private JLabel lbl_alerta_7;
	private JLabel lbl_alerta_8;
	private JTextField txt_pv2;

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Productos();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */

	public void Validar_Campos() {
		if(!"".equals(txt_id.getText())) {
			lbl_alerta_1.setForeground(new Color(82, 190, 128));
		}else {
			lbl_alerta_1.setForeground(new Color(0,0,0));
		}

		if(!"".equals(txt_producto.getText())) {
			lbl_alerta_2.setForeground(new Color(82, 190, 128));
		}else {
			lbl_alerta_2.setForeground(new Color(0,0,0));
		}

		//TIPO
		if(!"".equals(txt_distintivo_1.getText())) {
			lbl_alerta_3.setForeground(new Color(82, 190, 128));
		}else {
			lbl_alerta_3.setForeground(new Color(0,0,0));
		}

		if(!"".equals(txt_stock.getText())) {
			lbl_alerta_4.setForeground(new Color(82, 190, 128));
		}else {
			lbl_alerta_4.setForeground(new Color(0,0,0));
		}

		if(!"".equals(txt_precio_de_compra.getText())) {
			lbl_alerta_6.setForeground(new Color(82, 190, 128));
		}else {
			lbl_alerta_6.setForeground(new Color(0,0,0));
		}

		if(!"".equals(txt_precio_de_venta.getText())) {
			lbl_alerta_5.setForeground(new Color(82, 190, 128));
		}else {
			lbl_alerta_5.setForeground(new Color(0,0,0));
		}

		if(!"".equals(spinner_tiempo_inicial.getValue())) {
			lbl_alerta_7.setForeground(new Color(82, 190, 128));
		}else {
			lbl_alerta_7.setForeground(new Color(0,0,0));
		}

		if(!"".equals(spinner_tiempo_limite.getValue())) {
			lbl_alerta_8.setForeground(new Color(82, 190, 128));
		}else {
			lbl_alerta_8.setForeground(new Color(0,0,0));
		}

	}

	public Productos() {
		setLocationRelativeTo(null);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				txt_id.requestFocus();
				txt_kilos.setEnabled(true); 
				txt_cm.setEnabled(false);
				txt_mililitros.setEnabled(false);
				txt_color.setEnabled(false);
				txt_tamano.setEnabled(false);
				txt_kilos.setEnabled(false);
			}
		});
		setResizable(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 1362, 681);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(82, 190, 128));
		panel.setBounds(10, 11, 1336, 642);
		contentPane.add(panel);

		JButton btn_regresar = new JButton("");
		btn_regresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
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
		lbl_fecha_inicial.setBounds(1051, 30, 151, 32);
		lbl_fecha_inicial.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_fecha_inicial.setFont(new Font("Dialog", Font.BOLD, 13));
		panel.add(lbl_fecha_inicial);

		JLabel lbl_fecha_final = new JLabel("FECHA FINAL");
		lbl_fecha_final.setBounds(1051, 121, 151, 32);
		lbl_fecha_final.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_fecha_final.setFont(new Font("Dialog", Font.BOLD, 13));
		panel.add(lbl_fecha_final);

		JLabel lbl_calendario = new JLabel("");
		lbl_calendario.setBounds(1212, 30, 76, 60);
		lbl_calendario.setIcon(new ImageIcon(Productos.class.getResource("/imagenes/calendario.png")));
		lbl_calendario.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lbl_calendario);

		JLabel lbl_calendario_1 = new JLabel("");
		lbl_calendario_1.setBounds(1212, 121, 76, 60);
		lbl_calendario_1.setIcon(new ImageIcon(Productos.class.getResource("/imagenes/calendario.png")));
		lbl_calendario_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lbl_calendario_1);

		JButton btn_ver_movimientos = new JButton("VER MOVIMIENTOS");
		btn_ver_movimientos.setBounds(1023, 234, 253, 38);
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
				movimientos.setLocationRelativeTo(null);
				//frame.requestFocus();
			}
		});
		btn_ver_movimientos.setFont(new Font("Tahoma", Font.BOLD, 20));

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

		JButton btn_añadir = new JButton("");
		btn_añadir.setIcon(new ImageIcon(Productos.class.getResource("/imagenes/anadir.png")));

		panel.add(btn_añadir);



		JButton btn_buscar = new JButton("");
		btn_buscar.setIcon(new ImageIcon(Productos.class.getResource("/imagenes/buscar_tabla.png")));
		
		btn_buscar.setBounds(245, 52, 46, 35);
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
						txt_notas_de_venta.setText(datos[17].toString());
						
						txt_pv2.setText(datos[18].toString());
						
						if(datos[19].toString().equalsIgnoreCase("")) {
							spinner_caducidad.setEditor(new JSpinner.DateEditor(spinner_tiempo_limite, "yyyy-MM-dd"));
						}else {
							spinner_caducidad.setEditor(convertData(datos[19].toString()));							
						}		
						
						
						if(!datos[20].toString().equals("")) {
						switch (datos[20].toString()){
						case "CM":
							ckb_cm.setSelected(true);
							break;
						case "GRM":
							ckb_kg.setSelected(true);
							
							break;
						case "PZA":
							ckb_pza.setSelected(true);
							break;
						}
						}else {
							ckb_pza.setSelected(false);
							ckb_kg.setSelected(false);
							ckb_cm.setSelected(false);
						}
						
						
						Validar_Campos();	  
					} catch (NumberFormatException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}else {   
					busqueda_productos busca_productos = new busqueda_productos();
					busca_productos.setVisible(true);
					busca_productos.setLocationRelativeTo(null);

					busca_productos.addWindowFocusListener(new WindowFocusListener() {
						public void windowGainedFocus(WindowEvent e) {
						}
						public void windowLostFocus(WindowEvent e) {
							txt_id.setText(id_productos);
							txt_id.setText(busca_productos.txt_id.getText());

						}
					});

				}

			}
		});


















		panel.add(btn_buscar);

		JButton btn_actualizar = new JButton("");
		btn_actualizar.setIcon(new ImageIcon(Productos.class.getResource("/imagenes/actualizar.png")));
		btn_actualizar.setBounds(623, 519, 51, 38);
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
						datosDB[16] =  Menu_principal.nombre_usuario;
						datosDB[17] =  txt_notas_de_venta.getText();
						DB_productos.actualizar(datosDB);
						Validar_Campos();
						Limpiar_Campos();
						JOptionPane.showMessageDialog(null, "DATOS ACTUALIZADOS");
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}


				}else {
					Validar_Campos();
				}
			}	
		});
		btn_actualizar.setFont(new Font("Dialog", Font.BOLD, 13));
		panel.add(btn_actualizar);

		JButton btn_eliminar = new JButton("");
		btn_eliminar.setIcon(new ImageIcon(Productos.class.getResource("/imagenes/basura.png")));
		btn_eliminar.setBounds(739, 521, 59, 36);
		btn_eliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					if(!txt_id.getText().equalsIgnoreCase("")) {

						DB_productos.eliminar(Menu_principal.nombre_usuario, Long.parseLong(txt_id.getText()));

						Limpiar_Campos();
						cbx_atributos_produccion.setSelectedIndex(0);
						JOptionPane.showMessageDialog(null,"PRODUCTO ELIMINADO");
					}else {
						JOptionPane.showMessageDialog(null,"BUSCA EL PRODUCTO A ELIMINAR");
					}

				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					Validar_Campos();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					Validar_Campos();
				}
			}
		});
		btn_eliminar.setFont(new Font("Dialog", Font.BOLD, 13));
		panel.add(btn_eliminar);

		JButton btn_limpiar_campos = new JButton("");
		btn_limpiar_campos.setIcon(new ImageIcon(Productos.class.getResource("/imagenes/limpiar.png")));
		btn_limpiar_campos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_limpiar_campos.setBounds(828, 520, 51, 37);
		btn_limpiar_campos.setFont(new Font("Dialog", Font.BOLD, 13));

		btn_limpiar_campos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Limpiar_Campos();
				cbx_atributos_produccion.setSelectedIndex(0);
				Validar_Campos();
			}
		});
		panel.add(btn_limpiar_campos);

		JLabel lbl_distintivo1 = new JLabel("DISTINTIVO 1");
		lbl_distintivo1.setBounds(34, 266, 227, 23);
		lbl_distintivo1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_distintivo1.setFont(new Font("Dialog", Font.BOLD, 13));
		panel.add(lbl_distintivo1);

		JLabel notas_a_cerca_del_producto = new JLabel("<html><center>DISTINTIVO 2</center></html>");
		notas_a_cerca_del_producto.setBounds(34, 351, 217, 20);
		notas_a_cerca_del_producto.setHorizontalAlignment(SwingConstants.CENTER);
		notas_a_cerca_del_producto.setFont(new Font("Dialog", Font.BOLD, 13));
		panel.add(notas_a_cerca_del_producto);

		txt_notas_a_cerca_del_producto = new JTextField();
		txt_notas_a_cerca_del_producto.setBounds(34, 385, 218, 23);
		txt_notas_a_cerca_del_producto.setFont(new Font("Dialog", Font.BOLD, 12));
		txt_notas_a_cerca_del_producto.setColumns(10);
		panel.add(txt_notas_a_cerca_del_producto);

		txt_distintivo_1 = new JTextField();
		txt_distintivo_1.setBounds(34, 300, 217, 23);
		txt_distintivo_1.setFont(new Font("Dialog", Font.BOLD, 12));
		txt_distintivo_1.setColumns(10);

		txt_distintivo_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				Validar_Campos();
			}
		});
		panel.add(txt_distintivo_1);

		JLabel lbl_atributos_basicos = new JLabel("<html><center>ATRIBUTOS PRODUCCION </center></html>");
		lbl_atributos_basicos.setBounds(721, 30, 189, 23);
		lbl_atributos_basicos.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_atributos_basicos.setFont(new Font("Dialog", Font.BOLD, 13));
		panel.add(lbl_atributos_basicos);

		cbx_atributos_produccion = new JComboBox();
		cbx_atributos_produccion.setBounds(507, 68, 167, 23);
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
					txt_kilos.requestFocus();

				}
				if(cbx_atributos_produccion.getSelectedItem().toString().equalsIgnoreCase("medida")){
					txt_kilos.setEnabled(false);
					txt_cm.setEnabled(true);
					txt_mililitros.setEnabled(false);
					txt_color.setEnabled(false);
					txt_tamano.setEnabled(false);
					txt_cm.requestFocus();


				}	else	if(cbx_atributos_produccion.getSelectedItem().toString().equalsIgnoreCase("mililitros")){
					txt_kilos.setEnabled(false);
					txt_cm.setEnabled(false);
					txt_mililitros.setEnabled(true);
					txt_color.setEnabled(false);
					txt_tamano.setEnabled(false);
					txt_mililitros.requestFocus();

				}		else if(cbx_atributos_produccion.getSelectedItem().toString().equalsIgnoreCase("color")){
					txt_kilos.setEnabled(false);
					txt_cm.setEnabled(false);
					txt_mililitros.setEnabled(false);
					txt_color.setEnabled(true);
					txt_tamano.setEnabled(false);
					txt_color.requestFocus();

				}		else if(cbx_atributos_produccion.getSelectedItem().toString().equalsIgnoreCase("tamaño")){
					txt_kilos.setEnabled(false);
					txt_cm.setEnabled(false);
					txt_mililitros.setEnabled(false);
					txt_color.setEnabled(false);
					txt_tamano.setEnabled(true);
					txt_tamano.requestFocus();

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
		btn_limpiar_atributos_de_contenido.setBounds(798, 204, 33, 32);
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
		txt_stock.setBounds(322, 68, 117, 23);
		txt_stock.setFont(new Font("Dialog", Font.BOLD, 12));
		txt_stock.setColumns(10);

		txt_stock.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				Validar_Campos();
			}
		});
		panel.add(txt_stock);

		JLabel lbl_stock = new JLabel("CANTIDAD");
		lbl_stock.setBounds(330, 30, 110, 20);
		lbl_stock.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_stock.setFont(new Font("Dialog", Font.BOLD, 13));
		panel.add(lbl_stock);

		JLabel lbl_precio_de_venta = new JLabel("PRECIO DE VENTA");
		lbl_precio_de_venta.setBounds(287, 215, 183, 20);
		lbl_precio_de_venta.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_precio_de_venta.setFont(new Font("Dialog", Font.BOLD, 13));
		panel.add(lbl_precio_de_venta);

		txt_precio_de_venta = new JTextField();
		txt_precio_de_venta.setBounds(320, 245, 117, 23);
		txt_precio_de_venta.setFont(new Font("Dialog", Font.BOLD, 12));
		txt_precio_de_venta.setColumns(10);

		txt_precio_de_venta.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				Validar_Campos();
			}
		});
		panel.add(txt_precio_de_venta);

		JLabel lbl_precio_de_compra = new JLabel("PRECIO DE COMPRA");
		lbl_precio_de_compra.setBounds(292, 121, 175, 32);
		lbl_precio_de_compra.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_precio_de_compra.setFont(new Font("Dialog", Font.BOLD, 13));
		panel.add(lbl_precio_de_compra);

		txt_precio_de_compra = new JTextField();
		txt_precio_de_compra.setBounds(321, 153, 117, 23);
		txt_precio_de_compra.setFont(new Font("Dialog", Font.BOLD, 12));
		txt_precio_de_compra.setColumns(10);

		txt_precio_de_compra.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				Validar_Campos();
			}
		});
		panel.add(txt_precio_de_compra);

		JLabel lbl_id = new JLabel("ID");
		lbl_id.setBounds(34, 30, 151, 23);
		lbl_id.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_id.setFont(new Font("Dialog", Font.BOLD, 13));
		panel.add(lbl_id);

		txt_id = new JTextField();
		txt_id.setBounds(34, 64, 151, 23);
		txt_id.setFont(new Font("Dialog", Font.BOLD, 12));
		txt_id.setColumns(10);

		txt_id.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				Validar_Campos();
			}
		});
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
		lbl_producto.setBounds(61, 121, 167, 21);
		lbl_producto.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_producto.setFont(new Font("Dialog", Font.BOLD, 13));
		panel.add(lbl_producto);

		txt_producto = new JTextField();
		txt_producto.setBounds(36, 154, 215, 23);
		txt_producto.setFont(new Font("Dialog", Font.BOLD, 12));
		txt_producto.setColumns(10);

		txt_producto.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				Validar_Campos();
			}
		});
		panel.add(txt_producto);

		JLabel lbl_detalles = new JLabel("<html><center>DETALLES FISICOS</center></html>");
		lbl_detalles.setBounds(507, 28, 167, 23);
		lbl_detalles.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_detalles.setFont(new Font("Dialog", Font.BOLD, 13));
		panel.add(lbl_detalles);

		JButton btn_limpiar_atributos_de_contenido_1 = new JButton("");
		btn_limpiar_atributos_de_contenido_1.setBounds(598, 251, 33, 32);
		btn_limpiar_atributos_de_contenido_1.setIcon(new ImageIcon(Productos.class.getResource("/imagenes/limpiar.png")));
		btn_limpiar_atributos_de_contenido_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpia_campos_detalles_fisicos();
			}
		});
		panel.add(btn_limpiar_atributos_de_contenido_1);

		JButton btn_ver_atributos = new JButton("VER ATRIBUTOS");
		btn_ver_atributos.setBounds(721, 52, 189, 23);
		btn_ver_atributos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Productos_Tabla_Buscar interfaz_busqueda = new Productos_Tabla_Buscar();
				interfaz_busqueda.setVisible(true);
				interfaz_busqueda.setLocationRelativeTo(null);
				interfaz_busqueda.addWindowFocusListener(new WindowFocusListener() {
					public void windowGainedFocus(WindowEvent e) {

					}
					public void windowLostFocus(WindowEvent e) {

						txt_marca.setText(interfaz_busqueda.datosMarcas[0]);
						txt_linea.setText(interfaz_busqueda.datosMarcas[1]);
						txt_categoria.setText(interfaz_busqueda.datosMarcas[2]);
						txt_provedores.setText(interfaz_busqueda.datosMarcas[3]);
					}
				});
				//	frame.requestFocus();
			}
		});
		btn_ver_atributos.setFont(new Font("Dialog", Font.BOLD, 13));
		panel.add(btn_ver_atributos);

		txt_marca = new JTextField();
		txt_marca.setEditable(false);
		txt_marca.setBounds(721, 84, 189, 20);
		panel.add(txt_marca);
		txt_marca.setColumns(10);

		txt_linea = new JTextField();
		txt_linea.setEditable(false);
		txt_linea.setBounds(721, 115, 189, 20);
		txt_linea.setColumns(10);
		panel.add(txt_linea);

		txt_categoria = new JTextField();
		txt_categoria.setEditable(false);
		txt_categoria.setBounds(721, 142, 189, 20);
		txt_categoria.setColumns(10);
		panel.add(txt_categoria);

		txt_provedores = new JTextField();
		txt_provedores.setEditable(false);
		txt_provedores.setBounds(721, 173, 189, 20);
		txt_provedores.setColumns(10);
		panel.add(txt_provedores);

		txt_color = new JTextField();
		txt_color.setBounds(557, 189, 117, 20);
		txt_color.setColumns(10);
		panel.add(txt_color);

		txt_mililitros = new JTextField();
		txt_mililitros.setBounds(557, 158, 117, 20);
		txt_mililitros.setColumns(10);
		panel.add(txt_mililitros);

		txt_cm = new JTextField();
		txt_cm.setBounds(557, 131, 117, 20);
		txt_cm.setColumns(10);
		panel.add(txt_cm);

		txt_kilos = new JTextField();
		txt_kilos.setBounds(557, 100, 117, 20);
		txt_kilos.setColumns(10);
		panel.add(txt_kilos);

		txt_tamano = new JTextField();
		txt_tamano.setBounds(557, 220, 117, 20);
		txt_tamano.setColumns(10);
		panel.add(txt_tamano);

		JLabel lblNewLabel = new JLabel("KG / G");
		lblNewLabel.setBounds(480, 103, 73, 14);
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 12));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel);

		JLabel lblCm = new JLabel("M / CM");
		lblCm.setBounds(480, 134, 73, 14);
		lblCm.setFont(new Font("Dialog", Font.BOLD, 12));
		lblCm.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblCm);

		JLabel lblMl = new JLabel("L / ML");
		lblMl.setBounds(480, 161, 73, 14);
		lblMl.setFont(new Font("Dialog", Font.BOLD, 12));
		lblMl.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblMl);

		JLabel lblColor = new JLabel("COLOR");
		lblColor.setBounds(480, 192, 73, 14);
		lblColor.setFont(new Font("Dialog", Font.BOLD, 12));
		lblColor.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblColor);

		JLabel lblTamao = new JLabel("TAMAÑO");
		lblTamao.setBounds(480, 223, 73, 14);
		lblTamao.setFont(new Font("Dialog", Font.BOLD, 12));
		lblTamao.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblTamao);

		spinner_tiempo_inicial = new JSpinner(new SpinnerDateModel());
		spinner_tiempo_inicial.setBounds(1051, 71, 151, 20);
		spinner_tiempo_inicial.setFont(new Font("Dialog", Font.BOLD, 12));
		spinner_tiempo_inicial.setEditor(new JSpinner.DateEditor(spinner_tiempo_inicial, "yyyy-MM-dd HH:mm:ss"));

		spinner_tiempo_inicial.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				Validar_Campos();
			}
		});

		panel.add(spinner_tiempo_inicial);




		spinner_tiempo_limite = new JSpinner(new SpinnerDateModel());
		spinner_tiempo_limite.setBounds(1051, 161, 151, 20);
		spinner_tiempo_limite.setFont(new Font("Dialog", Font.BOLD, 12));

		spinner_tiempo_limite.setEditor(new JSpinner.DateEditor(spinner_tiempo_limite, "yyyy-MM-dd HH:mm:ss"));



		spinner_tiempo_limite.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				Validar_Campos();
			}
		});



		panel.add(spinner_tiempo_limite);

		JLabel lbl_notas_venta = new JLabel("<html><center>NOTAS DE VENTA</center></html>");
		lbl_notas_venta.setBounds(34, 429, 217, 23);
		lbl_notas_venta.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_notas_venta.setFont(new Font("Dialog", Font.BOLD, 13));
		panel.add(lbl_notas_venta);

		txt_notas_de_venta = new JTextField();
		txt_notas_de_venta.setBounds(34, 453, 217, 23);
		txt_notas_de_venta.setFont(new Font("Dialog", Font.BOLD, 12));
		txt_notas_de_venta.setColumns(10);
		panel.add(txt_notas_de_venta);

		lbl_alerta_1 = new JLabel("*");
		lbl_alerta_1.setForeground(new Color(0,0,0));
		lbl_alerta_1.setHorizontalTextPosition(SwingConstants.CENTER);
		lbl_alerta_1.setBounds(34, 86, 151, 24);
		lbl_alerta_1.setFont(new Font("Dialog", Font.BOLD, 23));
		lbl_alerta_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lbl_alerta_1);

		lbl_alerta_2 = new JLabel("*");
		lbl_alerta_2.setForeground(new Color(0,0,0));
		lbl_alerta_2.setBounds(61, 176, 167, 24);
		lbl_alerta_2.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_alerta_2.setFont(new Font("Dialog", Font.BOLD, 23));
		panel.add(lbl_alerta_2);

		lbl_alerta_3 = new JLabel("*");
		lbl_alerta_3.setForeground(new Color(0,0,0));
		lbl_alerta_3.setBounds(34, 322, 227, 24);
		lbl_alerta_3.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_alerta_3.setFont(new Font("Dialog", Font.BOLD, 23));
		panel.add(lbl_alerta_3);

		lbl_alerta_4 = new JLabel("*");
		lbl_alerta_4.setForeground(new Color(0,0,0));
		lbl_alerta_4.setBounds(303, 86, 143, 24);
		lbl_alerta_4.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_alerta_4.setFont(new Font("Dialog", Font.BOLD, 23));
		panel.add(lbl_alerta_4);

		lbl_alerta_5 = new JLabel("*");
		lbl_alerta_5.setForeground(new Color(0,0,0));
		lbl_alerta_5.setBounds(271, 268, 227, 24);
		lbl_alerta_5.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_alerta_5.setFont(new Font("Dialog", Font.BOLD, 23));
		panel.add(lbl_alerta_5);

		lbl_alerta_6 = new JLabel("*");
		lbl_alerta_6.setForeground(new Color(0,0,0));
		lbl_alerta_6.setBounds(303, 184, 161, 23);
		lbl_alerta_6.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_alerta_6.setFont(new Font("Dialog", Font.BOLD, 23));
		panel.add(lbl_alerta_6);

		lbl_alerta_7 = new JLabel("*");
		lbl_alerta_7.setHorizontalTextPosition(SwingConstants.CENTER);
		lbl_alerta_7.setForeground(new Color(0,0,0));
		lbl_alerta_7.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_alerta_7.setFont(new Font("Dialog", Font.BOLD, 23));
		lbl_alerta_7.setBounds(82, 572, 151, 24);
		panel.add(lbl_alerta_7);

		lbl_alerta_8 = new JLabel("*");
		lbl_alerta_8.setForeground(new Color(0,0,0));
		lbl_alerta_8.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_alerta_8.setFont(new Font("Dialog", Font.BOLD, 23));
		lbl_alerta_8.setBounds(1047, 192, 151, 24);
		panel.add(lbl_alerta_8);

		JButton btnNewButton = new JButton("CALCULAR PRECIO");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CalculaPrecio calcula = new CalculaPrecio();
				calcula.setVisible(true);
				calcula.setLocationRelativeTo(null);

			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setBounds(1023, 397, 253, 47);
		panel.add(btnNewButton);

		JLabel lbl_caducidad = new JLabel("CADUCIDAD");
		lbl_caducidad.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_caducidad.setFont(new Font("Dialog", Font.BOLD, 13));
		lbl_caducidad.setBounds(34, 500, 217, 23);
		panel.add(lbl_caducidad);


		spinner_caducidad.setFont(new Font("Dialog", Font.BOLD, 12));
		spinner_caducidad.setBounds(96, 527, 94, 20);
		spinner_caducidad.setEditor(new JSpinner.DateEditor(spinner_tiempo_limite, "yyyy-MM-dd"));



		spinner_caducidad.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				Validar_Campos();
			}
		});

		panel.add(spinner_caducidad);

		
		btn_buscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			        LocalDate date = LocalDate.of(2000, 1, 1);
			        spinner_caducidad.setValue(Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant()));
			}
		});
		
		
		
		
		
		JCheckBox ckb_confirmaCaducidad = new JCheckBox("");
		ckb_confirmaCaducidad.setBounds(196, 523, 21, 23);
		panel.add(ckb_confirmaCaducidad);



		btn_añadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_añadir.setBounds(480, 500, 115, 57);
		btn_añadir.setFont(new Font("Dialog", Font.BOLD, 13));

		JButton btn_caducados = new JButton("A CADUCAR");
		btn_caducados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

				spinnerTimeInicial = formater.format(spinner_tiempo_inicial.getValue());

				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				spinnerTimefinal = formater.format(spinner_tiempo_limite.getValue());

				Productos_a_caducar A_caducar = new Productos_a_caducar();



				A_caducar.ver_datos(spinnerTimeInicial, spinnerTimefinal);
				A_caducar.setVisible(true);
				A_caducar.setLocationRelativeTo(null);
				lbl_alerta_2.setForeground(new Color(0,0,0));
				A_caducar.addWindowFocusListener(new WindowFocusListener() {
					public void windowGainedFocus(WindowEvent e) {
					}
					public void windowLostFocus(WindowEvent e) {

						txt_id.requestFocus();


					}
				});
			}
		});
		btn_caducados.setFont(new Font("Tahoma", Font.BOLD, 20));
		btn_caducados.setBounds(1023, 316, 253, 38);
		panel.add(btn_caducados);

		 ckb_kg = new JCheckBox("GRM");
		

		ckb_kg.setBounds(30, 212, 21, 23);
		panel.add(ckb_kg);

		ckb_cm = new JCheckBox("CM");
		ckb_cm.setBounds(113, 215, 21, 23);
		panel.add(ckb_cm);

		JLabel lbl_kg = new JLabel("GRM");
		lbl_kg.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_kg.setBounds(57, 218, 46, 14);
		panel.add(lbl_kg);

		JLabel lbl_cm = new JLabel("CM");
		lbl_cm.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_cm.setBounds(133, 221, 46, 14);
		panel.add(lbl_cm);

		JLabel lbl_precio_de_venta_2 = new JLabel("PRECIO DE VENTA 2");
		lbl_precio_de_venta_2.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_precio_de_venta_2.setFont(new Font("Dialog", Font.BOLD, 13));
		lbl_precio_de_venta_2.setBounds(287, 283, 183, 20);
		panel.add(lbl_precio_de_venta_2);

		txt_pv2 = new JTextField();
		txt_pv2.setEnabled(false);
		txt_pv2.setEditable(false);
		txt_pv2.setFont(new Font("Dialog", Font.BOLD, 12));
		txt_pv2.setColumns(10);
		txt_pv2.setBounds(319, 317, 117, 23);
		panel.add(txt_pv2);

		JLabel lbl_alerta_pv2 = new JLabel("*");
		lbl_alerta_pv2.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_alerta_pv2.setForeground(Color.BLACK);
		lbl_alerta_pv2.setFont(new Font("Dialog", Font.BOLD, 23));
		lbl_alerta_pv2.setBounds(271, 352, 227, 24);
		panel.add(lbl_alerta_pv2);

		ckb_pza = new JCheckBox("PZA");
		ckb_pza.setBounds(195, 215, 21, 23);
		panel.add(ckb_pza);

		JLabel lbl_pzs = new JLabel("PZA");
		lbl_pzs.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_pzs.setBounds(215, 221, 46, 14);
		panel.add(lbl_pzs);

		JButton btn_ver_movimientos_1 = new JButton("VER VENTAS SUELTAS");
		btn_ver_movimientos_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		btn_ver_movimientos_1.setBounds(988, 485, 288, 38);
		panel.add(btn_ver_movimientos_1);

		confirmacionCheckbox(ckb_kg, ckb_cm, ckb_pza);
		confirmacionCheckbox(ckb_cm,ckb_kg, ckb_pza);
		confirmacionCheckbox(ckb_pza,ckb_kg, ckb_cm);
		recibeEntero(txt_stock);
		recibeEntero(txt_id);
		recibeDecimal(txt_precio_de_compra);
		recibeDecimal(txt_precio_de_venta);
		recibeDecimal(txt_pv2);
		recibeDecimal(txt_kilos);
		recibeDecimal(txt_cm);
		recibeDecimal(txt_mililitros);
		
		JButton btnConvertgrm = new JButton("Mix");
		btnConvertgrm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String value = String.valueOf(Metodos_numericos.convierteAdecimal(Double.parseDouble(txt_stock.getText())));
				
			}
		});
		btnConvertgrm.setBounds(449, 67, 44, 23);
		panel.add(btnConvertgrm);

		btn_añadir.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {

				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				spinnerCaducidad = format.format(spinner_caducidad.getValue());

				if(txt_id.getText().equals("") || txt_producto.getText().equals("") || txt_distintivo_1.getText().equals("") || txt_stock.getText().equals("") | txt_precio_de_venta.getText().equals("") || txt_precio_de_compra.getText().equals("")) {
					JOptionPane.showMessageDialog(null,"POR FAVOR LOS CAMPOS CON ' ASTERISCO ' SON OBLIGATORIOS");	
				}else {

					try {
						if(DB_productos.compararproductos(Long.parseLong(txt_id.getText()))) {
							JOptionPane.showMessageDialog(null,"ESTE PRODUCTO YA EXISTE");
						}
						else {


							Object datosDB[] = new Object[21];

							if(ckb_cm.isSelected() == false && ckb_kg.isSelected() == false && ckb_pza.isSelected() == false) {

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
								datosDB[16] =  "Menu_principal.nombre_usuario";
								datosDB[17] =  txt_notas_de_venta.getText();
								datosDB[18] =  ckb_confirmaCaducidad.isSelected()? spinnerCaducidad : "";
								datosDB[19] =  "";
								datosDB[20] =  0.0;

							}
							JCheckBox Punitario [] = {ckb_cm,ckb_kg,ckb_pza};
							String datoEncontrado = "";
							for(int i = 0 ; i < 3; i++) {
								if(Punitario[i].isSelected() == true) {
									datoEncontrado = Punitario[i].getText();
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
									datosDB[16] =  "enu_principal.nombre_usuario";
									datosDB[17] =  txt_notas_de_venta.getText();
									datosDB[18] =  ckb_confirmaCaducidad.isSelected()? spinnerCaducidad : "";
									datosDB[19] =  datoEncontrado;
									datosDB[20] =  txt_pv2.getText() != "" ? txt_pv2.getText(): null ;

								}
							}







							try 
							{

								DB_productos.anadir(datosDB);
								System.out.println("datos enviados");
								ckb_confirmaCaducidad.setSelected(false);
								Limpiar_Campos();
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
					} catch (NumberFormatException | SQLException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}

				}


			}	
		});


	}

	/*
	public static void impresion_atributos(String marca,String linea,String categoria,String provedores) {

		txt_marca.setText(marca);
		txt_linea.setText(linea);
		txt_categoria.setText(categoria);
		txt_provedores.setText(provedores);

	}
	 */
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


			for(int i =0 ; i < 6 ; i++) {
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

	}


	int contador = 0;
	public void confirmacionCheckbox(JCheckBox recibeEvento,JCheckBox bloqueado1, JCheckBox bloqueado2) {

		recibeEvento.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(recibeEvento.isSelected() == false) {	
					recibeEvento.setSelected(false);
					txt_pv2.setEditable(false);
					txt_pv2.setEnabled(false);
					txt_pv2.setText("");
				}else if (recibeEvento.isSelected() == true){

					recibeEvento.setSelected(true);
					txt_pv2.setEditable(true);
					txt_pv2.setEnabled(true);
					bloqueado1.setSelected(false);
					bloqueado2.setSelected(false);
				}



			}
		});
	}

	int contadork = 0;
	public void recibeDecimal (JTextField campo) {
		campo.addKeyListener(new KeyAdapter() {

			@Override
			public void keyTyped(KeyEvent evt) {



				int key = evt.getKeyChar();


				boolean numeros = key >= 46 && key <= 57;

				if(key == 46)
				{
					contadork++;



				}

				if (!numeros )
				{
					evt.consume();
				}

			}

			public void keyReleased(KeyEvent e) {
				if(contadork == 2) {
					JOptionPane.showMessageDialog(null,"NO MAS DE DOS PUNTOS");
					campo.setText("");

					contadork = 0;
				}


			}

		});
	}
	public void recibeEntero (JTextField campo) {
		campo.addKeyListener(new KeyAdapter() {

			@Override
			public void keyTyped(KeyEvent evt) {



				int key = evt.getKeyChar();


				boolean numeros = key >= 48 && key <= 57;


				if (!numeros )
				{
					evt.consume();
				}

			}



		});
	}

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
		txt_pv2.setText("");
		txt_notas_de_venta.setText("");
		txt_id.requestFocus();
		ckb_cm.setSelected(false);
		ckb_kg.setSelected(false);
		ckb_pza.setSelected(false);

	}
	private JSpinner.DateEditor convertData (String datedb) {
		SpinnerDateModel model = new SpinnerDateModel();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			System.out.println(datedb);
			date = format.parse(datedb);
		} catch (ParseException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		model.setValue(date);
		JSpinner spinner = new JSpinner(model);
		JSpinner.DateEditor editor = new JSpinner.DateEditor(spinner, format.toPattern());

		return editor;
		
		
	}
}
