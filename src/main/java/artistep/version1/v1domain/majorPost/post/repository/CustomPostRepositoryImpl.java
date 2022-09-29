package artistep.version1.v1domain.majorPost.post.repository;

import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import static artistep.version1.v1domain.majorPost.post.QPost.post;


@Repository
@RequiredArgsConstructor
public class CustomPostRepositoryImpl implements CustomPostRepository {
    private final JPAQueryFactory queryFactory;

    @Override
    public Tuple getPostWithId(Long postId) {
        return queryFactory
                .select(post.title, post.user.nickname, post.content, post.updatedAt, post.viewCount)
                .from(post)
                .where(post.id.eq(postId))
                .fetchOne();
    }

    @Override
    public Long getUserIdWithPostId(Long postId) {
        return queryFactory
                .select(post.user.id)
                .from(post)
                .where(post.id.eq(postId))
                .fetchOne();
    }
}
