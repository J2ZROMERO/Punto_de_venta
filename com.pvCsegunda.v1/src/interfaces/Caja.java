package interfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.DefaultComboBoxModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.awt.Color;


public class Caja extends JFrame {

	private JPanel contentPane;
	public static  JTextField txt_saldo_inicial;
	private JTextField txt_motivo;
	private JTextField txt_monto;
	private JTextField txt_saldo_total_del_dia;
	private JTextField txt_fecha_inicial;
	private JTextField txt_fecha_final;
	private static Caja frame;

	/**
	 * Launch the application.
	 */
	public void Activar_Botones() {
		
	}
	
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
	}

	/**
	 * Create the frame.
	 */
	public Caja() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 534, 646);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(235, 152, 78));
		panel.setBounds(0, 0, 518, 607);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btn_regresar = new JButton("");
		btn_regresar.setBounds(0, 0, 44, 35);
		panel.add(btn_regresar);
		btn_regresar.setIcon(new ImageIcon(Caja.class.getResource("/imagenes/flecha.png")));
		
		JLabel lbl_saldo_inicial = new JLabel("SALDO INICIAL");
		lbl_saldo_inicial.setBounds(10, 55, 159, 22);
		panel.add(lbl_saldo_inicial);
		lbl_saldo_inicial.setFont(new Font("Roboto Slab Black", Font.BOLD, 13));
		lbl_saldo_inicial.setHorizontalAlignment(SwingConstants.CENTER);
		
		txt_saldo_inicial = new JTextField();
		txt_saldo_inicial.setEnabled(false);
		txt_saldo_inicial.setBounds(196, 55, 192, 22);
		panel.add(txt_saldo_inicial);
		txt_saldo_inicial.setFont(new Font("Roboto Slab", Font.BOLD, 12));
		txt_saldo_inicial.setColumns(10);
		
		
		
		
		txt_saldo_inicial.setText(Caja_Inicial.monto);
		
		
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
				if(cbx_movimiento.getSelectedIndex() > 0 && !txt_motivo.getText().equals("") && !txt_monto.getText().equals("")) {
					JOptionPane.showMessageDialog(null,"MOVIMIENTO CARGADO CORRECTAMENTE");
					cbx_movimiento.setSelectedIndex(0);
					txt_motivo.setText("");
					txt_monto.setText("");
					frame.requestFocus();
				}else{
					JOptionPane.showMessageDialog(null,"MOVIMIENTO, MOTIVO Y MONTON DEBEN SER LLENADOS");
					frame.requestFocus();
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
		txt_saldo_total_del_dia.setBounds(196, 297, 192, 22);
		panel.add(txt_saldo_total_del_dia);
		txt_saldo_total_del_dia.setFont(new Font("Roboto Slab", Font.BOLD, 12));
		txt_saldo_total_del_dia.setColumns(10);
		
		JLabel lbl_fecha_inicial = new JLabel("FECHA INICIAL");
		lbl_fecha_inicial.setBounds(10, 350, 159, 22);
		panel.add(lbl_fecha_inicial);
		lbl_fecha_inicial.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_fecha_inicial.setFont(new Font("Roboto Slab Black", Font.BOLD, 13));
		
		txt_fecha_inicial = new JTextField();
		txt_fecha_inicial.setBounds(196, 350, 192, 22);
		panel.add(txt_fecha_inicial);
		txt_fecha_inicial.setFont(new Font("Roboto Slab", Font.BOLD, 12));
		txt_fecha_inicial.setColumns(10);
		
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
		
		txt_fecha_final = new JTextField();
		txt_fecha_final.setBounds(196, 420, 192, 22);
		panel.add(txt_fecha_final);
		txt_fecha_final.setFont(new Font("Roboto Slab", Font.BOLD, 12));
		txt_fecha_final.setColumns(10);
		
		JLabel img_fecha_final = new JLabel("");
		img_fecha_final.setBounds(418, 401, 76, 59);
		panel.add(img_fecha_final);
		img_fecha_final.setIcon(new ImageIcon(Caja.class.getResource("/imagenes/calendario.png")));
		img_fecha_final.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton btn_ver_movimientos = new JButton("VER MOVIMIENTOS");
		btn_ver_movimientos.setBounds(196, 498, 192, 23);
		panel.add(btn_ver_movimientos);
		
		btn_ver_movimientos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!txt_fecha_inicial.getText().equals("") && !txt_fecha_final.getText().equals("")) {
					Caja_Tabla_Ver_Movimientos ver= new Caja_Tabla_Ver_Movimientos();
					ver.setLocationRelativeTo(null);
					ver.setVisible(true);
					ver.setFocusable(true);
				}else {
					JOptionPane.showMessageDialog(null,"ES NECESARIO SELECCIONAR UN RANGO DE FECHAS...");
				}
				
			}
		});
		btn_ver_movimientos.setFont(new Font("Roboto Slab Black", Font.BOLD, 13));
		
		JButton btn_cierre_total_de_caja = new JButton("CIERRE TOTAL DE CAJA");
		btn_cierre_total_de_caja.setBounds(196, 546, 192, 23);
		panel.add(btn_cierre_total_de_caja);
		
		btn_cierre_total_de_caja.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				Caja_Cierre_Total_De_Caja cierre = new Caja_Cierre_Total_De_Caja();
				cierre.setFocusable(true);
				cierre.setLocationRelativeTo(null);
				cierre.setVisible(true);
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
	

	}


}
