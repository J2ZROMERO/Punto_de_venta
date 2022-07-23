package interfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import conexionDB.DB_linea;
import conexionDB.DB_marcas;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class Linea_de_Produccion extends JFrame {

	private JPanel contentPane;
	private JTextField txt_linea_de_produccion;
	private JTable tbl_linea_de_produccion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Linea_de_Produccion frame = new Linea_de_Produccion();
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
	public Linea_de_Produccion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 619, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 603, 511);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btn_regresar = new JButton("");
		btn_regresar.setIcon(new ImageIcon(Linea_de_Produccion.class.getResource("/imagenes/flecha.png")));
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
		
		JLabel lbl_linea_de_produccion = new JLabel("LINEA DE PRODUCCION");
		lbl_linea_de_produccion.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_linea_de_produccion.setFont(new Font("Roboto Slab Black", Font.BOLD, 13));
		lbl_linea_de_produccion.setBounds(114, 31, 186, 23);
		panel.add(lbl_linea_de_produccion);
		
		txt_linea_de_produccion = new JTextField();
		txt_linea_de_produccion.setFont(new Font("Roboto Slab", Font.BOLD, 12));
		txt_linea_de_produccion.setColumns(10);
		txt_linea_de_produccion.setBounds(310, 31, 214, 23);
		panel.add(txt_linea_de_produccion);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setToolTipText("");
		scrollPane.setBounds(29, 65, 297, 435);
		panel.add(scrollPane);
		
		tbl_linea_de_produccion = new JTable();
		tbl_linea_de_produccion.setFont(new Font("Roboto Slab", Font.BOLD, 12));
		tbl_linea_de_produccion.addMouseListener(new MouseAdapter() {
			
			public void mousePressed(MouseEvent e) {
				   String selectedCellValue = (String) tbl_linea_de_produccion.getValueAt(tbl_linea_de_produccion.getSelectedRow() , tbl_linea_de_produccion.getSelectedColumn());
		            txt_linea_de_produccion.setText(selectedCellValue);
		            
			};
			
			
			
			
			
			});
		try {
			tbl_linea_de_produccion.setModel(DB_linea.model_view_linea());
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		scrollPane.setViewportView(tbl_linea_de_produccion);
		
		JButton btn_añadir = new JButton("AÑADIR");
		btn_añadir.setHorizontalTextPosition(SwingConstants.CENTER);
		btn_añadir.setFont(new Font("Roboto Slab Black", Font.BOLD, 13));
		btn_añadir.setBounds(407, 133, 117, 35);
		
		btn_añadir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				
				if(!txt_linea_de_produccion.getText().equals("")) {
				try {
					DB_linea.anadir_marca(txt_linea_de_produccion.getText());
					ver_datos_tabla(tbl_linea_de_produccion);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
					JOptionPane.showMessageDialog(null, "LINEA DE PRODUCCION AGREGADA CORRECTAMENTE");
					txt_linea_de_produccion.setText("");
					txt_linea_de_produccion.requestFocus();
				}else {
					JOptionPane.showMessageDialog(null, "FAVOR DE LLENAR CAMPOS...");
					txt_linea_de_produccion.requestFocus();
				}
				
			}
		});
		panel.add(btn_añadir);
		
		JButton btn_eliminar = new JButton("ELIMINAR");
		btn_eliminar.setHorizontalTextPosition(SwingConstants.CENTER);
		btn_eliminar.setFont(new Font("Roboto Slab Black", Font.BOLD, 13));
		btn_eliminar.setBounds(407, 225, 117, 35);
		
		btn_eliminar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(!txt_linea_de_produccion.getText().equals("")) {
					try {
						DB_linea.eliminar_lineas(txt_linea_de_produccion.getText());
						ver_datos_tabla(tbl_linea_de_produccion);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					JOptionPane.showMessageDialog(null, "LINEA DE PRODUCCION ELIMINADA CORRECTAMENTE");
					txt_linea_de_produccion.setText("");
					txt_linea_de_produccion.requestFocus();
				}else {
					JOptionPane.showMessageDialog(null, "FAVOR DE LLENAR CAMPOS...");
					txt_linea_de_produccion.requestFocus();
				}
				
			}
		});
		panel.add(btn_eliminar);
		
		JLabel lbl_imagen = new JLabel("");
		lbl_imagen.setIcon(new ImageIcon(Linea_de_Produccion.class.getResource("/imagenes/linea_de_produccion_1.png")));
		lbl_imagen.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_imagen.setBounds(344, 288, 249, 212);
		panel.add(lbl_imagen);
	}
	public void ver_datos_tabla(JTable tabla) {

		try {
			tabla.setModel(DB_linea.model_view_linea());
			
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		
		
			
	}
}
