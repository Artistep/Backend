package artistep.version1.v1domain.majorUser.user.service;

import artistep.version1.v1domain.majorUser.user.Status;
import artistep.version1.v1domain.majorUser.user.User;
import artistep.version1.v1domain.majorUser.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void createInitUserKDH(String email) {
        User user = User.builder()
                .email(email)
                .status(Status.USER)
                .build();
        userRepository.save(user);
    }
}
