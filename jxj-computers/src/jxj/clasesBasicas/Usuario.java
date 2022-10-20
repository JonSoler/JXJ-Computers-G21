package jxj.clasesBasicas;

public class Usuario {

	private int id;
	private String nombre;
	private String apellidos;
	private String usuario;
	private String contrasenia;
	private String email;
	
	
	public Usuario(int id, String nombre, String apellidos, String usuario, String contrasenia, String email) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.usuario = usuario;
		this.contrasenia = contrasenia;
		this.email = email;
		
	}
	
	public Usuario(String nombre, String apellidos, String usuario, String contrasenia, String email) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.usuario = usuario;
		this.contrasenia = contrasenia;
		this.email = email;
		
	}
	
	public Usuario(String usuario, String contrasenia, String email) {
		super();
		this.usuario = usuario;
		this.contrasenia = contrasenia;
		this.email = email;
		
	}
	
	public Usuario(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
		
	}
	
	public Usuario() {
		super();
		this.id = 0;
		this.nombre = "";
		this.apellidos = "";
		this.usuario = "";
		this.contrasenia = "";
		this.email = "";
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "   Nombre: "+nombre+ " | Usuario: " + usuario+ " | Contraseña: " + contrasenia;
	}
	
	
}
