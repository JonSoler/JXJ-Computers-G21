package jxj.ventanasSecundarias;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import jxj.clasesBasicas.Usuario;
import jxj.ventanasPrimarias.VentanaCategoria;

public class VentanaCuentaUsuario extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JTextField textNombre;
	private JTextField textApellidos;
	private JTextField textUsuario;
	private JTextField textCorreo;
	private JTextField textContrasenya;
	private JPanel panelNorte, panelCentro, panelBotonera;

	public VentanaCuentaUsuario(Usuario u) {

		panelBotonera = new JPanel();
		panelNorte = new JPanel();
		panelNorte.setForeground(Color.BLACK);
		panelCentro = new JPanel();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 440, 522);
		setLocationRelativeTo(null);
		getContentPane().setBackground(new Color(245, 245, 245));

		JLabel lblMiCuenta = new JLabel("MI CUENTA");
		lblMiCuenta.setForeground(new Color(99, 121, 194));
		lblMiCuenta.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblMiCuenta.setBounds(151, 11, 147, 40);
		panelNorte.add(lblMiCuenta);

		getContentPane().add(panelNorte, BorderLayout.NORTH);
		panelCentro.setLayout(null);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(55, 58, 96, 14);
		panelCentro.add(lblNombre);

		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setBounds(55, 83, 96, 14);
		panelCentro.add(lblApellidos);

		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(55, 108, 96, 14);
		panelCentro.add(lblUsuario);

		JLabel lblMisDatos = new JLabel("Mis datos");
		lblMisDatos.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMisDatos.setBounds(11, 22, 119, 14);
		panelCentro.add(lblMisDatos);

		textNombre = new JTextField();
		textNombre.setEditable(false);
		textNombre.setBounds(161, 55, 193, 20);
		panelCentro.add(textNombre);
		textNombre.setColumns(10);
		textNombre.setText(u.getNombre());

		textApellidos = new JTextField();
		textApellidos.setEditable(false);
		textApellidos.setColumns(10);
		textApellidos.setBounds(161, 80, 193, 20);
		panelCentro.add(textApellidos);
		textApellidos.setText(u.getApellidos());

		textUsuario = new JTextField();
		textUsuario.setEditable(false);
		textUsuario.setColumns(10);
		textUsuario.setBounds(161, 105, 193, 20);
		panelCentro.add(textUsuario);
		textUsuario.setText(u.getUsuario());

		JLabel lblMail = new JLabel("E-Mail");
		lblMail.setBounds(55, 277, 96, 14);
		panelCentro.add(lblMail);

		JLabel lblContrasenya = new JLabel("Contrase\u00F1a");
		lblContrasenya.setBounds(55, 314, 96, 14);
		panelCentro.add(lblContrasenya);

		textCorreo = new JTextField();
		textCorreo.setEditable(false);
		textCorreo.setColumns(10);
		textCorreo.setBounds(161, 277, 193, 20);
		panelCentro.add(textCorreo);
		textCorreo.setText(u.getEmail());

		JLabel lblDetallesCompra = new JLabel("Detalles de la cuenta");
		lblDetallesCompra.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDetallesCompra.setBounds(11, 237, 269, 14);
		panelCentro.add(lblDetallesCompra);

		textContrasenya = new JTextField();
		textContrasenya.setEditable(false);
		textContrasenya.setColumns(10);
		textContrasenya.setBounds(161, 314, 193, 20);
		panelCentro.add(textContrasenya);
		textContrasenya.setText(u.getContrasenia());

		getContentPane().add(panelCentro, BorderLayout.CENTER);

		JButton btnAtras = new JButton("Atr\u00E1s");
		btnAtras.addActionListener(e -> {

			VentanaCategoria principal = new VentanaCategoria();
			principal.setVisible(true);
			dispose();
		});

		btnAtras.setBounds(26, 394, 126, 23);
		panelBotonera.add(btnAtras);

		getContentPane().add(panelBotonera, BorderLayout.SOUTH);

	}
}