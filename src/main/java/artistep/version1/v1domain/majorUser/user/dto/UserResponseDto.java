package artistep.version1.v1domain.majorUser.user.dto;

import artistep.version1.v1domain.majorUser.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

public class UserResponseDto {

    @Data @Builder
    @NoArgsConstructor @AllArgsConstructor
    public static class UserPreviewForm {

        // 활동명
        private String nickname;

        // 유저 이름
        private String username;

        // 프사
        private String picture;

    }

    /**
    마이페이지 반환 DTO
     로그인아이디, 활동명, 상태메세지, 프로필사진 링크, 뱃지 리스트
     팔로워 수, 팔로잉 수, 좋아요 한 게시글 수
     게시글 링크 리스트
     추천 유저 리스트
     */
    @Data @Builder
    @NoArgsConstructor @AllArgsConstructor
    public static class MyPageResponseForm {

        private String nickname;

        private String bio;

        private String picture;

        private String username;

        private Integer followerCount;

        private Integer followingCount;

        private Integer likePostCount;

        private List<String> postLinkList;

        private List<User> recommendUserList;
    }

}
