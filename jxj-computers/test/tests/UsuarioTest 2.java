package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import jxj.clasesBasicas.Usuario;

public class UsuarioTest {
	
	private Usuario u;
	private Usuario u1;	
	private Usuario u2;
	private Usuario u3;

	
	@Before
	public void setup() {
		 u=new Usuario("Xabier", "Garai", "x.garai", "123", "xabier.garai@opendeusto.es");
		 u1 = new Usuario("xg", "12", "xg@gmail.com");
		 u2 =new Usuario(01,"Xabier");
		 u3 = new Usuario("Jon", "Soler", "JSoler", "qwerty", "jon.soler@opendeusto.es");
	}				

		
	@Test
	public void testGetNomUsuario() {
		assertEquals("x.garai", u.getUsuario());
	}
	
	@Test
	public void testSetNomUsuario() {
		u.setUsuario("Xabi00");
		assertEquals("Xabi00", u.getUsuario());
	}
	
	@Test
	public void testGetNomUsuario1() {
		assertEquals("xg", u1.getUsuario());
	}
	
	@Test
	public void testSetNomUsuario1() {
		u1.setUsuario("XG0");
		assertEquals("XG0", u1.getUsuario());
	}
	
	@Test
	public void testGetNomUsuario2() {
		assertEquals("JSoler", u3.getUsuario());
	}
	
	@Test
	public void testSetNomUsuario2() {
		u3.setUsuario("JonSoler99");
		assertEquals("JonSoler99", u3.getUsuario());
	}
	
	@Test
	public void testGetNombre() {
		assertEquals("Xabier", u.getNombre());
	}
	
	@Test
	public void testSetNombre() {
		u.setNombre("Xabi");
		assertEquals("Xabi", u.getNombre());
	}
	
	@Test
	public void testGetNombre1() {
		assertEquals("Jon", u3.getNombre());
	}
	
	@Test
	public void testSetNombre1() {
		u3.setNombre("JON");
		assertEquals("JON", u3.getNombre());
	}
				
	@Test
	public void testgetApellidos() {
		assertEquals("Garai", u.getApellidos());
	}
	
	@Test
	public void testSetApellidos() {
		u.setApellidos("Garai");
		assertEquals("Garai", u.getApellidos());
	}
	
	@Test
	public void testgetApellidos1() {
		assertEquals("Soler", u3.getApellidos());
	}
	
	@Test
	public void testSetApellidos1() {
		u3.setApellidos("SOLER");
		assertEquals("SOLER", u3.getApellidos());
	}
	
	@Test
	public void testGetContrasenia() {
		assertEquals("123", u.getContrasenia());
	}
	
	@Test
	public void testSetContrasenia() {
		u.setContrasenia("321");
		assertEquals("321", u.getContrasenia());
	}
	
	@Test
	public void testGetContrasenia1() {
		assertEquals("12", u1.getContrasenia());
	}
	
	@Test
	public void testSetContrasenia1() {
		u1.setContrasenia("22");
		assertEquals("22", u1.getContrasenia());
	}
	
	@Test
	public void testGetContrasenia2() {
		assertEquals("qwerty", u3.getContrasenia());
	}
	
	@Test
	public void testSetContrasenia2() {
		u3.setContrasenia("123456");
		assertEquals("123456", u3.getContrasenia());
	}
	
	@Test
	public void testGetEmail() {
		assertEquals("xabier.garai@opendeusto.es", u.getEmail());
	}
	
	@Test
	public void testSetEmail() {
		u.setEmail("xabigarai@opendeusto.es");
		assertEquals("xabigarai@opendeusto.es", u.getEmail());
	}
	
	@Test
	public void testGetEmail1() {
		assertEquals("jon.soler@opendeusto.es", u3.getEmail());
	}
	
	@Test
	public void testSetEmail1() {
		u3.setEmail("jonsoler@opendeusto.es");
		assertEquals("jonsoler@opendeusto.es", u3.getEmail());
	}
	
	@Test
	public void testGetId() {
		assertEquals(01, u2.getId());
	}
	
	@Test
	public void testSetId() {
		u2.setId(02);
		assertEquals(02, u2.getId());
	}
	
	@Test
	public void testToString() {
		assertEquals("   Nombre: Xabier | Usuario: x.garai | Contraseña: 123", u.toString());
	}

}
