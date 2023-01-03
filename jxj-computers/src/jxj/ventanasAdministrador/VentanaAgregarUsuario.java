package jxj.ventanasAdministrador;

import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Pattern;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import jxj.clasesBasicas.Usuario;
import jxj.dataBase.DBException;
import jxj.dataBase.DBManager;
import jxj.ventanasPrimarias.VentanaLogin;


public class VentanaAgregarUsuario extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTextField textNombre;
	private JTextField textApellidos;
	private JTextField textUsuario;
	private JTextField textEmail;
	private JTextField textContrasenia;
	public static Pattern patronEmail = Pattern
			.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");


	int id = VentanaLogin.getUsuarioId();
	
	/**
	 * Create the frame.
	 */
	public VentanaAgregarUsuario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 577);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNuevoUsuario = new JLabel("Nuevo usuario");
		lblNuevoUsuario.setForeground(new Color(99, 121, 194));
		lblNuevoUsuario.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblNuevoUsuario.setBounds(106, 45, 230, 39);
		contentPane.add(lblNuevoUsuario);
	
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNombre.setBounds(69, 137, 88, 32);
		contentPane.add(lblNombre);
		
		textNombre = new JTextField();
		textNombre.setBounds(192, 139, 190, 32);
		contentPane.add(textNombre);
		textNombre.setColumns(10);
		
		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblApellidos.setBounds(69, 197, 88, 32);
		contentPane.add(lblApellidos);
		
		textApellidos = new JTextField();
		textApellidos.setColumns(10);
		textApellidos.setBounds(192, 199, 190, 32);
		contentPane.add(textApellidos);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEmail.setBounds(69, 258, 88, 32);
		contentPane.add(lblEmail);
		
		textEmail = new JTextField();
		textEmail.setColumns(10);
		textEmail.setBounds(192, 260, 190, 32);
		contentPane.add(textEmail);
		
		JLabel lblContrasenya = new JLabel("Contraseña");
		lblContrasenya.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblContrasenya.setBounds(69, 369, 88, 32);
		contentPane.add(lblContrasenya);
		
		textContrasenia = new JTextField();
		textContrasenia.setColumns(10);
		textContrasenia.setBounds(192, 371, 190, 32);
		contentPane.add(textContrasenia);
		
		JLabel lblNickname = new JLabel("Nickname");
		lblNickname.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNickname.setBounds(69, 313, 88, 32);
		contentPane.add(lblNickname);
		
		textUsuario = new JTextField();
		textUsuario.setColumns(10);
		textUsuario.setBounds(192, 315, 190, 32);
		contentPane.add(textUsuario);
	
		 JButton btnAgregarUsuario = new JButton("AGREGAR");
		 btnAgregarUsuario.addActionListener(e -> {
				
				
				// compruebar ningun campo en banco
				if (textNombre.getText().equals("") || textApellidos.getText().equals("")
						|| textUsuario.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "No puedes dejar campos vacios.");
				}
				
				// compruebar que cumple el patron del email
				if (!comprobarPatronEmail(textEmail.getText(), false)) {
					comprobarPatronEmail(textEmail.getText(), true);
				} else {
					DBManager modSql = new DBManager();
					
					
					Usuario mod = new Usuario();
					mod.setApellidos(textApellidos.getText());
					mod.setEmail(textEmail.getText());
					mod.setNombre(textNombre.getText());
					mod.setUsuario(textUsuario.getText());
					mod.setContrasenia(textContrasenia.getText());
					
					

					try {
						if (modSql.registrar(mod)) {
							aniadirUsuarioAFichero();
							JOptionPane.showMessageDialog(null, "Usuario insertado correctamente");
						} else {
							JOptionPane.showMessageDialog(null, "No se ha podido insertar");
						}
					} catch (HeadlessException | DBException e2) {
						e2.printStackTrace();
					}
					

					JOptionPane.showMessageDialog(null, "Usuario insertado");

					VentanaGestionUsuario vg = new VentanaGestionUsuario();
					vg.setVisible(true);
					dispose();
			} 
		}); 
		 	
		 this.setVisible(true);
		
		btnAgregarUsuario.setForeground(Color.WHITE);
		btnAgregarUsuario.setBackground(new Color(255, 165, 0));
		btnAgregarUsuario.setBounds(152, 466, 132, 50);
		contentPane.add(btnAgregarUsuario);
		
		JButton btnAtras = new JButton("");
		btnAtras.setFocusPainted(false);
		btnAtras.setBorderPainted(false);
		btnAtras.setContentAreaFilled(false);
		btnAtras.setIcon(new ImageIcon("imagenes/iconoAtras.png"));
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaAdmin va = new VentanaAdmin();
				va.setVisible(true);
				dispose();
			}
		});
		btnAtras.setBounds(10, 11, 53, 32);
		contentPane.add(btnAtras);
		
	
	}
	
	public static boolean comprobarPatronEmail(String email, boolean showErrorWindow) {
		if (patronEmail.matcher(email).matches()) {
			System.out.println(email + "Cumple el patron correctamente");
			return patronEmail.matcher(email).matches();
		} else {
			if (showErrorWindow) {
				JOptionPane.showMessageDialog(null, "El email " + email + " no cumple el patron correctamente");
				System.out.println("El email " + email + " no cumple el patron correctamente");
			}
			return false;
		}
	}
	//metodo que se encarga de escribir en el fichero usuarioRegistrados los usuarios que se registren
		public void aniadirUsuarioAFichero() {
		    File file = new File("usuarioRegistrados.txt");
			try{	
				FileWriter fw = new FileWriter(file.getAbsoluteFile(), true); //opci�n append habilitada permite escribir sobre el fichero sin tener que borrarlo
				BufferedWriter bw = new BufferedWriter(fw);
				bw.write("\n" + textNombre.getText() + "  " + textApellidos.getText() + " ha iniciado sesion con el usuario "
						+ textUsuario.getText() + " con contraseña " + textContrasenia.getText());
				
				bw.close();
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
}

