package interfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Productos_Tabla_Ver_Movimientos extends JFrame {

	private JPanel contentPane;
	private JTable tbl_ver_movimiento;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Productos_Tabla_Ver_Movimientos frame = new Productos_Tabla_Ver_Movimientos();
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
	public Productos_Tabla_Ver_Movimientos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 870, 416);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 875, 377);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 854, 328);
		panel.add(scrollPane);
		
		tbl_ver_movimiento = new JTable();
		tbl_ver_movimiento.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"<html><center>FECHA</center></html>", "<html><center>USUARIO</center></html>", "<html><center>ID</center></html>", "<html><center>PRODUCTO</center></html>", "<html><center>DISTINTIVO 1</center></html>", "<html><center>STOCK</center></html>", "<html><center>RAZON</center></html>"
			}
		));
		scrollPane.setViewportView(tbl_ver_movimiento);
		
		JButton btn_ok = new JButton("OK");
		btn_ok.setFont(new Font("Dialog", Font.BOLD, 13));
		btn_ok.setBounds(381, 339, 102, 27);
		
		btn_ok.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		panel.add(btn_ok);
	}
}
