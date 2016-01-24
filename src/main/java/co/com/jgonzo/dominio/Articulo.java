package co.com.jgonzo.dominio;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the articulo database table.
 * 
 */
@Entity
@NamedQueries({@NamedQuery(name="Articulo.findAll",query="SELECT a FROM Articulo a ORDER BY a.idArticulo")})
public class Articulo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_articulo")
	private int idArticulo;

	private String descripcion;

	@Column(name = "fecha_ingreso")
	private String fechaIngreso;

	@Column(name = "precio_costo")
	private int precioCosto;

	@Column(name = "precio_venta")
	private int precioVenta;

	private int stock;

	// bi-directional many-to-one association to Proveedor
	@ManyToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "cod_proveedor")
	private Proveedor proveedor;

	// bi-directional many-to-one association to TipoArticulo
	@ManyToOne
	@JoinColumn(name = "cod_tipo_articulo")
	private TipoArticulo tipoArticulo;

	// bi-directional many-to-one association to DetalleFactura
	@OneToMany(mappedBy = "articulo")
	private List<DetalleFactura> detalleFacturas;

	public Articulo() {
	}

	public Articulo(int idArticulo, String descripcion, String fechaIngreso, int precioCosto, int precioVenta,
			int stock, Proveedor proveedor, TipoArticulo tipoArticulo, List<DetalleFactura> detalleFacturas) {
		super();
		this.idArticulo = idArticulo;
		this.descripcion = descripcion;
		this.fechaIngreso = fechaIngreso;
		this.precioCosto = precioCosto;
		this.precioVenta = precioVenta;
		this.stock = stock;
		this.proveedor = proveedor;
		this.tipoArticulo = tipoArticulo;
		this.detalleFacturas = detalleFacturas;
	}

	public Articulo(String descripcion, String fechaIngreso, int precioCosto, int precioVenta, int stock,
			Proveedor proveedor, TipoArticulo tipoArticulo, List<DetalleFactura> detalleFacturas) {
		super();
		this.descripcion = descripcion;
		this.fechaIngreso = fechaIngreso;
		this.precioCosto = precioCosto;
		this.precioVenta = precioVenta;
		this.stock = stock;
		this.proveedor = proveedor;
		this.tipoArticulo = tipoArticulo;
		this.detalleFacturas = detalleFacturas;
	}

	public int getIdArticulo() {
		return this.idArticulo;
	}

	public void setIdArticulo(int idArticulo) {
		this.idArticulo = idArticulo;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getFechaIngreso() {
		return this.fechaIngreso;
	}

	public void setFechaIngreso(String fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public int getPrecioCosto() {
		return this.precioCosto;
	}

	public void setPrecioCosto(int precioCosto) {
		this.precioCosto = precioCosto;
	}

	public int getPrecioVenta() {
		return this.precioVenta;
	}

	public void setPrecioVenta(int precioVenta) {
		this.precioVenta = precioVenta;
	}

	public int getStock() {
		return this.stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public Proveedor getProveedor() {
		return this.proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	public TipoArticulo getTipoArticulo() {
		return this.tipoArticulo;
	}

	public void setTipoArticulo(TipoArticulo tipoArticulo) {
		this.tipoArticulo = tipoArticulo;
	}

	public List<DetalleFactura> getDetalleFacturas() {
		return this.detalleFacturas;
	}

	public void setDetalleFacturas(List<DetalleFactura> detalleFacturas) {
		this.detalleFacturas = detalleFacturas;
	}

	public DetalleFactura addDetalleFactura(DetalleFactura detalleFactura) {
		getDetalleFacturas().add(detalleFactura);
		detalleFactura.setArticulo(this);

		return detalleFactura;
	}

	public DetalleFactura removeDetalleFactura(DetalleFactura detalleFactura) {
		getDetalleFacturas().remove(detalleFactura);
		detalleFactura.setArticulo(null);

		return detalleFactura;
	}

	@Override
	public String toString() {
		return "Articulo [idArticulo=" + idArticulo + ", descripcion=" + descripcion + ", fechaIngreso=" + fechaIngreso
				+ ", precioCosto=" + precioCosto + ", precioVenta=" + precioVenta + ", stock=" + stock + ", proveedor="
				+ proveedor + ", tipoArticulo=" + tipoArticulo + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + ((detalleFacturas == null) ? 0 : detalleFacturas.hashCode());
		result = prime * result + ((fechaIngreso == null) ? 0 : fechaIngreso.hashCode());
		result = prime * result + idArticulo;
		result = prime * result + precioCosto;
		result = prime * result + precioVenta;
		result = prime * result + ((proveedor == null) ? 0 : proveedor.hashCode());
		result = prime * result + stock;
		result = prime * result + ((tipoArticulo == null) ? 0 : tipoArticulo.hashCode());
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
		Articulo other = (Articulo) obj;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (detalleFacturas == null) {
			if (other.detalleFacturas != null)
				return false;
		} else if (!detalleFacturas.equals(other.detalleFacturas))
			return false;
		if (fechaIngreso == null) {
			if (other.fechaIngreso != null)
				return false;
		} else if (!fechaIngreso.equals(other.fechaIngreso))
			return false;
		if (idArticulo != other.idArticulo)
			return false;
		if (precioCosto != other.precioCosto)
			return false;
		if (precioVenta != other.precioVenta)
			return false;
		if (proveedor == null) {
			if (other.proveedor != null)
				return false;
		} else if (!proveedor.equals(other.proveedor))
			return false;
		if (stock != other.stock)
			return false;
		if (tipoArticulo == null) {
			if (other.tipoArticulo != null)
				return false;
		} else if (!tipoArticulo.equals(other.tipoArticulo))
			return false;
		return true;
	}

}