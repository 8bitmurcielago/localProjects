package cl.nttdata.usermanager.exception;

/**
 * The Class UserManagementException.
 */
public class UserManagementException extends RuntimeException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -2928747639618334927L;

	/**
	 * Instantiates a new user management exception.
	 *
	 * @param message the message
	 */
	public UserManagementException(String message) {
		super(message);
	}
}
