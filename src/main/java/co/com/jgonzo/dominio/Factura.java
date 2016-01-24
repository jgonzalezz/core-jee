package co.com.jgonzo.dominio;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

/**
 * The persistent class for the factura database table.
 * 
 */
@Entity
@NamedQuery(name = "Factura.findAll", query = "SELECT f FROM Factura f")
public class Factura implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String nnm_factura;

	private String fecha_facturacion;

	private BigDecimal iva;

	private String nombre_empleado;

	@Column(name = "total_factura")
	private BigDecimal totalFactura;

	// bi-directional many-to-one association to DetalleFactura
	@OneToMany(mappedBy = "factura")
	private List<DetalleFactura> detalleFacturas;

	// bi-directional many-to-one association to Cliente
	@ManyToOne
	@JoinColumn(name = "cod_cliente")
	private Cliente cliente;

	// bi-directional many-to-one association to FormaDePago
	@ManyToOne
	@JoinColumn(name = "cod_formapago")
	private FormaDePago formaDePago;

	public Factura() {
	}

	public Factura(String nnm_factura, String fecha_facturacion, BigDecimal iva, String nombre_empleado,
			BigDecimal totalFactura, List<DetalleFactura> detalleFacturas, Cliente cliente, FormaDePago formaDePago) {
		super();
		this.nnm_factura = nnm_factura;
		this.fecha_facturacion = fecha_facturacion;
		this.iva = iva;
		this.nombre_empleado = nombre_empleado;
		this.totalFactura = totalFactura;
		this.detalleFacturas = detalleFacturas;
		this.cliente = cliente;
		this.formaDePago = formaDePago;
	}

	public String getNnm_factura() {
		return this.nnm_factura;
	}

	public void setNnm_factura(String nnm_factura) {
		this.nnm_factura = nnm_factura;
	}

	public String getFecha_facturacion() {
		return this.fecha_facturacion;
	}

	public void setFecha_facturacion(String fecha_facturacion) {
		this.fecha_facturacion = fecha_facturacion;
	}

	public BigDecimal getIva() {
		return this.iva;
	}

	public void setIva(BigDecimal iva) {
		this.iva = iva;
	}

	public String getNombre_empleado() {
		return this.nombre_empleado;
	}

	public void setNombre_empleado(String nombre_empleado) {
		this.nombre_empleado = nombre_empleado;
	}

	public BigDecimal getTotalFactura() {
		return this.totalFactura;
	}

	public void setTotalFactura(BigDecimal totalFactura) {
		this.totalFactura = totalFactura;
	}

	public List<DetalleFactura> getDetalleFacturas() {
		return this.detalleFacturas;
	}

	public void setDetalleFacturas(List<DetalleFactura> detalleFacturas) {
		this.detalleFacturas = detalleFacturas;
	}

	public DetalleFactura addDetalleFactura(DetalleFactura detalleFactura) {
		getDetalleFacturas().add(detalleFactura);
		detalleFactura.setFactura(this);

		return detalleFactura;
	}

	public DetalleFactura removeDetalleFactura(DetalleFactura detalleFactura) {
		getDetalleFacturas().remove(detalleFactura);
		detalleFactura.setFactura(null);

		return detalleFactura;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public FormaDePago getFormaDePago() {
		return this.formaDePago;
	}

	public void setFormaDePago(FormaDePago formaDePago) {
		this.formaDePago = formaDePago;
	}

	@Override
	public String toString() {
		return "Factura [nnm_factura=" + nnm_factura + ", fecha_facturacion=" + fecha_facturacion + ", iva=" + iva
				+ ", nombre_empleado=" + nombre_empleado + ", totalFactura=" + totalFactura + ", detalleFacturas="
				+ detalleFacturas + ", cliente=" + cliente + ", formaDePago=" + formaDePago + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
		result = prime * result + ((detalleFacturas == null) ? 0 : detalleFacturas.hashCode());
		result = prime * result + ((fecha_facturacion == null) ? 0 : fecha_facturacion.hashCode());
		result = prime * result + ((formaDePago == null) ? 0 : formaDePago.hashCode());
		result = prime * result + ((iva == null) ? 0 : iva.hashCode());
		result = prime * result + ((nnm_factura == null) ? 0 : nnm_factura.hashCode());
		result = prime * result + ((nombre_empleado == null) ? 0 : nombre_empleado.hashCode());
		result = prime * result + ((totalFactura == null) ? 0 : totalFactura.hashCode());
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
		Factura other = (Factura) obj;
		if (cliente == null) {
			if (other.cliente != null)
				return false;
		} else if (!cliente.equals(other.cliente))
			return false;
		if (detalleFacturas == null) {
			if (other.detalleFacturas != null)
				return false;
		} else if (!detalleFacturas.equals(other.detalleFacturas))
			return false;
		if (fecha_facturacion == null) {
			if (other.fecha_facturacion != null)
				return false;
		} else if (!fecha_facturacion.equals(other.fecha_facturacion))
			return false;
		if (formaDePago == null) {
			if (other.formaDePago != null)
				return false;
		} else if (!formaDePago.equals(other.formaDePago))
			return false;
		if (iva == null) {
			if (other.iva != null)
				return false;
		} else if (!iva.equals(other.iva))
			return false;
		if (nnm_factura == null) {
			if (other.nnm_factura != null)
				return false;
		} else if (!nnm_factura.equals(other.nnm_factura))
			return false;
		if (nombre_empleado == null) {
			if (other.nombre_empleado != null)
				return false;
		} else if (!nombre_empleado.equals(other.nombre_empleado))
			return false;
		if (totalFactura == null) {
			if (other.totalFactura != null)
				return false;
		} else if (!totalFactura.equals(other.totalFactura))
			return false;
		return true;
	}

}