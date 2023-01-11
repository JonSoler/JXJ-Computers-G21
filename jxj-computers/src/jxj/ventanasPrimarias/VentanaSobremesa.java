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
import jxj.seccionDisp.Sobremesa;

public class VentanaSobremesa {

	private JFrame frame;
	private ListaDispositivo Dispositivos;
	private static DefaultListModel<String> modelo;
	private JList<String> lista;
	private JScrollPane scroll;
	DBManager con = new DBManager();
	JScrollPane scrollPane;

	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaSobremesa venS = new VentanaSobremesa();
					venS.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public VentanaSobremesa() {
		Dispositivos = new ListaDispositivo();
		initialize();
	}

	public VentanaSobremesa(ListaDispositivo Dispositivos, ArrayList<Dispositivo> carrito) {
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
		scrollPane = new JScrollPane();
		scrollPane.setBounds(5, 10, 700, 750);
		
		JPanel pCentro = new JPanel();
		pCentro.setLayout(null);
		frame.getContentPane().add(pCentro, BorderLayout.CENTER);

		ArrayList<Sobremesa> Sobremesa = new ArrayList<Sobremesa>();
		try {
			Sobremesa = DBManager.listarSobremesa();
		} catch (DBException e1) {
			e1.printStackTrace();
		}

		JPanel SobremesaPanel = new JPanel(new FlowLayout());
		cargarRecursivamente(SobremesaPanel, Sobremesa, 0);

		SobremesaPanel.setBounds(50, 100, 500, 700);
		JScrollPane scrollPane = new JScrollPane(SobremesaPanel, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		//frame.getContentPane().add(scrollPane);
		//frame.getContentPane().add(SobremesaPanel);
		pCentro.add(scrollPane);
		pCentro.add(SobremesaPanel);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 99, 22);
		//frame.getContentPane().add(menuBar);
		pCentro.add(menuBar);

		JMenu mnSec = new JMenu("Categorías");
		menuBar.add(mnSec);
		
		JMenuItem mntmMovil = new JMenuItem("Movil");
		mntmMovil.addActionListener(e -> {
			VentanaMovil.main();
			frame.dispose();
		});
		mnSec.add(mntmMovil);
		
		JMenuItem mntmPortatil = new JMenuItem("Portatil");
		mntmPortatil.addActionListener(e -> {
			VentanaPortatil.main();
			frame.dispose();
		});
		mnSec.add(mntmPortatil);

		JMenuItem mntmTablet = new JMenuItem("Tablet");
		mntmTablet.addActionListener(e -> {
			VentanaTablet.main();
			frame.dispose();
		});
		mnSec.add(mntmTablet);
		
		JMenuItem mntmSecInicio = new JMenuItem("Atrás");
		mntmSecInicio.addActionListener(e -> {
			VentanaCategoria.main(null);
			frame.dispose();
		});
		mnSec.add(mntmSecInicio);

		JLabel lblSobremesa = new JLabel("Sobremesa");
		lblSobremesa.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblSobremesa.setBounds(194, 34, 178, 43);
		//frame.getContentPane().add(lblSobremesa);
		pCentro.add(lblSobremesa);
		
		JButton btnCarritoCompra = new JButton("Cesta");
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
		if(modelo!=null)
        	modelo.removeAllElements();
	}

	private void cargarRecursivamente(JPanel SobremesaPanel, ArrayList<Sobremesa> Sobremesa, int i) {
		if (i < Sobremesa.size()) {
			JPanel SobremesasPanel = DispositivoPanel(Sobremesa.get(i), VentanaCategoria.carrito);
			SobremesaPanel.add(SobremesasPanel);
			cargarRecursivamente(SobremesaPanel, Sobremesa, i + 1);
		}
	}

	private JPanel DispositivoPanel(Sobremesa sobremesa, ArrayList<Dispositivo> carrito) {

		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		panel.setBackground(Color.WHITE);
		JLabel lblImagen = new JLabel();
		lblImagen.setBounds(72, 90, 124, 141);
		ImageIcon ico1 = new ImageIcon(sobremesa.getRutaFoto());
		ImageIcon img1 = new ImageIcon(
				ico1.getImage().getScaledInstance(lblImagen.getWidth(), lblImagen.getHeight(), Image.SCALE_SMOOTH));
		lblImagen.setIcon(img1);
		lblImagen.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(lblImagen);

		JLabel lblNombre = new JLabel(sobremesa.getNombre());
		lblNombre.setBackground(Color.WHITE);
		lblNombre.setToolTipText("");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNombre.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(lblNombre);

		JLabel lblPrecio = new JLabel(String.valueOf(sobremesa.getPrecio() + "€"));
		lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPrecio.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(lblPrecio);

		JButton btnAnadirAlCarrito = new JButton("Agregar al carrito");
		btnAnadirAlCarrito.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAnadirAlCarrito.setForeground(Color.WHITE);
		btnAnadirAlCarrito.setBackground(new Color(255, 165, 0));
		btnAnadirAlCarrito.addActionListener(e -> {
			Dispositivos.getDispositivos().put(new Random().nextInt(), sobremesa);
			carrito.add(sobremesa);
			cargarModelo();
		});

		btnAnadirAlCarrito.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(btnAnadirAlCarrito);

		return panel;

	}

}
