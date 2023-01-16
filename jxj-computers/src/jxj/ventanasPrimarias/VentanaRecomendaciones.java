package jxj.ventanasPrimarias;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import jxj.clasesBasicas.ListaDispositivo;
import jxj.dataBase.DBException;
import jxj.dataBase.DBManager;
import jxj.recursividad.RecursividadRecomendaciones;
import jxj.seccionDisp.Dispositivo;
import jxj.seccionDisp.Movil;

public class VentanaRecomendaciones extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private JPanel panelRecomendaciones;
	private static DefaultListModel<List<Movil>> modelo;
	private JList<List<Movil>> lista;
	private JScrollPane scroll;

	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaRecomendaciones window = new VentanaRecomendaciones();
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
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 400, 500);
		frame.setLocationRelativeTo(null);
		frame.setTitle("JXJ Computers");
		frame.getContentPane().setLayout(new BorderLayout());
		
		modelo = new DefaultListModel<>();
		cargarModelo();
		lista = new JList<>(modelo);
		scroll = new JScrollPane(lista);
		scroll.setBounds(10, 10, 80, 30);
		scroll.setPreferredSize(new Dimension (500, 90));
		frame.getContentPane().add(scroll, BorderLayout.CENTER);
		JButton btnSeguirComprando = new JButton("Seguir comprando");
		btnSeguirComprando.setBounds(90, 407, 212, 29);
		frame.getContentPane().add(btnSeguirComprando, BorderLayout.SOUTH);
		btnSeguirComprando.addActionListener(e -> {
			frame.dispose();

		});

		JLabel lblRecomendaciones = new JLabel("Combinaciones recomendadas");
		lblRecomendaciones.setFont(new Font("Cooper Black", Font.BOLD, 22));
		lblRecomendaciones.setForeground(new Color(102, 102, 153));
		lblRecomendaciones.setBounds(10, 28, 364, 43);
		frame.getContentPane().add(lblRecomendaciones, BorderLayout.NORTH);
	}
	
	private void cargarModelo() {
		try {
			ArrayList<Movil> ad = DBManager.listarMovil();
			/**
			 * Añadimos la cantidad de dinero que queremos gastar, de esta manera,
			 * se nos generan todas las combinaciones de compra posibles con esa cantidad
			 */
			RecursividadRecomendaciones rr = new RecursividadRecomendaciones(700, ad);
			for(List<Movil> l: rr.getAl()) {
				modelo.addElement(l);
			}
		} catch (DBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
