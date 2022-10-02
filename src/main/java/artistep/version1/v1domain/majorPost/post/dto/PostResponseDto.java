package artistep.version1.v1domain.majorPost.post.dto;

import artistep.version1.v1domain.majorComment.comment.dto.CommentResponseDto.*;
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
    @Data @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class PostPreviewRespondForm {
        private String title;
        private String nickName;
        private LocalDateTime updatedAt;
        private Long likeCount;
        private Long commentCount;
        private Long viewCount;
    }

    /**
     * 게시글 상세보기 DTO
     * 타이틀, 활동명, 내용. 업데이트 시간, 좋아요 수, 댓글 수, 첨부파일 id
     */
    @Data @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PostRespondForm {
        private String title;
        private String nickName;
        private String content;
        private Long likeCount;
        private List<commentForm> commentList;
        private List<String> postFileList;
        private LocalDateTime updatedAt;
    }
}
