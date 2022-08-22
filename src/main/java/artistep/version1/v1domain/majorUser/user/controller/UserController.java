package artistep.version1.v1domain.majorUser.user.controller;

import artistep.version1.global.jwt.JwtUtillizer;
import artistep.version1.v1domain.majorPost.likePost.repository.LikePostRepository;
import artistep.version1.v1domain.majorPost.postFile.repository.PostFileRepository;
import artistep.version1.v1domain.majorUser.follow.repository.FollowRepository;
import artistep.version1.v1domain.majorUser.user.dto.UserRequestDto.DetailJoinForm;
import artistep.version1.v1domain.majorUser.user.dto.UserResponseDto;
import artistep.version1.v1domain.majorUser.user.dto.UserResponseDto.MyPageResponseForm;
import artistep.version1.v1domain.majorUser.user.repository.UserRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@Api("유저 컨트롤러")
@RequestMapping("/user")
public class UserController {

    private final UserRepository userRepository;
    private final FollowRepository followRepository;
    private final PostFileRepository postFileRepository;
    private final LikePostRepository likePostRepository;
    private final JwtUtillizer jwtUtillizer;

    @ApiOperation(value = "", notes = "OAuth 후 세부 정보를 받기 위한 컨트롤러")
    @PostMapping("/detail-join")
    public ResponseEntity<?> detailJoinControllerMethodKDH(@Valid @RequestBody DetailJoinForm detailJoinForm) {

        userRepository.detailUserJoin(detailJoinForm);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @ApiOperation(value = "", notes = "내 정보 페이지 불러오기")
    @GetMapping("/my-page")
    public ResponseEntity<MyPageResponseForm> myPageMethodKDH(@Valid @RequestHeader String jwt) {

        long userId = jwtUtillizer.jwtResolveToUserId(jwt);

        MyPageResponseForm data = userRepository.loadMyPage(userId);
        data.setFollowerCount(followRepository.NumberOfFollower(userId));
        data.setFollowingCount(followRepository.NumberOfFollowing(userId));
        data.setPostLinkList(postFileRepository.loadLikePostLink(userId));
        data.setLikePostCount(likePostRepository.LikePostCount(userId));

        return ResponseEntity.status(HttpStatus.OK).body(data);
    }
}

