package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import jxj.excepciones.ExcepcionExplicita;
import jxj.seccionDisp.Dispositivo;

public class DispositivoTest {

	private Dispositivo dis;
	private Dispositivo dis1;
	
	@Before
	 void setUp() throws Exception {
		try {
			dis = new Dispositivo("01","iphone 12","movil", "apple", "2020-05-15", "ios", "imagenes", null, 1500.0,null);
		} catch (ExcepcionExplicita e) {
			
			e.printStackTrace();
		}	
		 dis1= new Dispositivo();
	}

	@Test
	 void testDispositivo() {
		assertThrows(ExcepcionExplicita.class, ()->{new Dispositivo("01","iphone 14","14", "apple", "2000-04-19", "ios", "imagenes", null, 1500.0,null);});
		assertThrows(AssertionError.class, ()-> {
		assertThrows(ExcepcionExplicita.class, () -> {	
				new Dispositivo("01","iphone 12","movil", "apple", "2017-04-19", "ios", "imagenes", null, 1500.0,null);
			});
							
		});
	}

	@Test
	void testGetId() {
		assertEquals("01", dis.getId());
	}
	@Test
	void testSetId() {
		dis.setId("02");
		assertEquals("02", dis.getId());		
	}
	
	@Test
	void testGetNombre() {
		assertEquals("iphone 12 ", dis.getNombre());
	}
	
	@Test
	void testSetNombre() {
		dis.setNombre("13");
		assertEquals("13", dis.getNombre());		
	}
	@Test
	void testGetSeccion() {
		assertEquals("movil", dis.getSeccion());
	}
	
	@Test
	void testSetSeccion() {
		dis.setSeccion("14");;
		assertEquals("14", dis.getSeccion());		
	}
	
	@Test
	void testGetMarca() {
		assertEquals("apple", dis.getMarca());
	}
	
	@Test
	void testSetMarca() {
		dis.setMarca("samsung");;
		assertEquals("samsung", dis.getMarca());		
	}
	
	@Test
	void testGetFecha_fabricacion() {
		assertEquals("2020-05-15", dis.getFecha_fabricacion());
	}
	
	@Test
	void testSetFecha_fabricacion() {
		dis.setFecha_fabricacion("2015-06-20");;
		assertEquals("2015-06-20", dis.getFecha_fabricacion());		
	}
	
	@Test
	void testGetSistemaOperativo() {
		assertEquals("ios", dis.getSistemaOperativo());
	}
	
	@Test
	void testSetSistemaOperativo() {
		dis.setSistemaOperativo("android");
		assertEquals("android", dis.getSistemaOperativo());		
	}
	
	@Test
	void testGetPrecio() {
		assertEquals(1500, dis.getPrecio());
	}

	@Test
	void testSetPrecio() {
		dis.setPrecio(1000);
		assertEquals(1000, dis.getPrecio());
	}
	@Test
	void testGetRutaFoto() {
		assertEquals("imagen", dis.getRutaFoto());
	}
	
	@Test
	void testSetRutaFoto() {
		dis.setRutaFoto("imagen1");
		assertEquals("imagen1", dis.getRutaFoto());
	}
	
	@Test
	void testToString() {
		assertEquals("Dispositivo [id=01, nombre=iphone 12, seccion=movil, marca=apple, fecha_fabricacion=2020-05-15, sistema operativo=ios, precio=1500.0, rutaFoto=imagen]", dis.toString());
	}
	
	
}
