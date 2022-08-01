package artistep.version1.v1domain.majorPost.post;

import lombok.*;

@Getter
@RequiredArgsConstructor
public enum PostCategory {

    Feed("Feed", "피드 게시글"),
    FreeTalking("FreeTalking", "자유 게시판"),
    Information("Information", "정보 게시판"),
    FeedBack("FeedBack", "피드백 게시판");

    private final String postType;
    private final String value;
}
