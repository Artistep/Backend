package artistep.version1.v1domain.majorPost.post.repository;

import artistep.version1.v1domain.majorPost.post.dto.PostRequestDto.*;
import artistep.version1.v1domain.majorPost.post.dto.PostResponseDto.*;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomPostRepository {
    void updatePostTitleHJ(Long id, UpdateTitleForm updateTitleForm);
    void updatePostContentHJ(Long id, UpdateContentForm updateContentForm);
    void updatePostCategoryHJ(Long id, UpdateCategoryForm updateCategoryForm);
//    void updatePostStatusHJ(Long id, UpdateStatusForm updateStatusForm);
}
