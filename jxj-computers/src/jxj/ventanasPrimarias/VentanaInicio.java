package jxj.ventanasPrimarias;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import jxj.dataBase.DBException;

public class VentanaInicio extends JFrame {

	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaInicio frame = new VentanaInicio();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	public VentanaInicio() throws DBException {

		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(null);
		setBounds(100, 100, 610, 630);
		setLocationRelativeTo(null);
		
		// Boton Registro
		JButton btnRegistro = new JButton("");
		btnRegistro.setIcon(new ImageIcon("imagenes/AgregarUsuarios.png"));
		btnRegistro.setFocusPainted(false);
		btnRegistro.setBorderPainted(false);
		btnRegistro.setContentAreaFilled(false);
		btnRegistro.addActionListener(e -> {

			VentanaRegistro vr = null;
			vr = new VentanaRegistro();
			vr.setVisible(true);
			dispose();
		});

		btnRegistro.setBounds(137, 445, 92, 80);
		getContentPane().add(btnRegistro);

		// Boton Login
		JButton btnLogin = new JButton("");
		btnLogin.setBackground(SystemColor.control);
		btnLogin.setIcon(new ImageIcon("imagenes/IniciarSesion.png"));
		btnLogin.setFocusPainted(false);
		btnLogin.setBorderPainted(false);
		btnLogin.setContentAreaFilled(false);
		btnLogin.addActionListener(e -> {

			JOptionPane.showMessageDialog(null, "Introduzca sus credenciales a continuaci\u00F3n", "Iniciar sesi\u00F3n",
					JOptionPane.INFORMATION_MESSAGE);

			VentanaLogin vi = null;
			vi = new VentanaLogin();
			vi.setVisible(true);

			dispose();

		});

		btnLogin.setBounds(347, 445, 92, 80);
		getContentPane().add(btnLogin);

		JLabel lblBienvenido = new JLabel("Bienvenido a nuestra tienda de dispositivos electronicos");
		lblBienvenido.setHorizontalAlignment(SwingConstants.CENTER);
		lblBienvenido.setFont(new Font("Dialog", Font.ITALIC, 14));
		lblBienvenido.setBounds(30, 348, 554, 14);
		getContentPane().add(lblBienvenido);

		JLabel lblLogo1 = new JLabel("");
		lblLogo1.setBounds(77, 39, 456, 298);
		ImageIcon ico = new ImageIcon("imagenes/logoInicio.png");
		ImageIcon img = new ImageIcon(
				ico.getImage().getScaledInstance(lblLogo1.getWidth(), lblLogo1.getHeight(), Image.SCALE_SMOOTH));
		lblLogo1.setIcon(img);
		getContentPane().add(lblLogo1);
		
		JLabel lblIniciarSesion = new JLabel("Iniciar sesi\u00F3n");
		lblIniciarSesion.setForeground(new Color(51, 51, 204));
		lblIniciarSesion.setFont(new Font("Segoe UI Variable", Font.BOLD, 14));
		lblIniciarSesion.setEnabled(true);
		lblIniciarSesion.setBounds(349, 524, 92, 25);
		getContentPane().add(lblIniciarSesion);
		
		JLabel lblNuevoUsuario = new JLabel("Nuevo usuario");
		lblNuevoUsuario.setForeground(new Color(140, 128, 0));
		lblNuevoUsuario.setFont(new Font("Segoe UI Variable", Font.BOLD, 14));
		lblNuevoUsuario.setEnabled(true);
		lblNuevoUsuario.setBounds(135, 524, 106, 25);
		getContentPane().add(lblNuevoUsuario);

	}

}