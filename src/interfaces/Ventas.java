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
import java.awt.Frame;
import java.awt.Graphics;

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

import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;

import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
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

import javax.swing.event.CaretListener;
import javax.swing.event.CaretEvent;
import java.awt.SystemColor;
import Ticket_Venta.Ticket;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.WindowAdapter;
import interfaces.ProductoUnitario;
import metodos_externos_necesarios.Metodos_numericos;

public class Ventas extends JFrame implements Printable {
	public static String id_productos;	
    private boolean confirmarRecibo = false;
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
	private String spinnerTimeInicial ;
	private String spinnerTimefinal;
	private JSpinner spinner_tiempo_inicial;
	private JSpinner spinner_tiempo_limite;
	private static Ventas frame;
	private JLabel lbl_alerta_1;
	private JLabel lbl_alerta_2;
	
	/**
	 * Launch the application.
	 */
	
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Ventas();
					frame.setVisible(true);
					frame.txt_id.requestFocus();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	
	
	public Ventas() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				txt_id.requestFocus();
			}
		});

		setResizable(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		setBounds(100, 100, 1026, 746);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(248, 196, 113));
		panel.setBounds(0, 0, 1010, 707);

		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lbl_id_cliente = new JLabel("CLIENTE");
		lbl_id_cliente.setFont(new Font("Calibri", Font.BOLD, 18));
		lbl_id_cliente.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_id_cliente.setBounds(310, 32, 112, 22);
		panel.add(lbl_id_cliente);
		
		txt_id_cliente = new JTextField();
		txt_id_cliente.setFont(new Font("Dialog", Font.BOLD, 12));
		txt_id_cliente.setBounds(310, 61, 179, 22);
		panel.add(txt_id_cliente);
		txt_id_cliente.setColumns(10);
		
		JButton btn_buscar_clientes = new JButton("BUSCAR CLIENTES");
		btn_buscar_clientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_buscar_clientes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				if("".equals(txt_id_cliente.getText())) {
					Clientes_Tabla_Ver_Clientes c = new Clientes_Tabla_Ver_Clientes();
					c.setVisible(true);
					c.setLocationRelativeTo(null);
					c.ver_clientes(txt_id_cliente);
					c.addWindowFocusListener(new WindowFocusListener() {
						public void windowGainedFocus(WindowEvent e) {
						}
						public void windowLostFocus(WindowEvent e) {
						txt_id.setText(id_productos);
						txt_id.requestFocus();
						
						}
					});	 

				}else {
					JOptionPane.showMessageDialog(null,"Campo lleno");
					txt_id.requestFocus();
				}

				
			}
		});
		btn_buscar_clientes.setFont(new Font("Dialog", Font.BOLD, 13));
		btn_buscar_clientes.setBounds(310, 108, 179, 22);
		panel.add(btn_buscar_clientes);
		
		JLabel lbl_id = new JLabel("PRODUCTO");
		lbl_id.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_id.setFont(new Font("Calibri", Font.BOLD, 18));
		lbl_id.setBounds(110, 32, 112, 22);
		panel.add(lbl_id);
		
		txt_id = new JTextField();

		txt_id.setFont(new Font("Dialog", Font.BOLD, 12));
		txt_id.setColumns(10);
		txt_id.setBounds(110, 59, 179, 22);
		
		
		
		panel.add(txt_id);
		
		JButton btn_buscar_productos = new JButton("BUSCAR PRODUCTOS");
		btn_buscar_productos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_buscar_productos.addMouseListener(new MouseAdapter() {
			@Override	
			public void mouseClicked(MouseEvent e) {

				try {
					
    				 String inputid = txt_id.getText().equalsIgnoreCase("") ? "0": txt_id.getText();		           				 
    				 long productAvailble = (long) (DB_ventas.checkStockAndDoublePrice(Long.parseLong(inputid))[0]);
    				 
					if(productAvailble == 0) {
						JOptionPane.showMessageDialog(null,"No hay existencias");
					}
					
					else {
						String checkLabelInvidualOrEntire = (String) (DB_ventas.checkStockAndDoublePrice(Long.parseLong(txt_id.getText()))[2]);
						
						if(Objects.isNull(checkLabelInvidualOrEntire)) 
						{
							evento_teclado_campo_id.add_row();	
						}
						
						else {							
							
								Object dataMtable[] = DB_ventas.checkStockAndDoublePrice(Long.parseLong(txt_id.getText()));
								Object precios[] = {dataMtable[3],dataMtable[4],0};
								
								ProductoUnitario tabla_seleciona_precio =  new ProductoUnitario(Long.parseLong(txt_id.getText()),def_tabla);
								
								tabla_seleciona_precio.set_items_data(Long.parseLong(dataMtable[0].toString()),dataMtable[1].toString(), precios);		
								
							
								for (int i = 0; i < def_tabla.getRowCount();i++){

									
									if(txt_id.getText().equalsIgnoreCase( def_tabla.getValueAt(i,0).toString())  && Integer.parseInt(def_tabla.getValueAt(i,5).toString()) >= 1 ) {
										System.out.println(def_tabla.getValueAt(i,5).toString());
										tabla_seleciona_precio.dispose();
										
									}
								}
						
								txt_id.setText("");
						}
						
					}
						
				
				

					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				 
				
				
			}
		});
		btn_buscar_productos.setFont(new Font("Dialog", Font.BOLD, 13));
		btn_buscar_productos.setBounds(110, 108, 179, 22);
		panel.add(btn_buscar_productos);
		
		JLabel lbl_notas_extra = new JLabel("NOTAS EXTRA");
		lbl_notas_extra.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_notas_extra.setFont(new Font("Calibri", Font.BOLD, 18));
		lbl_notas_extra.setBounds(10, 186, 146, 22);
		panel.add(lbl_notas_extra);
		
		txt_notas_extra = new JTextField();
		txt_notas_extra.setEditable(false);
		txt_notas_extra.setFont(new Font("Dialog", Font.BOLD, 12));
		txt_notas_extra.setColumns(10);
		txt_notas_extra.setBounds(10, 208, 622, 22);
		
		panel.add(txt_notas_extra);
		
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setEnabled(false);
		scrollPane.setBounds(10, 241, 913, 171);
		panel.add(scrollPane);
 	   
		tbl_ventas = new  JTable();
		String[] columnNames = {"ID","Producto","Distintivo1","Stock", "Precio", "Cantidad", "$"};  
		
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
		btn_menos.setBounds(792, 204, 50, 27);
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
		btn_mas.setBounds(707, 204, 50, 27);
		panel.add(btn_mas);
		
		JLabel lbl_descuento = new JLabel("DESCUENTO");
		lbl_descuento.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_descuento.setFont(new Font("Calibri", Font.BOLD, 18));
		lbl_descuento.setBounds(10, 423, 137, 22);
		panel.add(lbl_descuento);
		
		txt_descuento = new JTextField();
		txt_descuento.setFont(new Font("Dialog", Font.BOLD, 12));
		txt_descuento.setColumns(10);
		txt_descuento.setBounds(10, 450, 137, 22);
		panel.add(txt_descuento);
		
		JLabel lbl_extra = new JLabel("EXTRA");
		lbl_extra.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_extra.setFont(new Font("Calibri", Font.BOLD, 18));
		lbl_extra.setBounds(189, 423, 137, 22);
		panel.add(lbl_extra);
		
		txt_extra = new JTextField();
		txt_extra.setFont(new Font("Dialog", Font.BOLD, 12));
		txt_extra.setColumns(10);
		txt_extra.setBounds(189, 450, 137, 22);
		panel.add(txt_extra);
		
		JLabel lbl_total = new JLabel("TOTAL");
		lbl_total.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_total.setFont(new Font("Calibri", Font.BOLD, 18));
		lbl_total.setBounds(408, 423, 157, 22);
		panel.add(lbl_total);
		
		
		lbl_alerta_1 = new JLabel("*");
		lbl_alerta_1.setHorizontalTextPosition(SwingConstants.CENTER);
		lbl_alerta_1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_alerta_1.setForeground(new Color(248, 196, 113));
		lbl_alerta_1.setFont(new Font("Dialog", Font.BOLD, 23));
		lbl_alerta_1.setBounds(138, 136, 157, 24);
		panel.add(lbl_alerta_1);
		
		txt_total = new JTextField();
		txt_total.setText("0.0");
			txt_total.addInputMethodListener(new InputMethodListener() {
			public void caretPositionChanged(InputMethodEvent event) {
	
			}
			public void inputMethodTextChanged(InputMethodEvent event) {
			
			}
			
		});
		txt_total.setFont(new Font("Dialog", Font.BOLD, 12));
		txt_total.setColumns(10);
		txt_total.setBounds(408, 450, 157, 22);
		panel.add(txt_total);
		
		
		//importante el flujo de datos primero se crean los elemetos despue se ejecuta el evento
	
				
				
				
		JLabel lbl_paga_con = new JLabel("PAGA CON");
		lbl_paga_con.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_paga_con.setFont(new Font("Calibri", Font.BOLD, 18));
		lbl_paga_con.setBounds(408, 483, 157, 22);
		panel.add(lbl_paga_con);
		
		txt_paga_con = new JTextField();
		txt_paga_con.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
				if (txt_paga_con.getText().equalsIgnoreCase("")  ) {
					txt_cambio.setText("0");
				}
			}
		});
		txt_paga_con.addMouseListener(new MouseAdapter() {
			
			public void mousePressed(MouseEvent e) {
			txt_paga_con.setText("");
			}
		});
		txt_paga_con.setText("0");
		txt_paga_con.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				if(e.getKeyCode() == KeyEvent.VK_DELETE ) {
					
				}
				
				if(txt_paga_con.getText().equalsIgnoreCase("") || txt_paga_con.getText().equalsIgnoreCase("0")) {
//
//					double total_pagar = Double.parseDouble( txt_total.getText());
//					double efectivo = 0;
//					double total =   total_pagar-efectivo  ; 
//					
//				String h =	String.valueOf(efectivo);
//					System.out.println( h.length());
//					
//					String cambio = String.valueOf(total);
//					txt_cambio.setText(cambio);
						
				}else {
					double total_pagar = Double.parseDouble( txt_total.getText());
					double efectivo = Double.parseDouble(txt_paga_con.getText());
					double total = Math.abs(  total_pagar-efectivo  ); 
					
								
								DecimalFormat df = new DecimalFormat("#.##");
								
								
								
								
								
					String cambio = String.valueOf(df.format(total));
					txt_cambio.setText(cambio);
					
				}
			}
		});
		txt_paga_con.setFont(new Font("Dialog", Font.BOLD, 12));
		txt_paga_con.setColumns(10);
		txt_paga_con.setBounds(408, 510, 157, 22);
		panel.add(txt_paga_con);
		
		JLabel lbl_cambio = new JLabel("CAMBIO");
		lbl_cambio.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_cambio.setFont(new Font("Calibri", Font.BOLD, 18));
		lbl_cambio.setBounds(623, 423, 90, 22);
		panel.add(lbl_cambio);
		
		txt_cambio = new JTextField();
		txt_cambio.setText("0");
		txt_cambio.setFont(new Font("Arial", Font.BOLD, 25));
		txt_cambio.setColumns(10);
		txt_cambio.setBounds(601, 474, 142, 37);
		txt_cambio.setOpaque(false);
		txt_cambio.repaint();
		
		 
		panel.add(txt_cambio);
		JCheckBox chk_imprimir_recibo = new JCheckBox("IMPRIMIR RECIBO");
		chk_imprimir_recibo.setSelected(confirmarRecibo);
		chk_imprimir_recibo.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				confirmarRecibo = chk_imprimir_recibo.isSelected();
				
			}
		});
		chk_imprimir_recibo.setFont(new Font("Dialog", Font.BOLD, 13));
		chk_imprimir_recibo.setHorizontalAlignment(SwingConstants.CENTER);
		
		chk_imprimir_recibo.setBounds(766, 466, 157, 23);
		
		panel.add(chk_imprimir_recibo);
		
		JButton btn_generar_venta = new JButton("GENERAR VENTA");
		btn_generar_venta.addActionListener(new ActionListener() {
			
			
			
			
			
			public void actionPerformed(ActionEvent e) {
				
				
				if(def_tabla.getRowCount() > 0) {
					boolean confirma = false;
					ArrayList<Object> datos_venta_list = new ArrayList<Object>();
					
					Object datos_venta[] = new Object[6];
					if(txt_extra.getText().equalsIgnoreCase("")  && txt_descuento.getText().equalsIgnoreCase("")) {
						for(int i = 0; i <  def_tabla.getRowCount();i++) {
							datos_venta[0] = def_tabla.getValueAt(i, 0);
							datos_venta[1] = def_tabla.getValueAt(i, 5);
							datos_venta[2] = txt_total.getText();
							datos_venta[3] =  txt_id_cliente.getText();
							datos_venta[4] = Login.idUsers[Login.indiceSeleccionado];
							datos_venta[5] = txt_numero_venta.getText();
			datos_venta_list.add(datos_venta);
						}
						
						int conteo_elementos_sin_stock = 0;
						
						for(int i = 0; i < def_tabla.getRowCount();i++) {
							if( Integer.parseInt( def_tabla.getValueAt(i, 3).toString()) == 0 && Integer.parseInt(def_tabla.getValueAt(i, 5).toString()) == 0 ) {
								conteo_elementos_sin_stock ++;
							}
							
						}
						
						if(conteo_elementos_sin_stock==0) {

							try {
								for (int i=0;i<datos_venta_list.size();i++) {
								
									Object venta[] =  (Object[])datos_venta_list.get(i);
									
									DB_ventas.anadir(venta);
								    }
								
								Ticket enviarDatosTicket = new Ticket();
								if(confirmarRecibo) {
		enviarDatosTicket.print("POS-58-Series", def_tabla, Login.usuario_menu, txt_total.getText(),txt_id_cliente.getText());
		chk_imprimir_recibo.setSelected(false);
		JOptionPane.showMessageDialog(null,"Venta generada");
		txt_id.requestFocus();
		
	}else {
		confirmarRecibo = false;
		enviarDatosTicket.print("POS-58-Series");
		JOptionPane.showMessageDialog(null,"Venta generada");
		txt_id.requestFocus();
	}
								limpia_campos();
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
						}else {
							JOptionPane.showMessageDialog(null,"Elimina productos sin stock");
							txt_id.requestFocus();
						}

					}else {
					
						JOptionPane.showMessageDialog(null,"Confirma tu descuento o extra");
						txt_id.requestFocus();
		
					}
					try {
						long  venta_numero =  DB_ventas.conteoVentasgeneradas() +1 ;
						txt_numero_venta.setText(String.valueOf(venta_numero));
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
						
				}else {
					
					JOptionPane.showMessageDialog(null,"INGRESA PRODUCTOS PARA GENERAR VENTA");
					txt_id.requestFocus();
					
				}
				
				
			}
		});
		btn_generar_venta.setFont(new Font("Dialog", Font.BOLD, 13));
		btn_generar_venta.setBounds(766, 510, 157, 22);
		panel.add(btn_generar_venta);
		
		
		JButton btn_cancelar_pedido = new JButton("CANCELAR PEDIDO");
		btn_cancelar_pedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			limpia_campos();	
			
			}
		});
		btn_cancelar_pedido.setFont(new Font("Dialog", Font.BOLD, 13));
		btn_cancelar_pedido.setBounds(310, 158, 179, 22);
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
	btn_borrar.setBounds(873, 204, 50, 27);
	panel.add(btn_borrar);
	
	JButton btn_confirma_desc = new JButton("confirmar");
	btn_confirma_desc.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			
		double desc = Double.parseDouble( txt_descuento.getText());
		double total_val= Double.parseDouble( txt_total.getText());
		double total = 0;
		DecimalFormat df = new DecimalFormat("#.##");
		
		
		total = Math.abs(  total_val - desc);
		
		String cast = String.valueOf(df.format(total));
		
		txt_total.setText(cast);
		
		txt_descuento.setText("");
	
		
		
			
			
	
		
	    double paga_con =  Double.parseDouble( txt_paga_con.getText() );

	    if(!txt_paga_con.getText().equalsIgnoreCase("") && paga_con <=0) {


}
	    else {
double total_pagar = Double.parseDouble( txt_total.getText());
double efectivo = Double.parseDouble(txt_paga_con.getText());
double totallast =   total_pagar-efectivo  ; 







String cambio = String.valueOf( df.format( totallast));
txt_cambio.setText(cambio);
}
		
		
		}
	});
	btn_confirma_desc.setFont(new Font("Dialog", Font.BOLD, 13));
	btn_confirma_desc.setBounds(10, 510, 137, 22);
	panel.add(btn_confirma_desc);
	
	JButton btn_confirma_extra = new JButton("confirmar ");
	btn_confirma_extra.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
				
			
			double extra = Double.parseDouble( txt_extra.getText());
			double total_val= Double.parseDouble( txt_total.getText());
			double total = 0;
		
			total = Math.abs(  (total_val+extra));

			DecimalFormat df = new DecimalFormat("#.##");
			
			
			
			
			
			String cast = String.valueOf(df.format(total));
			
			txt_total.setText(cast);
		    txt_extra.setText("");
		
		    
		    double paga_con =  Double.parseDouble( txt_paga_con.getText() );

		    if(!txt_paga_con.getText().equalsIgnoreCase("") && paga_con <=0) {

	
}else {
	double total_pagar = Double.parseDouble( txt_total.getText());
double efectivo = Double.parseDouble(txt_paga_con.getText());
double totallast =   total_pagar-efectivo  ; 

String cambio = String.valueOf(totallast);
txt_cambio.setText(cambio);
}
	
