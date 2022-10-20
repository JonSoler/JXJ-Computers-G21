package jxj.clasesBasicas;

public class Administrador extends Usuario {

	private String AdminUsuario, AdminInterfaz, AdminVerificar, AdminRecuperacion;

	public Administrador(int id, String nombre, String apellidos, String usuario, String contrasenia, String email,
			String adminUsuario, String adminInterfaz, String adminVerificar, String adminRecuperacion) {
		super(id, nombre, apellidos, usuario, contrasenia, email);
		AdminUsuario = adminUsuario;
		AdminInterfaz = adminInterfaz;
		AdminVerificar = adminVerificar;
		AdminRecuperacion = adminRecuperacion;
	}
	
	public Administrador() {
		super();
		this.AdminUsuario = " ";
		this.AdminInterfaz = " ";
		this.AdminVerificar = " ";
		this.AdminRecuperacion = " ";
	}

	public String getAdminUsuario() {
		return AdminUsuario;
	}

	public void setAdminUsuario(String adminUsuario) {
		AdminUsuario = adminUsuario;
	}

	public String getAdminInterfaz() {
		return AdminInterfaz;
	}

	public void setAdminInterfaz(String adminInterfaz) {
		AdminInterfaz = adminInterfaz;
	}

	public String getAdminVerificar() {
		return AdminVerificar;
	}

	public void setAdminVerificar(String adminVerificar) {
		AdminVerificar = adminVerificar;
	}

	public String getAdminRecuperacion() {
		return AdminRecuperacion;
	}

	public void setAdminRecuperacion(String adminRecuperacion) {
		AdminRecuperacion = adminRecuperacion;
	}

	@Override
	public String toString() {
		return "Administrador [AdminUsuario=" + AdminUsuario + ", AdminInterfaz=" + AdminInterfaz + ", AdminVerificar="
				+ AdminVerificar + ", AdminRecuperacion=" + AdminRecuperacion + "]";
	}
}
