//package artistep.version1.v1domain.majorPost.post.repository;
//
//import artistep.version1.v1domain.majorPost.post.PostCategory;
//import artistep.version1.v1domain.majorPost.post.QPost;
//import artistep.version1.v1domain.majorPost.post.dto.PostResponseDto.AllCategoryPostsPreviewForm;
//import com.querydsl.jpa.impl.JPAQueryFactory;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Repository;
//
//import java.awt.print.Pageable;
//
//import static artistep.version1.v1domain.majorPost.post.QPost.post;
//
//
//@Repository
//@RequiredArgsConstructor
//public class CustomPostRepositoryImpl implements CustomPostRepository {
//
//    private final JPAQueryFactory queryFactory;
//
//    @Override
//    public AllCategoryPostsPreviewForm loadAllPostPreview(Pageable pageable) {
//
//        AllCategoryPostsPreviewForm result = new AllCategoryPostsPreviewForm();
//
//        result.setFreeTalkingPostList(
//                queryFactory
//                        .select(post.title, post.updatedAt, post.user)
//                        .from(post)
//                        .where(post.postCategory.eq(PostCategory.valueOf("FreeTalking")))
//                        .fetchResults();
//    }
//}
