package artistep.version1.v1domain.majorPost.post.dto;

import artistep.version1.v1domain.majorPost.post.Post;
import artistep.version1.v1domain.majorUser.user.Genre;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class PostRequestDto {
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
        private String category;
    }

    @Data
    @NotNull
    public static class UpdateUpdatedForm {
        private LocalDateTime Updated;
    }

    @Data
    @NotNull
    public static class UpdateStatusForm {
        private String status;
    }
}
