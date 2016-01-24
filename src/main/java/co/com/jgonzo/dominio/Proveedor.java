package co.com.jgonzo.dominio;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the proveedor database table.
 * 
 */
@Entity
@NamedQuery(name = "Proveedor.findAll", query = "SELECT p FROM Proveedor p")
public class Proveedor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String no_documento;

	private String apellido;

	private String direccion;

	private String nombre;

	private String nombre_comercial;

	private String telefono;

	// bi-directional many-to-one association to Articulo
	@OneToMany(mappedBy = "proveedor")
	private List<Articulo> articulos;

	// bi-directional many-to-one association to TipoDeDocumento
	@ManyToOne
	@JoinColumn(name = "cod_tipo_documento")
	private TipoDeDocumento tipoDeDocumento;

	// bi-directional many-to-one association to Ciudad
	@ManyToOne
	@JoinColumn(name = "cod_ciudad")
	private Ciudad ciudad;

	public Proveedor() {
	}

	public Proveedor(String no_documento, String apellido, String direccion, String nombre, String nombre_comercial,
			String telefono, List<Articulo> articulos, TipoDeDocumento tipoDeDocumento, Ciudad ciudad) {
		super();
		this.no_documento = no_documento;
		this.apellido = apellido;
		this.direccion = direccion;
		this.nombre = nombre;
		this.nombre_comercial = nombre_comercial;
		this.telefono = telefono;
		this.articulos = articulos;
		this.tipoDeDocumento = tipoDeDocumento;
		this.ciudad = ciudad;
	}

	public String getNo_documento() {
		return this.no_documento;
	}

	public void setNo_documento(String no_documento) {
		this.no_documento = no_documento;
	}

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre_comercial() {
		return this.nombre_comercial;
	}

	public void setNombre_comercial(String nombre_comercial) {
		this.nombre_comercial = nombre_comercial;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<Articulo> getArticulos() {
		return this.articulos;
	}

	public void setArticulos(List<Articulo> articulos) {
		this.articulos = articulos;
	}

	public Articulo addArticulo(Articulo articulo) {
		getArticulos().add(articulo);
		articulo.setProveedor(this);

		return articulo;
	}

	public Articulo removeArticulo(Articulo articulo) {
		getArticulos().remove(articulo);
		articulo.setProveedor(null);

		return articulo;
	}

	public TipoDeDocumento getTipoDeDocumento() {
		return this.tipoDeDocumento;
	}

	public void setTipoDeDocumento(TipoDeDocumento tipoDeDocumento) {
		this.tipoDeDocumento = tipoDeDocumento;
	}

	public Ciudad getCiudad() {
		return this.ciudad;
	}

	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}

	@Override
	public String toString() {
		return "Proveedor [no_documento=" + no_documento + ", apellido=" + apellido + ", direccion=" + direccion
				+ ", nombre=" + nombre + ", nombre_comercial=" + nombre_comercial + ", telefono=" + telefono
				+ ", articulos=" + articulos + ", tipoDeDocumento=" + tipoDeDocumento + ", ciudad=" + ciudad + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apellido == null) ? 0 : apellido.hashCode());
		result = prime * result + ((articulos == null) ? 0 : articulos.hashCode());
		result = prime * result + ((ciudad == null) ? 0 : ciudad.hashCode());
		result = prime * result + ((direccion == null) ? 0 : direccion.hashCode());
		result = prime * result + ((no_documento == null) ? 0 : no_documento.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((nombre_comercial == null) ? 0 : nombre_comercial.hashCode());
		result = prime * result + ((telefono == null) ? 0 : telefono.hashCode());
		result = prime * result + ((tipoDeDocumento == null) ? 0 : tipoDeDocumento.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Proveedor other = (Proveedor) obj;
		if (apellido == null) {
			if (other.apellido != null)
				return false;
		} else if (!apellido.equals(other.apellido))
			return false;
		if (articulos == null) {
			if (other.articulos != null)
				return false;
		} else if (!articulos.equals(other.articulos))
			return false;
		if (ciudad == null) {
			if (other.ciudad != null)
				return false;
		} else if (!ciudad.equals(other.ciudad))
			return false;
		if (direccion == null) {
			if (other.direccion != null)
				return false;
		} else if (!direccion.equals(other.direccion))
			return false;
		if (no_documento == null) {
			if (other.no_documento != null)
				return false;
		} else if (!no_documento.equals(other.no_documento))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (nombre_comercial == null) {
			if (other.nombre_comercial != null)
				return false;
		} else if (!nombre_comercial.equals(other.nombre_comercial))
			return false;
		if (telefono == null) {
			if (other.telefono != null)
				return false;
		} else if (!telefono.equals(other.telefono))
			return false;
		if (tipoDeDocumento == null) {
			if (other.tipoDeDocumento != null)
				return false;
		} else if (!tipoDeDocumento.equals(other.tipoDeDocumento))
			return false;
		return true;
	}

}