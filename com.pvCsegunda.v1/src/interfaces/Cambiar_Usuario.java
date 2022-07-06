package interfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.DefaultComboBoxModel;

public class Cambiar_Usuario extends JFrame {

	private JPanel contentPane;
    public static Cambiar_Usuario frame;
    public JComboBox cbx_selecciona_usuario;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Cambiar_Usuario();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					frame.setFocusable(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Cambiar_Usuario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 699, 176);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 681, 136);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lbl_selecciona_usuario = new JLabel("<html><center>SELECCIONA USUARIO</center></html>");
		lbl_selecciona_usuario.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_selecciona_usuario.setFont(new Font("Dialog", Font.BOLD, 13));
		lbl_selecciona_usuario.setBounds(10, 11, 118, 114);
		panel.add(lbl_selecciona_usuario);
		
		/*JComboBox*/cbx_selecciona_usuario = new JComboBox();
		cbx_selecciona_usuario.setModel(new DefaultComboBoxModel(new String[] {"SELECCIONAR", "LUIS", "ANTONIO", "JOSE", "PEDRO"}));
		cbx_selecciona_usuario.setFont(new Font("Dialog", Font.BOLD, 12));
		cbx_selecciona_usuario.setBounds(138, 53, 256, 29);
		panel.add(cbx_selecciona_usuario);
		
		JButton btn_confirmar_usuario = new JButton("CONFIRMAR USUARIO");
		btn_confirmar_usuario.setFont(new Font("Dialog", Font.BOLD, 13));
		btn_confirmar_usuario.setBounds(448, 50, 205, 32);
		
		btn_confirmar_usuario.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Menu_principal mp = new Menu_principal();
				if(cbx_selecciona_usuario.getSelectedIndex() >=1) {
					
					mp.txt_cambiar_usuario.setText(cbx_selecciona_usuario.getSelectedItem().toString());
					mp.setVisible(true);
					mp.frame.setFocusable(true);
					
					
					dispose();
					//JOptionPane.showMessageDialog(null,cbx_selecciona_usuario.getSelectedItem());
				}else {
					JOptionPane.showMessageDialog(null,"SELECCIONA UN USUARIO");
				}
			}
		});
		panel.add(btn_confirmar_usuario);
	}
}
