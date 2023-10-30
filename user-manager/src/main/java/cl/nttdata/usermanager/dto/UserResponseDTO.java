package cl.nttdata.usermanager.dto;

import java.util.Date;

/**
 * The Class UserResponseDTO.
 */
public class UserResponseDTO {

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

	/** The id. */
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

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

}
