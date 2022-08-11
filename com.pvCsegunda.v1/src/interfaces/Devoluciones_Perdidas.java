package interfaces;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import conexionDB.DB_devoluciones_perdidas;


public class Devoluciones_Perdidas extends JFrame {
	private 	String spinnerTimeInicial ;
	private String spinnerTimefinal;
	private JSpinner spinner_tiempo_inicial;
	private JSpinner spinner_tiempo_limite;
	private JPanel contentPane;
	private JTextField txt_id;
	private JTable table;
	private JTextField txt_id_cliente;
	private JButton btn_devolver;
	private JComboBox cbx_motivo;
	private JSpinner sp_cantidad;
	private JTextField txt_cantidad_devolver;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Devoluciones_Perdidas frame = new Devoluciones_Perdidas();
					frame.setVisible(true);
					frame.setFocusable(true);
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
	
	public void Desactivar_Boton() {
		int numero = Integer.parseInt(sp_cantidad.getValue().toString());
		//JOptionPane.showMessageDialog(null, numero);
		if ( !txt_id.getText().equals("") && cbx_motivo.getSelectedIndex() > 0 && numero > 0) {
			btn_devolver.setEnabled(true);
		}
		
	}
	
	public void Activar_Boton() {
		int numero = Integer.parseInt(sp_cantidad.getValue().toString());
		JOptionPane.showMessageDialog(null, numero);
		if ( !txt_id.getText().equals("") && cbx_motivo.getSelectedIndex() > 0 && numero > 0) {
			btn_devolver.setEnabled(false);
		}
	}
	
