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

public class Proveedores_Tabla_Buscar extends JFrame {

	private JPanel contentPane;
	private JTable tbl_provedores_buscar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Proveedores_Tabla_Buscar frame = new Proveedores_Tabla_Buscar();
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
	public Proveedores_Tabla_Buscar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 605, 467);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 589, 428);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 589, 374);
		panel.add(scrollPane);
		
		tbl_provedores_buscar = new JTable();
		tbl_provedores_buscar.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"<html><center>TIPO DE ROL</center></html>", "<html><center>ID</center></html>", "<html><center>NOMBRE</center></html>"
			}
		));
		scrollPane.setViewportView(tbl_provedores_buscar);
		
		JButton btn_ok = new JButton("OK");
		btn_ok.setBounds(214, 394, 127, 23);
		btn_ok.setFont(new Font("Dialog", Font.BOLD, 13));
		
		btn_ok.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		panel.add(btn_ok);
	}
}
