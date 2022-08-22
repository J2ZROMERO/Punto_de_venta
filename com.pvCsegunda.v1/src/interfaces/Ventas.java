package interfaces;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

//import com.itextpdf.text.log.SysoCounter;

import conexionDB.DB_productos;
import conexionDB.DB_ventas;

import javax.swing.JCheckBox;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import javax.swing.JTextPane;
import javax.swing.SpinnerDateModel;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;

public class Ventas extends JFrame {
	
	private JTextPane txt_numero_venta;
	private DefaultTableModel def_tabla  = new DefaultTableModel();  
	private enventoTeclado evento_teclado_campo_id;
	private Object row [];
	private JPanel contentPane;
	private JTextField txt_id_cliente;
	public  JTextField txt_id;
	private  JTextField txt_notas_extra;
	private JTable tbl_ventas;
	private JTextField txt_descuento;
	private JTextField txt_extra;
	private JTextField txt_total;
	private JTextField txt_paga_con;
	private JTextField txt_cambio;
	private long numero_venta = 0;
	private 	String spinnerTimeInicial ;
	private String spinnerTimefinal;
	private JSpinner spinner_tiempo_inicial;
	private JSpinner spinner_tiempo_limite;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventas frame = new Ventas();
					frame.setVisible(true);
					frame.txt_id.requestFocus();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Ventas() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1026, 705);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(152, 179, 255));
		panel.setBounds(0, 0, 1010, 666);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lbl_id_cliente = new JLabel("ID CLIENTE");
		lbl_id_cliente.setFont(new Font("Dialog", Font.BOLD, 13));
		lbl_id_cliente.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_id_cliente.setBounds(711, 47, 112, 22);
		panel.add(lbl_id_cliente);
		
		txt_id_cliente = new JTextField();
		txt_id_cliente.setFont(new Font("Dialog", Font.BOLD, 12));
		txt_id_cliente.setBounds(678, 88, 179, 22);
		panel.add(txt_id_cliente);
		txt_id_cliente.setColumns(10);
		
		JButton btn_buscar_clientes = new JButton("BUSCAR CLIENTES");
		btn_buscar_clientes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Ventas_Tabla_Buscar_Clientes b = new Ventas_Tabla_Buscar_Clientes();
				b.setVisible(true);
				b.setFocusable(true);
				b.setLocationRelativeTo(null);
			}
		});
		btn_buscar_clientes.setFont(new Font("Dialog", Font.BOLD, 13));
		btn_buscar_clientes.setBounds(678, 121, 179, 22);
		panel.add(btn_buscar_clientes);
		
		JLabel lbl_id = new JLabel("ID");
		lbl_id.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_id.setFont(new Font("Dialog", Font.BOLD, 13));
		lbl_id.setBounds(32, 105, 79, 22);
		panel.add(lbl_id);
		
		txt_id = new JTextField();

		txt_id.setFont(new Font("Dialog", Font.BOLD, 12));
		txt_id.setColumns(10);
		txt_id.setBounds(138, 105, 157, 22);
		
		
		
		panel.add(txt_id);
		
		JButton btn_buscar_productos = new JButton("BUSCAR PRODUCTOS");
		btn_buscar_productos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
	
			}
		});
		btn_buscar_productos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
	
		//	ver_datos_ventas( Long.parseLong( txt_id.getText()));
				   
				 try {
					DB_ventas.add_row(Long.parseLong(txt_id.getText()), def_tabla);
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btn_buscar_productos.setFont(new Font("Dialog", Font.BOLD, 13));
		btn_buscar_productos.setBounds(316, 105, 179, 22);
		panel.add(btn_buscar_productos);
		
		JLabel lbl_notas_extra = new JLabel("NOTAS EXTRA");
		lbl_notas_extra.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_notas_extra.setFont(new Font("Dialog", Font.BOLD, 13));
		lbl_notas_extra.setBounds(10, 186, 146, 22);
		panel.add(lbl_notas_extra);
		
		txt_notas_extra = new JTextField();
		txt_notas_extra.setFont(new Font("Dialog", Font.BOLD, 12));
		txt_notas_extra.setColumns(10);
		txt_notas_extra.setBounds(10, 208, 847, 22);
		
		panel.add(txt_notas_extra);
		
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setEnabled(false);
		scrollPane.setBounds(10, 252, 847, 171);
		panel.add(scrollPane);
 	   
		tbl_ventas = new  JTable();
		String[] columnNames = {"ID","Producto","Distintivo1","Stock", "Precio", "Cantidad"};  
		
		def_tabla.setColumnIdentifiers(columnNames);
		
	tbl_ventas.setModel(def_tabla);
	tbl_ventas.addMouseListener( new MouseAdapter() {
		public void mouseEntered(MouseEvent e) {
	
			  int row = tbl_ventas.rowAtPoint( e.getPoint() );
	            int column = tbl_ventas.columnAtPoint( e.getPoint() );

		};		
	public void mousePressed(MouseEvent e) {
		
		
		if(e.getButton() == 1) {
			String selectedCellValue = (String) tbl_ventas.getValueAt(tbl_ventas.getSelectedRow() , 0);
            txt_id.setText(selectedCellValue);
            
		}
		
			
	
	
		   
            
            
if(e.getButton() == 3 ) {
  
	
	
	if(tbl_ventas.getSelectedRow() < 0) {
		
		
			
			
	}else {
		int suma = Integer.parseInt((def_tabla.getValueAt(tbl_ventas.getSelectedRow(), 5).toString()));
		suma-=1;
		def_tabla.setValueAt (suma,tbl_ventas.getSelectedRow() , 5);
		
		total_txt(txt_total, def_tabla);
		if(Integer.parseInt( tbl_ventas.getValueAt(tbl_ventas.getSelectedRow(), 5).toString()) <= 0) {
			
			def_tabla.removeRow( tbl_ventas.getSelectedRow());
			
			total_txt(txt_total, def_tabla);
			}
	}
		
	

	
	
	
		
		

		
}

if(e.getButton() == 2) {
	
	if(!(tbl_ventas.getRowCount() <= 0) ){
		def_tabla.removeRow( tbl_ventas.getSelectedRow());
		total_txt(txt_total, def_tabla);
	}else {
		


		 
	
	}
	 }

            
	}});
		//tbl_ventas.setModel(def_tabla);
		
		tbl_ventas.setFont(new Font("Dialog", Font.BOLD, 12));
		scrollPane.setViewportView(tbl_ventas);
		
		JButton btn_menos = new JButton("-");
		btn_menos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				
			
					if(def_tabla.getRowCount() != 0 && tbl_ventas.getSelectedRow() != -1) {
										
				
					
			
				int suma = Integer.parseInt((def_tabla.getValueAt(tbl_ventas.getSelectedRow(), 5).toString()));
				suma-=1;
				def_tabla.setValueAt (suma,tbl_ventas.getSelectedRow() , 5);
				total_txt(txt_total, def_tabla);
				
				
				if(Integer.parseInt( tbl_ventas.getValueAt(tbl_ventas.getSelectedRow(), 5).toString()) <= 0) {
					def_tabla.removeRow( tbl_ventas.getSelectedRow());
					total_txt(txt_total, def_tabla);
				}
			}		}
		});
		btn_menos.setFont(new Font("Dialog", Font.BOLD, 18));
		btn_menos.setBounds(867, 321, 50, 27);
		panel.add(btn_menos);
		
		JButton btn_mas = new JButton("+");
		btn_mas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				if(tbl_ventas.getRowCount() != 0 && tbl_ventas.getSelectedRow() != -1) {
					try {
						Object notas[] = DB_ventas.add_row(Long.parseLong(txt_id.getText()),def_tabla);
						txt_notas_extra.setText(notas[0].toString());
						
total_txt(txt_total, def_tabla);
					} catch (NumberFormatException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
						
				}
				
			
			}
		});
		btn_mas.setFont(new Font("Dialog", Font.BOLD, 18));
		btn_mas.setBounds(867, 263, 50, 27);
		panel.add(btn_mas);
		
		JLabel lbl_descuento = new JLabel("DESCUENTO");
		lbl_descuento.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_descuento.setFont(new Font("Dialog", Font.BOLD, 13));
		lbl_descuento.setBounds(10, 434, 103, 22);
		panel.add(lbl_descuento);
		
		txt_descuento = new JTextField();
		txt_descuento.setFont(new Font("Dialog", Font.BOLD, 12));
		txt_descuento.setColumns(10);
		txt_descuento.setBounds(20, 461, 89, 22);
		panel.add(txt_descuento);
		
		JLabel lbl_extra = new JLabel("EXTRA");
		lbl_extra.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_extra.setFont(new Font("Dialog", Font.BOLD, 13));
		lbl_extra.setBounds(173, 434, 103, 22);
		panel.add(lbl_extra);
		
		txt_extra = new JTextField();
		txt_extra.setFont(new Font("Dialog", Font.BOLD, 12));
		txt_extra.setColumns(10);
		txt_extra.setBounds(173, 461, 103, 22);
		panel.add(txt_extra);
		
		JLabel lbl_total = new JLabel("TOTAL");
		lbl_total.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_total.setFont(new Font("Dialog", Font.BOLD, 13));
		lbl_total.setBounds(329, 434, 157, 22);
		panel.add(lbl_total);
		
		txt_total = new JTextField();
		txt_total.setFont(new Font("Dialog", Font.BOLD, 12));
		txt_total.setColumns(10);
		txt_total.setBounds(329, 456, 157, 22);
		panel.add(txt_total);
		
		
		//importante el flujo de datos primero se crean los elemetos despue se ejecuta el evento
		 
				evento_teclado_campo_id = new enventoTeclado(txt_id,def_tabla,txt_notas_extra, txt_total);
				txt_id.addKeyListener(evento_teclado_campo_id);
				
				
		JLabel lbl_paga_con = new JLabel("PAGA CON");
		lbl_paga_con.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_paga_con.setFont(new Font("Dialog", Font.BOLD, 13));
		lbl_paga_con.setBounds(508, 434, 157, 22);
		panel.add(lbl_paga_con);
		
		txt_paga_con = new JTextField();
		txt_paga_con.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				if(!txt_paga_con.getText().equalsIgnoreCase("")) {

					double total_pagar = Double.parseDouble( txt_total.getText());
					double efectivo = Double.parseDouble(txt_paga_con.getText());
					double total = Math.abs(  total_pagar-efectivo  ); 
					
					String cambio = String.valueOf(total);
					txt_cambio.setText(cambio);
						
				}
			}
		});
		txt_paga_con.setFont(new Font("Dialog", Font.BOLD, 12));
		txt_paga_con.setColumns(10);
		txt_paga_con.setBounds(508, 456, 157, 22);
		panel.add(txt_paga_con);
		
		JLabel lbl_cambio = new JLabel("CAMBIO");
		lbl_cambio.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_cambio.setFont(new Font("Dialog", Font.BOLD, 13));
		lbl_cambio.setBounds(687, 434, 157, 22);
		panel.add(lbl_cambio);
		
		txt_cambio = new JTextField();
		txt_cambio.setFont(new Font("Dialog", Font.BOLD, 12));
		txt_cambio.setColumns(10);
		txt_cambio.setBounds(687, 456, 157, 22);
		panel.add(txt_cambio);
		
		JButton btn_generar_venta = new JButton("GENERAR VENTA");
		btn_generar_venta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				boolean confirma = false;
				
				Object datos_venta[] = new Object[6];		
				
				if(txt_extra.getText().equalsIgnoreCase("")  && txt_descuento.getText().equalsIgnoreCase("")) {
					for(int i = 0; i <  def_tabla.getRowCount();i++) {
					

						
						datos_venta[0] = def_tabla.getValueAt(i, 0);
						datos_venta[1] = def_tabla.getValueAt(i, 5);
						datos_venta[2] = txt_total.getText();
						datos_venta[3] =  txt_id_cliente.getText();
						datos_venta[4] = "";
						datos_venta[5] = txt_numero_venta.getText();
						
				
						
						
					}
					
					int conteo_elementos_sin_stock = 0;
					
					for(int i = 0; i < def_tabla.getRowCount();i++) {
						if( Integer.parseInt( def_tabla.getValueAt(i, 3).toString()) == 0 && Integer.parseInt(def_tabla.getValueAt(i, 5).toString()) == 0 ) {
							conteo_elementos_sin_stock ++;
						}
						
					}
					
					if(conteo_elementos_sin_stock==0) {

						try {
							DB_ventas.anadir(datos_venta);
							JOptionPane.showMessageDialog(null,"Venta generada");	
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					}else {
						JOptionPane.showMessageDialog(null,"Elimina productos sin stock");
					}
					
					
					
								
										
					
				
				}else {
				
					JOptionPane.showMessageDialog(null,"Confirma tu descuento o extra");
	
				}
			}
		});
		btn_generar_venta.setFont(new Font("Dialog", Font.BOLD, 13));
		btn_generar_venta.setBounds(678, 508, 179, 22);
		panel.add(btn_generar_venta);
		
		JButton btn_ver_ventas = new JButton("VER VENTAS");
		btn_ver_ventas.setFont(new Font("Dialog", Font.BOLD, 13));
		btn_ver_ventas.setBounds(678, 541, 179, 22);
		panel.add(btn_ver_ventas);
		
		JCheckBox chk_imprimir_recibo = new JCheckBox("IMPRIMIR RECIBO");
		chk_imprimir_recibo.setFont(new Font("Dialog", Font.BOLD, 13));
		chk_imprimir_recibo.setHorizontalAlignment(SwingConstants.CENTER);
		chk_imprimir_recibo.setBounds(490, 508, 181, 23);
		panel.add(chk_imprimir_recibo);
		
		JButton btn_cancelar_pedido = new JButton("CANCELAR PEDIDO");
		btn_cancelar_pedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			limpia_campos();	
				
				
			}
		});
		btn_cancelar_pedido.setFont(new Font("Dialog", Font.BOLD, 13));
		btn_cancelar_pedido.setBounds(678, 175, 179, 22);
		panel.add(btn_cancelar_pedido);
		
		JButton btn_regresar = new JButton("");
		btn_regresar.setIcon(new ImageIcon(Ventas.class.getResource("/imagenes/flecha.png")));
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

	JButton btn_borrar = new JButton("x");
	btn_borrar.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		
			
			if(def_tabla.getRowCount() != 0 && tbl_ventas.getSelectedRow() != -1)  {
				def_tabla.removeRow( tbl_ventas.getSelectedRow());
				total_txt(txt_total, def_tabla);
			}
			
			
			
		}
	});
	btn_borrar.setFont(new Font("Dialog", Font.BOLD, 18));
	btn_borrar.setBounds(867, 382, 50, 27);
	panel.add(btn_borrar);
	
	JButton btn_confirma_desc = new JButton("confirmar des");
	btn_confirma_desc.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			
		double desc = Double.parseDouble( txt_descuento.getText());
	//	double extra = Double.parseDouble( txt_extra.getText());
		double total_val= Double.parseDouble( txt_total.getText());
		double total = 0;
	
		total = total_val - desc;
		
		String cast = String.valueOf(total);
		
		txt_total.setText(cast);
		
		txt_descuento.setText("");
		
		}
	});
	btn_confirma_desc.setFont(new Font("Dialog", Font.BOLD, 13));
	btn_confirma_desc.setBounds(10, 497, 137, 22);
	panel.add(btn_confirma_desc);
	
	JButton btn_confirma_extra = new JButton("confirmar extra");
	btn_confirma_extra.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			
			double extra = Double.parseDouble( txt_extra.getText());
			double total_val= Double.parseDouble( txt_total.getText());
			double total = 0;
		
			total = (total_val+extra);
			
			String cast = String.valueOf(total);
			
			txt_total.setText(cast);
		txt_extra.setText("");
			
		}
	});
	btn_confirma_extra.setFont(new Font("Dialog", Font.BOLD, 13));
	btn_confirma_extra.setBounds(173, 497, 137, 22);
	panel.add(btn_confirma_extra);
	
	JLabel lbl_numero_venta = new JLabel("");
	lbl_numero_venta.setBounds(98, 129, 46, 14);
	panel.add(lbl_numero_venta);
	
	 txt_numero_venta = new JTextPane();
	txt_numero_venta.setBounds(432, 32, 137, 20);
	
	long venta_numero;
	try {
		venta_numero = DB_ventas.numero_venta() +1 ;
		txt_numero_venta.setText(String.valueOf( venta_numero) );
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
	
	
	panel.add(txt_numero_venta);

	
	JButton btn_ver_movimientos = new JButton("VER MOVIMIENTOS");
	btn_ver_movimientos.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			 spinnerTimeInicial = formater.format(spinner_tiempo_inicial.getValue());
			
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			 spinnerTimefinal = formater.format(spinner_tiempo_limite.getValue());
			
			Ventas_movimientos movimientos_generados = new Ventas_movimientos();
			
			System.out.println(spinnerTimeInicial + spinnerTimefinal);
			
			
		movimientos_generados.ver_datos(spinnerTimeInicial, spinnerTimefinal);
			movimientos_generados.setVisible(true);
		
		}
	});
	btn_ver_movimientos.setFont(new Font("Dialog", Font.BOLD, 13));
	btn_ver_movimientos.setBounds(230, 630, 161, 23);
	panel.add(btn_ver_movimientos);
	
	JLabel lbl_calendario_1 = new JLabel("");
	lbl_calendario_1.setIcon(new ImageIcon(Productos.class.getResource("/imagenes/calendario.png")));
	lbl_calendario_1.setHorizontalAlignment(SwingConstants.CENTER);
	lbl_calendario_1.setBounds(493, 541, 76, 60);
	panel.add(lbl_calendario_1);
	
	spinner_tiempo_limite = new JSpinner(new SpinnerDateModel());
	spinner_tiempo_limite.setEditor(new JSpinner.DateEditor(spinner_tiempo_limite, "yyyy-MM-dd HH:mm:ss"));
	
	panel.add(spinner_tiempo_limite);
	
	JLabel lbl_fecha_final = new JLabel("FECHA FINAL");
	lbl_fecha_final.setHorizontalAlignment(SwingConstants.CENTER);
	lbl_fecha_final.setFont(new Font("Dialog", Font.BOLD, 13));
	lbl_fecha_final.setBounds(348, 541, 135, 32);
	panel.add(lbl_fecha_final);
	
	JLabel lbl_calendario = new JLabel("");
	lbl_calendario.setIcon(new ImageIcon(Productos.class.getResource("/imagenes/calendario.png")));
	lbl_calendario.setHorizontalAlignment(SwingConstants.CENTER);
	lbl_calendario.setBounds(211, 541, 76, 60);
	panel.add(lbl_calendario);
	
	 spinner_tiempo_inicial = new JSpinner(new SpinnerDateModel());
	 spinner_tiempo_inicial.setEditor(new JSpinner.DateEditor(spinner_tiempo_inicial, "yyyy-MM-dd HH:mm:ss"));
	
	panel.add(spinner_tiempo_inicial);
	
	JLabel lbl_fecha_inicial = new JLabel("FECHA INICIAL");
	lbl_fecha_inicial.setHorizontalAlignment(SwingConstants.CENTER);
	lbl_fecha_inicial.setFont(new Font("Dialog", Font.BOLD, 13));
	lbl_fecha_inicial.setBounds(66, 541, 135, 32);
	panel.add(lbl_fecha_inicial);


	}	
				
				
				
		
	public void total_txt(JTextField total_suma,DefaultTableModel modelo) {
		
		 double total_sum=0;
		
		 for(int i = 0;i < modelo.getRowCount();i++) {
			 
			 double costo_sum = Double.parseDouble(	 modelo.getValueAt(i,5 ).toString());
			double cantidad_sum =	Double.parseDouble(	 modelo.getValueAt(i, 4).toString()); 
			
			
			total_sum += (costo_sum * cantidad_sum) ;
			 
			 
			 
		 }
		 String total_cadena =    String.valueOf(  total_sum);
		 
		 total_suma.setText(total_cadena);
		  
	 };
	
	public  void ver_datos_ventas(long id) {
		
		try {
			 tbl_ventas.setModel(DB_ventas.model_view_ventas(id));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void limpia_campos() {
	txt_id.setText("");
	txt_id_cliente.setText("");	
	txt_extra.setText("");	
	txt_descuento.setText("");
	txt_cambio.setText("");	
	txt_paga_con.setText("");	
	txt_total.setText("");	
	txt_notas_extra.setText("");
	def_tabla.setRowCount(0);
	}
}


class enventoTeclado implements KeyListener{
	
	private JTextField campo;
	private DefaultTableModel modelo;
	private JTextField campo_notas;
	private JTextField total;
	private JTextField extra;
	private JTextField resta;
	public  enventoTeclado(JTextField campo, DefaultTableModel modelo, JTextField campo_notas,JTextField total) {
		this.campo = campo;
		this.modelo = modelo;
		this.campo_notas = campo_notas;
		this.total = total;
		this.extra = extra;
		this.resta = resta;
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
		
	}else {
		

				try {
					 
					
					
					 
					Object  datos_notas[] = DB_ventas.add_row(Long.parseLong(campo.getText()), modelo);
					 campo_notas.setText(datos_notas[6].toString());
					 
					 double total=0;
					
					 for(int i = 0;i < modelo.getRowCount();i++) {
						 
						 double costo_sum = Double.parseDouble(	 modelo.getValueAt(i,5 ).toString());
						double cantidad_sum =	Double.parseDouble(	 modelo.getValueAt(i, 4).toString()); 
						
						
						
						total += (costo_sum * cantidad_sum) ;
						 
						 
						 
					 }
					 
					 String total_cadena =    String.valueOf(  total);
					 
					 this.total.setText(total_cadena);
					 
					 
					 
					campo.setText("");
					
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	}		
			
}
		
	}
	

	
}

