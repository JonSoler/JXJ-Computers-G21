package jxj.ventanasAdministrador;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

public class VentanaInicioAdmin extends JFrame {
	public static int idUsuario;
	private static final long serialVersionUID = 1L;

	private JPanel panelCentral, panelTitulo;
	private JLabel lblUsuario, lblContrasenya;
	private JLabel lblTitulo;
	private JTextField textoUsuario;
	private JPasswordField textoContrasenya;

	/**
	 * Create the frame
	 */
	@SuppressWarnings("static-access")
	public VentanaInicioAdmin() {
		super();

		setBounds(100, 100, 550, 390);
		setTitle("Administrador - Inicio de sesi\u00F3n");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		panelTitulo = new JPanel();
		panelTitulo.setBounds(0, 11, 533, 62);

		panelCentral = new JPanel();
		panelCentral.setBounds(0, 70, 557, 207);

		getContentPane().add(panelCentral, BorderLayout.CENTER);
		getContentPane().setLayout(null);
		getContentPane().add(panelTitulo);

		lblTitulo = new JLabel("ADMINISTRADOR");
		lblTitulo.setVerticalAlignment(SwingConstants.BOTTOM);
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setForeground(new Color(102, 102, 153));
		lblTitulo.setFont(new Font("Cooper Black", Font.BOLD, 40));
		panelTitulo.add(lblTitulo);

		panelCentral.setLayout(null);

		textoUsuario = new JTextField();
		textoUsuario.setColumns(10);
		textoUsuario.setBounds(277, 44, 163, 30);
		panelCentral.add(textoUsuario);

		lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Segoe UI Variable", Font.BOLD, 20));
		lblUsuario.setBounds(155, 46, 86, 25);
		panelCentral.add(lblUsuario);

		textoContrasenya = new JPasswordField();
		textoContrasenya.setBounds(277, 127, 163, 30);
		panelCentral.add(textoContrasenya);

		lblContrasenya = new JLabel("Contrase\u00F1a");
		lblContrasenya.setFont(new Font("Segoe UI Variable", Font.BOLD, 20));
		lblContrasenya.setEnabled(true);
		lblContrasenya.setBounds(155, 130, 118, 25);
		panelCentral.add(lblContrasenya);

		JLabel lblIconoUsuario = new JLabel("");
		lblIconoUsuario.setIcon(new ImageIcon("imagenes/Admin2.png"));
		lblIconoUsuario.setBounds(79, 28, 60, 60);
		panelCentral.add(lblIconoUsuario);

		JLabel lblIconoContrasenya = new JLabel("");
		lblIconoContrasenya.setIcon(new ImageIcon("imagenes/Contrasenya.png"));
		lblIconoContrasenya.setBounds(81, 111, 60, 60);
		panelCentral.add(lblIconoContrasenya);

		JCheckBox cbMostrarContrasenya = new JCheckBox("Mostrar contrase\u00F1a");
		cbMostrarContrasenya.setFont(new Font("Segoe UI Variable", Font.PLAIN, 10));
		cbMostrarContrasenya.setBounds(279, 171, 163, 23);
		panelCentral.add(cbMostrarContrasenya);

		cbMostrarContrasenya.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					textoContrasenya.setEchoChar((char) 0);
					// checkbox has been selected
					// do something...
				} else {// checkbox has been deselected
					textoContrasenya.setEchoChar('*');
				}
				;
			}

		});

		// Boton Iniciar Sesion
		JButton btnIniciarSesion = new JButton("");
		btnIniciarSesion.setBackground(SystemColor.control);
		btnIniciarSesion.setIcon(new ImageIcon("imagenes/IniciarAdmin.png"));
		btnIniciarSesion.setFocusPainted(false);
		btnIniciarSesion.setBorderPainted(false);
		btnIniciarSesion.setContentAreaFilled(false);
		btnIniciarSesion.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String usuario = textoUsuario.getText();
				String contrasenya = textoContrasenya.getText();
				
				if(usuario.equals("admin")&& contrasenya.equals("admin123")) {

					JOptionPane.showMessageDialog(null, "Bienvenido al modo administrador", "Aceptado", JOptionPane.INFORMATION_MESSAGE);
					VentanaAdmin vl = new VentanaAdmin();
					vl.setVisible(true);
					dispose();
					
				}else{
					JOptionPane.showMessageDialog(null, "No has introducido los datos correctamente", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});

		btnIniciarSesion.setBounds(477, 298, 36, 33);
		getContentPane().add(btnIniciarSesion);

		// Boton Atras
		JButton btnAtras = new JButton("");
		btnAtras.setBackground(SystemColor.control);
		btnAtras.setIcon(new ImageIcon("imagenes/Atras.png"));
		btnAtras.setFocusPainted(false);
		btnAtras.setBorderPainted(false);
		btnAtras.setContentAreaFilled(false);
		btnAtras.addActionListener(e -> {

			jxj.ventanasPrimarias.VentanaLogin vi = null;
			vi = new jxj.ventanasPrimarias.VentanaLogin();
			vi.setVisible(true);
			dispose();

		});

		btnAtras.setBounds(25, 298, 30, 30);
		getContentPane().add(btnAtras);

		JLabel lblIniciarSesion = new JLabel("Iniciar sesi\u00F3n");
		lblIniciarSesion.setForeground(new Color(51, 51, 204));
		lblIniciarSesion.setFont(new Font("Segoe UI Variable", Font.BOLD, 14));
		lblIniciarSesion.setEnabled(true);
		lblIniciarSesion.setBounds(386, 300, 101, 25);
		getContentPane().add(lblIniciarSesion);

		JLabel lblAtras = new JLabel("Atr\u00e1s");
		lblAtras.setForeground(new Color(204, 102, 0));
		lblAtras.setFont(new Font("Segoe UI Variable", Font.BOLD, 14));
		lblAtras.setEnabled(true);
		lblAtras.setBounds(62, 300, 92, 25);
		getContentPane().add(lblAtras);

	}

	/**
	 * Este metodo se encarga de vaciar los campos
	 */
	public void vaciarCampos() {
		textoUsuario.setText("");
		textoContrasenya.setText("");
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
		tempPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
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