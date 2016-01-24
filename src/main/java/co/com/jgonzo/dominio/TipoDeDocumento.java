package co.com.jgonzo.dominio;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipo_de_documento database table.
 * 
 */
@Entity
@Table(name="tipo_de_documento")
@NamedQuery(name="TipoDeDocumento.findAll", query="SELECT t FROM TipoDeDocumento t")
public class TipoDeDocumento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_tipo_documento")
	private int idTipoDocumento;

	private String descripcion;

	//bi-directional many-to-one association to Cliente
	@OneToMany(mappedBy="tipoDeDocumento")
	private List<Cliente> clientes;

	//bi-directional many-to-one association to Proveedor
	@OneToMany(mappedBy="tipoDeDocumento")
	private List<Proveedor> proveedores;

	public TipoDeDocumento() {
	}

	public int getIdTipoDocumento() {
		return this.idTipoDocumento;
	}

	public void setIdTipoDocumento(int idTipoDocumento) {
		this.idTipoDocumento = idTipoDocumento;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Cliente> getClientes() {
		return this.clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public Cliente addCliente(Cliente cliente) {
		getClientes().add(cliente);
		cliente.setTipoDeDocumento(this);

		return cliente;
	}

	public Cliente removeCliente(Cliente cliente) {
		getClientes().remove(cliente);
		cliente.setTipoDeDocumento(null);

		return cliente;
	}

	public List<Proveedor> getProveedores() {
		return this.proveedores;
	}

	public void setProveedores(List<Proveedor> proveedores) {
		this.proveedores = proveedores;
	}

	public Proveedor addProveedore(Proveedor proveedore) {
		getProveedores().add(proveedore);
		proveedore.setTipoDeDocumento(this);

		return proveedore;
	}

	public Proveedor removeProveedore(Proveedor proveedore) {
		getProveedores().remove(proveedore);
		proveedore.setTipoDeDocumento(null);

		return proveedore;
	}

}