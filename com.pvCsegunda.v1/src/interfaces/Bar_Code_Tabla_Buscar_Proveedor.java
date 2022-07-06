package interfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Bar_Code_Tabla_Buscar_Proveedor extends JFrame {

	private JPanel contentPane;
	private JTable tbl_productos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bar_Code_Tabla_Buscar_Proveedor frame = new Bar_Code_Tabla_Buscar_Proveedor();
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
	public Bar_Code_Tabla_Buscar_Proveedor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 801, 515);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 785, 476);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 785, 423);
		panel.add(scrollPane);
		
		tbl_productos = new JTable();
		scrollPane.setViewportView(tbl_productos);
		tbl_productos.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"<html><center>ID</center></html>", "<html><center>PRODUCTO</center></html>", "<html><center>DISTINTIVO 1</center></html>", "<html><center>MARCA</center></html>"
			}
		));
		
		JButton btn_ok = new JButton("OK");
		btn_ok.setFont(new Font("Dialog", Font.BOLD, 13));
		btn_ok.setBounds(312, 442, 127, 23);
		
		btn_ok.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		panel.add(btn_ok);
	}

}
