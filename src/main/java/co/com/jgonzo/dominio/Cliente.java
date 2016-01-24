package co.com.jgonzo.dominio;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the cliente database table.
 * 
 */
@Entity
@NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c")
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String documento;

	private String apellidos;

	private String direccion;

	private String nombres;

	private String telefono;

	// bi-directional many-to-one association to Ciudad
	@ManyToOne
	@JoinColumn(name = "cod_ciudad")
	private Ciudad ciudad;

	// bi-directional many-to-one association to TipoDeDocumento
	@ManyToOne
	@JoinColumn(name = "cod_tipo_documento")
	private TipoDeDocumento tipoDeDocumento;

	// bi-directional many-to-one association to Factura
	@OneToMany(mappedBy = "cliente")
	private List<Factura> facturas;

	public Cliente() {
	}

	public Cliente(String documento, String apellidos, String direccion, String nombres, String telefono, Ciudad ciudad,
			TipoDeDocumento tipoDeDocumento, List<Factura> facturas) {
		super();
		this.documento = documento;
		this.apellidos = apellidos;
		this.direccion = direccion;
		this.nombres = nombres;
		this.telefono = telefono;
		this.ciudad = ciudad;
		this.tipoDeDocumento = tipoDeDocumento;
		this.facturas = facturas;
	}

	public String getDocumento() {
		return this.documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getNombres() {
		return this.nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Ciudad getCiudad() {
		return this.ciudad;
	}

	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}

	public TipoDeDocumento getTipoDeDocumento() {
		return this.tipoDeDocumento;
	}

	public void setTipoDeDocumento(TipoDeDocumento tipoDeDocumento) {
		this.tipoDeDocumento = tipoDeDocumento;
	}

	public List<Factura> getFacturas() {
		return this.facturas;
	}

	public void setFacturas(List<Factura> facturas) {
		this.facturas = facturas;
	}

	public Factura addFactura(Factura factura) {
		getFacturas().add(factura);
		factura.setCliente(this);

		return factura;
	}

	public Factura removeFactura(Factura factura) {
		getFacturas().remove(factura);
		factura.setCliente(null);

		return factura;
	}

	@Override
	public String toString() {
		return "Cliente [documento=" + documento + ", apellidos=" + apellidos + ", direccion=" + direccion
				+ ", nombres=" + nombres + ", telefono=" + telefono + ", ciudad=" + ciudad + ", tipoDeDocumento="
				+ tipoDeDocumento + ", facturas=" + facturas + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apellidos == null) ? 0 : apellidos.hashCode());
		result = prime * result + ((ciudad == null) ? 0 : ciudad.hashCode());
		result = prime * result + ((direccion == null) ? 0 : direccion.hashCode());
		result = prime * result + ((documento == null) ? 0 : documento.hashCode());
		result = prime * result + ((facturas == null) ? 0 : facturas.hashCode());
		result = prime * result + ((nombres == null) ? 0 : nombres.hashCode());
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
		Cliente other = (Cliente) obj;
		if (apellidos == null) {
			if (other.apellidos != null)
				return false;
		} else if (!apellidos.equals(other.apellidos))
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
		if (documento == null) {
			if (other.documento != null)
				return false;
		} else if (!documento.equals(other.documento))
			return false;
		if (facturas == null) {
			if (other.facturas != null)
				return false;
		} else if (!facturas.equals(other.facturas))
			return false;
		if (nombres == null) {
			if (other.nombres != null)
				return false;
		} else if (!nombres.equals(other.nombres))
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