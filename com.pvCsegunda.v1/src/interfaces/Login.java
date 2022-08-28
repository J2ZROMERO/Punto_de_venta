package interfaces;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.geom.RoundRectangle2D;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;





public class Login extends JFrame {

	private JPanel contentPane;
	private JPasswordField txt_password;
	public JComboBox cbx_nickname;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
					frame.setFocusable(true);
					frame.esc();
					frame.setLocationRelativeTo(null);
					
					Shape forma = new RoundRectangle2D.Double(0, 0, frame.getBounds().width, frame.getBounds().height, 30, 30);
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the frame.
	 */
	
	
	public void esc() {
		
		setFocusTraversalPolicyProvider(true);
		
		addKeyListener(new KeyAdapter() {
			
			public void keyPressed(KeyEvent e) {
				
				int codigo = e.getKeyCode();
				if(codigo == 27){
					System.exit(0);
				}
			}
		});
	}
		
		public Login() {
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 665, 389);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(186, 85, 211));
		panel.setBounds(0, 0, 649, 350);
		contentPane.add(panel);
		panel.setLayout(null);
		panel.addKeyListener(new KeyAdapter() {
			
			public void keyPressed(KeyEvent e) {
				
				int codigo = e.getKeyCode();
				if(codigo == 27){
					System.exit(0);
				}
			}
		});
		
		JLabel lbl_titulo = new JLabel("LOGIN");
		lbl_titulo.setFont(new Font("Roboto Slab Black", Font.BOLD, 16));
		lbl_titulo.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_titulo.setBounds(74, 11, 186, 22);
		panel.add(lbl_titulo);
		
		JLabel lbl_nickname = new JLabel("NICKNAME");
		lbl_nickname.setFont(new Font("Roboto Slab Black", Font.BOLD, 13));
		lbl_nickname.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_nickname.setBounds(10, 89, 100, 22);
		panel.add(lbl_nickname);
		
		JLabel lbl_password = new JLabel("PASSWORD");
		lbl_password.setFont(new Font("Roboto Slab Black", Font.BOLD, 13));
		lbl_password.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_password.setBounds(10, 200, 100, 22);
		panel.add(lbl_password);
		
		cbx_nickname = new JComboBox();
		cbx_nickname.setModel(new DefaultComboBoxModel(new String[] {"SELECCIONAR", "LUIS", "ANTONIO", "JOSE", "PEDRO"}));
		cbx_nickname.setName("");
		cbx_nickname.setFont(new Font("Roboto Slab", Font.BOLD, 12));
		cbx_nickname.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cbx_nickname.setBounds(124, 89, 231, 22);
		cbx_nickname.addKeyListener(new KeyAdapter() {
			
			public void keyPressed(KeyEvent e) {
				
				int codigo = e.getKeyCode();
				if(codigo == 27){
					System.exit(0);
				}
			}
		});
		panel.add(cbx_nickname);
		
		txt_password = new JPasswordField();
		txt_password.setFont(new Font("Roboto Slab", Font.BOLD, 20));
		txt_password.setBounds(124, 200, 231, 22);
		txt_password.addKeyListener(new KeyAdapter() {
			
		public void keyReleased(KeyEvent e) {
		String nombre = cbx_nickname.getName();
		String pass = txt_password.getText();
	
		if(cbx_nickname.getName().equals("")) {
				if (pass.equalsIgnoreCase("12345") && nombre.equalsIgnoreCase(cbx_nickname.getName())) {
					Caja_Inicial ci = new Caja_Inicial();
					ci.setVisible(true);
					ci.setFocusable(true);
					ci.setLocationRelativeTo(null);
					ci.txt_usuario.setText(cbx_nickname.getSelectedItem().toString());
					dispose();
				}
		}else {
			JOptionPane.showMessageDialog(null, "CAMPOS VACIOS...");
		}
			}
			
		    });
		
		/*CERRAR CON LA TECLA SCAPE*/
		
		txt_password.addKeyListener(new KeyAdapter() {
			
				
			
		public void keyPressed(KeyEvent e) {
				
		int codigo = e.getKeyCode();
		if(codigo == 27){
		System.exit(0);
				}
			}
		});
		
		panel.add(txt_password);
		
		
		
		JButton btn_ingresar = new JButton("INGRESAR");
		btn_ingresar.addActionListener(new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
		   
			String usuario,password,us1="luis",us2="pedro",us3="marco",us4="antonio",pass1="12345",pass2="123456",pass3="2311212",pass4="12312343";
			
			usuario = cbx_nickname.getSelectedItem().toString();
			password = String.valueOf(txt_password.getPassword());
			
			//String contra = String.valueOf(txt_password.getPassword());
			//String user = cbx_nickname.getSelectedItem().toString();
			
		    //System.out.println(usuario);
		    //System.out.println(password);
			
			if((usuario.equals(us1) && password.equals(pass1)) || (usuario.equals(us2) && password.equals(pass2)) || (usuario.equals(us3) && password.equals(pass3)) ||(usuario.equals(us4) && password.equals(pass4) )) {                        
				JOptionPane.showMessageDialog(null, "DATOS CORRECTOS...");
				//cbx_nickname.setSelectedIndex(0);
				txt_password.setText("");
			}else {
				JOptionPane.showMessageDialog(null, "DATOS INCORRECTOS...");
				txt_password.setText("");
			}
		
		}
		});
		
		btn_ingresar.setFont(new Font("Roboto Slab", Font.BOLD, 13));
		btn_ingresar.setBounds(135, 275, 111, 23);
		panel.add(btn_ingresar);
		btn_ingresar.addKeyListener(new KeyAdapter() {
		
		public void keyPressed(KeyEvent e) {
			
			int codigo = e.getKeyCode();
			if(codigo == 27){
				System.exit(0);
			}
		}
	    });
		
	}
}
