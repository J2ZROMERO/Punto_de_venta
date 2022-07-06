package interfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JCheckBox;

public class Ventas extends JFrame {

	private JPanel contentPane;
	private JTextField txt_id_cliente;
	private JTextField txt_id;
	private JTextField txt_existencia;
	private JTextField txt_precio;
	private JTextField txt_notas_extra;
	private JTable tbl_ventas;
	private JTextField txt_descuento;
	private JTextField txt_extra;
	private JTextField txt_total;
	private JTextField txt_paga_con;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventas frame = new Ventas();
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
	public Ventas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 979, 599);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 963, 560);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lbl_id_cliente = new JLabel("ID CLIENTE");
		lbl_id_cliente.setFont(new Font("Dialog", Font.BOLD, 13));
		lbl_id_cliente.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_id_cliente.setBounds(10, 11, 112, 22);
		panel.add(lbl_id_cliente);
		
		txt_id_cliente = new JTextField();
		txt_id_cliente.setFont(new Font("Dialog", Font.BOLD, 12));
		txt_id_cliente.setBounds(132, 11, 157, 22);
		panel.add(txt_id_cliente);
		txt_id_cliente.setColumns(10);
		
		JButton btn_buscar_clientes = new JButton("BUSCAR CLIENTES");
		btn_buscar_clientes.setFont(new Font("Dialog", Font.BOLD, 13));
		btn_buscar_clientes.setBounds(313, 11, 179, 22);
		panel.add(btn_buscar_clientes);
		
		JLabel lbl_id = new JLabel("ID");
		lbl_id.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_id.setFont(new Font("Dialog", Font.BOLD, 13));
		lbl_id.setBounds(10, 61, 112, 22);
		panel.add(lbl_id);
		
		txt_id = new JTextField();
		txt_id.setFont(new Font("Dialog", Font.BOLD, 12));
		txt_id.setColumns(10);
		txt_id.setBounds(132, 61, 157, 22);
		panel.add(txt_id);
		
		JButton btn_buscar_productos = new JButton("BUSCAR PRODUCTOS");
		btn_buscar_productos.setFont(new Font("Dialog", Font.BOLD, 13));
		btn_buscar_productos.setBounds(313, 61, 179, 22);
		panel.add(btn_buscar_productos);
		
		JLabel lbl_existencia = new JLabel("EXISTENCIA");
		lbl_existencia.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_existencia.setFont(new Font("Dialog", Font.BOLD, 13));
		lbl_existencia.setBounds(10, 113, 157, 22);
		panel.add(lbl_existencia);
		
		txt_existencia = new JTextField();
		txt_existencia.setFont(new Font("Dialog", Font.BOLD, 12));
		txt_existencia.setColumns(10);
		txt_existencia.setBounds(10, 135, 157, 22);
		panel.add(txt_existencia);
		
		JLabel lbl_precio = new JLabel("PRECIO");
		lbl_precio.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_precio.setFont(new Font("Dialog", Font.BOLD, 13));
		lbl_precio.setBounds(210, 113, 157, 22);
		panel.add(lbl_precio);
		
		txt_precio = new JTextField();
		txt_precio.setFont(new Font("Dialog", Font.BOLD, 12));
		txt_precio.setColumns(10);
		txt_precio.setBounds(210, 135, 157, 22);
		panel.add(txt_precio);
		
		JLabel lbl_notas_extra = new JLabel("NOTAS EXTRA");
		lbl_notas_extra.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_notas_extra.setFont(new Font("Dialog", Font.BOLD, 13));
		lbl_notas_extra.setBounds(10, 186, 943, 22);
		panel.add(lbl_notas_extra);
		
		txt_notas_extra = new JTextField();
		txt_notas_extra.setFont(new Font("Dialog", Font.BOLD, 12));
		txt_notas_extra.setColumns(10);
		txt_notas_extra.setBounds(10, 208, 943, 22);
		panel.add(txt_notas_extra);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 252, 823, 171);
		panel.add(scrollPane);
		
		tbl_ventas = new JTable();
		tbl_ventas.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"<html><center>NOMBRE</center></html>", "<html><center>DISTINTIVO 1</center></html>", "<html><center>IMPUESTO</center></html>", "<html><center>PRECIO</center></html>", "<html><center>CANTIDAD</center></html>"
			}
		));
		tbl_ventas.setFont(new Font("Dialog", Font.BOLD, 12));
		scrollPane.setViewportView(tbl_ventas);
		
		JButton btn_menos = new JButton("-");
		btn_menos.setFont(new Font("Dialog", Font.BOLD, 18));
		btn_menos.setBounds(843, 331, 50, 27);
		panel.add(btn_menos);
		
		JButton btn_mas = new JButton("+");
		btn_mas.setFont(new Font("Dialog", Font.BOLD, 18));
		btn_mas.setBounds(903, 331, 50, 27);
		panel.add(btn_mas);
		
		JCheckBox cchk_descuento = new JCheckBox("");
		cchk_descuento.setHorizontalTextPosition(SwingConstants.CENTER);
		cchk_descuento.setHorizontalAlignment(SwingConstants.CENTER);
		cchk_descuento.setBounds(10, 445, 41, 44);
		panel.add(cchk_descuento);
		
		JLabel lbl_descuento = new JLabel("DESCUENTO");
		lbl_descuento.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_descuento.setFont(new Font("Dialog", Font.BOLD, 13));
		lbl_descuento.setBounds(57, 445, 157, 22);
		panel.add(lbl_descuento);
		
		txt_descuento = new JTextField();
		txt_descuento.setFont(new Font("Dialog", Font.BOLD, 12));
		txt_descuento.setColumns(10);
		txt_descuento.setBounds(57, 467, 157, 22);
		panel.add(txt_descuento);
		
		JLabel lbl_extra = new JLabel("EXTRA");
		lbl_extra.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_extra.setFont(new Font("Dialog", Font.BOLD, 13));
		lbl_extra.setBounds(57, 505, 157, 22);
		panel.add(lbl_extra);
		
		txt_extra = new JTextField();
		txt_extra.setFont(new Font("Dialog", Font.BOLD, 12));
		txt_extra.setColumns(10);
		txt_extra.setBounds(57, 527, 157, 22);
		panel.add(txt_extra);
		
		JLabel lbl_total = new JLabel("TOTAL");
		lbl_total.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_total.setFont(new Font("Dialog", Font.BOLD, 13));
		lbl_total.setBounds(236, 483, 157, 22);
		panel.add(lbl_total);
		
		txt_total = new JTextField();
		txt_total.setFont(new Font("Dialog", Font.BOLD, 12));
		txt_total.setColumns(10);
		txt_total.setBounds(236, 505, 157, 22);
		panel.add(txt_total);
		
		JLabel lbl_paga_con = new JLabel("PAGA CON");
		lbl_paga_con.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_paga_con.setFont(new Font("Dialog", Font.BOLD, 13));
		lbl_paga_con.setBounds(415, 483, 157, 22);
		panel.add(lbl_paga_con);
		
		txt_paga_con = new JTextField();
		txt_paga_con.setFont(new Font("Dialog", Font.BOLD, 12));
		txt_paga_con.setColumns(10);
		txt_paga_con.setBounds(415, 505, 157, 22);
		panel.add(txt_paga_con);
		
		JLabel lbl_cambio = new JLabel("CAMBIO");
		lbl_cambio.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_cambio.setFont(new Font("Dialog", Font.BOLD, 13));
		lbl_cambio.setBounds(594, 483, 157, 22);
		panel.add(lbl_cambio);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Dialog", Font.BOLD, 12));
		textField_2.setColumns(10);
		textField_2.setBounds(594, 505, 157, 22);
		panel.add(textField_2);
		
		JButton btn_generar_venta = new JButton("GENERAR VENTA");
		btn_generar_venta.setFont(new Font("Dialog", Font.BOLD, 13));
		btn_generar_venta.setBounds(774, 445, 179, 22);
		panel.add(btn_generar_venta);
		
		JButton btn_ver_ventas = new JButton("VER VENTAS");
		btn_ver_ventas.setFont(new Font("Dialog", Font.BOLD, 13));
		btn_ver_ventas.setBounds(774, 483, 179, 22);
		panel.add(btn_ver_ventas);
		
		JCheckBox chk_imprimir_recibo = new JCheckBox("IMPRIMIR RECIBO");
		chk_imprimir_recibo.setFont(new Font("Dialog", Font.BOLD, 13));
		chk_imprimir_recibo.setHorizontalAlignment(SwingConstants.CENTER);
		chk_imprimir_recibo.setBounds(772, 528, 181, 23);
		panel.add(chk_imprimir_recibo);
		
		JButton btn_cancelar_pedido = new JButton("CANCELAR PEDIDO");
		btn_cancelar_pedido.setFont(new Font("Dialog", Font.BOLD, 13));
		btn_cancelar_pedido.setBounds(544, 61, 179, 22);
		panel.add(btn_cancelar_pedido);
	}
}
