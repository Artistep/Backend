package artistep.version1.domain.majorUser;


import artistep.version1.domain.majorUser.UserResponseDto.MyPageUserInfoResponse;
import artistep.version1.domain.majorUser.userInfo.UserInfoRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@Api("MyPage")
@RequestMapping("/user")
@RequiredArgsConstructor
public class MajorUserController {

    private final UserInfoRepository userInfoRepository;


    @ApiOperation(value = "마이페이지", notes = "반환 값 : 로그인아이디, 활동명, 유저 태그, 팔로워 수, 팔로잉 수, 좋아요 수")
    @GetMapping
    public ResponseEntity<?> getMyPage(@Valid @RequestHeader String Authorization) {

        MyPageUserInfoResponse responseUserInfo = new MyPageUserInfoResponse();

        return new ResponseEntity<>((HttpStatus.OK));
    }
}
