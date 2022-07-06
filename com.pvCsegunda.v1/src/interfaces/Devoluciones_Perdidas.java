package interfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
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

public class Devoluciones_Perdidas extends JFrame {

	private JPanel contentPane;
	private JTextField txt_id;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;

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
		lbl_id.setBounds(10, 47, 70, 18);
		panel.add(lbl_id);
		
		txt_id = new JTextField();
		txt_id.setFont(new Font("Roboto Slab", Font.BOLD, 12));
		txt_id.setBounds(90, 45, 110, 20);
		panel.add(txt_id);
		txt_id.setColumns(10);
		
		JButton btn_buscar = new JButton("BUSCAR");
		btn_buscar.setFont(new Font("Roboto Slab Black", Font.BOLD, 13));
		btn_buscar.setBounds(269, 44, 100, 23);
		panel.add(btn_buscar);
		
		JSpinner sp_cantidad = new JSpinner();
		sp_cantidad.setBounds(113, 201, 50, 29);
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
		lbl_motivo.setBounds(10, 241, 93, 20);
		panel.add(lbl_motivo);
		
		JComboBox cbx_motivo = new JComboBox();
		cbx_motivo.setModel(new DefaultComboBoxModel(new String[] {"DEVOLUCION", "CADUCADO", "ABIERTO", "MAL ESTADO", "INSERVIBLE ", "INCOMPLETO"}));
		cbx_motivo.setFont(new Font("Roboto Slab", Font.BOLD, 12));
		cbx_motivo.setBounds(113, 240, 145, 22);
		panel.add(cbx_motivo);
		
		JLabel lbl_cantidad = new JLabel("CANTIDAD");
		lbl_cantidad.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_cantidad.setFont(new Font("Roboto Slab Black", Font.BOLD, 13));
		lbl_cantidad.setBounds(10, 200, 93, 29);
		panel.add(lbl_cantidad);
		
		JButton btn_devolver = new JButton("DEVOLVER");
		btn_devolver.setFont(new Font("Roboto Slab Black", Font.BOLD, 13));
		btn_devolver.setBounds(113, 293, 110, 23);
		panel.add(btn_devolver);
		
		JLabel lbl_fecha_inicial = new JLabel("FECHA INICIAL");
		lbl_fecha_inicial.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_fecha_inicial.setFont(new Font("Roboto Slab Black", Font.BOLD, 13));
		lbl_fecha_inicial.setBounds(10, 379, 122, 18);
		panel.add(lbl_fecha_inicial);
		
		textField = new JTextField();
		textField.setFont(new Font("Roboto Slab", Font.BOLD, 12));
		textField.setColumns(10);
		textField.setBounds(142, 377, 145, 20);
		panel.add(textField);
		
		JLabel lbl_fecha_final = new JLabel("FECHA FINAL");
		lbl_fecha_final.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_fecha_final.setFont(new Font("Roboto Slab Black", Font.BOLD, 13));
		lbl_fecha_final.setBounds(10, 447, 122, 18);
		panel.add(lbl_fecha_final);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Roboto Slab", Font.BOLD, 12));
		textField_1.setColumns(10);
		textField_1.setBounds(142, 445, 145, 20);
		panel.add(textField_1);
		
		JLabel lbl_calendario = new JLabel("");
		lbl_calendario.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_calendario.setIcon(new ImageIcon(Devoluciones_Perdidas.class.getResource("/imagenes/calendario.png")));
		lbl_calendario.setBounds(299, 356, 70, 58);
		panel.add(lbl_calendario);
		
		JLabel lbl_calendario_1 = new JLabel("");
		lbl_calendario_1.setIcon(new ImageIcon(Devoluciones_Perdidas.class.getResource("/imagenes/calendario.png")));
		lbl_calendario_1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_calendario_1.setBounds(299, 423, 70, 58);
		panel.add(lbl_calendario_1);
		
		JButton btn_ver_movimiento = new JButton("VER MOVIMIENTOS");
		btn_ver_movimiento.setFont(new Font("Roboto Slab Black", Font.BOLD, 13));
		btn_ver_movimiento.setBounds(82, 505, 176, 23);
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
	}
}
