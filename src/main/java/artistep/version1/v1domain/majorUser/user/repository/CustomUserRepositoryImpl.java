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

    // 추가 회원가입 - 부가 회원정보 입력 
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
     * @return :
     * 닉네임, 자기소개, 프로필 사진 링크, 사용자 이름, 뱃지, 팔로워 수, 팔로잉 수,
     * 좋아요 게시글 수, List<게시글 링크>, List<추천 유저>
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

    // 프로필사진 업로드/수정
    @Override
    public void updateUserPictureKDH(Long id, UpdatePictureForm updatePictureForm) {
        queryFactory
                .update(user)
                .set(user.picture, updatePictureForm.getImageLink())
                .where(user.id.eq(id))
                .execute();
    }

    // 자기소개 업로드/수정
    @Override
    public void updateUserBioKDH(Long id, UpdateBioForm updateBioForm) {
        queryFactory
                .update(user)
                .set(user.bio, updateBioForm.getBio())
                .where(user.id.eq(id))
                .execute();
    }

    // 닉네임 업로드/수정 (중복허용)
    @Override
    public void updateUserNicknameKDH(Long id, UpdateNicknameForm updateNicknameForm) {
        queryFactory
                .update(user)
                .set(user.nickname, updateNicknameForm.getNickName())
                .where(user.id.eq(id))
                .execute();
    }

    // 활동명 업로드/수정
    @Override
    public void updateUserWorkingNameKDH(Long id, UpdateWorkingNameForm updateWorkingNameForm) {
        // 이미 동일한 활동명이 존재하는 경우에는 예외처리
        if (queryFactory
                .selectFrom(user)
                .where(user.workingName.eq(updateWorkingNameForm.getWorkingName()))
                .fetch().size() > 0)
        {
            throw new CustomException(ErrorCode.OVERLAP_WORKING_NAME);
        }

        // 동일한 활동명이 존재하지 않는 경우에는 DB에 반영
        queryFactory
                .update(user)
                .set(user.workingName, updateWorkingNameForm.getWorkingName())
                .where(user.id.eq(id))
                .execute();
    }

    // 소속 업로드/수정
    @Override
    public void updateUserBelongKDH(Long id, UpdateBelongForm belongForm) {
        queryFactory
                .update(user)
                .set(user.nickname, belongForm.getBelong())
                .where(user.id.eq(id))
                .execute();
    }
}
