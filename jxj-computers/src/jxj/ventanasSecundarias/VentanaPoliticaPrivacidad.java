package jxj.ventanasSecundarias;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;

import jxj.ventanasPrimarias.VentanaSeccion;

public class VentanaPoliticaPrivacidad extends JFrame {

	private static final long serialVersionUID = 1L;

	public VentanaPoliticaPrivacidad() {

		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 454, 555);
		getContentPane().setBackground(SystemColor.menu);
		getContentPane().setLayout(null);

		JLabel lblPoliticaPrivacidad = new JLabel("Politica de privacidad");
		lblPoliticaPrivacidad.setForeground(new Color(99, 121, 194));
		lblPoliticaPrivacidad.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPoliticaPrivacidad.setBounds(128, 11, 160, 29);
		getContentPane().add(lblPoliticaPrivacidad);

		JTextPane txtpnATravsDe = new JTextPane();
		txtpnATravsDe.setText("A través de este sitio web no se piden datos de carácter personal de los "
				+ "usuarios sin su conocimiento, ni se ceden a terceros.\n");

		txtpnATravsDe.setBackground(SystemColor.menu);
		txtpnATravsDe.setBounds(27, 65, 376, 389);
		getContentPane().add(txtpnATravsDe);

		JButton btnAtras = new JButton("Atras");
		btnAtras.setBounds(27, 466, 89, 23);
		getContentPane().add(btnAtras);

		btnAtras.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaPrivacidad v1 = new VentanaPrivacidad();
				v1.setVisible(true);
				dispose();

			}
		});

		JCheckBox cbAcepto = new JCheckBox("Aceptar");
		cbAcepto.setBounds(302, 454, 99, 35);
		getContentPane().add(cbAcepto);

		if (cbAcepto.isSelected()) {

			JOptionPane.showMessageDialog(null, "Has aceptado la politica de privacidad", "Privacidad",
					JOptionPane.INFORMATION_MESSAGE);
			VentanaSeccion v = new VentanaSeccion();
			v.setVisible(true);
			dispose();
		}

	}
}
