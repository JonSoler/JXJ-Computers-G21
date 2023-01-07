package jxj.ventanasSecundarias;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import jxj.clasesBasicas.Opinion;
import jxj.dataBase.DBException;
import jxj.dataBase.DBManager;
import jxj.ventanasPrimarias.VentanaInicio;
import jxj.ventanasPrimarias.VentanaLogin;
import jxj.ventanasPrimarias.VentanaSeccion;

public class VentanaCrearOpinion extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Create the frame
	 */
	
	private JTextField textTitulo;
	private JTextField textDesc;
	public static Connection con;
	public static String nombreBD = "EasyRentingMotors.db";
	public static int idOpinion;
	static PrintStream log;
	Logger logger = Logger.getLogger("LOGGER");

	public VentanaCrearOpinion() {

		int idU = VentanaLogin.getUsuarioId();
		logger.log(Level.INFO, "Ventana inicializada");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 440, 522);
		setLocationRelativeTo(null);
		getContentPane().setBackground(SystemColor.menu);
		getContentPane().setLayout(null);

		JLabel lblOpinion = new JLabel("Dejanos la opinion acerca de tu compra ");
		lblOpinion.setForeground(new Color(99, 121, 194));
		lblOpinion.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblOpinion.setBounds(29, 6, 405, 88);
		getContentPane().add(lblOpinion);

		JLabel lblTitulo = new JLabel("Titulo");
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTitulo.setBounds(30, 97, 65, 20);
		getContentPane().add(lblTitulo);

		textTitulo = new JTextField();
		textTitulo.setBounds(30, 130, 343, 26);
		getContentPane().add(textTitulo);
		textTitulo.setColumns(10);

		JLabel lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDescripcion.setBounds(30, 185, 106, 26);
		getContentPane().add(lblDescripcion);

		textDesc = new JTextField();
		textDesc.setBounds(30, 222, 343, 83);
		getContentPane().add(textDesc);
		textDesc.setColumns(10);

		JCheckBox cbxOpinion = new JCheckBox("Permites a JXJ Computers hacer publica tu opinion");
		cbxOpinion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbxOpinion.setBackground(SystemColor.menu);
		cbxOpinion.setBounds(30, 340, 343, 23);
		getContentPane().add(cbxOpinion);

		JButton btnAtras = new JButton("Atras");
		btnAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VentanaInicio vi = null;
				try {
					vi = new VentanaInicio();
				} catch (DBException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				vi.setVisible(true);
				dispose();

			}
		});
		btnAtras.setBounds(30, 416, 106, 23);
		getContentPane().add(btnAtras);

		JButton btnGuardar = new JButton("Guardar\r\n");
		btnGuardar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "Gracias por tu opini�n", "Correcto", 1);
				VentanaSeccion vs = null;
				vs = new VentanaSeccion();
				vs.setVisible(true);
				setVisible(false);
			}
		});
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnGuardar.setBounds(261, 416, 112, 23);
		getContentPane().add(btnGuardar);

		btnGuardar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				@SuppressWarnings("unused")
				DBManager dbm = new DBManager();
				try {
					int idUsuario = idU;
					String titulo = textTitulo.getText();
					String descripcion = textDesc.getText();

					con = DBManager.initBD(nombreBD);
					Opinion opinion = new Opinion(idUsuario, titulo, descripcion);
					DBManager.insertarOpinion(opinion);
					try {
						DBManager.disconnect();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

					VentanaOpinion vo = new VentanaOpinion();
					vo.setVisible(true);
					dispose();

				} catch (DBException e1) {

					e1.printStackTrace();
				}

			}
		});

	}

}
