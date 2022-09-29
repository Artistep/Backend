package artistep.version1.v1domain.majorPost.postFile.repository;

import artistep.version1.v1domain.majorPost.postFile.PostFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PostFileRepository extends JpaRepository<PostFile, Long>, CustomPostFileRepository {
    @Modifying
    @Query("delete from PostFile p where p.post.id = :postID")
    void deleteByPostId(Long postId);
}