	public Devoluciones_Perdidas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 519, 604);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 11, 502, 560);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lbl_id = new JLabel("ID");
		lbl_id.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_id.setFont(new Font("Roboto Slab Black", Font.BOLD, 13));
		lbl_id.setBounds(10, 46, 70, 18);
		panel.add(lbl_id);
		
		txt_id = new JTextField();
		txt_id.setFont(new Font("Roboto Slab", Font.BOLD, 12));
		txt_id.setBounds(90, 45, 133, 20);
		panel.add(txt_id);
		
		txt_id.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				//Activar_Boton();
			}
		});
		
		txt_id.setColumns(10);
		
		JButton btn_buscar = new JButton("BUSCAR");
		btn_buscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		btn_buscar.setFont(new Font("Roboto Slab Black", Font.BOLD, 13));
		btn_buscar.setBounds(269, 44, 100, 23);
		
		btn_buscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(txt_id.getText().equals("")) {
					JOptionPane.showMessageDialog(null,"Ingresa ID");
				}else {
//					Devoluciones_Perdidas_Buscar b = new Devoluciones_Perdidas_Buscar();
//					b.setVisible(true);
//					b.setLocationRelativeTo(null);
//					b.setFocusable(true);
					ver_datos_tabla(table, Integer.parseInt(txt_id.getText()));	
				}
			}
		});
		panel.add(btn_buscar);
		
		sp_cantidad = new JSpinner();
		sp_cantidad.setBounds(180, 198, 145, 29);
		
		sp_cantidad.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
		//		Activar_Boton();
			}
		});
		panel.add(sp_cantidad);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 89, 482, 98);
		panel.add(scrollPane);
		
		table = new JTable();

		scrollPane.setViewportView(table);
		
		JLabel lbl_motivo = new JLabel("MOTIVO");
		lbl_motivo.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_motivo.setFont(new Font("Roboto Slab Black", Font.BOLD, 13));
		lbl_motivo.setBounds(10, 278, 93, 20);
		panel.add(lbl_motivo);
		
		cbx_motivo = new JComboBox();
		cbx_motivo.setModel(new DefaultComboBoxModel(new String[] {"SELECCIONAR", "DEVOLUCION", "CADUCADO", "ABIERTO", "MAL ESTADO", "INSERVIBLE ", "INCOMPLETO"}));
		cbx_motivo.setFont(new Font("Roboto Slab", Font.BOLD, 12));
		cbx_motivo.setBounds(180, 277, 145, 22);
		
		cbx_motivo.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED) {
					if(cbx_motivo.getSelectedIndex()>0) {
					//	Activar_Boton();
					}
					else {
						Desactivar_Boton();
					}
				}
			}
		});
		panel.add(cbx_motivo);
		
		JLabel lbl_cantidad = new JLabel("CANTIDAD");
		lbl_cantidad.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_cantidad.setFont(new Font("Roboto Slab Black", Font.BOLD, 13));
		lbl_cantidad.setBounds(10, 201, 93, 29);
		panel.add(lbl_cantidad);
		
		btn_devolver = new JButton("DEVOLVER");
		btn_devolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(txt_id.getText().equalsIgnoreCase("")) {
					System.out.println("rellena campos");
				}else {

					Object datos[] = new Object [6];
					datos[0] = txt_id.getText();
					datos[1] = sp_cantidad.getValue().toString();
					datos[2] = txt_cantidad_devolver.getText();
					datos[3] =  cbx_motivo.getSelectedItem().toString();
					datos[4] =  txt_id_cliente.getText();
					datos[5] = "";
					
					
					try {
						DB_devoluciones_perdidas.anadir(datos);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
				 
			
			}
		});
		btn_devolver.setFont(new Font("Roboto Slab Black", Font.BOLD, 13));
		btn_devolver.setBounds(371, 258, 110, 23);
		panel.add(btn_devolver);
		
		JLabel lbl_fecha_inicial = new JLabel("FECHA INICIAL");
		lbl_fecha_inicial.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_fecha_inicial.setFont(new Font("Roboto Slab Black", Font.BOLD, 13));
		lbl_fecha_inicial.setBounds(27, 440, 122, 18);
		panel.add(lbl_fecha_inicial);
		
		JLabel lbl_fecha_final = new JLabel("FECHA FINAL");
		lbl_fecha_final.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_fecha_final.setFont(new Font("Roboto Slab Black", Font.BOLD, 13));
		lbl_fecha_final.setBounds(210, 440, 122, 18);
		panel.add(lbl_fecha_final);
		
		JLabel lbl_calendario = new JLabel("");
		lbl_calendario.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_calendario.setIcon(new ImageIcon(Devoluciones_Perdidas.class.getResource("/imagenes/calendario.png")));
		lbl_calendario.setBounds(56, 371, 70, 58);
		panel.add(lbl_calendario);
		
		JLabel lbl_calendario_1 = new JLabel("");
		lbl_calendario_1.setIcon(new ImageIcon(Devoluciones_Perdidas.class.getResource("/imagenes/calendario.png")));
		lbl_calendario_1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_calendario_1.setBounds(222, 371, 70, 58);
		panel.add(lbl_calendario_1);
		
		JButton btn_ver_movimiento = new JButton("VER MOVIMIENTOS");
		btn_ver_movimiento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_ver_movimiento.setFont(new Font("Roboto Slab Black", Font.BOLD, 13));
		btn_ver_movimiento.setBounds(163, 508, 176, 23);
		
		btn_ver_movimiento.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				 spinnerTimeInicial = formater.format(spinner_tiempo_inicial.getValue());
				
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				 spinnerTimefinal = formater.format(spinner_tiempo_limite.getValue());
				 
			
					Devoluciones_Perdidas_Tabla_Ver_Movimientos tvm = new Devoluciones_Perdidas_Tabla_Ver_Movimientos();
			tvm.ver_datos(spinnerTimeInicial, spinnerTimefinal);
					tvm.setVisible(true);
					tvm.setLocationRelativeTo(null);
					tvm.setFocusable(true);
				
			}
		});
		panel.add(btn_ver_movimiento);
		
		JButton btn_regresar = new JButton("");
		btn_regresar.setIcon(new ImageIcon(Devoluciones_Perdidas.class.getResource("/imagenes/flecha.png")));
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
		
		JLabel lbl_id_cliente = new JLabel("ID CLIENTE");
		lbl_id_cliente.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_id_cliente.setFont(new Font("Dialog", Font.BOLD, 13));
		lbl_id_cliente.setBounds(10, 314, 113, 18);
		panel.add(lbl_id_cliente);
		
		txt_id_cliente = new JTextField();
		txt_id_cliente.setFont(new Font("Dialog", Font.BOLD, 12));
		txt_id_cliente.setColumns(10);
		txt_id_cliente.setBounds(180, 310, 145, 20);
		panel.add(txt_id_cliente);
		
		JLabel lbl_cantidad_1 = new JLabel("CANTIDAD a devolver");
		lbl_cantidad_1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_cantidad_1.setFont(new Font("Dialog", Font.BOLD, 13));
		lbl_cantidad_1.setBounds(10, 238, 153, 29);
		panel.add(lbl_cantidad_1);
		
		txt_cantidad_devolver = new JTextField();
		txt_cantidad_devolver.setFont(new Font("Dialog", Font.BOLD, 12));
		txt_cantidad_devolver.setColumns(10);
		txt_cantidad_devolver.setBounds(180, 238, 145, 20);
		panel.add(txt_cantidad_devolver);
		
		JButton btn_clientes = new JButton("ver clientes");
		btn_clientes.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				Clientes_Tabla_Ver_Clientes c = new Clientes_Tabla_Ver_Clientes();
				c.setVisible(true);
				c.ver_clientes(txt_id_cliente);
				       
			}
		});
		btn_clientes.setFont(new Font("Dialog", Font.BOLD, 13));
		btn_clientes.setBounds(371, 313, 110, 23);
		panel.add(btn_clientes);
		
		spinner_tiempo_inicial = new JSpinner(new SpinnerDateModel());
		spinner_tiempo_inicial.setBounds(10, 480, 151, 20);
		panel.add(spinner_tiempo_inicial);
		spinner_tiempo_inicial.setEditor(new JSpinner.DateEditor(spinner_tiempo_inicial, "yyyy-MM-dd HH:mm:ss"));
		
		
		
		
		 spinner_tiempo_limite = new JSpinner(new SpinnerDateModel());
		 spinner_tiempo_limite.setBounds(195, 477, 151, 20);
		 panel.add(spinner_tiempo_limite);
		 
		 spinner_tiempo_limite.setEditor(new JSpinner.DateEditor(spinner_tiempo_limite, "yyyy-MM-dd HH:mm:ss"));
	}

public void ver_datos_tabla(JTable tabla,int id) {
	try {
		tabla.setModel(  DB_devoluciones_perdidas.model_view_dev_per(id));
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
//commet//