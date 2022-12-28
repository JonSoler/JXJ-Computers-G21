package jxj.ventanasVenta;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;

import jxj.ventanasSecundarias.VentanaAjustes;
import jxj.ventanasSecundarias.VentanaOpinion;



public class VentanaVentasInformacion extends JFrame {
	
	private JPanel panelNorte, panelBotonera;
	/**
	 * Creamos la ventana
	 */
	
	public VentanaVentasInformacion() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 456, 474);
		getContentPane().setBackground(new Color(245, 245, 245));
		getContentPane().setForeground(Color.WHITE);
		
		panelNorte = new JPanel();
		panelBotonera = new JPanel();

		JLabel lblVentas = new JLabel("Ventas ");
		lblVentas.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblVentas.setForeground(new Color(255, 165, 0));
		lblVentas.setBounds(172, 28, 90, 20);
		panelNorte.add(lblVentas);
		
		getContentPane().add(panelNorte, BorderLayout.NORTH);
		panelBotonera.setLayout(null);

		JButton btnVenderCoche = new JButton("Vender coche");
		btnVenderCoche.setBackground(UIManager.getColor("CheckBox.background"));
		btnVenderCoche.setBounds(67, 77, 297, 29);
		panelBotonera.add(btnVenderCoche);
		
		btnVenderCoche.addActionListener(e -> {
				 VentanaVenta v2 = new VentanaVenta();
				 v2.setVisible(true);
					dispose();
		});
		

		JButton btnVolverAtras = new JButton("Volver atras");
		btnVolverAtras.setBackground(UIManager.getColor("CheckBox.background"));
		btnVolverAtras.setBounds(67, 161, 297, 29);
		panelBotonera.add(btnVolverAtras);
		
		btnVolverAtras.addActionListener(e -> {
				VentanaAjustes v3 = new VentanaAjustes();
				v3.setVisible(true);
				dispose();
		});
		

		JButton btnOpiniones = new JButton("Opiniones");
		btnOpiniones.setBackground(UIManager.getColor("CheckBox.background"));
		btnOpiniones.setBounds(67, 119, 297, 29);
		panelBotonera.add(btnOpiniones);
	

		btnOpiniones.addActionListener(e -> {
			VentanaOpinion v3 = new VentanaOpinion();
			v3.setVisible(true);
			dispose();
	});
		getContentPane().add(panelBotonera, BorderLayout.CENTER);
	

	}

}



