package artistep.version1.v1domain.majorUser.user.repository;

import artistep.version1.v1domain.majorUser.user.dto.UserRequestDto;
import artistep.version1.v1domain.majorUser.user.dto.UserResponseDto.MyPageResponseForm;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface CustomUserRepository {

    void detailUserJoin(UserRequestDto.DetailJoinForm detailJoinForm);

    MyPageResponseForm loadMyPage(Long id);
}