//		}

		    
		    
			
				
		
			
		}
	});
	btn_confirma_extra.setFont(new Font("Dialog", Font.BOLD, 13));
	btn_confirma_extra.setBounds(189, 510, 137, 22);
	panel.add(btn_confirma_extra);
	
	JLabel lbl_numero_venta = new JLabel("");
	lbl_numero_venta.setBounds(98, 129, 46, 14);
	
	panel.add(lbl_numero_venta);
	
	 txt_numero_venta = new JTextPane();
	 txt_numero_venta.setBackground(new Color(255, 255, 255));
	 txt_numero_venta.setFont(new Font("Dialog", Font.BOLD, 29));
	txt_numero_venta.setBounds(766, 91, 137, 38);
	txt_numero_venta.setOpaque(false);
	txt_numero_venta.repaint();
	long venta_numero;
	try {
		venta_numero =  DB_ventas.conteoVentasgeneradas()+1 ;
		txt_numero_venta.setText(String.valueOf(venta_numero ));
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
	
	
	panel.add(txt_numero_venta);

	
	JButton btn_ver_movimientos = new JButton("VER VENTAS");
	btn_ver_movimientos.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			spinnerTimeInicial = formater.format(spinner_tiempo_inicial.getValue());
			
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			spinnerTimefinal = formater.format(spinner_tiempo_limite.getValue());
			
			Ventas_movimientos movimientos_generados = new Ventas_movimientos();
			
			System.out.println(spinnerTimeInicial + spinnerTimefinal + "no da valores");
			
			
			movimientos_generados.ver_datos(spinnerTimeInicial, spinnerTimefinal);
			movimientos_generados.setVisible(true);
			movimientos_generados.setLocationRelativeTo(null);
			lbl_alerta_2.setForeground(new Color(0,0,0));
			movimientos_generados.addWindowFocusListener(new WindowFocusListener() {
				public void windowGainedFocus(WindowEvent e) {
				}
				public void windowLostFocus(WindowEvent e) {
				
				txt_id.requestFocus();
				
				
				}
			});
		
		}
	});
	btn_ver_movimientos.setFont(new Font("Dialog", Font.BOLD, 13));
	btn_ver_movimientos.setBounds(762, 619, 161, 23);

	
	
	panel.add(btn_ver_movimientos);
	
	JLabel lbl_calendario_1 = new JLabel("");
	lbl_calendario_1.setIcon(new ImageIcon(Productos.class.getResource("/imagenes/calendario.png")));
	lbl_calendario_1.setHorizontalAlignment(SwingConstants.CENTER);
	lbl_calendario_1.setBounds(343, 636, 76, 60);
	panel.add(lbl_calendario_1);
	

	spinner_tiempo_limite = new JSpinner(new SpinnerDateModel());
	spinner_tiempo_limite.setSize(135, 26);
	spinner_tiempo_limite.setLocation(254, 623);

	spinner_tiempo_limite.setEditor(new JSpinner.DateEditor(spinner_tiempo_limite, "yyyy-MM-dd HH:mm:ss"));
	
	
	
	JLabel lbl_fecha_final = new JLabel("FECHA FINAL");
	lbl_fecha_final.setHorizontalAlignment(SwingConstants.CENTER);
	lbl_fecha_final.setFont(new Font("Dialog", Font.BOLD, 13));

	lbl_fecha_final.setBounds(418, 582, 146, 32);

	panel.add(lbl_fecha_final);
	
	JLabel lbl_calendario = new JLabel("");
	lbl_calendario.setIcon(new ImageIcon(Productos.class.getResource("/imagenes/calendario.png")));
	lbl_calendario.setHorizontalAlignment(SwingConstants.CENTER);
	lbl_calendario.setBounds(40, 636, 76, 60);
	panel.add(lbl_calendario);
	

	 spinner_tiempo_inicial = new JSpinner(new SpinnerDateModel());
	 spinner_tiempo_inicial.setSize(135, 27);
	 spinner_tiempo_inicial.setLocation(10, 623);
	 spinner_tiempo_inicial.setEditor(new JSpinner.DateEditor(spinner_tiempo_inicial, "yyyy-MM-dd HH:mm:ss"));
	

	
	JLabel lbl_fecha_inicial = new JLabel("FECHA INICIAL");
	lbl_fecha_inicial.setHorizontalAlignment(SwingConstants.CENTER);
	lbl_fecha_inicial.setFont(new Font("Dialog", Font.BOLD, 13));
	lbl_fecha_inicial.setBounds(119, 582, 147, 32);

	panel.add(lbl_fecha_inicial);
	
	JLabel lbl_numero_ventas = new JLabel("Venta #:");
	lbl_numero_ventas.setHorizontalAlignment(SwingConstants.CENTER);
	lbl_numero_ventas.setFont(new Font("Dialog", Font.BOLD, 35));
	lbl_numero_ventas.setBounds(590, 91, 169, 39);
	panel.add(lbl_numero_ventas);
	

	JLabel lblNewLabel = new JLabel("$");
	lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
	lblNewLabel.setFont(new Font("Calibri", Font.PLAIN, 18));
	lblNewLabel.setBounds(538, 483, 53, 26);
	panel.add(lblNewLabel);

	
	
	lbl_alerta_2 = new JLabel("*");
	lbl_alerta_2.setHorizontalTextPosition(SwingConstants.CENTER);
	lbl_alerta_2.setHorizontalAlignment(SwingConstants.CENTER);
	lbl_alerta_2.setForeground(new Color(248, 196, 113));
	lbl_alerta_2.setFont(new Font("Dialog", Font.BOLD, 23));
	lbl_alerta_2.setBounds(189, 625, 531, 24);
	panel.add(lbl_alerta_2);

	txt_total.addCaretListener(new CaretListener() {
		public void caretUpdate(CaretEvent e) {
			
			
			
			if(!txt_paga_con.getText().equalsIgnoreCase("")) {
				double comparador = Double.parseDouble(txt_paga_con.getText());
				if(!txt_total.getText().equalsIgnoreCase("") && comparador > 0) {
					
					double total_pagar = Double.parseDouble( txt_total.getText());
					double efectivo = Double.parseDouble(txt_paga_con.getText());
					double total = Math.abs(  total_pagar-efectivo  ); 
					
					String cambio = String.valueOf(total);
					txt_cambio.setText(cambio);
				}
				
				
				
				
			}

			
			
		}
	});
	
	spinner_tiempo_inicial = new JSpinner(new SpinnerDateModel());
	spinner_tiempo_inicial.setBounds(119, 622, 147, 20);
	spinner_tiempo_inicial.setFont(new Font("Dialog", Font.BOLD, 12));
	spinner_tiempo_inicial.setEditor(new JSpinner.DateEditor(spinner_tiempo_inicial, "yyyy-MM-dd HH:mm:ss"));
	panel.add(spinner_tiempo_inicial);
	
	spinner_tiempo_limite = new JSpinner(new SpinnerDateModel());
	spinner_tiempo_limite.setBounds(417, 621, 147, 20);
	spinner_tiempo_limite.setFont(new Font("Dialog", Font.BOLD, 12));
	spinner_tiempo_limite.setEditor(new JSpinner.DateEditor(spinner_tiempo_limite, "yyyy-MM-dd HH:mm:ss"));
	panel.add(spinner_tiempo_limite);

	evento_teclado_campo_id = new enventoTeclado(
			txt_id,
			def_tabla,
			txt_notas_extra, 
			txt_total,
			lbl_alerta_1,
			txt_notas_extra,
			txt_total,
			id_productos);
	
	txt_id.addKeyListener(evento_teclado_campo_id);
	}	
				
				
				

	public void total_txt(JTextField total_suma,DefaultTableModel modelo) {		
		 double total_sum=0;
		 double cantidad_sum = 0;
		 double costo_sum= 0;
		 for(int i = 0;i < modelo.getRowCount();i++) {
			costo_sum = Double.parseDouble(	 modelo.getValueAt(i,5 ).toString());
			cantidad_sum =	Double.parseDouble(	 modelo.getValueAt(i, 4).toString()); 
			total_sum += (costo_sum * cantidad_sum) ;
		 }
		 String total_cadena =    String.valueOf(  total_sum);
		 total_suma.setText( total_cadena);
		  
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
	txt_id.requestFocus();
	//frame.requestFocus();
	}

	@Override
	public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
		// TODO Auto-generated method stub
		return 0;
	}

	
	

}


