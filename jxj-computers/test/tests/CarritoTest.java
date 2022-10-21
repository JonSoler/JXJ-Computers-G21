package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import jxj.clasesBasicas.Carrito;
import jxj.excepciones.ExcepcionExplicita;

class CarritoTest {

	private Carrito cdis;
	private Carrito cdis1;

	@BeforeEach
	public void setUp() throws ExcepcionExplicita {
		cdis = new Carrito("03", "2", "10-08-2011", 53);
		cdis1= new Carrito();
	}
		
	@Test
	public void testSetId() {
		cdis.setId("02");
		assertEquals("02", cdis.getId());
	}
			
	@Test
	public void testGetId() {	
		assertEquals("03", cdis.getId());		
	}
	
	@Test
	public void testSetNombre() {
		cdis.setNombre("3");
		assertEquals("3", cdis.getNombre());
	}
			
	@Test
	public void testGetNombre() {	
		assertEquals("2", cdis.getNombre());		
	}
	
	@Test
	public void testSetPrecio() {
		cdis.setPrecio(2000);
		assertEquals(2000, cdis.getPrecio());
	}
			
	@Test
	public void testGetPrecio() {	
		assertEquals(53, cdis.getPrecio());		
	}
	
	@Test
	public void testSetFecha() {
		cdis.setFecha("1-1-2010");
		assertEquals("1-1-2010", cdis.getFecha());
	}
			
	@Test
	public void testGetFecha() {	
		assertEquals("10-08-2011", cdis.getFecha());		
	}
	
	@Test
	public void testToString() {
		assertEquals("Carrito [id=03, nombre=2, fecha=10-08-2011, precio=53.0]"
	    , cdis.toString());
	}
}



