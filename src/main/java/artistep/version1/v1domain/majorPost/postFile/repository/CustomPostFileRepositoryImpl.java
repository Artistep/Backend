package artistep.version1.v1domain.majorPost.postFile.repository;

import artistep.version1.v1domain.majorPost.likePost.LikePost;
import artistep.version1.v1domain.majorPost.likePost.QLikePost;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static artistep.version1.v1domain.majorPost.likePost.QLikePost.likePost;
import static artistep.version1.v1domain.majorPost.postFile.QPostFile.postFile;

@Repository
@RequiredArgsConstructor
public class CustomPostFileRepositoryImpl implements CustomPostFileRepository {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<String> loadLikePostLink(Long userId) {
        return queryFactory
                .select(postFile.link)
                .from(postFile)
                .where(postFile.id.eq(
                        JPAExpressions
                                .select(likePost.id)
                                .from(likePost)
                                .where(likePost.user.id.eq(userId)))
                        )
                .fetch();
    }
}
