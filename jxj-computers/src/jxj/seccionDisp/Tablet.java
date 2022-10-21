package jxj.seccionDisp;

public class Tablet extends Dispositivo {
	
	private String color;
	private boolean conectividadTeclado;
	private int pixelesCamara;
	
	public Tablet(String id, String nombre, String seccion, String marca, String fecha_fabricacion, String memoria,
			String sistemaOperativo, String rutaFoto, double precio, String color,
			boolean conectividadTeclado, int pixelesCamara) {
		
		this.color = color;
		this.conectividadTeclado = conectividadTeclado;
		this.pixelesCamara = pixelesCamara;
	}
	
	public Tablet() {
		super();
		this.color = " ";
		this.conectividadTeclado = false;
		this.pixelesCamara = 0;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public boolean isConectividadTeclado() {
		return conectividadTeclado;
	}

	public void setConectividadTeclado(boolean conectividadTeclado) {
		this.conectividadTeclado = conectividadTeclado;
	}

	public int getPixelesCamara() {
		return pixelesCamara;
	}

	public void setPixelesCamara(int pixelesCamara) {
		this.pixelesCamara = pixelesCamara;
	}

	@Override
	public String toString() {
		return "Tablet [color=" + color + ", conectividadTeclado=" + conectividadTeclado + ", pixelesCamara="
				+ pixelesCamara + "]";
	}
	
}
