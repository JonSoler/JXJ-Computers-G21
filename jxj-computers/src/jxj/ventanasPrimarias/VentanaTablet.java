package jxj.ventanasPrimarias;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
import jxj.seccionDisp.Tablet;

public class VentanaTablet {
	private JFrame frame;
	private ListaDispositivo Dispositivos;
	
	
	public static void main() {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaTablet window = new VentanaTablet();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	public VentanaTablet() {
		Dispositivos = new ListaDispositivo();
		initialize();
	}

	public VentanaTablet(ListaDispositivo Dispositivos) {
		this.Dispositivos = Dispositivos;
		initialize();
	}
	
	private void initialize() {
		
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 10));
		frame.setBounds(100, 100, 600, 650);
		frame.setTitle("JXJComputers");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		ArrayList<Tablet> Tablet = new ArrayList<Tablet>();
		try {
			Tablet = DBManager.listarTablet();
		} catch (DBException e1) {
			e1.printStackTrace();
		}

		JPanel TabletPanel = new JPanel(new FlowLayout());
		cargarRecursivamente(TabletPanel, Tablet, 0);
		
		TabletPanel.setBounds(50, 100, 500, 700);
		JScrollPane scrollPane = new JScrollPane(TabletPanel, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		frame.getContentPane().add(scrollPane);
		frame.getContentPane().add(TabletPanel);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 99, 22);
		frame.getContentPane().add(menuBar);

		JMenu mnSec = new JMenu("Secciones");
		menuBar.add(mnSec);
		
		JMenuItem mntmSobremesa = new JMenuItem("Sobremesa");
		mntmSobremesa.addActionListener(e -> {
				VentanaSobremesa.main();
				frame.dispose();
		});
		mnSec.add(mntmSobremesa);
		
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
		
		JMenuItem mntmSecInicio = new JMenuItem("Volver a inicio");
		mntmSecInicio.addActionListener(e -> {
				VentanaSeccion.main(null);
				frame.dispose();
		});
		mnSec.add(mntmSecInicio);
		
		JLabel lblTablet = new JLabel("Tablet");
		lblTablet.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblTablet.setBounds(194, 34, 178, 43);
		frame.getContentPane().add(lblTablet);
		
		JButton btnCarritoCompra = new JButton("Carrito");
		btnCarritoCompra.setBounds(250, 550, 80, 30);
		btnCarritoCompra.addActionListener(e -> {
				VentanaCarritoCompra.main();
		});
		frame.getContentPane().add(btnCarritoCompra);
	}
	
	private void cargarRecursivamente(JPanel TabletPanel, ArrayList<Tablet> Tablet, int i) {
		if(i<Tablet.size()) {
			JPanel TabletsPanel = TabletPanel(Tablet.get(i), VentanaSeccion.carrito);
			TabletPanel.add(TabletsPanel);
			cargarRecursivamente(TabletPanel, Tablet, i+1);
	}
}


	private JPanel TabletPanel(Tablet tablet, ArrayList<Dispositivo> carrito) {
		
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		panel.setBackground(Color.WHITE);

		JLabel lblImagen = new JLabel();
		lblImagen.setBounds(72, 90, 124, 141);
		ImageIcon ico1 = new ImageIcon(tablet.getRutaFoto());
		ImageIcon img1 = new ImageIcon(
				ico1.getImage().getScaledInstance(lblImagen.getWidth(), lblImagen.getHeight(), Image.SCALE_SMOOTH));
		lblImagen.setIcon(img1);
		lblImagen.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(lblImagen);
		
		JLabel lblNombre = new JLabel(tablet.getNombre());
		lblNombre.setBackground(Color.WHITE);
		lblNombre.setToolTipText("");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNombre.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(lblNombre);

		JLabel lblPrecio = new JLabel(String.valueOf(tablet.getPrecio()+"€"));
		lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPrecio.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(lblPrecio);

		JButton btnAnadirAlCarrito = new JButton("Agregar al carrito");
		btnAnadirAlCarrito.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAnadirAlCarrito.setForeground(Color.WHITE);
		btnAnadirAlCarrito.setBackground(new Color(255, 165, 0));
		btnAnadirAlCarrito.addActionListener(e -> {

			Dispositivos.getDispositivos().put(new Random().nextInt(), tablet);
			carrito.add(tablet);
		});
		
		btnAnadirAlCarrito.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(btnAnadirAlCarrito);

		return panel;
		
	}

}