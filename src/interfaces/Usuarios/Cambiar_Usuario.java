package interfaces.Usuarios;

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
		
		cbx_selecciona_usuario = new JComboBox();
		cbx_selecciona_usuario.setModel(new DefaultComboBoxModel(new String[] {"SELECCIONAR", "LUIS", "ANTONIO", "JOSE", "PEDRO"}));
		cbx_selecciona_usuario.setFont(new Font("Dialog", Font.BOLD, 12));
		cbx_selecciona_usuario.setBounds(138, 54, 256, 29);
		panel.add(cbx_selecciona_usuario);
		
		JButton btn_confirmar = new JButton("CONFIRMAR");
		btn_confirmar.setFont(new Font("Dialog", Font.BOLD, 13));
		btn_confirmar.setBounds(448, 52, 205, 32);
		
		btn_confirmar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Login l = new Login();
				Menu_principal mp = new Menu_principal();
				if(cbx_selecciona_usuario.getSelectedIndex() > 0) {
					dispose();
					l.setVisible(true);
					l.cbx_nickname.setSelectedIndex(cbx_selecciona_usuario.getSelectedIndex());
		            //String elementoSeleccionado = cbx_selecciona_usuario.getSelectedItem().toString();
		            
		            //l.cbx_nickname.addItem(elementoSeleccionado);
					//l.cbx_nickname.setSelectedItem(cbx_selecciona_usuario.getSelectedItem());
					l.setFocusable(true);
					l.setLocationRelativeTo(null);
					
					dispose();
					
				}else {
					JOptionPane.showMessageDialog(null,"SELECCIONA UN USUARIO");
					frame.requestFocus();
				}
			}
	 });
		panel.add(btn_confirmar);
	}
}
