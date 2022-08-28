package artistep.version1.v1domain.majorPost.post.repository;

import artistep.version1.v1domain.majorPost.post.dto.PostResponseDto;
import artistep.version1.v1domain.majorPost.post.dto.PostResponseDto.AllCategoryPostsPreviewForm;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomPostRepository {

    AllCategoryPostsPreviewForm loadAllPostPreview();
}
