package jxj.ventanasPrimarias;



public class Hilo extends Thread{
	
	public void run() {
		while (true) {
			String texto = VentanaCarritoCompra.lblPremium.getText();
			char primercaracter = texto.charAt(0);
			String textoNuevo = texto.substring(1)+String.valueOf(primercaracter);
			VentanaCarritoCompra.lblPremium.setText(textoNuevo);
			try {
				sleep(600);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}