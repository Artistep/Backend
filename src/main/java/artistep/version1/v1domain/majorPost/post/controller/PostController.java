package artistep.version1.v1domain.majorPost.post.controller;


import artistep.version1.v1domain.majorComment.comment.repository.CommentRepository;
import artistep.version1.v1domain.majorPost.likePost.LikePost;
import artistep.version1.v1domain.majorPost.likePost.repository.LikePostRepository;
import artistep.version1.v1domain.majorPost.post.repository.PostRepository;
import artistep.version1.v1domain.majorPost.postFile.repository.PostFileRepository;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Api("게시글 컨트롤러")
@RequestMapping("/post")
public class PostController {
    private final PostRepository postRepository;
    private final CommentRepository commentRepository;
    private final PostFileRepository postFileRepository;
    private final LikePostRepository likePostRepository;
}
