package artistep.version1.v1domain.majorPost.post.service;

import artistep.version1.v1domain.majorPost.post.dto.PostResponseDto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    @Override
    public Long registerPostHJ(DetailPostForm detailPostForm) {
        return null;
    }

    @Override
    public void removePostHJ(Long id) {

    }

    @Override
    public void modifyPostHJ(DetailPostForm detailPostForm) {

    }

    @Override
    public DetailPostForm readPostHJ(Long id) {
        return null;
    }
}
