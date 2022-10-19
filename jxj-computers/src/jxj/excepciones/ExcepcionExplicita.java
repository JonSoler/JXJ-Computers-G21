package jxj.excepciones;

/**
 * Utilizamos esta clase para hacer que la fecha de fabricación no pueda ser menor al año 2000. Esta
 * fecha seria demasiado antigua para poder poner a la venta en nuestra aplicación.
 *
 */

public class ExcepcionExplicita extends Exception{
	
	private String mensaje;
	
	public ExcepcionExplicita(String m) {
		mensaje = m;
	}
	
	public String toString() {
		return mensaje;
	}

}

