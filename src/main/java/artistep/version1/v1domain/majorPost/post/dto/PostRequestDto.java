package artistep.version1.v1domain.majorPost.post.dto;

import artistep.version1.v1domain.majorPost.post.PostCategory;
import artistep.version1.v1domain.majorUser.user.Genre;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

public class PostRequestDto {
    @Data @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class PostRequestForm {
        private String title;
        private String content;
        private PostCategory postCategory;
        private Genre genre;
        private List<String> postFile;
    }
}
