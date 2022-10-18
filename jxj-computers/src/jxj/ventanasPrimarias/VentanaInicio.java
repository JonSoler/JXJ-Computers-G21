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
		setBounds(100, 100, 638, 639);
		//Boton Registro
		JButton btnRegistro = new JButton("");
		btnRegistro.setIcon(new ImageIcon("poner una imagen de icono Registro"));
		btnRegistro.setFocusPainted(false);
		btnRegistro.setBorderPainted(false);
		btnRegistro.setContentAreaFilled(false);
		btnRegistro.addActionListener(e -> {
			
			VentanaRegistro vr = null;
			vr = new VentanaRegistro();
			vr.setVisible(true);
			dispose();
		});
		
		btnRegistro.setBounds(182, 507, 66, 59);
		getContentPane().add(btnRegistro);
		
		JLabel lblTitulo = new JLabel("JXJ Computer");
		lblTitulo.setForeground(new Color(0, 0, 0));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblTitulo.setBounds(23, 28, 564, 71);
		getContentPane().add(lblTitulo);

		//Boton Login
		JButton btnLogin = new JButton("");
		btnLogin.setBackground(SystemColor.control);
		btnLogin.setIcon(new ImageIcon("poner una imagen de icono Login"));
		btnLogin.setFocusPainted(false);
		btnLogin.setBorderPainted(false);
		btnLogin.setContentAreaFilled(false);
		btnLogin.addActionListener(e -> {
			
			JOptionPane.showMessageDialog(null, "Introduzca su identificacion", "login",JOptionPane.INFORMATION_MESSAGE);
			
			VentanaLogin vi = null;
			vi = new VentanaLogin();
			vi.setVisible(true);
	
			dispose();

		});
		
		btnLogin.setBounds(382, 507, 78, 59);
		getContentPane().add(btnLogin);
		
		JLabel lblBienvenido = new JLabel("Bienvenido a nuestra tienda de dispositivos electronicos");
		lblBienvenido.setHorizontalAlignment(SwingConstants.CENTER);
		lblBienvenido.setFont(new Font("Zilla Slab", Font.ITALIC, 18));
		lblBienvenido.setBounds(23, 110, 554, 14);
		getContentPane().add(lblBienvenido);
		
		JLabel lblLogo1 = new JLabel("Logo");
		lblLogo1.setBounds(160, 188, 313, 246);
		ImageIcon ico = new ImageIcon("poner la imagen del logo");
		ImageIcon img = new ImageIcon(
		ico.getImage().getScaledInstance(lblLogo1.getWidth(), lblLogo1.getHeight(), Image.SCALE_SMOOTH));
		lblLogo1.setIcon(img);
		getContentPane().add(lblLogo1);
		
		JLabel lblLogin = new JLabel("Iniciar sesion");
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblLogin.setForeground(new Color(255, 165, 0));
		lblLogin.setBackground(new Color(255, 165, 0));
		lblLogin.setBounds(382, 467, 91, 25);
		getContentPane().add(lblLogin);
		
		JLabel lblRegistro = new JLabel("Registrar usuario");
		lblRegistro.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblRegistro.setForeground(new Color(255, 165, 0));
		lblRegistro.setBackground(new Color(255, 165, 0));
		lblRegistro.setBounds(171, 467, 120, 25);
		getContentPane().add(lblRegistro);
		
	}

}