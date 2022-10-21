package jxj.ventanasPrimarias;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import jxj.dataBase.DBException;

public class VentanaLogin extends JFrame {
	public static int idUsuario;
	private static final long serialVersionUID = 1L;

	private JPanel panelCentral, panelTitulo, panelBotones;
	private JLabel lblUsuario, lblContrasenya;
	private JButton btnIniciarSesion, btnVolver, btnAdmin;
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

		setBounds(100, 100, 571, 384);
		setTitle("Inicio de sesion");
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		panelTitulo = new JPanel();
		panelTitulo.setBounds(0, 11, 557, 62);

		panelCentral = new JPanel();
		panelCentral.setBounds(0, 70, 557, 232);

		panelBotones = new JPanel();
		panelBotones.setBounds(0, 303, 557, 33);

		getContentPane().add(panelCentral, BorderLayout.CENTER);
		getContentPane().setLayout(null);
		getContentPane().add(panelTitulo);

		lblTitulo = new JLabel("INICIO DE SESI\u00D3N");
		lblTitulo.setVerticalAlignment(SwingConstants.BOTTOM);
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setForeground(new Color(102, 102, 153));
		lblTitulo.setFont(new Font("Cooper Black", Font.BOLD, 40));
		panelTitulo.add(lblTitulo);
		getContentPane().add(panelBotones);

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

		JLabel lblIconoContraseña = new JLabel("");
		lblIconoContraseña.setIcon(new ImageIcon("imagenes/Contrasenya.png"));
		lblIconoContraseña.setBounds(95, 111, 60, 60);
		panelCentral.add(lblIconoContraseña);

		JCheckBox cbMostrarContraseña = new JCheckBox("Mostrar contrase\u00F1a");
		cbMostrarContraseña.setFont(new Font("Segoe UI Variable", Font.PLAIN, 10));
		cbMostrarContraseña.setBounds(293, 171, 163, 23);
		panelCentral.add(cbMostrarContraseña);

		cbMostrarContraseña.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					txtContrasenya.setEchoChar((char) 0);
					// checkbox has been selected
					// do something...
				} else {// checkbox has been deselected
					txtContrasenya.setEchoChar('*');
				};
			}

		});

		btnIniciarSesion = new JButton();
		btnIniciarSesion.setToolTipText("Pulsa para iniciar sesion");
		btnIniciarSesion.setText("Iniciar sesi\u00F3n");
		panelBotones.add(btnIniciarSesion);

		btnIniciarSesion.addActionListener(e -> {
			// TODO Auto-generated method stub
			
		});
		
		btnAdmin = new JButton("Admin");
		btnAdmin.setToolTipText("Modo administrador");
		panelBotones.add(btnAdmin);

		btnAdmin.addActionListener(e -> {
			// TODO Auto-generated method stub
			
		});
		
		btnVolver = new JButton();
		btnVolver.setToolTipText("Pulsa para volver a la ventana inicial");
		btnVolver.setText("Volver");
		panelBotones.add(btnVolver);

		btnVolver.addActionListener(e -> {
			// TODO Auto-generated method stub
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
