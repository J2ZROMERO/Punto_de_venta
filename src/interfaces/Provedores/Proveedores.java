package interfaces.Provedores;
 
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import conexionDB.DB_provedores;
import conexionDB.DB_usuarios;
import interfaces.Menu_principal;

import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Proveedores extends JFrame {

	private JPanel contentPane;
	private JTextField txt_id;
	private JLabel lbl_nombre;
	private JTextField txt_nombre;
	private JLabel lbl_apellido;
	private JTextField txt_apellido;
	private JLabel lbl_contacto;
	private JTextField txt_contacto;
	private JLabel lbl_empresa_para_la_que_trabaja;
	private JTextField txt_empresa_para_la_que_trabaja;
	private JLabel lbl_nombre_supervisor;
	private JTextField txt_nombre_supervisor;
	private JLabel lbl_contacto_supervisor;
	private JTextField txt_contacto_del_supervisor;
	private JTable tbl_proveedores;
	private JButton btn_regresar;
	private static Proveedores frame;
	private JLabel lbl_alerta_1;
	private JLabel lbl_alerta_2;

	
	
	
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Proveedores();
					frame.setVisible(true);
					frame.Validar_Campos();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void Validar_Campos() {
		if(!"".equals(txt_nombre.getText())) {
			lbl_alerta_2.setForeground(new Color(186, 104, 200));
		}else {
			lbl_alerta_2.setForeground(new Color(0,0,0));
		}
	}
	
	public void Limpiar_Campos() {
		txt_id.setEnabled(false);
		txt_id.setText("");
		txt_nombre.setText("");
		txt_apellido.setText("");
		txt_contacto.setText("");
		txt_empresa_para_la_que_trabaja.setText("");
		txt_nombre_supervisor.setText("");
		txt_contacto_del_supervisor.setText("");
	}

	/**
	 * Create the frame.
	 */
	public Proveedores() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
			
			txt_nombre.requestFocus();
			}
		});
		setResizable(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 780, 571);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(new Color(186, 104, 200));
		panel.setBounds(0, 0, 764, 532);
		contentPane.add(panel);
		panel.setLayout(null);
		
		txt_nombre = new JTextField();
		txt_nombre.setFont(new Font("Roboto Light", Font.BOLD, 13));
		txt_nombre.setColumns(10);
		txt_nombre.setBounds(140, 107, 198, 20);
		txt_nombre.requestFocus();
		txt_nombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				Validar_Campos();
			}
		});
		panel.add(txt_nombre);
		
		
		JLabel lbl_id = new JLabel("ID");
		lbl_id.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_id.setFont(new Font("Dialog", Font.BOLD, 13));
		lbl_id.setBounds(10, 60, 120, 20);
		panel.add(lbl_id);
		
		txt_id = new JTextField();
		txt_id.setEditable(false);
		txt_id.setFont(new Font("Roboto Light", Font.BOLD, 13));
		txt_id.setBounds(140, 60, 198, 20);
		panel.add(txt_id);
		txt_id.setColumns(10);
		
		lbl_nombre = new JLabel("NOMBRE");
		lbl_nombre.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_nombre.setFont(new Font("Dialog", Font.BOLD, 13));
		lbl_nombre.setBounds(10, 107, 120, 20);
		panel.add(lbl_nombre);
		
		lbl_apellido = new JLabel("APELLIDO");
		lbl_apellido.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_apellido.setFont(new Font("Dialog", Font.BOLD, 13));
		lbl_apellido.setBounds(10, 153, 120, 20);
		panel.add(lbl_apellido);
		
		txt_apellido = new JTextField();
		txt_apellido.setFont(new Font("Roboto Light", Font.BOLD, 13));
		txt_apellido.setColumns(10);
		txt_apellido.setBounds(140, 153, 198, 20);
		panel.add(txt_apellido);
		
		lbl_contacto = new JLabel("<html><center>CONTACTO</center></html>");
		lbl_contacto.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_contacto.setFont(new Font("Dialog", Font.BOLD, 13));
		lbl_contacto.setBounds(10, 201, 120, 46);
		panel.add(lbl_contacto);
		
		txt_contacto = new JTextField();
		txt_contacto.setFont(new Font("Roboto Light", Font.BOLD, 13));
		txt_contacto.setColumns(10);
		txt_contacto.setBounds(140, 216, 198, 20);
		panel.add(txt_contacto);
		
		lbl_empresa_para_la_que_trabaja = new JLabel("<html><center>EMPRESA PARA LA QUE TRABAJA </center></html>");
		lbl_empresa_para_la_que_trabaja.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_empresa_para_la_que_trabaja.setFont(new Font("Dialog", Font.BOLD, 13));
		lbl_empresa_para_la_que_trabaja.setBounds(10, 258, 120, 51);
		panel.add(lbl_empresa_para_la_que_trabaja);
		
		txt_empresa_para_la_que_trabaja = new JTextField();
		txt_empresa_para_la_que_trabaja.setFont(new Font("Roboto Light", Font.BOLD, 13));
		txt_empresa_para_la_que_trabaja.setColumns(10);
		txt_empresa_para_la_que_trabaja.setBounds(140, 271, 198, 20);
		panel.add(txt_empresa_para_la_que_trabaja);
		
		lbl_nombre_supervisor = new JLabel("<html><center>NOMBRE SUPERVISOR</center></html>");
		lbl_nombre_supervisor.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_nombre_supervisor.setFont(new Font("Dialog", Font.BOLD, 13));
		lbl_nombre_supervisor.setBounds(10, 320, 120, 46);
		panel.add(lbl_nombre_supervisor);
		
		txt_nombre_supervisor = new JTextField();
		txt_nombre_supervisor.setFont(new Font("Roboto Light", Font.BOLD, 13));
		txt_nombre_supervisor.setColumns(10);
		txt_nombre_supervisor.setBounds(140, 330, 198, 20);
		panel.add(txt_nombre_supervisor);
		
		lbl_contacto_supervisor = new JLabel("<html><center>CONTACTO SUPERVISOR</center></html>");
		lbl_contacto_supervisor.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_contacto_supervisor.setFont(new Font("Dialog", Font.BOLD, 13));
		lbl_contacto_supervisor.setBounds(10, 377, 120, 36);
		panel.add(lbl_contacto_supervisor);
		
		txt_contacto_del_supervisor = new JTextField();
		txt_contacto_del_supervisor.setFont(new Font("Roboto Light", Font.BOLD, 13));
		txt_contacto_del_supervisor.setColumns(10);
		txt_contacto_del_supervisor.setBounds(140, 383, 198, 20);
		panel.add(txt_contacto_del_supervisor);
		
		JButton btn_limpiar_campos = new JButton("");
		btn_limpiar_campos.setIcon(new ImageIcon(Proveedores.class.getResource("/imagenes/escoba.png")));
		btn_limpiar_campos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_limpiar_campos.setFont(new Font("Dialog", Font.BOLD, 12));
		btn_limpiar_campos.setBounds(97, 447, 159, 46);
		
		btn_limpiar_campos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Limpiar_Campos();
				txt_nombre.requestFocus();				
			}
		});
		panel.add(btn_limpiar_campos);
		
		JButton btn_anadir = new JButton("");
		btn_anadir.setIcon(new ImageIcon(Proveedores.class.getResource("/imagenes/anadir.png")));
		btn_anadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_anadir.setFont(new Font("Dialog", Font.BOLD, 12));
		btn_anadir.setBounds(468, 60, 159, 46);
		
		
		
		
		
		btn_anadir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				try {
					
					if(!txt_nombre.getText().equalsIgnoreCase("")) {
						
						
						if(!txt_id.getText().equalsIgnoreCase("")) {
							
							if(DB_provedores.compararprovedores(Integer.parseInt(txt_id.getText())) == false) {
								
								Object datos[] = new Object[6];
								datos[0] = txt_nombre.getText().toString();
								datos[1] = txt_apellido.getText().toString();
								datos[2] = txt_contacto.getText().toString();
								datos[3] = txt_empresa_para_la_que_trabaja.getText().toString();
								datos[4] = txt_nombre_supervisor.getText().toString();
								datos[5] = txt_contacto_del_supervisor.getText().toString();
								
								try {
									DB_provedores.anadir(datos);
									JOptionPane.showMessageDialog(null,"PROVEEDOR AGREGADO CORRECTAMENTE");
									Limpiar_Campos();
									txt_nombre.requestFocus();
									Validar_Campos();
									ver_datos_tabla(tbl_proveedores);
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								
								
								
							}else {
								JOptionPane.showMessageDialog(null,"ESTE ID YA EXISTE");
								Limpiar_Campos();
								txt_nombre.requestFocus();
								
							}
							
						}else {

							Object datos[] = new Object[6];
							datos[0] = txt_nombre.getText().toString();
							datos[1] = txt_apellido.getText().toString();
							datos[2] = txt_contacto.getText().toString();
							datos[3] = txt_empresa_para_la_que_trabaja.getText().toString();
							datos[4] = txt_nombre_supervisor.getText().toString();
							datos[5] = txt_contacto_del_supervisor.getText().toString();
							
							try {
								DB_provedores.anadir(datos);
								JOptionPane.showMessageDialog(null,"PROVEEDOR AGREGADO CORRECTAMENTE");
								Limpiar_Campos();
								txt_nombre.requestFocus();
								Validar_Campos();
								ver_datos_tabla(tbl_proveedores);
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
							
						}
					}else{
						JOptionPane.showMessageDialog(null, "AGREGA CAMPOS NECESARIOS '*' SON LOS MAS IMPORTANTES");
					}
					
				} catch (NumberFormatException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
				
			}
		});
		panel.add(btn_anadir);
		
		JButton btn_actualizar = new JButton("");
		btn_actualizar.setIcon(new ImageIcon(Proveedores.class.getResource("/imagenes/actualizar.png")));
		btn_actualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_actualizar.setFont(new Font("Dialog", Font.BOLD, 12));
		btn_actualizar.setBounds(577, 127, 159, 46);
		
		btn_actualizar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(!txt_id.getText().equals("")) {	
							
				Object datos [] =  new Object[7];
				datos[0] =txt_id.getText().toString();
						datos[1] =txt_nombre.getText().toString();
								datos[2] =txt_apellido.getText().toString();
										datos[3] =txt_contacto.getText().toString();
												datos[4] =txt_empresa_para_la_que_trabaja.getText().toString();
														datos[5] =txt_nombre_supervisor.getText().toString();
																datos[6] =txt_contacto_del_supervisor.getText().toString();
				try {
					DB_provedores.actualizar(datos);
					
					JOptionPane.showMessageDialog(null,"PROVEEDOR ACTUALIZADO CORRECTAMENTE");
							Limpiar_Campos();
							txt_nombre.requestFocus();
							ver_datos_tabla(tbl_proveedores);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		
						}else {
							JOptionPane.showMessageDialog(null,"CAMPOS VACIOS...");
							txt_nombre.requestFocus();
						}
			}
		});
		panel.add(btn_actualizar);
		
		JButton btn_eliminar = new JButton("");
		btn_eliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_eliminar.setIcon(new ImageIcon(Proveedores.class.getResource("/imagenes/basura.png")));
		btn_eliminar.setFont(new Font("Dialog", Font.BOLD, 12));
		btn_eliminar.setBounds(371, 127, 159, 46);
		
		btn_eliminar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(!txt_id.getText().equals("")) {	
                int opcion = JOptionPane.showConfirmDialog(null,"¿ESTAS SEGURO DE ELIMINAR EL PROVEEDOR?","¡ALERTA!",JOptionPane.YES_NO_OPTION);
					
					if (opcion == 0) {
					try {
						DB_provedores.eliminar(  Integer.parseInt( txt_id.getText()));
						JOptionPane.showMessageDialog(null,"PROVEEDOR ELIMINADO CORRECTAMENTE");
						Limpiar_Campos();
						txt_nombre.requestFocus();
						ver_datos_tabla(tbl_proveedores);
					} catch (NumberFormatException e1) {
						// 	JOptionPane.showMessageDialog(null,"USUARIO ELIMINADO CORRECTAMENTE");
					
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					}
						}else {
							JOptionPane.showMessageDialog(null,"CAMPOS VACIOS...");
							txt_nombre.requestFocus();	
						}
			}
		});
		panel.add(btn_eliminar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(371, 197, 365, 324);
		panel.add(scrollPane);
		
		tbl_proveedores = new JTable();
		tbl_proveedores.setSelectionBackground(new Color(186, 104, 200));
		tbl_proveedores.setBackground(new Color(84, 153, 199));
		ver_datos_tabla(tbl_proveedores);
		tbl_proveedores.addMouseListener( new MouseAdapter() {

	
			public void mousePressed(MouseEvent e) {
				
				String selectedCellValue = tbl_proveedores.getValueAt(tbl_proveedores.getSelectedRow() , 0).toString();
				txt_id.setText(selectedCellValue);


			    	 Object datos[];

							try {
								datos = DB_provedores.buscar(Integer.parseInt(txt_id.getText()));
								
								txt_nombre.setText(datos[1].toString());	
								txt_apellido.setText(datos[2].toString());
								txt_contacto.setText(datos[3].toString());
								txt_empresa_para_la_que_trabaja.setText(datos[4].toString());
								txt_nombre_supervisor.setText((String)datos[5]);
								txt_contacto_del_supervisor.setText((String)datos[6]);
								txt_nombre.requestFocus();
							} catch (NumberFormatException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
							
						
		}});
		tbl_proveedores.setFont(new Font("Dialog", Font.BOLD, 12));
		scrollPane.setViewportView(tbl_proveedores);
		
		btn_regresar = new JButton("");
		btn_regresar.setIcon(new ImageIcon(Proveedores.class.getResource("/imagenes/flecha.png")));
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
		
		lbl_alerta_1 = new JLabel("*");
		lbl_alerta_1.setHorizontalTextPosition(SwingConstants.CENTER);
		lbl_alerta_1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_alerta_1.setForeground(new Color(186, 104, 200));
		lbl_alerta_1.setFont(new Font("Dialog", Font.BOLD, 23));
		lbl_alerta_1.setBounds(140, 82, 198, 24);
		panel.add(lbl_alerta_1);
		
		lbl_alerta_2 = new JLabel("*");
		lbl_alerta_2.setHorizontalTextPosition(SwingConstants.CENTER);
		lbl_alerta_2.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_alerta_2.setForeground(new Color(0,0,0));
		lbl_alerta_2.setFont(new Font("Dialog", Font.BOLD, 23));
		lbl_alerta_2.setBounds(140, 127, 198, 24);
		panel.add(lbl_alerta_2);
		
		JTextField inputs[] =  new JTextField[7];
		inputs[0] = txt_apellido;
		inputs[1] = txt_contacto;
		inputs[2] = txt_contacto_del_supervisor;
		inputs[3] = txt_empresa_para_la_que_trabaja;
		inputs[4] = txt_nombre;
		inputs[5] = txt_nombre_supervisor;
		inputs[6] = txt_id;
		
		
		listenElementosToEnter(inputs);
	}
	private void listenElementosToEnter(JTextField txt_id[]) {
		
		
		for(int i = 0; i < txt_id.length;i++) {
			
		txt_id[i].addKeyListener(new KeyAdapter() {
				
				public void keyPressed(KeyEvent e) {
					if(e.getKeyCode() == KeyEvent.VK_ENTER) {
									
					

							try {
								
								if(!txt_id[4].getText().equalsIgnoreCase("")) {
									
									
									if(!txt_id[6].getText().equalsIgnoreCase("")) {
										
										if(DB_provedores.compararprovedores(Integer.parseInt(txt_id[6].getText())) == false) {
											
											Object datos[] = new Object[6];
											datos[0] = txt_nombre.getText().toString();
											datos[1] = txt_apellido.getText().toString();
											datos[2] = txt_contacto.getText().toString();
											datos[3] = txt_empresa_para_la_que_trabaja.getText().toString();
											datos[4] = txt_nombre_supervisor.getText().toString();
											datos[5] = txt_contacto_del_supervisor.getText().toString();
											
											try {
												DB_provedores.anadir(datos);
												JOptionPane.showMessageDialog(null,"PROVEEDOR AGREGADO CORRECTAMENTE");
												Limpiar_Campos();
												txt_nombre.requestFocus();
												Validar_Campos();
												ver_datos_tabla(tbl_proveedores);
											} catch (SQLException e1) {
												// TODO Auto-generated catch block
												e1.printStackTrace();
											}
											
											
											
										}else {
											JOptionPane.showMessageDialog(null,"ESTE ID YA EXISTE");
											Limpiar_Campos();
											txt_nombre.requestFocus();
											
										}
										
									}else {

										Object datos[] = new Object[6];
										datos[0] = txt_nombre.getText().toString();
										datos[1] = txt_apellido.getText().toString();
										datos[2] = txt_contacto.getText().toString();
										datos[3] = txt_empresa_para_la_que_trabaja.getText().toString();
										datos[4] = txt_nombre_supervisor.getText().toString();
										datos[5] = txt_contacto_del_supervisor.getText().toString();
										
										try {
											DB_provedores.anadir(datos);
											JOptionPane.showMessageDialog(null,"PROVEEDOR AGREGADO CORRECTAMENTE");
											Limpiar_Campos();
											txt_nombre.requestFocus();
											Validar_Campos();
											ver_datos_tabla(tbl_proveedores);
										} catch (SQLException e1) {
											// TODO Auto-generated catch block
											e1.printStackTrace();
										}
										
										
									}
								}
								
							} catch (NumberFormatException e2) {
								// TODO Auto-generated catch block
								e2.printStackTrace();
							} catch (SQLException e2) {
								// TODO Auto-generated catch block
								e2.printStackTrace();
							}
							
						
								
						
					
					}
				
		
		}
				});
		}
	}
	
	
	public void ver_datos_tabla(JTable tabla) {
		
		try {
			tabla.setModel(  DB_provedores.model_view_provedores());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
