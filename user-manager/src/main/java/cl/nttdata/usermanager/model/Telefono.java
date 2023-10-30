package cl.nttdata.usermanager.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * The Class Telefono.
 */
@Entity
public class Telefono {

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

	/** The id. */
	@Id
	@GeneratedValue
	private UUID id;

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public UUID getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(UUID id) {
		this.id = id;
	}

	/** The numero. */
	private String numero;

	/** The codigo ciudad. */
	private String codigoCiudad;

	/** The codigo pais. */
	private String codigoPais;

}
