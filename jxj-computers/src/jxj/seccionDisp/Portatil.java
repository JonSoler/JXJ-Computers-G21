package jxj.seccionDisp;

public class Portatil extends Dispositivo{
	
	public boolean webcam;
	public String tipoTeclado;
	public String touchpad;
	
	



	public Portatil(String id, String nombre, String seccion, String marca, String fecha_fabricacion, String memoria,
			String sistemaOperativo, String rutaFoto, double precio, boolean webcam,
			String tipoTeclado, String touchpad)  {
		
		this.webcam = webcam;
		this.tipoTeclado = tipoTeclado;
		this.touchpad = touchpad;
	}

	public Portatil() {
		super();
		this.webcam = false;
		this.tipoTeclado = " ";
		this.touchpad = " ";
	}

	

	public boolean isWebcam() {
		return webcam;
	}

	public void setWebcam(boolean webcam) {
		this.webcam = webcam;
	}

	public String getTipoTeclado() {
		return tipoTeclado;
	}

	public void setTipoTeclado(String tipoTeclado) {
		this.tipoTeclado = tipoTeclado;
	}

	public String getTouchpad() {
		return touchpad;
	}

	public void setTouchpad(String touchpad) {
		this.touchpad = touchpad;
	}

	public static void main(String[] args) {

	}

	@Override
	public String toString() {
		return "Portatil [webcam=" + webcam + ", tipoTeclado=" + tipoTeclado + ", touchpad=" + touchpad + "]";
	}
	
	
}
