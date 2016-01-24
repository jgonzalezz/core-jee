package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.ejb.embeddable.EJBContainer;

import org.junit.Before;
import org.junit.Test;

import co.com.jgonzo.dominio.Cliente;
import co.com.jgonzo.servicios.ClienteService;

public class ClienteServiceTest {
	//test

	private ClienteService clienteService;

	/**
	 * @throws Exception
	 *             Inicializar Contenedor Embebido
	 */
	@Before
	public void setUp() throws Exception {

		//Contenedor embebido de glassfisch   - Es un servidor que se usa para pruebas
		EJBContainer contenedor = EJBContainer.createEJBContainer();
		clienteService = (ClienteService) contenedor.getContext()
				.lookup("java:global/classes/ClienteServiceImpl!co.com.jgonzo.servicios.ClienteService");
	}
	
	@Test
	public void testEJBClienteService(){
		System.out.println("Iniciand test EJB ClienteService");
		
		assertTrue(clienteService != null);
		
		// 12 igual al numero de registros que esxisten en la base de datos
		assertEquals(38,clienteService.listarClientes().size());
		
		System.out.println("El # de Clienbtes es igual a:" + clienteService.listarClientes().size());
		
		this.desplegarClientes(clienteService.listarClientes());
		System.out.println("Fin test EJB ClienteService ");
		
	}

	// metodo para mostrar en consola las personas de la lista
	private void desplegarClientes(List<Cliente> listarClientes) {
		for (Cliente cliente : listarClientes) {
			System.out.println(cliente);
		}
		
	}
	

}
