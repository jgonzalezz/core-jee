package co.com.jgonzo.servicios;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import co.com.jgonzo.dao.ArticuloDao;
import co.com.jgonzo.dominio.Articulo;

@Stateless
public class ArticuloServiceImpl implements ArticuloService , ArticuloServiceRemote {

	@EJB
	private ArticuloDao articuloDao;

	public List<Articulo> listarArticulos() {

		return articuloDao.findAllArticulos();
	}

	public Articulo encontrArticuloPorId(Articulo articulo) {

		return articuloDao.findArticuloById(articulo);
	}

	public Articulo encontrarArticuloPorDescripcion(Articulo articulo) {

		return articuloDao.findArticuloByDescripcion(articulo);
	}

	public void registrarArticulo(Articulo articulo) {

		articuloDao.insertArticulo(articulo);
	}

	public void modificarArticulo(Articulo articulo) {
		articuloDao.updateArticulo(articulo);

	}

	public void eliminaraAticulo(Articulo articulo) {
		articuloDao.deleteArticulo(articulo);

	}

}
