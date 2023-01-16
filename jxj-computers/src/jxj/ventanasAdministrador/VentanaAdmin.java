package jxj.ventanasAdministrador;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import jxj.ventanasPrimarias.VentanaInicio;

public class VentanaAdmin extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane, panelNorte, panelCentro, panelBotonera;

	/**
	 * Create the frame.
	 */
	public VentanaAdmin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 631, 400);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setPanelNorte(new JPanel());
		panelBotonera = new JPanel();
		panelCentro = new JPanel();

		JButton btnStock = new JButton("STOCK DISPONIBLE");
		btnStock.setFont(new Font("Segoe UI Variable", Font.BOLD, 12));
		btnStock.setBounds(83, 167, 171, 32);
		btnStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaGestionStock vgs = new VentanaGestionStock();
				vgs.setVisible(true);
				dispose();
			}
		});
		contentPane.setLayout(new BorderLayout(0, 0));
		panelCentro.setLayout(null);
		btnStock.setForeground(Color.WHITE);
		btnStock.setBackground(new Color(255, 165, 0));
		panelCentro.add(btnStock);

		JButton btnUsuarios = new JButton("GESTION DE USUARIOS");
		btnUsuarios.setFont(new Font("Segoe UI Variable", Font.BOLD, 12));
		btnUsuarios.setBounds(353, 167, 171, 32);
		btnUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaGestionUsuario vgu = new VentanaGestionUsuario();
				vgu.setVisible(true);
				dispose();

			}
		});

		btnUsuarios.setForeground(Color.WHITE);
		btnUsuarios.setBackground(new Color(255, 165, 0));
		panelCentro.add(btnUsuarios);

		contentPane.add(panelCentro, BorderLayout.CENTER);

		JLabel lblTitulo = new JLabel("ADMINISTRAR TIENDA");
		lblTitulo.setForeground(new Color(99, 121, 194));
		lblTitulo.setFont(new Font("Cooper Black", Font.BOLD, 35));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		//panelNorte.add(lblTitulo);
		contentPane.add(lblTitulo, BorderLayout.NORTH);
		
		JLabel lblAdministrarUsuarios = new JLabel("");
		lblAdministrarUsuarios.setIcon(new ImageIcon("imagenes/AdministrarUsuarios.png"));
		lblAdministrarUsuarios.setBounds(396, 64, 92, 92);
		panelCentro.add(lblAdministrarUsuarios);
		
		JLabel lblStock = new JLabel("");
		lblStock.setIcon(new ImageIcon("imagenes/Stock.png"));
		lblStock.setBounds(122, 60, 92, 92);
		panelCentro.add(lblStock);

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

	public JPanel getPanelNorte() {
		return panelNorte;
	}

	public void setPanelNorte(JPanel panelNorte) {
		this.panelNorte = panelNorte;
	}
}
