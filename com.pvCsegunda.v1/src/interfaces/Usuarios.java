package interfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;

public class Usuarios extends JFrame {

	private JPanel contentPane;
	private JTextField txt_id;
	private JTextField txt_nombre;
	private JTextField txt_apellido;
	private JTextField txt_segundo_apellido;
	private JTextField txt_nick_name;
	private JTable tbl_usuarios;
	private JTable table_1;
	private JPasswordField txt_password;
	private JComboBox cbx_tipo_de_rol;
	private static Usuarios frame;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Usuarios();
					frame.setVisible(true);
					frame.setFocusable(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void Limpiar_Campos() {
		cbx_tipo_de_rol.setSelectedIndex(0);
		txt_id.setText("");
		txt_nombre.setText("");
		txt_apellido.setText("");
		txt_segundo_apellido.setText("");
		txt_nick_name.setText("");
		txt_password.setText("");
	}
	
	public Usuarios() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 808, 498);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 792, 459);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lbl_tipo_de_rol = new JLabel("TIPO DE ROL");
		lbl_tipo_de_rol.setFont(new Font("Roboto Slab Black", Font.BOLD, 13));
		lbl_tipo_de_rol.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_tipo_de_rol.setBounds(10, 56, 121, 22);
		panel.add(lbl_tipo_de_rol);
		
		cbx_tipo_de_rol = new JComboBox();
		cbx_tipo_de_rol.setModel(new DefaultComboBoxModel(new String[] {"SELECCIONA UN ROL", "ADMINISTRADOR", "INVITADO"}));
		cbx_tipo_de_rol.setFont(new Font("Roboto Slab", Font.BOLD, 12));
		cbx_tipo_de_rol.setBounds(149, 56, 230, 22);
		panel.add(cbx_tipo_de_rol);
		
		JLabel lbl_id = new JLabel("ID");
		lbl_id.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_id.setFont(new Font("Roboto Slab Black", Font.BOLD, 13));
		lbl_id.setBounds(10, 100, 121, 22);
		panel.add(lbl_id);
		
		txt_id = new JTextField();
		txt_id.setFont(new Font("Roboto Slab", Font.BOLD, 12));
		txt_id.setBounds(149, 100, 230, 22);
		panel.add(txt_id);
		txt_id.setColumns(10);
		
		JLabel lbl_nombre = new JLabel("NOMBRE");
		lbl_nombre.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_nombre.setFont(new Font("Roboto Slab Black", Font.BOLD, 13));
		lbl_nombre.setBounds(10, 146, 121, 22);
		panel.add(lbl_nombre);
		
		txt_nombre = new JTextField();
		txt_nombre.setFont(new Font("Roboto Slab", Font.BOLD, 12));
		txt_nombre.setColumns(10);
		txt_nombre.setBounds(149, 146, 230, 22);
		panel.add(txt_nombre);
		
		JLabel lbl_apellido = new JLabel("APELLIDO");
		lbl_apellido.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_apellido.setFont(new Font("Roboto Slab Black", Font.BOLD, 13));
		lbl_apellido.setBounds(10, 190, 121, 22);
		panel.add(lbl_apellido);
		
		txt_apellido = new JTextField();
		txt_apellido.setFont(new Font("Roboto Slab", Font.BOLD, 12));
		txt_apellido.setColumns(10);
		txt_apellido.setBounds(149, 190, 230, 22);
		panel.add(txt_apellido);
		
		JLabel lbl_segundo_apellido = new JLabel("<html><center>SEGUNDO APELLIDO</center></html>");
		lbl_segundo_apellido.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_segundo_apellido.setFont(new Font("Roboto Slab Black", Font.BOLD, 13));
		lbl_segundo_apellido.setBounds(10, 234, 121, 36);
		panel.add(lbl_segundo_apellido);
		
		txt_segundo_apellido = new JTextField();
		txt_segundo_apellido.setFont(new Font("Roboto Slab", Font.BOLD, 12));
		txt_segundo_apellido.setColumns(10);
		txt_segundo_apellido.setBounds(149, 240, 230, 22);
		panel.add(txt_segundo_apellido);
		
		JLabel lbl_nick_name = new JLabel("NICK NAME");
		lbl_nick_name.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_nick_name.setFont(new Font("Roboto Slab Black", Font.BOLD, 13));
		lbl_nick_name.setBounds(10, 291, 121, 22);
		panel.add(lbl_nick_name);
		
		txt_nick_name = new JTextField();
		txt_nick_name.setFont(new Font("Roboto Slab", Font.BOLD, 12));
		txt_nick_name.setColumns(10);
		txt_nick_name.setBounds(149, 291, 230, 22);
		panel.add(txt_nick_name);
		
		JLabel lbl_password = new JLabel("PASSWORD");
		lbl_password.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_password.setFont(new Font("Roboto Slab Black", Font.BOLD, 13));
		lbl_password.setBounds(10, 334, 121, 22);
		panel.add(lbl_password);
		
		JButton btn_limpiar_campos = new JButton("LIMPIAR CAMPOS");
		btn_limpiar_campos.setFont(new Font("Roboto Slab Black", Font.BOLD, 13));
		btn_limpiar_campos.setBounds(111, 398, 164, 23);
		
		btn_limpiar_campos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Limpiar_Campos();
				txt_id.requestFocus();
			}		
		});
		panel.add(btn_limpiar_campos);
	
		JButton btn_añadir = new JButton("AÑADIR");
		btn_añadir.setFont(new Font("Roboto Slab Black", Font.BOLD, 13));
		btn_añadir.setBounds(511, 12, 164, 23);
		
		btn_añadir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(cbx_tipo_de_rol.getSelectedIndex() > 0  && !txt_id.equals("") && !txt_nombre.equals("") && !txt_apellido.equals("") && !txt_nick_name.equals("") && !txt_password.equals("")) {
					JOptionPane.showMessageDialog(null, "USUARIO AGREGADO CORRECTAMENTE");
					Limpiar_Campos();
					txt_id.requestFocus();
				}else {
					JOptionPane.showMessageDialog(null, "FAVOR DE LLENAR CAMPOS...");
				}
				
			}
		});
		panel.add(btn_añadir);
		
		JButton btn_buscar = new JButton(" BUSCAR");
		btn_buscar.setFont(new Font("Roboto Slab Black", Font.BOLD, 13));
		btn_buscar.setBounds(511, 56, 164, 23);
		
		btn_buscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(!txt_id.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "LLENANDO CAMPOS CON LOS DATOS CORRESPONDIENTES");
				}else {	
					Usuarios_Tabla_Buscar tb = new Usuarios_Tabla_Buscar();
					tb.setVisible(true);
					tb.setLocationRelativeTo(null);
					tb.setFocusable(true);
				}
			}
		});
		panel.add(btn_buscar);
		
		JButton btn_actualizar = new JButton("ACTUALIZAR");
		btn_actualizar.setFont(new Font("Roboto Slab Black", Font.BOLD, 13));
		btn_actualizar.setBounds(511, 102, 164, 23);
		
		btn_actualizar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(cbx_tipo_de_rol.getSelectedIndex() > 0  && !txt_id.equals("") && !txt_nombre.equals("") && !txt_apellido.equals("") && !txt_nick_name.equals("") && !txt_password.equals("")) {
					JOptionPane.showMessageDialog(null, "USUARIO ACTUALIZADO CORRECTAMENTE");
					Limpiar_Campos();
					txt_id.requestFocus();
				}else {
					JOptionPane.showMessageDialog(null, "FAVOR DE LLENAR CAMPOS...");
				}
			}
		});
		panel.add(btn_actualizar);
		
		JButton btn_eliminar = new JButton("ELIMINAR");
		btn_eliminar.setFont(new Font("Roboto Slab Black", Font.BOLD, 13));
		btn_eliminar.setBounds(511, 146, 164, 23);
		
		btn_eliminar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(cbx_tipo_de_rol.getSelectedIndex() > 0  && !txt_id.equals("") && !txt_nombre.equals("") && !txt_apellido.equals("") && !txt_nick_name.equals("") && !txt_password.equals("")) {
					JOptionPane.showMessageDialog(null, "USUARIO ELIMINADO CORRECTAMENTE");
					Limpiar_Campos();
					txt_id.requestFocus();
				}else {
					JOptionPane.showMessageDialog(null, "FAVOR DE LLENAR CAMPOS...");
				}
			}
		});
		panel.add(btn_eliminar);
		
		JScrollPane scroll = new JScrollPane();
		scroll.setBounds(401, 192, 370, 256);
		panel.add(scroll);
//// tabla		
		tbl_usuarios = new JTable();
		tbl_usuarios.setModel(new DefaultTableModel(
			new Object[][] {
				{"administrador", "1", "admin1"},
				{"invitado","2","invitado2"},
				{"invitado","3","invitado3"}
			},
			new String[] {
				"ROL", "ID", "NICK_NAME"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, Object.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		
		
		///
		tbl_usuarios.setFont(new Font("Roboto Slab", Font.BOLD, 12));
		scroll.setViewportView(tbl_usuarios);
		
		JButton btn_regresar = new JButton("");
		btn_regresar.setIcon(new ImageIcon(Usuarios.class.getResource("/imagenes/flecha.png")));
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
		
		table_1 = new JTable();
		table_1.setBounds(347, 423, 221, -100);
		panel.add(table_1);
		
		txt_password = new JPasswordField();
		txt_password.setFont(new Font("Roboto Slab Black", Font.BOLD, 14));
		txt_password.setBounds(149, 334, 230, 22);
		panel.add(txt_password);
		
	}
}



