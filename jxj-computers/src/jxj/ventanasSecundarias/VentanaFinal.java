package jxj.ventanasSecundarias;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import jxj.ventanasPrimarias.VentanaCategoria;

public class VentanaFinal extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create la ventana
	 */
	
	public VentanaFinal() {

		getContentPane().setBackground(SystemColor.menu);
		getContentPane().setLayout(null);
		setIconImage(new ImageIcon("imagenes/Logo.png").getImage());

		JLabel lblTitulo = new JLabel("Compra realizada con exito");
		lblTitulo.setForeground(new Color(99, 121, 194));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 24));
		lblTitulo.setBounds(20, 21, 594, 58);
		getContentPane().add(lblTitulo);

		JLabel lblCamion = new JLabel("");
		lblCamion.setIcon(new ImageIcon("imagenes/icons8-cami\u00F3n-verificado-64.png"));
		lblCamion.setBounds(370, 171, 75, 88);
		getContentPane().add(lblCamion);

		JLabel lblCaja = new JLabel("");
		lblCaja.setIcon(new ImageIcon("imagenes/iconoCaja.png"));
		lblCaja.setBounds(234, 171, 75, 88);
		getContentPane().add(lblCaja);

		JLabel lblDispositivo = new JLabel("");
		lblDispositivo.setIcon(new ImageIcon("imagenes/dis.png"));
		lblDispositivo.setBounds(141, 162, 99, 115);
		getContentPane().add(lblDispositivo);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("imagenes/icons8-flecha-16.png"));
		lblNewLabel.setBounds(199, 183, 41, 63);
		getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("imagenes/icons8-flecha-16.png"));
		lblNewLabel_1.setBounds(319, 183, 41, 63);
		getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(319, 183, 41, 63);
		getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("imagenes/icons8-casa-48.png"));
		lblNewLabel_3.setBounds(515, 186, 99, 73);
		getContentPane().add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("imagenes/icons8-flecha-16.png"));
		lblNewLabel_4.setBounds(470, 211, 35, 14);
		getContentPane().add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Se esta tramitando el envio...");
		lblNewLabel_5.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.ITALIC, 20));
		lblNewLabel_5.setBounds(44, 107, 240, 26);
		getContentPane().add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel(
				"Te agradecemos si nos puedes dejar una valoraci\u00F3n acerca de la aplicaci\u00F3n... \r\n");
		lblNewLabel_6.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 20));
		lblNewLabel_6.setBounds(44, 325, 570, 32);
		getContentPane().add(lblNewLabel_6);

		JButton btnNewButton = new JButton("Dejar mi opinion");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaCrearOpinion vo = new VentanaCrearOpinion();
				setVisible(false);
				vo.setVisible(true);
			}
		});
		btnNewButton.setBounds(435, 394, 145, 23);
		getContentPane().add(btnNewButton);

		JLabel lblNewLabel_7 = new JLabel("GRACIAS");
		lblNewLabel_7.setForeground(new Color(99, 121, 194));
		lblNewLabel_7.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 20));
		lblNewLabel_7.setBounds(44, 368, 387, 32);
		getContentPane().add(lblNewLabel_7);

		JButton btnNewButton_1 = new JButton("Volver a JXJ Computers");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaCategoria vp = new VentanaCategoria();
				setVisible(false);
				vp.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(279, 511, 166, 58);
		getContentPane().add(btnNewButton_1);
		setBounds(100, 100, 638, 639);
		setLocationRelativeTo(null);

	}
}