package interfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Label;

import javax.swing.table.DefaultTableModel;

import conexionDB.DB_productos;

import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Color;

public class Productos_Tabla_Buscar extends JFrame {

	private JPanel contentPane;
	private JTable tbl_mrs;
	private JTable tbl_linea;
	private JTable tbl_categoria;
	private JTable tbl_provedores;
	private JTextField jtf_provedores;
	private JTextField jtf_categoria;
	private JTextField jtf_linea;
	private JTextField jtf_marca;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Productos_Tabla_Buscar frame = new Productos_Tabla_Buscar();
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
	public Productos_Tabla_Buscar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 658, 511);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(198, 144, 125));
		panel.setBounds(0, 0, 642, 476);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane marcas = new JScrollPane();
		marcas.setBounds(10, 11, 139, 344);
		panel.add(marcas);
		
		tbl_mrs = new JTable();
		marcas.setViewportView(tbl_mrs);


		
		JButton btn_ok = new JButton("OK");
		btn_ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_ok.setFont(new Font("Dialog", Font.BOLD, 13));
		btn_ok.setBounds(261, 428, 127, 23);
		
		btn_ok.addMouseListener(new MouseAdapter() {
			@Override
			
			
			public void mouseClicked(MouseEvent e) {

				Productos.impresion_atributos(jtf_marca.getText(),jtf_linea.getText(),jtf_categoria.getText(),jtf_provedores.getText());
	
				for(JTextField jtext: Productos.bloquear_campos()) {
		jtext.setEnabled(false);
	}
				
				dispose();
			}
		});
		panel.add(btn_ok);
		
		JScrollPane lineas = new JScrollPane();
		lineas.setBounds(176, 11, 139, 344);
		panel.add(lineas);
		tbl_linea = new JTable();
		lineas.setViewportView(tbl_linea);
	
		JScrollPane categoria = new JScrollPane();
		categoria.setBounds(340, 11, 139, 344);
		panel.add(categoria);
		tbl_categoria = new JTable();
		categoria.setViewportView(tbl_categoria);
	
		
	
		
		JScrollPane provedor = new JScrollPane();
		provedor.setBounds(490, 11, 139, 344);
		panel.add(provedor);
		
		tbl_provedores = new JTable();
		provedor.setViewportView(tbl_provedores);
	
		
		ver_datos_tablas(tbl_mrs, tbl_linea, tbl_categoria, tbl_provedores);
		
		 jtf_marca = new JTextField();
		jtf_marca.setBounds(10, 366, 102, 14);
		panel.add(jtf_marca);
		
		jtf_linea = new JTextField();
		jtf_linea.setBounds(176, 366, 139, 14);
		panel.add(jtf_linea);
		
		 jtf_categoria = new JTextField();
		jtf_categoria.setBounds(340, 366, 139, 14);
		panel.add(jtf_categoria);
		
		 jtf_provedores = new JTextField();
		jtf_provedores.setBounds(490, 366, 139, 14);
		panel.add(jtf_provedores);
		
		evento(tbl_mrs,jtf_marca);
		evento(tbl_linea,jtf_linea);
		evento(tbl_categoria,jtf_categoria);
		evento(tbl_provedores,jtf_provedores);
		evento_raton evento_marcas = new evento_raton(jtf_marca);
		evento_raton evento_linea = new evento_raton(jtf_linea);

		evento_raton evento_categoria = new evento_raton(jtf_categoria);

		evento_raton evento_provedor = new evento_raton(jtf_provedores);
	

	}

	public void ver_datos_tablas(JTable marcas,JTable linea,JTable categoria,JTable provedor) {
		try {
			marcas.setModel(DB_productos.model_view__prod_marcas());
			linea.setModel(DB_productos.model_view_prod_linea());
			categoria.setModel(DB_productos.model_view_prod_categoria());
			provedor.setModel(DB_productos.model_view_prod_provedores());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		

	}
	
	public void evento(JTable tabla,JTextField jtf_marca) {
tabla.addMouseListener( new MouseAdapter() {
			
			public void mousePressed(MouseEvent e) {
				
				if(e.getButton() == 3) {
					tabla.clearSelection();
					jtf_marca.setText("");
				}else {
					   String selectedCellValue = (String) tabla.getValueAt(tabla.getSelectedRow() , tabla.getSelectedColumn());
			            jtf_marca.setText(selectedCellValue);
	if(e.getClickCount() == 2) {
		tabla.clearSelection();	
				}
				
				
}
		            
			}});


	}
//	public  String[] llaves_foraneas() {
//		
//		String llave[] = new String[4];
//		llave[0] = jtf_marca.getText();
//				llave[1] = jtf_linea.getText();
//						llave[2] = jtf_categoria.getText();
//							llave[3] = jtf_provedores.getText();
//										
//		return llave;
//		
//	}
	
}
class evento_raton extends MouseAdapter{
public evento_raton(JTextField campo_editable) {
	this.campo_editable = campo_editable;
}
	public void mousePressed(MouseEvent e) {
this.campo_editable.setText("");



	}
	
	
private JTextField campo_editable;	
}
