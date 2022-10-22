package jxj.ventanasPrimarias;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import jxj.dataBase.DBException;

public class VentanaRegistro extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentpane;
	private JLabel labelDNI = new JLabel();
	private JLabel labelNombre = new JLabel();
	private JLabel labelApellido = new JLabel();
	private JLabel labelEdad = new JLabel();
	private JLabel labelEmail = new JLabel();
	private JLabel labelContrasenya = new JLabel();
	private JLabel labelConfirmarContrasenya = new JLabel();
	private JTextField textoDNI = new JTextField();
	private JTextField textoNombre = new JTextField();
	private JTextField textoApellido = new JTextField();
	private JTextField textoEdad = new JTextField();
	private JTextField textoEmail = new JTextField();
	private JPasswordField textoContrasenya = new JPasswordField();
	private JPasswordField textoConfirmarContrasenya = new JPasswordField();

	private final JPanel panelTitulo = new JPanel();
	private final JPanel panelDatos = new JPanel();
	private final JPanel panelCampos = new JPanel();

	public class JNumberTextField extends JTextField {
		private static final long serialVersionUID = 1L;
	}

	public VentanaRegistro() {

		contentpane = new JPanel();
		contentpane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentpane);
		contentpane.setLayout(null);

		panelTitulo.setBounds(0, 24, 444, 59);
		contentpane.add(panelTitulo);

		JLabel labelTitle = new JLabel("NUEVO USUARIO");
		panelTitulo.add(labelTitle);
		labelTitle.setForeground(new Color(102, 102, 153));
		labelTitle.setFont(new Font("Cooper Black", Font.BOLD, 40));

		panelDatos.setBounds(24, 100, 190, 372);
		contentpane.add(panelDatos);

		labelDNI.setText("DNI:");
		labelDNI.setOpaque(true);
		labelDNI.setFont(new Font("Segoe UI Variable", Font.BOLD, 16));

		labelNombre.setText("Nombre:");
		labelNombre.setOpaque(true);
		labelNombre.setFont(new Font("Segoe UI Variable", Font.BOLD, 16));

		labelApellido.setText("Apellido:");
		labelApellido.setOpaque(true);
		labelApellido.setFont(new Font("Segoe UI Variable", Font.BOLD, 16));

		labelEdad.setText(" Edad:");
		labelEdad.setOpaque(true);
		labelEdad.setFont(new Font("Segoe UI Variable", Font.BOLD, 16));

		labelEmail.setText("Email:");
		labelEmail.setOpaque(true);
		labelEmail.setFont(new Font("Segoe UI Variable", Font.BOLD, 16));

		labelContrasenya.setText("Contraseña:");
		labelContrasenya.setOpaque(true);
		labelContrasenya.setFont(new Font("Segoe UI Variable", Font.BOLD, 16));

		labelConfirmarContrasenya.setText("Confirmar contraseña:");
		labelConfirmarContrasenya.setOpaque(true);
		labelConfirmarContrasenya.setFont(new Font("Segoe UI Variable", Font.BOLD, 16));

		GroupLayout gl_panelDatos = new GroupLayout(panelDatos);
		gl_panelDatos.setHorizontalGroup(gl_panelDatos.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelDatos.createSequentialGroup()
						.addGroup(gl_panelDatos.createParallelGroup(Alignment.LEADING)
								.addGroup(Alignment.TRAILING,
										gl_panelDatos.createSequentialGroup().addContainerGap(18, Short.MAX_VALUE)
												.addComponent(labelConfirmarContrasenya))
								.addGroup(Alignment.TRAILING,
										gl_panelDatos.createSequentialGroup().addContainerGap(94, Short.MAX_VALUE)
												.addComponent(labelContrasenya))
								.addGroup(Alignment.TRAILING,
										gl_panelDatos.createSequentialGroup().addContainerGap(138, Short.MAX_VALUE)
												.addComponent(labelEmail))
								.addGroup(Alignment.TRAILING,
										gl_panelDatos.createSequentialGroup().addContainerGap(138, Short.MAX_VALUE)
												.addComponent(labelEdad))
								.addGroup(Alignment.TRAILING,
										gl_panelDatos.createSequentialGroup().addGap(117).addComponent(labelApellido,
												GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addGroup(Alignment.TRAILING,
										gl_panelDatos.createSequentialGroup().addContainerGap(117, Short.MAX_VALUE)
												.addComponent(labelNombre))
								.addGroup(Alignment.TRAILING, gl_panelDatos.createSequentialGroup()
										.addContainerGap(148, Short.MAX_VALUE).addComponent(labelDNI)))
						.addContainerGap()));

		gl_panelDatos.setVerticalGroup(gl_panelDatos.createParallelGroup(Alignment.LEADING).addGroup(gl_panelDatos
				.createSequentialGroup().addGap(20).addComponent(labelDNI).addGap(29)
				.addComponent(labelNombre, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE).addGap(30)
				.addComponent(labelApellido, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE).addGap(30)
				.addComponent(labelEdad, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE).addGap(30)
				.addComponent(labelEmail, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE).addGap(31)
				.addComponent(labelContrasenya, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE).addGap(30)
				.addComponent(labelConfirmarContrasenya, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
				.addContainerGap(30, Short.MAX_VALUE)));
		panelDatos.setLayout(gl_panelDatos);

		panelCampos.setBounds(208, 100, 174, 372);
		contentpane.add(panelCampos);
		GroupLayout gl_panelCampos = new GroupLayout(panelCampos);

		gl_panelCampos.setHorizontalGroup(gl_panelCampos.createParallelGroup(Alignment.LEADING).addGroup(gl_panelCampos
				.createSequentialGroup()
				.addGroup(gl_panelCampos.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelCampos.createSequentialGroup().addContainerGap().addComponent(
								textoConfirmarContrasenya, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelCampos.createSequentialGroup().addContainerGap().addComponent(
								textoContrasenya, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelCampos.createSequentialGroup().addContainerGap().addComponent(textoEmail,
								GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelCampos.createSequentialGroup().addContainerGap().addComponent(textoEdad,
								GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelCampos.createSequentialGroup().addContainerGap().addComponent(textoApellido,
								GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelCampos.createSequentialGroup().addContainerGap().addComponent(textoNombre,
								GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelCampos.createSequentialGroup().addContainerGap().addComponent(textoDNI,
								GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)))
				.addContainerGap(17, Short.MAX_VALUE)));
		gl_panelCampos
				.setVerticalGroup(
						gl_panelCampos
								.createParallelGroup(
										Alignment.LEADING)
								.addGroup(
										gl_panelCampos.createSequentialGroup().addGap(24)
												.addComponent(textoDNI, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addGap(30)
												.addComponent(textoNombre, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addGap(29)
												.addComponent(textoApellido, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addGap(31)
												.addComponent(textoEdad, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addGap(30)
												.addComponent(textoEmail, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addGap(31)
												.addComponent(textoContrasenya, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
												.addComponent(textoConfirmarContrasenya, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addGap(27)));
		panelCampos.setLayout(gl_panelCampos);

		// Boton Registrarse
		JButton btnRegistrarse = new JButton("");
		btnRegistrarse.setBackground(SystemColor.control);
		btnRegistrarse.setIcon(new ImageIcon("imagenes/Iniciar.png"));
		btnRegistrarse.setFocusPainted(false);
		btnRegistrarse.setBorderPainted(false);
		btnRegistrarse.setContentAreaFilled(false);
		btnRegistrarse.addActionListener(e -> {

			// comprobar los campos y realizar el registro

		});

		btnRegistrarse.setBounds(384, 499, 30, 30);
		contentpane.add(btnRegistrarse);

		// Boton Atras
		JButton btnAtras = new JButton("");
		btnAtras.setBackground(SystemColor.control);
		btnAtras.setIcon(new ImageIcon("imagenes/Atras.png"));
		btnAtras.setFocusPainted(false);
		btnAtras.setBorderPainted(false);
		btnAtras.setContentAreaFilled(false);
		btnAtras.addActionListener(e -> {

			VentanaInicio vi = null;
			try {
				vi = new VentanaInicio();
			} catch (DBException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			vi.setVisible(true);
			dispose();

		});
		btnAtras.setBounds(30, 499, 30, 30);
		contentpane.add(btnAtras);

		JLabel lblRegistrarse = new JLabel("Registrarse");
		lblRegistrarse.setForeground(new Color(51, 51, 204));
		lblRegistrarse.setFont(new Font("Segoe UI Variable", Font.BOLD, 14));
		lblRegistrarse.setEnabled(true);
		lblRegistrarse.setBounds(305, 501, 92, 25);
		contentpane.add(lblRegistrarse);

		JLabel lblAtras = new JLabel("Atr\u00E1s");
		lblAtras.setForeground(new Color(204, 102, 0));
		lblAtras.setFont(new Font("Segoe UI Variable", Font.BOLD, 14));
		lblAtras.setEnabled(true);
		lblAtras.setBounds(67, 501, 92, 25);
		contentpane.add(lblAtras);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(460, 600);
		setVisible(true);
		setLocationRelativeTo(null);
		setTitle("Registrarse como nuevo cliente");
	}
}