package artistep.version1.domain.majorUser;

import artistep.version1.domain.majorPost.post.Post;
import artistep.version1.domain.majorPost.postFile.PostFile;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.HashMap;
import java.util.List;


@Builder
@Data
@AllArgsConstructor

/**
 유저 Controller 요청에 관한 응답 DTO 입니다.
 */
public class UserResponseDto {

    /**
     * 마이페이지의 유저 정보를 반환하기 위한 DTO 입니다.
     * 반환 값 : 로그인아이디, 활동명, 유저 태그, 팔로워 수, 팔로잉 수, 좋아요 수, 게시글 리스트
     */
    public static class MyPageUserInfoResponse {
        private String loginId; // 유저 로그인아이디
        private String nickname; // 유저 활동명
        private String tag; // 유저 태그
        private Integer followerCount; // 팔로워 수
        private Integer followingCount;  // 팔로잉 수
        private Integer likePostCount; // 좋아요 수

        private List<HashMap<Post, PostFile>> postList; // 리스트<유저가 작성한 게시글, 작성한 게시글에 대한 파일>

    }
    
}
