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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;


public class Marcas extends JFrame {

	private JPanel contentPane;
	private JTextField txt_marca;
	private JTable tbl_marcas;
	private JLabel lbl_alerta_1;
	DefaultTableModel modelo = new DefaultTableModel();
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Marcas frame = new Marcas();
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
	public void Validar_Campos() {
		if(!"".equals(txt_marca.getText())) {
			lbl_alerta_1.setForeground(new Color(245, 176, 65));
		}else {
			lbl_alerta_1.setForeground(new Color(0,0,0));
		}
	}
	
	public Marcas() {
		setResizable(false);
		
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 619, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(new Color(245, 176, 65));
		panel.setBounds(0, 0, 602, 510);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lbl_marca = new JLabel("MARCA");
		lbl_marca.setBounds(180, 30, 73, 23);
		lbl_marca.setFont(new Font("Roboto Slab Black", Font.BOLD, 14));
		lbl_marca.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lbl_marca);
		
		txt_marca = new JTextField();
		txt_marca.setBounds(263, 30, 214, 23);
		txt_marca.setFont(new Font("Roboto Slab", Font.BOLD, 12));
		panel.add(txt_marca);
		
		txt_marca.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				Validar_Campos();
			}
		});
		txt_marca.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setToolTipText("");
		scrollPane.setBounds(28, 64, 297, 435);
		panel.add(scrollPane);
		
		tbl_marcas = new JTable();
		tbl_marcas.setSelectionBackground(new Color(255, 165, 0));
		tbl_marcas.setBackground(new Color(255, 252, 166));
		tbl_marcas.setFont(new Font("Roboto Slab", Font.BOLD, 12));
		tbl_marcas.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		tbl_marcas.setToolTipText("");
		scrollPane.setViewportView(tbl_marcas);
	
		tbl_marcas.addMouseListener( new MouseAdapter() {
				
			public void mousePressed(MouseEvent e) {

				   String selectedCellValue = (String) tbl_marcas.getValueAt(tbl_marcas.getSelectedRow() , 0);
		            txt_marca.setText(selectedCellValue);
		
			}});
		
		
		ver_datos_tabla(tbl_marcas);
		JButton btn_añadir = new JButton("");
		btn_añadir.setIcon(new ImageIcon(Marcas.class.getResource("/imagenes/anadir.png")));
		btn_añadir.setFont(new Font("Roboto Slab Black", Font.BOLD, 13));
		btn_añadir.setHorizontalTextPosition(SwingConstants.CENTER);
		btn_añadir.setBounds(406, 126, 117, 41);
		
		btn_añadir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(!txt_marca.getText().equals("")) {
					try {
						DB_marcas.anadir_marca(txt_marca.getText());
						ver_datos_tabla(tbl_marcas);
						Validar_Campos();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					JOptionPane.showMessageDialog(null, "MARCA AGREGADA CORRECTAMENTE");
					txt_marca.setText("");
					txt_marca.requestFocus();
					Validar_Campos();
				}
				else {
					Validar_Campos();
					txt_marca.requestFocus();
				}
			}
		});
		panel.add(btn_añadir);
		
		JButton btn_eliminar = new JButton("");
		btn_eliminar.setIcon(new ImageIcon(Marcas.class.getResource("/imagenes/basura.png")));
		btn_eliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		btn_eliminar.setHorizontalTextPosition(SwingConstants.CENTER);
		btn_eliminar.setFont(new Font("Roboto Slab Black", Font.BOLD, 13));
		btn_eliminar.setBounds(406, 218, 117, 41);
		
		btn_eliminar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(!txt_marca.getText().equals("")) {
					
					int opcion = JOptionPane.showConfirmDialog(null,"¿ESTAS SEGURO DE ELIMINAR LA MARCA?","¡ALERTA!",JOptionPane.YES_NO_OPTION);
					
					if (opcion == 0) {
					try {
						DB_marcas.eliminar_marcas(Integer.parseInt(txt_marca.getText()));
						ver_datos_tabla(tbl_marcas);
						Validar_Campos();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					JOptionPane.showMessageDialog(null, "MARCA ELIMINADA CORRECTAMENTE");
					txt_marca.setText("");
					txt_marca.requestFocus();
					Validar_Campos();
					}
				}else {
					txt_marca.requestFocus();
					Validar_Campos();
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
		
		lbl_alerta_1 = new JLabel("*");
		lbl_alerta_1.setHorizontalTextPosition(SwingConstants.CENTER);
		lbl_alerta_1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_alerta_1.setForeground(new Color(0,0,0));
		lbl_alerta_1.setFont(new Font("Dialog", Font.BOLD, 23));
		lbl_alerta_1.setBounds(487, 30, 73, 24);
		panel.add(lbl_alerta_1);
		
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
