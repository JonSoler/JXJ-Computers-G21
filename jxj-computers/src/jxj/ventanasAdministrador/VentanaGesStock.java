package jxj.ventanasAdministrador;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import jxj.dataBase.DBException;
import jxj.dataBase.DBManager;
import jxj.ventanasPrimarias.VentanaInicio;

public class VentanaGesStock extends JFrame{

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTable table;
	private ArrayList<String> dispositivos = new ArrayList<>();

	public VentanaGesStock() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaAgregarDispositivo vac = new VentanaAgregarDispositivo();
				vac.setVisible(true);
				dispose();
			}
		});
		
		JButton btnExpCsv = new JButton("Exp a CSV");
		btnExpCsv.setForeground(Color.WHITE);
		btnExpCsv.setBackground(new Color(0, 128, 0));
		btnExpCsv.setBounds(245, 299, 100, 39);
		contentPane.add(btnExpCsv);
		
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
		menuBar.setBounds(0, 0, 584, 22);
		getContentPane().add(menuBar);
		
		JMenu mnGestion = new JMenu("Gestion");
		menuBar.add(mnGestion);

		JMenuItem mnStock = new JMenuItem("Stock");
		mnStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaGesStock vgs = new VentanaGesStock();
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
		
		JMenuItem mnInicioAdmin = new JMenuItem("Volver a inicio");
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
		
	
		try {
			dispositivos = DBManager.listarDispositvos();
		} catch (DBException e) {
			e.printStackTrace();
		} 
		
		DefaultListModel<String> modelo = new DefaultListModel<>();
		JList listaArticulos = new JList(modelo);
		listaArticulos.setForeground(Color.BLACK);
		listaArticulos.setFont(new Font("Arial", Font.PLAIN, 15));
		listaArticulos.setBackground(new Color(255, 255, 255));
		listaArticulos.setBounds(50, 54, 487, 234);
		contentPane.add(listaArticulos);
		
		
		JScrollPane scrollpane = new JScrollPane(listaArticulos);
        getContentPane().add(scrollpane, BorderLayout.CENTER);
        scrollpane.setBounds(50, 54, 487, 234);
		contentPane.add(scrollpane);
		
		JLabel lblGestionStock = new JLabel("Gestion de Stock");
		lblGestionStock.setFont(new Font("Arial", Font.PLAIN, 27));
		scrollpane.setColumnHeaderView(lblGestionStock);
		
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String p = modelo.get(listaArticulos.getSelectedIndex());
				dispositivos.remove(listaArticulos.getSelectedIndex());
				modelo.remove(listaArticulos.getSelectedIndex());
				 try {
					try {
						DBManager.borrarDispositivo(p);
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
		
		for (String producto : dispositivos) {
			modelo.addElement(producto);
		}
		
		btnExpCsv.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String desktopPath = System.getProperty("user.home") + "/github/JXJ-Computers-G21" + "/dispositivo.csv";
				String ruta = desktopPath.replace("\\", "/");
	
				File archivo = new File(ruta);
				PrintWriter pw = null;
					
				try {
					pw = new PrintWriter(archivo);
					for(String p: dispositivos) {
						pw.println(p);
						
						
					}
				} catch (FileNotFoundException e2) {
			
					e2.printStackTrace();
				} finally {
					if(pw!=null) {
						pw.flush();
						pw.close();
						JOptionPane.showMessageDialog(null, "Fichero .Csv creado correctamente", "EXPORTACION CORRECTA", JOptionPane.INFORMATION_MESSAGE);
					}
				}
		        
			}
		
		});
		
		
	}
}
