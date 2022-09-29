package artistep.version1.v1domain.majorComment.comment.repository;

import artistep.version1.v1domain.majorComment.comment.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long>, CustomCommentRepository {
    @Modifying
    @Query("delete from Comment c where c.post.id = :postID")
    void deleteByPostId(Long postId);

}
