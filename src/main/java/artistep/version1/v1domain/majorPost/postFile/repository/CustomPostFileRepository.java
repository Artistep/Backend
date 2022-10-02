package artistep.version1.v1domain.majorPost.postFile.repository;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface CustomPostFileRepository {
    List<String> loadLikePostLink(Long userId);

    List<String> loadPostLinkByPostIdHJ(Long postId);

    void deleteAllByPostHJ(Long postId);
}
