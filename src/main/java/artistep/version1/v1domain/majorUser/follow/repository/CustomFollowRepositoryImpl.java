package artistep.version1.v1domain.majorUser.follow.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import static artistep.version1.v1domain.majorUser.follow.QFollow.follow;

@Repository
@RequiredArgsConstructor
public class CustomFollowRepositoryImpl implements CustomFollowRepository{

    private final JPAQueryFactory queryFactory;

    @Override
    public int NumberOfFollower(Long id) {
        return Integer.parseInt(String.valueOf(queryFactory
                .select(follow.count())
                .from(follow)
                .where(follow.followedUserId.id.eq(id))
                .fetchOne()));
    }


    @Override
    public int NumberOfFollowing(Long id) {
        return Integer.parseInt(String.valueOf(queryFactory
                .select(follow.followingUserId.count())
                .from(follow)
                .where(follow.followingUserId.id.eq(id))
                .fetchOne()));
    }
}
