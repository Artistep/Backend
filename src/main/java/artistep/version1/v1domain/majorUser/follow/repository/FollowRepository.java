package artistep.version1.v1domain.majorUser.follow.repository;

import artistep.version1.v1domain.majorUser.follow.Follow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public interface FollowRepository extends JpaRepository<Follow, Long>, CustomFollowRepository {
}
