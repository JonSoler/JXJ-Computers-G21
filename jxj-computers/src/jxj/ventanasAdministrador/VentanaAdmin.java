package jxj.ventanasAdministrador;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import jxj.ventanasPrimarias.VentanaInicio;


public class VentanaAdmin extends JFrame{
	
	private JPanel contentPane, panelNorte, panelCentro, panelBotonera;

	/**
	 * Create the frame.
	 */
	public VentanaAdmin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 631, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		panelNorte = new JPanel();
		panelBotonera = new JPanel();
		panelCentro = new JPanel();

		JButton btnStock = new JButton("STOCK DISPONIBLE");
		btnStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaGestionStock vgs = new VentanaGestionStock();
				vgs.setVisible(true);
				dispose();
			}
		});
		contentPane.setLayout(new BorderLayout(0, 0));
		panelCentro.setLayout(new FlowLayout(FlowLayout.CENTER, 125, 125));
		btnStock.setForeground(Color.WHITE);
		btnStock.setBackground(new Color(255, 165, 0));
		btnStock.setBounds(5, 81, 348, 66);
		panelCentro.add(btnStock);

		JButton btnUsuarios = new JButton("GESTION DE USUARIOS");
		btnUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaGestionUsuario vgu = new VentanaGestionUsuario();
				vgu.setVisible(true);
				dispose();

			}
		});

		btnUsuarios.setForeground(Color.WHITE);
		btnUsuarios.setBackground(new Color(255, 165, 0));
		btnUsuarios.setBounds(129, 187, 348, 66);
		panelCentro.add(btnUsuarios);

		contentPane.add(panelCentro, BorderLayout.CENTER);

		JLabel lblTitulo = new JLabel("MEN\u00DA");
		lblTitulo.setForeground(new Color(99, 121, 194));
		lblTitulo.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 40));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		panelNorte.add(lblTitulo);
		contentPane.add(lblTitulo, BorderLayout.NORTH);

		JButton btnVlvAtras = new JButton("Volver atras");
		btnVlvAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaInicioAdmin v1 = new VentanaInicioAdmin();
				v1.setVisible(true);
				dispose();
			}
		});
		btnVlvAtras.setBounds(10, 303, 138, 23);
		panelBotonera.add(btnVlvAtras);

		contentPane.add(panelBotonera, BorderLayout.SOUTH);

		JButton btnCerrarSesion = new JButton("Cerrar Sesion");
		btnCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaInicio.main(null);
				dispose();
			}
		});
		btnCerrarSesion.setBounds(469, 303, 138, 23);

		panelBotonera.add(btnCerrarSesion);

	}
}



