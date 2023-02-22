package test;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JSpinner;

public class Tabla extends JFrame {
	String [] encabezadosColumnas={"Primer Nombre", "Apellido", "Sexo", "Edad"} ;

    String [] [] datosUsuarios={

                  {"Adriana", "Parada","F", "21"},



   };
	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tabla frame = new Tabla();
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

	public Tabla() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 728, 540);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(569, 434, 64, 20);
		panel.add(spinner);
		
		DefaultTableModel modelo =  new DefaultTableModel(datosUsuarios,encabezadosColumnas ) ;
Object data[] = {"aa",spinner};
		modelo.addRow(data);
		
		
		table = new JTable();
		table.setBounds(29, 24, 637, 381);
		table.setModel(modelo);
		panel.add(table);
		
		
		
		
		
		
		
	}
}
