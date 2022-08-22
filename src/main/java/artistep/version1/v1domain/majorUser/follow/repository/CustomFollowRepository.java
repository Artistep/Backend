package artistep.version1.v1domain.majorUser.follow.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface CustomFollowRepository {

    int NumberOfFollower(Long id);
    int NumberOfFollowing(Long id);
}
