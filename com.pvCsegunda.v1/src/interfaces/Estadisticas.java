package interfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class Estadisticas extends JFrame {

	private JPanel contentPane;
	private JTextField txt_fecha_inicial;
	private JTextField txt_fecha_final;
	private JTextField txt_id;
	private JComboBox cbx_estadisticas_por;
	private JComboBox cbx_estadisticas_por_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Estadisticas frame = new Estadisticas();
					frame.setVisible(true);
					frame.setFocusable(true);
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
	
	public String[] getEstadisticas(String Estadisticas_por)
	{
	    String[] Estadisticas=new String[6];
	    if(Estadisticas_por.equalsIgnoreCase("GANANCIAS"))
	    {
	    	Estadisticas[0]="SELECCIONAR";
	    	Estadisticas[1]="PERDIDAS Y DEVOLUCIONES";
	    	Estadisticas[2]="PRODUCTO";
	    	Estadisticas[3]="USUARIO";
	    	Estadisticas[4]="CLIENTES";
	    	Estadisticas[5]="GENERALES";
	    }                               
	    if(Estadisticas_por.equalsIgnoreCase("USUARIOS"))
	    {
	    	Estadisticas[0]="SELECCIONAR";
	    	Estadisticas[1]="GANANCIA";
	    	Estadisticas[2]="PRODUCTO";
	    	Estadisticas[3]="GENERALES";
	    	Estadisticas[4]="CLIENTE";
	    	Estadisticas[5]="USUARIO";
	    }
	    if(Estadisticas_por.equalsIgnoreCase("CLIENTES"))
	    {
	    	Estadisticas[0]="SELECCIONAR";
	    	Estadisticas[1]="VENTAS";
	    	Estadisticas[2]="USUARIO";
	    	Estadisticas[3]="PRODUCTO";
	    	Estadisticas[4]="GENERAL";
	    	Estadisticas[5]="CLIENTE";
	    }
	    if(Estadisticas_por.equalsIgnoreCase("PRODUCTOS"))
	    {
	    	Estadisticas[0]="SELECCIONAR";
	    	Estadisticas[1]="GANANCIA";
	    	Estadisticas[2]="PRODUCTO";
	    	Estadisticas[3]="GENERALES";
	    	Estadisticas[4]="CLIENTE";
	    	Estadisticas[5]="USUARIO";
	    }
	    if(Estadisticas_por.equalsIgnoreCase("GENERALES"))
	    {
	    	Estadisticas[0]="SELECCIONAR";
	    	Estadisticas[1]="GANANCIA";
	    	Estadisticas[2]="PRODUCTO";
	    	Estadisticas[3]="GENERALES";
	    	Estadisticas[4]="CLIENTE";
	    	Estadisticas[5]="USUARIO";
	    }
	    return Estadisticas;
}
	
	public Estadisticas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1043, 664);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, -1, 1026, 626);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lbl_imagen = new JLabel("");
		lbl_imagen.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_imagen.setIcon(new ImageIcon(Estadisticas.class.getResource("/imagenes/calendario.png")));
		lbl_imagen.setBounds(682, 54, 70, 71);
		panel.add(lbl_imagen);
		
		cbx_estadisticas_por = new JComboBox();
		cbx_estadisticas_por.setModel(new DefaultComboBoxModel(new String[] {"SELECCIONAR", "GANANCIAS", "USUARIOS", "CLIENTES", "PRODUCTOS", "GENERALES"}));
		cbx_estadisticas_por.setFont(new Font("Roboto Slab", Font.BOLD, 12));
		cbx_estadisticas_por.setBounds(170, 68, 177, 27);
		
		cbx_estadisticas_por.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
			if(e.getStateChange() == ItemEvent.SELECTED) {
				if(cbx_estadisticas_por.getSelectedIndex()>0) {
					cbx_estadisticas_por_1.setModel(new DefaultComboBoxModel(getEstadisticas(cbx_estadisticas_por.getSelectedItem().toString())));
				}
				else {
					cbx_estadisticas_por_1.setSelectedIndex(0);
				}
			}
			}
		});
		panel.add(cbx_estadisticas_por);
		
		JLabel lbl_estadistica = new JLabel("ESTADISTICA POR");
		lbl_estadistica.setFont(new Font("Roboto Slab Black", Font.BOLD, 13));
		lbl_estadistica.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_estadistica.setBounds(11, 67, 149, 27);
		panel.add(lbl_estadistica);
		
		JLabel lbl_estadistica_1 = new JLabel("ESTADISTICA POR");
		lbl_estadistica_1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_estadistica_1.setFont(new Font("Roboto Slab Black", Font.BOLD, 13));
		lbl_estadistica_1.setBounds(10, 157, 149, 27);
		panel.add(lbl_estadistica_1);
		
		cbx_estadisticas_por_1 = new JComboBox();
		cbx_estadisticas_por_1.setFont(new Font("Roboto Slab", Font.BOLD, 12));
		cbx_estadisticas_por_1.setBounds(169, 158, 177, 27);
		panel.add(cbx_estadisticas_por_1);
		
		JLabel lbl_fecha_inicial = new JLabel("FECHA INICIAL");
		lbl_fecha_inicial.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_fecha_inicial.setFont(new Font("Roboto Slab Black", Font.BOLD, 13));
		lbl_fecha_inicial.setBounds(364, 70, 149, 27);
		panel.add(lbl_fecha_inicial);
		
		txt_fecha_inicial = new JTextField();
		txt_fecha_inicial.setBounds(523, 70, 149, 27);
		panel.add(txt_fecha_inicial);
		txt_fecha_inicial.setColumns(10);
		
		JLabel lbl_fecha_final = new JLabel("FECHA FINAL");
		lbl_fecha_final.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_fecha_final.setFont(new Font("Roboto Slab Black", Font.BOLD, 13));
		lbl_fecha_final.setBounds(364, 159, 149, 27);
		panel.add(lbl_fecha_final);
		
		txt_fecha_final = new JTextField();
		txt_fecha_final.setColumns(10);
		txt_fecha_final.setBounds(523, 159, 149, 27);
		panel.add(txt_fecha_final);
		
		JLabel lbl_calendario = new JLabel("");
		lbl_calendario.setIcon(new ImageIcon(Estadisticas.class.getResource("/imagenes/calendario.png")));
		lbl_calendario.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_calendario.setBounds(682, 136, 70, 71);
		panel.add(lbl_calendario);
		
		JLabel lbl_id = new JLabel("ID");
		lbl_id.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_id.setFont(new Font("Roboto Slab Black", Font.BOLD, 13));
		lbl_id.setBounds(11, 233, 70, 27);
		panel.add(lbl_id);
		
		txt_id = new JTextField();
		txt_id.setColumns(10);
		txt_id.setBounds(91, 233, 147, 27);
		panel.add(txt_id);
		
		JButton btn_buscar = new JButton("BUSCAR");
		btn_buscar.setFont(new Font("Roboto Slab Black", Font.BOLD, 13));
		btn_buscar.setBounds(248, 233, 99, 27);
		panel.add(btn_buscar);
		
		JButton btn_ejecutar_estadistica = new JButton("EJECUTAR ESTADISTICA");
		btn_ejecutar_estadistica.setFont(new Font("Roboto Slab Black", Font.BOLD, 13));
		btn_ejecutar_estadistica.setBounds(399, 233, 205, 27);
		panel.add(btn_ejecutar_estadistica);
		
		JButton btn_limpiar_campos = new JButton("LIMPIAR CAMPOS");
		btn_limpiar_campos.setFont(new Font("Roboto Slab Black", Font.BOLD, 13));
		btn_limpiar_campos.setBounds(809, 61, 173, 27);
		panel.add(btn_limpiar_campos);
		
		JButton btn_imprimir = new JButton("IMPRIMIR");
		btn_imprimir.setFont(new Font("Roboto Slab Black", Font.BOLD, 13));
		btn_imprimir.setBounds(809, 111, 173, 27);
		panel.add(btn_imprimir);
		
		JButton btn_guardar = new JButton("GUARDAR");
		btn_guardar.setFont(new Font("Roboto Slab Black", Font.BOLD, 13));
		btn_guardar.setBounds(809, 161, 175, 27);
		panel.add(btn_guardar);
		
		JButton btn_regresar = new JButton("");
		btn_regresar.setIcon(new ImageIcon(Estadisticas.class.getResource("/imagenes/flecha.png")));
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
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(11, 291, 1005, 324);
		panel.add(scrollPane);
		
		JButton btn_limpiar_hoja = new JButton("LIMPIAR HOJA");
		btn_limpiar_hoja.setFont(new Font("Dialog", Font.BOLD, 13));
		btn_limpiar_hoja.setBounds(809, 211, 173, 27);
		panel.add(btn_limpiar_hoja);
	}
}
