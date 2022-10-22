package jxj.ventanasPrimarias;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import jxj.dataBase.DBException;

public class VentanaLogin extends JFrame {
	public static int idUsuario;
	private static final long serialVersionUID = 1L;

	private JPanel panelCentral, panelTitulo;
	private JLabel lblUsuario, lblContrasenya;
	public static String nick;
	private JLabel lblTitulo;
	private JTextField txtNombre;
	private JPasswordField txtContrasenya;

	/**
	 * Create the frame
	 */
	@SuppressWarnings("static-access")
	public VentanaLogin() {
		super();

		setBounds(100, 100, 570, 420);
		setTitle("Inicio de sesion");
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		panelTitulo = new JPanel();
		panelTitulo.setBounds(60, 11, 437, 62);

		panelCentral = new JPanel();
		panelCentral.setBounds(0, 70, 557, 207);

		getContentPane().add(panelCentral, BorderLayout.CENTER);
		getContentPane().setLayout(null);
		getContentPane().add(panelTitulo);

		lblTitulo = new JLabel("INICIO DE SESI\u00D3N");
		lblTitulo.setVerticalAlignment(SwingConstants.BOTTOM);
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setForeground(new Color(102, 102, 153));
		lblTitulo.setFont(new Font("Cooper Black", Font.BOLD, 40));
		panelTitulo.add(lblTitulo);

		panelCentral.setLayout(null);

		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(291, 44, 163, 30);
		panelCentral.add(txtNombre);

		lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Segoe UI Variable", Font.BOLD, 20));
		lblUsuario.setBounds(169, 46, 86, 25);
		panelCentral.add(lblUsuario);

		txtContrasenya = new JPasswordField();
		txtContrasenya.setBounds(291, 127, 163, 30);
		panelCentral.add(txtContrasenya);

		lblContrasenya = new JLabel("Contrase\u00F1a");
		lblContrasenya.setFont(new Font("Segoe UI Variable", Font.BOLD, 20));
		lblContrasenya.setEnabled(true);
		lblContrasenya.setBounds(169, 130, 112, 25);
		panelCentral.add(lblContrasenya);

		JLabel lblIconoUsuario = new JLabel("");
		lblIconoUsuario.setIcon(new ImageIcon("imagenes/Usuario.png"));
		lblIconoUsuario.setBounds(93, 28, 60, 60);
		panelCentral.add(lblIconoUsuario);

		JLabel lblIconoContrasena = new JLabel("");
		lblIconoContrasena.setIcon(new ImageIcon("imagenes/Contrasenya.png"));
		lblIconoContrasena.setBounds(95, 111, 60, 60);
		panelCentral.add(lblIconoContrasena);

		JCheckBox cbMostrarContrasena = new JCheckBox("Mostrar contrase\u00F1a");
		cbMostrarContrasena.setFont(new Font("Segoe UI Variable", Font.PLAIN, 10));
		cbMostrarContrasena.setBounds(293, 171, 163, 23);
		panelCentral.add(cbMostrarContrasena);

		cbMostrarContrasena.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					txtContrasenya.setEchoChar((char) 0);
					// checkbox has been selected
					// do something...
				} else {// checkbox has been deselected
					txtContrasenya.setEchoChar('*');
				}
				;
			}

		});

		// Boton Iniciar Sesion
		JButton btnIniciarSesion = new JButton("");
		btnIniciarSesion.setBackground(SystemColor.control);
		btnIniciarSesion.setIcon(new ImageIcon("imagenes/Iniciar.png"));
		btnIniciarSesion.setFocusPainted(false);
		btnIniciarSesion.setBorderPainted(false);
		btnIniciarSesion.setContentAreaFilled(false);
		btnIniciarSesion.addActionListener(e -> {

			//Metodo iniciar sesion

		});

		btnIniciarSesion.setBounds(496, 321, 30, 30);
		getContentPane().add(btnIniciarSesion);

		// Boton Admin
		JButton btnAdmin = new JButton("");
		btnAdmin.setBackground(SystemColor.control);
		btnAdmin.setIcon(new ImageIcon("imagenes/Admin.png"));
		btnAdmin.setFocusPainted(false);
		btnAdmin.setBorderPainted(false);
		btnAdmin.setContentAreaFilled(false);
		btnAdmin.addActionListener(e -> {

			//Abrir ventana admin

		});

		btnAdmin.setBounds(252, 297, 50, 50);
		getContentPane().add(btnAdmin);

		// Boton Atras
		JButton btnAtras = new JButton("");
		btnAtras.setBackground(SystemColor.control);
		btnAtras.setIcon(new ImageIcon("imagenes/Atras.png"));
		btnAtras.setFocusPainted(false);
		btnAtras.setBorderPainted(false);
		btnAtras.setContentAreaFilled(false);
		btnAtras.addActionListener(e -> {

			VentanaInicio vi = null;
			try {
				vi = new VentanaInicio();
			} catch (DBException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			vi.setVisible(true);
			dispose();

		});

		btnAtras.setBounds(28, 321, 30, 30);
		getContentPane().add(btnAtras);

		JLabel lblIniciarSesion = new JLabel("Iniciar sesi\u00F3n");
		lblIniciarSesion.setForeground(new Color(51, 51, 204));
		lblIniciarSesion.setFont(new Font("Segoe UI Variable", Font.BOLD, 14));
		lblIniciarSesion.setEnabled(true);
		lblIniciarSesion.setBounds(405, 323, 92, 25);
		getContentPane().add(lblIniciarSesion);

		JLabel lblAtras = new JLabel("Atras");
		lblAtras.setForeground(new Color(204, 102, 0));
		lblAtras.setFont(new Font("Segoe UI Variable", Font.BOLD, 14));
		lblAtras.setEnabled(true);
		lblAtras.setBounds(65, 323, 92, 25);
		getContentPane().add(lblAtras);

		JLabel lblAdmin = new JLabel("Admin");
		lblAdmin.setForeground(new Color(51, 102, 51));
		lblAdmin.setFont(new Font("Segoe UI Variable", Font.BOLD, 14));
		lblAdmin.setEnabled(true);
		lblAdmin.setBounds(250, 345, 50, 25);
		getContentPane().add(lblAdmin);

	}

	/**
	 * Este metodo se encarga de vaciar los campos
	 */
	public void vaciarCampos() {
		txtNombre.setText("");
		txtContrasenya.setText("");
	}

	/**
	 * Este metodo sirve para alinear campos
	 * 
	 * @param cont
	 * @param etiqueta
	 * @param campo
	 */

	void posicionaLinea(Container cont, String etiqueta, Component campo) {
		JPanel tempPanel = new JPanel();
		tempPanel.setOpaque(false);
		tempPanel.setLayout(new FlowLayout(FlowLayout.LEFT)); // se hace un flow ajustado a la izquierda
		JLabel l = new JLabel(etiqueta);
		l.setPreferredSize(new Dimension(250, 50));
		l.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18));
		l.setForeground(Color.BLACK);
		tempPanel.add(l);
		tempPanel.add(campo);
		cont.add(tempPanel);
	}

	// METODO GET ID USUARIO
	public static int getUsuarioId() {
		return idUsuario;
	}
}
