package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*; 

import org.junit.Before;
import org.junit.Test;


import jxj.excepciones.ExcepcionExplicita;
import jxj.seccionDisp.Dispositivo;

public class DispositivoTest {

	private Dispositivo dis;
	private Dispositivo dis1;
	
	@Before
	 public void setUpDispositivo() {
		try {
			dis = new Dispositivo("01","iphone 12","movil", "apple", "2020-05-15", "ios", "imagenes", 1.500);
		} catch (ExcepcionExplicita e) {
			
			e.printStackTrace();
		}	
		 dis1= new Dispositivo();
	}

	@Test
	 public void testDispositivo() {
		assertThrows(ExcepcionExplicita.class, ()->{new Dispositivo("01","iphone 14","14", "apple", "2000-04-19", "ios", "imagenes", 1.500);});
		assertThrows(AssertionError.class, ()-> {
		assertThrows(ExcepcionExplicita.class, () -> {	
				new Dispositivo("01","iphone 12","movil", "apple", "2017-04-19", "ios", "imagenes", 1.500);
			});
							
		});
	}

	@Test
	public void testGetId() {
		assertEquals("01", dis.getId());
	}
	@Test
	public void testSetId() {
		dis.setId("02");
		assertEquals("02", dis.getId());		
	}
	
	@Test
	public void testGetNombre() {
		assertEquals("iphone 12", dis.getNombre());
	}
	
	@Test
	public void testSetNombre() {
		dis.setNombre("13");
		assertEquals("13", dis.getNombre());		
	}
	@Test
	public void testGetSeccion() {
		assertEquals("movil", dis.getSeccion());
	}
	
	@Test
	public void testSetSeccion() {
		dis.setSeccion("14");;
		assertEquals("14", dis.getSeccion());		
	}
	
	@Test
	public void testGetMarca() {
		assertEquals("apple", dis.getMarca());
	}
	
	@Test
	public void testSetMarca() {
		dis.setMarca("samsung");;
		assertEquals("samsung", dis.getMarca());		
	}
	
	@Test
	public void testGetFecha_fabricacion() {
		assertEquals("2020-05-15", dis.getFecha_fabricacion());
	}
	
	@Test
	public void testSetFecha_fabricacion() {
		dis.setFecha_fabricacion("2015-06-20");;
		assertEquals("2015-06-20", dis.getFecha_fabricacion());		
	}
	
	@Test
	public void testGetSistemaOperativo() {
		assertEquals("ios", dis.getSistemaOperativo());
	}
	
	@Test
	public void testSetSistemaOperativo() {
		dis.setSistemaOperativo("android");
		assertEquals("android", dis.getSistemaOperativo());		
	}
	
	@Test
	public void testGetPrecio() {
		assertEquals(1.500, dis.getPrecio());
	}

	@Test
	public void testSetPrecio() {
		dis.setPrecio(1000);
		assertEquals(1.000, dis.getPrecio());
	}
	@Test
	public void testGetRutaFoto() {
		assertEquals("imagenes", dis.getRutaFoto());
	}
	
	@Test
	public void testSetRutaFoto() {
		dis.setRutaFoto("imagen1");
		assertEquals("imagen1", dis.getRutaFoto());
	}
	
	@Test
	public void testToString() {
		assertEquals("Dispositivo [id=01, nombre=iphone 12, seccion=movil, marca=apple, fecha_fabricacion=2020-05-15, sistemaOperativo=ios, rutaFoto=imagenes, precio=1.5]", dis.toString());
	}
	
	
}
