package co.com.jgonzo.cliente;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import co.com.jgonzo.dominio.Articulo;
import co.com.jgonzo.servicios.ArticuloServiceRemote;
//video 23
//CLiente Remoto: Se va a conectar via JNDi a nuestro servidor y va solicitar una instancia de nuestro ejb ArticuloServiceImpl.java
public class ClienteArticuloServiceRemoto {
	public static void main(String[] args) {

		System.out.println("Inciando llamada al EJB desde el cliente\n");

		// conexion JNDI verificar dependiendo del servidor de aplicaciones como
		// se implementa(GlassFish)
		try {
			Context jndi = new InitialContext();
			ArticuloServiceRemote articuloServiceRemote = (ArticuloServiceRemote) jndi
					.lookup("java:global/core-jee/ArticuloServiceImpl!co.com.jgonzo.servicios.ArticuloServiceRemote");

			List<Articulo> articulos = articuloServiceRemote.listarArticulos();

			for (Articulo articulo : articulos) {

				// Solo con tener el metodo toString en la clase persona podemos
				// pasar solo el objeto persona
				System.out.println(articulo);
			}

			System.out.println("\nFin llamada al EJB desde el Cliente");

		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
