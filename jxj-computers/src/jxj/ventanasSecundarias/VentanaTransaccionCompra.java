package jxj.ventanasSecundarias;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class VentanaTransaccionCompra extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Método que contiene un hilo que salta al a hora de realizar la compra de la
	 * tabla de coches seleccionados
	 * 
	 * @param args
	 */

	private JPanel pCentral;

	/**
	 * Creamos la ventana
	 */
	public VentanaTransaccionCompra() {
		setBounds(800, 300, 400, 100);
		//setLocationRelativeTo(null);
		setTitle("Espera unos segundos mientras se realiza la transacción");
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setIconImage(new ImageIcon("imagenes/Logo.png").getImage());
		pCentral = new JPanel();
		getContentPane().add(pCentral, BorderLayout.CENTER);
		JFrame ventana = this;
		Runnable r = new Runnable() { // objeto ejecutable

			@Override
			public void run() {
				// TODO Auto-generated method stub
				for (int i = 0; i < 5; i++) {
					JLabel lbl = new JLabel(".");
					lbl.setFont(new Font(Font.SERIF, Font.BOLD, 30));
					pCentral.add(lbl);
					getContentPane().validate();
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				ventana.dispose();
				JOptionPane.showMessageDialog(null, "Gracias por su compra, la operación se ha realizado con exito");
			}
		};
		Thread t = new Thread(r); // hilo
		t.start();
		setVisible(true);
	}
}
