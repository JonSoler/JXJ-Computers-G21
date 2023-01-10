package jxj.ventanasPrimarias;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import jxj.clasesBasicas.ListaDispositivo;
import jxj.dataBase.DBException;
import jxj.dataBase.DBManager;
import jxj.seccionDisp.Dispositivo;
import jxj.seccionDisp.Movil;

public class VentanaMovil {

	private JFrame frame;
	private ListaDispositivo Dispositivos;
	
	private static DefaultListModel<String> modelo;
	private JList<String> lista;
	private JScrollPane scroll;

	public static void main() {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaMovil window = new VentanaMovil();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public VentanaMovil() {
		Dispositivos = new ListaDispositivo();
		initialize();
		
	}

	public VentanaMovil(ListaDispositivo Dispositivos) {
		this.Dispositivos = Dispositivos;
		initialize();
	}

	private void initialize() {

		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 10));
		frame.setBounds(100, 100, 600, 700);
		frame.setLocationRelativeTo(null);
		frame.setTitle("JXJComputers");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout());

		JPanel pCentro = new JPanel();
		pCentro.setLayout(null);
		frame.getContentPane().add(pCentro, BorderLayout.CENTER);
		ArrayList<Movil> Movil = new ArrayList<Movil>();
		try {
			Movil = DBManager.listarMovil();
		} catch (DBException e1) {
			e1.printStackTrace();
		}

		JPanel MovilPanel = new JPanel(new FlowLayout());
		cargarRecursivamente(MovilPanel, Movil, 0);

		MovilPanel.setBounds(50, 100, 500, 700);
		JScrollPane scrollPane = new JScrollPane(MovilPanel, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		//frame.getContentPane().add(scrollPane);
		//frame.getContentPane().add(MovilPanel);
		pCentro.add(scrollPane);
		pCentro.add(MovilPanel);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 99, 22);
		//frame.getContentPane().add(menuBar);
		pCentro.add(menuBar);
		
		JMenu mnSec = new JMenu("Categorías");
		menuBar.add(mnSec);
		
		JMenuItem mntmSecInicio = new JMenuItem("Volver a inicio");
		mntmSecInicio.addActionListener(e -> {
			VentanaCategoria.main(null);
			frame.dispose();
		});
		mnSec.add(mntmSecInicio);
				
		JMenuItem mntmPortatil = new JMenuItem("Portatil");
		mntmPortatil.addActionListener(e -> {
			VentanaPortatil.main();
			frame.dispose();
		});
		mnSec.add(mntmPortatil);

		JMenuItem mntmSobremesa = new JMenuItem("Sobremesa");
		mntmSobremesa.addActionListener(e -> {
			VentanaSobremesa.main();
			frame.dispose();
		});
		mnSec.add(mntmSobremesa);

		JMenuItem mntmTablet = new JMenuItem("Tablet");
		mntmTablet.addActionListener(e -> {
			VentanaTablet.main();
			frame.dispose();
		});
		mnSec.add(mntmTablet);

		JLabel lblMovil = new JLabel("Movil");
		lblMovil.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblMovil.setBounds(194, 34, 178, 43);
		//frame.getContentPane().add(lblMovil);
		pCentro.add(lblMovil);
		
		JButton btnCarritoCompra = new JButton("Carrito");
		btnCarritoCompra.setBounds(250, 550, 80, 30);
		btnCarritoCompra.addActionListener(e -> {
			VentanaCarritoCompra.main();
		});
		
		JPanel pBotonera = new JPanel();
		modelo = new DefaultListModel<>();
		cargarModelo();
		lista = new JList<>(modelo);
		//lista.setPreferredSize(new Dimension(20, 10));
		scroll = new JScrollPane(lista);
		scroll.setBounds(10, 10, 80, 30);
		scroll.setPreferredSize(new Dimension (500, 90));
		pBotonera.add(btnCarritoCompra);
		frame.getContentPane().add(pBotonera, BorderLayout.NORTH);
		frame.getContentPane().add(scroll, BorderLayout.SOUTH);
		/*JScrollBar bar = scroll.getVerticalScrollBar();
		bar.setPreferredSize(new Dimension(10, 0));*/
		

	}
	private void cargarModelo() {
		modelo.removeAllElements();
		for (Dispositivo Dispositivo : VentanaCategoria.carrito) {
			modelo.addElement("Has añadido " + Dispositivo.getNombre() + " por " + Dispositivo.getPrecio() + "€ a la cesta");
		}
	}
	
	public static void vaciarLista() {
		modelo.removeAllElements();
	}
	
	private void cargarRecursivamente(JPanel MovilPanel, ArrayList<Movil> Movil, int i) {
		if (i < Movil.size()) {
			JPanel MovilsPanel = DispositivoPanel(Movil.get(i), VentanaCategoria.carrito);
			MovilPanel.add(MovilsPanel);
			cargarRecursivamente(MovilPanel, Movil, i + 1);
		}
	}

	private JPanel DispositivoPanel(Movil movil, ArrayList<Dispositivo> carrito) {
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		panel.setBackground(Color.WHITE);

		JLabel lblImagen = new JLabel();
		lblImagen.setBounds(72, 90, 124, 141);
		ImageIcon ico1 = new ImageIcon(movil.getRutaFoto());
		ImageIcon img1 = new ImageIcon(
				ico1.getImage().getScaledInstance(lblImagen.getWidth(), lblImagen.getHeight(), Image.SCALE_SMOOTH));
		lblImagen.setIcon(img1);
		lblImagen.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(lblImagen);

		JLabel lblNombre = new JLabel(movil.getNombre());
		lblNombre.setBackground(Color.WHITE);
		lblNombre.setToolTipText("");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNombre.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(lblNombre);

		JLabel lblPrecio = new JLabel(String.valueOf(movil.getPrecio() + "€"));
		lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPrecio.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(lblPrecio);

		JButton btnAnadirAlCarrito = new JButton("Agregar al carrito");
		btnAnadirAlCarrito.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAnadirAlCarrito.setForeground(Color.WHITE);
		btnAnadirAlCarrito.setBackground(new Color(255, 165, 0));
		btnAnadirAlCarrito.addActionListener(e -> {

			Dispositivos.getDispositivos().put(new Random().nextInt(), movil);
			carrito.add(movil);
			cargarModelo();
		});

		btnAnadirAlCarrito.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(btnAnadirAlCarrito);

		return panel;
	}

}
