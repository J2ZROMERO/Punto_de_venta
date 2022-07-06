package interfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Bar_Code extends JFrame {

	private JPanel contentPane;
	private JTextField txt_id;
	private JTable tbl_bar_code;
	private JTextField textField;
	private JTable tbl_etiquetas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bar_Code frame = new Bar_Code();
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
	public Bar_Code() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 636, 598);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 620, 559);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btn_regresar = new JButton("");
		btn_regresar.setIcon(new ImageIcon(Bar_Code.class.getResource("/imagenes/flecha.png")));
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
		lbl_id.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_id.setFont(new Font("Dialog", Font.BOLD, 13));
		lbl_id.setBounds(10, 64, 69, 20);
		panel.add(lbl_id);
		
		txt_id = new JTextField();
		txt_id.setFont(new Font("Dialog", Font.BOLD, 12));
		txt_id.setBounds(89, 64, 86, 20);
		panel.add(txt_id);
		txt_id.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(237, 39, 373, 96);
		panel.add(scrollPane);
		
		tbl_bar_code = new JTable();
		tbl_bar_code.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"<html><center>PRODUCTO</center></html>", "<html><center>DISTINTIVO 1</center></html>", "<html><center>DISTINTIVO 2</center></html>"
			}
		));
		scrollPane.setViewportView(tbl_bar_code);
		
		JLabel lbl_id_1 = new JLabel("<html><center>CANTIDAD DE ETIQUETAS</center></html>");
		lbl_id_1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_id_1.setFont(new Font("Dialog", Font.BOLD, 13));
		lbl_id_1.setBounds(10, 146, 147, 35);
		panel.add(lbl_id_1);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("Dialog", Font.BOLD, 12));
		textField.setColumns(10);
		textField.setBounds(10, 190, 44, 35);
		panel.add(textField);
		
		JButton btn_mas = new JButton("+");
		btn_mas.setFont(new Font("Dialog", Font.BOLD, 15));
		btn_mas.setBounds(64, 190, 44, 35);
		panel.add(btn_mas);
		
		JButton btn_menos = new JButton("-");
		btn_menos.setFont(new Font("Dialog", Font.BOLD, 22));
		btn_menos.setBounds(118, 192, 44, 33);
		panel.add(btn_menos);
		
		JLabel lbl_añadir_precio_a_etiquetas = new JLabel("<html><center>AÑADIR PRECIO A ETIQUETAS</center></html>");
		lbl_añadir_precio_a_etiquetas.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_añadir_precio_a_etiquetas.setFont(new Font("Dialog", Font.BOLD, 13));
		lbl_añadir_precio_a_etiquetas.setBounds(208, 146, 153, 35);
		panel.add(lbl_añadir_precio_a_etiquetas);
		
		JButton btn_encendido = new JButton("ON");
		btn_encendido.setFont(new Font("Dialog", Font.BOLD, 13));
		btn_encendido.setBounds(218, 197, 61, 23);
		panel.add(btn_encendido);
		
		JButton btn_apagado = new JButton("OFF");
		btn_apagado.setFont(new Font("Dialog", Font.BOLD, 13));
		btn_apagado.setBounds(289, 197, 61, 23);
		panel.add(btn_apagado);
		
		JButton btn_ejecutar = new JButton("EJECUTAR");
		btn_ejecutar.setFont(new Font("Dialog", Font.BOLD, 13));
		btn_ejecutar.setBounds(34, 268, 122, 23);
		panel.add(btn_ejecutar);
		
		JButton btn_limpiar_hoja = new JButton("LIMPIAR HOJA");
		btn_limpiar_hoja.setFont(new Font("Dialog", Font.BOLD, 13));
		btn_limpiar_hoja.setBounds(192, 268, 141, 23);
		panel.add(btn_limpiar_hoja);
		
		JButton btn_buscar = new JButton("BUSCAR");
		btn_buscar.setFont(new Font("Dialog", Font.BOLD, 13));
		btn_buscar.setBounds(402, 146, 180, 23);
		
		btn_buscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Bar_Code_Buscar bcb = new Bar_Code_Buscar();
				bcb.setVisible(true);
				bcb.setFocusable(true);
				bcb.setLocationRelativeTo(null);
			}
		});
		panel.add(btn_buscar);
		
		JButton btn_guardar_imagen = new JButton("GUARDAR IMAGEN");
		btn_guardar_imagen.setFont(new Font("Dialog", Font.BOLD, 13));
		btn_guardar_imagen.setBounds(402, 190, 180, 23);
		panel.add(btn_guardar_imagen);
		
		JButton btn_imprimir = new JButton("IMPRIMIR");
		btn_imprimir.setFont(new Font("Dialog", Font.BOLD, 13));
		btn_imprimir.setBounds(402, 234, 180, 23);
		panel.add(btn_imprimir);
		
		JButton btn_guardar_pdf = new JButton("GUARDAR PDF");
		btn_guardar_pdf.setFont(new Font("Dialog", Font.BOLD, 13));
		btn_guardar_pdf.setBounds(402, 279, 180, 23);
		panel.add(btn_guardar_pdf);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 330, 600, 218);
		panel.add(scrollPane_1);
		
		tbl_etiquetas = new JTable();
		tbl_etiquetas.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"<html><center>ETIQUETAS</center></html>"
			}
		));
		tbl_etiquetas.setFont(new Font("Tahoma", Font.PLAIN, 11));
		scrollPane_1.setViewportView(tbl_etiquetas);
	}
}
