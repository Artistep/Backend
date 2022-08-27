package artistep.version1.v1domain.majorUser.user.repository;

import artistep.version1.v1domain.majorUser.user.dto.UserResponseDto.MyPageResponseForm;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import static artistep.version1.v1domain.majorUser.user.dto.UserRequestDto.*;

@Repository
@Transactional
public interface CustomUserRepository {

    void detailUserJoinKDH(DetailJoinForm detailJoinForm);

    MyPageResponseForm loadMyPageKDH(Long id);

    void updateUserPictureKDH(Long id, UpdatePictureForm updatePictureForm);

    void updateUserBioKDH(Long id, UpdateBioForm updateBioForm);

    // 중복허용
    void updateUserNicknameKDH(Long id, UpdateNicknameForm updateNicknameForm);

    // 활동명은 중복 불가
    void updateUserWorkingNameKDH(Long id, UpdateWorkingNameForm updateWorkingNameForm);
}
