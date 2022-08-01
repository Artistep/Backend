package artistep.version1.v1domain.majorUser.user.kdhController;

import artistep.version1.v1domain.majorUser.user.kdhDto.UserRequestDto.DetailJoinForm;
import artistep.version1.v1domain.majorUser.user.kdhRepository.UserRepository;
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

    @ApiOperation(value = "", notes = "OAuth 후 세부 정보를 받기 위한 컨트롤러")
    @PostMapping("/detail-join")
    public ResponseEntity<?> detailJoinControllerMethod(@Valid @RequestBody DetailJoinForm detailJoinForm) {

        userRepository.detailUserJoin(detailJoinForm);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}