class enventoTeclado implements KeyListener{
	
	private JTextField campo_id;
	private DefaultTableModel modelo;
	private JTextField campo_notas;
	private JTextField total;
	private JTextField extra;
	private JTextField resta;
	private String id_productos;
	private JLabel lbl_alerta_1;
	private JTextField txt_notas_extra;
	private JTextField txt_total; 
	 
	public  enventoTeclado(JTextField campo_id,
							DefaultTableModel modelo, 
							JTextField campo_notas,
							JTextField total,
							JLabel alerta_campo,
							JTextField notas_campo,
							JTextField total_campo,
							String id_productos)
	{
		this.campo_id = campo_id;
		this.modelo = modelo;
		this.campo_notas = campo_notas;
		this.total = total;
		this.extra = extra;
		this.resta = resta;
		this.id_productos = id_productos;
		this.lbl_alerta_1 = alerta_campo;
		this.txt_notas_extra = notas_campo;
		this.txt_total = total_campo;
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
				}
	
	@Override
	public void keyPressed(KeyEvent e) {
		
    if(e.getKeyCode() == KeyEvent.VK_ENTER) {
	if(campo_id.getText().equalsIgnoreCase("")) {
	}else {
		try {
			
			 String inputid = campo_id.getText().equalsIgnoreCase("") ? "0": campo_id.getText();		           				 
			 long productAvailble = (long) (DB_ventas.checkStockAndDoublePrice(Long.parseLong(inputid))[0]);
			 
			if(productAvailble == 0) {
				JOptionPane.showMessageDialog(null,"No hay existencias");
			}
			
			else {
				String checkLabelInvidualOrEntire = (String) (DB_ventas.checkStockAndDoublePrice(Long.parseLong(campo_id.getText()))[2]);
				
				if(Objects.isNull(checkLabelInvidualOrEntire)) 
				{
					add_row();	
				}
				
				else {							
					
						Object dataMtable[] = DB_ventas.checkStockAndDoublePrice(Long.parseLong(campo_id.getText()));
						Object precios[] = {dataMtable[3],dataMtable[4],0};
						
						ProductoUnitario tabla_seleciona_precio =  new ProductoUnitario(Long.parseLong(campo_id.getText()),modelo);
						
						tabla_seleciona_precio.set_items_data(Long.parseLong(dataMtable[0].toString()),dataMtable[1].toString(), precios);		
						
					
						for (int i = 0; i < modelo.getRowCount();i++){

							
							if(campo_id.getText().equalsIgnoreCase( modelo.getValueAt(i,0).toString())  && Integer.parseInt(modelo.getValueAt(i,5).toString()) >= 1 ) {
								System.out.println(modelo.getValueAt(i,5).toString());
								tabla_seleciona_precio.dispose();
								
							}
						
						}
						
						}
				campo_id.setText("");
				}

		}  catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	}}}
	
