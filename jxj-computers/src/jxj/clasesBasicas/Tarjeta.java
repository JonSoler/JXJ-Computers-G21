package jxj.clasesBasicas;

public class Tarjeta {

	private String tipo,numeroTarjeta,fecha,codigoDeSeguridad,nombreTarjeta,nombreCompleto,direccion,lineaSegundaDireccion,ciudad,estadoProvincia,codigoPostal;	
	private int idUsuario,idTarjeta;

	public Tarjeta(String tipo, String numeroTarjeta, String fecha, String codigoDeSeguridad, String nombreTarjeta,
			String nombreCompleto, String direccion, String lineaSegundaDireccion, String ciudad,
			String estadoProvincia, String codigoPostal, int idUsuario) {

		super();
		this.tipo = tipo;
		this.numeroTarjeta = numeroTarjeta;
		this.fecha = fecha;
		this.codigoDeSeguridad = codigoDeSeguridad;
		this.nombreTarjeta = nombreTarjeta;
		this.nombreCompleto = nombreCompleto;
		this.direccion = direccion;
		this.lineaSegundaDireccion = lineaSegundaDireccion;
		this.ciudad = ciudad;
		this.estadoProvincia = estadoProvincia;
		this.codigoPostal = codigoPostal;
		this.idUsuario = idUsuario;
	}

	public Tarjeta() {
		super();
		this.tipo = "";
		this.numeroTarjeta = "";
		this.fecha = "";
		this.codigoDeSeguridad = "";
		this.nombreTarjeta = "";
		this.nombreCompleto = "";
		this.direccion = "";
		this.lineaSegundaDireccion = "";
		this.ciudad = "";
		this.estadoProvincia = "";
		this.codigoPostal = "";
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNumeroTarjeta() {
		return numeroTarjeta;
	}

	public void setNumeroTarjeta(String numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getCodigoDeSeguridad() {
		return codigoDeSeguridad;
	}

	public void setCodigoDeSeguridad(String codigoDeSeguridad) {
		this.codigoDeSeguridad = codigoDeSeguridad;
	}

	public String getNombreTarjeta() {
		return nombreTarjeta;
	}

	public void setNombreTarjeta(String nombreTarjeta) {
		this.nombreTarjeta = nombreTarjeta;
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getLineaSegundaDireccion() {
		return lineaSegundaDireccion;
	}

	public void setLineaSegundaDireccion(String lineaSegundaDireccion) {
		this.lineaSegundaDireccion = lineaSegundaDireccion;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getEstadoProvincia() {
		return estadoProvincia;
	}

	public void setEstadoProvincia(String estadoProvincia) {
		this.estadoProvincia = estadoProvincia;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public int getidUsuario() {
		return idUsuario;
	}

	public void setidUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public int getidTarjeta() {
		return idTarjeta;
	}

	public void setidTarjeta(int idTarjeta) {
		this.idTarjeta = idTarjeta;
	}

}

