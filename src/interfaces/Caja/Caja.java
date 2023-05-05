package interfaces.Caja;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.border.EmptyBorder;

import conexionDB.DB_caja;
import conexionDB.DB_devoluciones_perdidas;
import conexionDB.DB_ventas;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.DefaultComboBoxModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.nio.file.spi.FileSystemProvider;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;


public class Caja extends JFrame {

	private JPanel contentPane;
	public static  JTextField txt_saldo_inicial;
	private 	String spinnerTimeInicial ;

	private String spinnerTimefinal;
	private JTextField txt_motivo;
	private JTextField txt_monto;
	private JTextField txt_saldo_total_del_dia;
	private static Caja frame;
	private JSpinner spinner_tiempo_inicial;
	private JSpinner spinner_tiempo_limite;
	private double valorInicial;
	private	SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//dd/MM/yyyy
    private Date now = new Date();
   private String fechaActual = sdfDate.format(now);
	/**
	 * Launch the application.
	 */
	public void Activar_Botones() {
		
	}
	/*
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {					
					frame = new Caja();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					frame.setFocusable(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public Caja() {
		
		
		this.valorInicial = 12121.0;
		setResizable(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 534, 646);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(139, 195, 74));
		panel.setBounds(0, 0, 518, 607);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btn_regresar = new JButton("");
		btn_regresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_regresar.setBounds(0, 0, 44, 35);
		panel.add(btn_regresar);
		btn_regresar.setIcon(new ImageIcon(Caja.class.getResource("/imagenes/flecha.png")));
		
		JLabel lbl_saldo_inicial = new JLabel("SALDO INICIAL");
		lbl_saldo_inicial.setBounds(10, 55, 159, 22);
		panel.add(lbl_saldo_inicial);
		lbl_saldo_inicial.setFont(new Font("Roboto Slab Black", Font.BOLD, 13));
		lbl_saldo_inicial.setHorizontalAlignment(SwingConstants.CENTER);
		
		txt_saldo_inicial = new JTextField();
		txt_saldo_inicial.setText("0.0");
		txt_saldo_inicial.setEditable(false);
		txt_saldo_inicial.setBounds(196, 55, 192, 22);
		panel.add(txt_saldo_inicial);
		txt_saldo_inicial.setFont(new Font("Roboto Slab", Font.BOLD, 12));
		txt_saldo_inicial.setColumns(10);
		
		
		
		

		
		
		
		//txt_fecha_inicial.setText(  Menu_principal.saldoInicial);
		
		JLabel lbl_movimiento = new JLabel("MOVIMIENTO");
		lbl_movimiento.setBounds(10, 99, 159, 22);
		panel.add(lbl_movimiento);
		lbl_movimiento.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_movimiento.setFont(new Font("Roboto Slab Black", Font.BOLD, 13));
		
		JComboBox cbx_movimiento = new JComboBox();
		cbx_movimiento.setModel(new DefaultComboBoxModel(new String[] {"SELECCIONAR", "SALIDA DE EFECTIVO", "ENTRADA DE EFECTIVO"}));
		cbx_movimiento.setBounds(196, 100, 192, 22);
		panel.add(cbx_movimiento);
		cbx_movimiento.setFont(new Font("Roboto Slab", Font.BOLD, 12));
		
		JLabel lbl_motivo = new JLabel("MOTIVO");
		lbl_motivo.setBounds(10, 143, 159, 22);
		panel.add(lbl_motivo);
		lbl_motivo.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_motivo.setFont(new Font("Roboto Slab Black", Font.BOLD, 13));
		
		txt_motivo = new JTextField();
		txt_motivo.setBounds(196, 143, 192, 22);
		panel.add(txt_motivo);
		txt_motivo.setFont(new Font("Roboto Slab", Font.BOLD, 12));
		txt_motivo.setColumns(10);
		
		JLabel lbl_monto = new JLabel("MONTO");
		lbl_monto.setBounds(10, 187, 159, 22);
		panel.add(lbl_monto);
		lbl_monto.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_monto.setFont(new Font("Roboto Slab Black", Font.BOLD, 13));
		
		txt_monto = new JTextField();
		txt_monto.setBounds(196, 187, 192, 22);
		panel.add(txt_monto);
		txt_monto.setFont(new Font("Roboto Slab", Font.BOLD, 12));
		txt_monto.setColumns(10);
		
		JButton btn_cargar_movimiento = new JButton("CARGAR MOVIMIENTO");
		btn_cargar_movimiento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_cargar_movimiento.setBounds(196, 241, 192, 23);
		panel.add(btn_cargar_movimiento);
		
		btn_cargar_movimiento.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(cbx_movimiento.getSelectedIndex() > 0 && !txt_motivo.getText().equals("") && !txt_monto.getText().equals("") && !txt_saldo_inicial.getText().equals("")) {
					Object datosCaja[] = {
							Double.parseDouble( txt_saldo_inicial.getText()),
							cbx_movimiento.getSelectedItem().toString(),
							txt_motivo.getText(),
							Double.parseDouble( txt_monto.getText()),
							Login.idUsers[Login.indiceSeleccionado]};

try {
	DB_caja.insertarMovimientosCaja(datosCaja);
	JOptionPane.showMessageDialog(null,"MOVIMIENTO CARGADO CORRECTAMENTE");
	cbx_movimiento.setSelectedIndex(0);
	txt_motivo.setText("");
	txt_monto.setText("");
	//frame.requestFocus();

	try {
		
txt_saldo_inicial.setText(Caja_Inicial.monto);
		double calculoDia = (
				Double.parseDouble(txt_saldo_inicial.getText()) +DB_ventas.calcularTotalVentasDia(fechaActual,Login.idUsers[Login.indiceSeleccionado]) + DB_caja.calcularEntradasCaja(fechaActual,Login.idUsers[Login.indiceSeleccionado])) 
				-  
				(DB_devoluciones_perdidas.calcularTotalPerdidasDevolucionesDia(fechaActual,Login.idUsers[Login.indiceSeleccionado]) + DB_caja.calcularSalidasCaja(fechaActual,Login.idUsers[Login.indiceSeleccionado])) ;
		DecimalFormat df = new DecimalFormat("#.##");
		txt_saldo_total_del_dia.setText(df.format(calculoDia));
		System.out.println("abajo copnsulta");
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}

} catch (SQLException e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
}
				}else{
					JOptionPane.showMessageDialog(null,"MOVIMIENTO, MOTIVO Y MONTON DEBEN SER LLENADOS");
					// frame.requestFocus();
				}
			}
		});
		btn_cargar_movimiento.setFont(new Font("Roboto Slab Black", Font.BOLD, 13));
		
		JLabel lbl_saldo_total_del_dia = new JLabel("<html><center>SALDO TOTAL DEL DIA</center></html>");
		lbl_saldo_total_del_dia.setBounds(10, 286, 159, 42);
		panel.add(lbl_saldo_total_del_dia);
		lbl_saldo_total_del_dia.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_saldo_total_del_dia.setFont(new Font("Roboto Slab Black", Font.BOLD, 13));
		
		txt_saldo_total_del_dia = new JTextField();
		txt_saldo_total_del_dia.setEditable(false);
		txt_saldo_total_del_dia.setHorizontalAlignment(SwingConstants.CENTER);
		txt_saldo_total_del_dia.setText("0");
		txt_saldo_total_del_dia.setBounds(196, 286, 192, 53);
		panel.add(txt_saldo_total_del_dia);
		txt_saldo_total_del_dia.setFont(new Font("Dialog", Font.BOLD, 25));
		txt_saldo_total_del_dia.setColumns(10);
		
		JLabel lbl_fecha_inicial = new JLabel("FECHA INICIAL");
		lbl_fecha_inicial.setBounds(10, 350, 159, 22);
		panel.add(lbl_fecha_inicial);
		lbl_fecha_inicial.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_fecha_inicial.setFont(new Font("Roboto Slab Black", Font.BOLD, 13));
		
		JLabel img_fecha_inicial = new JLabel("");
		img_fecha_inicial.setBounds(418, 331, 76, 59);
		panel.add(img_fecha_inicial);
		img_fecha_inicial.setIcon(new ImageIcon(Caja.class.getResource("/imagenes/calendario.png")));
		img_fecha_inicial.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lbl_fecha_final = new JLabel("FECHA FINAL");
		lbl_fecha_final.setBounds(10, 420, 159, 22);
		panel.add(lbl_fecha_final);
		lbl_fecha_final.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_fecha_final.setFont(new Font("Roboto Slab Black", Font.BOLD, 13));
		
		JLabel img_fecha_final = new JLabel("");
		img_fecha_final.setBounds(418, 401, 76, 59);
		panel.add(img_fecha_final);
		img_fecha_final.setIcon(new ImageIcon(Caja.class.getResource("/imagenes/calendario.png")));
		img_fecha_final.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton btn_ver_movimientos = new JButton("VER MOVIMIENTOS");
		btn_ver_movimientos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_ver_movimientos.setBounds(196, 467, 192, 23);
		panel.add(btn_ver_movimientos);
		
		btn_ver_movimientos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				 spinnerTimeInicial = formater.format(spinner_tiempo_inicial.getValue());
				
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				 spinnerTimefinal = formater.format(spinner_tiempo_limite.getValue());
				Caja_Tabla_Ver_Movimientos tvm = new Caja_Tabla_Ver_Movimientos();
		tvm.ver_datos(spinnerTimeInicial, spinnerTimefinal);
				tvm.setVisible(true);
				tvm.setLocationRelativeTo(null);
				tvm.setFocusable(true);
			
				
			}
		});
		btn_ver_movimientos.setFont(new Font("Roboto Slab Black", Font.BOLD, 13));
		
		JButton btn_cierre_total_de_caja = new JButton("CIERRE TOTAL DE CAJA");
		btn_cierre_total_de_caja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_cierre_total_de_caja.setBounds(196, 546, 192, 23);
		panel.add(btn_cierre_total_de_caja);
		
		btn_cierre_total_de_caja.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				try {
				Caja_Cierre_Total_De_Caja cierre = new Caja_Cierre_Total_De_Caja(  
						Double.parseDouble(txt_saldo_inicial.getText()),
						DB_ventas.calcularTotalVentasDia(fechaActual,Login.idUsers[Login.indiceSeleccionado]) + DB_caja.calcularEntradasCaja(fechaActual,Login.idUsers[Login.indiceSeleccionado]),						 
						DB_devoluciones_perdidas.calcularTotalPerdidasDevolucionesDia(fechaActual,Login.idUsers[Login.indiceSeleccionado])+ DB_caja.calcularSalidasCaja(fechaActual,Login.idUsers[Login.indiceSeleccionado]),
						
						Double.parseDouble(txt_saldo_total_del_dia.getText()),
						Login.idUsers[Login.indiceSeleccionado]);
					
			
				
				
					cierre.setFocusable(true);
					cierre.setLocationRelativeTo(null);
					cierre.setVisible(true);
					dispose();
					
				} catch (Exception e2) {
					
					// TODO: handle exception
				}
				
			}
		});
		btn_cierre_total_de_caja.setFont(new Font("Roboto Slab Black", Font.BOLD, 13));
		
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
	
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
			
				

					try {
						
txt_saldo_inicial.setText(Caja_Inicial.monto);
						double calculoDia = (
								Double.parseDouble(txt_saldo_inicial.getText()) +DB_ventas.calcularTotalVentasDia(fechaActual,Login.idUsers[Login.indiceSeleccionado]) + DB_caja.calcularEntradasCaja(fechaActual,Login.idUsers[Login.indiceSeleccionado])) 
								-  
								(DB_devoluciones_perdidas.calcularTotalPerdidasDevolucionesDia(fechaActual,Login.idUsers[Login.indiceSeleccionado]) + DB_caja.calcularSalidasCaja(fechaActual,Login.idUsers[Login.indiceSeleccionado])) ;
						DecimalFormat df = new DecimalFormat("#.##");
						txt_saldo_total_del_dia.setText(df.format(calculoDia));
						System.out.println("abajo copnsulta");
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
			}

		});
		spinner_tiempo_inicial = new JSpinner(new SpinnerDateModel());
		spinner_tiempo_inicial.setBounds(196, 350, 192, 20);
		panel.add(spinner_tiempo_inicial);
		spinner_tiempo_inicial.setEditor(new JSpinner.DateEditor(spinner_tiempo_inicial, "yyyy-MM-dd HH:mm:ss"));
		
		
		
		
		 spinner_tiempo_limite = new JSpinner(new SpinnerDateModel());
		 spinner_tiempo_limite.setBounds(196, 422, 192, 20);
		 panel.add(spinner_tiempo_limite);
		 
		 spinner_tiempo_limite.setEditor(new JSpinner.DateEditor(spinner_tiempo_limite, "yyyy-MM-dd HH:mm:ss"));
		 
		 JButton btn_ver_cierres = new JButton("VER CIERRES");
		 btn_ver_cierres.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				 spinnerTimeInicial = formater.format(spinner_tiempo_inicial.getValue());
				
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				 spinnerTimefinal = formater.format(spinner_tiempo_limite.getValue());
				Caja_Tabla_Ver_Cierres_Caja tvm = new Caja_Tabla_Ver_Cierres_Caja();
		tvm.ver_datos(spinnerTimeInicial, spinnerTimefinal);
				tvm.setVisible(true);
				tvm.setLocationRelativeTo(null);
				tvm.setFocusable(true);
			
		 	}
		 });
		 btn_ver_cierres.setFont(new Font("Dialog", Font.BOLD, 13));
		 btn_ver_cierres.setBounds(196, 501, 192, 23);
		 panel.add(btn_ver_cierres);
	}
}


