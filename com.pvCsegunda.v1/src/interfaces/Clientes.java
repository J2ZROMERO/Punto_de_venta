package interfaces;
import interfaces_no_graficas.CRUD;
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
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
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

public class Clientes extends JFrame implements CRUD{

	private JPanel contentPane;
	private JTextField txt_id;
	private JTextField txt_nombre;
	private JTextField txt_apellido;
	private JTextField txt_nick_name;
	private JTextField txt_telefono;
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
		btn_limpiar_campos.setBounds(73, 314, 154, 23);
		panel.add(btn_limpiar_campos);
		
		JButton btn_ver_clientes = new JButton("VER CLIENTES");
		btn_ver_clientes.setFont(new Font("Dialog", Font.BOLD, 13));
		btn_ver_clientes.setBounds(73, 376, 154, 23);
		panel.add(btn_ver_clientes);
		
		JButton btn_añadir = new JButton("AÑADIR");
		btn_añadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object campos_txt[] = new Object[4];
			campos_txt[0] = txt_nombre.getText(); 
			campos_txt[1] = txt_apellido.getText();
			campos_txt[2] = txt_nick_name.getText();
			campos_txt[3] = txt_telefono.getText();
			
				anadir(campos_txt);
			    ver_datos_tabla(tbl_clientes);
			}
		});
		
		
	
			
		
		
		btn_añadir.setFont(new Font("Dialog", Font.BOLD, 13));
		btn_añadir.setBounds(449, 56, 154, 23);
		panel.add(btn_añadir);
		
		JButton btn_buscar = new JButton("BUSCAR");
		btn_buscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			Object datos [] =	buscar(Integer.parseInt(txt_id.getText()));
			txt_id.setText(datos[0].toString());
			txt_nombre.setText(datos[1].toString());
			txt_apellido.setText(datos[2].toString());
			txt_nick_name.setText(datos[3].toString());
			txt_telefono.setText(datos[4].toString());
			
			}
		});
		btn_buscar.setFont(new Font("Dialog", Font.BOLD, 13));
		btn_buscar.setBounds(449, 100, 154, 23);
		panel.add(btn_buscar);
		
		JButton btn_actualizar = new JButton("ACTUALIZAR");
		btn_actualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Object campos_txt[] = new Object[5];
				campos_txt[0] = txt_id.getText();
				campos_txt[1] = txt_nombre.getText(); 
				campos_txt[2] = txt_apellido.getText();
				campos_txt[3] = txt_nick_name.getText();
				campos_txt[4] = txt_telefono.getText();
				
				actualizar(campos_txt);
					
				  ver_datos_tabla(tbl_clientes);
			}
		});
		btn_actualizar.setFont(new Font("Dialog", Font.BOLD, 13));
		btn_actualizar.setBounds(449, 146, 154, 23);
		panel.add(btn_actualizar);
		
		JButton btn_eliminar = new JButton("ELIMINAR");
		btn_eliminar.setFont(new Font("Dialog", Font.BOLD, 13));
		btn_eliminar.setBounds(449, 192, 154, 23);
		panel.add(btn_eliminar);
	btn_eliminar.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
	eliminar(Integer.parseInt(txt_id.getText()));
			ver_datos_tabla(tbl_clientes);
		}
	});
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(319, 239, 392, 242);
		panel.add(scrollPane);
		
		tbl_clientes = new JTable();
	tbl_clientes.addMouseListener(new MouseAdapter() {
			
			public void mousePressed(MouseEvent e) {
				   String selectedCellValue = (String) tbl_clientes.getValueAt(tbl_clientes.getSelectedRow() , tbl_clientes.getSelectedColumn());
		            txt_id.setText(selectedCellValue);
		            
			};
			
			
			
			
			
			});
	    ver_datos_tabla(tbl_clientes);
		scrollPane.setViewportView(tbl_clientes);
	}
	
	
	
	
	
	
	
	
	
	
	public void ver_datos_tabla(JTable tabla) {

		try {
			tabla.setModel(DB_clientes.model_view_clientes());
			
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		
		
			
	}

	@Override
	public void actualizar(Object t[]) {
		// 
		try {
			DB_clientes.actualizar(t);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void anadir(Object[] campos)  {
try {
	DB_clientes.anadir(campos);
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
		
	}

	@Override
	public Object []buscar(int id) {
		// TODO Auto-generated method stub
	Object data[] = null;
		try {
			data = DB_clientes.buscar(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}

	@Override
	public void eliminar(int id) {
		// 
		try {
			DB_clientes.eliminar(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}


	
}





















