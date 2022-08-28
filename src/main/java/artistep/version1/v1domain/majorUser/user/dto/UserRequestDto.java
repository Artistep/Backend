package artistep.version1.v1domain.majorUser.user.dto;

import artistep.version1.v1domain.majorUser.user.Genre;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class UserRequestDto {

    @Builder
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class DetailJoinForm {
        // 회원가입 요청한 구글 이메일
        private String email;
        // 닉네임
        private String nickname;
        // 활동명
        private String workingName;
        // 휴대폰 번호
        private String phoneNumber;
        // 생년월일
        private LocalDate birth;
        // 관심있는 장르 (입력 예시 : 리스너-힙합)
        private Genre genre;
        // 소속
        private String belong;
    }

    @Data
    @NotNull(message = "null 을 입력하면 안됨")
    public static class UpdatePictureForm {
        private String imageLink;
    }

    @Data
    @NotNull
    public static class UpdateBioForm {
        private String bio;
    }

    @Data
    @NotNull
    public static class UpdateWorkingNameForm {
        private String workingName;
    }

    @Data
    @NotNull
    public static class UpdateNicknameForm {
        private String nickName;
    }

    @Data
    @NotNull
    public static class UpdateBelongForm {
        private String belong;
    }

}
