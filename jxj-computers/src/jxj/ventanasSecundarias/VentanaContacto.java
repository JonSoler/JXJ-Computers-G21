package jxj.ventanasSecundarias;

import java.awt.Color;
import java.awt.Font;
import java.io.IOException;
import java.net.URISyntaxException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import jxj.dataBase.DBException;
import jxj.ventanasPrimarias.VentanaInicio;

public class VentanaContacto extends JFrame {

	private static final long serialVersionUID = 1L;

	public VentanaContacto() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 454, 472);
		setLocationRelativeTo(null);
		getContentPane().setBackground(new Color(245, 245, 245));
		getContentPane().setLayout(null);

		JLabel lblproblemas = new JLabel("¿Alguna Duda? Contactanos !!!");
		lblproblemas.setForeground(new Color(99, 121, 194));
		lblproblemas.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 24));
		lblproblemas.setBounds(45, 6, 378, 46);
		getContentPane().add(lblproblemas);

		JLabel lblGmail = new JLabel();
		lblGmail.setText("JXJComputers@gmail.es");
		lblGmail.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblGmail.setFocusable(false);
		lblGmail.setBounds(152, 77, 240, 41);
		getContentPane().add(lblGmail);

		JLabel lblLinkedin = new JLabel();
		lblLinkedin.setText("JXJComputers Linkedin");
		lblLinkedin.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblLinkedin.setFocusable(false);
		lblLinkedin.setBounds(152, 143, 300, 41);
		getContentPane().add(lblLinkedin);

		JTextArea txtDispositivo = new JTextArea();
		txtDispositivo
				.setText("\"Consigue el dispositivo que quieras a traves de \n nuestra pagina, a un precio unico\"");
		txtDispositivo.setOpaque(false);
		txtDispositivo.setFont(new Font("Monospaced", Font.PLAIN, 13));
		txtDispositivo.setBounds(27, 256, 403, 81);
		getContentPane().add(txtDispositivo);

		JButton btnVolver = new JButton("Atras");
		btnVolver.setBounds(91, 371, 122, 29);
		getContentPane().add(btnVolver);

		JButton btnGmail = new JButton("");
		btnGmail.setBackground(new Color(255, 255, 255));
		btnGmail.setIcon(new ImageIcon("imagenes/iconoEmail.png"));
		btnGmail.setFocusPainted(false);
		btnGmail.setBorderPainted(false);
		btnGmail.setContentAreaFilled(false);

		btnGmail.addActionListener(e -> {
			if (java.awt.Desktop.isDesktopSupported()) {
				java.awt.Desktop desktop = java.awt.Desktop.getDesktop();

				if (desktop.isSupported(java.awt.Desktop.Action.BROWSE)) {
					try {
						java.net.URI uri = new java.net.URI("https://mail.google.com");
						desktop.browse(uri);
					} catch (URISyntaxException | IOException ex) {
					}
				}
			}
		});

		btnGmail.setBounds(56, 89, 42, 29);
		getContentPane().add(btnGmail);

		JButton btnLinkedin = new JButton("");
		btnLinkedin.setBackground(new Color(255, 255, 255));
		btnLinkedin.setIcon(new ImageIcon("imagenes/iconoLikedin.png"));
		btnLinkedin.setFocusPainted(false);
		btnLinkedin.setBorderPainted(false);
		btnLinkedin.setContentAreaFilled(false);

		btnLinkedin.addActionListener(e -> {
			if (java.awt.Desktop.isDesktopSupported()) {
				java.awt.Desktop desktop = java.awt.Desktop.getDesktop();

				if (desktop.isSupported(java.awt.Desktop.Action.BROWSE)) {
					try {
						java.net.URI uri = new java.net.URI("https://www.linkedin.com");
						desktop.browse(uri);
					} catch (URISyntaxException | IOException ex) {
					}
				}
			}
		});

		btnLinkedin.setBounds(68, 143, 43, 38);
		getContentPane().add(btnLinkedin);

		JButton btnCerrarSesion = new JButton("Cerrar sesion");
		btnCerrarSesion.addActionListener(e -> {

			VentanaInicio vi;
			try {
				vi = new VentanaInicio();
				vi.setVisible(true);
			} catch (DBException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			dispose();

		});
		btnCerrarSesion.setBounds(223, 371, 136, 29);
		getContentPane().add(btnCerrarSesion);

		btnVolver.addActionListener(e -> {

			VentanaAjustes v1 = new VentanaAjustes();
			v1.setVisible(true);
			dispose();
		});
	}

}
