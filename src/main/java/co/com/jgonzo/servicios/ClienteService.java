package co.com.jgonzo.servicios;

import java.util.List;

import javax.ejb.Local;

import co.com.jgonzo.dominio.Cliente;

//Esta Interface la Utiliza la calse de test  ClienteServiceTest
@Local
public interface ClienteService {
	
	public List<Cliente> listarClientes();

	public Cliente encontrarClientePorDocumento(Cliente cliente);

	public Cliente encontrarClientePorNombre(Cliente cliente);

	public void registrarCliente(Cliente cliente);

	public void modificarCliente(Cliente cliente);

	public void eliminarCliente(Cliente cliente);
}
