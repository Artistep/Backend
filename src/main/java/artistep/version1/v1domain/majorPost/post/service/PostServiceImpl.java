package artistep.version1.v1domain.majorPost.post.service;

import artistep.version1.v1domain.majorComment.comment.dto.CommentResponseDto.*;
import artistep.version1.v1domain.majorComment.comment.repository.CommentRepository;
import artistep.version1.v1domain.majorPost.likePost.repository.LikePostRepository;
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
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static artistep.version1.v1domain.majorPost.post.QPost.post;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    private final PostFileRepository postFileRepository;
    private final LikePostRepository likePostRepository;
    private final CommentRepository commentRepository;
    private final JPAQueryFactory queryFactory;

    // 게시글 등록하기
    @Override
    @Transactional
    public Long registerPostHJ(Long userId, PostRequestForm postRequestForm) {
        User user = User.builder().id(userId).build();

        Post post = Post.builder()
                .title(postRequestForm.getTitle())
                .user(user)
                .content(postRequestForm.getContent())
                .postCategory(postRequestForm.getPostCategory())
                .genre(postRequestForm.getGenre())
                .status("NORMAL")
                .build();

        postRepository.save(post);

        for (String postLink : postRequestForm.getPostFile()) {
            PostFile postFile = PostFile.builder()
                    .link(postLink)
                    .user(user)
                    .post(post)
                    .status("NORMAL")
                    .build();

            postFileRepository.save(postFile);
        }

        return post.getId();
    }

    // 게시글 조회
    @Override
    @Transactional
    public PostRespondForm getPostDetailHJ(Long postId) {
        Tuple postEntity = postRepository.getPostById(postId);
        List<String> fileLinkList = postFileRepository.loadPostLinkByPostIdHJ(postId);
        List<commentForm> commentList = commentRepository.loadCommentListByPostHJ(postId);
        Long likeCount = likePostRepository.LikedPostCountHJ(postId);

        PostRespondForm postRespondForm = PostRespondForm.builder()
                .title(postEntity.get(post.title))
                .nickName(postEntity.get(post.user.nickname))
                .content(postEntity.get(post.content))
                .likeCount(likeCount)
                .commentList(commentList)
                .postFileList(fileLinkList)
                .updatedAt(postEntity.get(post.updatedAt))
                .build();

        // 조회수 추가
        queryFactory
                .update(post)
                .set(post.viewCount, postEntity.get(post.viewCount) + 1)
                .where(post.id.eq(postId))
                .execute();

        return postRespondForm;
    }

    // 게시글 수정
    @Override
    @Transactional
    public void updatePostHJ(Long userId, Long postId, PostRequestForm postRequestForm) {
        postRepository.updatePostHJ(postId, postRequestForm);

        postFileRepository.deleteAllByPostHJ(postId);

        for (String fileLink : postRequestForm.getPostFile()) {
            PostFile postFile = PostFile.builder()
                    .user(User.builder().id(userId).build())
                    .post(Post.builder().id(postId).build())
                    .link(fileLink)
                    .status("NORMAL")
                    .build();

            postFileRepository.save(postFile);
        }
    }

    // 게시글 지우기
    @Override
    @Transactional
    public void deletePostHJ(Long postId) {
        // 대댓글 지우기 추가하기
        postFileRepository.deleteAllByPostHJ(postId);
        commentRepository.deleteAllByPostHJ(postId);
        postRepository.deleteById(postId);
    }
}
