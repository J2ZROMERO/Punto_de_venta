package interfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Devoluciones_Perdidas extends JFrame {

	private JPanel contentPane;
	private JTextField txt_id;
	private JTable table;
	private JTextField txt_fecha_inicial;
	private JTextField txt_fecha_final;
	private JTextField txt_id_cliente;
	private JButton btn_devolver;
	private JComboBox cbx_motivo;
	private JSpinner sp_cantidad;

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
		setBounds(100, 100, 519, 599);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 502, 560);
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
				Activar_Boton();
			}
		});
		txt_id.setColumns(10);
		
		JButton btn_buscar = new JButton("BUSCAR");
		btn_buscar.setFont(new Font("Roboto Slab Black", Font.BOLD, 13));
		btn_buscar.setBounds(269, 44, 100, 23);
		
		btn_buscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!txt_id.getText().equals("")) {
					JOptionPane.showMessageDialog(null,"LLENANDO CAMPOS");
				}else {
					Devoluciones_Perdidas_Buscar b = new Devoluciones_Perdidas_Buscar();
					b.setVisible(true);
					b.setLocationRelativeTo(null);
					b.setFocusable(true);
				}
			}
		});
		panel.add(btn_buscar);
		
		sp_cantidad = new JSpinner();
		sp_cantidad.setBounds(113, 201, 50, 29);
		
		sp_cantidad.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Activar_Boton();
			}
		});
		panel.add(sp_cantidad);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 89, 482, 98);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"<html><center>PRODUCTO</center></html>", "<html><center>PRIMER INDICADOR</center></html>", "<html><center> EXISTENCIA</center></html>", "<html><center> PRECIO</center></html>"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(65);
		table.getColumnModel().getColumn(1).setPreferredWidth(111);
		table.getColumnModel().getColumn(1).setMinWidth(20);
		table.getColumnModel().getColumn(2).setPreferredWidth(71);
		table.getColumnModel().getColumn(3).setPreferredWidth(51);
		scrollPane.setViewportView(table);
		
		JLabel lbl_motivo = new JLabel("MOTIVO");
		lbl_motivo.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_motivo.setFont(new Font("Roboto Slab Black", Font.BOLD, 13));
		lbl_motivo.setBounds(244, 205, 93, 20);
		panel.add(lbl_motivo);
		
		cbx_motivo = new JComboBox();
		cbx_motivo.setModel(new DefaultComboBoxModel(new String[] {"SELECCIONAR", "DEVOLUCION", "CADUCADO", "ABIERTO", "MAL ESTADO", "INSERVIBLE ", "INCOMPLETO"}));
		cbx_motivo.setFont(new Font("Roboto Slab", Font.BOLD, 12));
		cbx_motivo.setBounds(347, 204, 145, 22);
		
		cbx_motivo.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED) {
					if(cbx_motivo.getSelectedIndex()>0) {
						Activar_Boton();
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
		btn_devolver.setEnabled(false);
		btn_devolver.setFont(new Font("Roboto Slab Black", Font.BOLD, 13));
		btn_devolver.setBounds(184, 308, 110, 23);
		panel.add(btn_devolver);
		
		JLabel lbl_fecha_inicial = new JLabel("FECHA INICIAL");
		lbl_fecha_inicial.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_fecha_inicial.setFont(new Font("Roboto Slab Black", Font.BOLD, 13));
		lbl_fecha_inicial.setBounds(66, 376, 122, 18);
		panel.add(lbl_fecha_inicial);
		
		txt_fecha_inicial = new JTextField();
		txt_fecha_inicial.setFont(new Font("Roboto Slab", Font.BOLD, 12));
		txt_fecha_inicial.setColumns(10);
		txt_fecha_inicial.setBounds(198, 374, 145, 20);
		panel.add(txt_fecha_inicial);
		
		JLabel lbl_fecha_final = new JLabel("FECHA FINAL");
		lbl_fecha_final.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_fecha_final.setFont(new Font("Roboto Slab Black", Font.BOLD, 13));
		lbl_fecha_final.setBounds(66, 444, 122, 18);
		panel.add(lbl_fecha_final);
		
		txt_fecha_final = new JTextField();
		txt_fecha_final.setFont(new Font("Roboto Slab", Font.BOLD, 12));
		txt_fecha_final.setColumns(10);
		txt_fecha_final.setBounds(198, 442, 145, 20);
		panel.add(txt_fecha_final);
		
		JLabel lbl_calendario = new JLabel("");
		lbl_calendario.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_calendario.setIcon(new ImageIcon(Devoluciones_Perdidas.class.getResource("/imagenes/calendario.png")));
		lbl_calendario.setBounds(355, 353, 70, 58);
		panel.add(lbl_calendario);
		
		JLabel lbl_calendario_1 = new JLabel("");
		lbl_calendario_1.setIcon(new ImageIcon(Devoluciones_Perdidas.class.getResource("/imagenes/calendario.png")));
		lbl_calendario_1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_calendario_1.setBounds(355, 420, 70, 58);
		panel.add(lbl_calendario_1);
		
		JButton btn_ver_movimiento = new JButton("VER MOVIMIENTOS");
		btn_ver_movimiento.setFont(new Font("Roboto Slab Black", Font.BOLD, 13));
		btn_ver_movimiento.setBounds(167, 505, 176, 23);
		btn_ver_movimiento.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(!txt_fecha_inicial.getText().equals("") && !txt_fecha_final.getText().equals("")) {
					Devoluciones_Perdidas_Tabla_Ver_Movimientos tvm = new Devoluciones_Perdidas_Tabla_Ver_Movimientos();
					tvm.setVisible(true);
					tvm.setLocationRelativeTo(null);
					tvm.setFocusable(true);
				}else {
					JOptionPane.showMessageDialog(null,"DEBES SELECCIONAR UN RANGO DE FECHAS");
				}
				
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
		lbl_id_cliente.setBounds(113, 263, 113, 18);
		panel.add(lbl_id_cliente);
		
		txt_id_cliente = new JTextField();
		txt_id_cliente.setFont(new Font("Dialog", Font.BOLD, 12));
		txt_id_cliente.setColumns(10);
		txt_id_cliente.setBounds(236, 262, 133, 20);
		panel.add(txt_id_cliente);
	}
}
