package interfaces;

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

import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Proveedores();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 780, 571);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 215, 0));
		panel.setBounds(0, 0, 764, 532);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lbl_id = new JLabel("ID");
		lbl_id.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_id.setFont(new Font("Dialog", Font.BOLD, 13));
		lbl_id.setBounds(10, 60, 120, 20);
		panel.add(lbl_id);
		
		txt_id = new JTextField();
		txt_id.setFont(new Font("Dialog", Font.BOLD, 12));
		txt_id.setBounds(140, 60, 198, 20);
		txt_id.setEnabled(false);
		panel.add(txt_id);
		txt_id.setColumns(10);
		
		lbl_nombre = new JLabel("NOMBRE");
		lbl_nombre.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_nombre.setFont(new Font("Dialog", Font.BOLD, 13));
		lbl_nombre.setBounds(10, 107, 120, 20);
		panel.add(lbl_nombre);
		
		txt_nombre = new JTextField();
		txt_nombre.setFont(new Font("Dialog", Font.BOLD, 12));
		txt_nombre.setColumns(10);
		txt_nombre.setBounds(140, 107, 198, 20);
		panel.add(txt_nombre);
		
		lbl_apellido = new JLabel("APELLIDO");
		lbl_apellido.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_apellido.setFont(new Font("Dialog", Font.BOLD, 13));
		lbl_apellido.setBounds(10, 153, 120, 20);
		panel.add(lbl_apellido);
		
		txt_apellido = new JTextField();
		txt_apellido.setFont(new Font("Dialog", Font.BOLD, 12));
		txt_apellido.setColumns(10);
		txt_apellido.setBounds(140, 153, 198, 20);
		panel.add(txt_apellido);
		
		lbl_contacto = new JLabel("<html><center>CONTACTO</center></html>");
		lbl_contacto.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_contacto.setFont(new Font("Dialog", Font.BOLD, 13));
		lbl_contacto.setBounds(10, 193, 120, 46);
		panel.add(lbl_contacto);
		
		txt_contacto = new JTextField();
		txt_contacto.setFont(new Font("Dialog", Font.BOLD, 12));
		txt_contacto.setColumns(10);
		txt_contacto.setBounds(140, 208, 198, 20);
		panel.add(txt_contacto);
		
		lbl_empresa_para_la_que_trabaja = new JLabel("<html><center>EMPRESA PARA LA QUE TRABAJA </center></html>");
		lbl_empresa_para_la_que_trabaja.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_empresa_para_la_que_trabaja.setFont(new Font("Dialog", Font.BOLD, 13));
		lbl_empresa_para_la_que_trabaja.setBounds(10, 258, 120, 51);
		panel.add(lbl_empresa_para_la_que_trabaja);
		
		txt_empresa_para_la_que_trabaja = new JTextField();
		txt_empresa_para_la_que_trabaja.setFont(new Font("Dialog", Font.BOLD, 12));
		txt_empresa_para_la_que_trabaja.setColumns(10);
		txt_empresa_para_la_que_trabaja.setBounds(140, 271, 198, 20);
		panel.add(txt_empresa_para_la_que_trabaja);
		
		lbl_nombre_supervisor = new JLabel("<html><center>NOMBRE SUPERVISOR</center></html>");
		lbl_nombre_supervisor.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_nombre_supervisor.setFont(new Font("Dialog", Font.BOLD, 13));
		lbl_nombre_supervisor.setBounds(10, 327, 120, 46);
		panel.add(lbl_nombre_supervisor);
		
		txt_nombre_supervisor = new JTextField();
		txt_nombre_supervisor.setFont(new Font("Dialog", Font.BOLD, 12));
		txt_nombre_supervisor.setColumns(10);
		txt_nombre_supervisor.setBounds(140, 337, 198, 20);
		panel.add(txt_nombre_supervisor);
		
		lbl_contacto_supervisor = new JLabel("<html><center>CONTACTO SUPERVISOR</center></html>");
		lbl_contacto_supervisor.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_contacto_supervisor.setFont(new Font("Dialog", Font.BOLD, 13));
		lbl_contacto_supervisor.setBounds(10, 395, 120, 36);
		panel.add(lbl_contacto_supervisor);
		
		txt_contacto_del_supervisor = new JTextField();
		txt_contacto_del_supervisor.setFont(new Font("Dialog", Font.BOLD, 12));
		txt_contacto_del_supervisor.setColumns(10);
		txt_contacto_del_supervisor.setBounds(140, 401, 198, 20);
		panel.add(txt_contacto_del_supervisor);
		
		JButton btn_limpiar_campos = new JButton("LIMPIAR CAMPOS");
		btn_limpiar_campos.setFont(new Font("Dialog", Font.BOLD, 12));
		btn_limpiar_campos.setBounds(97, 469, 159, 23);
		
		btn_limpiar_campos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Limpiar_Campos();
				txt_nombre.requestFocus();				
			}
		});
		panel.add(btn_limpiar_campos);
		
		JButton btn_añadir = new JButton("AÑADIR");
		btn_añadir.setFont(new Font("Dialog", Font.BOLD, 12));
		btn_añadir.setBounds(470, 59, 159, 23);
		
		btn_añadir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(!txt_nombre.getText().equals("") && !txt_apellido.getText().equals("")
				   && !txt_contacto.getText().equals("") && !txt_empresa_para_la_que_trabaja.getText().equals("")
				   && !txt_nombre_supervisor.getText().equals("") && !txt_contacto_del_supervisor.getText().equals("")) {	
					
					Object datos[] = new Object[6];
					datos[0] = txt_nombre.getText().toString();
					datos[1] = txt_apellido.getText().toString();
					datos[2] = txt_contacto.getText().toString();
					datos[3] = txt_empresa_para_la_que_trabaja.getText().toString();
					datos[4] = txt_nombre_supervisor.getText().toString();
					datos[5] = txt_contacto_del_supervisor.getText().toString();
					
					try {
						DB_provedores.anadir(datos);
						JOptionPane.showMessageDialog(null,"USUARIO AGREGADO CORRECTAMENTE");
						Limpiar_Campos();					
						ver_datos_tabla(tbl_proveedores);
						txt_nombre.requestFocus();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
				}else {
					JOptionPane.showMessageDialog(null,"CAMPOS VACIOS...");
					frame.requestFocus();
				}
			}
		});
		panel.add(btn_añadir);
		
		JButton btn_actualizar = new JButton("ACTUALIZAR");
		btn_actualizar.setFont(new Font("Dialog", Font.BOLD, 12));
		btn_actualizar.setBounds(470, 106, 159, 23);
		
		btn_actualizar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(!txt_id.getText().equals("") && !txt_nombre.getText().equals("") && !txt_apellido.getText().equals("")
						   && !txt_contacto.getText().equals("") && !txt_empresa_para_la_que_trabaja.getText().equals("")
						   && !txt_nombre_supervisor.getText().equals("") && !txt_contacto_del_supervisor.getText().equals("")) {	
							
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
					
					JOptionPane.showMessageDialog(null,"USUARIO ACTUALIZADO CORRECTAMENTE");
							Limpiar_Campos();
							ver_datos_tabla(tbl_proveedores);
							txt_nombre.requestFocus();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		
						}else {
							JOptionPane.showMessageDialog(null,"CAMPOS VACIOS...");
							frame.requestFocus();
						}
			}
		});
		panel.add(btn_actualizar);
		
		JButton btn_eliminar = new JButton("ELIMINAR");
		btn_eliminar.setFont(new Font("Dialog", Font.BOLD, 12));
		btn_eliminar.setBounds(470, 155, 159, 23);
		
		btn_eliminar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(!txt_id.getText().equals("") && !txt_nombre.getText().equals("") && !txt_apellido.getText().equals("")
						   && !txt_contacto.getText().equals("") && !txt_empresa_para_la_que_trabaja.getText().equals("")
						   && !txt_nombre_supervisor.getText().equals("") && !txt_contacto_del_supervisor.getText().equals("")) {	
                int opcion = JOptionPane.showConfirmDialog(null,"¿ESTAS SEGURO DE ELIMINAR EL PROVEEDOR?","¡ALERTA!",JOptionPane.YES_NO_OPTION);
					
					if (opcion == 0) {
					try {
						JOptionPane.showMessageDialog(null,"USUARIO ELIMINADO CORRECTAMENTE");
						DB_provedores.eliminar(  Integer.parseInt( txt_id.getText()));
						Limpiar_Campos();
						ver_datos_tabla(tbl_proveedores);
						txt_id.requestFocus();
					} catch (NumberFormatException e1) {
						// 	
					
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					}
						}else {
							JOptionPane.showMessageDialog(null,"CAMPOS VACIOS...");
							frame.requestFocus();
						}
			}
		});
		panel.add(btn_eliminar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(371, 197, 365, 324);
		panel.add(scrollPane);
		
		tbl_proveedores = new JTable();
		tbl_proveedores.setGridColor(new Color(0, 191, 255));
		tbl_proveedores.setBackground(new Color(175, 238, 238));
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


			
							} catch (NumberFormatException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
							
						
		}                              });
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
