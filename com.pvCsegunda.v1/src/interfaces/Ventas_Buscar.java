package interfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import conexionDB.DB_clientes;
import conexionDB.DB_productos;
import conexionDB.DB_ventas;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollBar;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Color;

public class Ventas_Buscar extends JFrame {
private static Ventas_Buscar frame;
	private JPanel contentPane;
	private static JTable table;
private boolean estaActivo = false;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Ventas_Buscar();
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
	public Ventas_Buscar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1133, 493);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(82, 190, 128));
		panel.setBounds(0, 0, 1117, 454);
		contentPane.add(panel);
		
		JButton btn_regresar = new JButton("OK");
		btn_regresar.setFont(new Font("Dialog", Font.BOLD, 12));
		btn_regresar.setBounds(529, 404, 59, 35);
		btn_regresar.setIcon(null);
		
		btn_regresar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		
   	
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 1097, 382);
		panel.add(scrollPane);
		
		table = new JTable();
		
		scrollPane.setViewportView(table);
		
		
		panel.add(btn_regresar);
	}
	
	
	
	
	
	public static void ver_datos_ventas(long id) {
		
		try {
			table.setModel(DB_ventas.model_view_ventas(id));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	
	// en duda este
	
public static void ver_datos_productos_like(Object dato[]) {


	
	try {
		table.setModel(DB_productos.model_view_ventas_buscar(dato));
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	}

public  void ver_datos_evento(JTextField id) {
table.addMouseListener( new MouseAdapter() {
		
		public void mousePressed(MouseEvent e) {
			
			String selectedCellValue = table.getValueAt(table.getSelectedRow() , 0).toString();
	        
			id.setText(selectedCellValue);
	     
		     if(e.getClickCount()==2) {
		    	 
		   		
		   		
		    	 			       dispose();
	           
	     estaActivo =true;
		     }	}                              });
	
	

		
}


public boolean detec_event() {
	return estaActivo;
	
}

}
