package artistep.version1.v1domain.majorPost.post.service;

import artistep.version1.v1domain.majorPost.post.dto.PostResponseDto.*;
import artistep.version1.v1domain.majorPost.post.dto.PostRequestDto.*;
import org.springframework.stereotype.Service;

@Service
public interface PostService {
    Long registerPostHJ(Long userId, PostRequestForm postRequestForm);

    PostRespondForm getPostDetailHJ(Long postId);

    void updatePostHJ(Long userId, Long postId, PostRequestForm postRequestForm);

    void deletePostHJ(Long postId);
}
