package jxj.excepciones;

/**
 * Utilizamos esta clase para hacer que la fecha de fabricaci�n no pueda ser
 * menor al a�o 2000. Esta fecha seria demasiado antigua para poder poner a la
 * venta en nuestra aplicaci�n.
 *
 */

public class ExcepcionExplicita extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String mensaje;

	public ExcepcionExplicita(String m) {
		mensaje = m;
	}

	public String toString() {
		return mensaje;
	}

}
