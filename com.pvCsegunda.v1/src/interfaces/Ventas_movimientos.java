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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

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
		setResizable(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 928, 466);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(248, 196, 113));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btn_ver = new JButton("OK");
		btn_ver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btn_ver.setBounds(401, 393, 111, 23);
		contentPane.add(btn_ver);
		btn_ver.setFont(new Font("Dialog", Font.BOLD, 13));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 892, 371);
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
