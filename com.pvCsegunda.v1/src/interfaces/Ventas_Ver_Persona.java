package interfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Ventas_Ver_Persona extends JFrame {

	private JPanel contentPane;
	private JTextField txt_fecha_inicial;
	private JTextField txt_fecha_final;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventas_Ver_Persona frame = new Ventas_Ver_Persona();
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
	public Ventas_Ver_Persona() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 423);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 284, 384);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lbl_persona = new JLabel("PERSONA");
		lbl_persona.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_persona.setFont(new Font("Dialog", Font.BOLD, 13));
		lbl_persona.setBounds(10, 11, 184, 22);
		panel.add(lbl_persona);
		
		JComboBox cbx_atributos_de_contenido = new JComboBox();
		cbx_atributos_de_contenido.setBounds(10, 33, 184, 23);
		panel.add(cbx_atributos_de_contenido);
		
		JLabel lbl_fecha = new JLabel("FECHA");
		lbl_fecha.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_fecha.setFont(new Font("Dialog", Font.BOLD, 13));
		lbl_fecha.setBounds(10, 79, 184, 22);
		panel.add(lbl_fecha);
		
		JLabel lbl_fecha_inicial = new JLabel("FECHA INICIAL");
		lbl_fecha_inicial.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_fecha_inicial.setFont(new Font("Dialog", Font.BOLD, 13));
		lbl_fecha_inicial.setBounds(10, 136, 184, 23);
		panel.add(lbl_fecha_inicial);
		
		txt_fecha_inicial = new JTextField();
		txt_fecha_inicial.setColumns(10);
		txt_fecha_inicial.setBounds(10, 161, 184, 23);
		panel.add(txt_fecha_inicial);
		
		JLabel lbl_fecha_final = new JLabel("FECHA FINAL");
		lbl_fecha_final.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_fecha_final.setFont(new Font("Dialog", Font.BOLD, 13));
		lbl_fecha_final.setBounds(10, 240, 184, 23);
		panel.add(lbl_fecha_final);
		
		txt_fecha_final = new JTextField();
		txt_fecha_final.setColumns(10);
		txt_fecha_final.setBounds(10, 265, 184, 23);
		panel.add(txt_fecha_final);
		
		JLabel lbl_fecha_inicial_imagen = new JLabel("");
		lbl_fecha_inicial_imagen.setIcon(new ImageIcon(Ventas_Ver_Persona.class.getResource("/imagenes/calendario.png")));
		lbl_fecha_inicial_imagen.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_fecha_inicial_imagen.setBounds(204, 130, 70, 64);
		panel.add(lbl_fecha_inicial_imagen);
		
		JLabel lbl_fecha_final_imagen = new JLabel("");
		lbl_fecha_final_imagen.setIcon(new ImageIcon(Ventas_Ver_Persona.class.getResource("/imagenes/calendario.png")));
		lbl_fecha_final_imagen.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_fecha_final_imagen.setBounds(204, 235, 70, 64);
		panel.add(lbl_fecha_final_imagen);
		
		JButton btn_ver = new JButton("VER");
		btn_ver.setFont(new Font("Dialog", Font.BOLD, 13));
		btn_ver.setBounds(83, 338, 111, 23);
		panel.add(btn_ver);
	}
}
