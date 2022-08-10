package interfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import conexionDB.DB_productos;
import conexionDB.DB_ventas;

import javax.swing.JLabel;
import java.awt.Font;
import java.sql.SQLException;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Ventas_movimientos extends JFrame {

	private JPanel contentPane;
	private JTable tbl_ver_movimientos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventas_movimientos frame = new Ventas_movimientos();
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
	public Ventas_movimientos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 767, 466);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btn_ver = new JButton("VER");
		btn_ver.setBounds(345, 393, 111, 23);
		contentPane.add(btn_ver);
		btn_ver.setFont(new Font("Dialog", Font.BOLD, 13));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(52, 33, 652, 297);
		contentPane.add(scrollPane);
		
		tbl_ver_movimientos = new JTable();
		scrollPane.setViewportView(tbl_ver_movimientos);
	}
	public void ver_datos(String fechaInicial,String fechaFinal) {
		try {
			tbl_ver_movimientos.setModel(DB_ventas.model_view_ventas_movimientos(fechaInicial, fechaFinal));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}