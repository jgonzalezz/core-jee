package co.com.jgonzo.dominio;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the ciudad database table.
 * 
 */
@Entity
@NamedQuery(name = "Ciudad.findAll", query = "SELECT c FROM Ciudad c")
public class Ciudad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo_ciudad;

	private String nombre_ciudad;

	// bi-directional many-to-one association to Cliente
	@OneToMany(mappedBy = "ciudad")
	private List<Cliente> clientes;

	// bi-directional many-to-one association to Proveedor
	@OneToMany(mappedBy = "ciudad")
	private List<Proveedor> proveedores;

	public Ciudad() {
	}

	public Ciudad(int codigo_ciudad, String nombre_ciudad, List<Cliente> clientes, List<Proveedor> proveedores) {
		super();
		this.codigo_ciudad = codigo_ciudad;
		this.nombre_ciudad = nombre_ciudad;
		this.clientes = clientes;
		this.proveedores = proveedores;
	}

	public Ciudad(String nombre_ciudad, List<Cliente> clientes, List<Proveedor> proveedores) {
		super();
		this.nombre_ciudad = nombre_ciudad;
		this.clientes = clientes;
		this.proveedores = proveedores;
	}

	public int getCodigo_ciudad() {
		return this.codigo_ciudad;
	}

	public void setCodigo_ciudad(int codigo_ciudad) {
		this.codigo_ciudad = codigo_ciudad;
	}

	public String getNombre_ciudad() {
		return this.nombre_ciudad;
	}

	public void setNombre_ciudad(String nombre_ciudad) {
		this.nombre_ciudad = nombre_ciudad;
	}

	public List<Cliente> getClientes() {
		return this.clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public Cliente addCliente(Cliente cliente) {
		getClientes().add(cliente);
		cliente.setCiudad(this);

		return cliente;
	}

	public Cliente removeCliente(Cliente cliente) {
		getClientes().remove(cliente);
		cliente.setCiudad(null);

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
		proveedore.setCiudad(this);

		return proveedore;
	}

	public Proveedor removeProveedore(Proveedor proveedore) {
		getProveedores().remove(proveedore);
		proveedore.setCiudad(null);

		return proveedore;
	}

	@Override
	public String toString() {
		return "Ciudad [codigo_ciudad=" + codigo_ciudad + ", nombre_ciudad=" + nombre_ciudad + ", clientes=" + clientes
				+ ", proveedores=" + proveedores + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((clientes == null) ? 0 : clientes.hashCode());
		result = prime * result + codigo_ciudad;
		result = prime * result + ((nombre_ciudad == null) ? 0 : nombre_ciudad.hashCode());
		result = prime * result + ((proveedores == null) ? 0 : proveedores.hashCode());
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
		Ciudad other = (Ciudad) obj;
		if (clientes == null) {
			if (other.clientes != null)
				return false;
		} else if (!clientes.equals(other.clientes))
			return false;
		if (codigo_ciudad != other.codigo_ciudad)
			return false;
		if (nombre_ciudad == null) {
			if (other.nombre_ciudad != null)
				return false;
		} else if (!nombre_ciudad.equals(other.nombre_ciudad))
			return false;
		if (proveedores == null) {
			if (other.proveedores != null)
				return false;
		} else if (!proveedores.equals(other.proveedores))
			return false;
		return true;
	}

}