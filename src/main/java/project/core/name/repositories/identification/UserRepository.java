package project.core.name.repositories.identification;

import org.springframework.data.jpa.repository.JpaRepository;
import project.core.name.entities.identification.User;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByLogin(String login);
}
