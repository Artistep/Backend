package artistep.version1.v1domain.majorUser.user.controller;

import artistep.version1.global.jwt.JwtUtilizer;
import artistep.version1.v1domain.majorPost.likePost.repository.LikePostRepository;
import artistep.version1.v1domain.majorPost.postFile.repository.PostFileRepository;
import artistep.version1.v1domain.majorUser.follow.repository.FollowRepository;
import artistep.version1.v1domain.majorUser.user.dto.UserRequestDto.*;
import artistep.version1.v1domain.majorUser.user.dto.UserResponseDto.*;
import artistep.version1.v1domain.majorUser.user.repository.UserRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;

@RestController
@RequiredArgsConstructor
@Api("유저 컨트롤러")
@RequestMapping("/user")
public class UserController {

    private final UserRepository userRepository;
    private final FollowRepository followRepository;
    private final PostFileRepository postFileRepository;
    private final LikePostRepository likePostRepository;
    private final JwtUtilizer jwtUtilizer;

    @ApiOperation(value = "", notes = "OAuth 후 세부 정보를 받기 위한 컨트롤러")
    @PostMapping("/detail-join")
    public ResponseEntity<?> detailJoinKDH(@Valid @RequestBody DetailJoinForm detailJoinForm) {

        userRepository.detailUserJoinKDH(detailJoinForm);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @ApiOperation(value = "", notes = "OAuth 후 로그인 및 토큰 발급을 위한 컨트롤러")
    @GetMapping("/login")
    public ResponseEntity<?> loginKDH(@Param("AccessToken") String AccessToken, @Param("RefreshToken") String RefreshToken) {

        HashMap<String, String> data = new HashMap<>();

        data.put("AccessToken", AccessToken);
        data.put("RefreshToken", RefreshToken);

        return ResponseEntity.status(HttpStatus.OK).body(data);
    }

    @ApiOperation(value = "", notes = "내 정보 페이지 불러오기")
    @GetMapping("/my-page")
    public ResponseEntity<MyPageResponseForm> loadMyPageKDH(@Valid @RequestHeader String Authorization) {

        long userId = jwtUtilizer.jwtResolveToUserId(Authorization.substring("Bearer ".length()));

        MyPageResponseForm data = userRepository.loadMyPageKDH(userId);
        data.setFollowerCount(followRepository.NumberOfFollower(userId));
        data.setFollowingCount(followRepository.NumberOfFollowing(userId));
        data.setPostLinkList(postFileRepository.loadLikePostLink(userId));
        data.setLikePostCount(likePostRepository.LikePostCount(userId));

        return ResponseEntity.status(HttpStatus.OK).body(data);
    }

    @ApiOperation(value = "", notes = "프로필 사진 올리기/수정하기")
    @PostMapping("/edit/profile-picture")
    public ResponseEntity<HashMap<String, Boolean>> updateProfilePictureKDH(
            @Valid @RequestHeader String Authorization, @Validated @RequestBody UpdatePictureForm updatePictureForm) {

        HashMap<String, Boolean> data = new HashMap<>();

        long userId = jwtUtilizer.jwtResolveToUserId(Authorization.substring("Bearer ".length()));

        userRepository.updateUserPictureKDH(userId, updatePictureForm);

        data.put("success", true);

        return ResponseEntity.status(HttpStatus.OK).body(data);
    }

    @ApiOperation(value = "", notes = "자기소개 올리기/수정하기")
    @PostMapping("/edit/profile-bio")
    public ResponseEntity<HashMap<String, Boolean>> updateProfileBioKDH(
            @Valid @RequestHeader String Authorization, @Valid @RequestBody UpdateBioForm updateBioForm) {

        HashMap<String, Boolean> data = new HashMap<>();

        long userId = jwtUtilizer.jwtResolveToUserId(Authorization.substring("Bearer ".length()));

        userRepository.updateUserBioKDH(userId, updateBioForm);

        data.put("success", true);

        return ResponseEntity.status(HttpStatus.OK).body(data);
    }
    @ApiOperation(value = "", notes = "활동명 올리기/수정하기")
    @PostMapping("/edit/profile-workingName")
    public ResponseEntity<HashMap<String, Boolean>> updateProfileWorkingNameKDH(
            @Valid @RequestHeader String Authorization, @Valid @RequestBody UpdateWorkingNameForm updateWorkingNameForm) {

        HashMap<String, Boolean> data = new HashMap<>();

        long userId = jwtUtilizer.jwtResolveToUserId(Authorization.substring("Bearer ".length()));

        userRepository.updateUserWorkingNameKDH(userId, updateWorkingNameForm);

        data.put("success", true);

        return ResponseEntity.status(HttpStatus.OK).body(data);
    }

    @ApiOperation(value = "", notes = "닉네임 올리기/수정하기")
    @PostMapping("/edit/profile-nickName")
    public ResponseEntity<HashMap<String, Boolean>> updateProfileNickNameKDH(
            @Valid @RequestHeader String Authorization, @Valid @RequestBody UpdateNicknameForm nicknameForm) {

        HashMap<String, Boolean> data = new HashMap<>();

        long userId = jwtUtilizer.jwtResolveToUserId(Authorization.substring("Bearer ".length()));

        userRepository.updateUserNicknameKDH(userId, nicknameForm);

        data.put("success", true);

        return ResponseEntity.status(HttpStatus.OK).body(data);
    }

    @ApiOperation(value = "", notes = "소속 올리기/수정하기")
    @PostMapping("/edit/profile-belong")
    public ResponseEntity<HashMap<String, Boolean>> updateProfileBelongKDH(
            @Valid @RequestHeader String Authorization, @Valid @RequestBody UpdateBelongForm belongForm) {

        HashMap<String, Boolean> data = new HashMap<>();

        long userId = jwtUtilizer.jwtResolveToUserId(Authorization.substring("Bearer ".length()));

        userRepository.updateUserBelongKDH(userId, belongForm);

        data.put("success", true);

        return ResponseEntity.status(HttpStatus.OK).body(data);
    }

}

