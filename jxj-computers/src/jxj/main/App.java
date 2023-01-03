package jxj.main;

import java.awt.EventQueue;
import java.util.logging.Logger;

import jxj.main.App;
import jxj.ventanasPrimarias.VentanaInicio;

public class App {

	public static Logger logger = Logger.getLogger(App.class.getName());

	public static void main(String[] args) {

		logger.info("Programa comenzado");

		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					jxj.dataBase.DBManager.usarCrearTablasBD();
					VentanaInicio vi = new VentanaInicio();
					vi.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});

	}

}
