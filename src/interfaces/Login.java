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

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import conexionDB.DB_acceso;
import conexionDB.DB_caja;
import conexionDB.DB_productos;
import conexionDB.DB_usuarios;
import conexionDB.DB_ventas;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Frame;
import java.awt.HeadlessException;

import javax.swing.border.EmptyBorder;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.awt.Cursor;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLException;
import java.util.Iterator;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import javax.swing.SpringLayout;



public class Login extends JFrame {

	public static String usuario_menu;
	private JPanel contentPane;
	private JPasswordField txt_password;
	public JComboBox cbx_nickname;
	private JLabel lbl_alerta_1;
	private JLabel lbl_alerta_2;
	public static int idUsers[];
	public static int indiceSeleccionado;
	
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
	
	
	public void Validar_Campos() {
		if(cbx_nickname.getSelectedIndex()>0) {
			lbl_alerta_1.setForeground(new Color(186, 85, 211));
		}else {
			lbl_alerta_1.setForeground(new Color(0,0,0));
		}
		
		if(!"".equals(txt_password.getText())) {
			lbl_alerta_2.setForeground(new Color(186, 85, 211));
		}else {
			lbl_alerta_2.setForeground(new Color(0,0,0));
		}
	}
		
		public Login() {
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 443, 234);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 427, 195);
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
		
		JLabel lbl_titulo = new JLabel("BIENVENIDO");
		lbl_titulo.setFont(new Font("Dialog", Font.BOLD, 35));
		lbl_titulo.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_titulo.setBounds(113, 11, 259, 47);
		panel.add(lbl_titulo);
		
		JLabel lbl_nickname = new JLabel("NOMBRE");
		lbl_nickname.setFont(new Font("Roboto Slab Black", Font.BOLD, 13));
		lbl_nickname.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_nickname.setBounds(10, 75, 100, 22);
		panel.add(lbl_nickname);
		
		JLabel lbl_password = new JLabel("CONTRASEÑA");
		lbl_password.setFont(new Font("Roboto Slab Black", Font.BOLD, 13));
		lbl_password.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_password.setBounds(10, 116, 100, 22);
		panel.add(lbl_password);
		
		cbx_nickname = new JComboBox();
		
		lista_usuarios(cbx_nickname);
		
		cbx_nickname.setName("");
		cbx_nickname.setFont(new Font("Roboto Slab", Font.BOLD, 12));
		cbx_nickname.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		cbx_nickname.setBounds(124, 75, 231, 22);
		
		cbx_nickname.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				Validar_Campos();
			}
		});
		

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
		txt_password.setBounds(124, 113, 231, 22);
		txt_password.addKeyListener(new KeyAdapter() {
			
			
		public void keyPressed(KeyEvent e) {
			
			if(e.getKeyCode() == KeyEvent.VK_ENTER) {
	
				
					try {
						if (acceso_usuario(cbx_nickname, txt_password)) {
							Caja_Inicial cliente = new Caja_Inicial();
							cliente.setVisible(true);
							cliente.setFocusable(true);
							cliente.setLocationRelativeTo(null);
							usuario_menu =  cbx_nickname.getSelectedItem().toString();
							cliente.txt_monto.requestFocus();
							cliente.txt_usuario.setText(cbx_nickname.getSelectedItem().toString());
							dispose();
							Validar_Campos();
							
							
						}

						else {
							JOptionPane.showMessageDialog(null, "DATOS INCORRECTOS...");
							
							txt_password.setText("");
						}
					} catch (HeadlessException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	
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
			
			
			try {
				if(acceso_usuario(cbx_nickname, txt_password) == true) {
					Caja_Inicial establece_monto = new Caja_Inicial();
					
					usuario_menu =  cbx_nickname.getSelectedItem().toString();
					establece_monto.setVisible(true);
					establece_monto.setFocusable(true);
					
					establece_monto.setLocationRelativeTo(null);
					establece_monto.txt_monto.requestFocus();
					
				dispose();
				}else {
					JOptionPane.showMessageDialog(null, "DATOS INCORRECTOS...");
					txt_password.setText("");
				}
			} catch (HeadlessException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		}
		});
		
		btn_ingresar.setFont(new Font("Roboto Slab", Font.BOLD, 13));
		btn_ingresar.setBounds(186, 146, 111, 23);
		panel.add(btn_ingresar);
		
		
		lbl_alerta_1 = new JLabel("*");
		lbl_alerta_1.setHorizontalTextPosition(SwingConstants.CENTER);
		lbl_alerta_1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_alerta_1.setForeground(Color.BLACK);
		lbl_alerta_1.setFont(new Font("Dialog", Font.BOLD, 23));
		lbl_alerta_1.setBounds(124, 122, 231, 24);
		panel.add(lbl_alerta_1);
		
		lbl_alerta_2= new JLabel("*");
		lbl_alerta_2.setHorizontalTextPosition(SwingConstants.CENTER);
		lbl_alerta_2.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_alerta_2.setForeground(Color.BLACK);
		lbl_alerta_2.setFont(new Font("Dialog", Font.BOLD, 23));
		lbl_alerta_2.setBounds(124, 233, 231, 24);
		panel.add(lbl_alerta_2);
		btn_ingresar.addKeyListener(new KeyAdapter() {
		
		public void keyPressed(KeyEvent e) {
			
			int codigo = e.getKeyCode();
			if(codigo == 27){
			System.exit(0);
			}
		}
	
	    });
		
		//eventoTeclado_enter tecla_enter = new eventoTeclado_enter(this,cbx_nickname, txt_password);
		//txt_password.addKeyListener(tecla_enter);
	
		
	}
		public void lista_usuarios(JComboBox users) {
			
			
		try {
			users.addItem("");
			this.idUsers = new int[DB_usuarios.nicknames().size()];
			
			for(int i = 1;  i < DB_usuarios.nicknames().size(); i++) {
				
				Object indice_lista[]  =(Object[]) DB_usuarios.nicknames().get(i);
    
		this.idUsers[i]	= Integer.parseInt(indice_lista[0].toString());
    			users.addItem(indice_lista[2]);	
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		}
		
public boolean acceso_usuario(JComboBox cbx, JTextField pass) throws SQLException {
	
	System.out.println(cbx.getSelectedItem().toString()+" "+ pass.getText());
	boolean confirma_acceso = false;
		
		confirma_acceso =  DB_acceso.acceso(this.idUsers[cbx.getSelectedIndex()], pass.getText());
		
		this.indiceSeleccionado= cbx.getSelectedIndex();
		

	return confirma_acceso;
	
}
}



	


