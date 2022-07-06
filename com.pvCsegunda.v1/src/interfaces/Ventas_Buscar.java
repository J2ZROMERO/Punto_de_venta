package interfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.DefaultComboBoxModel;

public class Ventas_Buscar extends JFrame {

	private JPanel contentPane;
	private JTextField txt_id;
	private JTextField txt_producto;
	private JTextField txt_distintivo_1;
	private JTextField txt_notas_a_cerca_del_producto;
	private JTextField txt_marca;
	private JTextField txt_proveedor;
	private JTextField txt_categoria;
	private JTextField txt_linea_de_produccion;
	private JTextField txt_stock;
	private JTextField txt_precio_de_venta;
	private JTextField txt_precio_de_compra;
	private JTextField txt_notas_a_cerca_de_su_seleccion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventas_Buscar frame = new Ventas_Buscar();
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
	public Ventas_Buscar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 902, 520);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 886, 481);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lbl_id = new JLabel("ID");
		lbl_id.setBounds(10, 11, 124, 23);
		lbl_id.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_id.setFont(new Font("Roboto Slab Black", Font.BOLD, 13));
		panel.add(lbl_id);
		
		txt_id = new JTextField();
		txt_id.setBounds(10, 35, 126, 23);
		panel.add(txt_id);
		txt_id.setColumns(10);
		
		JButton btn_copiar_id = new JButton("COPIAR  ID");
		btn_copiar_id.setBounds(146, 34, 111, 23);
		btn_copiar_id.setFont(new Font("Roboto Slab Black", Font.BOLD, 13));
		panel.add(btn_copiar_id);
		
		JLabel lbl_producto = new JLabel("PRODUCTO");
		lbl_producto.setBounds(288, 13, 167, 21);
		lbl_producto.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_producto.setFont(new Font("Roboto Slab Black", Font.BOLD, 13));
		panel.add(lbl_producto);
		
		txt_producto = new JTextField();
		txt_producto.setBounds(288, 35, 167, 23);
		txt_producto.setColumns(10);
		panel.add(txt_producto);
		
		JButton btn_buscar = new JButton("BUSCAR");
		btn_buscar.setBounds(489, 34, 111, 23);
		btn_buscar.setFont(new Font("Roboto Slab Black", Font.BOLD, 13));
		
		btn_buscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Ventas_Tabla_Bucar vt = new Ventas_Tabla_Bucar();
				vt.setVisible(true);
				vt.setFocusable(true);
				vt.setLocationRelativeTo(null);
			}
		});
		panel.add(btn_buscar);
		
		JLabel lbl_distintivo1 = new JLabel("DISTINTIVO 1");
		lbl_distintivo1.setBounds(10, 105, 159, 23);
		lbl_distintivo1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_distintivo1.setFont(new Font("Dialog", Font.BOLD, 13));
		panel.add(lbl_distintivo1);
		
		txt_distintivo_1 = new JTextField();
		txt_distintivo_1.setBounds(10, 130, 159, 23);
		txt_distintivo_1.setColumns(10);
		panel.add(txt_distintivo_1);
		
		JLabel notas_a_cerca_del_producto = new JLabel("<html><center>NOTAS A CERCA DEL PRODUCTO</center></html>");
		notas_a_cerca_del_producto.setBounds(219, 83, 182, 46);
		notas_a_cerca_del_producto.setHorizontalAlignment(SwingConstants.CENTER);
		notas_a_cerca_del_producto.setFont(new Font("Dialog", Font.BOLD, 13));
		panel.add(notas_a_cerca_del_producto);
		
		txt_notas_a_cerca_del_producto = new JTextField();
		txt_notas_a_cerca_del_producto.setBounds(218, 130, 184, 23);
		txt_notas_a_cerca_del_producto.setColumns(10);
		panel.add(txt_notas_a_cerca_del_producto);
		
		JLabel lbl_marca = new JLabel("MARCA");
		lbl_marca.setBounds(10, 183, 140, 23);
		lbl_marca.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_marca.setFont(new Font("Dialog", Font.BOLD, 13));
		panel.add(lbl_marca);
		
		txt_marca = new JTextField();
		txt_marca.setBounds(10, 205, 140, 23);
		txt_marca.setColumns(10);
		panel.add(txt_marca);
		
		JLabel lbl_proveedor = new JLabel("PROVEEDOR");
		lbl_proveedor.setBounds(233, 183, 140, 23);
		lbl_proveedor.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_proveedor.setFont(new Font("Dialog", Font.BOLD, 13));
		panel.add(lbl_proveedor);
		
		txt_proveedor = new JTextField();
		txt_proveedor.setBounds(233, 205, 140, 23);
		txt_proveedor.setColumns(10);
		panel.add(txt_proveedor);
		
		JLabel lbl_categoria = new JLabel("CATEGORIA");
		lbl_categoria.setBounds(457, 183, 140, 23);
		lbl_categoria.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_categoria.setFont(new Font("Dialog", Font.BOLD, 13));
		panel.add(lbl_categoria);
		
		txt_categoria = new JTextField();
		txt_categoria.setBounds(457, 205, 140, 23);
		txt_categoria.setColumns(10);
		panel.add(txt_categoria);
		
		JLabel lbl_linea = new JLabel("LINEA PRODUCCION");
		lbl_linea.setBounds(681, 183, 140, 23);
		lbl_linea.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_linea.setFont(new Font("Dialog", Font.BOLD, 13));
		panel.add(lbl_linea);
		
		txt_linea_de_produccion = new JTextField();
		txt_linea_de_produccion.setBounds(681, 206, 140, 21);
		txt_linea_de_produccion.setColumns(10);
		panel.add(txt_linea_de_produccion);
		
		JLabel lbl_atributos_del_contenido = new JLabel("<html><center>ATRIBUTOS DE CONTENIDO</center></html>");
		lbl_atributos_del_contenido.setBounds(10, 293, 140, 47);
		lbl_atributos_del_contenido.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_atributos_del_contenido.setFont(new Font("Dialog", Font.BOLD, 13));
		panel.add(lbl_atributos_del_contenido);
		
		JComboBox cbx_atributos_de_contenido = new JComboBox();
		cbx_atributos_de_contenido.setModel(new DefaultComboBoxModel(new String[] {"SELECCIONAR", "MEDIDA", "MILILITROS", "COLOR", "TAMAÑO", "KILOGRAMOS"}));
		cbx_atributos_de_contenido.setBounds(10, 340, 140, 23);
		panel.add(cbx_atributos_de_contenido);
		
		JLabel lbl_stock = new JLabel("STOCK");
		lbl_stock.setBounds(272, 293, 140, 47);
		lbl_stock.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_stock.setFont(new Font("Dialog", Font.BOLD, 13));
		panel.add(lbl_stock);
		
		txt_stock = new JTextField();
		txt_stock.setBounds(272, 340, 140, 23);
		txt_stock.setColumns(10);
		panel.add(txt_stock);
		
		JLabel lbl_precio_de_venta = new JLabel("PRECIO DE VENTA");
		lbl_precio_de_venta.setBounds(462, 293, 140, 47);
		lbl_precio_de_venta.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_precio_de_venta.setFont(new Font("Dialog", Font.BOLD, 13));
		panel.add(lbl_precio_de_venta);
		
		txt_precio_de_venta = new JTextField();
		txt_precio_de_venta.setBounds(462, 340, 140, 23);
		txt_precio_de_venta.setColumns(10);
		panel.add(txt_precio_de_venta);
		
		JLabel lbl_precio_de_compra = new JLabel("PRECIO DE COMPRA");
		lbl_precio_de_compra.setBounds(662, 293, 140, 47);
		lbl_precio_de_compra.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_precio_de_compra.setFont(new Font("Dialog", Font.BOLD, 13));
		panel.add(lbl_precio_de_compra);
		
		txt_precio_de_compra = new JTextField();
		txt_precio_de_compra.setBounds(662, 340, 140, 23);
		txt_precio_de_compra.setColumns(10);
		panel.add(txt_precio_de_compra);
		
		JLabel lbl_notas_a_cerca_de_su_seleccion = new JLabel("<html><center>NOTAS A CERCA DE SU SELECCION</center></html>");
		lbl_notas_a_cerca_de_su_seleccion.setBounds(10, 389, 140, 57);
		lbl_notas_a_cerca_de_su_seleccion.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_notas_a_cerca_de_su_seleccion.setFont(new Font("Dialog", Font.BOLD, 13));
		panel.add(lbl_notas_a_cerca_de_su_seleccion);
		
		txt_notas_a_cerca_de_su_seleccion = new JTextField();
		txt_notas_a_cerca_de_su_seleccion.setBounds(10, 447, 140, 23);
		txt_notas_a_cerca_de_su_seleccion.setColumns(10);
		panel.add(txt_notas_a_cerca_de_su_seleccion);
		
		JButton btn_limpiar_marca = new JButton("");
		btn_limpiar_marca.setIcon(new ImageIcon(Ventas_Buscar.class.getResource("/imagenes/limpiar.png")));
		btn_limpiar_marca.setBounds(160, 184, 46, 35);
		panel.add(btn_limpiar_marca);
		
		JButton btn_limpiar_proveedor = new JButton("");
		btn_limpiar_proveedor.setIcon(new ImageIcon(Ventas_Buscar.class.getResource("/imagenes/limpiar.png")));
		btn_limpiar_proveedor.setBounds(383, 184, 46, 35);
		panel.add(btn_limpiar_proveedor);
		
		JButton btn_limpiar_categoria = new JButton("");
		btn_limpiar_categoria.setIcon(new ImageIcon(Ventas_Buscar.class.getResource("/imagenes/limpiar.png")));
		btn_limpiar_categoria.setBounds(607, 184, 46, 35);
		panel.add(btn_limpiar_categoria);
		
		JButton btn_limpiar_linea_de_produccion = new JButton("");
		btn_limpiar_linea_de_produccion.setIcon(new ImageIcon(Ventas_Buscar.class.getResource("/imagenes/limpiar.png")));
		btn_limpiar_linea_de_produccion.setBounds(831, 184, 46, 35);
		panel.add(btn_limpiar_linea_de_produccion);
		
		JButton btn_limpiar_atributos_de_contenido = new JButton("");
		btn_limpiar_atributos_de_contenido.setIcon(new ImageIcon(Ventas_Buscar.class.getResource("/imagenes/limpiar.png")));
		btn_limpiar_atributos_de_contenido.setBounds(160, 317, 46, 35);
		panel.add(btn_limpiar_atributos_de_contenido);
		
		JButton btn_buscar_marca = new JButton("");
		btn_buscar_marca.setIcon(new ImageIcon(Ventas_Buscar.class.getResource("/imagenes/buscar.png")));
		btn_buscar_marca.setBounds(58, 239, 46, 43);
		panel.add(btn_buscar_marca);
		
		JButton btn_buscar_proveedor = new JButton("");
		btn_buscar_proveedor.setIcon(new ImageIcon(Ventas_Buscar.class.getResource("/imagenes/buscar.png")));
		btn_buscar_proveedor.setBounds(283, 239, 46, 43);
		panel.add(btn_buscar_proveedor);
		
		JButton btn_buscar_categoria = new JButton("");
		btn_buscar_categoria.setIcon(new ImageIcon(Ventas_Buscar.class.getResource("/imagenes/buscar.png")));
		btn_buscar_categoria.setBounds(508, 239, 46, 43);
		panel.add(btn_buscar_categoria);
		
		JButton btn_buscar_linea_de_produccion = new JButton("");
		btn_buscar_linea_de_produccion.setIcon(new ImageIcon(Ventas_Buscar.class.getResource("/imagenes/buscar.png")));
		btn_buscar_linea_de_produccion.setBounds(732, 238, 46, 43);
		panel.add(btn_buscar_linea_de_produccion);
	}
}
