package artistep.version1.v1domain.majorUser.user.repository;

import artistep.version1.global.exception.CustomException;
import artistep.version1.global.exception.ErrorCode;
import artistep.version1.v1domain.majorUser.user.User;
import artistep.version1.v1domain.majorUser.user.dto.UserRequestDto.*;
import artistep.version1.v1domain.majorUser.user.dto.UserResponseDto.MyPageResponseForm;
import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;


import javax.lang.model.type.ErrorType;
import java.util.List;

import static artistep.version1.v1domain.majorUser.user.QUser.user;

@Repository
@RequiredArgsConstructor
public class CustomUserRepositoryImpl implements CustomUserRepository {

    private final JPAQueryFactory queryFactory;

    @Override
    public void detailUserJoinKDH(DetailJoinForm detailJoinForm) {

        queryFactory
                .update(user)
                .set(user.nickname, detailJoinForm.getNickname())
                .set(user.workingName, detailJoinForm.getWorkingName())
                .set(user.phoneNumber, detailJoinForm.getPhoneNumber())
                .set(user.birth, detailJoinForm.getBirth())
                .set(user.genre, detailJoinForm.getGenre())
                .set(user.belong, detailJoinForm.getBelong())
                .where(user.email.eq(detailJoinForm.getEmail()))
                .execute();
    }

    /**
     *
     * @param id
     * @return : 닉네임, 자기소개, 프로필 사진 링크, 사용자 이름, 뱃지, 팔로워 수, 팔로잉 수, 좋아요 게시글 수, List<게시글 링크>, List<추천 유저>
     *
     */

    @Override
    public MyPageResponseForm loadMyPageKDH(Long id) {

        MyPageResponseForm data = new MyPageResponseForm();

        Tuple result = queryFactory
                .select(user.nickname, user.bio, user.picture, user.workingName)
                .from(user)
                .where(user.id.eq(id))
                .fetchOne();

        data.setNickname(result.get(user.nickname));
        data.setBio(result.get(user.bio));
        data.setPicture(result.get(user.picture));
        data.setUsername(result.get(user.workingName));

        return data;
    }

    @Override
    public void updateUserPictureKDH(Long id, UpdatePictureForm updatePictureForm) {
        queryFactory
                .update(user)
                .set(user.picture, updatePictureForm.getImageLink())
                .where(user.id.eq(id))
                .execute();
    }

    @Override
    public void updateUserBioKDH(Long id, UpdateBioForm updateBioForm) {
        queryFactory
                .update(user)
                .set(user.bio, updateBioForm.getBio())
                .where(user.id.eq(id))
                .execute();
    }

    // 중복허용
    @Override
    public void updateUserNicknameKDH(Long id, UpdateNicknameForm updateNicknameForm) {
        queryFactory
                .update(user)
                .set(user.nickname, updateNicknameForm.getNickName())
                .where(user.id.eq(id))
                .execute();
    }

    // 활동명은 중복 불가
    @Override
    public void updateUserWorkingNameKDH(Long id, UpdateWorkingNameForm updateWorkingNameForm) {
        List<User> searchWorkingName = queryFactory
                .selectFrom(user)
                .where(user.workingName.eq(updateWorkingNameForm.getWorkingName()))
                .fetch();

        if (searchWorkingName.size() > 0) {
            throw new CustomException(ErrorCode.OVERLAP_EMAIL);
        }

        queryFactory
                .update(user)
                .set(user.workingName, updateWorkingNameForm.getWorkingName())
                .where(user.id.eq(id))
                .execute();
    }
}
