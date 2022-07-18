package interfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.DefaultComboBoxModel;

public class Productos extends JFrame {

	private JPanel contentPane;
	private JTextField txt_fecha_inicial;
	private JTextField txt_fecha_final;
	private JTextField txt_notas_a_cerca_del_producto;
	private JTextField txt_distintivo_1;
	private JTextField txt_marca;
	private JTextField txt_proveedor;
	private JTextField txt_categoria;
	private JTextField txt_linea_de_produccion;
	private JTextField txt_stock;
	private JTextField txt_precio_de_venta;
	private JTextField txt_precio_de_compra;
	private JTextField txt_notas_a_cerca_de_su_seleccion;
	private JTextField txt_id;
	private JTextField txt_producto;
	private JComboBox cbx_atributos_de_contenido;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Productos frame = new Productos();
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
	public Productos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1089, 598);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1073, 559);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btn_regresar = new JButton("");
		btn_regresar.setIcon(new ImageIcon(Productos.class.getResource("/imagenes/flecha.png")));
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
		
		JLabel lbl_fecha_inicial = new JLabel("FECHA INICIAL");
		lbl_fecha_inicial.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_fecha_inicial.setFont(new Font("Dialog", Font.BOLD, 13));
		lbl_fecha_inicial.setBounds(289, 425, 135, 32);
		panel.add(lbl_fecha_inicial);
		
		txt_fecha_inicial = new JTextField();
		txt_fecha_inicial.setFont(new Font("Dialog", Font.BOLD, 12));
		txt_fecha_inicial.setColumns(10);
		txt_fecha_inicial.setBounds(289, 465, 135, 20);
		panel.add(txt_fecha_inicial);
		
		JLabel lbl_fecha_final = new JLabel("FECHA FINAL");
		lbl_fecha_final.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_fecha_final.setFont(new Font("Dialog", Font.BOLD, 13));
		lbl_fecha_final.setBounds(571, 425, 135, 32);
		panel.add(lbl_fecha_final);
		
		txt_fecha_final = new JTextField();
		txt_fecha_final.setFont(new Font("Dialog", Font.BOLD, 12));
		txt_fecha_final.setColumns(10);
		txt_fecha_final.setBounds(571, 465, 135, 20);
		panel.add(txt_fecha_final);
		
		JLabel lbl_calendario = new JLabel("");
		lbl_calendario.setIcon(new ImageIcon(Productos.class.getResource("/imagenes/calendario.png")));
		lbl_calendario.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_calendario.setBounds(434, 425, 76, 60);
		panel.add(lbl_calendario);
		
		JLabel lbl_calendario_1 = new JLabel("");
		lbl_calendario_1.setIcon(new ImageIcon(Productos.class.getResource("/imagenes/calendario.png")));
		lbl_calendario_1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_calendario_1.setBounds(716, 425, 76, 60);
		panel.add(lbl_calendario_1);
		
		JButton btn_ver_movimientos = new JButton("VER MOVIMIENTOS");
		btn_ver_movimientos.setFont(new Font("Dialog", Font.BOLD, 13));
		btn_ver_movimientos.setBounds(441, 508, 161, 23);
		
		btn_ver_movimientos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!txt_fecha_inicial.getText().equals("") && !txt_fecha_inicial.getText().equals("")) {
					Productos_Tabla_Ver_Movimientos p = new Productos_Tabla_Ver_Movimientos();
					p.setVisible(true);
					p.setLocationRelativeTo(null);
					p.setFocusable(true);
					
				}else {
					JOptionPane.showMessageDialog(null,"SELECCIONA UN RANGO DE FECHAS");
				}
			}
		});
		panel.add(btn_ver_movimientos);
		
		JButton btn_añadir = new JButton("AÑADIR");
		btn_añadir.setFont(new Font("Dialog", Font.BOLD, 13));
		btn_añadir.setBounds(907, 49, 156, 23);
		panel.add(btn_añadir);
		
		JButton btn_buscar = new JButton("BUSCAR");
		btn_buscar.setFont(new Font("Dialog", Font.BOLD, 13));
		btn_buscar.setBounds(907, 97, 156, 23);
		panel.add(btn_buscar);
		
		JButton btn_actualizar = new JButton("ACTUALIZAR");
		btn_actualizar.setFont(new Font("Dialog", Font.BOLD, 13));
		btn_actualizar.setBounds(907, 145, 156, 23);
		panel.add(btn_actualizar);
		
		JButton btn_eliminar = new JButton("ELIMINAR");
		btn_eliminar.setFont(new Font("Dialog", Font.BOLD, 13));
		btn_eliminar.setBounds(907, 194, 156, 23);
		panel.add(btn_eliminar);
		
		JButton btn_limpiar_campos = new JButton("LIMPIAR CAMPOS");
		btn_limpiar_campos.setFont(new Font("Dialog", Font.BOLD, 13));
		btn_limpiar_campos.setBounds(907, 241, 156, 23);
		panel.add(btn_limpiar_campos);
		
		JLabel lbl_distintivo1 = new JLabel("DISTINTIVO 1");
		lbl_distintivo1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_distintivo1.setFont(new Font("Dialog", Font.BOLD, 13));
		lbl_distintivo1.setBounds(10, 97, 227, 46);
		panel.add(lbl_distintivo1);
		
		JLabel notas_a_cerca_del_producto = new JLabel("<html><center>NOTAS A CERCA DEL PRODUCTO</center></html>");
		notas_a_cerca_del_producto.setHorizontalAlignment(SwingConstants.CENTER);
		notas_a_cerca_del_producto.setFont(new Font("Dialog", Font.BOLD, 13));
		notas_a_cerca_del_producto.setBounds(289, 97, 217, 46);
		panel.add(notas_a_cerca_del_producto);
		
		txt_notas_a_cerca_del_producto = new JTextField();
		txt_notas_a_cerca_del_producto.setFont(new Font("Dialog", Font.BOLD, 12));
		txt_notas_a_cerca_del_producto.setColumns(10);
		txt_notas_a_cerca_del_producto.setBounds(288, 145, 218, 23);
		panel.add(txt_notas_a_cerca_del_producto);
		
		txt_distintivo_1 = new JTextField();
		txt_distintivo_1.setFont(new Font("Dialog", Font.BOLD, 12));
		txt_distintivo_1.setColumns(10);
		txt_distintivo_1.setBounds(10, 145, 227, 23);
		panel.add(txt_distintivo_1);
		
		JLabel lbl_marca = new JLabel("MARCA");
		lbl_marca.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_marca.setFont(new Font("Dialog", Font.BOLD, 13));
		lbl_marca.setBounds(10, 198, 140, 23);
		panel.add(lbl_marca);
		
		txt_marca = new JTextField();
		txt_marca.setFont(new Font("Dialog", Font.BOLD, 12));
		txt_marca.setColumns(10);
		txt_marca.setBounds(10, 220, 140, 23);
		panel.add(txt_marca);
		
		JButton btn_buscar_marca = new JButton("");
		btn_buscar_marca.setIcon(new ImageIcon(Productos.class.getResource("/imagenes/buscar.png")));
		btn_buscar_marca.setBounds(58, 254, 46, 43);
		
		btn_buscar_marca.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(txt_marca.getText().equals("")) {
					JOptionPane.showMessageDialog(null,"CAMPO MARCA VACIO...");
					txt_marca.requestFocus();
				}else {
					Bar_Code_Tabla_Buscar_Marca m = new Bar_Code_Tabla_Buscar_Marca();
					m.setVisible(true);
					m.setLocationRelativeTo(null);
					m.setFocusable(true);
					txt_marca.requestFocus();
				}
			}
		});
		panel.add(btn_buscar_marca);
		
		JButton btn_limpiar_marca = new JButton("");
		btn_limpiar_marca.setIcon(new ImageIcon(Productos.class.getResource("/imagenes/limpiar.png")));
		btn_limpiar_marca.setBounds(160, 199, 46, 35);
		
		btn_limpiar_marca.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txt_marca.setText("");
				txt_marca.requestFocus();
			}
		});
		panel.add(btn_limpiar_marca);
		
		JLabel lbl_proveedor = new JLabel("PROVEEDOR");
		lbl_proveedor.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_proveedor.setFont(new Font("Dialog", Font.BOLD, 13));
		lbl_proveedor.setBounds(233, 198, 140, 23);
		panel.add(lbl_proveedor);
		
		txt_proveedor = new JTextField();
		txt_proveedor.setFont(new Font("Dialog", Font.BOLD, 12));
		txt_proveedor.setColumns(10);
		txt_proveedor.setBounds(233, 220, 140, 23);
		panel.add(txt_proveedor);
		
		JButton btn_buscar_proveedor = new JButton("");
		btn_buscar_proveedor.setIcon(new ImageIcon(Productos.class.getResource("/imagenes/buscar.png")));
		btn_buscar_proveedor.setBounds(283, 254, 46, 43);
		
		btn_buscar_proveedor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(txt_proveedor.getText().equals("")) {
					JOptionPane.showMessageDialog(null,"CAMPO PROVEEDOR VACIO...");
					txt_proveedor.requestFocus();
				}else {
					Bar_Code_Tabla_Buscar_Proveedor p = new Bar_Code_Tabla_Buscar_Proveedor();
					p.setVisible(true);
					p.setLocationRelativeTo(null);
					p.setFocusable(true);
					txt_proveedor.requestFocus();
				}
			}
		});
		panel.add(btn_buscar_proveedor);
		
		JButton btn_limpiar_proveedor = new JButton("");
		btn_limpiar_proveedor.setIcon(new ImageIcon(Productos.class.getResource("/imagenes/limpiar.png")));
		btn_limpiar_proveedor.setBounds(383, 199, 46, 35);
		
		btn_limpiar_proveedor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txt_proveedor.setText("");
				txt_proveedor.requestFocus();
			}
		});
		panel.add(btn_limpiar_proveedor);
		
		JLabel lbl_categoria = new JLabel("CATEGORIA");
		lbl_categoria.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_categoria.setFont(new Font("Dialog", Font.BOLD, 13));
		lbl_categoria.setBounds(457, 198, 140, 23);
		panel.add(lbl_categoria);
		
		txt_categoria = new JTextField();
		txt_categoria.setFont(new Font("Dialog", Font.BOLD, 12));
		txt_categoria.setColumns(10);
		txt_categoria.setBounds(457, 220, 140, 23);
		panel.add(txt_categoria);
		
		JButton btn_buscar_categoria = new JButton("");
		btn_buscar_categoria.setIcon(new ImageIcon(Productos.class.getResource("/imagenes/buscar.png")));
		btn_buscar_categoria.setBounds(508, 254, 46, 43);
		
		btn_buscar_categoria.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(txt_categoria.getText().equals("")) {
					JOptionPane.showMessageDialog(null,"CAMPO CATEGORIA VACIO...");
					txt_categoria.requestFocus();
				}else {
					Bar_Code_Tabla_Buscar_Categoria c = new Bar_Code_Tabla_Buscar_Categoria();
					c.setVisible(true);
					c.setLocationRelativeTo(null);
					c.setFocusable(true);
					txt_categoria.requestFocus();
				}
			}
		});
		panel.add(btn_buscar_categoria);
		
		JButton btn_limpiar_categoria = new JButton("");
		btn_limpiar_categoria.setIcon(new ImageIcon(Productos.class.getResource("/imagenes/limpiar.png")));
		btn_limpiar_categoria.setBounds(607, 199, 46, 35);
		
		btn_limpiar_categoria.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txt_categoria.setText("");
				txt_categoria.requestFocus();
			}
		});
		panel.add(btn_limpiar_categoria);
		
		JLabel lbl_linea = new JLabel("LINEA PRODUCCION");
		lbl_linea.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_linea.setFont(new Font("Dialog", Font.BOLD, 13));
		lbl_linea.setBounds(681, 198, 140, 23);
		panel.add(lbl_linea);
		
		txt_linea_de_produccion = new JTextField();
		txt_linea_de_produccion.setFont(new Font("Dialog", Font.BOLD, 12));
		txt_linea_de_produccion.setColumns(10);
		txt_linea_de_produccion.setBounds(681, 221, 140, 21);
		panel.add(txt_linea_de_produccion);
		
		JButton btn_buscar_linea_de_produccion = new JButton("");
		btn_buscar_linea_de_produccion.setIcon(new ImageIcon(Productos.class.getResource("/imagenes/buscar.png")));
		btn_buscar_linea_de_produccion.setBounds(732, 253, 46, 43);
		
		btn_buscar_linea_de_produccion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(txt_linea_de_produccion.getText().equals("")) {
					JOptionPane.showMessageDialog(null,"CAMPO LINEA DE PRODUCCION VACIO...");
					txt_linea_de_produccion.requestFocus();
				}else {
					Bar_Code_Tabla_Buscar_Linea_De_Produccion l = new Bar_Code_Tabla_Buscar_Linea_De_Produccion();
					l.setVisible(true);
					l.setLocationRelativeTo(null);
					l.setFocusable(true);
					txt_linea_de_produccion.requestFocus();
				}
			}
		});
		panel.add(btn_buscar_linea_de_produccion);
		
		JButton btn_limpiar_linea_de_produccion = new JButton("");
		btn_limpiar_linea_de_produccion.setIcon(new ImageIcon(Productos.class.getResource("/imagenes/limpiar.png")));
		btn_limpiar_linea_de_produccion.setBounds(831, 199, 46, 35);
		
		btn_limpiar_linea_de_produccion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txt_linea_de_produccion.setText("");
				txt_linea_de_produccion.requestFocus();
			}
		});
		panel.add(btn_limpiar_linea_de_produccion);
		
		JLabel lbl_atributos_del_contenido = new JLabel("<html><center>ATRIBUTOS DE CONTENIDO</center></html>");
		lbl_atributos_del_contenido.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_atributos_del_contenido.setFont(new Font("Dialog", Font.BOLD, 13));
		lbl_atributos_del_contenido.setBounds(10, 308, 140, 47);
		panel.add(lbl_atributos_del_contenido);
		
		cbx_atributos_de_contenido = new JComboBox();
		cbx_atributos_de_contenido.setFont(new Font("Dialog", Font.BOLD, 12));
		cbx_atributos_de_contenido.setModel(new DefaultComboBoxModel(new String[] {"SELECCIONAR", "MEDIDA", "MILILITROS", "COLOR ", "TAMAÑO", "KILOGRAMO"}));
		cbx_atributos_de_contenido.setBounds(10, 355, 140, 23);
		panel.add(cbx_atributos_de_contenido);
		
		JButton btn_limpiar_atributos_de_contenido = new JButton("");
		btn_limpiar_atributos_de_contenido.setIcon(new ImageIcon(Productos.class.getResource("/imagenes/limpiar.png")));
		btn_limpiar_atributos_de_contenido.setBounds(160, 332, 46, 35);
		
		btn_limpiar_atributos_de_contenido.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cbx_atributos_de_contenido.setSelectedIndex(0);
			}
		});
		panel.add(btn_limpiar_atributos_de_contenido);
		
		txt_stock = new JTextField();
		txt_stock.setFont(new Font("Dialog", Font.BOLD, 12));
		txt_stock.setColumns(10);
		txt_stock.setBounds(272, 355, 140, 23);
		panel.add(txt_stock);
		
		JLabel lbl_stock = new JLabel("STOCK");
		lbl_stock.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_stock.setFont(new Font("Dialog", Font.BOLD, 13));
		lbl_stock.setBounds(272, 308, 140, 47);
		panel.add(lbl_stock);
		
		JLabel lbl_precio_de_venta = new JLabel("PRECIO DE VENTA");
		lbl_precio_de_venta.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_precio_de_venta.setFont(new Font("Dialog", Font.BOLD, 13));
		lbl_precio_de_venta.setBounds(462, 308, 140, 47);
		panel.add(lbl_precio_de_venta);
		
		txt_precio_de_venta = new JTextField();
		txt_precio_de_venta.setFont(new Font("Dialog", Font.BOLD, 12));
		txt_precio_de_venta.setColumns(10);
		txt_precio_de_venta.setBounds(462, 355, 140, 23);
		panel.add(txt_precio_de_venta);
		
		JLabel lbl_precio_de_compra = new JLabel("PRECIO DE COMPRA");
		lbl_precio_de_compra.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_precio_de_compra.setFont(new Font("Dialog", Font.BOLD, 13));
		lbl_precio_de_compra.setBounds(662, 308, 140, 47);
		panel.add(lbl_precio_de_compra);
		
		txt_precio_de_compra = new JTextField();
		txt_precio_de_compra.setFont(new Font("Dialog", Font.BOLD, 12));
		txt_precio_de_compra.setColumns(10);
		txt_precio_de_compra.setBounds(662, 355, 140, 23);
		panel.add(txt_precio_de_compra);
		
		JLabel lbl_notas_a_cerca_de_su_seleccion = new JLabel("<html><center>NOTAS A CERCA DE SU SELECCION</center></html>");
		lbl_notas_a_cerca_de_su_seleccion.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_notas_a_cerca_de_su_seleccion.setFont(new Font("Dialog", Font.BOLD, 13));
		lbl_notas_a_cerca_de_su_seleccion.setBounds(10, 404, 140, 57);
		panel.add(lbl_notas_a_cerca_de_su_seleccion);
		
		txt_notas_a_cerca_de_su_seleccion = new JTextField();
		txt_notas_a_cerca_de_su_seleccion.setFont(new Font("Dialog", Font.BOLD, 12));
		txt_notas_a_cerca_de_su_seleccion.setColumns(10);
		txt_notas_a_cerca_de_su_seleccion.setBounds(10, 462, 140, 23);
		panel.add(txt_notas_a_cerca_de_su_seleccion);
		
		JLabel lbl_id = new JLabel("ID");
		lbl_id.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_id.setFont(new Font("Dialog", Font.BOLD, 13));
		lbl_id.setBounds(10, 40, 126, 23);
		panel.add(lbl_id);
		
		txt_id = new JTextField();
		txt_id.setFont(new Font("Dialog", Font.BOLD, 12));
		txt_id.setColumns(10);
		txt_id.setBounds(10, 64, 126, 23);
		panel.add(txt_id);
		
		JButton btn_generar_qr = new JButton("");
		btn_generar_qr.setIcon(new ImageIcon(Productos.class.getResource("/imagenes/cargando.png")));
		btn_generar_qr.setFont(new Font("Dialog", Font.BOLD, 13));
		btn_generar_qr.setBounds(146, 30, 59, 57);
		
		btn_generar_qr.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Productos_Generador b= new Productos_Generador();
				b.setVisible(true);
				b.setFocusable(true);
				b.setLocationRelativeTo(null);
			}
		});
		panel.add(btn_generar_qr);
		
		JLabel lbl_producto = new JLabel("PRODUCTO");
		lbl_producto.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_producto.setFont(new Font("Dialog", Font.BOLD, 13));
		lbl_producto.setBounds(288, 42, 167, 21);
		panel.add(lbl_producto);
		
		txt_producto = new JTextField();
		txt_producto.setFont(new Font("Dialog", Font.BOLD, 12));
		txt_producto.setColumns(10);
		txt_producto.setBounds(288, 64, 167, 23);
		panel.add(txt_producto);
	}
}
