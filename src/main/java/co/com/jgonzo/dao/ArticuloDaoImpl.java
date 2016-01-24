package co.com.jgonzo.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import co.com.jgonzo.dominio.Articulo;

@Stateless
public class ArticuloDaoImpl implements ArticuloDao {

	@PersistenceContext(unitName = "core-jee")
	EntityManager em;

	@SuppressWarnings("unchecked")
	public List<Articulo> findAllArticulos() {

		return em.createNamedQuery("Articulo.findAll").getResultList();
	}

	public Articulo findArticuloById(Articulo articulo) {
		Query query = em.createQuery("from Articulo a where a.id_articulo = :id_articulo");
		return (Articulo) query.getSingleResult();
	}

	public Articulo findArticuloByDescripcion(Articulo articulo) {
		Query query = em.createQuery("from Articulo a where a.descripcion = :descripcion");
		return (Articulo) query.getSingleResult();
	}

	public void insertArticulo(Articulo articulo) {
		em.persist(articulo);
	}

	public void updateArticulo(Articulo articulo) {
		em.merge(articulo);
	}

	public void deleteArticulo(Articulo articulo) {
		em.merge(articulo);
		em.remove(articulo);
	}

}
