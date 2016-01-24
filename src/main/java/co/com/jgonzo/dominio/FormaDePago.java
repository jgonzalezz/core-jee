package co.com.jgonzo.dominio;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the forma_de_pago database table.
 * 
 */
@Entity
@Table(name="forma_de_pago")
@NamedQuery(name="FormaDePago.findAll", query="SELECT f FROM FormaDePago f")
public class FormaDePago implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_formapago")
	private int idFormapago;

	private String descripcion_formapago;

	//bi-directional many-to-one association to Factura
	@OneToMany(mappedBy="formaDePago")
	private List<Factura> facturas;

	public FormaDePago() {
	}

	public int getIdFormapago() {
		return this.idFormapago;
	}

	public void setIdFormapago(int idFormapago) {
		this.idFormapago = idFormapago;
	}

	public String getDescripcion_formapago() {
		return this.descripcion_formapago;
	}

	public void setDescripcion_formapago(String descripcion_formapago) {
		this.descripcion_formapago = descripcion_formapago;
	}

	public List<Factura> getFacturas() {
		return this.facturas;
	}

	public void setFacturas(List<Factura> facturas) {
		this.facturas = facturas;
	}

	public Factura addFactura(Factura factura) {
		getFacturas().add(factura);
		factura.setFormaDePago(this);

		return factura;
	}

	public Factura removeFactura(Factura factura) {
		getFacturas().remove(factura);
		factura.setFormaDePago(null);

		return factura;
	}

}