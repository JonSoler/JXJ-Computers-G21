package jxj.ventanasPrimarias;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import jxj.clasesBasicas.ListaDispositivo;
import jxj.seccionDisp.Dispositivo;

public class VentanaRecomendaciones extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private JPanel panelRecomendaciones;
	private static DefaultListModel<String> modelo;
	private JList<String> lista;
	private JScrollPane scroll;

	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaRecomendaciones window = new VentanaRecomendaciones(null);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame
	 */

	public VentanaRecomendaciones() {
		initialize();
	}

	public VentanaRecomendaciones(ListaDispositivo Dispositivos) {
		initTablePanel(VentanaCategoria.carrito);
		initialize();
	}

	private void initTablePanel(ArrayList<Dispositivo> carrito) {
		panelRecomendaciones = new JPanel(new GridLayout());
		panelRecomendaciones.setBounds(10, 81, 360, 241);

		JScrollPane js = new JScrollPane(scroll);
		panelRecomendaciones.add(js);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 400, 500);
		frame.setLocationRelativeTo(null);
		frame.setTitle("JXJ Computers");
		frame.getContentPane().setLayout(null);
		
		//lista = new JList<>(modelo);
		scroll = new JScrollPane(lista);
		scroll.setBounds(10, 10, 80, 30);
		scroll.setPreferredSize(new Dimension (500, 90));

		JButton btnSeguirComprando = new JButton("Seguir comprando");
		btnSeguirComprando.setBounds(90, 407, 212, 29);
		frame.getContentPane().add(btnSeguirComprando);
		btnSeguirComprando.addActionListener(e -> {
			frame.dispose();

		});

		frame.getContentPane().add(panelRecomendaciones);

		JLabel lblRecomendaciones = new JLabel("Combinaciones recomendadas");
		lblRecomendaciones.setFont(new Font("Cooper Black", Font.BOLD, 22));
		lblRecomendaciones.setForeground(new Color(102, 102, 153));
		lblRecomendaciones.setBounds(10, 28, 364, 43);
		frame.getContentPane().add(lblRecomendaciones);
	}
	
}
