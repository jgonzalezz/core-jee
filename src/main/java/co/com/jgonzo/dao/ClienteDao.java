package co.com.jgonzo.dao;

import java.util.List;

import co.com.jgonzo.dominio.Cliente;


public interface ClienteDao {
	
    public List<Cliente> findAllClientes();
	
	public Cliente findClienteByDocument(Cliente cliente);
	
	public Cliente findClienteByName(Cliente cliente);
	
	public void insertCliente(Cliente cliente);
	
	public void updateCliente(Cliente cliente);
	
	public void deleteCliente(Cliente cliente);

}
