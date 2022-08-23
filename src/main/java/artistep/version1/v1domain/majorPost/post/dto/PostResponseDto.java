package artistep.version1.v1domain.majorPost.post.dto;

import artistep.version1.v1domain.majorPost.post.Post;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

public class PostResponseDto {

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AllCategoryPostsPreviewForm {
        List<Post> freeTalkingPostList;
        List<Post> informationPostList;
        List<Post> feedbackPostList;
        List<Post> noticePostList;
    }
}
