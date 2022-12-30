package jxj.ventanasSecundarias;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import jxj.clasesBasicas.Tarjeta;
import jxj.dataBase.DBException;
import jxj.dataBase.DBManager;
import jxj.ventanasPrimarias.VentanaInicio;
import jxj.ventanasPrimarias.VentanaRegistro;


public class VentanaPago extends javax.swing.JFrame {

	private static final Component ActionPerformed = null;
	private JPanel contentPane;
	private JTextField TextoNTarjeta;
	private JTextField Textocaducidad;
	private JTextField TextoCodigodeSeguridad;
	private JTextField txtnombreTarjeta;
	private JTextField txtNombreCompleto;
	private JTextField txtDireccin;
	private JTextField txtLneaDeDireccin;
	private JTextField txtCiudad;
	private JTextField txtEstadoprovincia;
	private JTextField txtCodigoPostal_1;

	/**
	 * Create the frame.
	 */
	public VentanaPago() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 349, 559);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.menu);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		TextoNTarjeta = new JTextField();
		TextoNTarjeta.setHorizontalAlignment(SwingConstants.CENTER);
		TextoNTarjeta.setFont(new Font("Tahoma", Font.PLAIN, 11));
		TextoNTarjeta.setText("               N\u00FAmero de la tarjeta");
		TextoNTarjeta.setBounds(23, 98, 297, 26);
		contentPane.add(TextoNTarjeta);
		TextoNTarjeta.setColumns(10);

		Textocaducidad = new JTextField();
		Textocaducidad.setHorizontalAlignment(SwingConstants.CENTER);
		Textocaducidad.setFont(new Font("Tahoma", Font.PLAIN, 11));
		Textocaducidad.setText("     MM/AA");
		Textocaducidad.setBounds(23, 135, 141, 26);
		contentPane.add(Textocaducidad);
		Textocaducidad.setColumns(10);

		TextoCodigodeSeguridad = new JTextField();
		TextoCodigodeSeguridad.setHorizontalAlignment(SwingConstants.CENTER);
		TextoCodigodeSeguridad.setFont(new Font("Tahoma", Font.PLAIN, 11));
		TextoCodigodeSeguridad.setText("  Codigo de Seguridad");
		TextoCodigodeSeguridad.setBounds(174, 135, 146, 26);
		contentPane.add(TextoCodigodeSeguridad);
		TextoCodigodeSeguridad.setColumns(10);

		txtnombreTarjeta = new JTextField();
		txtnombreTarjeta.setHorizontalAlignment(SwingConstants.CENTER);
		txtnombreTarjeta.setText("Nombre Tarjeta");
		txtnombreTarjeta.setBounds(58, 172, 106, 26);
		contentPane.add(txtnombreTarjeta);
		txtnombreTarjeta.setColumns(10);

		txtNombreCompleto = new JTextField();
		txtNombreCompleto.setHorizontalAlignment(SwingConstants.CENTER);
		txtNombreCompleto.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtNombreCompleto.setText("    Nombre Completo");
		txtNombreCompleto.setBounds(23, 259, 297, 26);
		contentPane.add(txtNombreCompleto);
		txtNombreCompleto.setColumns(10);

		txtDireccin = new JTextField();
		txtDireccin.setHorizontalAlignment(SwingConstants.CENTER);
		txtDireccin.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtDireccin.setText("               Direcci\u00F3n");
		txtDireccin.setBounds(23, 296, 297, 26);
		contentPane.add(txtDireccin);
		txtDireccin.setColumns(10);

		txtLneaDeDireccin = new JTextField();
		txtLneaDeDireccin.setHorizontalAlignment(SwingConstants.CENTER);
		txtLneaDeDireccin.setText("L\u00EDnea de Direcci\u00F3n 2 ");
		txtLneaDeDireccin.setBounds(23, 330, 297, 26);
		contentPane.add(txtLneaDeDireccin);
		txtLneaDeDireccin.setColumns(10);

		txtCiudad = new JTextField();
		txtCiudad.setHorizontalAlignment(SwingConstants.CENTER);
		txtCiudad.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtCiudad.setText("         Ciudad");
		txtCiudad.setBounds(23, 367, 146, 26);
		contentPane.add(txtCiudad);
		txtCiudad.setColumns(10);

		txtEstadoprovincia = new JTextField();
		txtEstadoprovincia.setHorizontalAlignment(SwingConstants.CENTER);
		txtEstadoprovincia.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtEstadoprovincia.setText("   Estado/Provincia");
		txtEstadoprovincia.setBounds(174, 367, 146, 26);
		contentPane.add(txtEstadoprovincia);
		txtEstadoprovincia.setColumns(10);

		txtCodigoPostal_1 = new JTextField();
		txtCodigoPostal_1.setHorizontalAlignment(SwingConstants.CENTER);
		txtCodigoPostal_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtCodigoPostal_1.setText("    Codigo Postal");
		txtCodigoPostal_1.setColumns(10);
		txtCodigoPostal_1.setBounds(99, 404, 146, 26);
		contentPane.add(txtCodigoPostal_1);

		JComboBox TipoTarjeta = new JComboBox();
		TipoTarjeta.setModel(new DefaultComboBoxModel(
				new String[] { "Visa", "MasterCard", "BBK", "Caixa", "Discover", "American Express" }));
		TipoTarjeta.setBounds(174, 172, 94, 26);
		contentPane.add(TipoTarjeta);

		JButton BotonGuardar = new JButton("Guardar");
		BotonGuardar.setBackground(new Color(255, 165, 0));
		BotonGuardar.setForeground(new Color(0, 0, 0));
		BotonGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaTransaccionCompra vtt = new VentanaTransaccionCompra();
				setVisible(false);
				
				
				JOptionPane.showMessageDialog(null, "Los datos de la tarjeta se han guardado correctamente",
						"Correcto", 1);
				
			}
		});
		BotonGuardar.setFont(new Font("Tahoma", Font.BOLD, 16));
		BotonGuardar.setBounds(112, 489, 115, 29);
		contentPane.add(BotonGuardar);

		int idU = VentanaRegistro.getUsuarioId();

		JButton btnPaypal = new JButton("");
		btnPaypal.setIcon(new ImageIcon("imagenes/iconoPaypal.png"));
		btnPaypal.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnPaypal.setBounds(266, 462, 54, 56);
		btnPaypal.setFocusPainted(false);
		btnPaypal.setBorderPainted(false);
		btnPaypal.setContentAreaFilled(false);
		contentPane.add(btnPaypal);

		TextoNTarjeta.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
				TextoNTarjeta.setText("");
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				TextoNTarjeta.setText("");

			}
		});
		Textocaducidad.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
				Textocaducidad.setText("");
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				Textocaducidad.setText("");

			}
		});
		TextoCodigodeSeguridad.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
				TextoCodigodeSeguridad.setText("");
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				TextoCodigodeSeguridad.setText("");

			}
		});
		txtnombreTarjeta.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
				txtnombreTarjeta.setText("");
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				txtnombreTarjeta.setText("");

			}
		});
		txtDireccin.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
				txtDireccin.setText("");
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				txtDireccin.setText("");

			}
		});
		txtNombreCompleto.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
				txtNombreCompleto.setText("");
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				txtNombreCompleto.setText("");

			}
		});
		txtLneaDeDireccin.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
				txtLneaDeDireccin.setText("");
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				txtLneaDeDireccin.setText("");

			}
		});

		txtEstadoprovincia.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
				txtEstadoprovincia.setText("");
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				txtEstadoprovincia.setText("");

			}
		});

		txtCiudad.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
				txtCiudad.setText("");
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				txtCiudad.setText("");

			}
		});

		txtCodigoPostal_1.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
				txtCodigoPostal_1.setText("");
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				txtCodigoPostal_1.setText("");

			}
		});
		JButton btnAtras = new JButton("");
		btnAtras.setIcon(new ImageIcon("imagenes/iconoAtras.png"));
		btnAtras.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAtras.setBounds(10, 11, 54, 36);
		btnAtras.setFocusPainted(false);
		btnAtras.setBorderPainted(false);
		btnAtras.setContentAreaFilled(false);
		contentPane.add(btnAtras);

		JLabel lblTitulo = new JLabel("Pago con Tarjeta ");
		lblTitulo.setForeground(new Color(99, 121, 194));
		lblTitulo.setFont(new Font("Dialog", Font.PLAIN, 21));
		lblTitulo.setBounds(76, 36, 187, 36);
		contentPane.add(lblTitulo);

		JLabel lblTituloFacturacion = new JLabel("Direccion de facturacion");
		lblTituloFacturacion.setForeground(new Color(99, 121, 194));
		lblTituloFacturacion.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 18));
		lblTituloFacturacion.setBounds(23, 222, 297, 26);
		contentPane.add(lblTituloFacturacion);

		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaInicio vp = null;
				try {
					vp = new VentanaInicio();
				} catch (DBException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				setVisible(false);
				vp.setVisible(true);
			}
		});

		btnPaypal.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (java.awt.Desktop.isDesktopSupported()) {
					java.awt.Desktop desktop = java.awt.Desktop.getDesktop();

					if (desktop.isSupported(java.awt.Desktop.Action.BROWSE)) {
						try {
							java.net.URI uri = new java.net.URI("https://www.paypal.com/es/signin");
							desktop.browse(uri);
						} catch (URISyntaxException | IOException ex) {
						}
					}
				}

			}

		});

		int idUsuario = idU;
		
	

		BotonGuardar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				VentanaFinal vt = new VentanaFinal();
				setVisible(false);
				vt.setVisible(true);

				String tipo = TipoTarjeta.getSelectedItem().toString();
				String numeroTarjeta = TextoNTarjeta.getText();
				String fecha = Textocaducidad.getText();
				String codigoDeSeguridad = TextoCodigodeSeguridad.getText();
				String nombreTarjeta = txtnombreTarjeta.getText();
				String nombreCompleto = txtNombreCompleto.getText();
				String direccion = txtDireccin.getText();
				String lineaSegundaDireccion = txtLneaDeDireccin.getText();
				String ciudad = txtCiudad.getText();
				String estadoProvincia = txtEstadoprovincia.getText();
				String codigoPostal = txtCodigoPostal_1.getText();

				Tarjeta tarjeta = new Tarjeta();

				tarjeta.setidUsuario(idUsuario);
				tarjeta.setTipo(tipo);
				tarjeta.setNumeroTarjeta(numeroTarjeta);
				tarjeta.setFecha(fecha);
				tarjeta.setCodigoDeSeguridad(codigoDeSeguridad);
				tarjeta.setNombreTarjeta(nombreTarjeta);
				tarjeta.setNombreCompleto(nombreCompleto);
				tarjeta.setDireccion(direccion);
				tarjeta.setLineaSegundaDireccion(lineaSegundaDireccion);
				tarjeta.setCiudad(ciudad);
				tarjeta.setEstadoProvincia(estadoProvincia);
				tarjeta.setCodigoPostal(codigoPostal);

				DBManager conexionT = new DBManager();

				try {
					conexionT.initBD("JXJComputers.db");
					conexionT.insertarDatosTarjeta(tarjeta); 
					try {
						conexionT.disconnect();
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

