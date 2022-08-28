package artistep.version1.v1domain.majorPost.likePost.repository;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface CustomLikePostRepository {

    int LikePostCount(Long userId);
}
