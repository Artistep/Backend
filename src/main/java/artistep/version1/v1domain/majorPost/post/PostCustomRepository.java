package artistep.version1.v1domain.majorPost.post;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostCustomRepository {

    List<String> getPostInUserInfoPage(Long avatarId);
}
