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
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Clientes extends JFrame {

	private JPanel contentPane;
	private JTextField txt_id;
	private JTextField txt_nombre;
	private JTextField txt_apellido;
	private JTextField txt_nick_name;
	private JTextField txt_telefono;
	private JLabel lbl_alerta_1;
	private JLabel lbl_alerta_2;
	public static Clientes frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Clientes();
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
	
	
	public void Validar_Campos() {
		if(!"".equals(txt_nombre.getText())) {
			lbl_alerta_1.setForeground(new Color(135, 206, 250));
		}else {
			lbl_alerta_1.setForeground(new Color(0,0,0));
		}
		
		if(!"".equals(txt_nick_name.getText())) {
			lbl_alerta_2.setForeground(new Color(135, 206, 250));
		}else {
			lbl_alerta_2.setForeground(new Color(0,0,0));
		}
	}
	/**
	 * Create the frame.
	 */
	public Clientes() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 612, 396);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(135, 206, 250));
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(0, 0, 596, 357);
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
		
		txt_nombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				Validar_Campos();
			}
		});
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
		
		txt_nick_name.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				Validar_Campos();
			}
		});
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
		
		JButton btn_limpiar_campos = new JButton("");
		btn_limpiar_campos.setIcon(new ImageIcon(Clientes.class.getResource("/imagenes/escoba.png")));
		btn_limpiar_campos.setFont(new Font("Dialog", Font.BOLD, 13));
		btn_limpiar_campos.setBounds(399, 281, 154, 41);
		
		btn_limpiar_campos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Limpiar_Campos();
				txt_nombre.requestFocus();
				Validar_Campos();
			}
		});
		panel.add(btn_limpiar_campos);
		
		JButton btn_ver_clientes = new JButton("");
		btn_ver_clientes.setIcon(new ImageIcon(Clientes.class.getResource("/imagenes/tabla.png")));
		btn_ver_clientes.setFont(new Font("Dialog", Font.BOLD, 13));
		btn_ver_clientes.setBounds(122, 281, 163, 41);
		
		btn_ver_clientes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Clientes_Tabla_Ver_Clientes c = new Clientes_Tabla_Ver_Clientes();
				c.ver_clientes(txt_id, txt_nombre, txt_apellido, txt_nick_name, txt_telefono);
				c.setVisible(true);
				c.setFocusable(true);
				c.setLocationRelativeTo(null);
				frame.requestFocus();
				
			}
		});
		panel.add(btn_ver_clientes);
		
		JButton btn_añadir = new JButton("");
		btn_añadir.setIcon(new ImageIcon(Clientes.class.getResource("/imagenes/anadir.png")));
		btn_añadir.setFont(new Font("Dialog", Font.BOLD, 13));
		btn_añadir.setBounds(399, 41, 154, 41);
		
		btn_añadir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(!(txt_nombre.getText().equals("") && txt_nick_name.getText().equals(""))) {
					Object datos[] = { txt_nombre.getText(),txt_apellido.getText(),txt_nick_name.getText(),txt_telefono.getText()};
					try {
						DB_clientes.anadir(datos);
						//ver_datos_tabla(tbl_clientes);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					JOptionPane.showMessageDialog(null,"CLIENTE AÑADIDO");
							txt_nombre.requestFocus();
							Limpiar_Campos();
							Validar_Campos();
						}else {
							JOptionPane.showMessageDialog(null,"FAVOR DE RELLENAR CAMPOS");
							frame.requestFocus();
							Validar_Campos();
						}
			}
		});
		panel.add(btn_añadir);
		
		JButton btn_buscar = new JButton("");
		btn_buscar.setIcon(new ImageIcon(Clientes.class.getResource("/imagenes/buscar_tabla.png")));
		btn_buscar.setFont(new Font("Dialog", Font.BOLD, 13));
		btn_buscar.setBounds(399, 224, 154, 41);
		
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
					Validar_Campos();
				} else {
					JOptionPane.showMessageDialog(null, "DA CLICK EN VER TABLA DE CLIENTES");
					txt_nombre.requestFocus();
					Validar_Campos();
				}
			}
		});
		panel.add(btn_buscar);
		
		JButton btn_actualizar = new JButton("");
		btn_actualizar.setIcon(new ImageIcon(Clientes.class.getResource("/imagenes/actualizar.png")));
		btn_actualizar.setFont(new Font("Dialog", Font.BOLD, 13));
		btn_actualizar.setBounds(399, 103, 154, 41);
		
		btn_actualizar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if( !txt_nombre.getText().equals("") && !txt_nick_name.getText().equals("")
				   || txt_apellido.getText().equals("") ||  txt_telefono.getText().equals("")) {
					Object datos[] = {Integer.parseInt(  txt_id.getText()), txt_nombre.getText(),txt_apellido.getText(),txt_nick_name.getText(),txt_telefono.getText()};
					
					try {
						DB_clientes.actualizar(datos);
						Validar_Campos();
					//	ver_datos_tabla(tbl_clientes);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					JOptionPane.showMessageDialog(null,"CLIENTE ACTUALIZADO");
					Limpiar_Campos();
					txt_nombre.requestFocus();
					Validar_Campos();
				}else {
					Validar_Campos();
					frame.requestFocus();
				}
			}
		});
		panel.add(btn_actualizar);
		
		JButton btn_eliminar = new JButton("");
		btn_eliminar.setIcon(new ImageIcon(Clientes.class.getResource("/imagenes/basura.png")));
		btn_eliminar.setFont(new Font("Dialog", Font.BOLD, 13));
		btn_eliminar.setBounds(399, 163, 154, 41);
		
		btn_eliminar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!txt_id.getText().equals("") ) {
				   
					int opcion = JOptionPane.showConfirmDialog(null,"¿ESTAS SEGURO DE ELIMINAR AL CLIENTE?","¡ALERTA!",JOptionPane.YES_NO_OPTION);
					if(opcion == 0) {
						try {
						
						DB_clientes.eliminar(Integer.parseInt(txt_id.getText()));
						Validar_Campos();
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
						txt_nombre.requestFocus();
						Validar_Campos();
					}
					
				}else {
				   JOptionPane.showMessageDialog(null,"CAMPOS VACIOS...");
				   frame.requestFocus();
				   Validar_Campos();
				}
		 	}
		});
		panel.add(btn_eliminar);
		
		lbl_alerta_1 = new JLabel("*");
		lbl_alerta_1.setHorizontalTextPosition(SwingConstants.CENTER);
		lbl_alerta_1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_alerta_1.setForeground(Color.BLACK);
		lbl_alerta_1.setFont(new Font("Dialog", Font.BOLD, 23));
		lbl_alerta_1.setBounds(122, 124, 163, 20);
		panel.add(lbl_alerta_1);
		
		lbl_alerta_2 = new JLabel("*");
		lbl_alerta_2.setHorizontalTextPosition(SwingConstants.CENTER);
		lbl_alerta_2.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_alerta_2.setForeground(Color.BLACK);
		lbl_alerta_2.setFont(new Font("Dialog", Font.BOLD, 23));
		lbl_alerta_2.setBounds(122, 219, 163, 20);
		panel.add(lbl_alerta_2);
		
}
}
