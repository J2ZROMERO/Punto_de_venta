package interfaces;


import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Vista_Impresora extends JFrame {

	private JPanel contentPane;
	private JTextField txt_nombre_empresa;
	private JTextField txt_direccion;
	private JTextField txt_despedida;
	private JTextField txt_impresora;
	private JLabel lbl_img;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				try {
					Vista_Impresora frame = new Vista_Impresora();
					frame.setVisible(true);
					
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	public Vista_Impresora() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 642, 559);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(240, 230, 140));
		panel.setBounds(0, 0, 626, 520);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btn_seleccionar = new JButton("SELECCIONAR IMPRESORA");
		btn_seleccionar.setFont(new Font("Dialog", Font.BOLD, 12));
		btn_seleccionar.setBounds(412, 419, 204, 23);
		
		btn_seleccionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		panel.add(btn_seleccionar);
		
		JLabel lbl_titulo = new JLabel("IMPRESORA");
		lbl_titulo.setFont(new Font("Dialog", Font.BOLD, 18));
		lbl_titulo.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_titulo.setBounds(34, 45, 340, 31);
		panel.add(lbl_titulo);
		
		JButton btn_confirmar = new JButton("CONFIRMAR");
		btn_confirmar.setFont(new Font("Dialog", Font.BOLD, 12));
		btn_confirmar.setBounds(270, 486, 109, 23);
		
		btn_confirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JOptionPane.showMessageDialog(null,"REALIZANDO IMPRESION");
			}
		});
		panel.add(btn_confirmar);
		
		lbl_img = new JLabel("");
		lbl_img.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		lbl_img.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_img.setBounds(48, 141, 130, 97);
		panel.add(lbl_img);
		
		JButton btn_seleccionar_img = new JButton("SELECCIONAR IMAGEN");
		btn_seleccionar_img.setFont(new Font("Dialog", Font.BOLD, 12));
		btn_seleccionar_img.setBounds(188, 178, 193, 23);
		
		btn_seleccionar_img.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				JFileChooser fc=new JFileChooser();
				
				fc.setDialogTitle("EXPLORADOR DE ARCHIVOS");
				
				if(fc.showOpenDialog(contentPane) == JFileChooser.APPROVE_OPTION){
					//File archivo = new File(fc.getSelectedFile().toString());
					
					lbl_img.setIcon(new ImageIcon("c:/arrow.png"));
				}
				
			}
		});
		
		panel.add(btn_seleccionar_img);
		
		JLabel lbl_nombre = new JLabel("NOMBRE EMPRESA");
		lbl_nombre.setFont(new Font("Dialog", Font.BOLD, 12));
		lbl_nombre.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_nombre.setBounds(10, 279, 130, 23);
		panel.add(lbl_nombre);
		
		JLabel lbl_direccion = new JLabel("DIRECCION");
		lbl_direccion.setFont(new Font("Dialog", Font.BOLD, 12));
		lbl_direccion.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_direccion.setBounds(10, 327, 130, 23);
		panel.add(lbl_direccion);
		
		JLabel lbl_despedida = new JLabel("DESPEDIDA");
		lbl_despedida.setFont(new Font("Dialog", Font.BOLD, 12));
		lbl_despedida.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_despedida.setBounds(10, 375, 130, 23);
		panel.add(lbl_despedida);
		
		JLabel lbl_impresora = new JLabel("IMPRESORA");
		lbl_impresora.setFont(new Font("Dialog", Font.BOLD, 12));
		lbl_impresora.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_impresora.setBounds(10, 420, 130, 23);
		panel.add(lbl_impresora);
		
		txt_nombre_empresa = new JTextField();
		txt_nombre_empresa.setBounds(150, 278, 245, 25);
		panel.add(txt_nombre_empresa);
		txt_nombre_empresa.setColumns(10);
		
		txt_direccion = new JTextField();
		txt_direccion.setColumns(10);
		txt_direccion.setBounds(150, 326, 245, 25);
		panel.add(txt_direccion);
		
		txt_despedida = new JTextField();
		txt_despedida.setColumns(10);
		txt_despedida.setBounds(150, 374, 245, 25);
		panel.add(txt_despedida);
		
		txt_impresora = new JTextField();
		txt_impresora.setColumns(10);
		txt_impresora.setBounds(150, 419, 245, 25);
		panel.add(txt_impresora);
		
		JLabel lbl_img_1 = new JLabel("");
		lbl_img_1.setIcon(new ImageIcon(Vista_Impresora.class.getResource("/imagenes/cliente.png")));
		lbl_img_1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_img_1.setBounds(384, 12, 97, 97);
		panel.add(lbl_img_1);
	}
}
