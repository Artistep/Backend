package artistep.version1.v1domain.majorUser.user.repository;

import artistep.version1.v1domain.majorUser.user.User;
import artistep.version1.v1domain.majorUser.user.dto.UserRequestDto.DetailJoinForm;
import artistep.version1.v1domain.majorUser.user.dto.UserResponseDto.MyPageResponseForm;
import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;


import java.util.List;

import static artistep.version1.v1domain.majorUser.user.QUser.user;

@Repository
@RequiredArgsConstructor
public class CustomUserRepositoryImpl implements CustomUserRepository {

    private final JPAQueryFactory queryFactory;

    @Override
    public void detailUserJoin(DetailJoinForm detailJoinForm) {

        queryFactory
                .update(user)
                .set(user.nickname, detailJoinForm.getNickname())
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
    public MyPageResponseForm loadMyPage(Long id) {

        MyPageResponseForm data = new MyPageResponseForm();

        Tuple result = queryFactory
                .select(user.nickname, user.bio, user.picture, user.username)
                .from(user)
                .where(user.id.eq(id))
                .fetchOne();

        data.setNickname(result.get(user.nickname));
        data.setBio(result.get(user.bio));
        data.setPicture(result.get(user.picture));
        data.setUsername(result.get(user.username));

        return data;
    }
}
