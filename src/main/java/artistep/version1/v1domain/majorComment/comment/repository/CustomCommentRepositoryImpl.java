package artistep.version1.v1domain.majorComment.comment.repository;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import artistep.version1.v1domain.majorComment.comment.dto.CommentResponseDto.*;

import java.util.List;

import static artistep.version1.v1domain.majorComment.comment.QComment.comment;

@Repository
@Transactional
@RequiredArgsConstructor
public class CustomCommentRepositoryImpl implements CustomCommentRepository {
    private final JPAQueryFactory queryFactory;

    @Override
    public List<commentForm> getCommentListHJ(Long postId) {
        return queryFactory
                .select(Projections.constructor(commentForm.class,
                        comment.user.nickname,
                        comment.content,
                        comment.updatedAt))
                .from(comment)
                .where(comment.post.id.eq(postId))
                .fetch();
    }
}
