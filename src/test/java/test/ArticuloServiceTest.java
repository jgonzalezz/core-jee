package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.ejb.embeddable.EJBContainer;

import org.junit.Before;
import org.junit.Test;

import co.com.jgonzo.dominio.Articulo;
import co.com.jgonzo.servicios.ArticuloService;

public class ArticuloServiceTest {
	//test

	private ArticuloService articuloService;

	/**
	 * @throws Exception
	 *             Inicializar Contenedor Embebido
	 */
	@Before
	public void setUp() throws Exception {

		//Contenedor embebido de glassfisch   - Es un servidor que se usa para pruebas
		EJBContainer contenedor = EJBContainer.createEJBContainer();
		articuloService = (ArticuloService) contenedor.getContext()
				.lookup("java:global/classes/ArticuloServiceImpl!co.com.jgonzo.servicios.ArticuloService");
	}
	
	//@Test
	public void testEJBArticuloService(){
		System.out.println("Iniciand test EJB ArticuloService");
		
		assertTrue(articuloService != null);
		
		// 12 igual al numero de registros que esxisten en la base de datos
		assertEquals(12,articuloService.listarArticulos().size());
		
		System.out.println("El # de Articulos es igual a:" + articuloService.listarArticulos().size());
		
		this.desplegarArticulos(articuloService.listarArticulos());
		System.out.println("Fin test EJB ArticuloService ");
		
	}

	// metodo para mostrar en consola las personas de la lista
	private void desplegarArticulos(List<Articulo> listarArticulos) {
		for (Articulo articulo : listarArticulos) {
			System.out.println(articulo);
		}
		
	}
	

}
