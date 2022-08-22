package artistep.version1.v1domain.majorPost.likePost.repository;

import artistep.version1.v1domain.majorPost.likePost.QLikePost;
import artistep.version1.v1domain.majorPost.post.QPost;
import artistep.version1.v1domain.majorPost.postFile.QPostFile;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import static artistep.version1.v1domain.majorPost.likePost.QLikePost.likePost;

@Repository
@Transactional
@RequiredArgsConstructor
public class CustomLikePostRepositoryImpl implements CustomLikePostRepository {

    private final JPAQueryFactory queryFactory;

    @Override
    public int LikePostCount(Long userId) {
        return Integer.parseInt(String.valueOf(queryFactory
                .select(likePost.count())
                .from(likePost)
                .where(likePost.user.id.eq(userId))
                .fetchOne()));
    }

}
