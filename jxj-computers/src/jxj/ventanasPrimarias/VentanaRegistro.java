package jxj.ventanasPrimarias;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.util.regex.Pattern;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
	
	public static Pattern patronEmail = Pattern
			.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
	private JTextField textoUsuario;
	
	public static boolean comprobarEmail(String email, boolean showErrorWindow) {
		if (patronEmail.matcher(email).matches()) {
			return patronEmail.matcher(email).matches(); // email correcto
		} else {
			if (showErrorWindow) {
				JOptionPane.showMessageDialog(null, "El email " + email + " no es v\u00e1lido", "Error", JOptionPane.INFORMATION_MESSAGE);
			}
			return false;
		}
	}

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

		labelContrasenya.setText("Contrase\u00F1a:");
		labelContrasenya.setOpaque(true);
		labelContrasenya.setFont(new Font("Segoe UI Variable", Font.BOLD, 16));

		labelConfirmarContrasenya.setText("Confirmar contrase\u00F1a:");
		labelConfirmarContrasenya.setOpaque(true);
		labelConfirmarContrasenya.setFont(new Font("Segoe UI Variable", Font.BOLD, 16));
		
		JLabel lblNewLabel = new JLabel("Nombre usuario");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 16));

		GroupLayout gl_panelDatos = new GroupLayout(panelDatos);
		gl_panelDatos.setHorizontalGroup(
			gl_panelDatos.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelDatos.createSequentialGroup()
					.addContainerGap(121, Short.MAX_VALUE)
					.addComponent(labelNombre)
					.addContainerGap())
				.addGroup(Alignment.TRAILING, gl_panelDatos.createSequentialGroup()
					.addGap(117)
					.addComponent(labelApellido, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(Alignment.TRAILING, gl_panelDatos.createSequentialGroup()
					.addGap(64)
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(Alignment.TRAILING, gl_panelDatos.createSequentialGroup()
					.addContainerGap(129, Short.MAX_VALUE)
					.addGroup(gl_panelDatos.createParallelGroup(Alignment.LEADING)
						.addComponent(labelEmail)
						.addComponent(labelEdad))
					.addGap(18))
				.addGroup(Alignment.TRAILING, gl_panelDatos.createSequentialGroup()
					.addContainerGap(93, Short.MAX_VALUE)
					.addComponent(labelContrasenya)
					.addContainerGap())
				.addGroup(Alignment.TRAILING, gl_panelDatos.createSequentialGroup()
					.addContainerGap(14, Short.MAX_VALUE)
					.addComponent(labelConfirmarContrasenya)
					.addContainerGap())
				.addGroup(Alignment.TRAILING, gl_panelDatos.createSequentialGroup()
					.addContainerGap(145, Short.MAX_VALUE)
					.addComponent(labelDNI)
					.addGap(19))
		);
		gl_panelDatos.setVerticalGroup(
			gl_panelDatos.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelDatos.createSequentialGroup()
					.addGap(38)
					.addComponent(labelDNI)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(labelNombre, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(labelApellido, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblNewLabel)
					.addGap(18)
					.addComponent(labelEdad, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(labelEmail, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
					.addGap(26)
					.addComponent(labelContrasenya, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
					.addGap(26)
					.addComponent(labelConfirmarContrasenya, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(37, Short.MAX_VALUE))
		);
		panelDatos.setLayout(gl_panelDatos);

		panelCampos.setBounds(208, 100, 174, 372);
		contentpane.add(panelCampos);
		
		textoUsuario = new JTextField();
		GroupLayout gl_panelCampos = new GroupLayout(panelCampos);
		gl_panelCampos.setHorizontalGroup(
			gl_panelCampos.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelCampos.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelCampos.createParallelGroup(Alignment.LEADING)
						.addComponent(textoNombre, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
						.addComponent(textoApellido, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
						.addComponent(textoUsuario, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
						.addComponent(textoEdad, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
						.addComponent(textoEmail, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
						.addComponent(textoContrasenya, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
						.addComponent(textoConfirmarContrasenya, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
						.addComponent(textoDNI, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(21, Short.MAX_VALUE))
		);
		gl_panelCampos.setVerticalGroup(
			gl_panelCampos.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelCampos.createSequentialGroup()
					.addGap(36)
					.addComponent(textoDNI, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(textoNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(textoApellido, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(textoUsuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(textoEdad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(textoEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(27)
					.addComponent(textoContrasenya, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(28)
					.addComponent(textoConfirmarContrasenya, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(31, Short.MAX_VALUE))
		);
		panelCampos.setLayout(gl_panelCampos);

		// Boton Registrarse
		JButton btnRegistrarse = new JButton("");
		btnRegistrarse.setBackground(SystemColor.control);
		btnRegistrarse.setIcon(new ImageIcon("imagenes/Iniciar.png"));
		btnRegistrarse.setFocusPainted(false);
		btnRegistrarse.setBorderPainted(false);
		btnRegistrarse.setContentAreaFilled(false);
		btnRegistrarse.addActionListener(e -> {

			String dni = textoDNI.getText().toString();
			String nombre = textoNombre.getText().toString();
			String apellido = textoApellido.getText().toString();
			String edad = textoEdad.getText().toString();
			boolean RegistroCorrecto = false;
			boolean error = false;

			if (textoDNI.getText().equals("") || textoNombre.getText().equals("") || textoApellido.getText().equals("")
					|| textoEmail.getText().equals("") || textoContrasenya.toString().equals("")
					|| textoConfirmarContrasenya.toString().equals("")) {

				JOptionPane.showMessageDialog(null, "Por favor, rellene todos los campos", "Error",
						JOptionPane.INFORMATION_MESSAGE);
				VentanaRegistro.this.repaint();
				error = true;

			} else if (dni.matches("^[a-zA-Z]+$")) {

				JOptionPane.showMessageDialog(null, "DNI no v\u00e1lido", "Error", JOptionPane.INFORMATION_MESSAGE);
				error = true;
				VentanaRegistro.this.repaint();

			} else if (nombre.matches("^[0-9]+$")) {

				JOptionPane.showMessageDialog(null, "Nombre no v\u00e1lido", "Error", JOptionPane.INFORMATION_MESSAGE);
				error = true;
				VentanaRegistro.this.repaint();

			} else if (apellido.matches("^[0-9]+$")) {

				JOptionPane.showMessageDialog(null, "Apellido no v\u00e1lido", "Error", JOptionPane.INFORMATION_MESSAGE);
				error = true;
				VentanaRegistro.this.repaint();

			} else if (edad.matches("^[a-zA-Z]+$")) {

				JOptionPane.showMessageDialog(null, "Edad no v\u00e1lida", "Error", JOptionPane.INFORMATION_MESSAGE);
				error = true;
				VentanaRegistro.this.repaint();

			} else if (!comprobarEmail(textoEmail.getText(), false)) {
				comprobarEmail(textoEmail.getText(), true);

				error = true;
				VentanaRegistro.this.repaint();

			} else if (!String.valueOf(textoContrasenya.getPassword())
					.equals(String.valueOf(textoConfirmarContrasenya.getPassword()))) {

				JOptionPane.showMessageDialog(null, "Las contrase\u00F1as no coinciden", "Error",
						JOptionPane.INFORMATION_MESSAGE);
				VentanaRegistro.this.repaint();
				error = true;

			} else if (!error) {

				// Metodo registrar cliente

				RegistroCorrecto = true;
			}

			if (RegistroCorrecto) {
				JOptionPane.showMessageDialog(null, "Cliente registrado correctamente", "Nuevo cliente",
						JOptionPane.INFORMATION_MESSAGE);
				VentanaLogin inicio = new VentanaLogin();
				inicio.setVisible(true);
				VentanaRegistro.this.dispose();

			} else if (!error) {
				JOptionPane.showMessageDialog(null,
						"El email introducido ya ha sido registrado, pruebe a iniciar sesi\u00F3n", "Error",
						JOptionPane.INFORMATION_MESSAGE);
				VentanaRegistro.this.repaint();
			}
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