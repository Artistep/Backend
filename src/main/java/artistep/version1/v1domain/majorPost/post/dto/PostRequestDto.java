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
    public static class PageRequestForm {
        private int page;
        private int size;

        public PageRequestForm() {
            this.page = 1;
            this.size = 10;
        }
    }

    // 추가할 것 : 파일 수정
}
