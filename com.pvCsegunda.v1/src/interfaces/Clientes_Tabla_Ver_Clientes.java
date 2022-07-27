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
		setBounds(100, 100, 870, 416);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 875, 377);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 854, 328);
		panel.add(scrollPane);
		
		tbl_ver_clientes= new JTable();
		
		scrollPane.setViewportView(tbl_ver_clientes);
	
		JButton btn_ok = new JButton("OK");
		btn_ok.setFont(new Font("Dialog", Font.BOLD, 13));
		btn_ok.setBounds(381, 339, 102, 27);
		
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
			
			tbl_ver_clientes.setModel(DB_clientes.model_view_clientes_boton());
			
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
	tbl_ver_clientes.addMouseListener( new MouseAdapter() {
			
			public void mousePressed(MouseEvent e) {
				
				String selectedCellValue = tbl_ver_clientes.getValueAt(tbl_ver_clientes.getSelectedRow() , 0).toString();
		        
				id.setText(selectedCellValue);
		            
		     
			     if(e.getClickCount()==2) {
			    	 
			    	 
			    	 	Object datos[];
						try {
							datos = DB_clientes.buscar(Integer.parseInt(id.getText()));
							
							nombre.setText((String) datos[1]);
							apellido.setText((String) datos[2]);
							nickname.setText((String) datos[3]);
							telefono.setText((String) datos[4]);
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
