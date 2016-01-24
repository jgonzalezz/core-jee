package co.com.jgonzo.servicios;

import java.util.List;

import javax.ejb.Remote;

import co.com.jgonzo.dominio.Articulo;
import co.com.jgonzo.dominio.Cliente;
//Esta interface la utiliza la clase de prueba ClienteArticuloServiceRemote
@Remote
public interface ClienteServiceRemote {
	
	public List<Cliente> listarClientes();

	public Cliente encontrarClientePorDocumento(Cliente cliente);

	public Cliente encontrarClientePorNombre(Cliente cliente);

	public void registrarCliente(Cliente cliente);

	public void modificarCliente(Cliente cliente);

	public void eliminarCliente(Cliente cliente);

}
