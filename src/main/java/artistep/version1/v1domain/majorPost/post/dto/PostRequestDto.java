package artistep.version1.v1domain.majorPost.post.dto;

import artistep.version1.v1domain.majorPost.post.Post;
import artistep.version1.v1domain.majorPost.post.PostCategory;
import artistep.version1.v1domain.majorPost.postFile.PostFile;
import artistep.version1.v1domain.majorUser.user.Genre;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class PostRequestDto {
    @Builder
    @AllArgsConstructor
    @Data
    public static class PageForm {
        private int page;
        private int size;

        public PageForm() {
            this.page = 1;
            this.size = 10;
        }
    }

    @Data
    @NotNull
    public static class UpdateTitleForm {
        private String title;
    }

    @Data
    @NotNull
    public static class UpdateContentForm {
        private String content;
    }

    @Data
    @NotNull
    public static class UpdateCategoryForm {
        private PostCategory postCategory;
    }

    @Data
    @NotNull
    public static class UpdateStatusForm {
        private String status;
    }

    // 추가할 것 : 파일 수정
}
