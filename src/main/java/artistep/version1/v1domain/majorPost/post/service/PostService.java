package artistep.version1.v1domain.majorPost.post.service;

import artistep.version1.v1domain.majorPost.post.dto.PostResponseDto.*;
import org.springframework.stereotype.Service;

@Service
public interface PostService {
    PostDetailForm getPostDetailHJ(Long postId);
}
