package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import jxj.excepciones.ExcepcionExplicita;
import jxj.clasesBasicas.ListaDispositivo;
import jxj.seccionDisp.Dispositivo;

class ListaDispositivoTest {

	ListaDispositivo listaDisp = new ListaDispositivo();
	Map<Integer, Dispositivo> listaD = listaDisp.getDispositivos();
	private Dispositivo disp;

	@Before
	public void setUp() {
		listaD.put(01, disp);
		listaD.get(01);
		try {
			disp = new Dispositivo("01", "Samsung Z4", "Tablet", "Samsung", "2020-03-10", "Windows", 2.000, "imagenes");

		} catch (ExcepcionExplicita e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testGetDispositivos() {
		assertNotEquals(null, listaDisp.getDispositivos());
	}

	@Test
	public void testSetCoches() {
		listaDisp.setProductos(listaD);
		assertNotNull(listaDisp.getDispositivos());
	}
}
