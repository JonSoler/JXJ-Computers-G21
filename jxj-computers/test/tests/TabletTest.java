package tests;


import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import jxj.seccionDisp.Tablet;

public class TabletTest {

	private Tablet t;
	private Tablet t1;
	@Before
	public void setUp() throws Exception {
	
		t= new Tablet("t01","ipad pro","ipad", "apple", "2019-05-13","512 gb","ios","imagen",1450.0,"gris",true,12);
		t1= new Tablet();
	}

	@Test
	public void testSetId() {
		t.setId("1");
		assertEquals("1", t.getId());
	}

	@Test
	public void testSetNombre() {
		t.setNombre("ipad");
		assertEquals("ipad", t.getNombre());
	}
	
	@Test
	public void testGetColor() {	
		assertEquals("gris", t.getColor());
	}
	
	@Test
	public void testSetColor() {	
		t.setColor("negro");
		assertEquals("negro", t.getColor());
	}
	
	@Test
	public void testGetConectividadTeclado() {	
		assertEquals(true, t.isConectividadTeclado());
	}
	
	@Test
	public void testSetConectividadTeclado() {	
		t.setConectividadTeclado(false);
		assertEquals(false, t.isConectividadTeclado());
	}
	
	@Test
	public void testGetPixelesCamara() {	
		assertEquals(12, t.getPixelesCamara());
	}
	
	@Test
	public void testSetPixelesCamara() {	
		t.setPixelesCamara(20);
		assertEquals(20, t.getPixelesCamara());
	}
	
	@Test
	public void testToString() {
		assertEquals("Tablet [color=gris, conectividadTeclado=true, pixelesCamara=12]",t.toString());
	}
	
	
}
