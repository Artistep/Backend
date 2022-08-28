package artistep.version1.v1domain.majorPost.likePost.repository;

import artistep.version1.v1domain.majorPost.likePost.LikePost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LikePostRepository extends JpaRepository<LikePost, Long>, CustomLikePostRepository {



}
