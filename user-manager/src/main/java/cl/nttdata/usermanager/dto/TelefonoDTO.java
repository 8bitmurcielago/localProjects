package cl.nttdata.usermanager.dto;

/**
 * The Class TelefonoDTO.
 */
public class TelefonoDTO {

	/**
	 * Gets the numero.
	 *
	 * @return the numero
	 */
	public String getNumero() {
		return numero;
	}

	/**
	 * Sets the numero.
	 *
	 * @param numero the new numero
	 */
	public void setNumero(String numero) {
		this.numero = numero;
	}

	/**
	 * Gets the codigo ciudad.
	 *
	 * @return the codigo ciudad
	 */
	public String getCodigoCiudad() {
		return codigoCiudad;
	}

	/**
	 * Sets the codigo ciudad.
	 *
	 * @param codigoCiudad the new codigo ciudad
	 */
	public void setCodigoCiudad(String codigoCiudad) {
		this.codigoCiudad = codigoCiudad;
	}

	/**
	 * Gets the codigo pais.
	 *
	 * @return the codigo pais
	 */
	public String getCodigoPais() {
		return codigoPais;
	}

	/**
	 * Sets the codigo pais.
	 *
	 * @param codigoPais the new codigo pais
	 */
	public void setCodigoPais(String codigoPais) {
		this.codigoPais = codigoPais;
	}

	/** The numero. */
	private String numero;

	/** The codigo ciudad. */
	private String codigoCiudad;

	/** The codigo pais. */
	private String codigoPais;
}