	public void add_row() {

		 try {
			 if(!"".equals(campo_id.getText())) {
				 Object notas[] = DB_ventas.add_row(Long.parseLong(campo_id.getText()), modelo);
				 
				 lbl_alerta_1.setForeground(new Color(248, 196, 113));
				 campo_id.setText("");
			
				 
				
				txt_notas_extra.setText(notas[7].toString());
					
			total_txt(txt_total, modelo);
			campo_id.requestFocus();
			 }else {

				 
				 busqueda_productos busca_productos = new busqueda_productos();
				 busca_productos.setVisible(true);
				 busca_productos.setLocationRelativeTo(null);
				 busca_productos.addWindowFocusListener(new WindowFocusListener() {
						public void windowGainedFocus(WindowEvent e) {
						}
						public void windowLostFocus(WindowEvent e) {
							campo_id.setText(id_productos);						
						}});	 

				 //ALERTA
				 lbl_alerta_1.setForeground(new Color(0,0,0));

			 }
			
		} catch (NumberFormatException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	public void total_txt(JTextField total_suma,DefaultTableModel modelo) {		
		 double total_sum=0;
		 double cantidad_sum = 0;
		 double costo_sum= 0;
		 for(int i = 0;i < modelo.getRowCount();i++) {
			costo_sum = Double.parseDouble(	 modelo.getValueAt(i,5 ).toString());
			cantidad_sum =	Double.parseDouble(	 modelo.getValueAt(i, 4).toString()); 
			total_sum += (costo_sum * cantidad_sum) ;
		 }
		 String total_cadena =    String.valueOf(  total_sum);
		 total_suma.setText( total_cadena);
		  
	 };
	
}



