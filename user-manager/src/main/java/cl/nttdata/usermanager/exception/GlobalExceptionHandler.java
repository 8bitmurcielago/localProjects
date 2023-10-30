package cl.nttdata.usermanager.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	/**
	 * Handle user registration exception.
	 *
	 * @param ex the ex
	 * @return the response entity
	 */
	@ExceptionHandler(UserManagementException.class)
	public ResponseEntity<Map<String, String>> handleUserRegistrationException(UserManagementException ex) {
		Map<String, String> errorResponse = new HashMap<>();
		errorResponse.put("mensaje", ex.getMessage());
		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}
}