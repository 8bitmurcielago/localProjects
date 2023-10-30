package cl.nttdata.usermanager.dto;

import java.util.List;

/**
 * The Class UserDTO.
 */
public class UserDTO {

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
	 * Gets the telefonos.
	 *
	 * @return the telefonos
	 */
	public List<TelefonoDTO> getTelefonos() {
		return telefonos;
	}

	/**
	 * Sets the telefonos.
	 *
	 * @param telefonos the new telefonos
	 */
	public void setTelefonos(List<TelefonoDTO> telefonos) {
		this.telefonos = telefonos;
	}

	/** The nombre. */
	private String nombre;

	/** The correo. */
	private String correo;

	/** The contraseña. */
	private String contraseña;

	/** The telefonos. */
	private List<TelefonoDTO> telefonos;

}
