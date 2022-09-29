package artistep.version1.v1domain.majorPost.post.repository;

import com.querydsl.core.Tuple;
import org.springframework.stereotype.Repository;

@Repository
public interface
CustomPostRepository {
    Tuple getPostWithId(Long postId);

    Long getUserIdWithPostId(Long postId);
}
