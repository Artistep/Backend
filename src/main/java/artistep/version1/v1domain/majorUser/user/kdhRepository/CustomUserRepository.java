package artistep.version1.v1domain.majorUser.user.kdhRepository;

import artistep.version1.v1domain.majorUser.user.kdhDto.UserRequestDto;
import artistep.version1.v1domain.majorUser.user.kdhDto.UserResponseDto;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface CustomUserRepository {

    void detailUserJoin(UserRequestDto.DetailJoinForm detailJoinForm);

    UserResponseDto.MyPageResponseForm loadMyPage();
}
