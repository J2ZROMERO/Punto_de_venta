package interfaces;


import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import com.itextpdf.text.pdf.PdfDocument;


import java.awt.print.*;

public class Vista_Impresora extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vista_Impresora frame = new Vista_Impresora();
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
	
	public Vista_Impresora() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 756, 559);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 740, 520);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(35, 53, 684, 418);
		panel.add(scrollPane);
		
		JButton btn_quitar = new JButton("OK");
		btn_quitar.setFont(new Font("Dialog", Font.BOLD, 12));
		btn_quitar.setBounds(263, 486, 89, 23);
		
		btn_quitar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		panel.add(btn_quitar);
		
		JLabel lbl_titulo = new JLabel("TICKET");
		lbl_titulo.setFont(new Font("Dialog", Font.BOLD, 18));
		lbl_titulo.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_titulo.setBounds(137, 11, 481, 31);
		panel.add(lbl_titulo);
		
		JButton btn_imprimir = new JButton("IMPRIMIR");
		btn_imprimir.setFont(new Font("Dialog", Font.BOLD, 12));
		btn_imprimir.setBounds(392, 487, 89, 23);
		
		btn_imprimir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		panel.add(btn_imprimir);
	}
}
