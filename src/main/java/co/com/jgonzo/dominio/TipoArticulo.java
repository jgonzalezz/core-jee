package co.com.jgonzo.dominio;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipo_articulo database table.
 * 
 */
@Entity
@Table(name="tipo_articulo")
@NamedQuery(name="TipoArticulo.findAll", query="SELECT t FROM TipoArticulo t")
public class TipoArticulo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_tipoarticulo")
	private int idTipoarticulo;

	@Column(name="descripcion_articulo")
	private String descripcionArticulo;

	//bi-directional many-to-one association to Articulo
	@OneToMany(mappedBy="tipoArticulo")
	private List<Articulo> articulos;

	public TipoArticulo() {
	}

	public int getIdTipoarticulo() {
		return this.idTipoarticulo;
	}

	public void setIdTipoarticulo(int idTipoarticulo) {
		this.idTipoarticulo = idTipoarticulo;
	}

	public String getDescripcionArticulo() {
		return this.descripcionArticulo;
	}

	public void setDescripcionArticulo(String descripcionArticulo) {
		this.descripcionArticulo = descripcionArticulo;
	}

	public List<Articulo> getArticulos() {
		return this.articulos;
	}

	public void setArticulos(List<Articulo> articulos) {
		this.articulos = articulos;
	}

	public Articulo addArticulo(Articulo articulo) {
		getArticulos().add(articulo);
		articulo.setTipoArticulo(this);

		return articulo;
	}

	public Articulo removeArticulo(Articulo articulo) {
		getArticulos().remove(articulo);
		articulo.setTipoArticulo(null);

		return articulo;
	}

}