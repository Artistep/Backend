package artistep.version1.v1domain.majorComment.comment.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

public class CommentResponseDto {
    /**
     * 임시 댓글 dto
     * 굳이 필요할지 고민하기
     */
    @Builder @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class commentForm {
        private String nickName;
        private String content;
        private LocalDateTime updatedAt;
    }
}
