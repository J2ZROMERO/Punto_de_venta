package interfaces;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Caja_Inicial extends JFrame {

	private JPanel contentPane;
	private JTextField txt_monto;
	public static Caja_Inicial frame;
	public JTextField txt_usuario;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Caja_Inicial();
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
	public Caja_Inicial() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 466, 211);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 450, 172);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lbl_caja_inicial = new JLabel("CAJA INICIAL");
		lbl_caja_inicial.setFont(new Font("Dialog", Font.BOLD, 16));
		lbl_caja_inicial.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_caja_inicial.setBounds(48, 11, 361, 32);
		panel.add(lbl_caja_inicial);
		
		txt_monto = new JTextField();
		txt_monto.setFont(new Font("Dialog", Font.BOLD, 13));
		txt_monto.setBounds(48, 73, 232, 24);
		panel.add(txt_monto);
		txt_monto.setColumns(10);
		
		JButton btn_añadir = new JButton("AÑADIR");
		btn_añadir.setFont(new Font("Dialog", Font.BOLD, 13));
		btn_añadir.setBounds(320, 73, 89, 24);
		btn_añadir.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				
				if(!txt_monto.getText().equals("")) {
				Menu_principal mp = new Menu_principal();
				mp.setVisible(true);
				mp.setFocusable(true);
				mp.setLocationRelativeTo(null);
				dispose();
				}else {
					JOptionPane.showMessageDialog(null,"CAMPOS VACIOS...");
					frame.requestFocus();
				}
			}
		});
		panel.add(btn_añadir);
		
		txt_usuario = new JTextField();
		txt_usuario.setText("Monto actual  en caja");
		txt_usuario.setFont(new Font("Dialog", Font.BOLD, 16));
		txt_usuario.setEditable(false);
		txt_usuario.setHorizontalAlignment(SwingConstants.CENTER);
		txt_usuario.setBounds(48, 129, 361, 32);
		panel.add(txt_usuario);
		txt_usuario.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("$");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(10, 76, 28, 20);
		panel.add(lblNewLabel);
	}
}
