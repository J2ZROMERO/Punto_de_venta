package interfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import conexionDB.DB_linea;
import conexionDB.DB_marcas;

import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
<<<<<<< HEAD
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
=======
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
>>>>>>> 5388bb1609ec6a5245731295f00bff5b57fc6d1b

public class Marcas extends JFrame {

	private JPanel contentPane;
	private JTextField txt_marca;
	private JTable tbl_marcas;
	public static Marcas frame;
	DefaultTableModel modelo = new DefaultTableModel();
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Marcas();
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
	public Marcas() {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 619, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(250, 210, 7));
		panel.setBounds(0, 0, 603, 511);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lbl_marca = new JLabel("MARCAS");
		lbl_marca.setBounds(180, 30, 73, 23);
		lbl_marca.setFont(new Font("Roboto Slab Black", Font.BOLD, 13));
		lbl_marca.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lbl_marca);
		
		txt_marca = new JTextField();
		txt_marca.setBounds(263, 30, 214, 23);
		txt_marca.setFont(new Font("Roboto Slab", Font.BOLD, 12));
		panel.add(txt_marca);
		
		txt_marca.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				
				//variable para datos de tipo caracter
				int key = e.getKeyChar();
				
				boolean mayuscula = key >= 65 && key <= 90;
				boolean minuscula = key >= 97 && key <= 122;
				boolean espacio = key == 32;
				
				if(!(mayuscula || minuscula || espacio)) {
					e.consume();
				}
				
			}
		});
		txt_marca.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(new Color(240, 255, 240));
		scrollPane.setToolTipText("");
		scrollPane.setBounds(28, 64, 297, 435);
		panel.add(scrollPane);
		
		tbl_marcas = new JTable();
		tbl_marcas.setGridColor(new Color(253, 151, 159));
		tbl_marcas.setSelectionBackground(new Color(253, 151, 159));
		tbl_marcas.setBackground(new Color(253, 240, 172));
		tbl_marcas.setFont(new Font("Roboto Slab", Font.BOLD, 12));
		tbl_marcas.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		tbl_marcas.setToolTipText("");
		scrollPane.setViewportView(tbl_marcas);
	
		tbl_marcas.addMouseListener( new MouseAdapter() {
				
			public void mousePressed(MouseEvent e) {
<<<<<<< HEAD
				   String selectedCellValue = (String) tbl_marcas.getValueAt(tbl_marcas.getSelectedRow() , tbl_marcas.getSelectedColumn());
		           txt_marca.setText(selectedCellValue);
=======
				   String selectedCellValue = (String) tbl_marcas.getValueAt(tbl_marcas.getSelectedRow() , 0);
		            txt_marca.setText(selectedCellValue);
>>>>>>> 5388bb1609ec6a5245731295f00bff5b57fc6d1b
		
			}});
		
		
		ver_datos_tabla(tbl_marcas);
		JButton btn_añadir = new JButton("AÑADIR");
		btn_añadir.setFont(new Font("Roboto Slab Black", Font.BOLD, 13));
		btn_añadir.setHorizontalTextPosition(SwingConstants.CENTER);
		btn_añadir.setBounds(406, 132, 117, 35);
		
		btn_añadir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(!txt_marca.getText().equals("")) {
					try {
						DB_marcas.anadir_marca(txt_marca.getText());
						ver_datos_tabla(tbl_marcas);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					JOptionPane.showMessageDialog(null, "MARCA AGREGADA CORRECTAMENTE");
					txt_marca.setText("");
					txt_marca.requestFocus();
				}
				else {
					JOptionPane.showMessageDialog(null, "CAMPOS VACIOS..." );
					txt_marca.requestFocus();
				}
			}
		});
		panel.add(btn_añadir);
		
		JButton btn_eliminar = new JButton("ELIMINAR");
		btn_eliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		btn_eliminar.setHorizontalTextPosition(SwingConstants.CENTER);
		btn_eliminar.setFont(new Font("Roboto Slab Black", Font.BOLD, 13));
		btn_eliminar.setBounds(406, 224, 117, 35);
		
		btn_eliminar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(!txt_marca.getText().equals("")) {
					
					int opcion = JOptionPane.showConfirmDialog(null,"¿ESTAS SEGURO DE ELIMINAR LA MARCA?","¡ALERTA!",JOptionPane.YES_NO_OPTION);
					
					if (opcion == 0) {
					try {
						DB_marcas.eliminar_marcas(Integer.parseInt( txt_marca.getText()));
						ver_datos_tabla(tbl_marcas);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					JOptionPane.showMessageDialog(null, "MARCA ELIMINADA CORRECTAMENTE");
					txt_marca.setText("");
					txt_marca.requestFocus();
					}
				}else {
					JOptionPane.showMessageDialog(null, "CAMPOS VACIOS..." );
					txt_marca.requestFocus();
				}
			}
		});
		panel.add(btn_eliminar);
		
		JLabel lbl_imagen = new JLabel("");
		lbl_imagen.setIcon(new ImageIcon(Marcas.class.getResource("/imagenes/marca_1.png")));
		lbl_imagen.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_imagen.setBounds(343, 287, 249, 212);
		panel.add(lbl_imagen);
		
		JButton btn_regresar = new JButton("");
		btn_regresar.setIcon(new ImageIcon(Marcas.class.getResource("/imagenes/flecha.png")));
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
		
		tbl_marcas.getColumnModel().getColumn(0).setResizable(false);
	}
	public void ver_datos_tabla(JTable tabla) {

		try {
			tabla.setModel(DB_marcas.model_view_marcas());
			
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		
		
			
	}
}
