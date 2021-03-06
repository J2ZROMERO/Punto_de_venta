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
import java.sql.SQLException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import conexionDB.DB_clientes;
import conexionDB.DB_marcas;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Clientes extends JFrame {

	private JPanel contentPane;
	private JTextField txt_id;
	private JTextField txt_nombre;
	private JTextField txt_apellido;
	private JTextField txt_nick_name;
	private JTextField txt_telefono;

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

	public void Limpiar_Campos() {
		txt_id.setText("");
		txt_nombre.setText("");
		txt_apellido.setText("");
		txt_nick_name.setText("");
		txt_telefono.setText("");
	

	}
	/**
	 * Create the frame.
	 */
	public Clientes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 612, 396);
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
		txt_id.setEnabled(false);;
		panel.add(txt_id);
		txt_id.setColumns(10);
		
		JLabel lbl_nombre = new JLabel("NOMBRE");
		lbl_nombre.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_nombre.setFont(new Font("Dialog", Font.BOLD, 13));
		lbl_nombre.setBounds(10, 103, 102, 20);
		panel.add(lbl_nombre);
		
		txt_nombre = new JTextField();
		txt_nombre.setFont(new Font("Dialog", Font.BOLD, 12));
		txt_nombre.setColumns(10);
		txt_nombre.setBounds(122, 103, 163, 20);
		panel.add(txt_nombre);
		
		JLabel lbl_apellido = new JLabel("APELLIDO");
		lbl_apellido.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_apellido.setFont(new Font("Dialog", Font.BOLD, 13));
		lbl_apellido.setBounds(10, 149, 102, 20);
		panel.add(lbl_apellido);
		
		txt_apellido = new JTextField();
		txt_apellido.setFont(new Font("Dialog", Font.BOLD, 12));
		txt_apellido.setColumns(10);
		txt_apellido.setBounds(122, 149, 163, 20);
		panel.add(txt_apellido);
		
		JLabel lbl_nik_name = new JLabel("NIK NAME");
		lbl_nik_name.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_nik_name.setFont(new Font("Dialog", Font.BOLD, 13));
		lbl_nik_name.setBounds(10, 195, 102, 20);
		panel.add(lbl_nik_name);
		
		txt_nick_name = new JTextField();
		txt_nick_name.setFont(new Font("Dialog", Font.BOLD, 12));
		txt_nick_name.setColumns(10);
		txt_nick_name.setBounds(122, 195, 163, 20);
		panel.add(txt_nick_name);
		
		JLabel lbl_telefono = new JLabel("TELEFONO");
		lbl_telefono.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_telefono.setFont(new Font("Dialog", Font.BOLD, 13));
		lbl_telefono.setBounds(10, 239, 102, 20);
		panel.add(lbl_telefono);
		
		txt_telefono = new JTextField();
		txt_telefono.setFont(new Font("Dialog", Font.BOLD, 12));
		txt_telefono.setColumns(10);
		txt_telefono.setBounds(122, 239, 163, 20);
		panel.add(txt_telefono);
		
		JButton btn_limpiar_campos = new JButton("LIMPIAR CAMPOS");
		btn_limpiar_campos.setFont(new Font("Dialog", Font.BOLD, 13));
		btn_limpiar_campos.setBounds(399, 241, 154, 23);
		
		btn_limpiar_campos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Limpiar_Campos();
				txt_id.requestFocus();
			}
		});
		panel.add(btn_limpiar_campos);
		
		JButton btn_ver_clientes = new JButton("VER CLIENTES");
		btn_ver_clientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
			}
		});
		btn_ver_clientes.setFont(new Font("Dialog", Font.BOLD, 13));
		btn_ver_clientes.setBounds(122, 281, 154, 23);
		
		btn_ver_clientes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Clientes_Tabla_Ver_Clientes c = new Clientes_Tabla_Ver_Clientes();
		c.ver_clientes(txt_id, txt_nombre, txt_apellido, txt_nick_name, txt_telefono);
				c.setVisible(true);
				c.setFocusable(true);
				c.setLocationRelativeTo(null);
			}
		});
		panel.add(btn_ver_clientes);
		
		JButton btn_a??adir = new JButton("A??ADIR");
		btn_a??adir.setFont(new Font("Dialog", Font.BOLD, 13));
		btn_a??adir.setBounds(399, 59, 154, 23);
		
		btn_a??adir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(!(txt_nombre.getText().equals("") && txt_nick_name.getText().equals("") && txt_apellido.getText().equals("")
						&& txt_telefono.getText().equals(""))) {
					Object datos[] = { txt_nombre.getText(),txt_apellido.getText(),txt_nick_name.getText(),txt_telefono.getText()};
					try {
						DB_clientes.anadir(datos);
						//ver_datos_tabla(tbl_clientes);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					JOptionPane.showMessageDialog(null,"CLIENTE A??ADIDO");
							txt_nombre.requestFocus();
							Limpiar_Campos();
						}else {
							JOptionPane.showMessageDialog(null,"FAVOR DE RELLENAR CAMPOS");
							txt_nombre.requestFocus();
						}
			}
		});
		panel.add(btn_a??adir);
		
		JButton btn_buscar = new JButton("BUSCAR");
		btn_buscar.setFont(new Font("Dialog", Font.BOLD, 13));
		btn_buscar.setBounds(399, 103, 154, 23);
		
		btn_buscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (!txt_id.getText().equals("")){
		try {
			Object datos[]=    DB_clientes.buscar(Integer.parseInt(txt_id.getText()));
			
			txt_id.setText(datos[0].toString());
			txt_nombre.setText((String) datos[1]);
			txt_apellido.setText((String) datos[2]);
			txt_nick_name.setText((String) datos[3]);
			txt_telefono.setText((String) datos[4]);
			
			
			
		} catch (NumberFormatException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
					JOptionPane.showMessageDialog(null, "DEVOLVIENDO DATOS");
					//Limpiar_Campos();
				} else {
					JOptionPane.showMessageDialog(null, "DA CLICK EN BUSQUEDA DE CLIENTES");
				}
			}
		});
		panel.add(btn_buscar);
		
		JButton btn_actualizar = new JButton("ACTUALIZAR");
		btn_actualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_actualizar.setFont(new Font("Dialog", Font.BOLD, 13));
		btn_actualizar.setBounds(399, 149, 154, 23);
		
		btn_actualizar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if( !txt_nombre.getText().equals("") && !txt_nick_name.getText().equals("")
				   || txt_apellido.getText().equals("") ||  txt_telefono.getText().equals("")) {
					Object datos[] = {Integer.parseInt(  txt_id.getText()), txt_nombre.getText(),txt_apellido.getText(),txt_nick_name.getText(),txt_telefono.getText()};
					
					try {
						DB_clientes.actualizar(datos);
					//	ver_datos_tabla(tbl_clientes);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					JOptionPane.showMessageDialog(null,"CLIENTE ACTUALIZADO");
					Limpiar_Campos();
				}else {
					JOptionPane.showMessageDialog(null,"CAMPOS VACIOS...");
				}
			}
		});
		panel.add(btn_actualizar);
		
		JButton btn_eliminar = new JButton("ELIMINAR");
		btn_eliminar.setFont(new Font("Dialog", Font.BOLD, 13));
		btn_eliminar.setBounds(399, 195, 154, 23);
		
		btn_eliminar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!txt_id.getText().equals("") ) {
				   
					int opcion = JOptionPane.showConfirmDialog(null,"??ESTAS SEGURO DE ELIMINAR AL CLIENTE?","??ALERTA!",JOptionPane.YES_NO_OPTION);
					if(opcion == 0) {
						try {
						
						
							DB_clientes.eliminar(Integer.parseInt(txt_id.getText()));
						//	ver_datos_tabla(tbl_clientes);
							
						} catch (NumberFormatException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						JOptionPane.showMessageDialog(null,"CLIENTE ELIMINADO");
						Limpiar_Campos();
						txt_id.requestFocus();
					}
					
				}else {
				   JOptionPane.showMessageDialog(null,"CAMPOS VACIOS...");
				}
		 	}
		});
		panel.add(btn_eliminar);
		
}

}
