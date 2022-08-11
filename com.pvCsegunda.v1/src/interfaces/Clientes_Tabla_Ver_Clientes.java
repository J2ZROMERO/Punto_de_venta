package interfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import conexionDB.DB_clientes;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.awt.Color;

public class Clientes_Tabla_Ver_Clientes extends JFrame {

	private JPanel contentPane;
	private  JTable tbl_ver_clientes;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Clientes_Tabla_Ver_Clientes frame = new Clientes_Tabla_Ver_Clientes();
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
	public Clientes_Tabla_Ver_Clientes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 918, 416);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 165, 0));
		panel.setBounds(0, 0, 902, 377);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 882, 317);
		panel.add(scrollPane);
		
		tbl_ver_clientes= new JTable();
		tbl_ver_clientes.setGridColor(new Color(244, 164, 96));
		tbl_ver_clientes.setBackground(new Color(255, 255, 0));
	
		
		scrollPane.setViewportView(tbl_ver_clientes);
	
		JButton btn_ok = new JButton("OK");
		btn_ok.setFont(new Font("Dialog", Font.BOLD, 13));
		btn_ok.setBounds(387, 339, 102, 27);
		
		btn_ok.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();

			}
		});
		panel.add(btn_ok);
	}
	
	public  void ver_clientes(JTextField id,JTextField nombre,JTextField apellido,JTextField nickname,JTextField telefono) {

		try {
			
			tbl_ver_clientes.setModel(DB_clientes.model_view_clientes());
			
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
	tbl_ver_clientes.addMouseListener( new MouseAdapter() {
			
			public void mousePressed(MouseEvent e) {
				
				String selectedCellValue = tbl_ver_clientes.getValueAt(tbl_ver_clientes.getSelectedRow() , 0).toString();
		        
				id.setText(selectedCellValue);
		     
			     if(e.getClickCount()==2) {
			    	 
			    	 
			    	 	
						try {
						Object	datos[] = DB_clientes.buscar(Integer.parseInt(id.getText()));
							
						for(Object t: DB_clientes.buscar(Integer.parseInt(id.getText()))) {
							System.out.println(t);
						}
							nombre.setText( datos[1].toString());
							apellido.setText( datos[2].toString());
							nickname.setText( datos[3].toString());
							telefono.setText(datos[4].toString());
							
							dispose();
						} catch (NumberFormatException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
				
			    	 
			     }	
				
			       
		           
		            			
		
		}                              });
		
		
			
	}
	
	
	
	/////
	public  void ver_clientes(JTextField id) {

		try {
			
			tbl_ver_clientes.setModel(DB_clientes.model_view_clientes());
			
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
	tbl_ver_clientes.addMouseListener( new MouseAdapter() {
			
			public void mousePressed(MouseEvent e) {
				
				String selectedCellValue = tbl_ver_clientes.getValueAt(tbl_ver_clientes.getSelectedRow() , 0).toString();
		        
				id.setText(selectedCellValue);
		     
			     if(e.getClickCount()==2) {
			    	 
			    	 
			    	 	
						try {
						Object	datos[] = DB_clientes.buscar(Integer.parseInt(id.getText()));
							
						for(Object t: DB_clientes.buscar(Integer.parseInt(id.getText()))) {
							System.out.println(t);
						}
							
							dispose();
						} catch (NumberFormatException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
				
			    	 
			     }	
				
			       
		           
		            			
		
		}                              });
		
		
			
	}

	
	
}
