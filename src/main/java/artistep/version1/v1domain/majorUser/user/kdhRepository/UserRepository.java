package artistep.version1.v1domain.majorUser.user.kdhRepository;

import artistep.version1.v1domain.majorUser.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long>, CustomUserRepository {

    Optional<User> findByUsername(String username);

    Optional<User> findByEmail(String email);
}
