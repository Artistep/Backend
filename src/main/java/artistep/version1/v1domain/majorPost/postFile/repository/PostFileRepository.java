package artistep.version1.v1domain.majorPost.postFile.repository;

import artistep.version1.v1domain.majorPost.postFile.PostFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface PostFileRepository extends JpaRepository<PostFile, Long>, CustomPostFileRepository {
}
