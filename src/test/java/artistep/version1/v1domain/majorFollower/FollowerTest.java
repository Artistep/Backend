package artistep.version1.v1domain.majorFollower;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static artistep.version1.v1domain.majorUser.follow.QFollow.follow;

@SpringBootTest()
@Transactional
public class FollowerTest {

    @Autowired
    JPAQueryFactory queryFactory;


    // 팔로워 수
    @Test
    @DisplayName(value = "팔로워 수")
    public void NumberOfFollower() {
        Long id = 1L;

        int result = Integer.parseInt(String.valueOf(queryFactory
                .select(follow.followedUserId.count())
                .from(follow)
                .where(follow.followedUserId.id.eq(id))
                .fetchOne()));

        System.out.println(result);
    }

    // 팔로잉 수
    @Test
    @DisplayName(value = "팔로잉 수")
    public void NumberOfFollowing() {
        Long id = 1L;

        int result = Integer.parseInt(String.valueOf(queryFactory
                .select(follow.followingUserId.count())
                .from(follow)
                .where(follow.followingUserId.id.eq(id))
                .fetchOne()));

        System.out.println(result);
    }
}
