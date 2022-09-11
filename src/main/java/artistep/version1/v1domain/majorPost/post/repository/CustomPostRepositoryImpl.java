package artistep.version1.v1domain.majorPost.post.repository;

import artistep.version1.v1domain.majorPost.post.QPost;
import artistep.version1.v1domain.majorPost.post.dto.PostRequestDto;
import artistep.version1.v1domain.majorPost.post.dto.PostResponseDto.AllCategoryPostsPreviewForm;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import static artistep.version1.v1domain.majorPost.post.QPost.post;


@Repository
@RequiredArgsConstructor
public class CustomPostRepositoryImpl implements CustomPostRepository {
    private final JPAQueryFactory queryFactory;

    // 글 제목 변경
    @Override
    public void updatePostTitleHJ(Long id, PostRequestDto.UpdateTitleForm updateTitleForm) {
        queryFactory
                .update(post)
                .set(post.title, updateTitleForm.getTitle())
                .where(post.id.eq(id))
                .execute();
    }

    // 글 내용 변경
    @Override
    public void updatePostContentHJ(Long id, PostRequestDto.UpdateContentForm updateContentForm) {
        queryFactory
                .update(post)
                .set(post.content, updateContentForm.getContent())
                .where(post.id.eq(id))
                .execute();
    }
    
    // 카테고리 수정
    @Override
    public void updatePostCategoryHJ(Long id, PostRequestDto.UpdateCategoryForm updateCategoryForm) {
        queryFactory
                .update(post)
                .set(post.postCategory, updateCategoryForm.getPostCategory())
                .where(post.id.eq(id))
                .execute();
    }
//    // 상태 수정
//    @Override
//    public void updatePostStatusHJ(Long id, PostRequestDto.UpdateStatusForm updateStatusForm) {
//        queryFactory
//                .update(post)
//                .set(post.status, updateStatusForm.getStatus())
//                .where(post.id.eq(id))
//                .execute();
//    }
}
