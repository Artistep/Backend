package artistep.version1.v1domain.majorComment.comment.repository;

import artistep.version1.v1domain.majorComment.comment.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long>, CustomCommentRepository {
}
