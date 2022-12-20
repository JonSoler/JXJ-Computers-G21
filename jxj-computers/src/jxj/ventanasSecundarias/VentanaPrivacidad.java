package jxj.ventanasSecundarias;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URISyntaxException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;

import jxj.ventanasSecundarias.VentanaAjustes;
import jxj.dataBase.DBException;
import jxj.dataBase.DBManager;
import jxj.ventanasPrimarias.VentanaInicio;
import jxj.ventanasPrimarias.VentanaLogin;

public class VentanaPrivacidad extends JFrame{
	
	JPanel panel;
	JPanel panelBotones;
	
	
	public VentanaPrivacidad() {
		
		int idUser = VentanaLogin.getUsuarioId();
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 454, 489);
		getContentPane().setBackground(SystemColor.menu);
		
		panel = new JPanel();
		panelBotones = new JPanel();
		
		JLabel lblPrivacidad = new JLabel("Privacidad");
		lblPrivacidad.setBounds(160, 30, 90, 15);
		panel.add(lblPrivacidad);
		
		getContentPane().add(panel, BorderLayout.NORTH);
		
		JButton btnAcercaDe = new JButton("Acerca de");
		btnAcercaDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		panelBotones.setLayout(null);
		btnAcercaDe.setBackground(UIManager.getColor("CheckBox.background"));
		btnAcercaDe.setBounds(100, 101, 250, 20);
		panelBotones.add(btnAcercaDe);
		
		JButton btnPoliticaDePrivacidad = new JButton("Politica de privacidad");
		btnPoliticaDePrivacidad.setBackground(UIManager.getColor("CheckBox.background"));
		btnPoliticaDePrivacidad.setBounds(100, 54, 250, 20);
		panelBotones.add(btnPoliticaDePrivacidad);
		
		JButton btnEliminarCuenta = new JButton("Eliminar cuenta");
		btnEliminarCuenta.setBackground(UIManager.getColor("CheckBox.background"));
		btnEliminarCuenta.setBounds(100, 153, 250, 20);
		panelBotones.add(btnEliminarCuenta);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAtras.setBackground(UIManager.getColor("CheckBox.background"));
		btnAtras.setBounds(100, 199, 250, 20);
		panelBotones.add(btnAtras);
		
		btnPoliticaDePrivacidad.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaPoliticaPrivacidad v2 = new VentanaPoliticaPrivacidad();
				v2.setVisible(true);
				dispose();
				
			}
			
		});
		
		btnEliminarCuenta.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				DBManager dbm = new DBManager();
					if (JOptionPane.showConfirmDialog(null, "�Desea eliminar permanentemente su cuenta?", "Eliminacion de cuenta", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
						try {
							
							
							dbm.eliminarUsuario(idUser);
							dispose();
							VentanaInicio vl = new VentanaInicio();
							vl.setVisible(true);
					
							
						} catch (DBException e1) {
							e1.printStackTrace();
						}
				
					}
			}
		});
		
		btnAtras.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaAjustes va = new VentanaAjustes();
				va.setVisible(true);
				setVisible(false);
				
			}
		});
		
		btnAcercaDe.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(java.awt.Desktop.isDesktopSupported()) {
                    java.awt.Desktop desktop = java.awt.Desktop.getDesktop();

                    if (desktop.isSupported(java.awt.Desktop.Action.BROWSE)) {
                        try {
                            java.net.URI uri = new java.net.URI("https://www.pccomponentes.com");
                            desktop.browse(uri);
                        }catch (URISyntaxException | IOException ex) {}
                        }
                    }

            }
				
			});
		getContentPane().add(panelBotones, BorderLayout.CENTER);
		
	}
	
	
}
