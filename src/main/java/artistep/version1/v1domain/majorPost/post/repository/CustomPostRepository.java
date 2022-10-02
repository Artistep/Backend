package artistep.version1.v1domain.majorPost.post.repository;

import artistep.version1.v1domain.majorPost.post.dto.PostRequestDto.*;
import com.querydsl.core.Tuple;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface CustomPostRepository {
    Tuple getPostById(Long postId);

    void updatePostHJ(Long postId, PostRequestForm postRequestForm);
}
