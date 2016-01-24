package co.com.jgonzo.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import co.com.jgonzo.dominio.Cliente;

@Stateless
public class ClienteDaoImpl implements ClienteDao {

	@PersistenceContext(unitName = "core-jee")
	EntityManager em;

	@SuppressWarnings("unchecked")
	public List<Cliente> findAllClientes() {
		return em.createNamedQuery("Cliente.findAll").getResultList();
	}
	
	public Cliente findClienteByDocument(Cliente cliente) {
		Query query = em.createQuery("from Cliente a where a.documento = :documento");
		return (Cliente) query.getSingleResult();
	}

	public Cliente findClienteByName(Cliente cliente) {
		Query query = em.createQuery("from Cliente a where a.nombres = :nombres");
		return (Cliente) query.getSingleResult();
	}

	public void insertCliente(Cliente cliente) {
		em.persist(cliente);
	}

	public void updateCliente(Cliente cliente) {
		em.merge(cliente);
	}

	public void deleteCliente(Cliente cliente) {
		em.merge(cliente);
		em.remove(cliente);
	}
}
