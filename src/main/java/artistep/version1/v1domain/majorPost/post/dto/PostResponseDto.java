package artistep.version1.v1domain.majorPost.post.dto;

import artistep.version1.v1domain.majorPost.post.Post;
import artistep.version1.v1domain.majorPost.postFile.PostFile;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

public class PostResponseDto {
    /**
     * 게시글 DTO
     * 타이틀, 활동명, 업데이트 시간, 좋아요 수, 댓글 수, 조회 수
     */
    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class PostPreviewForm {
        private String title;
        private String workingName;
        private LocalDateTime updatedAt;
        private Integer likeCnt;
        private Integer commentCnt;
        private Integer viewCnt;
    }

    /**
     * 게시글 상세보기 DTO
     * 타이틀, 활동명, 내용. 업데이트 시간, 좋아요 수, 댓글 수, 첨부파일 id
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class DetailPostForm {
        private String title;
        private String workingName;
        private String content;
        private LocalDateTime updatedAt;
        private Integer likeCnt;
        private Integer commentCnt;
        private List<PostFile> postFile;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AllCategoryPostsPreviewForm {
        List<PostPreviewForm> freeTalkingPostList;
        List<PostPreviewForm> informationPostList;
        List<PostPreviewForm> feedbackPostList;
        List<PostPreviewForm> noticePostList;
    }
}
