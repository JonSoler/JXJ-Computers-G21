package jxj.seccionDisp;

public class Movil extends Dispositivo {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private boolean tactil;
	private String sensorReconocimiento;
	private int bateria;

	public Movil(String id, String nombre, String seccion, String marca, String fecha_fabricacion,
			String sistemaOperativo, String rutaFoto, double precio, boolean tactil, String sensorReconocimiento,
			int bateria) {

		this.tactil = tactil;
		this.sensorReconocimiento = sensorReconocimiento;
		this.bateria = bateria;
	}

	public Movil() {
		super();
		this.tactil = false;
		this.sensorReconocimiento = " ";
		this.bateria = 0;

	}

	public boolean isTactil() {
		return tactil;
	}

	public void setTactil(boolean tactil) {
		this.tactil = tactil;
	}

	public String getSensorReconocimiento() {
		return sensorReconocimiento;
	}

	public void setSensorReconocimiento(String sensorReconocimiento) {
		this.sensorReconocimiento = sensorReconocimiento;
	}

	public int getBateria() {
		return bateria;
	}

	public void setBateria(int bateria) {
		this.bateria = bateria;
	}

	@Override
	public String toString() {
		//return "Movil [tactil=" + tactil + ", sensorReconocimiento=" + sensorReconocimiento + ", bateria=" + bateria
		//		+ "]";
		return getNombre() + " " + getPrecio() + " €";
	}

}
