package artistep.version1.v1domain.majorUser.user.controller;

import artistep.version1.v1domain.majorPost.likePost.repository.LikePostRepository;
import artistep.version1.v1domain.majorPost.postFile.repository.PostFileRepository;
import artistep.version1.v1domain.majorUser.follow.repository.FollowRepository;
import artistep.version1.v1domain.majorUser.user.Genre;
import artistep.version1.v1domain.majorUser.user.dto.UserRequestDto;
import artistep.version1.v1domain.majorUser.user.dto.UserResponseDto;
import artistep.version1.v1domain.majorUser.user.repository.UserRepository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;


@SpringBootTest
@Transactional
class UserControllerTest {

    @Autowired
    UserRepository userRepository;

    @Autowired
    FollowRepository followRepository;

    @Autowired
    PostFileRepository postFileRepository;

    @Autowired
    LikePostRepository likePostRepository;

    @Test
    void detailJoinControllerMethodKDH() {
        UserRequestDto.DetailJoinForm detailJoinForm = new UserRequestDto.DetailJoinForm();
        detailJoinForm.setBelong("송");
        detailJoinForm.setBirth(LocalDate.of(1999, 10, 9));
        detailJoinForm.setEmail("peter6081@gmail.com");
        detailJoinForm.setGenre(Genre.리스너RB);
        detailJoinForm.setNickname("diger");
        detailJoinForm.setPhoneNumber("01050616081");

        userRepository.detailUserJoinKDH(detailJoinForm);

        Assertions.assertThat(userRepository.findByEmail("peter6081@gmail.com")).isPresent();

    }

    @Test
    public void myPageMethodKDH() {

        Long userId = 8L;

        UserResponseDto.MyPageResponseForm data = userRepository.loadMyPageKDH(userId);
        data.setFollowerCount(followRepository.NumberOfFollower(userId));
        data.setFollowingCount(followRepository.NumberOfFollowing(userId));
        data.setPostLinkList(postFileRepository.loadLikePostLink(userId));
        data.setLikePostCount(likePostRepository.LikePostCount(userId));

        System.out.println(data);
    }
}