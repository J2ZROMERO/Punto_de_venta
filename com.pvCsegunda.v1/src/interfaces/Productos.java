package interfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
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
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;

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
		notas_a_cerca_del_producto.setBounds(289, 98, 217, 46);
		panel.add(notas_a_cerca_del_producto);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(288, 145, 218, 23);
		panel.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(10, 145, 227, 23);
		panel.add(textField_1);
		
		JLabel lbl_marca = new JLabel("MARCA");
		lbl_marca.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_marca.setFont(new Font("Dialog", Font.BOLD, 13));
		lbl_marca.setBounds(10, 198, 140, 23);
		panel.add(lbl_marca);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(10, 220, 140, 23);
		panel.add(textField_2);
		
		JButton btn_buscar_marca = new JButton("");
		btn_buscar_marca.setIcon(new ImageIcon(Productos.class.getResource("/imagenes/buscar.png")));
		btn_buscar_marca.setBounds(58, 254, 46, 43);
		panel.add(btn_buscar_marca);
		
		JButton btn_limpiar_marca = new JButton("");
		btn_limpiar_marca.setIcon(new ImageIcon(Productos.class.getResource("/imagenes/limpiar.png")));
		btn_limpiar_marca.setBounds(160, 199, 46, 35);
		panel.add(btn_limpiar_marca);
		
		JLabel lbl_proveedor = new JLabel("PROVEEDOR");
		lbl_proveedor.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_proveedor.setFont(new Font("Dialog", Font.BOLD, 13));
		lbl_proveedor.setBounds(233, 198, 140, 23);
		panel.add(lbl_proveedor);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(233, 220, 140, 23);
		panel.add(textField_3);
		
		JButton btn_buscar_proveedor = new JButton("");
		btn_buscar_proveedor.setIcon(new ImageIcon(Productos.class.getResource("/imagenes/buscar.png")));
		btn_buscar_proveedor.setBounds(283, 254, 46, 43);
		panel.add(btn_buscar_proveedor);
		
		JButton btn_limpiar_proveedor = new JButton("");
		btn_limpiar_proveedor.setIcon(new ImageIcon(Productos.class.getResource("/imagenes/limpiar.png")));
		btn_limpiar_proveedor.setBounds(383, 199, 46, 35);
		panel.add(btn_limpiar_proveedor);
		
		JLabel lbl_categoria = new JLabel("CATEGORIA");
		lbl_categoria.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_categoria.setFont(new Font("Dialog", Font.BOLD, 13));
		lbl_categoria.setBounds(457, 198, 140, 23);
		panel.add(lbl_categoria);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(457, 220, 140, 23);
		panel.add(textField_4);
		
		JButton btn_buscar_categoria = new JButton("");
		btn_buscar_categoria.setIcon(new ImageIcon(Productos.class.getResource("/imagenes/buscar.png")));
		btn_buscar_categoria.setBounds(508, 254, 46, 43);
		panel.add(btn_buscar_categoria);
		
		JButton btn_limpiar_categoria = new JButton("");
		btn_limpiar_categoria.setIcon(new ImageIcon(Productos.class.getResource("/imagenes/limpiar.png")));
		btn_limpiar_categoria.setBounds(607, 199, 46, 35);
		panel.add(btn_limpiar_categoria);
		
		JLabel lbl_linea = new JLabel("LINEA PRODUCCION");
		lbl_linea.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_linea.setFont(new Font("Dialog", Font.BOLD, 13));
		lbl_linea.setBounds(681, 198, 140, 23);
		panel.add(lbl_linea);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(681, 221, 140, 21);
		panel.add(textField_5);
		
		JButton btn_buscar_linea_de_produccion = new JButton("");
		btn_buscar_linea_de_produccion.setIcon(new ImageIcon(Productos.class.getResource("/imagenes/buscar.png")));
		btn_buscar_linea_de_produccion.setBounds(732, 253, 46, 43);
		panel.add(btn_buscar_linea_de_produccion);
		
		JButton btn_limpiar_linea_de_produccion = new JButton("");
		btn_limpiar_linea_de_produccion.setIcon(new ImageIcon(Productos.class.getResource("/imagenes/limpiar.png")));
		btn_limpiar_linea_de_produccion.setBounds(831, 199, 46, 35);
		panel.add(btn_limpiar_linea_de_produccion);
		
		JLabel lbl_atributos_del_contenido = new JLabel("<html><center>ATRIBUTOS DE CONTENIDO</center></html>");
		lbl_atributos_del_contenido.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_atributos_del_contenido.setFont(new Font("Dialog", Font.BOLD, 13));
		lbl_atributos_del_contenido.setBounds(10, 308, 140, 47);
		panel.add(lbl_atributos_del_contenido);
		
		JComboBox cbx_atributos_de_contenido = new JComboBox();
		cbx_atributos_de_contenido.setModel(new DefaultComboBoxModel(new String[] {"SELECCIONAR", "MEDIDA", "MILILITROS", "COLOR ", "TAMAÑO", "KILOGRAMO"}));
		cbx_atributos_de_contenido.setBounds(10, 355, 140, 23);
		panel.add(cbx_atributos_de_contenido);
		
		JButton btn_limpiar_atributos_de_contenido = new JButton("");
		btn_limpiar_atributos_de_contenido.setIcon(new ImageIcon(Productos.class.getResource("/imagenes/limpiar.png")));
		btn_limpiar_atributos_de_contenido.setBounds(160, 332, 46, 35);
		panel.add(btn_limpiar_atributos_de_contenido);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(272, 355, 140, 23);
		panel.add(textField_6);
		
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
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(462, 355, 140, 23);
		panel.add(textField_7);
		
		JLabel lbl_precio_de_compra = new JLabel("PRECIO DE COMPRA");
		lbl_precio_de_compra.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_precio_de_compra.setFont(new Font("Dialog", Font.BOLD, 13));
		lbl_precio_de_compra.setBounds(662, 308, 140, 47);
		panel.add(lbl_precio_de_compra);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(662, 355, 140, 23);
		panel.add(textField_8);
		
		JLabel lbl_notas_a_cerca_de_su_seleccion = new JLabel("<html><center>NOTAS A CERCA DE SU SELECCION</center></html>");
		lbl_notas_a_cerca_de_su_seleccion.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_notas_a_cerca_de_su_seleccion.setFont(new Font("Dialog", Font.BOLD, 13));
		lbl_notas_a_cerca_de_su_seleccion.setBounds(10, 404, 140, 57);
		panel.add(lbl_notas_a_cerca_de_su_seleccion);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(10, 462, 140, 23);
		panel.add(textField_9);
		
		JLabel lbl_id = new JLabel("ID");
		lbl_id.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_id.setFont(new Font("Dialog", Font.BOLD, 13));
		lbl_id.setBounds(10, 40, 126, 23);
		panel.add(lbl_id);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(10, 64, 126, 23);
		panel.add(textField_10);
		
		JButton btn_generar_qr = new JButton("");
		btn_generar_qr.setIcon(new ImageIcon(Productos.class.getResource("/imagenes/cargando.png")));
		btn_generar_qr.setFont(new Font("Dialog", Font.BOLD, 13));
		btn_generar_qr.setBounds(146, 30, 59, 57);
		panel.add(btn_generar_qr);
		
		JLabel lbl_producto = new JLabel("PRODUCTO");
		lbl_producto.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_producto.setFont(new Font("Dialog", Font.BOLD, 13));
		lbl_producto.setBounds(288, 42, 167, 21);
		panel.add(lbl_producto);
		
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setBounds(288, 64, 167, 23);
		panel.add(textField_11);
	}
}
