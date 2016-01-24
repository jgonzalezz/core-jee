package co.com.jgonzo.servicios;

import java.util.List;

import javax.ejb.Local;

import co.com.jgonzo.dominio.Articulo;

//Esta Interface la Utiliza la calse de test  ArticuloServiceTest
@Local
public interface ArticuloService {
	
	public List<Articulo> listarArticulos();

	public Articulo encontrArticuloPorId(Articulo articulo);

	public Articulo encontrarArticuloPorDescripcion(Articulo articulo);

	public void registrarArticulo(Articulo articulo);

	public void modificarArticulo(Articulo articulo);

	public void eliminaraAticulo(Articulo articulo);

}
