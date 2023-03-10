package interfaces;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.itextpdf.text.log.SysoCounter;

import conexionDB.DB_caja;
import metodos_externos_necesarios.SoloDecimalTextField;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Caja_Inicial extends JFrame {

	private JPanel contentPane;
	public SoloDecimalTextField   txt_monto;
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
		
		txt_monto = new SoloDecimalTextField();
		txt_monto.setHorizontalAlignment(SwingConstants.CENTER);
		txt_monto.setText("0.0");
		txt_monto.setFont(new Font("Dialog", Font.BOLD, 17));
		txt_monto.setBounds(48, 73, 232, 24);
		panel.add(txt_monto);
		txt_monto.setColumns(10);
		txt_monto.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == 8) {
					txt_monto.setText("");
				}
				
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
						
					if(!txt_monto.getText().equals("")) {
						
						Menu_principal mp = new Menu_principal();
						mp.setVisible(true);
						mp.setFocusable(true);
						mp.setLocationRelativeTo(null);
						
						monto = txt_monto.getText();	
						
						Object datosCajaInicial[] = {Double.parseDouble(txt_monto.getText()),"ENTRADA DE EFECTIVO INICIAL","SALDO INICIAL",Double.parseDouble(txt_monto.getText()),Login.idUsers[Login.indiceSeleccionado]};
						try {
							DB_caja.insertarCajaInicial(datosCajaInicial);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}		
				dispose();
						}else {
							JOptionPane.showMessageDialog(null,"CAMPOS VACIOS...");
							frame.requestFocus();
						}
						}
					
				
			}
		});
		
		JLabel lbl_caja_inicial = new JLabel("CAJA INICIAL");
		lbl_caja_inicial.setFont(new Font("Dialog", Font.BOLD, 35));
		lbl_caja_inicial.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_caja_inicial.setBounds(48, 11, 361, 32);
		panel.add(lbl_caja_inicial);
		JButton btn_añadir = new JButton("AÑADIR");
		
		btn_añadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_añadir.setFont(new Font("Dialog", Font.BOLD, 13));
		btn_añadir.setBounds(320, 73, 89, 24);
		
		
		btn_añadir.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				
				if(!txt_monto.getText().equals("")) {
					
				Menu_principal mp = new Menu_principal();
				mp.setVisible(true);
				mp.setFocusable(true);
				mp.setLocationRelativeTo(null);
				
				monto = txt_monto.getText();	
				
				Object datosCajaInicial[] = {Double.parseDouble(txt_monto.getText()),"ENTRADA","SALDO INICIAL",0,"",Login.idUsers[Login.indiceSeleccionado]};
				try {
					DB_caja.insertarCajaInicial(datosCajaInicial);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}		
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
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 37));
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(10, 61, 28, 32);
		panel.add(lblNewLabel);
		
		

			

	}



	public class NumberOnlyTextField extends JTextField {

	    public NumberOnlyTextField() {
	        super();
	        this.addKeyListener(new KeyAdapter() {
	            public void keyTyped(KeyEvent e) {
	                char c = e.getKeyChar();
	                if (!((c >= '0' && c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
	                    e.consume();
	                }
	            }
	        });
	    }
	}

	
public  static  String monto;

}
