package interfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import conexionDB.DB_ventas;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ProductoUnitario extends JFrame {
	private Object dataFromModel[];
	private JPanel contentPane;
	private JTextField txt_id;
	private JTextField txt_producto;
	private JComboBox cbx_precio;
	private DefaultTableModel modeloFromVentas;
    public static boolean ExisteEnLaTabla = false;
	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProductoUnitario frame = new ProductoUnitario();
					Object dato[] = {"uno","tres","dos",0};
					//frame.set_items_data(dato);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public ProductoUnitario(long id, DefaultTableModel modelo) {

		
		
		modeloFromVentas = modelo;
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 342, 391);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lbl_id = new JLabel("ID");
		lbl_id.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_id.setBounds(10, 11, 46, 14);
		panel.add(lbl_id);
		
		JLabel lbl_product = new JLabel("PRODUCTO");
		lbl_product.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_product.setBounds(10, 61, 78, 14);
		panel.add(lbl_product);
		
		cbx_precio = new JComboBox();
		cbx_precio.setBounds(129, 145, 148, 22);
		panel.add(cbx_precio);
	
		
		JButton btn_ok = new JButton("OK");
		btn_ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();

			}
		});
		btn_ok.setBounds(79, 257, 146, 23);
		panel.add(btn_ok);
		
		txt_id = new JTextField();
		txt_id.setBounds(20, 36, 148, 20);
		panel.add(txt_id);
		txt_id.setColumns(10);
		
		txt_producto = new JTextField();
		txt_producto.setColumns(10);
		txt_producto.setBounds(20, 86, 148, 20);
		panel.add(txt_producto);
		
		JLabel lbl_precio = new JLabel("SELECCIONA PRECIO");
		lbl_precio.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_precio.setBounds(129, 117, 148, 14);
		panel.add(lbl_precio);
		
		JLabel lblNewLabel = new JLabel("Precio 1");
		lblNewLabel.setBounds(10, 172, 109, 14);
		panel.add(lblNewLabel);
		
		JLabel lblPrecioPieza = new JLabel("Precio 2");
		lblPrecioPieza.setBounds(10, 185, 109, 14);
		panel.add(lblPrecioPieza);
		
		JLabel lblProductoTerminado = new JLabel("Producto terminado");
		lblProductoTerminado.setBounds(10, 197, 109, 14);
		panel.add(lblProductoTerminado);
		addWindowListener(new WindowAdapter() {
			public void windowClosed(WindowEvent e) {
		
				try {
					 
					 dataFromModel = DB_ventas.add_row_double_precio(id,modelo,Double.parseDouble(cbx_precio.getSelectedItem().toString()));
					 
					 
					 
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
	
		
			
			
		
		

	}
	
	
	
	public void set_items_data(long id, String producto,Object item[]) {			
		
		cbx_precio.removeAllItems();

		this.setVisible(true);
		this.setLocationRelativeTo(null);
	txt_id.setText(String.valueOf(id));
	txt_producto.setText(producto);
	Arrays.stream(item).forEach(cbx_precio::addItem);
	
	
	

	}
	
	public void elementoDoblePrecio(JFrame doblePrecio) {
		System.out.println("compara el evento");
	
	}
	
}
