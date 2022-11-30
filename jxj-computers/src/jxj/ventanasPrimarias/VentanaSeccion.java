package jxj.ventanasPrimarias;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import jxj.clasesBasicas.ListaDispositivo;
import jxj.dataBase.DBException;
import jxj.seccionDisp.Dispositivo;
import jxj.ventanasSecundarias.VentanaAjustes;
import jxj.ventanasSecundarias.VentanaCuentaUsuario;

public class VentanaSeccion extends JFrame {
	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;
	JPanel pCentral, pSur;

	public static ArrayList<Dispositivo> carrito = new ArrayList<Dispositivo>();
	ListaDispositivo listaDispositivo = new ListaDispositivo();

	/**
	 * Launch the application
	 */

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaSeccion window = new VentanaSeccion();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	VentanaLogin vl = new VentanaLogin();

	/**
	 * Create the application.
	 */
	public VentanaSeccion() {
		initialize();
		setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		setBounds(100, 100, 500, 480);
		setTitle("JXJ Computers");
		getContentPane().setLayout(null);

		JLabel lblSeccionesDispositivos = new JLabel("Categorias de los Dispositivos");
		lblSeccionesDispositivos.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 24));
		lblSeccionesDispositivos.setBounds(106, 11, 295, 26);
		getContentPane().add(lblSeccionesDispositivos);

		JLabel lblMovil = new JLabel("Movil");
		lblMovil.setBounds(83, 62, 126, 77);
		getContentPane().add(lblMovil);
		ImageIcon ico3 = new ImageIcon("imagenes/Movil.jpg");
		ImageIcon img3 = new ImageIcon(
				ico3.getImage().getScaledInstance(lblMovil.getWidth(), lblMovil.getHeight(), Image.SCALE_SMOOTH));
		lblMovil.setIcon(img3);

		JButton btnMovil = new JButton("Movil");
		btnMovil.setForeground(Color.WHITE);
		btnMovil.setBackground(new Color(255, 165, 0));
		btnMovil.setBounds(83, 150, 126, 48);
		getContentPane().add(btnMovil);

		btnMovil.addActionListener(e -> {
			VentanaMovil.main();
			dispose();
		});

		JLabel lblPortatil = new JLabel("Portatil");
		lblPortatil.setBounds(275, 62, 126, 77);
		getContentPane().add(lblPortatil);

		ImageIcon ico2 = new ImageIcon("imagenes/Portatil.jpg");
		ImageIcon img2 = new ImageIcon(
				ico2.getImage().getScaledInstance(lblPortatil.getWidth(), lblPortatil.getHeight(), Image.SCALE_SMOOTH));
		lblPortatil.setIcon(img2);

		JButton btnPortatil = new JButton("Portatil");
		btnPortatil.setForeground(Color.WHITE);
		btnPortatil.setBackground(new Color(255, 165, 0));
		btnPortatil.setBounds(275, 150, 126, 48);
		getContentPane().add(btnPortatil);

		btnPortatil.addActionListener(e -> {
			VentanaPortatil.main();
			dispose();
		});

		JLabel lblSobremesa = new JLabel("Sobremesa");
		lblSobremesa.setBackground(Color.WHITE);
		lblSobremesa.setBounds(83, 239, 126, 77);
		getContentPane().add(lblSobremesa);

		ImageIcon ico4 = new ImageIcon("imagenes/Sobremesa.jpg");
		ImageIcon img4 = new ImageIcon(ico4.getImage().getScaledInstance(lblSobremesa.getWidth(),
				lblSobremesa.getHeight(), Image.SCALE_SMOOTH));
		lblSobremesa.setIcon(img4);

		JButton btnSobremesa = new JButton("Sobremesa");
		btnSobremesa.setForeground(Color.WHITE);
		btnSobremesa.setBackground(new Color(255, 165, 0));
		btnSobremesa.setBounds(83, 339, 126, 48);
		getContentPane().add(btnSobremesa);

		btnSobremesa.addActionListener(e -> {
			VentanaSobremesa.main();
			dispose();
		});

		JLabel lblTablet = new JLabel("Tablet");
		lblTablet.setBackground(Color.WHITE);
		lblTablet.setBounds(275, 239, 126, 77);
		getContentPane().add(lblTablet);

		ImageIcon ico5 = new ImageIcon("imagenes/Tablet.jpg");
		ImageIcon img5 = new ImageIcon(
				ico5.getImage().getScaledInstance(lblTablet.getWidth(), lblTablet.getHeight(), Image.SCALE_SMOOTH));
		lblTablet.setIcon(img5);

		JButton btnTablet = new JButton("Tablet");
		btnTablet.setForeground(Color.WHITE);
		btnTablet.setBackground(new Color(255, 165, 0));
		btnTablet.setBounds(275, 339, 126, 48);
		getContentPane().add(btnTablet);

		btnTablet.addActionListener(e -> {
			VentanaTablet.main();
			dispose();
		});

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenuItem mntmCerrarSesion = new JMenuItem("Cerrar sesion");
		mntmCerrarSesion.setFont(new Font("Segoe UI", Font.BOLD, 12));
		mntmCerrarSesion.setForeground(new Color(255, 153, 0));
		mntmCerrarSesion.addActionListener(e -> {

			VentanaInicio v3 = null;
			try {
				v3 = new VentanaInicio();
			} catch (DBException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			v3.setVisible(true);
			dispose();
		});
		menuBar.add(mntmCerrarSesion);

		JButton btnPerfil = new JButton("");
		btnPerfil.setIcon(new ImageIcon("imagenes/iconoPerfil.png"));
		btnPerfil.setFocusPainted(false);
		btnPerfil.setContentAreaFilled(false);
		menuBar.add(btnPerfil);

		btnPerfil.addActionListener(e -> {

			VentanaCuentaUsuario vU = new VentanaCuentaUsuario(VentanaLogin.u);
			vU.setVisible(true);
			dispose();
		});

		JButton btnAjustes = new JButton("");
		btnAjustes.setIcon(new ImageIcon("imagenes/iconoAjustes.png"));
		btnAjustes.setFocusPainted(false);
		btnAjustes.setContentAreaFilled(false);
		menuBar.add(btnAjustes);

		btnAjustes.addActionListener(e -> {

			VentanaAjustes v1 = new VentanaAjustes();
			v1.setVisible(true);
			dispose();
		});
	}

}
