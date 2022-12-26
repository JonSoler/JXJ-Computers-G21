package jxj.ventanasAdministrador;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import jxj.dataBase.DBException;
import jxj.dataBase.DBManager;
import jxj.ventanasPrimarias.VentanaSeccion;


public class VentanaAgregarDispositivo extends JFrame{

	private JPanel contentPane;
	private JTextField textId;
	private JTextField textNombre;
	private JTextField textPrecio;
	private JTextField textMarca;
	private JTextField textFecha_Fabricacion;
	private JTextField textSistemaOperativo;
	
	
	
	public VentanaAgregarDispositivo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNuevoDispositivo = new JLabel("Nuevo Dispositivo");
		lblNuevoDispositivo.setForeground(new Color(255, 165, 0));
		lblNuevoDispositivo.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblNuevoDispositivo.setBounds(106, 45, 230, 39);
		contentPane.add(lblNuevoDispositivo);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNombre.setBounds(32, 137, 88, 32);
		contentPane.add(lblNombre);
		
		textNombre = new JTextField();
		textNombre.setBounds(130, 139, 103, 32);
		contentPane.add(textNombre);
		textNombre.setColumns(10);
		
		JLabel lblMarca = new JLabel("Marca");
		lblMarca.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMarca.setBounds(32, 197, 88, 32);
		contentPane.add(lblMarca);
		
		textMarca = new JTextField();
		textMarca.setColumns(10);
		textMarca.setBounds(130, 199, 103, 32);
		contentPane.add(textMarca);
		
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPrecio.setBounds(32, 258, 88, 32);
		contentPane.add(lblPrecio);
		
		textPrecio = new JTextField();
		textPrecio.setColumns(10);
		textPrecio.setBounds(130, 260, 103, 32);
		contentPane.add(textPrecio);
		
		JLabel lblId = new JLabel("Id");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblId.setBounds(253, 137, 34, 32);
		contentPane.add(lblId);
		
		textId = new JTextField();
		textId.setColumns(10);
		textId.setBounds(297, 139, 47, 32);
		contentPane.add(textId);
		
		JLabel lblSeccion = new JLabel("Seccion");
		lblSeccion.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSeccion.setBounds(32, 313, 88, 32);
		contentPane.add(lblSeccion);
		
		
		JLabel lblFchaFabricacion = new JLabel("Fecha de Fabricacion");
		lblFchaFabricacion.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblFchaFabricacion.setBounds(32, 379, 180, 32);
		contentPane.add(lblFchaFabricacion);
		
		textFecha_Fabricacion = new JTextField();
		textFecha_Fabricacion.setColumns(10);
		textFecha_Fabricacion.setBounds(222, 381, 170, 32);
		contentPane.add(textFecha_Fabricacion);
		
		JLabel lblSistemaOperativo = new JLabel("SistemaOperativo");
		lblSistemaOperativo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSistemaOperativo.setBounds(32, 439, 88, 32);
		contentPane.add(lblSistemaOperativo);
		
		textSistemaOperativo = new JTextField();
		textSistemaOperativo.setColumns(10);
		textSistemaOperativo.setBounds(222, 441, 170, 32);
		contentPane.add(textSistemaOperativo);
		
		String[] opciones = {"Movil","Portatil","Sobremesa","Tablet"};
		JComboBox comboBox = new JComboBox(opciones);
		comboBox.setBounds(130, 319, 147, 25);
		contentPane.add(comboBox);

		
		JButton btnAgregarDispositivo = new JButton("AGREGAR");
		btnAgregarDispositivo.setForeground(Color.WHITE);
		btnAgregarDispositivo.setBackground(new Color(255, 165, 0));
		btnAgregarDispositivo.setBounds(149, 580, 132, 50);
		contentPane.add(btnAgregarDispositivo);
		
		JLabel lblEur = new JLabel("EUR");
		lblEur.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEur.setBounds(243, 258, 41, 32);
		contentPane.add(lblEur);
		
		JButton btnAtras = new JButton("");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaGestionStock vgs = new VentanaGestionStock();
				vgs.setVisible(true);
				dispose();
			}
		});
		btnAtras.setIcon(new ImageIcon("imagenes/iconoAtras.png"));
		btnAtras.setFocusPainted(false);
		btnAtras.setContentAreaFilled(false);
		btnAtras.setBorderPainted(false);
		btnAtras.setBounds(10, 11, 53, 32);
		contentPane.add(btnAtras);
		
		// Boton imagen
				JButton btnImagen = new JButton("Imagen");
				btnImagen.setBounds(168, 510, 93, 29);
				getContentPane().add(btnImagen);
				
				JLabel lblFoto = new JLabel("");
				lblFoto.setBounds(297, 517, 0, 0);
				contentPane.add(lblFoto);

				btnImagen.addActionListener(e -> {
					
						JFileChooser fileChooser = new JFileChooser();
						JFileChooser fc = new JFileChooser();
						fc.setCurrentDirectory(new File(".")); // Abre el directorio raiz de mi proyecto
						// fc.setCurrentDirectory(new File("src")); //Abre la carpeta src de mi proyecto
						int seleccionado = fc.showOpenDialog(null);
						if (seleccionado == JFileChooser.APPROVE_OPTION) {
							File ficheroSeleccionado = fc.getSelectedFile();
							ImageIcon im = new ImageIcon(ficheroSeleccionado.getAbsolutePath());
							im.setDescription(ficheroSeleccionado.getAbsolutePath());
							lblFoto.setIcon(im);
						}
				});

		btnAgregarDispositivo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	String id = textId.getText();
                String nombre = textNombre.getText();
                String Seccion = comboBox.getSelectedItem().toString();
                String marca = textMarca.getText();
                String precio = textPrecio.getText();
                String fecha_Fabricacion = textFecha_Fabricacion.getText();
                String SistemaOperativo = textSistemaOperativo.getText();
                ImageIcon im =(ImageIcon) lblFoto.getIcon();
                String rutaFoto = im.getDescription();
                

                if (Seccion.equals("Movil")) {
                    try {
						DBManager.insertarMovil(id, nombre, Seccion, marca, fecha_Fabricacion, SistemaOperativo, precio, rutaFoto);
					} catch (DBException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
                    VentanaSeccion vs = new VentanaSeccion();
                    vs.setVisible(true);
                    setVisible(false);
                } 


                if (Seccion.equals("Portatil")) {
                    try {
						DBManager.insertarPortatil(id, nombre, Seccion, marca, fecha_Fabricacion, SistemaOperativo, precio, rutaFoto);
					} catch (DBException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
                    VentanaGestionStock vs = new VentanaGestionStock();
                    vs.setVisible(true);
                    setVisible(false);
                } 

                if (Seccion.equals("Sobremesa")) {
                    try {
						DBManager.insertarSobremesa(id, nombre, Seccion, marca, fecha_Fabricacion, SistemaOperativo, precio, rutaFoto);
					} catch (DBException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
                    VentanaGestionStock vs = new VentanaGestionStock();
                    vs.setVisible(true);
                    setVisible(false);
                } 

                if (Seccion.equals("Tablet")) {
                    try {
						DBManager.insertarTablet(id, nombre, Seccion, marca, fecha_Fabricacion, SistemaOperativo, precio, rutaFoto);
					} catch (DBException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
                    VentanaGestionStock vs = new VentanaGestionStock();
                    vs.setVisible(true);
                    setVisible(false);
                }  


            } 
        }); 
	}	
		
	}

