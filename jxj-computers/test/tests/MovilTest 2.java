package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import jxj.seccionDisp.Movil;

public class MovilTest {

	private Movil m;
	
	@Before
	public void setUp() throws Exception {
	
		m= new Movil("m01","iphone 13","iphone", "apple", "2021-05-13","ios","imagen",1400.0,true,"facial",100);
	}

	@Test
	public void testSetId() {
		m.setId("1");
		assertEquals("1", m.getId());
	}

	@Test
	public void testSetNombre() {
		m.setNombre("mac");
		assertEquals("mac", m.getNombre());
	}
	@Test
	public void testGetTactil() {	
		assertEquals(true, m.isTactil());
	}
	
	@Test
	public void testSetTactil() {	
		m.setTactil(false);
		assertEquals(false, m.isTactil());
	}
	
	@Test
	public void testGetSensorReconocimiento() {	
		assertEquals("facial", m.getSensorReconocimiento());
	}
	
	@Test
	public void testSetSensorReconocimiento() {	
		m.setSensorReconocimiento("ocular");
		assertEquals("ocular", m.getSensorReconocimiento());
	}

	@Test
	public void testGetBateria() {	
		assertEquals(100, m.getBateria());
	}
	
	@Test
	public void testSetBateria() {	
		m.setBateria(50);
		assertEquals(50, m.getBateria());
	}
	
	@Test
	public void testToString() {
		assertEquals("Movil [tactil=true, sensorReconocimiento=facial, bateria=100]", m.toString());
	}
	
}
