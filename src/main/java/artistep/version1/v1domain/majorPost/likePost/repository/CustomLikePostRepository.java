package artistep.version1.v1domain.majorPost.likePost.repository;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface CustomLikePostRepository {

    // user의 좋아요한 post 수
    int LikePostCount(Long userId);

    // post의 좋아요 수
    Long LikedPostCountHJ(Long postId);
}
