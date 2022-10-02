package artistep.version1.v1domain.majorPost.post.repository;

import artistep.version1.v1domain.majorPost.post.dto.PostRequestDto.*;
import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import static artistep.version1.v1domain.majorPost.post.QPost.post;


@Repository
@Transactional
@RequiredArgsConstructor
public class CustomPostRepositoryImpl implements CustomPostRepository {
    private final JPAQueryFactory queryFactory;

    @Override
    public Tuple getPostById(Long postId) {
        return queryFactory
                .select(post.title, post.user.nickname, post.content, post.updatedAt, post.viewCount)
                .from(post)
                .where(post.id.eq(postId))
                .fetchOne();
    }

    @Override
    public void updatePostHJ(Long postId, PostRequestForm postRequestForm) {
        queryFactory
                .update(post)
                .set(post.title, postRequestForm.getTitle())
                .set(post.content, postRequestForm.getContent())
                .set(post.genre, postRequestForm.getGenre())
                .where(post.id.eq(postId))
                .execute();
    }
}