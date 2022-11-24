package jxj.clasesBasicas;


public class Carrito {

	private String id, nombre, fecha;
	private double precio;
	
	public Carrito(String id, String nombre, String fecha, double precio) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.fecha = fecha;
		this.precio = precio;
	}
	
	public Carrito() {
		super();
		this.id = " ";
		this.nombre = " ";
		this.fecha = " ";
		this.precio = 0.0;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Carrito [id=" + id + ", nombre=" + nombre + ", fecha=" + fecha + ", precio=" + precio + "]";
	}

}
