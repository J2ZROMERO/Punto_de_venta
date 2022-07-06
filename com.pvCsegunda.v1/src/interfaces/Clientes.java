package interfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class Clientes extends JFrame {

	private JPanel contentPane;
	private JTextField txt_id;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTable tbl_clientes;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Clientes frame = new Clientes();
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
	public Clientes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 737, 531);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 721, 492);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btn_regresar = new JButton("");
		btn_regresar.setIcon(new ImageIcon(Clientes.class.getResource("/imagenes/flecha.png")));
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
		
		JLabel lbl_id = new JLabel("ID");
		lbl_id.setFont(new Font("Dialog", Font.BOLD, 13));
		lbl_id.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_id.setBounds(10, 59, 102, 20);
		panel.add(lbl_id);
		
		txt_id = new JTextField();
		txt_id.setFont(new Font("Dialog", Font.BOLD, 12));
		txt_id.setBounds(122, 59, 163, 20);
		panel.add(txt_id);
		txt_id.setColumns(10);
		
		JLabel lbl_nombre = new JLabel("NOMBRE");
		lbl_nombre.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_nombre.setFont(new Font("Dialog", Font.BOLD, 13));
		lbl_nombre.setBounds(10, 103, 102, 20);
		panel.add(lbl_nombre);
		
		textField = new JTextField();
		textField.setFont(new Font("Dialog", Font.BOLD, 12));
		textField.setColumns(10);
		textField.setBounds(122, 103, 163, 20);
		panel.add(textField);
		
		JLabel lbl_apellido = new JLabel("APELLIDO");
		lbl_apellido.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_apellido.setFont(new Font("Dialog", Font.BOLD, 13));
		lbl_apellido.setBounds(10, 149, 102, 20);
		panel.add(lbl_apellido);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Dialog", Font.BOLD, 12));
		textField_1.setColumns(10);
		textField_1.setBounds(122, 149, 163, 20);
		panel.add(textField_1);
		
		JLabel lbl_nikname = new JLabel("NIK-NAME");
		lbl_nikname.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_nikname.setFont(new Font("Dialog", Font.BOLD, 13));
		lbl_nikname.setBounds(10, 195, 102, 20);
		panel.add(lbl_nikname);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Dialog", Font.BOLD, 12));
		textField_2.setColumns(10);
		textField_2.setBounds(122, 195, 163, 20);
		panel.add(textField_2);
		
		JLabel lbl_telefono = new JLabel("TELEFONO");
		lbl_telefono.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_telefono.setFont(new Font("Dialog", Font.BOLD, 13));
		lbl_telefono.setBounds(10, 239, 102, 20);
		panel.add(lbl_telefono);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Dialog", Font.BOLD, 12));
		textField_3.setColumns(10);
		textField_3.setBounds(122, 239, 163, 20);
		panel.add(textField_3);
		
		JButton btn_limpiar_campos = new JButton("LIMPIAR CAMPOS");
		btn_limpiar_campos.setFont(new Font("Dialog", Font.BOLD, 13));
		btn_limpiar_campos.setBounds(73, 314, 154, 23);
		panel.add(btn_limpiar_campos);
		
		JButton btn_ver_clientes = new JButton("VER CLIENTES");
		btn_ver_clientes.setFont(new Font("Dialog", Font.BOLD, 13));
		btn_ver_clientes.setBounds(73, 376, 154, 23);
		panel.add(btn_ver_clientes);
		
		JButton btn_añadir = new JButton("AÑADIR");
		btn_añadir.setFont(new Font("Dialog", Font.BOLD, 13));
		btn_añadir.setBounds(449, 56, 154, 23);
		panel.add(btn_añadir);
		
		JButton btn_buscar = new JButton("BUSCAR");
		btn_buscar.setFont(new Font("Dialog", Font.BOLD, 13));
		btn_buscar.setBounds(449, 100, 154, 23);
		panel.add(btn_buscar);
		
		JButton btn_actualizar = new JButton("ACTUALIZAR");
		btn_actualizar.setFont(new Font("Dialog", Font.BOLD, 13));
		btn_actualizar.setBounds(449, 146, 154, 23);
		panel.add(btn_actualizar);
		
		JButton btn_eliminar = new JButton("ELIMINAR");
		btn_eliminar.setFont(new Font("Dialog", Font.BOLD, 13));
		btn_eliminar.setBounds(449, 192, 154, 23);
		panel.add(btn_eliminar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(319, 239, 392, 242);
		panel.add(scrollPane);
		
		tbl_clientes = new JTable();
		tbl_clientes.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"<html><center>ID</center></html>", "<html><center>NOMBRE</center></html>", "<html><center>TELEFONO</center></html>"
			}
		));
		scrollPane.setViewportView(tbl_clientes);
	}
}
