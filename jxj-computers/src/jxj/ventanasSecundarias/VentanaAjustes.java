package jxj.ventanasSecundarias;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;


import jxj.dataBase.DBException;
import jxj.ventanasPrimarias.VentanaInicio;
import jxj.ventanasPrimarias.VentanaLogin;
import jxj.ventanasPrimarias.VentanaSeccion;
import jxj.ventanasVenta.VentanaVenta;

import java.awt.SystemColor;

public class VentanaAjustes extends JFrame {

	/**
	 * Creamos la ventana
	 */
	
	public VentanaAjustes() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 454, 555);
		getContentPane().setBackground(new Color(245, 245, 245));
		getContentPane().setLayout(null);

		JLabel lblConfiguracion = new JLabel("Configuracion");
		lblConfiguracion.setForeground(new Color(99, 121, 194));
		lblConfiguracion.setBackground(new Color(255, 255, 255));
		lblConfiguracion.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 22));
		lblConfiguracion.setBounds(10, 22, 297, 29);
		getContentPane().add(lblConfiguracion);

		JLabel lblDatosCuenta = new JLabel("Datos de tu cuenta\r\n");
		lblDatosCuenta.setBackground(Color.PINK);
		lblDatosCuenta.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDatosCuenta.setBounds(10, 66, 229, 20);
		getContentPane().add(lblDatosCuenta);

		JLabel lblSesion = new JLabel("Sesion");
		lblSesion.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSesion.setBounds(10, 230, 69, 20);
		getContentPane().add(lblSesion);

		JLabel lblContacto = new JLabel("Servicio");
		lblContacto.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblContacto.setBounds(10, 334, 110, 20);
		getContentPane().add(lblContacto);

		JButton botonPrivacidad = new JButton("Privacidad");
		botonPrivacidad.setBackground(UIManager.getColor("CheckBox.background"));
		botonPrivacidad.setBounds(57, 158, 297, 20);
		getContentPane().add(botonPrivacidad);

		JButton botonSeguridad = new JButton("Seguridad");
		botonSeguridad.setBackground(UIManager.getColor("CheckBox.background"));
		botonSeguridad.setBounds(57, 177, 297, 23);
		getContentPane().add(botonSeguridad);

		JButton botonCerrarSesion = new JButton("Cerrar Sesion");
		botonCerrarSesion.setBackground(UIManager.getColor("CheckBox.background"));
		botonCerrarSesion.setBounds(57, 261, 297, 23);
		getContentPane().add(botonCerrarSesion);

		JButton botonSalir = new JButton("Salir de la aplicacion");
		botonSalir.setBackground(UIManager.getColor("CheckBox.background"));
		botonSalir.setBounds(57, 285, 297, 23);
		getContentPane().add(botonSalir);

		JButton botonContacto = new JButton("Contacto");
		botonContacto.setBackground(UIManager.getColor("CheckBox.background"));
		botonContacto.setBounds(57, 375, 297, 23);
		getContentPane().add(botonContacto);

		JButton btnvlvAtras = new JButton("Volver atras");
		btnvlvAtras.setBackground(UIManager.getColor("CheckBox.background"));
		btnvlvAtras.setBounds(57, 398, 297, 23);
		getContentPane().add(btnvlvAtras);

		JButton btnVentasEInformacion = new JButton("Ventas e informacion");
		btnVentasEInformacion.setBackground(UIManager.getColor("CheckBox.background"));
		btnVentasEInformacion.setBounds(57, 120, 297, 20);
		getContentPane().add(btnVentasEInformacion);

		

		btnVentasEInformacion.addActionListener(e -> {
			
			VentanaVenta v1 = new VentanaVenta();
			v1.setVisible(true);
			dispose();
		
	});		

		botonPrivacidad.addActionListener(e -> {
			
				VentanaPrivacidad v2 = new VentanaPrivacidad();
				v2.setVisible(true);
				dispose();

		});

		botonCerrarSesion.addActionListener(e -> {
			
				VentanaLogin vl = new VentanaLogin();
				vl.setVisible(true);
				dispose();
		});

		botonSalir.addActionListener(e -> {
			
				System.exit(-1);
		});

		botonContacto.addActionListener(e -> {
				VentanaContacto v4 = new VentanaContacto();
				v4.setVisible(true);
				dispose();
		});

		botonSeguridad.addActionListener(e -> {
			
				VentanaSeguridad vs = new VentanaSeguridad();
				vs.setVisible(true);
				setVisible(false);
		});

		btnvlvAtras.addActionListener(e -> {
			
				VentanaSeccion vs = null;
				vs = new VentanaSeccion();
				vs.setVisible(true);
				setVisible(false);

		});
	}
}
