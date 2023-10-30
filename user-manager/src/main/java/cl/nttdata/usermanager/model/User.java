package cl.nttdata.usermanager.model;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The Class User.
 */
@Entity
@Table(name = "user_table")
public class User {

	/**
	 * Gets the nombre.
	 *
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Sets the nombre.
	 *
	 * @param nombre the new nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Gets the correo.
	 *
	 * @return the correo
	 */
	public String getCorreo() {
		return correo;
	}

	/**
	 * Sets the correo.
	 *
	 * @param correo the new correo
	 */
	public void setCorreo(String correo) {
		this.correo = correo;
	}

	/**
	 * Gets the contraseña.
	 *
	 * @return the contraseña
	 */
	public String getContraseña() {
		return contraseña;
	}

	/**
	 * Sets the contraseña.
	 *
	 * @param contraseña the new contraseña
	 */
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	/**
	 * Gets the creado.
	 *
	 * @return the creado
	 */
	public Date getCreado() {
		return creado;
	}

	/**
	 * Sets the creado.
	 *
	 * @param creado the new creado
	 */
	public void setCreado(Date creado) {
		this.creado = creado;
	}

	/**
	 * Gets the modificado.
	 *
	 * @return the modificado
	 */
	public Date getModificado() {
		return modificado;
	}

	/**
	 * Sets the modificado.
	 *
	 * @param modificado the new modificado
	 */
	public void setModificado(Date modificado) {
		this.modificado = modificado;
	}

	/**
	 * Gets the ultimo login.
	 *
	 * @return the ultimo login
	 */
	public Date getUltimoLogin() {
		return ultimoLogin;
	}

	/**
	 * Sets the ultimo login.
	 *
	 * @param ultimoLogin the new ultimo login
	 */
	public void setUltimoLogin(Date ultimoLogin) {
		this.ultimoLogin = ultimoLogin;
	}

	/**
	 * Gets the token.
	 *
	 * @return the token
	 */
	public String getToken() {
		return token;
	}

	/**
	 * Sets the token.
	 *
	 * @param token the new token
	 */
	public void setToken(String token) {
		this.token = token;
	}

	/**
	 * Checks if is activo.
	 *
	 * @return true, if is activo
	 */
	public boolean isActivo() {
		return activo;
	}

	/**
	 * Sets the activo.
	 *
	 * @param activo the new activo
	 */
	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	/**
	 * Gets the telefonos.
	 *
	 * @return the telefonos
	 */
	public List<Telefono> getTelefonos() {
		return telefonos;
	}

	/**
	 * Sets the telefonos.
	 *
	 * @param telefonos the new telefonos
	 */
	public void setTelefonos(List<Telefono> telefonos) {
		this.telefonos = telefonos;
	}

	/** The id. */
	@Id
	@GeneratedValue
	private UUID id;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	/** The nombre. */
	private String nombre;

	/** The correo. */
	private String correo;

	/** The contraseña. */
	private String contraseña;

	/** The creado. */
	private Date creado;

	/** The modificado. */
	private Date modificado;

	/** The ultimo login. */
	private Date ultimoLogin;

	/** The token. */
	private String token;

	/** The activo. */
	private boolean activo;

	/** The telefonos. */
	@OneToMany(cascade = CascadeType.ALL)
	private List<Telefono> telefonos;

}
