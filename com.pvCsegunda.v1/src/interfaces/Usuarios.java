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

import conexionDB.DB_clientes;
import conexionDB.DB_usuarios;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Usuarios extends JFrame {

	private JPanel contentPane;
	private JTextField txt_id;
	private JTextField txt_nombre;
	private JTextField txt_apellido;
	private JTextField txt_segundo_apellido;
	private JTextField txt_nick_name;
	private JTable tbl_usuarios;
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
		txt_pass.setText("");
		txt_fecha.setText("");
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
		cbx_tipo_de_rol.setModel(new DefaultComboBoxModel(new String[] {"SELECCIONA UN ROL", "ADMINISTRADOR", "EMPLEADO"}));
		
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
		
		txt_id.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				int key = e.getKeyChar();

			    boolean numeros = key >= 48 && key <= 57;
			    
			    if (!numeros)
			    {
			        e.consume();
			    }
			    /*if (txt_id.getText().trim().length() == 10) {
			        e.consume();
			    }*/
			}
		});
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
		btn_limpiar_campos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_limpiar_campos.setFont(new Font("Roboto Slab Black", Font.BOLD, 13));
		btn_limpiar_campos.setBounds(111, 409, 164, 23);
		
		btn_limpiar_campos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Limpiar_Campos();
				txt_id.requestFocus();

				// campos que se bloquean cuando se selecciona algun dato a editar
				//txt_pass.setEnabled(true);
				txt_id.setEnabled(true);
			//	cbx_tipo_de_rol.setEnabled(true);
				//

			}		
		});
		panel.add(btn_limpiar_campos);
	
		JButton btn_a??adir = new JButton("A??ADIR");
		btn_a??adir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_a??adir.setFont(new Font("Roboto Slab Black", Font.BOLD, 13));
		btn_a??adir.setBounds(511, 56, 164, 23);
		
		btn_a??adir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Object datos[] = new Object[7];
				if(cbx_tipo_de_rol.getSelectedIndex() > 0  && !txt_id.equals("") && !txt_nombre.equals("") && !txt_apellido.equals("") && !txt_nick_name.equals("") && !txt_pass.equals("")) {
				datos[0] = txt_id.getText();
				datos[1] = cbx_tipo_de_rol.getSelectedItem().toString();
				datos[2] = txt_nombre.getText();
				datos[3] = txt_apellido.getText();
				datos[4] = txt_segundo_apellido.getText();
				datos[5] = txt_nick_name.getText();
				datos[6] = txt_pass.getText();
						
					
					
					try {
						DB_usuarios.anadir(datos);
						JOptionPane.showMessageDialog(null, "USUARIO AGREGADO CORRECTAMENTE");
						Limpiar_Campos();
						txt_id.requestFocus();
						ver_datos_tabla(tbl_usuarios);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
				}else {
					JOptionPane.showMessageDialog(null, "FAVOR DE LLENAR CAMPOS...");
				}
				
			}
		});
		panel.add(btn_a??adir);
		
		JButton btn_actualizar = new JButton("ACTUALIZAR");
		btn_actualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_actualizar.setFont(new Font("Roboto Slab Black", Font.BOLD, 13));
		btn_actualizar.setBounds(511, 102, 164, 23);
		
		btn_actualizar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				Object datos[] = new Object[7];
				datos[0] = txt_id.getText();
				datos[1] = cbx_tipo_de_rol.getSelectedItem().toString();
				datos[2] = txt_nombre.getText();
				datos[3] = txt_apellido.getText();
				datos[4] = txt_segundo_apellido.getText();
				datos[5] = txt_nick_name.getText();
				datos[6] = txt_pass.getText();
				
						
					
				if(cbx_tipo_de_rol.getSelectedIndex() > 0  && !txt_id.equals("") && !txt_nombre.equals("") && !txt_apellido.equals("") && !txt_nick_name.equals("") && !txt_pass.equals("")) {
				try {
					DB_usuarios.actualizar(datos);
					JOptionPane.showMessageDialog(null, "USUARIO ACTUALIZADO CORRECTAMENTE");
					Limpiar_Campos();
					txt_id.requestFocus();
					ver_datos_tabla(tbl_usuarios);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
				}else {
					JOptionPane.showMessageDialog(null, "FAVOR DE LLENAR CAMPOS...");
				}
			}
		});
		panel.add(btn_actualizar);
		
		JButton btn_eliminar = new JButton("ELIMINAR");
		btn_eliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_eliminar.setFont(new Font("Roboto Slab Black", Font.BOLD, 13));
		btn_eliminar.setBounds(511, 146, 164, 23);
		
		btn_eliminar.addMouseListener(new MouseAdapter() {
			@Override
			
			public void mouseClicked(MouseEvent e) {
				if(!txt_id.equals("")) {
					
                int opcion = JOptionPane.showConfirmDialog(null,"??ESTAS SEGURO DE ELIMINAR AL USUARIO?","??ALERTA!",JOptionPane.YES_NO_OPTION);
					
					if (opcion == 0) {
					try {
						DB_usuarios.eliminar(Integer.parseInt( txt_id.getText() ));
						ver_datos_tabla(tbl_usuarios);
						JOptionPane.showMessageDialog(null, "USUARIO ELIMINADO CORRECTAMENTE");
						Limpiar_Campos();
						txt_id.requestFocus();
					} catch (NumberFormatException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					}
				}else {
					JOptionPane.showMessageDialog(null, "FAVOR DE LLENAR CAMPOS...");
				}
			}
		});
		panel.add(btn_eliminar);
		
		
		JScrollPane scroll = new JScrollPane();
		scroll.setBounds(401, 192, 370, 256);
		panel.add(scroll);
	
		tbl_usuarios = new JTable();
tbl_usuarios.setFont(new Font("Roboto Slab", Font.BOLD, 12));
		scroll.setViewportView(tbl_usuarios);
		ver_datos_tabla(tbl_usuarios);
	
tbl_usuarios.addMouseListener( new MouseAdapter() {

	
			public void mousePressed(MouseEvent e) {
				
				String selectedCellValue = tbl_usuarios.getValueAt(tbl_usuarios.getSelectedRow() , 0).toString();
		        
				txt_id.setText(selectedCellValue);
		
		     
		
			    	 Object datos[];
						try {
							datos = DB_usuarios.buscar(Integer.parseInt(txt_id.getText()));
							
							

							 
							txt_id.setText(datos[0].toString());
							
							for(int i = 0; i < (cbx_tipo_de_rol.getItemCount());i++) {
	
								if(cbx_tipo_de_rol.getItemAt(i).toString().equals(datos[1].toString())) {
									cbx_tipo_de_rol.setSelectedIndex(i);
								}
								
								
							};
							
	
													
						
							
										
										if(datos[3] == null || datos[4] == null) {
											txt_nombre.setText(datos[2].toString());	
											txt_apellido.setText("");
											txt_segundo_apellido.setText("");
											txt_nick_name.setText(datos[5].toString());
											txt_pass.setText((String)datos[6]);											
											txt_fecha.setText((String)datos[7]);

											// campos que se bloquean cuando se selecciona algun dato a editar
										//	txt_pass.setEnabled(false);
											txt_id.setEnabled(false);
											//cbx_tipo_de_rol.setEnabled(false);
											//

											
										}else {
											txt_nombre.setText(datos[2].toString());	
											txt_apellido.setText(datos[3].toString());
											txt_segundo_apellido.setText(datos[4].toString());
											txt_nick_name.setText(datos[5].toString());
											txt_pass.setText((String)datos[6]);
											txt_fecha.setText((String)datos[7]);

											// campos que se bloquean cuando se selecciona algun dato a editar
											//txt_pass.setEnabled(false);
											txt_id.setEnabled(false);
											//cbx_tipo_de_rol.setEnabled(false);
											//
										}
										
						
						
						
						
						}

											
							
								
							
							
						
							
							
						 catch (NumberFormatException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
				
			    	 
			     
				
			       
		           
		            			
		
		}                              });
		

		
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
		
		JLabel lbl_fecha = new JLabel("REGISTRO");
		lbl_fecha.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_fecha.setFont(new Font("Roboto Slab Black", Font.BOLD, 13));
		lbl_fecha.setBounds(10, 376, 121, 22);
		panel.add(lbl_fecha);
		
		txt_pass = new JTextField();
		txt_pass.setFont(new Font("Dialog", Font.BOLD, 12));
		txt_pass.setColumns(10);
		txt_pass.setBounds(149, 334, 230, 22);
		
		txt_pass.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				int key = e.getKeyChar();

			    boolean numeros = key >= 48 && key <= 57;
			    
			    if (!numeros)
			    {
			        e.consume();
			    }
			    /*if (txt_id.getText().trim().length() == 10) {
			        e.consume();
			    }*/
			}
		});
		panel.add(txt_pass);
		
		txt_fecha = new JTextField();
		txt_fecha.setEnabled(false);
		txt_fecha.setFont(new Font("Dialog", Font.BOLD, 12));
		txt_fecha.setColumns(10);
		txt_fecha.setBounds(149, 376, 230, 22);
		panel.add(txt_fecha);
		
	}
	
	
	private void ver_datos_tabla(JTable tabla){
try {
	tabla.setModel(DB_usuarios.model_view_usuarios());
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
		
	}
	
	private JTextField txt_pass;
	private JTextField txt_fecha;
}



