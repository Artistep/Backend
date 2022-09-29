package artistep.version1.v1domain.majorPost.post.service;

import artistep.version1.v1domain.majorComment.comment.repository.CommentRepository;
import artistep.version1.v1domain.majorPost.post.Post;
import artistep.version1.v1domain.majorPost.post.dto.PostRequestDto.*;
import artistep.version1.v1domain.majorPost.post.dto.PostResponseDto.*;
import artistep.version1.v1domain.majorPost.post.repository.PostRepository;
import artistep.version1.v1domain.majorPost.postFile.PostFile;
import artistep.version1.v1domain.majorPost.postFile.repository.PostFileRepository;
import artistep.version1.v1domain.majorUser.user.User;
import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static artistep.version1.v1domain.majorPost.post.QPost.post;
import static artistep.version1.v1domain.majorPost.postFile.QPostFile.postFile;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    private final PostFileRepository postFileRepository;
    private final CommentRepository commentRepository;
    private final JPAQueryFactory queryFactory;

    // 게시글 등록하기
    @Override
    public Long registerPostHJ(Long userId, PostRequestForm postRequestForm) {
        User user = User.builder().id(userId).build();

        Post post = Post.builder()
                .title(postRequestForm.getTitle())
                .user(user)
                .content(postRequestForm.getContent())
                .postCategory(postRequestForm.getPostCategory())
                .genre(postRequestForm.getGenre())
                .viewCount(0)
                .status("NORMAL")
                .build();

        postRepository.save(post);

        postRequestForm.getPostFile().forEach(file -> {
            queryFactory
                    .update(postFile)
                    .set(postFile.user, user)
                    .set(postFile.post, post)
                    .set(postFile.link, file)
                    .set(postFile.status, "NORMAL")
                    .execute();
        });

        return post.getId();
    }

    // 게시글 조회
    @Override
    public PostRespondForm getPostDetailHJ(Long postId) {
        Tuple postEntity = postRepository.getPostWithId(postId);

        PostRespondForm postRespondForm = PostRespondForm.builder()
                .title(postEntity.get(post.title))
                .nickName(postEntity.get(post.user.nickname))
                .content(postEntity.get(post.content))
                .updatedAt(postEntity.get(post.updatedAt))
                .build();

        // 조회수 추가
        queryFactory
                .update(post)
                .set(post.viewCount, postEntity.get(post.viewCount) + 1)
                .execute();

        return postRespondForm;
    }

    // 게시글 수정
    @Override
    public void updatePostHJ(Long postId, PostRequestForm postRequestForm) {
        Long userId = postRepository.getUserIdWithPostId(postId);

        queryFactory.update(post)
                .set(post.title, postRequestForm.getTitle())
                .set(post.content, postRequestForm.getContent())
                .where(post.id.eq(postId))
                .execute();

        // 파일 업데이트
        postRequestForm.getPostFile().forEach(file -> {
            if (queryFactory
                    .selectFrom(postFile)
                    .where(postFile.link.eq(file))
                    .fetch().size() == 0)

                queryFactory
                        .update(postFile)
                        .set(postFile.user, User.builder().id(userId).build())
                        .set(postFile.post, Post.builder().id(postId).build())
                        .set(postFile.link, file)
                        .set(postFile.status, "NORMAL")
                        .execute();
        });
    }

    // 게시글 지우기
    @Override
    public void deletePostHJ(Long postId) {
        // 대댓글 지우기 추가하기
        postFileRepository.deleteByPostId(postId);
        commentRepository.deleteByPostId(postId);
        postRepository.deleteById(postId);
    }
}
