package cl.nttdata.usermanager.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cl.nttdata.usermanager.dto.UserDTO;
import cl.nttdata.usermanager.dto.UserResponseDTO;
import cl.nttdata.usermanager.model.User;
import cl.nttdata.usermanager.service.UserService;

/**
 * The Class UserController.
 */
@RestController
@RequestMapping("")
public class UserController {

	/** The user service. */
	@Autowired
	private UserService userService;

	/**
	 * Creates the user.
	 *
	 * @param userDTO the user DTO
	 * @return the response entity
	 */
	@PostMapping("/userManagement/createUser")
	public ResponseEntity<UserResponseDTO> createUser(@Valid @RequestBody UserDTO userDTO) {
		return ResponseEntity.ok(userService.createUser(userDTO));
	}

	/**
	 * Gets the user.
	 *
	 * @param userId the user id
	 * @return the user
	 */
	@GetMapping("/userManagement/getUser")
	public ResponseEntity<User> getUser(@RequestParam String userId) {
		return ResponseEntity.ok(userService.getUser(userId));
	}

	/**
	 * Update user.
	 *
	 * @param userId the user id
	 * @param userDTO the user DTO
	 * @return the response entity
	 */
	@PutMapping("/userManagement/updateUser")
	public ResponseEntity<UserResponseDTO> updateUser(@RequestParam String userId, @RequestBody UserDTO userDTO) {
		return ResponseEntity.ok(userService.updateUser(userId, userDTO));
	}

	/**
	 * Delete user.
	 *
	 * @param userId the user id
	 * @return the response entity
	 */
	@DeleteMapping("/userManagement/deleteUser")
	public ResponseEntity<String> deleteUser(@RequestParam String userId) {
		return ResponseEntity.ok(userService.deleteUser(userId));
	}
}
