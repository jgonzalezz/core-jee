package co.com.jgonzo.dominio;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;

/**
 * The persistent class for the detalle_factura database table.
 * 
 */
@Entity
@Table(name = "detalle_factura")
@NamedQuery(name = "DetalleFactura.findAll", query = "SELECT d FROM DetalleFactura d")
public class DetalleFactura implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private DetalleFacturaPK id;

	private int cantidad;

	private BigDecimal total;

	// bi-directional many-to-one association to Articulo
	@ManyToOne
	@JoinColumn(name = "cod_articulo")
	private Articulo articulo;

	// bi-directional many-to-one association to Factura
	@ManyToOne
	@JoinColumn(name = "cod_factura")
	private Factura factura;

	public DetalleFactura() {
	}

	public DetalleFactura(DetalleFacturaPK id, int cantidad, BigDecimal total, Articulo articulo, Factura factura) {
		super();
		this.id = id;
		this.cantidad = cantidad;
		this.total = total;
		this.articulo = articulo;
		this.factura = factura;
	}

	public DetalleFactura(int cantidad, BigDecimal total, Articulo articulo, Factura factura) {
		super();
		this.cantidad = cantidad;
		this.total = total;
		this.articulo = articulo;
		this.factura = factura;
	}

	public DetalleFacturaPK getId() {
		return this.id;
	}

	public void setId(DetalleFacturaPK id) {
		this.id = id;
	}

	public int getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public BigDecimal getTotal() {
		return this.total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public Articulo getArticulo() {
		return this.articulo;
	}

	public void setArticulo(Articulo articulo) {
		this.articulo = articulo;
	}

	public Factura getFactura() {
		return this.factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}

	@Override
	public String toString() {
		return "DetalleFactura [id=" + id + ", cantidad=" + cantidad + ", total=" + total + ", articulo=" + articulo
				+ ", factura=" + factura + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((articulo == null) ? 0 : articulo.hashCode());
		result = prime * result + cantidad;
		result = prime * result + ((factura == null) ? 0 : factura.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((total == null) ? 0 : total.hashCode());
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
		DetalleFactura other = (DetalleFactura) obj;
		if (articulo == null) {
			if (other.articulo != null)
				return false;
		} else if (!articulo.equals(other.articulo))
			return false;
		if (cantidad != other.cantidad)
			return false;
		if (factura == null) {
			if (other.factura != null)
				return false;
		} else if (!factura.equals(other.factura))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (total == null) {
			if (other.total != null)
				return false;
		} else if (!total.equals(other.total))
			return false;
		return true;
	}

}