package tests;

import static org.junit.jupiter.api.Assertions.*;

	import java.util.ArrayList;
	
	import org.junit.Assert;
	import org.junit.jupiter.api.Test;
	
	import jxj.clasesBasicas.ListaUsuario;
	import jxj.clasesBasicas.Usuario;	
	
		class ListaUsuarioTest {		
			ListaUsuario listaUsuario = new ListaUsuario();
			private ArrayList<Usuario> usuarios;
			ArrayList<Usuario> lista = listaUsuario.getUsuarios();
					
			
			@Test
			public void testmyArray() {
				ListaUsuarioTest test = new ListaUsuarioTest();
			    Assert.assertNotNull("no deberia ser null", test);
								
			}
			
			@Test
			public void testSetUsuarios() {
				listaUsuario.setUsuarios(lista);
				assertNotNull(listaUsuario.getUsuarios());
			}
		
}
