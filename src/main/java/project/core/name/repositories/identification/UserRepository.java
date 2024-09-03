package project.core.name.repositories.identification;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.core.name.entities.identification.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByLogin(String login);
}
