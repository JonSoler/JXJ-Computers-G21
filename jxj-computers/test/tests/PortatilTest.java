package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import jxj.seccionDisp.Portatil;

public class PortatilTest {

	private Portatil p;

	@Before
	public void setUp() throws Exception {

		p = new Portatil("01", "mac pro", "mac", "apple", "2020-05-13", "ios", "imagen", 1450.0, true, "Keyboard Pro",
				"multi-tactil");
	}

	@Test
	public void testSetId() {
		p.setId("01");
		assertEquals("01", p.getId());
	}

	@Test
	public void testSetNombre() {
		p.setNombre("hp chromebook");
		assertEquals("hp chromebook", p.getNombre());
	}

	@Test
	public void testGetWebcam() {
		assertEquals(true, p.isWebcam());
	}

	@Test
	public void testSetWebcam() {
		p.setWebcam(false);
		assertEquals(false, p.isWebcam());
	}

	@Test
	public void testGetTipoTeclado() {
		assertEquals("Keyboard Pro", p.getTipoTeclado());
	}

	@Test
	public void testSetTipoTeclado() {
		p.setTipoTeclado("teclado ergonomico");
		assertEquals("teclado ergonomico", p.getTipoTeclado());
	}

	@Test
	public void testGetTouchpad() {
		assertEquals("multi-tactil", p.getTouchpad());
	}

	@Test
	public void testSetTouchpad() {
		p.setTouchpad("panel tactil");
		assertEquals("panel tactil", p.getTouchpad());
	}

	@Test
	public void testToString() {
		assertEquals("Portatil [webcam=true, tipoTeclado=Keyboard Pro, touchpad=multi-tactil]", p.toString());
	}
}
