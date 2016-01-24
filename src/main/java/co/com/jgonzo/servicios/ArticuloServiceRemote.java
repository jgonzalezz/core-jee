package co.com.jgonzo.servicios;

import java.util.List;

import javax.ejb.Remote;

import co.com.jgonzo.dominio.Articulo;
//Esta interface la utiliza la clase de prueba ClienteArticuloServiceRemote
@Remote
public interface ArticuloServiceRemote {
	
	public List<Articulo> listarArticulos();

	public Articulo encontrArticuloPorId(Articulo articulo);

	public Articulo encontrarArticuloPorDescripcion(Articulo articulo);

	public void registrarArticulo(Articulo articulo);

	public void modificarArticulo(Articulo articulo);

	public void eliminaraAticulo(Articulo articulo);

}
