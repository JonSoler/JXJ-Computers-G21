package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import jxj.seccionDisp.Sobremesa;

public class SobremesaTest {

	private Sobremesa sm;
	
	@Before
	public void setUp() throws Exception {
		sm= new Sobremesa("sm01","msi mag meta 5","sobremesa", "msi", "2021-05-13","1 tb","windows 11","imagen",1600.0,"500 W 80 plus bronze","ventilador cpu",4);
	}

	@Test
	public void testSetId() {
		sm.setId("sm01");
		assertEquals("sm01", sm.getId());
	}

	@Test
	public void testSetNombre() {
		sm.setNombre("meta 5");
		assertEquals("meta 5", sm.getNombre());
	}
	
	@Test
	public void testGetFuenteAlimentacion() {	
		assertEquals("500 W 80 plus bronze", sm.getFuenteAlimentacion());
	}
	
	@Test
	public void testSetFuenteAlimentacion() {	
		sm.setFuenteAlimentacion("300 W 80 plus ");
		assertEquals("300 W 80 plus ", sm.getFuenteAlimentacion());
	}
	
	@Test
	public void testGetVentilador() {	
		assertEquals("ventilador cpu", sm.getVentilador());
	}
	
	@Test
	public void testSetVentilador() {	
		sm.setVentilador("ventilador");
		assertEquals("ventilador",sm.getVentilador());
	}
	
	@Test
	public void testGetnumPuertosUSB() {	
		assertEquals(4, sm.getNumPuertosUSB());
	}
	
	@Test
	public void testSetnumPuertosUSB() {	
		sm.setNumPuertosUSB(7);
		assertEquals(7, sm.getNumPuertosUSB());
	}
	
	@Test
	public void testToString() {
		assertEquals("Sobremesa [fuenteAlimentacion=500 W 80 plus bronze, ventilador=ventilador cpu, numPuertosUSB=4]", sm.toString());
	}
}
