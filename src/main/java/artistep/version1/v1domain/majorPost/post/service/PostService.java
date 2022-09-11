package artistep.version1.v1domain.majorPost.post.service;

import artistep.version1.v1domain.majorPost.post.dto.PostResponseDto.*;

public interface PostService {
    Long registerPostHJ(DetailPostForm detailPostForm);

    void removePostHJ(Long id);

    void modifyPostHJ(DetailPostForm detailPostForm);

    DetailPostForm readPostHJ(Long id);
}
