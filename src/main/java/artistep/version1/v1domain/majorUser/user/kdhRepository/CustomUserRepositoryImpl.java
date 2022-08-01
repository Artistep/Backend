package artistep.version1.v1domain.majorUser.user.kdhRepository;

import artistep.version1.v1domain.majorUser.user.kdhDto.UserRequestDto.DetailJoinForm;
import artistep.version1.v1domain.majorUser.user.kdhDto.UserResponseDto;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;


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
                .set(user.genre, detailJoinForm.getGenre().getGenre())
                .where(user.email.eq(detailJoinForm.getEmail()))
                .execute();
    }

    @Override
    public UserResponseDto.MyPageResponseForm loadMyPage() {
        return null;
    }
}
