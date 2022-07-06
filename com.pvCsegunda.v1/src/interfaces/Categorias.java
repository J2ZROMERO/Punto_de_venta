package interfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Categorias extends JFrame {

	private JPanel contentPane;
	private JTextField txt_categoria;
	private JTable tbl_categoria;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Categorias frame = new Categorias();
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
	public Categorias() {
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
		btn_regresar.setIcon(new ImageIcon(Categorias.class.getResource("/imagenes/flecha.png")));
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
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setToolTipText("");
		scrollPane.setBounds(29, 65, 297, 435);
		panel.add(scrollPane);
		
		tbl_categoria = new JTable();
		tbl_categoria.setFont(new Font("Roboto Slab", Font.BOLD, 12));
		tbl_categoria.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"CATEGORIA"
			}
		));
		scrollPane.setViewportView(tbl_categoria);
		
		JLabel lbl_categoria = new JLabel("CATEGORIA");
		lbl_categoria.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_categoria.setFont(new Font("Roboto Slab Black", Font.BOLD, 13));
		lbl_categoria.setBounds(137, 31, 117, 23);
		panel.add(lbl_categoria);
		
		txt_categoria = new JTextField();
		txt_categoria.setFont(new Font("Roboto Slab", Font.BOLD, 12));
		txt_categoria.setColumns(10);
		txt_categoria.setBounds(264, 31, 214, 23);
		panel.add(txt_categoria);
		
		JButton btn_añadir = new JButton("AÑADIR");
		btn_añadir.setHorizontalTextPosition(SwingConstants.CENTER);
		btn_añadir.setFont(new Font("Roboto Slab Black", Font.BOLD, 13));
		btn_añadir.setBounds(407, 133, 117, 35);
		btn_añadir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!txt_categoria.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "CATEGORIA AGREGADA CORRECTAMENTE");
					txt_categoria.setText("");
					txt_categoria.setFocusable(true);
				}else {
					JOptionPane.showMessageDialog(null, "CAMPOS VACIOS..." );
					txt_categoria.setFocusable(true);
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
				if(!txt_categoria.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "CATEGORIA ELIMINADA CORRECTAMENTE");
					txt_categoria.setText("");
					txt_categoria.setFocusable(true);
				}else {
					JOptionPane.showMessageDialog(null, "CAMPOS VACIOS..." );
					txt_categoria.setFocusable(true);
				}
			}
		});
		panel.add(btn_eliminar);
		
		JLabel lbl_imagen = new JLabel("");
		lbl_imagen.setIcon(new ImageIcon(Categorias.class.getResource("/imagenes/categorias_1.png")));
		lbl_imagen.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_imagen.setBounds(344, 288, 249, 212);
		panel.add(lbl_imagen);
	}

}
