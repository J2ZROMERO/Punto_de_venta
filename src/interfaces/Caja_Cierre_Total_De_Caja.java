package interfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import conexionDB.DB_caja;
import conexionDB.DB_devoluciones_perdidas;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Caja_Cierre_Total_De_Caja extends JFrame {

	private JPanel contentPane;
	private JTable tbl_cierre_total_de_caja;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Caja_Cierre_Total_De_Caja frame = new Caja_Cierre_Total_De_Caja(3213,3213,321,80,80);
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
	public Caja_Cierre_Total_De_Caja(double saldoInicial , double entradas, double salidas, double saldoTotal,int id) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 815, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 799, 302);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 799, 69);
		panel.add(scrollPane);
		
		tbl_cierre_total_de_caja = new JTable();
		tbl_cierre_total_de_caja.setModel(new DefaultTableModel(
			new Object[][] {
				{saldoInicial,entradas,salidas,saldoTotal},
			},
			new String[] {
				"<html><center>SALDO INICIAL</center></html>", "<html><center>SALIDAS</center></html>", "<html><center>ENTRADAS</center></html>", "<html><center>TOTAL EN CAJA</center></html>"
			}
		));
		tbl_cierre_total_de_caja.setFont(new Font("Tahoma", Font.PLAIN, 11));
		scrollPane.setViewportView(tbl_cierre_total_de_caja);
		
		JButton btn_regresar = new JButton("REGRESAR");
		btn_regresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_regresar.setFont(new Font("Dialog", Font.BOLD, 13));
		btn_regresar.setBounds(209, 121, 120, 23);
		dispose();
		btn_regresar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
		
				Caja cajaRetorno = new Caja();
				cajaRetorno.setVisible(true);
				cajaRetorno.setLocationRelativeTo(null);
				
				dispose();
			}
		});
		panel.add(btn_regresar);
		
		JButton btn_cerrar_caja = new JButton("CERRAR CAJA");
		btn_cerrar_caja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object datosCierre[] = {tbl_cierre_total_de_caja.getValueAt(0,0 ),tbl_cierre_total_de_caja.getValueAt(0,1 ),tbl_cierre_total_de_caja.getValueAt(0,2 ),tbl_cierre_total_de_caja.getValueAt(0,3),id};
				
				try {
					DB_caja.cerrarCaja(datosCierre);
dispose();

Login inicio = new Login();
inicio.setVisible(true);
inicio.setLocationRelativeTo(null);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btn_cerrar_caja.setFont(new Font("Dialog", Font.BOLD, 13));
		btn_cerrar_caja.setBounds(464, 121, 142, 23);
		panel.add(btn_cerrar_caja);
	}


}
