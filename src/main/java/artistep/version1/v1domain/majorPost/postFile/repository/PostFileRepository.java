package artistep.version1.v1domain.majorPost.postFile.repository;

import artistep.version1.v1domain.majorPost.postFile.PostFile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostFileRepository extends JpaRepository<PostFile, Long>, CustomPostFileRepository {
}
