package jxj.ventanasAdministrador;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import jxj.clasesBasicas.Usuario;
import jxj.dataBase.DBException;
import jxj.dataBase.DBManager;
import jxj.ventanasPrimarias.VentanaInicio;

public class VentanaGestionUsuario extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JTable tablaUsuarios;
	private DefaultTableModel modeloTabla;
	private ArrayList<Usuario> usuarios = new ArrayList<>();

	public VentanaGestionUsuario() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(99, 121, 194));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaAgregarUsuario vau = new VentanaAgregarUsuario();
				vau.setVisible(true);
				dispose();
			}
		});

		btnAgregar.setForeground(Color.WHITE);
		btnAgregar.setBackground(new Color(255, 165, 0));
		btnAgregar.setBounds(50, 299, 100, 39);
		contentPane.add(btnAgregar);

		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setForeground(Color.WHITE);
		btnEliminar.setBackground(new Color(255, 165, 0));
		btnEliminar.setBounds(437, 299, 100, 39);
		contentPane.add(btnEliminar);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setForeground(new Color(99, 121, 194));
		menuBar.setBounds(0, 0, 584, 22);
		getContentPane().add(menuBar);

		JMenu mnGestion = new JMenu("Gestion");
		mnGestion.setForeground(Color.BLACK);
		menuBar.add(mnGestion);

		JMenuItem mnStock = new JMenuItem("Stock");
		mnStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaGestionStock vgs = new VentanaGestionStock();
				vgs.setVisible(true);
				dispose();
			}
		});
		mnGestion.add(mnStock);

		JMenuItem mnUsuarios = new JMenuItem("Usuarios");
		mnUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaGestionUsuario vgu = new VentanaGestionUsuario();
				vgu.setVisible(true);
				dispose();
			}
		});
		mnGestion.add(mnUsuarios);

		JMenuItem mnInicioAdmin = new JMenuItem("Volver al inicio");
		mnInicioAdmin.setForeground(Color.BLACK);
		mnInicioAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaAdmin va = new VentanaAdmin();
				va.setVisible(true);
				dispose();
			}
		});
		mnGestion.add(mnInicioAdmin);

		JMenuItem mnCerrarSesion = new JMenuItem("Cerrar sesion");
		mnCerrarSesion.setForeground(Color.BLACK);
		mnCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaInicio.main(null);
				dispose();
			}
		});
		mnGestion.add(mnCerrarSesion);

		Object[] columnas = { "id", "nombre", "apellidos", "usuario", "contrasenia", "email" };
		modeloTabla = new DefaultTableModel();
		modeloTabla.setColumnIdentifiers(columnas);
		tablaUsuarios = new JTable(modeloTabla);
		JScrollPane scroll = new JScrollPane(tablaUsuarios);
		contentPane.add(scroll);

		try {
			usuarios = DBManager.listarUsuarios();
		} catch (DBException e) {
			e.printStackTrace();
		}

		DefaultListModel<Usuario> modelo = new DefaultListModel<>();
		@SuppressWarnings({ "unchecked", "rawtypes" })
		JList listaUsuarios = new JList(modelo);
		listaUsuarios.setForeground(Color.BLACK);
		listaUsuarios.setFont(new Font("Arial", Font.PLAIN, 15));
		listaUsuarios.setBackground(new Color(255, 255, 255));
		listaUsuarios.setBounds(50, 54, 487, 234);
		contentPane.add(listaUsuarios);

		JScrollPane scrollpane = new JScrollPane(listaUsuarios);
		getContentPane().add(scrollpane, BorderLayout.CENTER);
		scrollpane.setBounds(50, 54, 487, 234);
		contentPane.add(scrollpane);

		JLabel lblGestionUsuarios = new JLabel("Gestion de usuarios");
		lblGestionUsuarios.setFont(new Font("Arial", Font.PLAIN, 27));
		scrollpane.setColumnHeaderView(lblGestionUsuarios);

		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Usuario u = modelo.get(listaUsuarios.getSelectedIndex());
				usuarios.remove(listaUsuarios.getSelectedIndex());
				modelo.remove(listaUsuarios.getSelectedIndex());
				try {
					try {
						DBManager.borrarUsuarioGestion(u);
					} catch (DBException e1) {
						e1.printStackTrace();
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				validate();
				repaint();
			}
		});

		for (Usuario usuario : usuarios) {
			modelo.addElement(usuario);
		}

	}
}
