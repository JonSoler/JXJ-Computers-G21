package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import jxj.clasesBasicas.Administrador;

class AdministradorTest {

	private Administrador admin;

	@BeforeEach
	public void setUp() {
		admin = new Administrador(01, "x.g", "02", "x@gmail.com", "xabier", "garai", "12", "1", "2", "2");
	}

	@Test
	public void testSetAdminUsuario() {
		admin.setAdminUsuario("100");
		assertEquals("100", admin.getAdminUsuario());
	}

	@Test
	public void testGetAdminUsuario() {
		assertEquals("12", admin.getAdminUsuario());
	}

	@Test
	public void testSetAdminInterfaz() {
		admin.setAdminInterfaz("23");
		assertEquals("23", admin.getAdminInterfaz());
	}

	@Test
	public void testGetAdminInterfaz() {
		assertEquals("1", admin.getAdminInterfaz());
	}

	@Test
	public void testSetAdminVerificar() {
		admin.setAdminVerificar("30");
		assertEquals("30", admin.getAdminVerificar());
	}

	@Test
	public void testGetAdminVerificar() {
		assertEquals("2", admin.getAdminVerificar());
	}

	@Test
	public void testSetAdminRecuperacion() {
		admin.setAdminRecuperacion("5");
		assertEquals("5", admin.getAdminRecuperacion());
	}

	@Test
	public void testGetAdminRecuperacion() {
		assertEquals("2", admin.getAdminRecuperacion());
	}

	@Test
	public void testToString() {
		assertEquals("Administrador [AdminUsuario=12, AdminInterfaz=1, AdminVerificar=2, AdminRecuperacion=2]",
				admin.toString());
	}
}
