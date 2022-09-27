package artistep.version1.v1domain.majorPost.postFile.repository;


import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomPostFileRepository {

    List<String> loadLikePostLink(Long userId);

    List<String> loadPostLinkWithPostIdHJ(Long postId);
}
