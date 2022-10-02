package artistep.version1.v1domain.majorComment.comment.repository;

import artistep.version1.v1domain.majorComment.comment.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface CommentRepository extends JpaRepository<Comment, Long>, CustomCommentRepository {

}
