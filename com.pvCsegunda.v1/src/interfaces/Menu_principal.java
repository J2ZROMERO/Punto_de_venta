package interfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JToggleButton;
import java.awt.Font;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Cursor;
import javax.swing.JTextField;

public class Menu_principal extends JFrame {

	private JPanel contentPane;
	public JTextField txt_usuario;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu_principal frame = new Menu_principal();
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
	public Menu_principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 613, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 594, 711);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lbl_ventas = new JLabel("");
		lbl_ventas.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lbl_ventas.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_ventas.setIcon(new ImageIcon(Menu_principal.class.getResource("/imagenes/ventas.png")));
		lbl_ventas.setBounds(42, 60, 109, 85);
		
		lbl_ventas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Ventas v = new Ventas();
				v.setVisible(true);
				v.setFocusable(true);
				v.setLocationRelativeTo(null);
				dispose();
			}
		});
		panel.add(lbl_ventas);
		
		JLabel lbl_ventas_titulo = new JLabel("VENTAS");
		lbl_ventas_titulo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lbl_ventas_titulo.setFont(new Font("Roboto Slab Black", Font.BOLD, 13));
		lbl_ventas_titulo.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_ventas_titulo.setBounds(42, 148, 109, 20);
		
		lbl_ventas_titulo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Ventas v = new Ventas();
				v.setVisible(true);
				v.setFocusable(true);
				v.setLocationRelativeTo(null);
				dispose();
			}
		});
		panel.add(lbl_ventas_titulo);
		
		JLabel lbl_inventario = new JLabel("");
		lbl_inventario.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lbl_inventario.setIcon(new ImageIcon(Menu_principal.class.getResource("/imagenes/inventario.png")));
		lbl_inventario.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_inventario.setBounds(247, 60, 109, 85);
		lbl_inventario.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Productos pr = new Productos();
				pr.setVisible(true);
				pr.setFocusable(true);
				pr.setLocationRelativeTo(null);
				dispose();
			}
		});
		panel.add(lbl_inventario);
		
		JLabel lbl_inventario_titulo = new JLabel("INVENTARIO");
		lbl_inventario_titulo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lbl_inventario_titulo.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_inventario_titulo.setFont(new Font("Roboto Slab Black", Font.BOLD, 13));
		lbl_inventario_titulo.setBounds(247, 148, 109, 20);
		
		lbl_inventario_titulo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Productos pr = new Productos();
				pr.setVisible(true);
				pr.setFocusable(true);
				pr.setLocationRelativeTo(null);
				dispose();
			}
		});
		panel.add(lbl_inventario_titulo);
		
		JLabel lbl_proveedores_titulo = new JLabel("<html><center>PROVEEDORES</center></html>");
		lbl_proveedores_titulo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lbl_proveedores_titulo.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_proveedores_titulo.setFont(new Font("Roboto Slab Black", Font.BOLD, 13));
		lbl_proveedores_titulo.setBounds(450, 638, 109, 31);
		
		lbl_proveedores_titulo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				Proveedores pr = new Proveedores();
				pr.setVisible(true);
				pr.setFocusable(true);
				pr.setLocationRelativeTo(null);
			    dispose();
				
			}
		});
		panel.add(lbl_proveedores_titulo);
		
		JLabel lbl_estadisticas = new JLabel("");
		lbl_estadisticas.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lbl_estadisticas.setIcon(new ImageIcon(Menu_principal.class.getResource("/imagenes/estadisticas.png")));
		lbl_estadisticas.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_estadisticas.setBounds(42, 236, 109, 85);
		
		lbl_estadisticas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Estadisticas frame = new Estadisticas();
				frame.setVisible(true);
				frame.setFocusable(true);
				frame.setLocationRelativeTo(null);
				dispose();
			}
		});
		panel.add(lbl_estadisticas);
		
		JLabel lbl_usuarios = new JLabel("");
		lbl_usuarios.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lbl_usuarios.setIcon(new ImageIcon(Menu_principal.class.getResource("/imagenes/usuarios.png")));
		lbl_usuarios.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_usuarios.setBounds(247, 236, 109, 85);
		
		lbl_usuarios.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Usuarios us = new Usuarios();
				us.setVisible(true);
				us.setFocusable(true);
				us.setLocationRelativeTo(null);
				dispose();
			}
		});
		panel.add(lbl_usuarios);
		
		JLabel lbl_codigo_de_barras = new JLabel("");
		lbl_codigo_de_barras.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lbl_codigo_de_barras.setIcon(new ImageIcon(Menu_principal.class.getResource("/imagenes/codigo_de_barras.png")));
		lbl_codigo_de_barras.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_codigo_de_barras.setBounds(451, 236, 109, 85);
		
		lbl_codigo_de_barras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Bar_Code bc = new Bar_Code();
				bc.setVisible(true);
				bc.setFocusable(true);
				bc.setLocationRelativeTo(null);
				dispose();
			}
		});
		panel.add(lbl_codigo_de_barras);
		
		JLabel lbl_estadisticas_titulo = new JLabel("ESTADISTICAS");
		lbl_estadisticas_titulo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lbl_estadisticas_titulo.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_estadisticas_titulo.setFont(new Font("Roboto Slab Black", Font.BOLD, 13));
		lbl_estadisticas_titulo.setBounds(42, 318, 109, 20);
		
		lbl_estadisticas_titulo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Estadisticas frame = new Estadisticas();
				frame.setVisible(true);
				frame.setFocusable(true);
				frame.setLocationRelativeTo(null);
				dispose();
			}
		});
		panel.add(lbl_estadisticas_titulo);
		
		JLabel lbl_usuarios_titulo = new JLabel("USUARIOS");
		lbl_usuarios_titulo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lbl_usuarios_titulo.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_usuarios_titulo.setFont(new Font("Roboto Slab Black", Font.BOLD, 13));
		lbl_usuarios_titulo.setBounds(247, 318, 109, 20);
		
		lbl_usuarios_titulo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Usuarios us = new Usuarios();
				us.setVisible(true);
				us.setFocusable(true);
				us.setLocationRelativeTo(null);
				dispose();
			}
		});
		panel.add(lbl_usuarios_titulo);
		
		JLabel lbl_codigo_de_barras_titulo = new JLabel("BAR-CODE");
		lbl_codigo_de_barras_titulo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lbl_codigo_de_barras_titulo.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_codigo_de_barras_titulo.setFont(new Font("Roboto Slab Black", Font.BOLD, 13));
		lbl_codigo_de_barras_titulo.setBounds(451, 318, 109, 20);
		
		lbl_codigo_de_barras_titulo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Bar_Code bc = new Bar_Code();
				bc.setVisible(true);
				bc.setFocusable(true);
				bc.setLocationRelativeTo(null);
				dispose();
			}
		});
		panel.add(lbl_codigo_de_barras_titulo);
		
		JLabel lbl_categorias = new JLabel("");
		lbl_categorias.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lbl_categorias.setIcon(new ImageIcon(Menu_principal.class.getResource("/imagenes/categorias.png")));
		lbl_categorias.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_categorias.setBounds(36, 559, 109, 85);
		
		lbl_categorias.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Categorias Cat = new Categorias();
				Cat.setVisible(true);
				Cat.setFocusable(true);
				Cat.setLocationRelativeTo(null);
				dispose();
			}
		});
		
		panel.add(lbl_categorias);
		
		JLabel lbl_marcas = new JLabel("");
		lbl_marcas.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lbl_marcas.setIcon(new ImageIcon(Menu_principal.class.getResource("/imagenes/marca.png")));
		lbl_marcas.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_marcas.setBounds(240, 559, 109, 85);
		
		lbl_marcas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Marcas ma = new Marcas();
				ma.setVisible(true);
				ma.setFocusable(true);
				ma.setLocationRelativeTo(null);
				dispose();
			}
		});
		panel.add(lbl_marcas);
		
		JLabel lbl_linea_de_produccion = new JLabel("");
		lbl_linea_de_produccion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lbl_linea_de_produccion.setIcon(new ImageIcon(Menu_principal.class.getResource("/imagenes/linea_de_produccion.png")));
		lbl_linea_de_produccion.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_linea_de_produccion.setBounds(451, 393, 109, 85);
		
		lbl_linea_de_produccion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Linea_de_Produccion lp = new Linea_de_Produccion();
				lp.setVisible(true);
				lp.setFocusable(true);
				lp.setLocationRelativeTo(null);
				dispose();
			}
		});
		panel.add(lbl_linea_de_produccion);
		
		JLabel lbl_categorias_titulo = new JLabel("CATEGORIAS");
		lbl_categorias_titulo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lbl_categorias_titulo.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_categorias_titulo.setFont(new Font("Roboto Slab Black", Font.BOLD, 13));
		lbl_categorias_titulo.setBounds(36, 643, 109, 20);
		
		lbl_categorias_titulo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Categorias Cat = new Categorias();
				Cat.setVisible(true);
				//Cat.setFocusable(true);
				Cat.setLocationRelativeTo(null);
				dispose();
			}
		});
		
		panel.add(lbl_categorias_titulo);
		
		JLabel lbl_marcas_titulo = new JLabel("MARCAS");
		lbl_marcas_titulo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lbl_marcas_titulo.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_marcas_titulo.setFont(new Font("Roboto Slab Black", Font.BOLD, 13));
		lbl_marcas_titulo.setBounds(240, 643, 109, 20);
		
		lbl_marcas_titulo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Marcas m = new Marcas();
				m.setVisible(true);
				m.setFocusable(true);
				m.setLocationRelativeTo(null);
				dispose();
			}
		});
		panel.add(lbl_marcas_titulo);
		
		JLabel lbl_linea_de_produccion_titulo = new JLabel("<html><center>LINEA DE PRODUCCION</center></html>");
		lbl_linea_de_produccion_titulo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lbl_linea_de_produccion_titulo.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_linea_de_produccion_titulo.setFont(new Font("Roboto Slab Black", Font.BOLD, 13));
		lbl_linea_de_produccion_titulo.setBounds(451, 466, 109, 42);
		
		lbl_linea_de_produccion_titulo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Linea_de_Produccion lp = new Linea_de_Produccion();
				lp.setVisible(true);
				lp.setFocusable(true);
				lp.setLocationRelativeTo(null);
				dispose();
			}
		});
		panel.add(lbl_linea_de_produccion_titulo);
		
		JLabel lbl_devoluciones_o_perdidas = new JLabel("");
		lbl_devoluciones_o_perdidas.setHorizontalTextPosition(SwingConstants.CENTER);
		lbl_devoluciones_o_perdidas.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lbl_devoluciones_o_perdidas.setIcon(new ImageIcon(Menu_principal.class.getResource("/imagenes/devoluciones_o_perdidas.png")));
		lbl_devoluciones_o_perdidas.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_devoluciones_o_perdidas.setBounds(244, 393, 109, 85);
		
		lbl_devoluciones_o_perdidas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Devoluciones_Perdidas dp = new Devoluciones_Perdidas();
				dp.setVisible(true);
				dp.setFocusable(true);
				dp.setLocationRelativeTo(null);
				dispose();
			}
		});
		panel.add(lbl_devoluciones_o_perdidas);
		
		JLabel lbl_caja = new JLabel("");
		lbl_caja.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lbl_caja.setIcon(new ImageIcon(Menu_principal.class.getResource("/imagenes/caja.png")));
		lbl_caja.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_caja.setBounds(444, 60, 109, 85);
		
		lbl_caja.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Caja frame = new Caja();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
				frame.setFocusable(true);
				dispose();
			}
		});
		panel.add(lbl_caja);
		
		JLabel lbl_devoluciones_o_perdidas_titulo = new JLabel("<html><center>DEVOLUCIONES O PERDIDAS</center></html>");
		lbl_devoluciones_o_perdidas_titulo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lbl_devoluciones_o_perdidas_titulo.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_devoluciones_o_perdidas_titulo.setFont(new Font("Roboto Slab Black", Font.BOLD, 13));
		lbl_devoluciones_o_perdidas_titulo.setBounds(244, 472, 109, 31);
		
		lbl_devoluciones_o_perdidas_titulo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Devoluciones_Perdidas dp = new Devoluciones_Perdidas();
				dp.setVisible(true);
				dp.setFocusable(true);
				dp.setLocationRelativeTo(null);
				dispose();
			}
		});
		panel.add(lbl_devoluciones_o_perdidas_titulo);
		
		JLabel lbl_caja_titulo = new JLabel("CAJA");
		lbl_caja_titulo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lbl_caja_titulo.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_caja_titulo.setFont(new Font("Roboto Slab Black", Font.BOLD, 13));
		lbl_caja_titulo.setBounds(444, 148, 109, 20);
		lbl_caja_titulo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Caja frame = new Caja();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
				frame.setFocusable(true);
				dispose();
			}
		});
		panel.add(lbl_caja_titulo);
		
		JButton btn_cambiar_usuario = new JButton("CAMBIAR USUARIO");
		btn_cambiar_usuario.setFont(new Font("Roboto Slab Black", Font.BOLD, 13));
		btn_cambiar_usuario.setBounds(237, 10, 184, 23);
		
		btn_cambiar_usuario.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				Cambiar_Usuario cu = new Cambiar_Usuario();
				cu.setVisible(true);
				cu.setFocusable(true);
				cu.setLocationRelativeTo(null);
				
			}
		});
		panel.add(btn_cambiar_usuario);
		
		JLabel lbl_clientes = new JLabel("");
		lbl_clientes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lbl_clientes.setHorizontalTextPosition(SwingConstants.CENTER);
		lbl_clientes.setIcon(new ImageIcon(Menu_principal.class.getResource("/imagenes/cliente.png")));
		lbl_clientes.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_clientes.setBounds(39, 393, 109, 85);
		
		lbl_clientes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Clientes C = new Clientes();
				C.setVisible(true);
				C.setFocusable(true);
				C.setLocationRelativeTo(null);
				dispose();
			}
		});
		panel.add(lbl_clientes);
		
		JLabel lbl_clientes_titulo = new JLabel("CLIENTES");
		lbl_clientes_titulo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lbl_clientes_titulo.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_clientes_titulo.setFont(new Font("Roboto Slab Black", Font.BOLD, 13));
		lbl_clientes_titulo.setBounds(39, 477, 109, 20);
		
		lbl_clientes_titulo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Clientes C = new Clientes();
				C.setVisible(true);
				C.setFocusable(true);
				C.setLocationRelativeTo(null);
				dispose();
			}
		});
		panel.add(lbl_clientes_titulo);
		
		JLabel lbl_proveedores = new JLabel("");
		lbl_proveedores.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lbl_proveedores.setIcon(new ImageIcon(Menu_principal.class.getResource("/imagenes/prove.png")));
		lbl_proveedores.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_proveedores.setBounds(450, 559, 109, 85);
		
		lbl_proveedores.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Proveedores pr = new Proveedores();
				pr.setVisible(true);
				pr.setFocusable(true);
				pr.setLocationRelativeTo(null);
			    dispose();
			}
		});
		panel.add(lbl_proveedores);
		
		txt_usuario = new JTextField();
		txt_usuario.setFont(new Font("Dialog", Font.BOLD, 13));
		txt_usuario.setEditable(false);
		txt_usuario.setHorizontalAlignment(SwingConstants.CENTER);
		txt_usuario.setBounds(42, 11, 185, 20);
		panel.add(txt_usuario);
		txt_usuario.setColumns(10);
	}
}
