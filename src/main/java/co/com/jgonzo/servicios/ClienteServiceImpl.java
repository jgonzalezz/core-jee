package co.com.jgonzo.servicios;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import co.com.jgonzo.dao.ClienteDao;
import co.com.jgonzo.dominio.Cliente;

@Stateless
public class ClienteServiceImpl implements ClienteService,ClienteServiceRemote {

	@EJB
	private ClienteDao clienteDao;

	@Override
	public List<Cliente> listarClientes() {
		return clienteDao.findAllClientes();
	}
	
	@Override
	public Cliente encontrarClientePorDocumento(Cliente cliente) {
		return clienteDao.findClienteByDocument(cliente);
	}

	@Override
	public Cliente encontrarClientePorNombre(Cliente cliente) {
		return clienteDao.findClienteByName(cliente);
	}

	@Override
	public void registrarCliente(Cliente cliente) {
		clienteDao.insertCliente(cliente);
	}

	@Override
	public void modificarCliente(Cliente cliente) {
		clienteDao.updateCliente(cliente);
	}

	@Override
	public void eliminarCliente(Cliente cliente) {
		clienteDao.deleteCliente(cliente);
	}

}
