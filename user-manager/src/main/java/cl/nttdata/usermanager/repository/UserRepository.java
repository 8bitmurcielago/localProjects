package cl.nttdata.usermanager.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.nttdata.usermanager.model.User;

/**
 * The Interface UserRepository.
 */
@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

	/**
	 * Exists by correo.
	 *
	 * @param correo the correo
	 * @return true, if successful
	 */
	boolean existsByCorreo(String correo);
}
