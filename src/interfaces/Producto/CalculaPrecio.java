package interfaces.Producto;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;

public class CalculaPrecio extends JFrame {

	private JPanel contentPane;
	private JTextField txt_cantidadpzas;
	private JTextField txt_sevendepor;
	private JTextField txt_costo;
	private JTextField txt_resultado;
	private JTextField txt_ganancia;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalculaPrecio frame = new CalculaPrecio();
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
	public CalculaPrecio() {
		
		//setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 559, 527);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Me costo");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(52, 23, 149, 37);
		panel.add(lblNewLabel);
		
		JLabel lblUnidades = new JLabel("Trae (piezas)");
		lblUnidades.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblUnidades.setBounds(299, 23, 210, 37);
		panel.add(lblUnidades);
		
		JLabel lblSeVendePor = new JLabel("Se vende por(pzas) ");
		lblSeVendePor.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblSeVendePor.setBounds(305, 124, 203, 37);
		panel.add(lblSeVendePor);
		
		txt_cantidadpzas = new JTextField();
		txt_cantidadpzas.setFont(new Font("Tahoma", Font.PLAIN, 30));
		txt_cantidadpzas.setColumns(10);
		txt_cantidadpzas.setBounds(333, 71, 134, 42);
		panel.add(txt_cantidadpzas);
		
		JLabel lblAlPublico = new JLabel("$ publico");
		lblAlPublico.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblAlPublico.setBounds(188, 232, 161, 37);
		panel.add(lblAlPublico);
		
		txt_sevendepor = new JTextField();
		txt_sevendepor.setFont(new Font("Tahoma", Font.PLAIN, 30));
		txt_sevendepor.setColumns(10);
		txt_sevendepor.setBounds(333, 172, 134, 42);
		panel.add(txt_sevendepor);
		setDefaultCloseOperation(this.DO_NOTHING_ON_CLOSE);
		txt_costo = new JTextField();
		txt_costo.setFont(new Font("Tahoma", Font.PLAIN, 30));
		txt_costo.setColumns(10);
		txt_costo.setBounds(49, 71, 134, 42);
		panel.add(txt_costo);
		
		txt_resultado = new JTextField();
		txt_resultado.setFont(new Font("Tahoma", Font.PLAIN, 30));
		txt_resultado.setHorizontalAlignment(SwingConstants.CENTER);
		txt_resultado.setEditable(false);
		txt_resultado.setColumns(10);
		txt_resultado.setBounds(199, 280, 134, 42);
		panel.add(txt_resultado);
		
		JButton btn_calcular = new JButton("CALCULAR");
		btn_calcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DecimalFormat df = new DecimalFormat("#.##");
				
				txt_resultado.setText(String.valueOf(df.format(
						(
								( Double.parseDouble(txt_sevendepor.getText())*Double.parseDouble(txt_costo.getText()))/Double.parseDouble(txt_cantidadpzas.getText())+  
								(!txt_ganancia.getText().equals("")? Double.parseDouble(txt_ganancia.getText()): 0)   ) )));
				
			}
		});
		btn_calcular.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btn_calcular.setBounds(166, 333, 194, 65);
		panel.add(btn_calcular);
		
		JLabel lblGanancia = new JLabel("Ganancia");
		lblGanancia.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblGanancia.setBounds(52, 124, 161, 37);
		panel.add(lblGanancia);
		
		txt_ganancia = new JTextField();
		txt_ganancia.setHorizontalAlignment(SwingConstants.CENTER);
		txt_ganancia.setFont(new Font("Tahoma", Font.PLAIN, 30));
		txt_ganancia.setColumns(10);
		txt_ganancia.setBounds(52, 172, 134, 42);
		panel.add(txt_ganancia);
		
		JButton btn_calcular_1 = new JButton("Ok");
		btn_calcular_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btn_calcular_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btn_calcular_1.setBounds(166, 409, 194, 65);
		panel.add(btn_calcular_1);
	}
}
