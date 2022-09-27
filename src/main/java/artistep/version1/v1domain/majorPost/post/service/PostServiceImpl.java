package artistep.version1.v1domain.majorPost.post.service;

import artistep.version1.v1domain.majorPost.post.dto.PostResponseDto.*;
import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static artistep.version1.v1domain.majorPost.post.QPost.post;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final JPAQueryFactory queryFactory;

    @Override
    public PostDetailForm getPostDetailHJ(Long postId) {
        Tuple postEntity = queryFactory
                .select(post.title, post.user.nickname, post.content, post.updatedAt)
                .from(post)
                .where(post.id.eq(postId))
                .fetchOne();

        PostDetailForm postDetailForm = PostDetailForm.builder()
                .title(postEntity.get(post.title))
                .nickName(postEntity.get(post.user.nickname))
                .content(postEntity.get(post.content))
                .updatedAt(postEntity.get(post.updatedAt))
                .build();

        return postDetailForm;
    }
}
