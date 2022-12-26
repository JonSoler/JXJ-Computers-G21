package jxj.ventanasSecundarias;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import java.awt.BorderLayout;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import jxj.ventanasPrimarias.VentanaLogin;
import jxj.clasesBasicas.Usuario;
import jxj.dataBase.DBException;
import jxj.dataBase.DBManager;

import javax.swing.JButton;
import java.awt.Color;

public class VentanaSeguridad extends JFrame{
	
	private static final long serialVersionUID = 1L;

	int l = VentanaLogin.getUsuarioId();
	
	private JPasswordField pfActual;
	private JPasswordField pfNueva;
	private JPasswordField pfConfirmarNueva;
	private JPanel panelNorte;
	private JPanel panelCentro;
	private JPanel panelBotones;
	
	public VentanaSeguridad() {
		
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 449, 379);
		getContentPane().setBackground(SystemColor.menu);
		
		panelNorte = new JPanel();
		panelBotones = new JPanel();
		panelCentro = new JPanel();
		
		JLabel lblCambiarContrasenia = new JLabel("Cambiar contraseña");
		lblCambiarContrasenia.setForeground(new Color(99, 121, 194));
		lblCambiarContrasenia.setBounds(128, 23, 223, 20);
		panelNorte.add(lblCambiarContrasenia);
		getContentPane().add(panelNorte, BorderLayout.NORTH);
		panelCentro.setLayout(null);
		
		JLabel lblContraseniaAntigua = new JLabel("Contraseña actual");
		lblContraseniaAntigua.setBounds(10, 50, 165, 14);
		panelCentro.add(lblContraseniaAntigua);
		
		pfActual = new JPasswordField();
		pfActual.setBounds(185, 44, 208, 20);
		panelCentro.add(pfActual);
		
		JLabel lblNuevaContrasenia = new JLabel("Nueva contraseña");
		lblNuevaContrasenia.setBounds(10, 114, 139, 14);
		panelCentro.add(lblNuevaContrasenia);
		
		pfNueva = new JPasswordField();
		pfNueva.setBounds(185, 111, 208, 20);
		panelCentro.add(pfNueva);
		
		JLabel label = new JLabel("Confirmar contraseña");
		label.setBounds(10, 177, 165, 14);
		panelCentro.add(label);
		
		pfConfirmarNueva = new JPasswordField();
		pfConfirmarNueva.setBounds(185, 174, 208, 20);
		panelCentro.add(pfConfirmarNueva);
		
		getContentPane().add(panelCentro, BorderLayout.CENTER);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.setBounds(10, 366, 160, 29);
		panelBotones.add(btnAtras);
		
		btnAtras.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaAjustes va = new VentanaAjustes();
				va.setVisible(true);
				setVisible(false);
				
			}
		});
		
		JButton btnCambiar = new JButton("Cambiar");
		btnCambiar.setBounds(248, 367, 160, 26);
		panelBotones.add(btnCambiar);
		
		getContentPane().add(panelBotones, BorderLayout.SOUTH);
		
		
		btnCambiar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) { 
				DBManager dbm = new DBManager();
				try {
					
					dbm.initBD("JXJComputers.db");
					Usuario user = null;
					try {
						user = dbm.buscarUsuarioId(l);
					} catch (SQLException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					if (user.getContrasenia().equals(pfActual.getText()) && pfNueva.getText().equals(pfConfirmarNueva.getText())) {
						user.setContrasenia(pfNueva.getText());
						dbm.cambiarContrasenia(user);
						JOptionPane.showMessageDialog(null, "Contraseña cambiada correctamente", "Confirmacion", 1);
						pfActual.setText("");
						pfNueva.setText("");
						pfConfirmarNueva.setText("");
					}else {
						JOptionPane.showMessageDialog(null, "Los campos no coinciden o contraseña incorrecta", "Error", 0);
					}
					try {
						dbm.disconnect();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} catch (DBException e1) {
					
					e1.printStackTrace();
				}
				
				
			}
		});
		
	}
}
