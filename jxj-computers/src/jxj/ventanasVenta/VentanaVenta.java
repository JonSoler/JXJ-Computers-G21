package jxj.ventanasVenta;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import jxj.dataBase.DBManager;

public class VentanaVenta extends JFrame {

	private static final long serialVersionUID = 1L;
	private JButton btnAtras;
	public static int idVenta;
	private JPanel panelNorte;
	private JPanel panelCentro;
	private JPanel panelBotonera;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaVenta frame = new VentanaVenta();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public VentanaVenta() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 643, 452);
		getContentPane().setBackground(new Color(245, 245, 245));

		panelNorte = new JPanel();
		panelCentro = new JPanel();
		panelBotonera = new JPanel();
		panelNorte.setLayout(new GridLayout(0, 1));
		panelBotonera.setLayout(new GridLayout(0, 2));

		JLabel v_titulo = new JLabel("Ventas");
		v_titulo.setHorizontalAlignment(SwingConstants.CENTER);
		v_titulo.setForeground(new Color(102, 102, 153));
		v_titulo.setFont(new Font("Cooper Black", Font.PLAIN, 40));
		v_titulo.setBounds(301, 11, 93, 60);
		panelNorte.add(v_titulo);

		JLabel descripcion = new JLabel("Introduce las caracteristicas del dispositivo que quieras vender");
		descripcion.setHorizontalAlignment(SwingConstants.CENTER);
		descripcion.setForeground(new Color(102, 102, 153));
		descripcion.setFont(new Font("Cooper Black", Font.PLAIN, 16));
		descripcion.setBounds(179, 70, 373, 28);
		panelNorte.add(descripcion);

		getContentPane().add(panelNorte, BorderLayout.NORTH);
		panelCentro.setLayout(null);

		JLabel Id = new JLabel("Id");
		Id.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Id.setBounds(37, 50, 93, 34);
		panelCentro.add(Id);
		
		JTextArea textoId = new JTextArea();
		textoId.setTabSize(18);
		textoId.setFont(new Font("Tahoma", Font.BOLD, 11));
		textoId.setBounds(126, 62, 148, 22);
		panelCentro.add(textoId);
		
		JLabel Nombre = new JLabel("Nombre");
		Nombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Nombre.setBounds(37, 96, 93, 34);
		panelCentro.add(Nombre);
		
		JTextArea textoNombre = new JTextArea();
		textoNombre.setTabSize(18);
		textoNombre.setFont(new Font("Tahoma", Font.BOLD, 11));
		textoNombre.setBounds(126, 108, 148, 22);
		panelCentro.add(textoNombre);
		
		JLabel Seccion = new JLabel("Seccion");
		Seccion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Seccion.setBounds(37, 141, 99, 34);
		panelCentro.add(Seccion);

		JLabel Precio = new JLabel("Precio");
		Precio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Precio.setBounds(310, 145, 64, 27);
		panelCentro.add(Precio);
		
		JTextArea textoPrecio = new JTextArea();
		textoPrecio.setFont(new Font("Tahoma", Font.BOLD, 11));
		textoPrecio.setBounds(445, 153, 128, 22);
		panelCentro.add(textoPrecio);

		JLabel euro = new JLabel("€");
		euro.setFont(new Font("Tahoma", Font.PLAIN, 16));
		euro.setBounds(580, 151, 37, 34);
		panelCentro.add(euro);
		
		JLabel FechaF = new JLabel("Fecha fabricacion");
		FechaF.setFont(new Font("Tahoma", Font.PLAIN, 14));
		FechaF.setBounds(310, 50, 111, 34);
		panelCentro.add(FechaF);
		
		JTextPane textoFechaF = new JTextPane();
		textoFechaF.setFont(new Font("Tahoma", Font.BOLD, 11));
		textoFechaF.setBounds(445, 62, 148, 22);
		panelCentro.add(textoFechaF);

		JLabel Marca = new JLabel("Marca");
		Marca.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Marca.setBounds(37, 201, 77, 29);
		panelCentro.add(Marca);
		
		JTextArea textoMarca = new JTextArea();
		textoMarca.setFont(new Font("Tahoma", Font.BOLD, 11));
		textoMarca.setBounds(126, 210, 148, 22);
		panelCentro.add(textoMarca);
		textoMarca.setColumns(10);
		
		JLabel SistemaOP = new JLabel("Sistema Operativo");
		SistemaOP.setFont(new Font("Tahoma", Font.PLAIN, 14));
		SistemaOP.setBounds(310, 96, 122, 34);
		panelCentro.add(SistemaOP);

		JTextArea textoSOP = new JTextArea();
		textoSOP.setFont(new Font("Tahoma", Font.BOLD, 11));
		textoSOP.setText("");
		textoSOP.setBounds(445, 108, 148, 22);
		panelCentro.add(textoSOP);
		textoSOP.setColumns(10);
		
		JLabel Imagen = new JLabel("Imagen");
		Imagen.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Imagen.setBounds(310, 198, 77, 34);
		
		JLabel Foto = new JLabel("");
		Foto.setBounds(37, 282, 0, 0);
		panelCentro.add(Foto);

		panelCentro.add(Imagen);

		// Boton imagen
		JButton btnImagen = new JButton("Imagen");
		btnImagen.setBounds(455, 206, 111, 22);
		panelCentro.add(btnImagen);

		btnImagen.addActionListener(e -> {

			JFileChooser fc = new JFileChooser();
			fc.setCurrentDirectory(new File(".")); 
			//fc.setCurrentDirectory(new File("src"));  carpeta
			int seleccionado = fc.showOpenDialog(null);
			if (seleccionado == JFileChooser.APPROVE_OPTION) {
				File ficheroSeleccionado = fc.getSelectedFile();
				ImageIcon im = new ImageIcon(ficheroSeleccionado.getAbsolutePath());
				im.setDescription(ficheroSeleccionado.getAbsolutePath());
				Foto.setIcon(im);

			}
		});

		String[] opciones = { "Movil", "Portatil", "Sobremesa", "Tablet" };

		JComboBox comboBox_seccion = new JComboBox(opciones);
		comboBox_seccion.setModel(new DefaultComboBoxModel(new String[] {"Movil", "Portatil", "Sobremesa", "Tablet"}));
		panelCentro.add(comboBox_seccion);
		comboBox_seccion.setBounds(126, 149, 148, 22);

		getContentPane().add(panelCentro, BorderLayout.CENTER);
		
				btnAtras = new JButton("Atras");
				panelCentro.add(btnAtras);
				btnAtras.setFont(new Font("Tahoma", Font.PLAIN, 16));
				btnAtras.setBounds(126, 266, 128, 29);
				

				JButton btnGuardar = new JButton("Guardar");
				panelCentro.add(btnGuardar);
				btnGuardar.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						
						if (textoId.getText().equals("") || textoNombre.getText().equals("") || textoPrecio.getText().equals("")
								|| textoFechaF.getText().equals("") || textoSOP.getText().equals("")
								|| textoMarca.getText().equals("")) {
							JOptionPane.showMessageDialog(null, "No puedes dejar campos vacios.");
						} else {
							String id = textoId.getText();
							String nombre = textoNombre.getText();
							String seccion = comboBox_seccion.getSelectedItem().toString();
							String marca = textoPrecio.getText();
							String precio = textoFechaF.getText();
							String fecha_fabricacion = textoSOP.getText();
							String sistemaOperativo = textoMarca.getText();
							ImageIcon im = (ImageIcon) Foto.getIcon();
							String rutaFoto = im.getDescription();

							if (seccion.equals("Movil")) {
								DBManager.insertarMovil(id, nombre, seccion, marca, fecha_fabricacion, sistemaOperativo,
										precio, rutaFoto);
								
							}

							if (seccion.equals("Portatil")) {
								DBManager.insertarPortatil(id, nombre, seccion, marca, fecha_fabricacion, sistemaOperativo,
										precio, rutaFoto);
								
							}

							if (seccion.equals("Sobremesa")) {
								DBManager.insertarSobremesa(id, nombre, seccion, marca, fecha_fabricacion, sistemaOperativo,
										precio, rutaFoto);
								
							}

							if (seccion.equals("Tablet")) {
								DBManager.insertarTablet(id, nombre, seccion, marca, fecha_fabricacion, sistemaOperativo,
										precio, rutaFoto);
								
							}

							JOptionPane.showMessageDialog(null, "Se ha registrado tu venta correctamente");
						}
					}
				});
				btnGuardar.setFont(new Font("Tahoma", Font.PLAIN, 16));
				btnGuardar.setBounds(395, 266, 128, 29);
				
						btnAtras.addActionListener(e -> {
						});
		getContentPane().add(panelBotonera, BorderLayout.SOUTH);

	}

	
	public static int getVentaId() {
		return idVenta;
	}
}