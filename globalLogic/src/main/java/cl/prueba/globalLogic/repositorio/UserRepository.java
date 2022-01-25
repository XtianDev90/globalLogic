package cl.prueba.globalLogic.repositorio;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import cl.prueba.globalLogic.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	Optional<User> findByIdUser(java.util.UUID id);
	
	Optional<User> findByEmail(String email);
}
