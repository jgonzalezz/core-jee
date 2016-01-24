package co.com.jgonzo.dao;

import java.util.List;

import co.com.jgonzo.dominio.Articulo;


public interface ArticuloDao {
	
public List<Articulo> findAllArticulos();
	
	public Articulo findArticuloById(Articulo articulo);
	
	public Articulo findArticuloByDescripcion(Articulo articulo);
	
	public void insertArticulo(Articulo articulo);
	
	public void updateArticulo(Articulo articulo);
	
	public void deleteArticulo(Articulo articulo);

}
