package jxj.seccionDisp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import jxj.excepciones.ExcepcionExplicita;

public class Dispositivo implements Serializable {

	private String id, nombre, seccion, marca, fecha_fabricacion, sistemaOperativo, rutaFoto;
	private double precio;
	
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	public Dispositivo(String id, String nombre, String seccion, String marca, String fecha_fabricacion,
			String sistemaOperativo, String rutaFoto, double precio) throws ExcepcionExplicita {
		super();
		this.id = id;
		this.nombre = nombre;
		this.seccion = seccion;
		this.marca = marca;
		this.fecha_fabricacion = fecha_fabricacion;
		try {
			Date f = sdf.parse(fecha_fabricacion);
			Date fechaLimite = sdf.parse("2000-01-01");
			if(f.before(fechaLimite))
				throw new ExcepcionExplicita("Es un dispositivo demasiado antiguo");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.sistemaOperativo = sistemaOperativo;
		this.rutaFoto = rutaFoto;
		this.precio = precio;
		
	}
	
	public Dispositivo() {
		super();
		this.id = " ";
		this.nombre = " ";
		this.seccion = " ";
		this.marca = " ";
		this.fecha_fabricacion = " ";
		this.sistemaOperativo = " ";
		this.rutaFoto = " ";
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

	public String getSeccion() {
		return seccion;
	}

	public void setSeccion(String seccion) {
		this.seccion = seccion;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getFecha_fabricacion() {
		return fecha_fabricacion;
	}

	public void setFecha_fabricacion(String fecha_fabricacion) {
		this.fecha_fabricacion = fecha_fabricacion;
	}

	public String getSistemaOperativo() {
		return sistemaOperativo;
	}

	public void setSistemaOperativo(String sistemaOperativo) {
		this.sistemaOperativo = sistemaOperativo;
	}

	public String getRutaFoto() {
		return rutaFoto;
	}

	public void setRutaFoto(String rutaFoto) {
		this.rutaFoto = rutaFoto;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public SimpleDateFormat getSdf() {
		return sdf;
	}

	

	@Override
	public String toString() {
		return "Dispositivo [id=" + id + ", nombre=" + nombre + ", seccion=" + seccion + ", marca=" + marca
				+ ", fecha_fabricacion=" + fecha_fabricacion + ", sistemaOperativo=" + sistemaOperativo + ", rutaFoto="
				+ rutaFoto + ", precio=" + precio + "]";
	}
	
}
