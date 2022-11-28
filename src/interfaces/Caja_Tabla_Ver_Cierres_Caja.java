package interfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import conexionDB.DB_caja;
import conexionDB.DB_devoluciones_perdidas;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.awt.Color;

public class Caja_Tabla_Ver_Cierres_Caja extends JFrame {

	private JPanel contentPane;
	private JTable tbl_ver_movimiento;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Caja_Tabla_Ver_Cierres_Caja frame = new Caja_Tabla_Ver_Cierres_Caja();
					frame.setVisible(true);
					frame.setFocusable(true);
					frame.setLocationRelativeTo(null);
					//frame.ver_datos("2022-11-28 02:23:36","2022-11-28 02:23:36");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Caja_Tabla_Ver_Cierres_Caja() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 870, 416);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(226, 132, 62));
		panel.setBounds(0, 0, 875, 377);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 833, 317);
		panel.add(scrollPane);
		
		tbl_ver_movimiento = new JTable();
		/*tbl_ver_movimiento.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"<html><center>USUARIO</center></html>", "<html><center>FECHA Y HORA</center></html>", "<html><center>MOVIMIENTO</center></html>", "<html><center>MOTIVO</center></html>", "<html><center>MONTO</center></html>"
			}
		));*/
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
	public void ver_datos(String fechaInicial,String fechaFinal) {
		try {
			tbl_ver_movimiento.setModel(DB_caja.model_view_dev_caja_Cierre(fechaInicial, fechaFinal));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
