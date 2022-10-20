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
	private Usuario u4;

	
	@Before
	public void setup() {
		 u=new Usuario("Xabier", "Garai", "x.garai", "123", "xabier.garai@opendeusto.es");
		 u1=new Usuario();
		 u2 = new Usuario("xg", "12", "xg@gmail.com");
		 u3 =new Usuario(01,"Xabier");
		 u4 = new Usuario("Xabier", "Garai", "x.garai", "123", "xabier.garai@opendeusto.es");
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
	public void testGetNombre() {
		assertEquals("Xabier", u.getNombre());
	}
	
	@Test
	public void testSetNombre() {
		u.setNombre("Xabi");
		assertEquals("Xabi", u.getNombre());
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
	public void testGetContrasenia() {
		assertEquals("123", u.getContrasenia());
	}
	
	@Test
	public void testSetContrasenia() {
		u.setContrasenia("321");
		assertEquals("321", u.getContrasenia());
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
	public void testGetId() {
		assertEquals(01, u3.getId());
	}
	
	@Test
	public void testSetId() {
		u3.setId(02);
		assertEquals(02, u3.getId());
	}
	
	@Test
	public void testToString() {
		assertEquals("   Nombre: Xabier | Usuario: x.garai | Contraseña: 123", u.toString());
	}

}
