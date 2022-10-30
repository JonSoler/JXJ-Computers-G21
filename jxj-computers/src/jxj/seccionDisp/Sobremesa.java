package jxj.seccionDisp;

public class Sobremesa extends Dispositivo{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String fuenteAlimentacion;
	private String ventilador;
	private int numPuertosUSB;
	
	public Sobremesa(String id, String nombre, String seccion, String marca, String fecha_fabricacion, String memoria,
			String sistemaOperativo, String rutaFoto, double precio, String fuenteAlimentacion, String ventilador, int numPuertosUSB)  {
		
		this.fuenteAlimentacion = fuenteAlimentacion;
		this.ventilador = ventilador;
		this.numPuertosUSB = numPuertosUSB;
	}
	
	public Sobremesa() {
		super();
		this.fuenteAlimentacion = " ";
		this.ventilador = " ";
		this.numPuertosUSB = 0;
	}

	public String getFuenteAlimentacion() {
		return fuenteAlimentacion;
	}

	public void setFuenteAlimentacion(String fuenteAlimentacion) {
		this.fuenteAlimentacion = fuenteAlimentacion;
	}

	public String getVentilador() {
		return ventilador;
	}

	public void setVentilador(String ventilador) {
		this.ventilador = ventilador;
	}

	public int getNumPuertosUSB() {
		return numPuertosUSB;
	}

	public void setNumPuertosUSB(int numPuertosUSB) {
		this.numPuertosUSB = numPuertosUSB;
	}

	@Override
	public String toString() {
		return "Sobremesa [fuenteAlimentacion=" + fuenteAlimentacion + ", ventilador=" + ventilador + ", numPuertosUSB="
				+ numPuertosUSB + "]";
	}
	
	
}
