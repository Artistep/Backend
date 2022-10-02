package artistep.version1.v1domain.majorPost.post.repository;

import artistep.version1.v1domain.majorPost.post.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface PostRepository extends JpaRepository<Post, Long>, CustomPostRepository {

}
