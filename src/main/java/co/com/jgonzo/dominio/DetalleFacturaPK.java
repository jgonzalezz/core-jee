package co.com.jgonzo.dominio;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the detalle_factura database table.
 * 
 */
@Embeddable
public class DetalleFacturaPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="cod_factura", insertable=false, updatable=false)
	private String codFactura;

	@Column(name="cod_articulo", insertable=false, updatable=false)
	private int codArticulo;

	public DetalleFacturaPK() {
	}
	public String getCodFactura() {
		return this.codFactura;
	}
	public void setCodFactura(String codFactura) {
		this.codFactura = codFactura;
	}
	public int getCodArticulo() {
		return this.codArticulo;
	}
	public void setCodArticulo(int codArticulo) {
		this.codArticulo = codArticulo;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof DetalleFacturaPK)) {
			return false;
		}
		DetalleFacturaPK castOther = (DetalleFacturaPK)other;
		return 
			this.codFactura.equals(castOther.codFactura)
			&& (this.codArticulo == castOther.codArticulo);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.codFactura.hashCode();
		hash = hash * prime + this.codArticulo;
		
		return hash;
	}
}