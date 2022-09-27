package artistep.version1.v1domain.majorComment.comment.repository;

import artistep.version1.v1domain.majorComment.comment.Comment;
import artistep.version1.v1domain.majorComment.comment.dto.CommentResponseDto.*;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface CustomCommentRepository {
    List<commentForm> getCommentListHJ(Long postId);
}
