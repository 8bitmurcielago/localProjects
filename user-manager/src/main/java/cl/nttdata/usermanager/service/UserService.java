package cl.nttdata.usermanager.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import cl.nttdata.usermanager.config.JwtTokenProvider;
import cl.nttdata.usermanager.dto.TelefonoDTO;
import cl.nttdata.usermanager.dto.UserDTO;
import cl.nttdata.usermanager.dto.UserResponseDTO;
import cl.nttdata.usermanager.exception.UserManagementException;
import cl.nttdata.usermanager.model.Telefono;
import cl.nttdata.usermanager.model.User;
import cl.nttdata.usermanager.repository.UserRepository;

/**
 * The Class UserService.
 */
@Service
public class UserService {

	/** The password regex. */
	@Value("${password.validation.regex}")
	private String passwordRegex;

	/** The user repository. */
	@Autowired
	private UserRepository userRepository;

	/** The password encoder. */
	@Autowired
	private PasswordEncoder passwordEncoder;

	/** The jwt token provider. */
	@Autowired
	private JwtTokenProvider jwtTokenProvider;

	/**
	 * Creates the user.
	 *
	 * @param userDTO the user DTO
	 * @return the user response DTO
	 */
	public UserResponseDTO createUser(UserDTO userDTO) {
		if (!isValidEmail(userDTO.getCorreo())) {
			throw new UserManagementException("El formato de correo es incorrecto");
		}

		if (!isValidPassword(userDTO.getContraseña())) {
			throw new UserManagementException("El formato de contraseña es incorrecto");
		}
		if (userRepository.existsByCorreo(userDTO.getCorreo())) {
			throw new UserManagementException("El correo ya está registrado");
		}

		User user = new User();
		user.setNombre(userDTO.getNombre());
		user.setCorreo(userDTO.getCorreo());
		user.setContraseña(passwordEncoder.encode(userDTO.getContraseña()));
		user.setCreado(new Date());
		user.setModificado(new Date());
		user.setUltimoLogin(new Date());
		user.setToken(jwtTokenProvider.generateToken(userDTO.getCorreo()));
		user.setActivo(true);

		user.setTelefonos(new ArrayList<>());
		if (!userDTO.getTelefonos().isEmpty()) {
			mapAndAddTelefono(userDTO, user);
		}

		User savedUser = userRepository.save(user);
		UserResponseDTO response = new UserResponseDTO();
		response.setId(savedUser.getId().toString());
		response.setActivo(savedUser.isActivo());
		response.setCreado(savedUser.getCreado());
		response.setModificado(savedUser.getModificado());
		response.setToken(savedUser.getToken());
		response.setUltimoLogin(savedUser.getUltimoLogin());
		return response;
	}

	/**
	 * Map and add telefono.
	 *
	 * @param userDTO the user DTO
	 * @param user the user
	 */
	private void mapAndAddTelefono(UserDTO userDTO, User user) {
		for (TelefonoDTO telefonoDTO : userDTO.getTelefonos()) {
			Telefono telefono = new Telefono();
			telefono.setNumero(telefonoDTO.getNumero());
			telefono.setCodigoCiudad(telefonoDTO.getCodigoCiudad());
			telefono.setCodigoPais(telefonoDTO.getCodigoPais());
			user.getTelefonos().add(telefono);
		}
	}

	/**
	 * Checks if is valid email.
	 *
	 * @param email the email
	 * @return true, if is valid email
	 */
	public boolean isValidEmail(String email) {
		String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";

		Pattern pattern = Pattern.compile(emailRegex);
		Matcher matcher = pattern.matcher(email);

		return matcher.matches();
	}

	/**
	 * Checks if is valid password.
	 *
	 * @param password the password
	 * @return true, if is valid password
	 */
	public boolean isValidPassword(String password) {
		Pattern pattern = Pattern.compile(passwordRegex);
		Matcher matcher = pattern.matcher(password);

		return matcher.matches();
	}

	/**
	 * Gets the user.
	 *
	 * @param userId the user id
	 * @return the user
	 */
	public User getUser(String userId) {
		return userRepository.findById(UUID.fromString(userId))
				.orElseThrow(() -> new UserManagementException("Usuario no encontrado"));
	}

	/**
	 * Update user.
	 *
	 * @param userId the user id
	 * @param userDTO the user DTO
	 * @return the user response DTO
	 */
	public UserResponseDTO updateUser(String userId, UserDTO userDTO) {
		User user = userRepository.findById(UUID.fromString(userId))
				.orElseThrow(() -> new UserManagementException("Usuario no encontrado"));

		user.setNombre(userDTO.getNombre());
		user.setCorreo(userDTO.getCorreo());

		if (userDTO.getContraseña() != null) {
			if (!isValidPassword(userDTO.getContraseña())) {
				throw new UserManagementException("El formato de contraseña es incorrecto");
			}
			user.setContraseña(passwordEncoder.encode(userDTO.getContraseña()));
		}

		if (!userDTO.getTelefonos().isEmpty()) {
			mapAndAddTelefono(userDTO, user);
		}

		user.setModificado(new Date());

		User savedUser = userRepository.save(user);
		UserResponseDTO response = new UserResponseDTO();
		response.setId(savedUser.getId().toString());
		response.setActivo(savedUser.isActivo());
		response.setCreado(savedUser.getCreado());
		response.setModificado(savedUser.getModificado());
		response.setToken(savedUser.getToken());
		response.setUltimoLogin(savedUser.getUltimoLogin());
		return response;
	}

	/**
	 * Delete user.
	 *
	 * @param userId the user id
	 * @return the string
	 */
	public String deleteUser(String userId) {
		try {
			userRepository.deleteById(UUID.fromString(userId));
			return "Usuario eliminado.";
		} catch (Exception e) {
			throw new UserManagementException("Error al eliminar usuario: " + e.getMessage());
		}

	}
}
