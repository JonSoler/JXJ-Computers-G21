package jxj.ventanasPrimarias;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import jxj.seccionDisp.*;
import jxj.clasesBasicas.ListaDispositivo;
import jxj.dataBase.DBException;
import jxj.dataBase.DBManager;
import jxj.seccionDisp.Dispositivo;
import jxj.ventanasSecundarias.VentanaPago;


	public class VentanaCarritoCompra extends JFrame {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private JFrame frame;
		private JPanel tablePanel;
		private JTable carritoTabla;
		private DefaultTableModel carritoModeloTabla;
		private JLabel lblTotal;
		public static JLabel lblPremium;
		private double precioTotal;


		/**
		 * Launch the application.
		 */
		public static void main() {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						VentanaCarritoCompra window = new VentanaCarritoCompra(null);
						window.frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}

		

		/**
		 * Create the frame
		 */

		public VentanaCarritoCompra() {
			initialize();
		}

		public VentanaCarritoCompra(ListaDispositivo Dispositivos) {
			this.precioTotal = 0;
			lblTotal = new JLabel();
			initTablePanel(VentanaSeccion.carrito);
			initialize();
		}

		private void initTablePanel(ArrayList<Dispositivo> carrito) {
			tablePanel = new JPanel(new GridLayout());
			tablePanel.setBounds(10, 81, 360, 241);

			initTableModel(carrito);

			carritoTabla = new JTable();
			carritoTabla.setModel(carritoModeloTabla);
			tablePanel.add(carritoTabla);

			carritoTabla.getColumnModel().getColumn(0).setMaxWidth(40);
			carritoTabla.getColumnModel().getColumn(1).setMaxWidth(100);
			carritoTabla.getColumnModel().getColumn(2).setMaxWidth(140);
			carritoTabla.getColumnModel().getColumn(3).setMaxWidth(80);
			
			
			// Añadimos el Renderer a la tabla
			carritoTabla.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {

				/**
				 * 
				 */
				private static final long serialVersionUID = 1L;

				@Override
				public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
						boolean hasFocus, int row, int column) {
					Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
					if (column == 0) {
						c.setBackground(Color.LIGHT_GRAY);
					} else {
						c.setBackground(Color.WHITE);
					}

					// Cuando tengo que aplicar el cambio a toda la fila, compruebo
					// si se cumple la condición en el DefaultTableModel (carritoModeloTabla)
					double precio = (double) carritoModeloTabla.getValueAt(row, 3);
					if (precio < 8000) {
						c.setForeground(Color.BLUE);
					} else {
						c.setForeground(Color.BLACK);
					}
					return c;
				}
			});

			JScrollPane js = new JScrollPane(carritoTabla);
			tablePanel.add(js);
		}

		/**
		 * Initialize the contents of the frame.
		 */
		@SuppressWarnings("unchecked")
		private void initialize() {
			frame = new JFrame();
			frame.setBounds(100, 100, 400, 750);
			frame.setTitle("JXJ Computers");
			frame.getContentPane().setLayout(null);
			updatePrecioTotal();
			lblTotal.setBounds(14, 527, 360, 16);
			frame.getContentPane().add(lblTotal);
		
			JButton btnVaciarCesta = new JButton("Vaciar cesta");
			btnVaciarCesta.setBounds(90, 349, 212, 29);
			btnVaciarCesta.addActionListener(e -> {
				while (carritoModeloTabla.getRowCount() != 0)
					carritoModeloTabla.removeRow(0);
				while (!VentanaSeccion.carrito.isEmpty()) {
					VentanaSeccion.carrito.remove(0);
				}
			});
			frame.getContentPane().add(btnVaciarCesta);

			JButton btnGuardarLista = new JButton("Guardar lista");
			btnGuardarLista.setBounds(90, 378, 212, 29);
			btnGuardarLista.addActionListener(e -> {

				if (carritoModeloTabla.getRowCount() != 0) {
					try {
						DBManager.insetarCarrito(carritoModeloTabla.getDataVector());
					} catch (SQLException | DBException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}

				JOptionPane.showMessageDialog(null, "Compra guardada correctamente");
				dispose();

			});
			frame.getContentPane().add(btnGuardarLista);

			JButton btnSeguirComprando = new JButton("Seguir comprando");
			btnSeguirComprando.setBounds(90, 407, 212, 29);
			frame.getContentPane().add(btnSeguirComprando);
			btnSeguirComprando.addActionListener(e -> {
				frame.dispose();

			});

			lblPremium = new JLabel("*Gastos de envio gratis");
			lblPremium.setBounds(199, 475, 145, 29);
			frame.getContentPane().add(lblPremium);
			
			Hilo h = new Hilo();
	        h.start();

			JCheckBox chckbxContratoTarifa = new JCheckBox("Contratar tarifa premium");
			chckbxContratoTarifa.setBounds(176, 526, 188, 23);
			frame.getContentPane().add(chckbxContratoTarifa);

			JButton btnRealizarPedido = new JButton("REALIZAR PEDIDO");
			btnRealizarPedido.setBackground(new Color(255, 165, 0));
			btnRealizarPedido.setBounds(90, 569, 188, 29);
			frame.getContentPane().add(btnRealizarPedido);
			btnRealizarPedido.addActionListener(e -> {
				// TODO Auto-generated method stub
				VentanaPago vp = new VentanaPago();
				setVisible(false);
				vp.setVisible(true);
			});

			frame.getContentPane().add(tablePanel);

			JLabel lblResumenCompra = new JLabel("Resumen Compra");
			lblResumenCompra.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 40));
			lblResumenCompra.setBounds(63, 28, 261, 43);
			frame.getContentPane().add(lblResumenCompra);

			JButton btnGuardarFichero = new JButton("Guardar fichero");
			btnGuardarFichero.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
					    int respuesta = JOptionPane.showConfirmDialog(null, "Quieres guardar el carrito en el fichero?", "Confirmacion", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
	                    if(respuesta == JOptionPane.YES_OPTION) {
	                    	// Crea un documento en blanco
	                    	PrintWriter pw = new PrintWriter("Carrito.txt");
	                        escribirProductosEnFichero(0, carritoModeloTabla, pw);
	                        pw.close();
	        				JOptionPane.showMessageDialog(null, "Fichero guardado correctamente");
	                    }else if (respuesta == JOptionPane.NO_OPTION) {                      	
	                    }else if (respuesta == JOptionPane.CLOSED_OPTION) {                    	
	                    }
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} 

				}

			});
			btnGuardarFichero.setBounds(90, 437, 212, 25);
			frame.getContentPane().add(btnGuardarFichero);
			
			JLabel lblCostesGratis = new JLabel("Sin costes adicionales:");
			lblCostesGratis.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblCostesGratis.setBounds(10, 482, 179, 14);
			frame.getContentPane().add(lblCostesGratis);
		}
		
		private void initTableModel(ArrayList<Dispositivo> carrito) {
			carritoModeloTabla = new DefaultTableModel();
			carritoModeloTabla.addColumn("Id");
			carritoModeloTabla.addColumn("Nombre");
			carritoModeloTabla.addColumn("Fecha de matriculacion");
			carritoModeloTabla.addColumn("Precio (�)");
			setTableContent(carrito);

		}
		
		public void setTableContent(ArrayList<Dispositivo> carrito) {
			clear();
			System.out.println(carrito);
			for (Dispositivo Dispositivo : carrito) {
				this.carritoModeloTabla.addRow(new Object[] { Dispositivo.getId(), Dispositivo.getNombre(),
						Dispositivo.getFecha_fabricacion(), Dispositivo.getPrecio() });
				precioTotal += Dispositivo.getPrecio();
			}
			updatePrecioTotal();
			/*
			 * Hilo que hace que los productos se pongan en oferta a las 18:04:00 y que
			 * dejen de estar en oferta a las 18:05:00
			 */
			Runnable r1 = new Runnable() {

				@Override
				public void run() {
					// TODO Auto-generated method stub
					SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yy hh:mm:ss");

					boolean fin = false;
					while (fin == false) {
						long milis = System.currentTimeMillis();
						Date d = new Date(milis);
						String f = sdf.format(d);
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						// if(f.equals("30-11-21 15:55:00")) {
						// if(d.getMinutes() == 53) && d.getSeconds()==0) {
						if (d.getHours() == 19 && d.getMinutes() == 30 && d.getSeconds() == 0) {
							try {
								DBManager.ponerMovilEnOferta();
								setTableContent(carrito);

								fin = true;
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}

					fin = false;
					while (fin == false) {
						long milis = System.currentTimeMillis();
						Date d = new Date(milis);
						String f = sdf.format(d);
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						// if(f.equals("30-11-21 15:55:00")) {
						// if(d.getMinutes() == 53) && d.getSeconds()==0) {
						if (d.getHours() == 20 && d.getMinutes() == 30 && d.getSeconds() == 0) {
							try {
								DBManager.seAcabaLaOferta();
								setTableContent(carrito);

								fin = true;
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
				}
			};

		
		}
		private void escribirProductosEnFichero(int fila, DefaultTableModel carritoModeloTabla, PrintWriter pw) {
			if (fila < carritoModeloTabla.getRowCount()) {
				String id = (String) carritoModeloTabla.getValueAt(fila, 0);
				String nom = (String) carritoModeloTabla.getValueAt(fila, 1);
				Double precio = (Double) carritoModeloTabla.getValueAt(fila, 3);
				String fecha = (String) carritoModeloTabla.getValueAt(fila, 2);
				pw.println(id + " " + nom + " " + precio + " " + fecha);
				escribirProductosEnFichero(fila + 1, carritoModeloTabla, pw);
			}
		}
		

		public void clear() {
			this.precioTotal = 0;
			this.carritoModeloTabla.setRowCount(0);
			updatePrecioTotal();
		}
		

		/**
		 * Se suman los precios de los dispositivos que se encuentran en la tabla
		 */

		private void updatePrecioTotal() {
			this.lblTotal.setText("TOTAL:   " + this.precioTotal + " �");
		}	


}
